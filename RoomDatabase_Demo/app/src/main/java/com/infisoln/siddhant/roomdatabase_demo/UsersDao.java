package com.infisoln.siddhant.roomdatabase_demo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface UsersDao {

    @Insert
    void insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);

    @Query(value = "SELECT * FROM user")
    List<User> getAllUsers();

    @Query(value = "SELECT * FROM user WHERE id = :id ")
    User getUserById(Long id);

}
