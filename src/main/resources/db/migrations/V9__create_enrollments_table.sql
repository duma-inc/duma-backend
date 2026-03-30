CREATE TABLE enrollments (
    id BIGSERIAL PRIMARY KEY,
    user_id UUID NOT NULL,
    skill_id BIGINT NOT NULL,
    stage_id BIGINT NOT NULL,
    status VARCHAR(255),
    source VARCHAR(255),
    pace VARCHAR(255),
    progress_percentage INTEGER NOT NULL,
    enrolled_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_activity_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uk_enrollments_user_skill UNIQUE (user_id, skill_id),
    CONSTRAINT fk_enrollments_user
        FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_enrollments_skill
        FOREIGN KEY (skill_id) REFERENCES skills(id),
    CONSTRAINT fk_enrollments_stage
        FOREIGN KEY (stage_id) REFERENCES stages(id)
);
