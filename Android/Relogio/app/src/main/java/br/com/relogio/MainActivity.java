package br.com.relogio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Runnable mRunnable;
    private Handler mHandler = new Handler();
    private boolean mTicker = false;
    private boolean mLandScape = false;


    private ViewHolder mViewHolder = new ViewHolder();
    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int levelBattery = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            mViewHolder.textBattery.setText(String.format("%s%%", levelBattery));

        }
    };

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_IMMERSIVE
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
            );
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.textHourMinute = findViewById(R.id.text_hour_minute);
        this.mViewHolder.textSeconds = findViewById(R.id.text_seconds);
        this.mViewHolder.textBattery = findViewById(R.id.text_battery);
        this.mViewHolder.textNigth = findViewById(R.id.text_night);

        this.mViewHolder.textHourMinute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSystemUi();
            }
        });

        this.registerReceiver(this.mReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));


    }

    private void showSystemUi() {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.registerReceiver(this.mReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        this.mTicker = false;
        this.unregisterReceiver(this.mReceiver);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.mTicker = true;
        this.mLandScape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        startClock();

    }

    private void startClock() {
        if (!mTicker) return;
        Calendar calendar = Calendar.getInstance();
        this.mRunnable = () -> {

            calendar.setTimeInMillis(System.currentTimeMillis());

            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minutes = calendar.get(Calendar.MINUTE);
            int seconds = calendar.get(Calendar.SECOND);

            mViewHolder.textHourMinute.setText(String.format(Locale.getDefault(), "%02d:%02d", hour, minutes));
            mViewHolder.textSeconds.setText(String.format(Locale.getDefault(), "%02d", seconds));

            if (hour >= 18 && mLandScape) {
                mViewHolder.textNigth.setVisibility(View.VISIBLE);
            } else if (mLandScape) {
                mViewHolder.textNigth.setVisibility(View.GONE);
            }

            long now = SystemClock.elapsedRealtime();
            long next = now + (1000 - (now % 1000));
            mHandler.postAtTime(mRunnable, next);
        };

        this.mRunnable.run();
    }

    private static class ViewHolder {
        TextView textHourMinute;
        TextView textSeconds;
        TextView textBattery;
        TextView textNigth;
    }
}