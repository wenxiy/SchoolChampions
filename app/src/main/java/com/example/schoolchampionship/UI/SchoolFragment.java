package com.example.schoolchampionship.UI;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.schoolchampionship.Adapter.RecyclerViewAdapter;
import com.example.schoolchampionship.Bean.Entity;
import com.example.schoolchampionship.Bean.School_de;
import com.example.schoolchampionship.Bean.School_icon;
import com.example.schoolchampionship.Bean.School_title;
import com.example.schoolchampionship.R;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;


public class SchoolFragment extends Fragment {
    private RecyclerView recyclerview;
    private List<Entity> entities = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_school, container, false);
        recyclerview = v.findViewById(R.id.school_recyclerview);
        Fresco.initialize(getContext());
        initdate();
        inittablayout();
        return v;
    }

    private void inittablayout() {
    }

    private void changeToAnotherActivity(int position) {
        Bundle args = new Bundle();
        String school = "school";
        args.putInt("position", position);
        args.putString("history",school);
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("mybundle", args);
        startActivity(intent);
    }

    private void initdate() {
        for (int i = 0; i < School_icon.icons.length-1; i++) {
            Entity entity = new Entity();
            entity.setDescription(School_de.de[i]);
            entity.setUri(School_icon.icons[i]);
            entity.setTitle(School_title.title[i]);
            entity.setTime("2020.11.9");
            entities.add(entity);
        }
        adapter = new RecyclerViewAdapter(entities);
        adapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                changeToAnotherActivity(position);
            }
        });
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerview.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}