package com.example.schoolchampionship.Adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolchampionship.Bean.Entity;
import com.example.schoolchampionship.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.InnerHolder> {
    private List<Entity> entities;
    int expandPosition = -1;

    public RecyclerViewAdapter(List<Entity> entities) {
        this.entities = entities;
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list, parent, false);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        holder.setdata(entities.get(position), position);
        //以下是设置展开的动画体现
//        holder.maver.setVisibility(position == expandPosition ? View.VISIBLE : View.GONE);
//        holder.description.setVisibility(position == expandPosition ? View.VISIBLE : View.GONE);
//        holder.title.setVisibility(position == expandPosition ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        if (entities!=null){
            return entities.size();
        }
            return 0;
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView maver;
        private TextView description;
        private TextView title;
        private int mposition;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            maver = itemView.findViewById(R.id.aver);
            description = itemView.findViewById(R.id.description);
            title = itemView.findViewById(R.id.title);
        }

        public void setdata(Entity entity, int position) {
            mposition = position;
            Uri uri = Uri.parse(entity.getUri());
            maver.setImageURI(uri);
            description.setText(entity.getDescription());
            title.setText(entity.getTitle());
        }
    }
}
