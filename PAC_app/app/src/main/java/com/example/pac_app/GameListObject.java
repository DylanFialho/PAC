package com.example.pac_app;

import com.example.pac_app.model.Game;

import java.util.List;

public class GameListObject {

    private List<Game> gameList;
    private String category;

    public GameListObject(List<Game> gameList, String category) {
        this.gameList = gameList;
        this.category = category;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
