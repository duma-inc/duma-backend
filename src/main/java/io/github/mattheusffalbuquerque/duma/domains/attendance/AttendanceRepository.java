package io.github.mattheusffalbuquerque.duma.domains.attendance;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    Optional<Attendance> findByStudentIdAndMeetingId(String studentId, String meetingId);

    List<Attendance> findByStudentId(String studentId);

    List<Attendance> findByMeetingId(String meetingId);

    List<Attendance> findByStatus(Boolean status);

    Integer countByStudentId(String studentId);

    Integer countByMeetingId(String meetingId);
}
