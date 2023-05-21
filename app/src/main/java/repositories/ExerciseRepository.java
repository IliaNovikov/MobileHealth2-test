package repositories;

import com.example.mobilehealth.R;

import java.util.ArrayList;
import java.util.List;

import models.Exercise;
import models.structures.ExerciseLevels;

public class ExerciseRepository {
    public static List<Exercise> loadBreastExercisesList(){
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(new Exercise("Push ups", 16, R.drawable.common_push_ups, ExerciseLevels.COMMON));
        exercises.add(new Exercise("Push ups from the bench", 16, R.drawable.push_ups_from_the_bench, ExerciseLevels.BEGINNER));
        exercises.add(new Exercise("Diamond push ups", 16, R.drawable.diamond_push_ups, ExerciseLevels.SPORTSMAN));
        exercises.add(new Exercise("Wide push ups", 16, R.drawable.wide_push_ups, ExerciseLevels.COMMON));
        exercises.add(new Exercise("Snake push ups", 16, R.drawable.snake_push_ups, ExerciseLevels.SPORTSMAN));
        return exercises;
    }
}
