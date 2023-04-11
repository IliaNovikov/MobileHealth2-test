package com.example.mobilehealth.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilehealth.R;

import java.util.List;

import models.BreathTechnic;

public class BreathTechnicAdapter extends RecyclerView.Adapter<BreathTechnicAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<BreathTechnic> breathTechnics;

    public BreathTechnicAdapter(Context context, List<BreathTechnic> breathTechnics) {
        inflater = LayoutInflater.from(context);
        this.breathTechnics = breathTechnics;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rv_breath_technic_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BreathTechnic breathTechnic = breathTechnics.get(position);
        holder.tvName.setText(breathTechnic.getName());
        holder.tvContent.setText(breathTechnic.getContent());
    }

    @Override
    public int getItemCount() {
        return breathTechnics.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvName;
        private TextView tvContent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvContent = itemView.findViewById(R.id.tvContent);
        }
    }
}
