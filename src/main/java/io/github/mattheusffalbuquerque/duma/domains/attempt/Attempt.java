package io.github.mattheusffalbuquerque.duma.domains.attempt;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.github.mattheusffalbuquerque.duma.domains.lesson.Lesson;
import io.github.mattheusffalbuquerque.duma.domains.student.Student;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "attempts")
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;

    @Column(nullable = false)
    private String exerciseId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String answerGiven;

    @Column(nullable = false)
    private Boolean isCorrect;

    @Column(nullable = false)
    private Integer score;

    @Column(nullable = false)
    private Integer timeSpentSeconds;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
