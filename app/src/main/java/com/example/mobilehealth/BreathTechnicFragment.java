package com.example.mobilehealth;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.util.TimeUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mobilehealth.adapters.BreathTechnicAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import models.BreathTechnic;

public class BreathTechnicFragment extends Fragment {

    private RecyclerView rvBreathTechnics;
    private DatabaseReference breathsDatabase;

    private String breathsTechnicName = "";

    private String breathsTechnicContent = "";

    private View view;

    private List<BreathTechnic> breathTechnics = new ArrayList<>();

    private int breathsCount;

    BreathTechnicAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_breath_technic, container, false);
        breathsDatabase = FirebaseDatabase.getInstance().getReference();
        init();
        listInitialization();
        adapter = new BreathTechnicAdapter(getContext(), breathTechnics);
        rvBreathTechnics.setAdapter(adapter);
        return view;
    }
    private void init(){
        rvBreathTechnics = view.findViewById(R.id.rvBreathTechnics);
    }
    private void listInitialization(){

        breathsDatabase.child("BreathTechnics").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                breathsCount = (int) snapshot.getChildrenCount();
                Log.e("breathsCount", String.valueOf(breathsCount));
                for(int i = 1; i <= breathsCount; i++){
                    breathsDatabase.child("BreathTechnics").child("technic" + i).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            if(task.isSuccessful()){
                                breathsTechnicName = String.valueOf(task.getResult().child("Name").getValue());
                                breathsTechnicContent = String.valueOf(task.getResult().child("Content").getValue());
                                Log.e("breathName", breathsTechnicName);
                                Log.e("breathContent", breathsTechnicContent);
                                BreathTechnic breathTechnic = new BreathTechnic(breathsTechnicName, breathsTechnicContent);
                                breathTechnics.add(breathTechnic);
                                adapter.notifyDataSetChanged();
                            }
                            else{
                                Log.e("breath", "error");
                            }
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}