package io.github.mattheusffalbuquerque.duma.domains.meeting.dto;

import java.time.LocalDate;

public record MeetingResponse(
    
    String title, 
    String description, 
    String teacherId, 
    String meetingUrl,
    LocalDate scheduledStart,
    String recordingUrl

) {} 
