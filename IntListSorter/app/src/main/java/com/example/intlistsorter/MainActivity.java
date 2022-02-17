package com.example.intlistsorter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Build;
import android.os.Bundle;

import com.example.intlistsorter.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    List<String> fAdapterData = new ArrayList<>();
    String userListInput;
    String userSortInput;
    ArrayListAdapter adapter;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupRecView(fAdapterData);

        binding.btnSort.setOnClickListener(view -> {

            userListInput = binding.edtArrayInput.getText().toString();
            userSortInput = binding.edtSortInput.getText().toString();

            fAdapterData = Presenter.filteredList(userListInput, userSortInput);

            setupRecView(fAdapterData);
        });
    }



    private void setupRecView(List<String> data) {


        adapter = new ArrayListAdapter(data);
        binding.recView.setAdapter(adapter);
        binding.recView.setLayoutManager(new LinearLayoutManager(this));
    }
}