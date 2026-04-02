package io.github.mattheusffalbuquerque.duma.domains.modulePerformance;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModulePerformanceRepository extends JpaRepository<ModulePerformance, Long> {

    Optional<ModulePerformance> findByStudentIdAndModuleId(UUID studentId, UUID moduleId);

    List<ModulePerformance> findByStudentId(UUID studentId);

    List<ModulePerformance> findByModuleId(UUID moduleId);

    Integer countByStudentId(UUID studentId);

    Integer countByModuleId(UUID moduleId);
}
