package io.github.mattheusffalbuquerque.duma.domains.skill;

import org.springframework.web.bind.annotation.RestController;

import io.github.mattheusffalbuquerque.duma.domains.skill.dto.CreateSkillRequest;
import io.github.mattheusffalbuquerque.duma.domains.skill.dto.SkillResponse;
import io.github.mattheusffalbuquerque.duma.domains.skill.entities.Skill;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/skills")
@RequiredArgsConstructor
@Tag(name = "Skill", description = "Endpoints for managing skills")
public class SkillController {

    private final SkillService skillService;
    private final SkillMapper skillMapper;

    @GetMapping
    @Operation(summary = "Get all skills", description = "Returns a list of all skills in the system")
    public ResponseEntity<List<SkillResponse>> getAllSkills() {

        List<Skill> skills = skillService.getAllSkills();

        return ResponseEntity.ok(skillMapper.toResponseList(skills));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get skill by ID", description = "Returns a single skill by its unique ID")
    public ResponseEntity<SkillResponse> getSkillById(@PathVariable Long id) {

        Skill skill = skillService.getSkillById(id);

        return ResponseEntity.ok(skillMapper.toResponse(skill));
    }

    @PostMapping
    @Operation(summary = "Create a new skill", description = "Creates a new skill in the system")
    public ResponseEntity<SkillResponse> createSkill(@RequestBody CreateSkillRequest request) {
        return ResponseEntity.ok(skillService.createSkill(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update skill information", description = "Updates the information of an existing skill identified by its unique ID")
    public ResponseEntity<SkillResponse> updateSkill(@PathVariable Long id, @RequestBody CreateSkillRequest request) {
        return ResponseEntity.ok(skillService.updateSkill(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a skill", description = "Deletes an existing skill from the system identified by its unique ID")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
        return ResponseEntity.noContent().build();
    }

}
