package com.example.ksh.myaudioplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static String url = "http://sites.google.com/site/ubiaccessmobile/sample_audio.amr";

    MediaPlayer player;
    int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener((v) -> {playAudio();});

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener((v) -> { pauseAudio();});

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener((v) ->  { resumeAudio();});

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener((v) -> { stopAudio();} );
    }

    public void playAudio(){

        try {
            player = new MediaPlayer();
            player.setDataSource(url);
            player.prepare();
            player.start();

            Toast.makeText(this, "재생 시작됨", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pauseAudio(){
        if(player != null){
            position = player.getCurrentPosition();
            player.pause();

            Toast.makeText(this, "일시정지", Toast.LENGTH_LONG).show();
        }
    }

    public void resumeAudio(){

        if(player != null && player.isPlaying()){

            player.start();
            player.seekTo(position);

            Toast.makeText(this, "재생  다시 시작됨" ,Toast.LENGTH_LONG).show();
        }


    }

    public void stopAudio(){

        if(player != null && player.isPlaying()){

            player.stop();
            Toast.makeText(this, "재생  중지", Toast.LENGTH_LONG).show();
        }


    }

    public void closePlayer(){
        if(player != null){
            player.release();
            player = null;
        }
    }

}
