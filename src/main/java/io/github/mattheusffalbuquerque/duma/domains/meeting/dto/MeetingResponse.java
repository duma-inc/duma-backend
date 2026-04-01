package io.github.mattheusffalbuquerque.duma.domains.meeting.dto;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "MeetingResponse", description = "Response containing meeting details")
public record MeetingResponse(
    
    @Schema(description = "The title", example = "Java Basics")
    String title, 
    @Schema(description = "The description", example = "Detailed description of the item")
    String description, 
    @Schema(description = "The identifier of the teacher", example = "teacher-123")
    String teacherId, 
    @Schema(description = "The meeting URL", example = "https://example.com/meeting")
    String meetingUrl,
    @Schema(description = "The scheduled start date and time", example = "2024-01-01T10:00:00")
    LocalDate scheduledStart,
    @Schema(description = "The recording URL", example = "https://example.com/recording")
    String recordingUrl

) {} 
