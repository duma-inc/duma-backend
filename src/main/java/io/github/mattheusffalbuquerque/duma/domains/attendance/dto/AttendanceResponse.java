package io.github.mattheusffalbuquerque.duma.domains.attendance.dto;

import java.time.LocalDateTime;

public record AttendanceResponse(

    Long id,
    String studentId,
    String meetingId,
    Boolean status,
    String notes,
    LocalDateTime checkedAt,
    LocalDateTime createdAt,
    LocalDateTime updatedAt

) {}
