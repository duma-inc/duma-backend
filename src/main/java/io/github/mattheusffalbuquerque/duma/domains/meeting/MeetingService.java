package io.github.mattheusffalbuquerque.duma.domains.meeting;

import java.util.List;
import java.util.UUID;

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

    public List<MeetingResponse> getMeetingByTeacherId(UUID teacherId) {
        List<Meeting> meetings = meetingRepository.findAllByTeacherId(teacherId);
        return meetingMapper.toResponseList(meetings);
    }

    public List<MeetingResponse> getMeetingBySkillId(Long skillId) {
        List<Meeting> meetings = meetingRepository.findAllBySkillId(skillId);
        return meetingMapper.toResponseList(meetings);
    }

    public List<MeetingResponse> getMeetingByStageId(Long stageId) {
        List<Meeting> meetings = meetingRepository.findAllByStageId(stageId);
        return meetingMapper.toResponseList(meetings);
    }

    public MeetingResponse getMeetingById(UUID id) {
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

    public Integer countMeetingsByTeacherId(UUID teacherId) {
        return meetingRepository.countByTeacherId(teacherId);
    }

    public Integer countMeetingsBySkillId(Long skillId) {
        return meetingRepository.countBySkillId(skillId);
    }

    public Integer countMeetingsByStageId(Long stageId) {
        return meetingRepository.countByStageId(stageId);
    }

    public void deleteMeeting(UUID id) {
        meetingRepository.deleteById(id);
    }
    
}
