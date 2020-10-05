package com.example.noman_000.youtube_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button singleVideo;
    private Button standAlonePlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        singleVideo = (Button) findViewById(R.id.btnSingleVideo);
        standAlonePlayer = (Button) findViewById(R.id.btnStandAlonePlayer);

        singleVideo.setOnClickListener(this);
        standAlonePlayer.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch(view.getId()){
            case R.id.btnSingleVideo :
                intent = new Intent(this, YoutubeActivity.class);
                break;

            case R.id.btnStandAlonePlayer :
                intent = new Intent(this, StandAlone_Activity.class);
                break;
        }

        startActivity(intent);
    }
}
