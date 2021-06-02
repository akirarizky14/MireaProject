package ru.mirea.rosyadi.akira.rizky.mireaproject.ui.Histories;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Cell {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String text;
}

