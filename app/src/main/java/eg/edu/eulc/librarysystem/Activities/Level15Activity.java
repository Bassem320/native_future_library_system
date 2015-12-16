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

public class Level15Activity extends AppCompatActivity {
    ScrollView parent, child = null,
            level040, level041, level042, level043, level044, level045, level046, level047, level048, level049;

    LinearLayout subject40, subject41, subject42, subject43, subject44, subject45, subject46, subject47, subject48, subject49,
            subject400, subject401, subject402, subject403, subject404, subject405, subject406, subject407, subject408, subject409,
            subject410, subject411, subject412, subject413, subject414, subject415, subject416, subject417, subject418, subject419,
            subject420, subject421, subject422, subject423, subject424, subject425, subject426, subject427, subject428, subject429,
            subject430, subject431, subject432, subject433, subject434, subject435, subject436, subject437, subject438, subject439,
            subject440, subject441, subject442, subject443, subject444, subject445, subject446, subject447, subject448, subject449,
            subject450, subject451, subject452, subject453, subject454, subject455, subject456, subject457, subject458, subject459,
            subject460, subject461, subject462, subject463, subject464, subject465, subject466, subject467, subject468, subject469,
            subject470, subject471, subject472, subject473, subject474, subject475, subject476, subject477, subject478, subject479,
            subject480, subject481, subject482, subject483, subject484, subject485, subject486, subject487, subject488, subject489,
            subject490, subject491, subject492, subject493, subject494, subject495, subject496, subject497, subject498, subject499;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level15);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        parent = (ScrollView) findViewById(R.id.level04);

        level040 = (ScrollView) findViewById(R.id.level040);
        level041 = (ScrollView) findViewById(R.id.level041);
        level042 = (ScrollView) findViewById(R.id.level042);
        level043 = (ScrollView) findViewById(R.id.level043);
        level044 = (ScrollView) findViewById(R.id.level044);
        level045 = (ScrollView) findViewById(R.id.level045);
        level046 = (ScrollView) findViewById(R.id.level046);
        level047 = (ScrollView) findViewById(R.id.level047);
        level048 = (ScrollView) findViewById(R.id.level048);
        level049 = (ScrollView) findViewById(R.id.level049);

        subject40 = (LinearLayout) findViewById(R.id.Subject40);
        subject41 = (LinearLayout) findViewById(R.id.Subject41);
        subject42 = (LinearLayout) findViewById(R.id.Subject42);
        subject43 = (LinearLayout) findViewById(R.id.Subject43);
        subject44 = (LinearLayout) findViewById(R.id.Subject44);
        subject45 = (LinearLayout) findViewById(R.id.Subject45);
        subject46 = (LinearLayout) findViewById(R.id.Subject46);
        subject47 = (LinearLayout) findViewById(R.id.Subject47);
        subject48 = (LinearLayout) findViewById(R.id.Subject48);
        subject49 = (LinearLayout) findViewById(R.id.Subject49);

        subject40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level040;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level041;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level042;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level043;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level044;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level045;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level046;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level047;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level048;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level049;
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
