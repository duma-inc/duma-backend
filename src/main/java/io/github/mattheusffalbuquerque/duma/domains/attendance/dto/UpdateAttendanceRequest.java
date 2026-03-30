package io.github.mattheusffalbuquerque.duma.domains.attendance.dto;

import java.time.LocalDateTime;

public record UpdateAttendanceRequest(

    String studentId,
    String meetingId,
    Boolean status,
    String notes,
    LocalDateTime checkedAt

) {}
