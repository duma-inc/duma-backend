package io.github.mattheusffalbuquerque.duma.domains.student.dto;

public record CreateStudentRequest(

    String userId,  // ← apenas o ID
    String bio,
    String profilePictureUrl

) {}
