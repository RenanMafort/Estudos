package com.example.alimentos.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.alimentos.listener.OnListClick;
import com.example.alimentos.R;
import com.example.alimentos.adapter.FoodAdapter;
import com.example.alimentos.busines.FoodBusines;
import com.example.alimentos.constants.FoodConstants;
import com.example.alimentos.entity.FoodEntity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewHolder viewHolder = new ViewHolder();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<FoodEntity> list = new FoodBusines().getList();

        // Obter a recycler view
        viewHolder.mRecyclerFood = findViewById(R.id.recycler_food);

        OnListClick foodListener = id -> {
            Bundle bundle = new Bundle();
            bundle.putInt(FoodConstants.FOOD_ID,id);

            Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        };

        // 2 - Definir um adapter
        FoodAdapter adapter = new FoodAdapter(list,foodListener);
        this.viewHolder.mRecyclerFood.setAdapter(adapter);

        // 3 - definir um layout
        this.viewHolder.mRecyclerFood.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.action_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private static class ViewHolder{
        RecyclerView mRecyclerFood;
    }
}