package com.example.mobilehealth.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilehealth.R;

import java.util.List;

import interfaces.OnWorkoutClickInterface;
import models.Workout;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Workout> workouts;
    private OnWorkoutClickInterface onWorkoutClickInterface;

    public WorkoutAdapter(Context context, List<Workout> workouts, OnWorkoutClickInterface onWorkoutClickInterface) {
        this.inflater = LayoutInflater.from(context);
        this.workouts = workouts;
        this.onWorkoutClickInterface = onWorkoutClickInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rv_workout_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Workout workout = workouts.get(position);
        holder.tvTitle.setText(workout.getTitle());
        holder.tvShortDescription.setText(workout.getShortDescription());
        holder.ivImage.setImageResource(workout.getImg());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onWorkoutClickInterface.onClick(workout, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return workouts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private TextView tvShortDescription;
        private ImageView ivImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvWorkoutTitle);
            tvShortDescription = itemView.findViewById(R.id.tvWorkoutShortDescription);
            ivImage = itemView.findViewById(R.id.ivWorkout);
        }
    }
}
