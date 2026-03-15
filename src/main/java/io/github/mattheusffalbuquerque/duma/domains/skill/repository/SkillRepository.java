package io.github.mattheusffalbuquerque.duma.domains.skill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.mattheusffalbuquerque.duma.domains.skill.entities.Skill;

import java.util.Optional;
import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    Optional<Skill> findBySlug(String slug);

    boolean existsBySlug(String slug);

    Integer countByCategoryId(Long categoryId);

    Optional<List<Skill>> findByCategoryId(Long categoryId);
}
