CREATE TABLE modules (
    id UUID PRIMARY KEY,
    title VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(255),
    order_index INTEGER NOT NULL,
    is_active BOOLEAN NOT NULL,
    stage_id BIGINT NOT NULL,
    skill_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_modules_stage
        FOREIGN KEY (stage_id) REFERENCES stages(id),
    CONSTRAINT fk_modules_skill
        FOREIGN KEY (skill_id) REFERENCES skills(id)
);
