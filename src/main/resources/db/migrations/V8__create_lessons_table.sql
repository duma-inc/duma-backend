CREATE TABLE lessons (
    id UUID PRIMARY KEY,
    title VARCHAR(100) NOT NULL UNIQUE,
    content TEXT,
    order_index INTEGER NOT NULL,
    is_active BOOLEAN NOT NULL,
    module_id UUID NOT NULL,
    stage_id BIGINT NOT NULL,
    skill_id BIGINT NOT NULL,
    video_url VARCHAR(255),
    duration_in_minutes INTEGER,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_lessons_module
        FOREIGN KEY (module_id) REFERENCES modules(id),
    CONSTRAINT fk_lessons_stage
        FOREIGN KEY (stage_id) REFERENCES stages(id),
    CONSTRAINT fk_lessons_skill
        FOREIGN KEY (skill_id) REFERENCES skills(id)
);
