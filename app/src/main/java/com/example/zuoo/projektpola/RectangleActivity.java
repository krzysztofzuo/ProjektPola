package com.example.zuoo.projektpola;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

class Rectangle {
    private double a, b;

    Rectangle(double _a, double _b) {
        a = _a;
        b = _b;
    }

    double area() {
        double p = (a * b);
        return (p);
    }
}

public class RectangleActivity extends AppCompatActivity {
    public final static String RECTANGLE_RESULT = "Area";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);

        ((Button) findViewById(R.id.rectangleCalcButton)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        double a = Double.parseDouble(((EditText) findViewById(R.id.aRectangleEditText)).getText().toString());
                        double b = Double.parseDouble(((EditText) findViewById(R.id.bRectangleEditText)).getText().toString());
                        Rectangle Rect = new Rectangle(a, b);
                        ((TextView) findViewById(R.id.rectangleResultTextView)).setText(Double.toString(Rect.area()));
                    }
                }
        );

        ((Button) findViewById(R.id.backAndAddButton)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String area_string = ((TextView) findViewById(R.id.rectangleResultTextView)).getText().toString();
                        Intent backIntent = new Intent();
                        backIntent.putExtra(RECTANGLE_RESULT, area_string);
                        setResult(RESULT_OK, backIntent);
                        finish();
                    }
                }
        );

        ((Button) findViewById(R.id.backButton)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent backIntent = new Intent();
                        backIntent.putExtra(RECTANGLE_RESULT, "0.0");
                        setResult(RESULT_OK, backIntent);
                        finish();
                    }
                }
        );
    }

}
