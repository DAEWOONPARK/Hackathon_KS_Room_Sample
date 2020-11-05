package com.dwp.testapplication.db;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Created by dwp on 2020-11-05.
 */
@Entity(tableName = "test_table")
public class TestData {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String content;

    public TestData(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Ignore
    public TestData(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
