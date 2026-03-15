package io.github.mattheusffalbuquerque.duma.domains.skill;

import java.util.List;
import io.github.mattheusffalbuquerque.duma.domains.skill.dto.CreateSkillRequest;
import io.github.mattheusffalbuquerque.duma.domains.skill.dto.SkillResponse;
import io.github.mattheusffalbuquerque.duma.domains.skill.entities.Skill;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    
    SkillResponse toResponse(Skill skill);

    Skill toEntity(CreateSkillRequest request);

    List<SkillResponse> toResponseList(List<Skill> skills);

}
