package com.nageswar.optionsmenu__;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //We will attach options file usin this method
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //This method will be invoked when an item is selected from the menu
        int id = item.getItemId();
        switch (id){
            case R.id.first:
                //do some action
                Toast.makeText(this, "First", Toast.LENGTH_SHORT).show();
                break;
            case R.id.second:
                //do some action
                Toast.makeText(this, "Second", Toast.LENGTH_SHORT).show();
                break;
            case R.id.third:
                //do some action
                showAlertDialog();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAlertDialog() {
        //showing alert
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sample Alert");
        builder.setIcon(R.drawable.smiley);
        builder.setMessage("This is a sample message");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("No",null);
        builder.setNeutralButton("Cancel",null);
        builder.show();
    }

    @Override
    public void onBackPressed() {
        /*super.onBackPressed();*/
        showAlertDialog();
    }
}