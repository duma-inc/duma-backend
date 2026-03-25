package io.github.mattheusffalbuquerque.duma.domains.meeting.dto;

import java.time.LocalDateTime;

public record UpdateMeetingRequest(
    String title, 
    String description, 
    String teacherId, 
    String meetingUrl,
    LocalDateTime scheduledStart,
    String recordingUrl
) {} 
