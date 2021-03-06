package com.example.zuoo.projektpola;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

class Circle {
    protected double r;

    Circle(double _r) {
        r = _r;
    }

    double area() {
        return Math.PI * r * r;
    }
}


public class CircleActivity extends AppCompatActivity {
    public final static String CIRCLE_RESULT = "Area";
    private Circle C;

    Circle parse() {
        double r = Double.parseDouble(((EditText) findViewById(R.id.rCircleEditText)).getText().toString());
        return new Circle(r);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        ((Button) findViewById(R.id.circleCalcButton)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            C = parse();
                            ((TextView) findViewById(R.id.circleResultTextView)).setText(Double.toString(C.area()));
                        } catch (NumberFormatException e) {
                            Toast.makeText(CircleActivity.this, "Niepoprawna długość promienia!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

        );
        ((Button) findViewById(R.id.backAndAddButton)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            C = parse();
                            Double result = C.area();
                            Intent backIntent = new Intent();
                            backIntent.putExtra(CIRCLE_RESULT, result);
                            setResult(RESULT_OK, backIntent);
                            finish();
                        } catch (NumberFormatException e) {
                            Toast.makeText(CircleActivity.this, "Niepoprawna długość promienia!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

        );
        ((Button) findViewById(R.id.backButton)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent backIntent = new Intent();
                        backIntent.putExtra(CIRCLE_RESULT, "0.0");
                        setResult(RESULT_OK, backIntent);
                        finish();
                    }
                }

        );
    }

    @Override
    public void onBackPressed() {
        Intent backIntent = new Intent();
        backIntent.putExtra(CIRCLE_RESULT, "0.0");
        setResult(RESULT_OK, backIntent);
        finish();
    }
}

