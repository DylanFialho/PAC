package com.example.pac_app;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UsersDao {

    @Query("SELECT * FROM Users")
    List<Users> getAll();

    @Query("SELECT * FROM Users WHERE id = :id")
    Users getById(long id);

    @Insert
    void add(Users country);

    @Insert
    void add(List<Users> countries);

    @Delete
    void delete(Users country);

    @Update
    void update(Users country);
}
