package io.github.mattheusffalbuquerque.duma.domains.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    Optional<Student> findByUserId(String userId);

    void deleteByUserId(String userId);

    Integer countByIsActiveTrue();
}
