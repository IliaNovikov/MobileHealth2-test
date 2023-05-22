package com.example.mobilehealth;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilehealth.adapters.SelectedWorkoutExerciseAdapter;

import java.util.List;

import globalvalues.GlobalValues;
import models.Exercise;
import models.structures.ExerciseLevels;
import repositories.ExerciseRepository;

public class WorkoutExercisesFragment extends Fragment {

    private RecyclerView rvExercises;
    private List<Exercise> exercises;
    public WorkoutExercisesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workout_exercises, container, false);
        rvExercises = view.findViewById(R.id.rvWorkoutExercises);
        if(GlobalValues.ExerciseType.equals("breast"))
            exercises = ExerciseRepository.loadBreastExercisesList();
        SelectedWorkoutExerciseAdapter selectedWorkoutExerciseAdapter = new SelectedWorkoutExerciseAdapter(getContext(), exercises);
        rvExercises.setLayoutManager(new LinearLayoutManager(getContext()));
        rvExercises.setAdapter(selectedWorkoutExerciseAdapter);
        return view;
    }
}