package com.example.pac_app;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.pac_app.model.Users;

import java.util.List;

@Dao
public interface UsersDao {

    @Query("SELECT * FROM Users WHERE username = :user AND password = :pass")
    Users getByUserAndPass(String user, String pass);

    @Query("SELECT * FROM Users WHERE username = :user AND email = :email")
    List<Users> getUsersByUserAndMail(String user, String email);

    @Insert
    void insertUser(Users users);

}
