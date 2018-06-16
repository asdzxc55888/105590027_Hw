package com.example.user.hw8;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MusicService extends Service {
    private MediaPlayer bgmPlayer;

    @Override
    public void onCreate() {
        super.onCreate();

        bgmPlayer = MediaPlayer.create(this, R.raw.bgm);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service start", Toast.LENGTH_SHORT).show();
        bgmPlayer.start();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "service stop", Toast.LENGTH_SHORT).show();
        bgmPlayer.stop();
    }
}
