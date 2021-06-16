package com.example.pac_app;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pac_app.model.Game;

import java.util.List;

@Dao
public interface GameDao {

    @Query("SELECT * FROM Game")
    List<Game> getAll();

    @Query("SELECT * FROM Game WHERE category LIKE :category")
    List<Game> getAllFromCat(String category);

    @Query("SELECT * FROM Game ORDER BY RANDOM() LIMIT 5")
    List<Game> getHighLights();

    @Query("SELECT * FROM Game WHERE isInCart = 1")
    List<Game> getAllInCart();

    @Update
    public void updateGame(Game game);
}
