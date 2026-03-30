CREATE TABLE lesson_progress (
    id BIGSERIAL PRIMARY KEY,
    student_id UUID NOT NULL,
    lesson_id UUID NOT NULL,
    status VARCHAR(255) NOT NULL,
    progress_percent INTEGER NOT NULL,
    watched_minutes INTEGER NOT NULL,
    started_at TIMESTAMP,
    last_access_at TIMESTAMP,
    completed_at TIMESTAMP,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uk_lesson_progress_student_lesson UNIQUE (student_id, lesson_id),
    CONSTRAINT fk_lesson_progress_student
        FOREIGN KEY (student_id) REFERENCES students(id),
    CONSTRAINT fk_lesson_progress_lesson
        FOREIGN KEY (lesson_id) REFERENCES lessons(id)
);
