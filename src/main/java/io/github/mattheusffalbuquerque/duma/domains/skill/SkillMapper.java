package io.github.mattheusffalbuquerque.duma.domains.skill;

import java.util.List;
import io.github.mattheusffalbuquerque.duma.domains.skill.dto.CreateSkillRequest;
import io.github.mattheusffalbuquerque.duma.domains.skill.dto.SkillResponse;
import io.github.mattheusffalbuquerque.duma.domains.skill.entities.Skill;
import io.github.mattheusffalbuquerque.duma.domains.skill.entities.SkillCategory;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SkillMapper {

    @Mapping(target = "category", source = "category.name")
    SkillResponse toResponse(Skill skill);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", source = "categoryId")
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Skill toEntity(CreateSkillRequest request);

    List<SkillResponse> toResponseList(List<Skill> skills);

    default SkillCategory map(Long categoryId) {
        if (categoryId == null) {
            return null;
        }

        SkillCategory category = new SkillCategory();
        category.setId(categoryId);
        return category;
    }
}
