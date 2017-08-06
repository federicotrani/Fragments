package com.example.ftrani.fragments;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbarMain);
        tabLayout = (TabLayout) findViewById(R.id.tabLayoutMain);
        viewPager = (ViewPager) findViewById(R.id.viewPagerMain);

        setupViewPager();

        if(toolbar!=null){
            setSupportActionBar(toolbar);
        }
    }

    private ArrayList<Fragment> agregarFragments(){
        fragments = new ArrayList<>();
        fragments.add(new FragmentListaContactos());
        fragments.add(new FragmentDetalleContacto());

        return fragments;
    }

    private void setupViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        //tabLayout.getTabAt(0).setText("Inicio");
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_chat);
        //tabLayout.getTabAt(1).setText("Detalle");
    }
}
