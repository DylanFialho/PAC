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

    @Query("SELECT * FROM Users WHERE username = :user")
    Users getByUser(String user);

    @Query("SELECT * FROM Users WHERE password = :pass")
    Users getByPass(String pass);

}
