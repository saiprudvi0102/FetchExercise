package com.exam.fetchexercise.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.exam.fetchexercise.R;
import com.exam.fetchexercise.adapter.ItemAdapter;
import com.exam.fetchexercise.repository.ItemRepository;

public class MainActivity extends AppCompatActivity {
    private ItemAdapter adapter;
    private ItemRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ItemAdapter();
        recyclerView.setAdapter(adapter);

        repository = new ItemRepository();

        repository.getItemsLiveData().observe(this, items -> {
            if (items != null && !items.isEmpty()) {
                adapter.updateItems(items);
            } else {
                Toast.makeText(this,
                        items == null ? "Error loading data" : "No items found",
                        Toast.LENGTH_SHORT).show();
            }
        });

        repository.fetchItems();
    }
}