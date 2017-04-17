package com.ashishkapoor.gpacalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

import javax.xml.transform.Templates;

public class enterScore extends AppCompatActivity {

    private LinearLayout Layout5, Layout6, Layout7, Layout8, Layout9, Layout10, Layout11, Layout12;
    private int count_visible_rows = 5;
    private EditText Credit1, Credit2, Credit3, Credit4, Credit5, Credit6, Credit7, Credit8, Credit9, Credit10, Credit11, Credit12, prev_credits, prev_GPA1, prev_GPA2;
    private Spinner Grade1, Grade2, Grade3, Grade4, Grade5, Grade6, Grade7, Grade8, Grade9, Grade10, Grade11, Grade12;
    private Button add_course, Clear, Calculate;
    private String g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11, g12, temp, previousgrade1, previousgrade2, previousgradecombined;
    private String c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, temp1, previousCredits;
    private String result1, result2;
    private float semgpa = 0.0f, overallgpa = 0.0f;
    private float sum_of_grades = 0.0f, sum_of_credits = 0.0f, sum_of_grades1 = 0.0f, sum_of_credits1 = 0.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_score);
        init();

        Grade1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        Grade2.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        Grade3.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        Grade4.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        Grade5.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        Grade6.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        Grade7.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        Grade8.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        Grade9.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        Grade10.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        Grade11.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        Grade12.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        add_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_row();
            }
        });
        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear_gpa();
            }
        });
        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate_gpa();
            }
        });

    }

    private void calculate_gpa() {

        previousgrade1 = prev_GPA1.getText().toString();
        previousgrade2 = prev_GPA2.getText().toString();
        previousgradecombined = previousgrade1 + "." + previousgrade2;
        previousCredits = prev_credits.getText().toString();

        g1 = String.valueOf(Grade1.getSelectedItem());
        g2 = String.valueOf(Grade2.getSelectedItem());
        g3 = String.valueOf(Grade3.getSelectedItem());
        g4 = String.valueOf(Grade4.getSelectedItem());
        g5 = String.valueOf(Grade5.getSelectedItem());
        g6 = String.valueOf(Grade6.getSelectedItem());
        g7 = String.valueOf(Grade7.getSelectedItem());
        g8 = String.valueOf(Grade8.getSelectedItem());
        g9 = String.valueOf(Grade9.getSelectedItem());
        g10 = String.valueOf(Grade10.getSelectedItem());
        g11 = String.valueOf(Grade11.getSelectedItem());
        g12 = String.valueOf(Grade12.getSelectedItem());
        c1 = Credit1.getText().toString();
        c2 = Credit2.getText().toString();
        c3 = Credit3.getText().toString();
        c4 = Credit4.getText().toString();
        c5 = Credit5.getText().toString();
        c6 = Credit6.getText().toString();
        c7 = Credit7.getText().toString();
        c8 = Credit8.getText().toString();
        c9 = Credit9.getText().toString();
        c10 = Credit10.getText().toString();
        c11 = Credit11.getText().toString();
        c12 = Credit12.getText().toString();


        if ((!g1.isEmpty() && c1.isEmpty()) || (g1.isEmpty() && !c1.isEmpty())
                || (!g2.isEmpty() && c2.isEmpty()) || (g2.isEmpty() && !c2.isEmpty())
                || (!g3.isEmpty() && c3.isEmpty()) || (g3.isEmpty() && !c3.isEmpty())
                || (!g4.isEmpty() && c4.isEmpty()) || (g4.isEmpty() && !c4.isEmpty())
                || (!g5.isEmpty() && c5.isEmpty()) || (g5.isEmpty() && !c5.isEmpty())
                || (!g6.isEmpty() && c6.isEmpty()) || (g6.isEmpty() && !c6.isEmpty())
                || (!g7.isEmpty() && c7.isEmpty()) || (g7.isEmpty() && !c7.isEmpty())
                || (!g8.isEmpty() && c8.isEmpty()) || (g8.isEmpty() && !c8.isEmpty())
                || (!g9.isEmpty() && c9.isEmpty()) || (g9.isEmpty() && !c9.isEmpty())
                || (!g10.isEmpty() && c10.isEmpty()) || (g10.isEmpty() && !c10.isEmpty())
                || (!g11.isEmpty() && c11.isEmpty()) || (g11.isEmpty() && !c11.isEmpty())
                || (!g12.isEmpty() && c12.isEmpty()) || (g12.isEmpty() && !c12.isEmpty())
                || (!(previousgrade1.isEmpty()&& previousgrade2.isEmpty()) && previousCredits.isEmpty())
                || ((previousgrade1.isEmpty() && previousgrade2.isEmpty()) && !previousCredits.isEmpty())) {

            Toast.makeText(getBaseContext(), "Please Enter both Grade and Credits", Toast.LENGTH_LONG).show();
        } else {

            if (previousgradecombined.equals(".")){ previousgradecombined="0.000";}
            if (previousCredits.isEmpty()){ previousCredits="0";}
            if (Float.valueOf(previousgradecombined) < 4.001) {
                g1 = convert_gpa(g1);
                g2 = convert_gpa(g2);
                g3 = convert_gpa(g3);
                g4 = convert_gpa(g4);
                g5 = convert_gpa(g5);
                g6 = convert_gpa(g6);
                g7 = convert_gpa(g7);
                g8 = convert_gpa(g8);
                g9 = convert_gpa(g9);
                g10 = convert_gpa(g10);
                g11 = convert_gpa(g11);
                g12 = convert_gpa(g12);
                c1 = convert_credits(c1);
                c2 = convert_credits(c2);
                c3 = convert_credits(c3);
                c4 = convert_credits(c4);
                c5 = convert_credits(c5);
                c6 = convert_credits(c6);
                c7 = convert_credits(c7);
                c8 = convert_credits(c8);
                c9 = convert_credits(c9);
                c10 = convert_credits(c10);
                c11 = convert_credits(c11);
                c12 = convert_credits(c12);

                // Multiplication of grades with credits  eg: 3 credits course has grade A then sum_of_grade will be 12
                sum_of_grades = ((Float.valueOf(g1) * Float.valueOf(c1)) +
                        (Float.valueOf(g2) * Float.valueOf(c2)) +
                        (Float.valueOf(g3) * Float.valueOf(c3)) +
                        (Float.valueOf(g4) * Float.valueOf(c4)) +
                        (Float.valueOf(g5) * Float.valueOf(c5)) +
                        (Float.valueOf(g6) * Float.valueOf(c6)) +
                        (Float.valueOf(g7) * Float.valueOf(c7)) +
                        (Float.valueOf(g8) * Float.valueOf(c8)) +
                        (Float.valueOf(g9) * Float.valueOf(c9)) +
                        (Float.valueOf(g10) * Float.valueOf(c10)) +
                        (Float.valueOf(g11) * Float.valueOf(c11)) +
                        (Float.valueOf(g12) * Float.valueOf(c12)));
                // sum of all the credits
                sum_of_credits = ((Float.valueOf(c1) + Float.valueOf(c2) + Float.valueOf(c3)) + Float.valueOf(c4)
                        + Float.valueOf(c5) + Float.valueOf(c6) + Float.valueOf(c7) + Float.valueOf(c8)
                        + Float.valueOf(c9) + Float.valueOf(c10) + Float.valueOf(c11) + Float.valueOf(c12));
                // This semester gpa
                semgpa = (sum_of_grades / sum_of_credits);

                sum_of_grades1 = (Float.valueOf(previousgradecombined) * Float.valueOf(previousCredits));
                sum_of_credits1 = Float.valueOf(previousCredits);

                overallgpa = ((sum_of_grades + sum_of_grades1) / (sum_of_credits + sum_of_credits1));

                result1 = String.format("%.3f", semgpa);
                result2 = String.format("%.3f", overallgpa);

                if(result1.equals("NaN")){result1 = "0.000";}
                if(result2.equals("NaN")){result2 = "0.000";}

                Intent intentresult = new Intent(this, resultDisplay.class);
                intentresult.putExtra("semgpa", result1);
                intentresult.putExtra("cumgpa", result2);
                startActivity(intentresult);
            }else {
                Toast.makeText(getBaseContext(), "Previous GPA cannot be more than 4.0", Toast.LENGTH_SHORT).show();
            }
        }

    }


    private String convert_credits(String stri) {

        temp1 = stri;

        if (temp1.isEmpty()) {
            temp1 = "0";
        }
        return temp1;
    }


    private String convert_gpa(String str) {

        temp = str;

        if (temp.equals("A")) {
            temp = "4";
        } else if (temp.equals("A-")) {
            temp = "3.7";
        } else if (temp.equals("B+")) {
            temp = "3.3";
        } else if (temp.equals("B")) {
            temp = "3.0";
        } else if (temp.equals("B-")) {
            temp = "2.7";
        } else if (temp.equals("C+")) {
            temp = "2.3";
        } else if (temp.equals("C")) {
            temp = "2.0";
        } else if (temp.equals("C-")) {
            temp = "1.7";
        } else if (temp.equals("D+")) {
            temp = "1.3";
        } else if (temp.equals("D")) {
            temp = "1";
        } else if (temp.equals("D-")) {
            temp = "0.7";
        } else if (temp.equals("F")) {
            temp = "0.0";
        } else {
            temp = "0";
        }

        return temp;
    }

    private void clear_gpa() {

        count_visible_rows = 5;
        Grade1.setSelection(0);
        Grade2.setSelection(0);
        Grade3.setSelection(0);
        Grade4.setSelection(0);
        Grade5.setSelection(0);
        Grade6.setSelection(0);
        Grade7.setSelection(0);
        Grade8.setSelection(0);
        Grade9.setSelection(0);
        Grade10.setSelection(0);
        Grade11.setSelection(0);
        Grade12.setSelection(0);
        Credit1.setText("");
        Credit2.setText("");
        Credit3.setText("");
        Credit4.setText("");
        Credit5.setText("");
        Credit6.setText("");
        Credit7.setText("");
        Credit8.setText("");
        Credit9.setText("");
        Credit10.setText("");
        Credit11.setText("");
        Credit12.setText("");
        prev_credits.setText("");
        prev_GPA1.setText("");
        prev_GPA2.setText("");

        Layout5.setVisibility(View.GONE);
        Layout6.setVisibility(View.GONE);
        Layout7.setVisibility(View.GONE);
        Layout8.setVisibility(View.GONE);
        Layout9.setVisibility(View.GONE);
        Layout10.setVisibility(View.GONE);
        Layout11.setVisibility(View.GONE);
        Layout12.setVisibility(View.GONE);

    }

    private void init() {
        Layout5 = (LinearLayout) findViewById(R.id.layout5);
        Layout6 = (LinearLayout) findViewById(R.id.layout6);
        Layout7 = (LinearLayout) findViewById(R.id.layout7);
        Layout8 = (LinearLayout) findViewById(R.id.layout8);
        Layout9 = (LinearLayout) findViewById(R.id.layout9);
        Layout10 = (LinearLayout) findViewById(R.id.layout10);
        Layout11 = (LinearLayout) findViewById(R.id.layout11);
        Layout12 = (LinearLayout) findViewById(R.id.layout12);
        Credit1 = (EditText) findViewById(R.id.credit1);
        Credit2 = (EditText) findViewById(R.id.credit2);
        Credit3 = (EditText) findViewById(R.id.credit3);
        Credit4 = (EditText) findViewById(R.id.credit4);
        Credit5 = (EditText) findViewById(R.id.credit5);
        Credit6 = (EditText) findViewById(R.id.credit6);
        Credit7 = (EditText) findViewById(R.id.credit7);
        Credit8 = (EditText) findViewById(R.id.credit8);
        Credit9 = (EditText) findViewById(R.id.credit9);
        Credit10 = (EditText) findViewById(R.id.credit10);
        Credit11 = (EditText) findViewById(R.id.credit11);
        Credit12 = (EditText) findViewById(R.id.credit12);
        Grade1 = (Spinner) findViewById(R.id.grade1);
        Grade2 = (Spinner) findViewById(R.id.grade2);
        Grade3 = (Spinner) findViewById(R.id.grade3);
        Grade4 = (Spinner) findViewById(R.id.grade4);
        Grade5 = (Spinner) findViewById(R.id.grade5);
        Grade6 = (Spinner) findViewById(R.id.grade6);
        Grade7 = (Spinner) findViewById(R.id.grade7);
        Grade8 = (Spinner) findViewById(R.id.grade8);
        Grade9 = (Spinner) findViewById(R.id.grade9);
        Grade10 = (Spinner) findViewById(R.id.grade10);
        Grade11 = (Spinner) findViewById(R.id.grade11);
        Grade12 = (Spinner) findViewById(R.id.grade12);
        add_course = (Button) findViewById(R.id.addCourse);
        Clear = (Button) findViewById(R.id.clear);
        Calculate = (Button) findViewById(R.id.calculate);
        prev_credits = (EditText) findViewById(R.id.prevCredits);
        prev_GPA1 = (EditText) findViewById(R.id.pre_gpa1);
        prev_GPA2 = (EditText) findViewById(R.id.pre_gpa2);

    }

    private void add_row() {

        if (count_visible_rows == 5) {
            Layout5.setVisibility(View.VISIBLE);
        } else if (count_visible_rows == 6) {
            Layout6.setVisibility(View.VISIBLE);
        } else if (count_visible_rows == 7) {
            Layout7.setVisibility(View.VISIBLE);
        } else if (count_visible_rows == 8) {
            Layout8.setVisibility(View.VISIBLE);
        } else if (count_visible_rows == 9) {
            Layout9.setVisibility(View.VISIBLE);
        } else if (count_visible_rows == 10) {
            Layout10.setVisibility(View.VISIBLE);
        } else if (count_visible_rows == 11) {
            Layout11.setVisibility(View.VISIBLE);
        } else if (count_visible_rows == 12) {
            Layout12.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(getBaseContext(), "Max Number of course reached", Toast.LENGTH_SHORT).show();
        }

        count_visible_rows++;
    }


}
