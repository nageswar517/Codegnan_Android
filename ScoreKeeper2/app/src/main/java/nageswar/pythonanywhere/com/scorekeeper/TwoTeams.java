package nageswar.pythonanywhere.com.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class TwoTeams extends AppCompatActivity {

    private TextView tv,tv2;
    private int count = 0;
    private int count2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_teams);
        tv = findViewById(R.id.result);
        tv2 = findViewById(R.id.result2);
    }


    public void decrement(View view) {
        count--;
        tv.setText(String.valueOf(count));
    }

    public void increment(View view) {
        count++;
        tv.setText(String.valueOf(count));
    }

    public void increment2(View view) {
        count2++;
        tv2.setText(String.valueOf(count2));
    }

    public void decrement2(View view) {
        count2--;
        tv2.setText(String.valueOf(count2));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.reset:
                showAlertDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAlertDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Reset All!");
        builder.setMessage("Click Yes to reset all scores to zero.");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                count = 0;
                count2 = 0;
                tv.setText(""+count);
                tv2.setText(""+count2);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                showAlertDialog();
            }
            private void showAlertDialog(){
                AlertDialog.Builder builder1 = builder;
                builder1.setTitle("Choose team to reset");
                builder1.setPositiveButton("Team1", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        count = 0;
                        tv.setText(""+count);
                    }
                });
                builder1.setNegativeButton("Team2", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        count2 = 0;
                        tv2.setText(""+count2);
                    }
                });
                builder1.setNeutralButton("Cancel",null);
                builder1.show();
            }
        });
        builder.setNeutralButton("Cancel",null);
        builder.show();
    }

    public void nextActivity(View view) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}