package io.github.mattheusffalbuquerque.duma.domains.meeting.dto;
import java.time.LocalDateTime;

public record CreateMeetingRequest(
    String title, 
    String description, 
    String teacherId, 
    LocalDateTime scheduledStart, 
    String meetingUrl
) {}
