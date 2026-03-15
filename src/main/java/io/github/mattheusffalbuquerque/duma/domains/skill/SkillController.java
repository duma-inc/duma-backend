package io.github.mattheusffalbuquerque.duma.domains.skill;

import org.springframework.web.bind.annotation.RestController;

import io.github.mattheusffalbuquerque.duma.domains.skill.dto.CreateSkillRequest;
import io.github.mattheusffalbuquerque.duma.domains.skill.dto.SkillResponse;
import io.github.mattheusffalbuquerque.duma.domains.skill.entities.Skill;
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
public class SkillController {

    private final SkillService skillService;
    private final SkillMapper skillMapper;

    @GetMapping
    public ResponseEntity<List<SkillResponse>> getAllSkills() {

        List<Skill> skills = skillService.getAllSkills();

        return ResponseEntity.ok(skillMapper.toResponseList(skills));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillResponse> getSkillById(@PathVariable Long id) {

        Skill skill = skillService.getSkillById(id);

        return ResponseEntity.ok(skillMapper.toResponse(skill));
    }

    @PostMapping
    public ResponseEntity<SkillResponse> createSkill(@RequestBody CreateSkillRequest request) {
        return ResponseEntity.ok(skillService.createSkill(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkillResponse> updateSkill(@PathVariable Long id, @RequestBody CreateSkillRequest request) {
        return ResponseEntity.ok(skillService.updateSkill(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
        return ResponseEntity.noContent().build();
    }

}
