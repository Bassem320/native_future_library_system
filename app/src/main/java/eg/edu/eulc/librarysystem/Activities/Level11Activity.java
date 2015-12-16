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

public class Level11Activity extends AppCompatActivity {
    ScrollView parent, child = null,
            level000, level001, level002, level003, level004, level005, level006, level007, level008, level009;

    LinearLayout subject00, subject01, subject02, subject03, subject04, subject05, subject06, subject07, subject08, subject09,
            subject000, subject001, subject002, subject003, subject004, subject005, subject006, subject007, subject008, subject009,
            subject010, subject011, subject012, subject013, subject014, subject015, subject016, subject017, subject018, subject019,
            subject020, subject021, subject022, subject023, subject024, subject025, subject026, subject027, subject028, subject029,
            subject030, subject031, subject032, subject033, subject034, subject035, subject036, subject037, subject038, subject039,
            subject040, subject041, subject042, subject043, subject044, subject045, subject046, subject047, subject048, subject049,
            subject050, subject051, subject052, subject053, subject054, subject055, subject056, subject057, subject058, subject059,
            subject060, subject061, subject062, subject063, subject064, subject065, subject066, subject067, subject068, subject069,
            subject070, subject071, subject072, subject073, subject074, subject075, subject076, subject077, subject078, subject079,
            subject080, subject081, subject082, subject083, subject084, subject085, subject086, subject087, subject088, subject089,
            subject090, subject091, subject092, subject093, subject094, subject095, subject096, subject097, subject098, subject099;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level11);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        parent = (ScrollView) findViewById(R.id.level00);

        level000 = (ScrollView) findViewById(R.id.level000);
        level001 = (ScrollView) findViewById(R.id.level001);
        level002 = (ScrollView) findViewById(R.id.level002);
        level003 = (ScrollView) findViewById(R.id.level003);
        level004 = (ScrollView) findViewById(R.id.level004);
        level005 = (ScrollView) findViewById(R.id.level005);
        level006 = (ScrollView) findViewById(R.id.level006);
        level007 = (ScrollView) findViewById(R.id.level007);
        level008 = (ScrollView) findViewById(R.id.level008);
        level009 = (ScrollView) findViewById(R.id.level009);

        subject00 = (LinearLayout) findViewById(R.id.Subject00);
        subject01 = (LinearLayout) findViewById(R.id.Subject01);
        subject02 = (LinearLayout) findViewById(R.id.Subject02);
        subject03 = (LinearLayout) findViewById(R.id.Subject03);
        subject04 = (LinearLayout) findViewById(R.id.Subject04);
        subject05 = (LinearLayout) findViewById(R.id.Subject05);
        subject06 = (LinearLayout) findViewById(R.id.Subject06);
        subject07 = (LinearLayout) findViewById(R.id.Subject07);
        subject08 = (LinearLayout) findViewById(R.id.Subject08);
        subject09 = (LinearLayout) findViewById(R.id.Subject09);

        subject00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level000;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level001;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level002;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level003;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level004;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level005;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level006;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level007;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level008;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level009;
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
