package com.example.mobilehealth;

import static com.example.mobilehealth.R.layout.dialog_add_meds;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mobilehealth.adapters.MedicalsAdapter;

import java.util.ArrayList;
import java.util.List;

import models.Medical;
import viewmodels.MedsFragmentVM;
import viewmodels.factories.MedsFragmentVMFactory;

public class MedsFragment extends Fragment{

    private View view;
    private MedsFragmentVM vm;
    private RecyclerView rvMeds;
    private Button btnAddMeds;
    private List<Medical> medicals = new ArrayList<>();

    private String receptionTime;
    Dialog dialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_meds, container, false);
        vm = new ViewModelProvider(getActivity(), new MedsFragmentVMFactory(getActivity())).get(MedsFragmentVM.class);
        init();
        MedicalsAdapter adapter = new MedicalsAdapter(getContext(), medicals);
        btnAddMeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
        EditText etMedName = dialog.findViewById(R.id.etMedicalName);
        Spinner spnTime = dialog.findViewById(R.id.spnReceptionTime);
        EditText etTime = dialog.findViewById(R.id.etTime);
        EditText etDuration = dialog.findViewById(R.id.etCourseDuration);

        TextView tvTime = dialog.findViewById(R.id.tvTime);

        Button btnSaveMed = dialog.findViewById(R.id.btnSaveMedical);
        Button btnCloseMed = dialog.findViewById(R.id.btnCloseMedical);

        spnTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        etTime.setVisibility(View.GONE);
                        tvTime.setVisibility(View.GONE);
                        receptionTime = "Any";
                        break;
                    case 1:
                        etTime.setVisibility(View.VISIBLE);
                        tvTime.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnCloseMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        btnSaveMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                medicals.add(new Medical(etMedName.getText().toString(), receptionTime, etDuration.getText().toString(), R.drawable.medicine));
                adapter.notifyDataSetChanged();
            }
        });
        rvMeds.setAdapter(adapter);
        return view;
    }
    private void init(){
        rvMeds = view.findViewById(R.id.rvMeds);
        btnAddMeds = view.findViewById(R.id.btnAddMed);
        dialog = new Dialog(getActivity());
        dialog.setContentView(dialog_add_meds);
    }
}