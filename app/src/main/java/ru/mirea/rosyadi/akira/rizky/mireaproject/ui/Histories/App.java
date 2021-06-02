package ru.mirea.rosyadi.akira.rizky.mireaproject.ui.Histories;

import android.app.Application;

import androidx.room.Room;

public class App extends Application {
    public static ru.mirea.rosyadi.akira.rizky.mireaproject.ui.Histories.App instance;
    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "database")
                .allowMainThreadQueries()
                .build();
    }

    public static ru.mirea.rosyadi.akira.rizky.mireaproject.ui.Histories.App getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }
}