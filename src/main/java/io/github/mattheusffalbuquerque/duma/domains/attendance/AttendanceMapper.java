package io.github.mattheusffalbuquerque.duma.domains.attendance;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import io.github.mattheusffalbuquerque.duma.domains.attendance.dto.AttendanceResponse;
import io.github.mattheusffalbuquerque.duma.domains.attendance.dto.CreateAttendanceRequest;
import io.github.mattheusffalbuquerque.duma.domains.meeting.Meeting;
import io.github.mattheusffalbuquerque.duma.domains.student.Student;

@Mapper(componentModel = "spring")
public interface AttendanceMapper {

    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "meetingId", source = "meeting.id")
    AttendanceResponse toResponse(Attendance attendance);

    @Mapping(target = "student", source = "studentId")
    @Mapping(target = "meeting", source = "meetingId")
    Attendance toEntity(CreateAttendanceRequest request);

    List<AttendanceResponse> toResponseList(List<Attendance> attendanceList);

    default Student mapStudent(String studentId) {
        if (studentId == null) {
            return null;
        }

        Student student = new Student();
        student.setId(UUID.fromString(studentId));
        return student;
    }

    default Meeting mapMeeting(String meetingId) {
        if (meetingId == null) {
            return null;
        }

        Meeting meeting = new Meeting();
        meeting.setId(UUID.fromString(meetingId));
        return meeting;
    }
}
