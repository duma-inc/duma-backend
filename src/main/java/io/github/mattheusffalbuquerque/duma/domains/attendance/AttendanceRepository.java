package io.github.mattheusffalbuquerque.duma.domains.attendance;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    Optional<Attendance> findByStudentIdAndMeetingId(UUID studentId, UUID meetingId);

    List<Attendance> findByStudentId(UUID studentId);

    List<Attendance> findByMeetingId(UUID meetingId);

    List<Attendance> findByStatus(Boolean status);

    Integer countByStudentId(UUID studentId);

    Integer countByMeetingId(UUID meetingId);
}
