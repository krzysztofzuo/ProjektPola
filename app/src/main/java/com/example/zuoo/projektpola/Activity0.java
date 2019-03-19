package com.example.zuoo.projektpola;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity0 extends AppCompatActivity {
    public static final int CODE_TRIANGLE = 1;
    public static final int CODE_RECTANGLE = 2;
    public static final int CODE_CIRCLE = 3;
    private double area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_0);
        area = 0.0;

        ((Button) findViewById(R.id.triangleButton)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent triangleIntent = new Intent(Activity0.this, TriangleActivity.class);
                        startActivityForResult(triangleIntent, CODE_TRIANGLE);
                    }
                }
        );

        ((Button) findViewById(R.id.rectangleButton)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent rectangleIntent = new Intent(Activity0.this, RectangleActivity.class);
                        startActivityForResult(rectangleIntent, CODE_RECTANGLE);
                    }
                }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String new_area = data.getExtras().get("Area").toString();
        area += Double.parseDouble(new_area);
        ((TextView) findViewById(R.id.resultTextView)).setText(Double.toString(area));
    }

}
