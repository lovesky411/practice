package com.example.ksh.myprogress;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    Handler handler = new Handler();
    CompletionThread completionThread;

    String msg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ProgressThread thread = new ProgressThread();
                        thread.start();
                    }
                }, 5000);*/

                ProgressTask task = new ProgressTask();
                task.execute("시작");
            }
        });

        completionThread = new CompletionThread();
        completionThread.start();
    }

    class ProgressTask extends AsyncTask<String, Integer, Integer>{
        int value = 0;


        @Override
        protected Integer doInBackground(String... strings) {
            while(true){
                if(value > 100){
                    break;
                }

                value += 1;

                publishProgress(value);

                try {
                    Thread.sleep(200);
                }catch (Exception e){}
            }
            return value;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);

            Toast.makeText(getApplicationContext(), "완료됨", Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            progressBar.setProgress(values[0].intValue());
        }
    }

    class ProgressThread extends  Thread{
        int value = 0;

        public void run(){
            while(true){
                if(value > 100){
                    break;
                }

                value += 1;

                handler.post(() -> { progressBar.setProgress(value); });

                try {
                    Thread.sleep(200);
                }catch (Exception e){}
            }

            completionThread.completionHandler.post(new Runnable() {
                @Override
                public void run() {
                    msg = "OK";

                    Log.d("MainActivity", " Message : " +msg);
                }
            });

        }
    }

    class CompletionThread extends  Thread {
        public Handler completionHandler = new Handler();

        public void run(){
            Looper.prepare();
            Looper.loop();
        }
    }
}
