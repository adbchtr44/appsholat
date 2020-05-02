package com.example.bismillahbisa.database;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface DataListDao {
    @Insert
    Long insertData(DataList dataList);

    @Query("Select * from List_Ramadhan")
    DataList[] getData();
}
