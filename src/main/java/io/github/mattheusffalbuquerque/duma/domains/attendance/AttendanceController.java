package io.github.mattheusffalbuquerque.duma.domains.attendance;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.mattheusffalbuquerque.duma.domains.attendance.dto.AttendanceResponse;
import io.github.mattheusffalbuquerque.duma.domains.attendance.dto.CreateAttendanceRequest;
import io.github.mattheusffalbuquerque.duma.domains.attendance.dto.UpdateAttendanceRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/attendances")
@Tag(name = "Attendance", description = "Endpoints for managing attendance records")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @GetMapping
    @Operation(summary = "Get all attendance records", description = "Returns a list of all attendance records in the system")
    public ResponseEntity<List<AttendanceResponse>> getAllAttendances() {
        return ResponseEntity.ok(attendanceService.getAllAttendances());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get attendance record by ID", description = "Returns a single attendance record by its unique ID")
    public ResponseEntity<AttendanceResponse> getAttendanceById(@PathVariable Long id) {
        return ResponseEntity.ok(attendanceService.getAttendanceById(id));
    }

    @GetMapping("/student/{studentId}")
    @Operation(summary = "Get attendance records by student ID", description = "Returns a list of attendance records associated with a specific student")
    public ResponseEntity<List<AttendanceResponse>> getAttendancesByStudentId(@PathVariable String studentId) {
        return ResponseEntity.ok(attendanceService.getAttendancesByStudentId(studentId));
    }

    @GetMapping("/meeting/{meetingId}")
    @Operation(summary = "Get attendance records by meeting ID", description = "Returns a list of attendance records associated with a specific meeting")
    public ResponseEntity<List<AttendanceResponse>> getAttendancesByMeetingId(@PathVariable String meetingId) {
        return ResponseEntity.ok(attendanceService.getAttendancesByMeetingId(meetingId));
    }

    @GetMapping("/by-student-and-meeting")
    @Operation(summary = "Get attendance record by student ID and meeting ID", description = "Returns a single attendance record associated with a specific student and meeting")
    public ResponseEntity<AttendanceResponse> getAttendanceByStudentIdAndMeetingId(
        @RequestParam String studentId,
        @RequestParam String meetingId
    ) {
        return ResponseEntity.ok(attendanceService.getAttendanceByStudentIdAndMeetingId(studentId, meetingId));
    }

    @PostMapping
    @Operation(summary = "Create a new attendance record", description = "Creates a new attendance record in the system")
    public ResponseEntity<AttendanceResponse> createAttendance(@RequestBody CreateAttendanceRequest request) {
        return ResponseEntity.ok(attendanceService.createAttendance(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing attendance record", description = "Updates the information of an existing attendance record identified by its unique ID")
    public ResponseEntity<AttendanceResponse> updateAttendance(
        @PathVariable Long id,
        @RequestBody UpdateAttendanceRequest request
    ) {
        return ResponseEntity.ok(attendanceService.updateAttendance(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an existing attendance record", description = "Deletes an existing attendance record identified by its unique ID")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
        return ResponseEntity.noContent().build();
    }
}
