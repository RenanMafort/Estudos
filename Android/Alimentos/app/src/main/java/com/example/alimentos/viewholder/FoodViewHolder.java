package com.example.alimentos.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alimentos.listener.OnListClick;
import com.example.alimentos.R;
import com.example.alimentos.entity.FoodEntity;

public class FoodViewHolder extends RecyclerView.ViewHolder {
    TextView mTextName;
    TextView mTextCalorias;
    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);

        this.mTextName = itemView.findViewById(R.id.text_name);
        this.mTextCalorias = itemView.findViewById(R.id.text_caloria);


    }

    public void bind (FoodEntity foodEntity, OnListClick listClick){
        this.mTextName.setText(foodEntity.getName());
        this.mTextCalorias.setText(String.valueOf(foodEntity.getCalories()));


        this.mTextName.setOnClickListener((v) -> listClick.onClick(foodEntity.getId()));

    }
}
