package io.github.mattheusffalbuquerque.duma.domains.skill;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import io.github.mattheusffalbuquerque.duma.domains.skill.dto.CreateSkillRequest;
import io.github.mattheusffalbuquerque.duma.domains.skill.dto.SkillResponse;
import io.github.mattheusffalbuquerque.duma.domains.skill.entities.Skill;
import io.github.mattheusffalbuquerque.duma.domains.skill.entities.SkillCategory;
import lombok.RequiredArgsConstructor;
import io.github.mattheusffalbuquerque.duma.domains.skill.repository.SkillCategoryRepository;
import io.github.mattheusffalbuquerque.duma.domains.skill.repository.SkillRepository;

@Service
@RequiredArgsConstructor
public class SkillService {

    private final SkillRepository skillRepository;
    private final SkillCategoryRepository skillCategoryRepository;

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public Skill getSkillById(Long id) {
        return skillRepository.findById(id).orElseThrow(() -> new RuntimeException("Skill not found with id: " + id));
    }

    public Optional<List<Skill>> getSkillsByCategoryId(Long categoryId) {
        return skillRepository.findByCategoryId(categoryId);
    }

     public Skill getSkillBySlug(String slug) {
        return skillRepository.findBySlug(slug).orElseThrow(() -> new RuntimeException("Skill not found with slug: " + slug));
    }

    public Integer countSkillsByCategoryId(Long categoryId) {
        return skillRepository.countByCategoryId(categoryId);
    }

    public SkillResponse createSkill(CreateSkillRequest request) {

        SkillCategory skillCategory = skillCategoryRepository.findById(request.categoryId())
            .orElseThrow(() -> new RuntimeException("Category not found with id: " + request.categoryId()));

        Skill newSkill = Skill.builder()
            .name(request.name())
            .slug(request.slug())
            .shortDescription(request.shortDescription())
            .category(skillCategory)
            .build();

        Skill savedSkill = skillRepository.save(newSkill);
        
        return new SkillResponse(
            savedSkill.getId(),
            savedSkill.getName(),
            savedSkill.getSlug(),
            savedSkill.getShortDescription(),
            savedSkill.getCategory().getName()
        );
    }

    public SkillResponse updateSkill(Long id, CreateSkillRequest request) {
        Skill existingSkill = skillRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Skill not found with id: " + id));

        SkillCategory skillCategory = skillCategoryRepository.findById(request.categoryId())
            .orElseThrow(() -> new RuntimeException("Category not found with id: " + request.categoryId()));

        if (request.name() != null) {
            existingSkill.setName(request.name());     
        }
        if (request.slug() != null) {
            existingSkill.setSlug(request.slug());
        }
        if (request.shortDescription() != null) {
            existingSkill.setShortDescription(request.shortDescription());
        }
        if (request.categoryId() != null) {
            skillCategory = skillCategoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + request.categoryId()));
            existingSkill.setCategory(skillCategory);
        }

        Skill updatedSkill = skillRepository.save(existingSkill);

        return new SkillResponse(
            updatedSkill.getId(),
            updatedSkill.getName(),
            updatedSkill.getSlug(),
            updatedSkill.getShortDescription(),
            updatedSkill.getCategory().getName()
        );
    }

    public void deleteSkill(Long id) {
        Skill existingSkill = skillRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Skill not found with id: " + id));
        skillRepository.delete(existingSkill);
    }
    
}
