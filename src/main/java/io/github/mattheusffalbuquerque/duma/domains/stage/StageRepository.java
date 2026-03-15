package io.github.mattheusffalbuquerque.duma.domains.stage;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long> {

    Optional<Stage> findBySlug(String slug);
}
