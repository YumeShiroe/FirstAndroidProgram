package com.example.firstandroidprogram;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText InputFirstNumber;
    private EditText InputSecondNumber;
    private TextView TextResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputFirstNumber = findViewById(R.id.InputFirstNumber);
        InputSecondNumber = findViewById(R.id.InputSecondNumber);
        TextResult = findViewById(R.id.ResultText);

        Button PlusButton = findViewById(R.id.PlusButton);
        Button MinusButton = findViewById(R.id.MinusButton);
        Button MulButton = findViewById(R.id.MulButton);
        Button DivButton = findViewById(R.id.DivButton);

        PlusButton.setOnClickListener(v -> calculate("+"));
        MinusButton.setOnClickListener(v -> calculate("-"));
        MulButton.setOnClickListener(v -> calculate("*"));
        DivButton.setOnClickListener(v -> calculate("/"));
    }

    private void calculate(String operator) {

        int num1 = Integer.parseInt(InputFirstNumber.getText().toString());
        int num2 = Integer.parseInt(InputSecondNumber.getText().toString());

        int res = 0;

        if(operator.equals("+"))
            res = num1 + num2;

        if(operator.equals("-"))
            res = num1 - num2;

        if(operator.equals("*"))
            res = num1 * num2;

        if(operator.equals("/")) {

            if(num2 == 0) {
                TextResult.setText("Cannot divide by 0");
                return;
            }

            res = num1 / num2;
        }

        TextResult.setText("Result: " + res);
    }
}