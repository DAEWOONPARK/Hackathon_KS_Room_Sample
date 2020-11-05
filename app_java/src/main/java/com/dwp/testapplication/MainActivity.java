package com.dwp.testapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import com.dwp.testapplication.db.TestData;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtTitle = findViewById(R.id.txt_title);
        TextView txtContent = findViewById(R.id.txt_content);

        TestRepository repository = new TestRepository(getApplication());
        LiveData<List<TestData>> allTasks = repository.getAllTasks();
        allTasks.observe(this, testData -> {
            txtTitle.setText(testData.get(0).getTitle());
            txtContent.setText(testData.get(0).getContent());
        });

        repository.insert(new TestData("title_data", "content_data"));

/** ShraedPreferences sample **/
//        SQLiteDatabase db = openOrCreateDatabase("test_db", MODE_PRIVATE, null);
//        db.execSQL("CREATE TABLE IF NOT EXISTS test_table (title VARCHAR(20), content VARCHAR(20))");
//        db.execSQL("INSERT INTO test_table (title, content) VALUES (?, ?)", new String[]{"title_data", "content_data"});
//
//        Cursor cursor = db.rawQuery("SELECT title, content FROM test_table", null);
//        while(cursor.moveToNext()) {
//            txtTitle.setText(cursor.getString(0));
//            txtContent.setText(cursor.getString(1));
//        }
    }
}