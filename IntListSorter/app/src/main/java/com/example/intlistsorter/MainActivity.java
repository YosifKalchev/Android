package com.example.intlistsorter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> fAdapterData;
    String userListInput;
    String userSortInput;
    EditText fEdtArrayInput;
    EditText fEdtSortInput;
    Button fBtnSort;
    RecyclerView fRecView;
    ArrayListAdapter adapter;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewInit();
        setupRecView(fAdapterData);

        fBtnSort.setOnClickListener(view -> {


            userListInput = fEdtArrayInput.getText().toString();
            userSortInput = fEdtSortInput.getText().toString();

            fAdapterData = Presenter.filteredList(userListInput, userSortInput);

            setupRecView(fAdapterData);
        });
    }



    private void setupRecView(List<String> data) {


        adapter = new ArrayListAdapter(data);
        fRecView.setAdapter(adapter);
        fRecView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void viewInit() {

        fEdtArrayInput = findViewById(R.id.edtArrayInput);
        fEdtSortInput = findViewById(R.id.edtSortInput);
        fBtnSort = findViewById(R.id.btnSort);
        fRecView = findViewById(R.id.recView);
        fAdapterData = new ArrayList<>();
    }
}