package com.example.pac_app;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.pac_app.model.Game;

import java.util.List;

@Dao
public interface GameDao {

    @Query("SELECT * FROM Game")
    public List<Game> getAll();

    @Query("SELECT * FROM Game WHERE category LIKE :category")
    public List<Game> getAllFromCat(String category);

    @Query("SELECT * FROM Game ORDER BY RANDOM() LIMIT 5")
    public List<Game> getHighLights();
}
