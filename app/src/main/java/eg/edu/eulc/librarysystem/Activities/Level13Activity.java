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

public class Level13Activity extends AppCompatActivity {
    ScrollView parent, child = null,
            level020, level021, level022, level023, level024, level025, level026, level027, level028, level029;

    LinearLayout subject20, subject21, subject22, subject23, subject24, subject25, subject26, subject27, subject28, subject29,
            subject200, subject201, subject202, subject203, subject204, subject205, subject206, subject207, subject208, subject209,
            subject210, subject211, subject212, subject213, subject214, subject215, subject216, subject217, subject218, subject219,
            subject220, subject221, subject222, subject223, subject224, subject225, subject226, subject227, subject228, subject229,
            subject230, subject231, subject232, subject233, subject234, subject235, subject236, subject237, subject238, subject239,
            subject240, subject241, subject242, subject243, subject244, subject245, subject246, subject247, subject248, subject249,
            subject250, subject251, subject252, subject253, subject254, subject255, subject256, subject257, subject258, subject259,
            subject260, subject261, subject262, subject263, subject264, subject265, subject266, subject267, subject268, subject269,
            subject270, subject271, subject272, subject273, subject274, subject275, subject276, subject277, subject278, subject279,
            subject280, subject281, subject282, subject283, subject284, subject285, subject286, subject287, subject288, subject289,
            subject290, subject291, subject292, subject293, subject294, subject295, subject296, subject297, subject298, subject299;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level13);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        parent = (ScrollView) findViewById(R.id.level02);

        level020 = (ScrollView) findViewById(R.id.level020);
        level021 = (ScrollView) findViewById(R.id.level021);
        level022 = (ScrollView) findViewById(R.id.level022);
        level023 = (ScrollView) findViewById(R.id.level023);
        level024 = (ScrollView) findViewById(R.id.level024);
        level025 = (ScrollView) findViewById(R.id.level025);
        level026 = (ScrollView) findViewById(R.id.level026);
        level027 = (ScrollView) findViewById(R.id.level027);
        level028 = (ScrollView) findViewById(R.id.level028);
        level029 = (ScrollView) findViewById(R.id.level029);

        subject20 = (LinearLayout) findViewById(R.id.Subject20);
        subject21 = (LinearLayout) findViewById(R.id.Subject21);
        subject22 = (LinearLayout) findViewById(R.id.Subject22);
        subject23 = (LinearLayout) findViewById(R.id.Subject23);
        subject24 = (LinearLayout) findViewById(R.id.Subject24);
        subject25 = (LinearLayout) findViewById(R.id.Subject25);
        subject26 = (LinearLayout) findViewById(R.id.Subject26);
        subject27 = (LinearLayout) findViewById(R.id.Subject27);
        subject28 = (LinearLayout) findViewById(R.id.Subject28);
        subject29 = (LinearLayout) findViewById(R.id.Subject29);

        subject20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level020;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level021;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level022;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level023;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level024;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level025;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level026;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level027;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level028;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level029;
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
