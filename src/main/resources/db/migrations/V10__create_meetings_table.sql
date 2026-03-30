CREATE TABLE meetings (
    id UUID PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    teacher_id UUID NOT NULL,
    skill_id BIGINT NOT NULL,
    stage_id BIGINT NOT NULL,
    scheduled_start TIMESTAMP NOT NULL,
    meeting_url VARCHAR(255) NOT NULL,
    recording_url VARCHAR(255),
    status VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_meetings_teacher
        FOREIGN KEY (teacher_id) REFERENCES teachers(id),
    CONSTRAINT fk_meetings_skill
        FOREIGN KEY (skill_id) REFERENCES skills(id),
    CONSTRAINT fk_meetings_stage
        FOREIGN KEY (stage_id) REFERENCES stages(id)
);
