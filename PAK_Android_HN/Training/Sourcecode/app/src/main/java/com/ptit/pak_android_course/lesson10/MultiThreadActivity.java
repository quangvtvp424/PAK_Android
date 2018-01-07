package com.ptit.pak_android_course.lesson10;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ptit.pak_android_course.R;
import com.ptit.pak_android_course.lesson10.model.Employee;
import com.ptit.pak_android_course.lesson10.model.EmployeeList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 1/6/2018.
 */

public class MultiThreadActivity extends Activity implements View.OnClickListener {

    public TextView txtMsg;
    public Button btnGetDataFromServer;
    public Button btnGetDataFromServerByRetrofit;
    public ProgressDialog loaddingBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMsg = (TextView) this.findViewById(R.id.txtMsg);
        btnGetDataFromServer = (Button) this.findViewById(R.id.btnPerform);
        btnGetDataFromServer.setOnClickListener(this);
        btnGetDataFromServerByRetrofit = (Button) this.findViewById(R.id.btnRetrofit);
        btnGetDataFromServerByRetrofit.setOnClickListener(this);
        loaddingBar = new ProgressDialog(this);
        loaddingBar.setMessage("Downloading...");
        // modify code for new branch

    }

    private void workWithRunable() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final String data = "getting data from server..."; // doing heavy job
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txtMsg.setText(data);
                    }
                });
//                txtMsg.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        txtMsg.setText(data);
//                    }
//                });
            }
        }).start();
    }

    private void workWithAsyncTask(){
        new MyAsyncTask(this).execute("http://...");
    }

    private class MyAsyncTask extends AsyncTask<String, Void, String>{

        ProgressDialog progressBar;

        public MyAsyncTask(Context context){
            progressBar = new ProgressDialog(context);
            progressBar.setMessage("Downloading...");
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            // get data from server
            // heavy jobs here
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "data";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            displayData(s);
            progressBar.dismiss();
            // dismiss progress
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
    }

    public void displayData(String data){
        txtMsg.setText(data);
    }

    private void getDataFromServerUsingRetrofit(){
          /*Create handle for the RetrofitInstance interface*/
        GetEmployeeDataService service = RetrofitInstance.getRetrofitInstance().create(GetEmployeeDataService.class);

        /*Call the method with parameter in the interface to get the employee data*/
        Call<EmployeeList> call = service.getEmployeeData(100);
        loaddingBar.show();
        call.enqueue(new Callback<EmployeeList>() {
            @Override
            public void onResponse(Call<EmployeeList> call, Response<EmployeeList> response) {
                displayListOfEmployee(response.body().getEmployeeArrayList());
                loaddingBar.dismiss();
            }

            @Override
            public void onFailure(Call<EmployeeList> call, Throwable t) {
                Toast.makeText(MultiThreadActivity.this, "Things went wrong..", Toast.LENGTH_SHORT).show();
                loaddingBar.dismiss();
            }
        });
    }

    private void displayListOfEmployee(ArrayList<Employee> employeeArrayList) {
        StringBuilder builder = new StringBuilder();
        for ( Employee item : employeeArrayList){
            builder.append(item.getName()).append("\n");
        }
        txtMsg.setText(builder.toString());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPerform:
                workWithRunable();
                break;
            case R.id.btnRetrofit:
                getDataFromServerUsingRetrofit();
//                workWithAsyncTask();
                break;
            default:
                break;
        }
    }
}
