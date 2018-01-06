package com.ptit.pak_android_course.lesson07.room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Thuannd on 11/25/2017.
 */
@Entity
public class Student {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String fullName;
    public String address;
    public String major;

    public Student(){}
    public Student(String fullName, String address, String major){
        this.fullName = fullName;
        this.address = address;
        this.major = major;
    }
}
