package io.github.mattheusffalbuquerque.duma.domains.meeting;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, String> {
    
    public Meeting findByTeacherId(String teacherId);

    public Meeting findByMeetingUrl(String meetingUrl);

    public List<Meeting> findAllByTeacherId(String teacherId);

    public List<Meeting> findAllBySkillId(String skillId);

    public List<Meeting> findAllByStageId(String stageId);

    public Integer countBySkillId(String skillId);

    public Integer countByStageId(String stageId);

    public Integer countByTeacherId(String teacherId);

}