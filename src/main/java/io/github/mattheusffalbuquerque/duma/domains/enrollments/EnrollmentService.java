package io.github.mattheusffalbuquerque.duma.domains.enrollments;

import io.github.mattheusffalbuquerque.duma.domains.enrollments.dto.CreateEnrollmentRequest;
import io.github.mattheusffalbuquerque.duma.domains.enrollments.dto.EnrollmentResponse;
import java.util.List;
import io.github.mattheusffalbuquerque.duma.domains.enrollments.dto.UpdateEnrollmentRequest;
import io.github.mattheusffalbuquerque.duma.domains.user.UserRepository;
import org.springframework.stereotype.Service;
import io.github.mattheusffalbuquerque.duma.domains.skill.repository.SkillRepository;
import io.github.mattheusffalbuquerque.duma.domains.stage.StageRepository;
import io.github.mattheusffalbuquerque.duma.domains.user.User;
import io.github.mattheusffalbuquerque.duma.domains.skill.entities.Skill;   
import io.github.mattheusffalbuquerque.duma.domains.stage.Stage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final UserRepository userRepository;
    private final SkillRepository skillRepository;
    private final StageRepository stageRepository;
    private final EnrollmentMapper enrollmentMapper;

    public List<EnrollmentResponse> getAllEnrollments() {
        return enrollmentMapper.toResponseList(enrollmentRepository.findAll());
    }

    public EnrollmentResponse getEnrollmentById(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Enrollment not found with id: " + id));

        return enrollmentMapper.toResponse(enrollment);
    }

    public EnrollmentResponse createEnrollment(CreateEnrollmentRequest request) {
        
        User user = userRepository.findById(request.userId())
            .orElseThrow(() -> new RuntimeException("User not found with id: " + request.userId()));

        Skill skill = skillRepository.findById(request.skillId())
            .orElseThrow(() -> new RuntimeException("Skill not found with id: " + request.skillId()));

        Stage stage = stageRepository.findById(request.stageId())
            .orElseThrow(() -> new RuntimeException("Stage not found with id: " + request.stageId()));

        Enrollment enrollment = Enrollment.builder()
            .user(user)
            .skill(skill)
            .currentStage(stage)
            .status(request.status())
            .source(request.source())
            .pace(request.pace())
            .build();

        return enrollmentMapper.toResponse(enrollmentRepository.save(enrollment));
    }

    public EnrollmentResponse updateEnrollment(Long id, UpdateEnrollmentRequest request) {
        Enrollment existingEnrollment = enrollmentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Enrollment not found with id: " + id));


        if (request.userId() != null) {
            User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + request.userId()));
            existingEnrollment.setUser(user);
        }
        if (request.skillId() != null) {
            Skill skill = skillRepository.findById(request.skillId())
                .orElseThrow(() -> new RuntimeException("Skill not found with id: " + request.skillId()));
            existingEnrollment.setSkill(skill);
        }
        if (request.stageId() != null) {
            Stage stage = stageRepository.findById(request.stageId())
                .orElseThrow(() -> new RuntimeException("Stage not found with id: " + request.stageId()));
            existingEnrollment.setCurrentStage(stage);
        }
        if (request.status() != null) {
            existingEnrollment.setStatus(request.status());
        }
        if (request.source() != null) {
            existingEnrollment.setSource(request.source());
        }
        if (request.pace() != null) {
            existingEnrollment.setPace(request.pace());
        }

        Enrollment updatedEnrollment = enrollmentRepository.save(existingEnrollment);
        return enrollmentMapper.toResponse(updatedEnrollment);
    }

    public void deleteEnrollment(Long id) {
        if (!enrollmentRepository.existsById(id)) {
            throw new RuntimeException("Enrollment not found with id: " + id);
        }
        enrollmentRepository.deleteById(id);
    }       
}
