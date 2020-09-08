package com.nageswar.score_keeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //connecting text view on xml to tv in java
        tv = findViewById(R.id.result);
        if(savedInstanceState!=null) {
            count = savedInstanceState.getInt("KEY");
            tv.setText(String.valueOf(count));
        }
    }

    public void decrementScore(View view) {
        count--;
        tv.setText(String.valueOf(count));
    }

    public void incrementScore(View view) {
        count++;
        tv.setText(""+count);
    }

    //To save the values when the activity is destroyed we use onSave instance

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("KEY",count);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //We will attach options file usin this method
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.reset:
                count=0;
                tv.setText(""+count);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
