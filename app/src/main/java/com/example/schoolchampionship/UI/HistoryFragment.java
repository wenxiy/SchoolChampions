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
import com.example.schoolchampionship.Bean.History_de;
import com.example.schoolchampionship.Bean.History_title;
import com.example.schoolchampionship.Bean.Entity;
import com.example.schoolchampionship.R;
import com.example.schoolchampionship.Bean.History_icon;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends Fragment {
    private List<Entity> entities = new ArrayList<>();
    private RecyclerView recyclerview;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_study, container, false);
        recyclerview = v.findViewById(R.id.HistoryFragment);
        Fresco.initialize(getContext());
        initdate();
        inittablayout();
        return v;
    }

    private void changeToAnotherActivity(int position) {
        Bundle args = new Bundle();
        String history = "history";
        args.putInt("position", position);
        args.putString("history", history);
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("mybundle", args);
        startActivity(intent);
    }

    private void initdate() {
        //模拟数据，稍后用sqlite来实现
        for (int i = 0; i < History_icon.icons.length; i++) {
            Entity entity = new Entity();
            entity.setDescription(History_de.de[i]);
            entity.setUri(History_icon.icons[i]);
            entity.setTitle(History_title.title[i]);
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

    private void inittablayout() {
    }

}