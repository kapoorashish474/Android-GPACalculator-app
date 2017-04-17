package com.ashishkapoor.gpacalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class resultDisplay extends AppCompatActivity {

    private TextView Sem_GPA, Cumul_GPA;
    private String semgpa, cumgpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_display);
        init();
        display();
    }

    private void display() {
        // receiving the result from previous page
        semgpa = getIntent().getStringExtra("semgpa");
        cumgpa = getIntent().getStringExtra("cumgpa");

        // displaying the result on this page
        Sem_GPA.setText(semgpa);
        Cumul_GPA.setText(cumgpa);
    }


    private void init() {
        Sem_GPA = (TextView) findViewById(R.id.semGPA);
        Cumul_GPA = (TextView) findViewById(R.id.cumulGPA);

    }
}
