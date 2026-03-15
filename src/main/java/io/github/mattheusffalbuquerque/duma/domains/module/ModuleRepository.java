package io.github.mattheusffalbuquerque.duma.domains.module;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModuleRepository extends JpaRepository<Module, String> {

    Optional<Module> findByTitle(String title);

    List<Module> findByStageId(Long stageId);

    List<Module> findBySkillId(Long skillId);

    Integer countByStageId(Long stageId);

    Integer countBySkillId(Long skillId);

}
