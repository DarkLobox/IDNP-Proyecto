package com.example.idnp_proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class InicioActivity extends AppCompatActivity {

    private TabLayout tabMenu;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        tabMenu = findViewById(R.id.tabMenu);
        viewPager = findViewById(R.id.viewPager);

        tabMenu.setupWithViewPager(viewPager);

        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new FragmentTodas(), "TODAS");
        vpAdapter.addFragment(new FragmentFavoritas(), "FAVORITAS");
        vpAdapter.addFragment(new FragmentCercanas(), "CERCANAS");
        viewPager.setAdapter(vpAdapter);
    }
}