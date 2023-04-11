package com.example.mobilehealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import services.FragmentService;
import viewmodels.MainActivityVM;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView menu;
    private FrameLayout frameLayout;

    public NavController navController;
    private TextView tvFragmentName;
    private Toolbar toolbarMain;
    private String fragmentName;
    private int fragmentColor;
    private MainActivityVM vm;

    public void setFragmentColor(int fragmentColor) {
        this.fragmentColor = fragmentColor;
        toolbarMain.setBackgroundColor(fragmentColor);
    }

    public void setFragmentName(String fragmentName) {
        this.fragmentName = fragmentName;
        tvFragmentName.setText(fragmentName);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //сокрытие экшнбара активности
        getSupportActionBar().hide();
        init();

//        FragmentService.currentFragmentTitle = getString(R.string.main_page);
//        FragmentService.currentFragmentColor = getColor(R.color.black);
//        FragmentService.setFragment(this, new MainFragment(), R.id.main_frameLayout);
        menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.homeMenuItem:
                        navController.navigate(R.id.mainFragment);
                        return true;
                    case R.id.profileMenuItem:
                        navController.navigate(R.id.profileFragment);
                        return true;
                }
                return false;

            }
        });
//        menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @SuppressLint("NonConstantResourceId")
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    //нажатие на кнопку главной
//                    case R.id.homeMenuItem:
//                        FragmentService.currentFragmentTitle = getString(R.string.main_page);
//                        FragmentService.currentFragmentColor = getColor(R.color.black);
//                        FragmentService.setFragment(MainActivity.this, new MainFragment(), R.id.main_frameLayout);
//                        return true;
//                        //нажатие на кнопку профиля
//                    case R.id.profileMenuItem:
//                        FragmentService.currentFragmentTitle = getString(R.string.profile_page);
//                        FragmentService.currentFragmentColor = getColor(R.color.black);
//                        FragmentService.setFragment(MainActivity.this, new ProfileFragment(), R.id.main_frameLayout);
//                        return true;
//                }
//                return false;
//            }
//        });
    }

    private void init(){
//        frameLayout = findViewById(R.id.main_frameLayout);
        navController = Navigation.findNavController(this, R.id.nav_host);
        tvFragmentName = findViewById(R.id.tvFragmentName);
        toolbarMain = findViewById(R.id.toolbar);
        menu = findViewById(R.id.bottomNavigationView);
//        vm = new ViewModelProvider(this).get(MainActivityVM.class);
    }
}