package com.dwp.testapplication.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Created by dwp on 2020-11-05.
 */
@Dao
public interface TestDao {

    @Insert
    void insert(TestData testData);

    @Update
    void update(TestData testData);

    @Delete
    void delete(TestData testData);

    @Query("DELETE FROM test_table")
    void deleteAllTasks();

    @Query("SELECT * FROM test_table")
    LiveData<List<TestData>> getAllTasks();

}
