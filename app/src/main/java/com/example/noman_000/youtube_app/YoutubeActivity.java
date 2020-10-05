package com.example.noman_000.youtube_app;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    private static final String TAG = "YoutubeActivity";
    public static final String GOOGLE_API_KEY = "AIzaSyD6eaKPAGKdH_dHu7CGHWzS0gqRGdBRtLM";
    public static String VIDEO_ID = "ElpitAfkRS4";
    public static String PLAYLIST_ID = "PLXtTjtWmQhg1SsviTmKkWO5n0a_-T0bnD";

    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {
            Toast.makeText(YoutubeActivity.this, "Video playing successfully", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onPaused() {
            Toast.makeText(YoutubeActivity.this, "Video paused successfully", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onStopped() {
            Toast.makeText(YoutubeActivity.this, "Video stopped successfully", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };

    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {
            Toast.makeText(YoutubeActivity.this, "Video is loading", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onLoaded(String s) {
            Toast.makeText(YoutubeActivity.this, "Video loaded successfully " + s, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onAdStarted() {
            Toast.makeText(YoutubeActivity.this, "Ad started", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ConstraintLayout constraintLayout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_youtube, null);
        setContentView(constraintLayout);

        final YouTubePlayerView youTubePlayerView = new YouTubePlayerView(this);

        youTubePlayerView.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        youTubePlayerView.initialize(GOOGLE_API_KEY, this);

        constraintLayout.addView(youTubePlayerView);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        Log.d(TAG, "onInitializationSuccess: " + provider.getClass().toString());
        Toast.makeText(this, "onInitializationSuccessful", Toast.LENGTH_LONG).show();
        youTubePlayer.setPlaybackEventListener(playbackEventListener);
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        if(!wasRestored){
            youTubePlayer.cueVideo(VIDEO_ID);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        int REQUEST_CODE = 1;
        if(youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this, REQUEST_CODE).show();
        }
    }
}
