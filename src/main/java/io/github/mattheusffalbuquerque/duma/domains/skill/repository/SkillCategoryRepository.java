package io.github.mattheusffalbuquerque.duma.domains.skill.repository;

import org.springframework.stereotype.Repository;

import io.github.mattheusffalbuquerque.duma.domains.skill.entities.SkillCategory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface SkillCategoryRepository extends JpaRepository<SkillCategory, Long> {
    
    Optional<SkillCategory> findById(Long id);

} 
    