package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText firstNumber;
    private EditText secondNumber;

    private ImageButton addButton;
    private ImageButton subtractButton;
    private ImageButton multiplyButton;
    private ImageButton divideButton;
    private TextView resultTextView;
    private TextView errorTextView;

    private double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumber = findViewById(R.id.first_number);
        secondNumber = findViewById(R.id.second_number);
        addButton = findViewById(R.id.add_button);
        subtractButton = findViewById(R.id.subtract_button);
        multiplyButton = findViewById(R.id.multiply_button);
        divideButton = findViewById(R.id.divide_button);
        resultTextView = findViewById(R.id.result);
        errorTextView = findViewById(R.id.error);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = Double.valueOf(firstNumber.getText().toString()) + Double.valueOf(secondNumber.getText().toString());
                Log.d("TAG", "onClick: result : " + result);
                resultTextView.setText(String.valueOf(result));
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = Double.valueOf(firstNumber.getText().toString()) - Double.valueOf(secondNumber.getText().toString());
                resultTextView.setText(String.valueOf(result));
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = Double.valueOf(firstNumber.getText().toString()) * Double.valueOf(secondNumber.getText().toString());
                resultTextView.setText(String.valueOf(result));
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double resultForDivision;
                if (Double.valueOf(secondNumber.getText().toString()) != 0) {
                    errorTextView.setVisibility(View.INVISIBLE);
                    result = Double.valueOf(firstNumber.getText().toString()) / Double.valueOf(secondNumber.getText().toString());
                    resultTextView.setText(String.valueOf(result));
                }else {
                    errorTextView.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}