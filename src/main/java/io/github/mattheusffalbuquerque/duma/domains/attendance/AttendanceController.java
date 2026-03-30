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
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/attendances")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @GetMapping
    public ResponseEntity<List<AttendanceResponse>> getAllAttendances() {
        return ResponseEntity.ok(attendanceService.getAllAttendances());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttendanceResponse> getAttendanceById(@PathVariable Long id) {
        return ResponseEntity.ok(attendanceService.getAttendanceById(id));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<AttendanceResponse>> getAttendancesByStudentId(@PathVariable String studentId) {
        return ResponseEntity.ok(attendanceService.getAttendancesByStudentId(studentId));
    }

    @GetMapping("/meeting/{meetingId}")
    public ResponseEntity<List<AttendanceResponse>> getAttendancesByMeetingId(@PathVariable String meetingId) {
        return ResponseEntity.ok(attendanceService.getAttendancesByMeetingId(meetingId));
    }

    @GetMapping("/by-student-and-meeting")
    public ResponseEntity<AttendanceResponse> getAttendanceByStudentIdAndMeetingId(
        @RequestParam String studentId,
        @RequestParam String meetingId
    ) {
        return ResponseEntity.ok(attendanceService.getAttendanceByStudentIdAndMeetingId(studentId, meetingId));
    }

    @PostMapping
    public ResponseEntity<AttendanceResponse> createAttendance(@RequestBody CreateAttendanceRequest request) {
        return ResponseEntity.ok(attendanceService.createAttendance(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttendanceResponse> updateAttendance(
        @PathVariable Long id,
        @RequestBody UpdateAttendanceRequest request
    ) {
        return ResponseEntity.ok(attendanceService.updateAttendance(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
        return ResponseEntity.noContent().build();
    }
}
