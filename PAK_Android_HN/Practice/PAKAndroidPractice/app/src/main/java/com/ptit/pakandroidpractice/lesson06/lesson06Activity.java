package com.ptit.pakandroidpractice.lesson06;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ptit.pakandroidpractice.R;

import java.util.ArrayList;

/**
 * Created by admin on 11/18/2017.
 */

public class lesson06Activity extends AppCompatActivity {

    ArrayList<Student> students;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson06_activity_main);

        initializing();

        addStudentList(students);

        StudentAdapter adapter = new StudentAdapter(students, getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(false);
    }

    private void initializing() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_student);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        students = new ArrayList<>();
    }

    private void addStudentList(ArrayList<Student> students) {
        students.add(new Student(R.drawable.icon_student, "Tran Quang Khai", "20"));
        students.add(new Student(R.drawable.icon_student, "Tran Tuan Anh", "20"));
        students.add(new Student(R.drawable.icon_student, "Nguyen Viet Anh", "20"));
        students.add(new Student(R.drawable.icon_student, "Pham Hoang Anh", "20"));
        students.add(new Student(R.drawable.icon_student, "Cao Minh Duc", "20"));
        students.add(new Student(R.drawable.icon_student, "Vu Van Duc", "20"));
    }
}
