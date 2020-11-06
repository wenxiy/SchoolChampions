package com.example.schoolchampionship.UI;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.schoolchampionship.Adapter.ViewpageAdapter;
import com.example.schoolchampionship.R;
import com.google.android.material.tabs.TabLayout;

public class HistoryFragment extends Fragment {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ViewpageAdapter viewpageAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_study,container,false);
        toolbar =  v.findViewById(R.id.toolbar);
        viewPager = v.findViewById(R.id.viewpager);
        tabLayout = v.findViewById(R.id.tablayout);
        inittablayout();
        return v;
    }

    private void inittablayout() {
        tabLayout.addTab(tabLayout.newTab().setText("历史知识板块"));
        tabLayout.addTab(tabLayout.newTab().setText("时政知识板块"));
        tabLayout.addTab(tabLayout.newTab().setText("校园知识板块"));
        viewPager.setAdapter(viewpageAdapter);

    }

}