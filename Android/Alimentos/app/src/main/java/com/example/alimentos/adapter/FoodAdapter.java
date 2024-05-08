package com.example.alimentos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alimentos.listener.OnListClick;
import com.example.alimentos.R;
import com.example.alimentos.entity.FoodEntity;
import com.example.alimentos.viewholder.FoodViewHolder;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodViewHolder> {

    private List<FoodEntity> mList;
    private OnListClick onListClick;

    public FoodAdapter(List<FoodEntity> mList, OnListClick listClick) {
        this.mList = mList;
        this.onListClick = listClick;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_food,parent,false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        FoodEntity foodEntity = this.mList.get(position);
        holder.bind(foodEntity,onListClick);
    }

    @Override
    public int getItemCount() {
        return this.mList.size();
    }
}
