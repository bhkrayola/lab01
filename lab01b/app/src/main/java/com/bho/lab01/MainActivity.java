package com.bho.lab01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button incrementButton;
    TextView greetingDisplay;
    TextView countDisplay;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        incrementButton = findViewById(R.id.increment_button);
        greetingDisplay = findViewById(R.id.greeting_textview);
        countDisplay = findViewById(R.id.count_textview);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("incrementing: "+ ++count);
                Log.i("incrementing", ""+count);
                countDisplay.setText(Integer.toString(count));
            }
        });
    }
    public void decrement(View view) {
        System.out.println("decrementing "+ --count);
        Log.i("decrementing", ""+count);
        countDisplay.setText(Integer.toString(count));
    }
    public void reset(View view) {
        count = 0;
        countDisplay.setText(Integer.toString(count));
    }
}