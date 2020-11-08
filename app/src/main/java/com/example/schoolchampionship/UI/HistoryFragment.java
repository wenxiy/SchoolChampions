package com.example.schoolchampionship.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.schoolchampionship.Adapter.RecyclerViewAdapter;
import com.example.schoolchampionship.Bean.Entity;
import com.example.schoolchampionship.R;
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

    private void initdate() {
        //模拟数据，稍后用sqlite来实现
        for (int i =1;i<=10;i++) {
        Entity entity = new Entity();
        entity.setDescription("朋友们好，我是混元形意太极掌门人马保国，昨天，有两个年轻人问我说马老师发生什么事了");
        entity.setUri("https://github.com/xingshaocheng.png");
        entity.setTitle("习近平总书记发表重要讲话");
        entity.setTime("2020.11.9");
            entities.add(entity);
        }
        adapter = new RecyclerViewAdapter(entities);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void inittablayout() {
    }

}