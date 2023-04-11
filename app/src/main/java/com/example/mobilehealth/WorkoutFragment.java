package com.example.mobilehealth;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilehealth.adapters.WorkoutAdapter;

import java.util.ArrayList;
import java.util.List;

import models.Workout;

public class WorkoutFragment extends Fragment {

    private List<Workout> workouts;
    private RecyclerView rvWorkout;
    private WorkoutAdapter workoutAdapter;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_workout, container, false);
        init();
        listInitialization();
        rvWorkout.setAdapter(workoutAdapter);

        return view;
    }

    private void init(){
        rvWorkout = view.findViewById(R.id.rvWorkout);
        workouts = new ArrayList<>();
        workoutAdapter = new WorkoutAdapter(getContext(), workouts);
    }

    private void listInitialization(){
        workouts.add(new Workout(getString(R.string.full_body_workout_title),
                getString(R.string.full_body_workout_short_description), R.drawable.full_body));
        workouts.add(new Workout(getString(R.string.breast_workout_title),
                getString(R.string.breast_workout_short_description), R.drawable.breast_img));
        workouts.add(new Workout(getString(R.string.back_workout_title),
                getString(R.string.back_workout_short_description), R.drawable.back_img));
        workouts.add(new Workout(getString(R.string.abs_workout_title),
                getString(R.string.abs_workout_short_description), R.drawable.abs_img));
        workouts.add(new Workout(getString(R.string.legs_workout_title),
                getString(R.string.legs_workout_short_description), R.drawable.legs_img));
    }
}