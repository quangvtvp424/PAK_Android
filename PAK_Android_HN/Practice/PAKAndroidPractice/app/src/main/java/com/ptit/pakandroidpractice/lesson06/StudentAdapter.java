package com.ptit.pakandroidpractice.lesson06;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ptit.pakandroidpractice.R;

import java.util.ArrayList;

/**
 * Created by admin on 11/19/2017.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    ArrayList<Student> arrayList;
    Context context;

    public StudentAdapter(ArrayList<Student> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_row_student, parent, false);
        return (new ViewHolder(itemView));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.imgStudent.setImageResource(arrayList.get(position).getImage());
        holder.txvName.setText(arrayList.get(position).getName());
        holder.txvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, holder.txvName.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.txvAge.setText(arrayList.get(position).getAge());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgStudent;
        TextView txvName, txvAge;

        public ViewHolder(View itemView) {
            super(itemView);
            imgStudent = (ImageView) itemView.findViewById(R.id.imageView_student);
            txvName = (TextView) itemView.findViewById(R.id.textView_name);
            txvAge = (TextView) itemView.findViewById(R.id.textView_age);
        }
    }
}
