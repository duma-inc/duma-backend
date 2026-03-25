package io.github.mattheusffalbuquerque.duma.domains.meeting;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.mattheusffalbuquerque.duma.domains.meeting.dto.MeetingResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MeetingService {

    private final MeetingRepository meetingRepository;
    private final MeetingMapper meetingMapper;

    public List<MeetingResponse> getAllMeetings() {
        List<Meeting> meetings = meetingRepository.findAll();
        return meetingMapper.toResponseList(meetings);
    }

    public List<MeetingResponse> getMeetingByTeacherId(String teacherId) {
        List<Meeting> meetings = meetingRepository.findAllByTeacherId(teacherId);
        return meetingMapper.toResponseList(meetings);
    }

    public List<MeetingResponse> getMeetingBySkillId(String skillId) {
        List<Meeting> meetings = meetingRepository.findAllBySkillId(skillId);
        return meetingMapper.toResponseList(meetings);
    }

    public List<MeetingResponse> getMeetingByStageId(String stageId) {
        List<Meeting> meetings = meetingRepository.findAllByStageId(stageId);
        return meetingMapper.toResponseList(meetings);
    }

    public MeetingResponse getMeetingById(String id) {
        Meeting meeting = meetingRepository.findById(id).orElse(null);
        return meetingMapper.toResponse(meeting);
    }

    public MeetingResponse createMeeting(Meeting meeting) {
        Meeting savedMeeting = meetingRepository.save(meeting);
        return meetingMapper.toResponse(savedMeeting);
    }


    public MeetingResponse updateMeeting(Meeting meeting) {
        Meeting updatedMeeting = meetingRepository.save(meeting);
        return meetingMapper.toResponse(updatedMeeting);
    }

    public Integer countMeetingsByTeacherId(String teacherId) {
        return meetingRepository.countByTeacherId(teacherId);
    }

    public Integer countMeetingsBySkillId(String skillId) {
        return meetingRepository.countBySkillId(skillId);
    }

    public Integer countMeetingsByStageId(String stageId) {
        return meetingRepository.countByStageId(stageId);
    }

    public void deleteMeeting(String id) {
        meetingRepository.deleteById(id);
    }
    
}
