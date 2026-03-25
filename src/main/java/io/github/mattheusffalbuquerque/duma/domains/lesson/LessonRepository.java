package io.github.mattheusffalbuquerque.duma.domains.lesson;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, String> {

    List<Lesson> findByTitle(String title);
    
    List<Lesson> findByModuleId(String moduleId);

    List<Lesson> findByStageId(Long stageId);

     List<Lesson> findBySkillId(Long skillId);

     Integer countByModuleId(String moduleId);

     Integer countByStageId(Long stageId);

     Integer countBySkillId(Long skillId);

}
