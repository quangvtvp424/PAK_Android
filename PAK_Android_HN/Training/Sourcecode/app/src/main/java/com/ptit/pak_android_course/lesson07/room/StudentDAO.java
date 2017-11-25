package com.ptit.pak_android_course.lesson07.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Thuannd on 11/25/2017.
 */

@Dao
public interface StudentDAO {

    @Query("SELECT * from Student")
    List<Student> getAll();

    @Query("SELECT * from Student WHERE id IN (:studentIds)")
    List<Student> loadAllByIds(int[] studentIds);

    @Query("SELECT * from Student WHERE fullName LIKE :name")
    List<Student> searchByName(String name);

    @Insert
    void insertAll(Student... students);
}
