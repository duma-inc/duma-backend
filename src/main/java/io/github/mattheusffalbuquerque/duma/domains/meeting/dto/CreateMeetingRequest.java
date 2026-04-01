package io.github.mattheusffalbuquerque.duma.domains.meeting.dto;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "CreateMeetingRequest", description = "Request to create a new Meeting")
public record CreateMeetingRequest(
    @Schema(description = "The title", example = "Java Basics")
    String title, 
    @Schema(description = "The description", example = "Detailed description of the item")
    String description, 
    @Schema(description = "The identifier of the teacher", example = "teacher-123")
    String teacherId, 
    @Schema(description = "The scheduled start date and time", example = "2024-01-01T10:00:00")
    LocalDateTime scheduledStart, 
    @Schema(description = "The meeting URL", example = "https://example.com/meeting")
    String meetingUrl
) {}
