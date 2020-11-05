package com.dwp.testapplication;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.dwp.testapplication.db.AppDatabase;
import com.dwp.testapplication.db.TestDao;
import com.dwp.testapplication.db.TestData;

import java.util.List;

/**
 * Created by dwp on 2020-11-05.
 */
public class TestRepository {

    private TestDao testDao;
    private LiveData<List<TestData>> allTask;

    public TestRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        testDao = database.testDao();
        allTask = testDao.getAllTasks();
    }

    public LiveData<List<TestData>> getAllTasks() {return allTask;}

    public void insert(TestData testData) {
        new InsertTaskAsyncTask(testDao).execute(testData);
    }

    private static class InsertTaskAsyncTask extends AsyncTask<TestData, Void, Void> {
        private TestDao testDao;

        public InsertTaskAsyncTask(TestDao testDao) {this.testDao = testDao;}

        @Override
        protected Void doInBackground(TestData... testData) {
            testDao.insert(testData[0]);
            return null;
        }
    }
}
