package com.agomezlucena.manejodeclientes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.agomezlucena.manejodeclientes.gestion_clientes.adapters.MainActivityFragmentPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout pestañas;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pestañas = findViewById(R.id.activity_main_pestañas);
        viewPager = findViewById(R.id.activity_main_pager);

        MainActivityFragmentPagerAdapter adapter = new MainActivityFragmentPagerAdapter(getSupportFragmentManager(),this);
        viewPager.setAdapter(adapter);

        pestañas.setupWithViewPager(viewPager);
    }
}
