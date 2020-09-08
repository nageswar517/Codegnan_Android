package com.nageswar.roomdatabase__1__;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText name,age;
    private TextView result;

    private PersonDatabase pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        result = findViewById(R.id.result);

        pd = Room.databaseBuilder(this,PersonDatabase.class,"nageswar")
                .allowMainThreadQueries()
                .build();
    }

    public void saveData(View view) {
        String n = name.getText().toString();
        int a = Integer.parseInt(age.getText().toString());
        Person p = new Person(n,a);
        pd.personDAO().insert(p);
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        getData();
    }

    private void getData() {
        result.setText("");
        List<Person> list = pd.personDAO().getAllData();
        if(list!=null){
            for(Person p : list){
              result.append(p.getId()+ " "+ p.getName()+" "+p.getAge()+"\n");

            }

        }
    }
}