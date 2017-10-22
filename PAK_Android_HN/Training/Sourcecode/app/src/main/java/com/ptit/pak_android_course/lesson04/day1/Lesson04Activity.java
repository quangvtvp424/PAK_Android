package com.ptit.pak_android_course.lesson04.day1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.ptit.pak_android_course.R;

import java.util.ArrayList;

/**
 * Created by quanglm on 10/15/17.
 */

public class Lesson04Activity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson04);


        // Init animal list
        Animal animal = new Animal();
        Animal dog = new Dog();
        Animal cat = new Cat();

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(animal);
        animals.add(dog);
        animals.add(cat);

        printAnimalSpeak(animals);

    }

    private void printAnimalSpeak(ArrayList<Animal> animals) {
        for (Animal a : animals) {
            a.speak();
        }
    }

    class Animal {
        public void speak() {
            Log.d("Animal", "speak: this is animal");
        }
    }

    class Dog extends Animal {
        @Override
        public void speak() {
            Log.d("Animal", "speak: this is Dog");
        }
    }

    class Cat extends Animal {
        @Override
        public void speak() {
            Log.d("Animal", "speak: this is Cat");
        }
    }
}
