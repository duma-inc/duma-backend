package io.github.mattheusffalbuquerque.duma.domains.meeting;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import io.github.mattheusffalbuquerque.duma.domains.meeting.dto.CreateMeetingRequest;
import io.github.mattheusffalbuquerque.duma.domains.meeting.dto.MeetingResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/meetings")
@RequiredArgsConstructor
@Tag(name = "Meeting", description = "Endpoints for managing meetings")
public class MeetingController {

    private final MeetingService meetingService;
    private final MeetingMapper meetingMapper;

    @GetMapping
    @Operation(summary = "Get all meetings", description = "Returns a list of all meetings in the system")
    public List<MeetingResponse> getAllMeetings() {
        return meetingService.getAllMeetings();
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get meeting by ID", description = "Returns a single meeting by its unique ID")
    public MeetingResponse getMeetingById(@PathVariable String id) {
        return meetingService.getMeetingById(id);
    }

    @GetMapping("/teacherId")
    @Operation(summary = "Get meetings by teacher ID", description = "Returns a list of meetings associated with a specific teacher")
    public List<MeetingResponse> getAllByTeacherId(@RequestParam String id) {
        return meetingService.getMeetingByTeacherId(id);
    }

    @GetMapping("/skillId")
    @Operation(summary = "Get meetings by skill ID", description = "Returns a list of meetings associated with a specific skill")
    public List<MeetingResponse> getAllBySkillId(@RequestParam String id) {
        return meetingService.getMeetingBySkillId(id);
    }
    
    @PostMapping
    @Operation(summary = "Create a new meeting", description = "Creates a new meeting in the system")
    public MeetingResponse createMeeting(@RequestBody CreateMeetingRequest request) {
        Meeting meeting = meetingMapper.toEntity(request);
        return meetingService.createMeeting(meeting);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update meeting information", description = "Updates the information of an existing meeting identified by its unique ID")
    public MeetingResponse updateMeeting(@PathVariable String id, @RequestBody CreateMeetingRequest request) {
        Meeting meeting = meetingMapper.toEntity(request);
        meeting.setId(id);
        return meetingService.updateMeeting(meeting);
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a meeting", description = "Deletes an existing meeting from the system identified by its unique ID")
    public void deleteMeeting(@PathVariable String id) {
        meetingService.deleteMeeting(id);
    }
    
}
