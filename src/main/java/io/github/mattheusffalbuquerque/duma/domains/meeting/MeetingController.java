package io.github.mattheusffalbuquerque.duma.domains.meeting;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import io.github.mattheusffalbuquerque.duma.domains.meeting.dto.CreateMeetingRequest;
import io.github.mattheusffalbuquerque.duma.domains.meeting.dto.MeetingResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/meetings")
@RequiredArgsConstructor
public class MeetingController {

    private final MeetingService meetingService;
    private final MeetingMapper meetingMapper;

    @GetMapping
    public List<MeetingResponse> getAllMeetings() {
        return meetingService.getAllMeetings();
    }
    
    @GetMapping("/{id}")
    public MeetingResponse getMeetingById(@PathVariable String id) {
        return meetingService.getMeetingById(id);
    }

    @GetMapping("/teacherId")
    public List<MeetingResponse> getAllByTeacherId(@RequestParam String id) {
        return meetingService.getMeetingByTeacherId(id);
    }

    @GetMapping("/skillId")
    public List<MeetingResponse> getAllBySkillId(@RequestParam String id) {
        return meetingService.getMeetingBySkillId(id);
    }
    
    @PostMapping
    public MeetingResponse createMeeting(@RequestBody CreateMeetingRequest request) {
        Meeting meeting = meetingMapper.toEntity(request);
        return meetingService.createMeeting(meeting);
    }

    @PutMapping("/{id}")
    public MeetingResponse updateMeeting(@PathVariable String id, @RequestBody CreateMeetingRequest request) {
        Meeting meeting = meetingMapper.toEntity(request);
        meeting.setId(id);
        return meetingService.updateMeeting(meeting);
    }
    
    @DeleteMapping("/{id}")
    public void deleteMethodName(@PathVariable String id) {
        meetingService.deleteMeeting(id);
    }
    
}
