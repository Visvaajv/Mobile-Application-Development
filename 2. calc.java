package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Defining the Views
    EditText Num1;
    EditText Num2;
    Button Add;
    Button Sub;
    Button Mul;
    Button Div;
    TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referring the Views
        Num1 = findViewById(R.id.editText1);
        Num2 = findViewById(R.id.editText2);
        Add = findViewById(R.id.Add);
        Sub = findViewById(R.id.Sub);
        Mul = findViewById(R.id.Mul);
        Div = findViewById(R.id.Div);
        Result = findViewById(R.id.textView);

        // Set listeners for buttons
        Add.setOnClickListener(this);
        Sub.setOnClickListener(this);
        Mul.setOnClickListener(this);
        Div.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String oper = "";
        double result = 0;

        // Get the values from EditText and convert them to numbers
        String input1 = Num1.getText().toString();
        String input2 = Num2.getText().toString();

        // Check if inputs are empty
        if (input1.isEmpty() || input2.isEmpty()) {
            Result.setText("Please enter valid numbers");
            return;
        }

        double num1 = Double.parseDouble(input1);
        double num2 = Double.parseDouble(input2);

        // Replacing switch with if statements
        if (v.getId() == R.id.Add) {
            oper = "+";
            result = num1 + num2;
        } else if (v.getId() == R.id.Sub) {
            oper = "-";
            result = num1 - num2;
        } else if (v.getId() == R.id.Mul) {
            oper = "*";
            result = num1 * num2;
        } else if (v.getId() == R.id.Div) {
            if (num2 != 0) {
                oper = "/";
                result = num1 / num2;
            } else {
                Result.setText("Cannot divide by zero");
                return;
            }
        }

        // Display result or operation
        Result.setText("Operation: " + oper + "\nResult: " + result);
    }
}
