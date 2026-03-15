package io.github.mattheusffalbuquerque.duma.domains.enrollments;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;

import io.github.mattheusffalbuquerque.duma.domains.enrollments.enums.EnrollmentStatus;
import io.github.mattheusffalbuquerque.duma.domains.skill.entities.Skill;
import io.github.mattheusffalbuquerque.duma.domains.user.User;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import io.github.mattheusffalbuquerque.duma.domains.stage.Stage;
import jakarta.persistence.UniqueConstraint;
import io.github.mattheusffalbuquerque.duma.domains.enrollments.enums.EnrollmentSource;
import io.github.mattheusffalbuquerque.duma.domains.enrollments.enums.EnrollmentPace;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "enrollments", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user_id", "skill_id"})
})
public class Enrollment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    @ManyToOne
    @JoinColumn(name = "stage_id", nullable = false)
    private Stage currentStage;

    @Enumerated(EnumType.STRING)
    private EnrollmentStatus status;

    @Enumerated(EnumType.STRING)
    private EnrollmentSource source;

    @Enumerated(EnumType.STRING)
    private EnrollmentPace pace;

    @Column(nullable = false)
    private Integer progressPercentage;

    @CreatedDate
    private LocalDateTime enrolledAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime lastActivityAt;
    
}
