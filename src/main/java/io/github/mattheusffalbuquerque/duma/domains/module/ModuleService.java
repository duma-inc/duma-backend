package io.github.mattheusffalbuquerque.duma.domains.module;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.mattheusffalbuquerque.duma.domains.module.dto.ModuleResponse;
import lombok.RequiredArgsConstructor;
import io.github.mattheusffalbuquerque.duma.domains.module.dto.CreateModuleRequest;
import io.github.mattheusffalbuquerque.duma.domains.module.dto.UpdateModuleRequest;
import io.github.mattheusffalbuquerque.duma.domains.stage.Stage;
import io.github.mattheusffalbuquerque.duma.domains.skill.entities.Skill;

@Service
@RequiredArgsConstructor
public class ModuleService {

    private final ModuleRepository moduleRepository;
    private final ModuleMapper moduleMapper;

    public List<ModuleResponse> getAllModules() {
        return moduleMapper.toResponseList(moduleRepository.findAll());
    }

    public ModuleResponse getModuleById(String id) {
        Module module = moduleRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Module not found with id: " + id));

        return moduleMapper.toResponse(module);
    }

    public List<ModuleResponse> getModulesByStageId(Long stageId) {
        return moduleMapper.toResponseList(moduleRepository.findByStageId(stageId));
    }

    public List<ModuleResponse> getModulesBySkillId(Long skillId) {
        return moduleMapper.toResponseList(moduleRepository.findBySkillId(skillId));
    }

    public Integer countModulesByStageId(Long stageId) {
        return moduleRepository.countByStageId(stageId);
    }

    public Integer countModulesBySkillId(Long skillId) {
        return moduleRepository.countBySkillId(skillId);
    }

    public ModuleResponse createModule(CreateModuleRequest request) {
        Module module = moduleMapper.toEntity(request);
        Module savedModule = moduleRepository.save(module);
        return moduleMapper.toResponse(savedModule);
    }

     public ModuleResponse updateModule(String id, UpdateModuleRequest request) {
        Module existingModule = moduleRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Module not found with id: " + id));

        if (request.title() != null) {
            existingModule.setTitle(request.title());
        }
        if (request.description() != null) {
            existingModule.setDescription(request.description());
        }
        if (request.orderIndex() != null) {
            existingModule.setOrderIndex(request.orderIndex());
        }
        if (request.isActive() != null) {
            existingModule.setIsActive(request.isActive());
        }
        if (request.stageId() != null) {
            Stage stage = new Stage();
            stage.setId(request.stageId());
            existingModule.setStage(stage);
        }
        if (request.skillId() != null) {
            Skill skill = new Skill();
            skill.setId(request.skillId());
            existingModule.setSkill(skill);
        }

        Module updatedModule = moduleRepository.save(existingModule);
        return moduleMapper.toResponse(updatedModule);
    }

    public void deleteModule(String id) {
        Module existingModule = moduleRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Module not found with id: " + id));

        moduleRepository.delete(existingModule);
    }

}
