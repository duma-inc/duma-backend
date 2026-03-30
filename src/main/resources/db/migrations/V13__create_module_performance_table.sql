CREATE TABLE module_performance (
    id BIGSERIAL PRIMARY KEY,
    student_id UUID NOT NULL,
    module_id UUID NOT NULL,
    total_exercises INTEGER NOT NULL,
    exercises_completed INTEGER NOT NULL,
    average_score INTEGER NOT NULL,
    time_spent_minutes INTEGER NOT NULL,
    progress_percent INTEGER NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uk_module_performance_student_module UNIQUE (student_id, module_id),
    CONSTRAINT fk_module_performance_student
        FOREIGN KEY (student_id) REFERENCES students(id),
    CONSTRAINT fk_module_performance_module
        FOREIGN KEY (module_id) REFERENCES modules(id)
);
