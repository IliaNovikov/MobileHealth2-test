package com.example.mobilehealth;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.time.LocalTime;

import viewmodels.StepsFragmentVM;
import viewmodels.factories.StepsFragmentVMFactory;

public class StepsFragment extends Fragment {
    private StepsFragmentVM vm;
    private TextView tvStepToday;
    private TextView tvStepGoal;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_steps, container, false);
        vm = new ViewModelProvider(getActivity(), new StepsFragmentVMFactory(getActivity())).get(StepsFragmentVM.class);
        tvStepToday = view.findViewById(R.id.tvStepsToday);
        tvStepGoal = view.findViewById(R.id.tvStepsAll);
//        vm.stepCount.observe(getActivity(), new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer aInteger) {
//                tvStepToday.setText(String.valueOf(aInteger));
//            }
//        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Log.e("time", LocalTime.now().toString());
        }
        vm.stepCount.observe(getActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                tvStepToday.setText(String.valueOf(integer));
            }
        });
        vm.stepsToday.observe(getActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                tvStepGoal.setText(String.valueOf(integer));
            }
        });
        return view;
    }

    @Override
    public void onStop() {
        Log.e("stop", "cleared");
        vm.saveData();
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.e("destroy", "cleared");
        super.onDestroy();
    }
}