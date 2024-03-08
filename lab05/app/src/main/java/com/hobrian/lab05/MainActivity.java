package com.hobrian.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String TAG = "com.hobrian.lab05";
    LifetimeData currentRun, lifeTime;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TextView currentRunTV, lifeTimeTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
        //create editor
        editor = sharedPreferences.edit();
        currentRun = new LifetimeData();
        currentRun.duration="Current Run";
        //get LifetimeData from SharedPreferences as String
        String lifetimeDataAsString = sharedPreferences.getString("lifetime", "");
        //Instantiate a new LifecycleData if empty string
        //else convert the JSON to LifetimeData object
        if(lifetimeDataAsString.equals("")){
            lifeTime = new LifetimeData();
            lifeTime.duration="Lifetime";
        }else{
            lifeTime = LifetimeData.parseJSON(lifetimeDataAsString);
        }
        lifeTimeTV = findViewById(R.id.lifetime);
        currentRunTV = findViewById(R.id.current);
        String currentEnclosingMethod = new Throwable().getStackTrace()[0].getMethodName();
        updateCount(currentEnclosingMethod);
    }

    private void displayData() {
        lifeTimeTV.setText(lifeTime.toString());
        currentRunTV.setText(currentRun.toString());
    }

    public void storeData(){
        editor.putString("lifetime",lifeTime.toJSON()).apply();
    }
    public void updateCount(String currentEnclosingMethod){
        currentRun.updateEvent(currentEnclosingMethod);
        lifeTime.updateEvent(currentEnclosingMethod);
        displayData();
        storeData();
    }
    @Override
    protected void onStart(){
        super.onStart();
        String currentEnclosingMethod = new Throwable().getStackTrace()[0].getMethodName();
        updateCount(currentEnclosingMethod);
    }
    @Override
    protected void onResume(){
        super.onResume();
        String currentEnclosingMethod = new Throwable().getStackTrace()[0].getMethodName();
        updateCount(currentEnclosingMethod);
    }
    @Override
    protected void onPause(){
        super.onPause();
        String currentEnclosingMethod = new Throwable().getStackTrace()[0].getMethodName();
        updateCount(currentEnclosingMethod);
    }
    @Override
    protected void onStop(){
        super.onStop();
        String currentEnclosingMethod = new Throwable().getStackTrace()[0].getMethodName();
        updateCount(currentEnclosingMethod);
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        String currentEnclosingMethod = new Throwable().getStackTrace()[0].getMethodName();
        updateCount(currentEnclosingMethod);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        String currentEnclosingMethod = new Throwable().getStackTrace()[0].getMethodName();
        updateCount(currentEnclosingMethod);
    }
}