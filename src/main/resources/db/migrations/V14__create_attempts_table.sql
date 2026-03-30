CREATE TABLE attempts (
    id BIGSERIAL PRIMARY KEY,
    student_id UUID NOT NULL,
    lesson_id UUID NOT NULL,
    exercise_id VARCHAR(255) NOT NULL,
    answer_given TEXT NOT NULL,
    is_correct BOOLEAN NOT NULL,
    score INTEGER NOT NULL,
    time_spent_seconds INTEGER NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_attempts_student
        FOREIGN KEY (student_id) REFERENCES students(id),
    CONSTRAINT fk_attempts_lesson
        FOREIGN KEY (lesson_id) REFERENCES lessons(id)
);
