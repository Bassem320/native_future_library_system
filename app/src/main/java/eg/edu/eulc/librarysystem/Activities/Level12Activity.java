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

public class Level12Activity extends AppCompatActivity {
    ScrollView parent, child = null,
            level010, level011, level012, level013, level014, level015, level016, level017, level018, level019;

    LinearLayout subject10, subject11, subject12, subject13, subject14, subject15, subject16, subject17, subject18, subject19,
            subject100, subject101, subject102, subject103, subject104, subject105, subject106, subject107, subject108, subject109,
            subject110, subject111, subject112, subject113, subject114, subject115, subject116, subject117, subject118, subject119,
            subject120, subject121, subject122, subject123, subject124, subject125, subject126, subject127, subject128, subject129,
            subject130, subject131, subject132, subject133, subject134, subject135, subject136, subject137, subject138, subject139,
            subject140, subject141, subject142, subject143, subject144, subject145, subject146, subject147, subject148, subject149,
            subject150, subject151, subject152, subject153, subject154, subject155, subject156, subject157, subject158, subject159,
            subject160, subject161, subject162, subject163, subject164, subject165, subject166, subject167, subject168, subject169,
            subject170, subject171, subject172, subject173, subject174, subject175, subject176, subject177, subject178, subject179,
            subject180, subject181, subject182, subject183, subject184, subject185, subject186, subject187, subject188, subject189,
            subject190, subject191, subject192, subject193, subject194, subject195, subject196, subject197, subject198, subject199;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level12);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        parent = (ScrollView) findViewById(R.id.level01);

        level010 = (ScrollView) findViewById(R.id.level010);
        level011 = (ScrollView) findViewById(R.id.level011);
        level012 = (ScrollView) findViewById(R.id.level012);
        level013 = (ScrollView) findViewById(R.id.level013);
        level014 = (ScrollView) findViewById(R.id.level014);
        level015 = (ScrollView) findViewById(R.id.level015);
        level016 = (ScrollView) findViewById(R.id.level016);
        level017 = (ScrollView) findViewById(R.id.level017);
        level018 = (ScrollView) findViewById(R.id.level018);
        level019 = (ScrollView) findViewById(R.id.level019);

        subject10 = (LinearLayout) findViewById(R.id.Subject10);
        subject11 = (LinearLayout) findViewById(R.id.Subject11);
        subject12 = (LinearLayout) findViewById(R.id.Subject12);
        subject13 = (LinearLayout) findViewById(R.id.Subject13);
        subject14 = (LinearLayout) findViewById(R.id.Subject14);
        subject15 = (LinearLayout) findViewById(R.id.Subject15);
        subject16 = (LinearLayout) findViewById(R.id.Subject16);
        subject17 = (LinearLayout) findViewById(R.id.Subject17);
        subject18 = (LinearLayout) findViewById(R.id.Subject18);
        subject19 = (LinearLayout) findViewById(R.id.Subject19);

        subject10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level010;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level011;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level012;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level013;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level014;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level015;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level016;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level017;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level018;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level019;
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
