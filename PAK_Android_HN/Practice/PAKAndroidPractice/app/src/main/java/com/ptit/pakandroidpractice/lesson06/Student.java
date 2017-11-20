package com.ptit.pakandroidpractice.lesson06;

/**
 * Created by admin on 11/19/2017.
 */

public class Student {
    private int image;
    private String name, age;

    public Student(int image, String name, String age) {
        this.image = image;
        this.name = name;
        this.age = age;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}
