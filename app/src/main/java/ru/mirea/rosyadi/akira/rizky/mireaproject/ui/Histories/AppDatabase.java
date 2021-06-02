package ru.mirea.rosyadi.akira.rizky.mireaproject.ui.Histories;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Cell.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract HistoriesDao storyDao();
}
