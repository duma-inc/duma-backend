package io.github.mattheusffalbuquerque.duma.domains.modulePerformance;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModulePerformanceRepository extends JpaRepository<ModulePerformance, Long> {

    Optional<ModulePerformance> findByStudentIdAndModuleId(String studentId, String moduleId);

    List<ModulePerformance> findByStudentId(String studentId);

    List<ModulePerformance> findByModuleId(String moduleId);

    Integer countByStudentId(String studentId);

    Integer countByModuleId(String moduleId);
}
