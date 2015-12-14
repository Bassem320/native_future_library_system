package eg.edu.eulc.librarysystem.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ScrollView;

import eg.edu.eulc.librarysystem.R;

public class BrowseActivity extends AppCompatActivity {
    ScrollView mainParent, parent;
    ScrollView level00, level01, level02, level03, level04, level05, level06, level07, level08, level09;

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
        }
    }

}
