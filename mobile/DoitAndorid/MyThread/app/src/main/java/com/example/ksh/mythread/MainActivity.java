package com.example.ksh.mythread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    ValueHandler handler = new ValueHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackgroundThread thread = new BackgroundThread();
                thread.start();
            }
        });

        Button button2 = (Button) findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //      textView.setText("?꾩옱媛?: " +value);
            }
        });
    }

    class BackgroundThread extends  Thread{
        int value = 0;
        boolean running = false;

        @Override
        public void run() {
            running = true;
            while(running){
                value += 1;

                try {
                    Message message = handler.obtainMessage();
                    Bundle bundle = new Bundle();
                    bundle.putInt("value", value);
                    message.setData(bundle);
                    handler.sendMessage(message);

                    Thread.sleep(1000);
                }catch (Exception e){}
            }
        }
    }

    class ValueHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Bundle bundle = msg.getData();
            int value = bundle.getInt("value");
            textView.setText("?꾩옱媛?: " +value);
        }
    }
}
