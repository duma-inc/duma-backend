package io.github.mattheusffalbuquerque.duma.domains.modulePerformance;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.mattheusffalbuquerque.duma.domains.module.Module;
import io.github.mattheusffalbuquerque.duma.domains.module.ModuleRepository;
import io.github.mattheusffalbuquerque.duma.domains.modulePerformance.dto.CreateModulePerformanceRequest;
import io.github.mattheusffalbuquerque.duma.domains.modulePerformance.dto.ModulePerformanceResponse;
import io.github.mattheusffalbuquerque.duma.domains.modulePerformance.dto.UpdateModulePerformanceRequest;
import io.github.mattheusffalbuquerque.duma.domains.student.Student;
import io.github.mattheusffalbuquerque.duma.domains.student.StudentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ModulePerformanceService {

    private final ModulePerformanceRepository modulePerformanceRepository;
    private final ModulePerformanceMapper modulePerformanceMapper;
    private final StudentRepository studentRepository;
    private final ModuleRepository moduleRepository;

    public List<ModulePerformanceResponse> getAllModulePerformance() {
        return modulePerformanceMapper.toResponseList(modulePerformanceRepository.findAll());
    }

    public ModulePerformanceResponse getModulePerformanceById(Long id) {
        ModulePerformance modulePerformance = modulePerformanceRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Module performance not found with id: " + id));

        return modulePerformanceMapper.toResponse(modulePerformance);
    }

    public List<ModulePerformanceResponse> getModulePerformanceByStudentId(String studentId) {
        return modulePerformanceMapper.toResponseList(modulePerformanceRepository.findByStudentId(studentId));
    }

    public List<ModulePerformanceResponse> getModulePerformanceByModuleId(String moduleId) {
        return modulePerformanceMapper.toResponseList(modulePerformanceRepository.findByModuleId(moduleId));
    }

    public ModulePerformanceResponse createModulePerformance(CreateModulePerformanceRequest request) {
        ModulePerformance modulePerformance = modulePerformanceMapper.toEntity(request);
        modulePerformance.setStudent(findStudentById(request.studentId()));
        modulePerformance.setModule(findModuleById(request.moduleId()));

        ModulePerformance savedModulePerformance = modulePerformanceRepository.save(modulePerformance);
        return modulePerformanceMapper.toResponse(savedModulePerformance);
    }

    public ModulePerformanceResponse updateModulePerformance(Long id, UpdateModulePerformanceRequest request) {
        ModulePerformance existingModulePerformance = modulePerformanceRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Module performance not found with id: " + id));

        if (request.studentId() != null) {
            existingModulePerformance.setStudent(findStudentById(request.studentId()));
        }
        if (request.moduleId() != null) {
            existingModulePerformance.setModule(findModuleById(request.moduleId()));
        }
        if (request.exercisesCompleted() != null) {
            existingModulePerformance.setExercisesCompleted(request.exercisesCompleted());
        }
        if (request.averageScore() != null) {
            existingModulePerformance.setAverageScore(request.averageScore());
        }
        if (request.timeSpentMinutes() != null) {
            existingModulePerformance.setTimeSpentMinutes(request.timeSpentMinutes());
        }
        if (request.progressPercent() != null) {
            existingModulePerformance.setProgressPercent(request.progressPercent());
        }

        ModulePerformance updatedModulePerformance = modulePerformanceRepository.save(existingModulePerformance);
        return modulePerformanceMapper.toResponse(updatedModulePerformance);
    }

    public void deleteModulePerformance(Long id) {
        ModulePerformance existingModulePerformance = modulePerformanceRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Module performance not found with id: " + id));

        modulePerformanceRepository.delete(existingModulePerformance);
    }

    private Student findStudentById(String studentId) {
        return studentRepository.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));
    }

    private Module findModuleById(String moduleId) {
        return moduleRepository.findById(moduleId)
            .orElseThrow(() -> new RuntimeException("Module not found with id: " + moduleId));
    }
}
