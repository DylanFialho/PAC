package com.example.pac_app;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ConcurrentModificationException;

@Database(entities = {Users.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{

    public abstract UsersDao getUsersDao();

    public static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "Users").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
