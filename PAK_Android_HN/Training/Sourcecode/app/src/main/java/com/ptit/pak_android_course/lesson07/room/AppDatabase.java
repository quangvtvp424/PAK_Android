package com.ptit.pak_android_course.lesson07.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Thuannd on 11/25/2017.
 */

@Database(entities = {Student.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract StudentDAO getStudentDao();
}
