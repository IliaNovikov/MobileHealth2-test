package com.example.mobilehealth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import org.w3c.dom.Text;

import viewmodels.PFCFragmentVM;
import viewmodels.factories.PFCFragmentVMFactory;

public class PFCFragment extends Fragment {

    private View view;

    private TextView tvProtein;
    private TextView tvFat;
    private TextView tvCarb;

    private ProgressBar pbProtein;
    private ProgressBar pbFat;
    private ProgressBar pbCarb;

    private EditText etProtein;
    private EditText etFat;
    private EditText etCarb;

    private Button btnAdd;

    private PFCFragmentVM vm;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pfc, container, false);
        init();
        vm = new ViewModelProvider(getActivity(), new PFCFragmentVMFactory(getActivity())).get(PFCFragmentVM.class);
            vm.loadData();
            pbProtein.setProgress(vm.proteinCurrent.getValue());
            pbFat.setProgress(vm.fatCurrent.getValue());
            pbCarb.setProgress(vm.carbCurrent.getValue());
        vm.protein.observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvProtein.setText(s);
                pbProtein.setMax(Integer.valueOf(s.split("/")[1]));
            }
        });

        vm.fat.observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvFat.setText(s);
                pbFat.setMax(Integer.valueOf(s.split("/")[1]));
            }
        });

        vm.carb.observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvCarb.setText(s);
                pbCarb.setMax(Integer.valueOf(s.split("/")[1]));
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vm.proteinCurrent.setValue(vm.proteinCurrent.getValue() + Integer.valueOf(etProtein.getText().toString()));
                vm.fatCurrent.setValue(vm.fatCurrent.getValue() + Integer.valueOf(etFat.getText().toString()));
                vm.carbCurrent.setValue(vm.carbCurrent.getValue() + Integer.valueOf(etCarb.getText().toString()));
                pbProtein.setProgress(vm.proteinCurrent.getValue());
                pbFat.setProgress(vm.fatCurrent.getValue());
                pbCarb.setProgress(vm.carbCurrent.getValue());
                vm.saveData();
                vm.loadData();
            }
        });
        return view;
    }
    private void init(){
        tvProtein = view.findViewById(R.id.tvProteinCounter);
        tvFat = view.findViewById(R.id.tvFatCounter);
        tvCarb = view.findViewById(R.id.tvCarbsCounter);

        pbProtein = view.findViewById(R.id.pbProtein);
        pbFat = view.findViewById(R.id.pbFat);
        pbCarb = view.findViewById(R.id.pbCarbs);

        etProtein = view.findViewById(R.id.etProtein);
        etFat = view.findViewById(R.id.etFat);
        etCarb = view.findViewById(R.id.etCarbs);

        btnAdd = view.findViewById(R.id.btnAddPfc);
    }
}
