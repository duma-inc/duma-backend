package io.github.mattheusffalbuquerque.duma.domains.modulePerformance;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.github.mattheusffalbuquerque.duma.domains.module.Module;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.github.mattheusffalbuquerque.duma.domains.student.Student;

/* 
    * This class will represent the performance of a student in a specific module, including metrics such as:
    * - Exercises completed
    * - Scores achieved
    * - Time spent on learning activities
    * It will be used to provide insights to students about their learning journey and to help them identify areas for improvement.
*/


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(
    name = "module_performance",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"student_id", "module_id"})
    }
)
public class ModulePerformance {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;

    @Column(nullable = false)
    private Integer totalExercises;

    @Column(nullable = false)
    private Integer exercisesCompleted;

    @Column(nullable = false)
    private Integer averageScore;

    @Column(nullable = false)
    private Integer timeSpentMinutes;

    @Column(nullable = false)
    private Integer progressPercent;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
