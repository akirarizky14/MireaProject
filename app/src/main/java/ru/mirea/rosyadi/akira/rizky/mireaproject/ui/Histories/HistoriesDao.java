package ru.mirea.rosyadi.akira.rizky.mireaproject.ui.Histories;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface HistoriesDao {
    @Query("SELECT * FROM Cell")
    List<ru.mirea.rosyadi.akira.rizky.mireaproject.ui.Histories.Cell> getAll();
    @Query("SELECT * FROM Cell WHERE id = :id")
    ru.mirea.rosyadi.akira.rizky.mireaproject.ui.Histories.Cell getById(long id);
    @Insert
    void insert(ru.mirea.rosyadi.akira.rizky.mireaproject.ui.Histories.Cell cell);
    @Update
    void update(ru.mirea.rosyadi.akira.rizky.mireaproject.ui.Histories.Cell cell);
    @Delete
    void delete(ru.mirea.rosyadi.akira.rizky.mireaproject.ui.Histories.Cell cell);

}

