package io.github.mattheusffalbuquerque.duma.domains.attendance.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "CreateAttendanceRequest", description = "Request to create a new Attendance")
public record CreateAttendanceRequest(

    @Schema(description = "The identifier of the student", example = "student-123")
    String studentId,
    @Schema(description = "The identifier of the meeting", example = "meeting-123")
    String meetingId,
    @Schema(description = "The status", example = "ACTIVE")
    Boolean status,
    @Schema(description = "Additional notes", example = "Attendance confirmed")
    String notes,
    @Schema(description = "The date and time when attendance was checked", example = "2024-01-01T10:00:00")
    LocalDateTime checkedAt

) {}
