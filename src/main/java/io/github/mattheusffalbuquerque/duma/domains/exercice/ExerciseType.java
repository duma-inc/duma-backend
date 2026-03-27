package io.github.mattheusffalbuquerque.duma.domains.exercice;

/**
 * Enum representing the types of exercises available in the system.
 */

/*
    Multiple Choice: A question with several options, where only one is correct.
    True/False: A statement that the user must identify as true or false.
    Translation: An exercise where the user must translate a word or phrase from one language to another.
    Fill in the Blank: A sentence with a missing word or phrase that the user must fill in.
    Matching: An exercise where the user must match items from two lists (e.g., words and their definitions).
    Short Answer: A question that requires a brief written response.
    Essay: A question that requires a longer, more detailed written response.
*/

public enum ExerciseType {
    MULTIPLE_CHOICE,
    TRUE_FALSE,
    TRANSLATION,
    FILL_IN_THE_BLANK,
    MATCHING,
    SHORT_ANSWER,
    ESSAY,
}
