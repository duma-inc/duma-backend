CREATE TABLE teachers (
    id UUID PRIMARY KEY,
    bio VARCHAR(255),
    profile_picture_url VARCHAR(255),
    timezone VARCHAR(255),
    is_active BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_teachers_user
        FOREIGN KEY (id) REFERENCES users(id)
);
