package io.github.mattheusffalbuquerque.duma.domains.attendance;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import io.github.mattheusffalbuquerque.duma.domains.attendance.dto.AttendanceResponse;
import io.github.mattheusffalbuquerque.duma.domains.attendance.dto.CreateAttendanceRequest;
import io.github.mattheusffalbuquerque.duma.domains.attendance.dto.UpdateAttendanceRequest;
import io.github.mattheusffalbuquerque.duma.domains.meeting.Meeting;
import io.github.mattheusffalbuquerque.duma.domains.meeting.MeetingRepository;
import io.github.mattheusffalbuquerque.duma.domains.student.Student;
import io.github.mattheusffalbuquerque.duma.domains.student.StudentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final AttendanceMapper attendanceMapper;
    private final StudentRepository studentRepository;
    private final MeetingRepository meetingRepository;

    public List<AttendanceResponse> getAllAttendances() {
        return attendanceMapper.toResponseList(attendanceRepository.findAll());
    }

    public AttendanceResponse getAttendanceById(Long id) {
        Attendance attendance = attendanceRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Attendance not found with id: " + id));

        return attendanceMapper.toResponse(attendance);
    }

    public List<AttendanceResponse> getAttendancesByStudentId(String studentId) {
        return attendanceMapper.toResponseList(attendanceRepository.findByStudentId(studentId));
    }

    public List<AttendanceResponse> getAttendancesByMeetingId(String meetingId) {
        return attendanceMapper.toResponseList(attendanceRepository.findByMeetingId(meetingId));
    }

    public AttendanceResponse getAttendanceByStudentIdAndMeetingId(String studentId, String meetingId) {
        Attendance attendance = attendanceRepository.findByStudentIdAndMeetingId(studentId, meetingId)
            .orElseThrow(() -> new RuntimeException(
                "Attendance not found for student id: " + studentId + " and meeting id: " + meetingId
            ));

        return attendanceMapper.toResponse(attendance);
    }

    public AttendanceResponse createAttendance(CreateAttendanceRequest request) {
        attendanceRepository.findByStudentIdAndMeetingId(request.studentId(), request.meetingId())
            .ifPresent(existingAttendance -> {
                throw new RuntimeException(
                    "Attendance already exists for student id: " + request.studentId()
                        + " and meeting id: " + request.meetingId()
                );
            });

        Attendance attendance = attendanceMapper.toEntity(request);
        attendance.setStudent(getStudentById(request.studentId()));
        attendance.setMeeting(getMeetingById(request.meetingId()));
        attendance.setCheckedAt(request.checkedAt() != null ? request.checkedAt() : LocalDateTime.now());

        Attendance savedAttendance = attendanceRepository.save(attendance);
        return attendanceMapper.toResponse(savedAttendance);
    }

    public AttendanceResponse updateAttendance(Long id, UpdateAttendanceRequest request) {
        Attendance existingAttendance = attendanceRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Attendance not found with id: " + id));

        if (request.studentId() != null) {
            existingAttendance.setStudent(getStudentById(request.studentId()));
        }
        if (request.meetingId() != null) {
            existingAttendance.setMeeting(getMeetingById(request.meetingId()));
        }
        if (request.status() != null) {
            existingAttendance.setStatus(request.status());
        }
        if (request.notes() != null) {
            existingAttendance.setNotes(request.notes());
        }
        if (request.checkedAt() != null) {
            existingAttendance.setCheckedAt(request.checkedAt());
        }

        Attendance updatedAttendance = attendanceRepository.save(existingAttendance);
        return attendanceMapper.toResponse(updatedAttendance);
    }

    public void deleteAttendance(Long id) {
        Attendance existingAttendance = attendanceRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Attendance not found with id: " + id));

        attendanceRepository.delete(existingAttendance);
    }

    private Student getStudentById(String studentId) {
        return studentRepository.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));
    }

    private Meeting getMeetingById(String meetingId) {
        return meetingRepository.findById(meetingId)
            .orElseThrow(() -> new RuntimeException("Meeting not found with id: " + meetingId));
    }
}
