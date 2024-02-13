package com.bho.lab01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button userInput;
    EditText elTextMod;
    TextView nameDisplay;
    Button incrementButton;
    TextView greetingDisplay;
    TextView countDisplay;
    TextView laName;
    int count = 0;
    String input = "";
    String[] linux;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        incrementButton = findViewById(R.id.increment_button);
        greetingDisplay = findViewById(R.id.greeting_textview);
        nameDisplay = findViewById(R.id.name_textview);
        linux = getResources().getStringArray(R.array.linux_distributions);
        countDisplay = findViewById(R.id.count_textview);
        elTextMod = findViewById(R.id.edittext_button);
        userInput = findViewById(R.id.confirm_button);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          /* System.out.println("incrementing: "+ ++count);
             //   Log.i("incrementing", ""+count);
                countDisplay.setText(""+count);*/
                count = ++count% linux.length;
                greetingDisplay.setText(linux[count]);
            }
        });
        userInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = elTextMod.getText().toString();
                nameDisplay.setText(input);
            }
        });
    }
    public void decrement(View view) {
        /*System.out.println("decrementing "+ --count);
        Log.i("decrementing", ""+count);
        countDisplay.setText(Integer.toString(count));*/
        if(--count <0)count=linux.length-1;
        greetingDisplay.setText(linux[count]);
    }
    public void reset(View view) {
        count = 0;
        greetingDisplay.setText(R.string.wazowski);
    }
}