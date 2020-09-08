package nageswar.pythonanywhere.com.scorekeeper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.result);
        if(savedInstanceState!=null){
            count = savedInstanceState.getInt("KEY");
            tv.setText(String.valueOf(count));
        }
    }

    public void incrementScore(View view) {
        count++;
        tv.setText(""+count);
    }

    public void decrementScore(View view) {
        count--;
        tv.setText(""+count);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("KEY",count);
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

    public void nextActivity(View view) {
        Intent i = new Intent(this,TwoTeams.class);
        startActivity(i);
    }
}