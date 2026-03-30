CREATE TABLE attendances (
    id BIGSERIAL PRIMARY KEY,
    student_id UUID NOT NULL,
    meeting_id UUID NOT NULL,
    status BOOLEAN NOT NULL DEFAULT FALSE,
    notes VARCHAR(255),
    checked_at TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uk_attendances_student_meeting UNIQUE (student_id, meeting_id),
    CONSTRAINT fk_attendances_student
        FOREIGN KEY (student_id) REFERENCES students(id),
    CONSTRAINT fk_attendances_meeting
        FOREIGN KEY (meeting_id) REFERENCES meetings(id)
);
