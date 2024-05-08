package com.example.alimentos.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.alimentos.R;
import com.example.alimentos.busines.FoodBusines;
import com.example.alimentos.constants.FoodConstants;
import com.example.alimentos.entity.FoodEntity;

public class DetailsActivity extends AppCompatActivity {
    private ViewHolder viewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        //Elementos da Interface
        viewHolder.mTextName = findViewById(R.id.text_name);
        viewHolder.mTextCalories = findViewById(R.id.text_caloria);

        this.getData();
    }

    private void getData(){
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            int anInt = bundle.getInt(FoodConstants.FOOD_ID);
            FoodEntity food = new FoodBusines().getFood(anInt);
            this.viewHolder.mTextName.setText(food.getName());
            this.viewHolder.mTextCalories.setText(String.valueOf(food.getCalories()));
        }
    }
    private static class ViewHolder{
        TextView mTextName;
        TextView mTextCalories;
    }
}