package com.example.recycle_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setupRecycleView();
    }

    private void setupRecycleView() {

        Task task1 = new Task("Clean the house", Difficulty.HARD);
        Task task2 = new Task("Walk the dog", Difficulty.MEDIUM);
        Task task3 = new Task("Dispose the trash", Difficulty.EASY);

        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);

        RecyclerView recyclerView = findViewById(R.id.recTodo);

        TaskAdapter taskAdapter = new TaskAdapter(tasks);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(taskAdapter);

    }


}