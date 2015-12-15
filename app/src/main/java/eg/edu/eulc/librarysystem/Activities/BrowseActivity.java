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

public class BrowseActivity extends AppCompatActivity {
    ScrollView mainParent, parent = null;
    ScrollView level00, level01, level02, level03, level04, level05, level06, level07, level08, level09,
    level000, level001, level002, level003, level004, level005, level006, level007, level008, level009;
    LinearLayout subject00, subject01, subject02, subject03, subject04, subject05, subject06, subject07, subject08, subject09;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        level00 = (ScrollView) findViewById(R.id.level00);
        level01 = (ScrollView) findViewById(R.id.level01);
        level02 = (ScrollView) findViewById(R.id.level02);
        level03 = (ScrollView) findViewById(R.id.level03);
        level04 = (ScrollView) findViewById(R.id.level04);
        level05 = (ScrollView) findViewById(R.id.level05);
        level06 = (ScrollView) findViewById(R.id.level06);
        level07 = (ScrollView) findViewById(R.id.level07);
        level08 = (ScrollView) findViewById(R.id.level08);
        level09 = (ScrollView) findViewById(R.id.level09);
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

        Bundle bundle = BrowseActivity.this.getIntent().getExtras();
        if(bundle!=null) {
            int subjectIndex = bundle.getInt("SubjectsIndex");
            switch (subjectIndex) {
                case 0:
                    mainParent = level00;
                    break;
                case 1:
                    mainParent = level01;
                    break;
                case 2:
                    mainParent = level02;
                    break;
                case 3:
                    mainParent = level03;
                    break;
                case 4:
                    mainParent = level04;
                    break;
                case 5:
                    mainParent = level05;
                    break;
                case 6:
                    mainParent = level06;
                    break;
                case 7:
                    mainParent = level07;
                    break;
                case 8:
                    mainParent = level08;
                    break;
                case 9:
                    mainParent = level09;
                    break;
                default:
                    mainParent = null;
                    break;
            }

            if (mainParent != null) {
                mainParent.setVisibility(View.VISIBLE);
            }

            subject00.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level000;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject01.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level001;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject02.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level002;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject03.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level003;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject04.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level004;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject05.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level005;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject06.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level006;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject07.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level007;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject08.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level008;
                    parent.setVisibility(View.VISIBLE);
                }
            });
            subject09.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainParent.setVisibility(View.GONE);
                    parent = level009;
                    parent.setVisibility(View.VISIBLE);
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        if (parent != null) {
            if (parent.getVisibility() == View.VISIBLE) {
                parent.setVisibility(View.GONE);
                mainParent.setVisibility(View.VISIBLE);
            } else {
                super.onBackPressed();
            }
        } else {
            super.onBackPressed();
        }
    }
}
