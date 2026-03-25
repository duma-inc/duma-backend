package io.github.mattheusffalbuquerque.duma.domains.teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {

    Optional<Teacher> findByUserId(String userId);

    void deleteByUserId(String userId);

    Integer countByIsActiveTrue();
}
