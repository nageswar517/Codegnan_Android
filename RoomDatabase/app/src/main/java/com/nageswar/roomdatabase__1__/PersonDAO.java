package com.nageswar.roomdatabase__1__;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PersonDAO {
    //dierect sqlite lengthy query
    //insert into person(id,name,age) values(0,nag,13)
    //room database

    @Insert
    void insert(Person p);

    @Query("select * from person")
    List<Person> getAllData();

    /*@Delete
    void delete(Person p);

    @Update
    void update(Person p);*/

}
