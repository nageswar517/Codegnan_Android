package com.nageswar.roomdatabase__1__;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "person")
public class Person {    //person is the table name
    @PrimaryKey(autoGenerate = true)
    int id;  // id & primary key
    String name; // col 2
    int age; // col 3

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
