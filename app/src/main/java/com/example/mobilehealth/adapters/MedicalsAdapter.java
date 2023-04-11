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

import models.Medical;

public class MedicalsAdapter extends RecyclerView.Adapter<MedicalsAdapter.ViewHolder>{

    private LayoutInflater inflater;
    private List<Medical> meds;

    public MedicalsAdapter(Context context, List<Medical> meds){
        this.inflater = LayoutInflater.from(context);
        this.meds = meds;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rv_medicals_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicalsAdapter.ViewHolder holder, int position) {
        Medical medical = meds.get(position);
        holder.tvMedName.setText(medical.getMedName());
        holder.tvMedReceptionTime.setText(medical.getReceptionTime());
        holder.tvMedReceptionDuration.setText(medical.getReceptionDuration());
        holder.tvMedsRemainingDays.setText(medical.getReceptionDaysRemaining());
        holder.ivMedsType.setImageResource(medical.getImg());
    }

    @Override
    public int getItemCount() {
        return meds.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvMedName;
        private TextView tvMedReceptionTime;
        private TextView tvMedReceptionDuration;
        private TextView tvMedsRemainingDays;
        private ImageView ivMedsType;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMedName = itemView.findViewById(R.id.tvMedName);
            tvMedReceptionTime = itemView.findViewById(R.id.tvMedReceptionTime);
            tvMedReceptionDuration = itemView.findViewById(R.id.tvMedReceptionDuration);
            tvMedsRemainingDays = itemView.findViewById(R.id.tvMedsRemainingDays);
            ivMedsType = itemView.findViewById(R.id.ivMedsType);
        }
    }
}
