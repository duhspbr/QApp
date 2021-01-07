package com.qualidade.qapp.login;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface LoginDao {
    @Insert
    public void insert(Login user);

    @Update
    public void update(Login user);

    @Delete
    public void delete(Login user);

    @Query("DELETE FROM login_table")
    void deleteAllUsers();

    @Query("SELECT * FROM login_table")
    LiveData<List<Login>> getAllUsers();

    @Query("SELECT COUNT(*)  FROM login_table WHERE usuario=:user AND senha=:senha")
    LiveData<Integer> getUser(String user, String senha);
}
