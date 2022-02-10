package com.example.simplecalcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText edtUserInput;
    private Button btnCalculate;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViews();
        displayResult();

    }

    @SuppressLint("SetTextI18n")
    private void displayResult() {
        btnCalculate.setOnClickListener(view -> {


            String userInput = edtUserInput.getText().toString();

            if (userInput.isEmpty()) {
                Toast.makeText(this, "Please, insert a number", Toast.LENGTH_SHORT).show();
            } else {
                txtResult.setText(convertToMeters(userInput) + " meters");
            }
        });
    }

    private String convertToMeters(String userInput) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        double userInputAsDouble = Double.parseDouble(userInput);
        double result = userInputAsDouble * 0.0254;
        return decimalFormat.format(result);
    }

    private void findViews() {

        edtUserInput = findViewById(R.id.edtUserInput);
        btnCalculate = findViewById(R.id.bntCalculate);
        txtResult = findViewById(R.id.txtResult);
    }
}