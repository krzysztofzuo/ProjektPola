package com.example.zuoo.projektpola;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

class Triangle {
    protected double a, b, c;

    Triangle(double _a, double _b, double _c) {
        a = _a;
        b = _b;
        c = _c;
    }

    double area() {
        double p = (a + b + c) / 2.0;
        double w = (p - a) * (p - b) * (p - c) * p;
        return Math.sqrt(w);
    }
}


public class TriangleActivity extends AppCompatActivity {
    private Triangle T;
    public final static String TRIANGLE_RESULT = "Area";

    Triangle parse() {
        double a = Double.parseDouble(((EditText) findViewById(R.id.aTriangleEditText)).getText().toString());
        double b = Double.parseDouble(((EditText) findViewById(R.id.bTriangleEditText)).getText().toString());
        double c = Double.parseDouble(((EditText) findViewById(R.id.cTriangleEditText)).getText().toString());
        return new Triangle(a, b, c);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);

        ((Button) findViewById(R.id.triangleCalcButton)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            T = parse();
                            if (T.a + T.b > T.c && T.b + T.c > T.a && T.c + T.a > T.b) {
                                ((TextView) findViewById(R.id.triangleResultTextView)).setText(Double.toString(T.area()));
                            } else
                                Toast.makeText(TriangleActivity.this, "Niepoprawne boki trójkąta", Toast.LENGTH_SHORT).show();

                        } catch (NumberFormatException e) {
                            Toast.makeText(TriangleActivity.this, "Podaj długości wszystkich boków", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

        );
        ((Button) findViewById(R.id.backAndAddButton)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            T = parse();
                            if (T.a + T.b > T.c && T.b + T.c > T.a && T.c + T.a > T.b) {
                                Double result = T.area();
                                Intent backIntent = new Intent();
                                backIntent.putExtra(TRIANGLE_RESULT, result);
                                setResult(RESULT_OK, backIntent);
                                finish();
                            } else
                                Toast.makeText(TriangleActivity.this, "Niepoprawne boki trójkąta", Toast.LENGTH_SHORT).show();
                        } catch (NumberFormatException e) {
                            Toast.makeText(TriangleActivity.this, "Podaj długości wszystkich boków", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

        );
        ((Button) findViewById(R.id.backButton)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent backIntent = new Intent();
                        backIntent.putExtra(TRIANGLE_RESULT, "0.0");
                        setResult(RESULT_OK, backIntent);
                        finish();
                    }
                }

        );
    }
}

