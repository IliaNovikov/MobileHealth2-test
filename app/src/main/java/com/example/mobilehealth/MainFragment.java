package com.example.mobilehealth;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import com.example.mobilehealth.adapters.SectionAdapter;
import interfaces.OnSectionClickInterface;
import models.Section;
import services.FragmentService;

public class MainFragment extends Fragment {

    private List<Section> sections;
    private RecyclerView rvMain;
    private SectionAdapter sectionAdapter;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            listInitialization();
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        init(view);
        rvMain.setAdapter(sectionAdapter);
        rvMain.setLayoutManager(new GridLayoutManager(getContext(), 2));
        return view;
    }
    private void init(View view){
        sections = new ArrayList<>();
        Thread thread = new Thread(runnable);
        thread.run();
        rvMain = view.findViewById(R.id.rvMain);
        FragmentService.currentFragmentColor = getResources().getColor(R.color.black);

        OnSectionClickInterface onSectionClickInterface = new OnSectionClickInterface() {
            @Override
            public void onClick(Section section, int position) {
                FragmentService.currentFragmentTitle = section.getTitle();
                FragmentService.currentFragmentColor = section.getBackgroundColor();
                switch (position){
                    case 0:
                        ((MainActivity)getActivity()).navController.navigate(R.id.action_mainFragment_to_PFCFragment2);
                        break;
                    case 1:
                        ((MainActivity)getActivity()).navController.navigate(R.id.action_mainFragment_to_waterRegimeFragment);
                        break;
                    case 2:
                        ((MainActivity)getActivity()).navController.navigate(R.id.action_mainFragment_to_stepsFragment);
                        break;
                    case 3:
                        ((MainActivity)getActivity()).navController.navigate(R.id.action_mainFragment_to_medsFragment2);
                        break;
                    case 4:
                        ((MainActivity)getActivity()).navController.navigate(R.id.action_mainFragment_to_breathTechnicFragment);
                        break;
                    case 5:
                        ((MainActivity)getActivity()).navController.navigate(R.id.action_mainFragment_to_workoutFragment2);

                }
            }
        };

        sectionAdapter = new SectionAdapter(getContext(), sections, onSectionClickInterface);
    }
    private void listInitialization(){
        sections.add(new Section(R.drawable.pfc_icon, getString(R.string.pfc_page),  getResources().getColor(R.color.pfc_color)));
        sections.add(new Section(R.drawable.water_glass_icon, getString(R.string.wrp_page), getResources().getColor(R.color.water_regime_color)));
        sections.add(new Section(R.drawable.steps_icon, getString(R.string.steps_page), getResources().getColor(R.color.steps_color)));
        sections.add(new Section(R.drawable.medicine, getString(R.string.meds_page), getResources().getColor(R.color.medicine_color)));
        sections.add(new Section(R.drawable.breath_icon, getString(R.string.bt_page), getResources().getColor(R.color.breath_color)));
        sections.add(new Section(R.drawable.workout_icon, getString(R.string.workout_page), getResources().getColor(R.color.workout_color)));
    }
}