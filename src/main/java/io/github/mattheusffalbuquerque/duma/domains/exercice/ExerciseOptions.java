package io.github.mattheusffalbuquerque.duma.domains.exercice;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "exercise_options")
public class ExerciseOptions {

    private String id;
    private String text;
    private boolean isCorrect;

}
