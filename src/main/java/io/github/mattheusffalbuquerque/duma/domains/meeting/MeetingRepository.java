package io.github.mattheusffalbuquerque.duma.domains.meeting;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, UUID> {
    
    public Meeting findByTeacherId(UUID teacherId);

    public Meeting findByMeetingUrl(String meetingUrl);

    public List<Meeting> findAllByTeacherId(UUID teacherId);

    public List<Meeting> findAllBySkillId(Long skillId);

    public List<Meeting> findAllByStageId(Long stageId);

    public Integer countBySkillId(Long skillId);

    public Integer countByStageId(Long stageId);

    public Integer countByTeacherId(UUID teacherId);

}
