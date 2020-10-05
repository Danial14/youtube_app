package com.example.noman_000.youtube_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandAlone_Activity extends AppCompatActivity implements View.OnClickListener{
    private Button standAloneVideoButton;
    private Button standAlonePlayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtube_standalone_player);

        standAloneVideoButton = (Button) findViewById(R.id.btnStandAloneVideo);
        standAlonePlayList = (Button) findViewById(R.id.btnStandAlonePlayList);

        standAloneVideoButton.setOnClickListener(this);
        standAlonePlayList.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch(view.getId()){
            case R.id.btnStandAloneVideo :
                intent = YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.VIDEO_ID, 0,true, false);
                break;

            case R.id.btnStandAlonePlayList :
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.PLAYLIST_ID,
                        0, 0, true, false
                        );
                break;
        }
        if(intent != null) {
            startActivity(intent);
        }
    }
}
