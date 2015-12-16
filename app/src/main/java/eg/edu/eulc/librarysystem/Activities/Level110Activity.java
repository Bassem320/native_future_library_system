package eg.edu.eulc.librarysystem.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import eg.edu.eulc.librarysystem.R;

public class Level110Activity extends AppCompatActivity {
    ScrollView parent, child = null,
            level090, level091, level092, level093, level094, level095, level096, level097, level098, level099;

    LinearLayout subject90, subject91, subject92, subject93, subject94, subject95, subject96, subject97, subject98, subject99,
            subject900, subject901, subject902, subject903, subject904, subject905, subject906, subject907, subject908, subject909,
            subject910, subject911, subject912, subject913, subject914, subject915, subject916, subject917, subject918, subject919,
            subject920, subject921, subject922, subject923, subject924, subject925, subject926, subject927, subject928, subject929,
            subject930, subject931, subject932, subject933, subject934, subject935, subject936, subject937, subject938, subject939,
            subject940, subject941, subject942, subject943, subject944, subject945, subject946, subject947, subject948, subject949,
            subject950, subject951, subject952, subject953, subject954, subject955, subject956, subject957, subject958, subject959,
            subject960, subject961, subject962, subject963, subject964, subject965, subject966, subject967, subject968, subject969,
            subject970, subject971, subject972, subject973, subject974, subject975, subject976, subject977, subject978, subject979,
            subject980, subject981, subject982, subject983, subject984, subject985, subject986, subject987, subject988, subject989,
            subject990, subject991, subject992, subject993, subject994, subject995, subject996, subject997, subject998, subject999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level110);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        parent = (ScrollView) findViewById(R.id.level09);

        level090 = (ScrollView) findViewById(R.id.level090);
        level091 = (ScrollView) findViewById(R.id.level091);
        level092 = (ScrollView) findViewById(R.id.level092);
        level093 = (ScrollView) findViewById(R.id.level093);
        level094 = (ScrollView) findViewById(R.id.level094);
        level095 = (ScrollView) findViewById(R.id.level095);
        level096 = (ScrollView) findViewById(R.id.level096);
        level097 = (ScrollView) findViewById(R.id.level097);
        level098 = (ScrollView) findViewById(R.id.level098);
        level099 = (ScrollView) findViewById(R.id.level099);

        subject90 = (LinearLayout) findViewById(R.id.Subject90);
        subject91 = (LinearLayout) findViewById(R.id.Subject91);
        subject92 = (LinearLayout) findViewById(R.id.Subject92);
        subject93 = (LinearLayout) findViewById(R.id.Subject93);
        subject94 = (LinearLayout) findViewById(R.id.Subject94);
        subject95 = (LinearLayout) findViewById(R.id.Subject95);
        subject96 = (LinearLayout) findViewById(R.id.Subject96);
        subject97 = (LinearLayout) findViewById(R.id.Subject97);
        subject98 = (LinearLayout) findViewById(R.id.Subject98);
        subject99 = (LinearLayout) findViewById(R.id.Subject99);

        subject90.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level090;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject91.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level091;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject92.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level092;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject93.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level093;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject94.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level094;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject95.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level095;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject96.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level096;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject97.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level097;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject98.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level098;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject99.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level099;
                child.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (child != null) {
            if (child.getVisibility() == View.VISIBLE) {
                child.setVisibility(View.GONE);
                parent.setVisibility(View.VISIBLE);
            } else {
                super.onBackPressed();
            }
        } else {
            super.onBackPressed();
        }
    }

}
