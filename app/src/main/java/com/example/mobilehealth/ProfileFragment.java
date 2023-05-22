package com.example.mobilehealth;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;

import viewmodels.ProfileFragmentVM;
import viewmodels.factories.ProfileFragmentVMFactory;


public class ProfileFragment extends Fragment {

    View view;
    private EditText etName;
    private EditText etHeight;
    private EditText etWeight;
    private EditText etDateBirth;
    private CalendarView cvDateBirth;
    private Button btnSave;
    private ImageButton btnSettings;

    private ProfileFragmentVM vm;

    public ProfileFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        init();
        vm = new ViewModelProvider(getActivity(), new ProfileFragmentVMFactory(getActivity())).get(ProfileFragmentVM.class);
        vm.name.observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                etName.setText(s);
            }

        });

        vm.height.observe(getActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                etHeight.setText(String.valueOf(integer));
            }
        });

        vm.weight.observe(getActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                etWeight.setText(String.valueOf(integer));
            }
        });

        vm.birthDate.observe(getActivity(), new Observer<Long>() {
            @Override
            public void onChanged(Long date) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    etDateBirth.setText(String.valueOf(Instant.ofEpochMilli(date).atZone(ZoneId.systemDefault()).toLocalDate()));
                }
                cvDateBirth.setDate(date);
            }
        });

        cvDateBirth.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                vm.birthDate.setValue(new GregorianCalendar(i, i1, i2).getTimeInMillis());
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!etName.getText().toString().isEmpty() && !etHeight.getText().toString().isEmpty() && !etHeight.getText().equals("0")
                && !etWeight.getText().toString().isEmpty() && !etWeight.getText().equals("0") && !etDateBirth.getText().toString().isEmpty()) {
                    vm.name.setValue(etName.getText().toString());
                    vm.height.setValue(Integer.valueOf(etHeight.getText().toString()));
                    vm.weight.setValue(Integer.valueOf(etWeight.getText().toString()));
                    vm.saveData();
                    Toast.makeText(getActivity(), R.string.successful_save, Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getActivity(), R.string.empty_fields, Toast.LENGTH_SHORT).show();
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.dialog_settings);
                dialog.show();
            }
        });

        return view;
    }

    private void init(){
        etName = view.findViewById(R.id.etName);
        etHeight = view.findViewById(R.id.etHeight);
        etWeight = view.findViewById(R.id.etWeight);
        etDateBirth = view.findViewById(R.id.etDate);
        cvDateBirth = view.findViewById(R.id.cvDateBirth);
        btnSave = view.findViewById(R.id.btnSave);
        btnSettings = view.findViewById(R.id.btnSettings);
    }
}