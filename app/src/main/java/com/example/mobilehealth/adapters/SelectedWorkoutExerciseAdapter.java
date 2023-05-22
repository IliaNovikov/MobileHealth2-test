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

import org.w3c.dom.Text;

import java.util.List;

import interfaces.OnSectionClickInterface;
import models.Exercise;

public class SelectedWorkoutExerciseAdapter extends RecyclerView.Adapter<SelectedWorkoutExerciseAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Exercise> exercises;

    public SelectedWorkoutExerciseAdapter(Context context, List<Exercise> exercises) {
        this.inflater = LayoutInflater.from(context);
        this.exercises = exercises;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = inflater.inflate(R.layout.rv_selected_workout_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Exercise exercise = exercises.get(position);
        holder.tvTitle.setText(exercise.getTitle());
        holder.tvCount.setText(String.valueOf(exercise.getCount()));
        holder.ivExercise.setImageResource(exercise.getExerciseImage());
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private TextView tvCount;
        private ImageView ivExercise;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvSelectedWorkoutItemTitle);
            tvCount = itemView.findViewById(R.id.tvSelectedWorkoutItemCount);
            ivExercise = itemView.findViewById(R.id.ivSelectedWorkoutItem);
        }
    }
}
