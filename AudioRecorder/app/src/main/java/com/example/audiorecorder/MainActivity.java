package com.example.audiorecorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {


    private static final int REQUEST_AUDIO_PERM_CODE = 100;
    MediaRecorder mediaRecorder;
    MediaPlayer mediaPlayer;
    ImageView ibRecord;
    ImageView ibPlay;
    TextView tvRecordingTime;
    TextView tvRecordingPath;
    ImageView ivBackground;
    boolean isRecording = false;
    boolean isPlaying = false;
    int seconds = 0;
    int dummySeconds=0;
    int playableSeconds=0;
    String path = null;
    LottieAnimationView lavPlaying;
    String recordingPermission = Manifest.permission.RECORD_AUDIO;
    Handler handler;

    ExecutorService executorService = Executors.newSingleThreadExecutor();



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();


        initView();

        ibRecord.setOnClickListener(view -> {
            if(checkRecordingPermission()) {
                if (!isRecording) {
                    tvRecordingPath.setText("Recording...");
                    isRecording=true;
                    executorService.execute(() -> {
                        path = getRecordingFilePath();

                        mediaRecorder = new MediaRecorder();
                        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                        mediaRecorder.setOutputFile(path);
                        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

                        try {
                            mediaRecorder.prepare();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        mediaRecorder.start();
                        runOnUiThread(() -> {
                            ivBackground.setVisibility(View.VISIBLE);
                            lavPlaying.setVisibility(View.GONE);
                            playableSeconds = 0;
                            seconds = 0;
                            dummySeconds = 0;
                            ibRecord.setImageDrawable(ContextCompat
                                    .getDrawable(MainActivity.this, R.drawable.recording_active));

                            runTimer();
                        });
                    });
                } else {
                     executorService.execute(() -> {

                         mediaRecorder.stop();
                         tvRecordingPath.setText("");
                         mediaRecorder.release();
                         mediaRecorder=null;
                         playableSeconds=seconds;
                         dummySeconds=seconds;
                         seconds=0;
                         isRecording = false;

                         runOnUiThread(() -> {
                             ivBackground.setVisibility(View.VISIBLE);
                             lavPlaying.setVisibility(View.GONE);
                             handler.removeCallbacksAndMessages(null);
                             ibRecord.setImageDrawable(ContextCompat
                                     .getDrawable(MainActivity.this, R.drawable.recording_in_active));
                         });
                     });
                }

            } else {
                requestRecordingPermissions();
            }
        });

        ibPlay.setOnClickListener(view -> {
            if(!isPlaying)  {
                if(path!=null) {
                    try {
                        mediaPlayer.setDataSource(getRecordingFilePath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(this, "No recording present", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.start();
                tvRecordingPath.setText("Playing...");
                isPlaying = true;
                ibPlay.setImageDrawable(ContextCompat
                        .getDrawable(MainActivity.this, R.drawable.recording_pause));
                ivBackground.setVisibility(View.GONE);
                lavPlaying.setVisibility(View.VISIBLE);
                runTimer();

            } else {
                mediaPlayer.stop();
                tvRecordingPath.setText(""); 
                mediaPlayer.release();
                mediaPlayer = null;
                mediaPlayer = new MediaPlayer();
                isPlaying = false;
                seconds = 0;
                handler.removeCallbacksAndMessages(null);
                ivBackground.setVisibility(View.VISIBLE);
                lavPlaying.setVisibility(View.GONE);
                ibPlay.setImageDrawable(ContextCompat
                        .getDrawable(MainActivity.this, R.drawable.recording_play));
            }




        });
    }

    private void runTimer() {

        handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format(Locale.getDefault(), "%02d:%02d", minutes, secs);
                tvRecordingTime.setText(time);

                if (isRecording || (isPlaying && playableSeconds != -1)) {
                    seconds++;
                    playableSeconds--;

                    if (playableSeconds == -1 && isPlaying) {
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = null;
                        mediaPlayer = new MediaPlayer();
                        playableSeconds = dummySeconds;
                        seconds = 0;
                        handler.removeCallbacksAndMessages(null);
                        ivBackground.setVisibility(View.VISIBLE);
                        lavPlaying.setVisibility(View.GONE);
                        ibPlay.setImageDrawable(ContextCompat.
                                getDrawable(MainActivity.this, R.drawable.recording_play));
                        return;
                    }

                }
                handler.postDelayed(this, 1000);
            }
        });
    }

    private String getRecordingFilePath() {

        ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
        File music = contextWrapper.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        File file = new File(music, "fileName"+".mp3");
        return file.getPath();
    }

    private void initView() {
        ibRecord = findViewById(R.id.ib_record);
        ibPlay = findViewById(R.id.ib_play);
        tvRecordingTime = findViewById(R.id.tv_time);
        tvRecordingPath = findViewById(R.id.tv_recording_path);
        ivBackground = findViewById(R.id.iv_simple_bg);
        lavPlaying = findViewById(R.id.lav_playing);
        mediaPlayer = new MediaPlayer();
    }

    private void requestRecordingPermissions() {
        ActivityCompat
                .requestPermissions(MainActivity.this,
                        new String[]{recordingPermission}, REQUEST_AUDIO_PERM_CODE);
    }

    private boolean checkRecordingPermission() {
        if (ContextCompat.checkSelfPermission(this, recordingPermission)== PackageManager.PERMISSION_DENIED) {
            requestRecordingPermissions();
            return false;
        } return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==REQUEST_AUDIO_PERM_CODE) {
            if (grantResults.length>0) {
                boolean permissionToRecord = grantResults[0]==PackageManager.PERMISSION_GRANTED;
                if(permissionToRecord) {
                    Toast.makeText(this, "Permission given", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
                }

            }
        }
    }
}