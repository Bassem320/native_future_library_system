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

public class Level16Activity extends AppCompatActivity {
    ScrollView parent, child = null,
            level050, level051, level052, level053, level054, level055, level056, level057, level058, level059;

    LinearLayout subject50, subject51, subject52, subject53, subject54, subject55, subject56, subject57, subject58, subject59,
            subject500, subject501, subject502, subject503, subject504, subject505, subject506, subject507, subject508, subject509,
            subject510, subject511, subject512, subject513, subject514, subject515, subject516, subject517, subject518, subject519,
            subject520, subject521, subject522, subject523, subject524, subject525, subject526, subject527, subject528, subject529,
            subject530, subject531, subject532, subject533, subject534, subject535, subject536, subject537, subject538, subject539,
            subject540, subject541, subject542, subject543, subject544, subject545, subject546, subject547, subject548, subject549,
            subject550, subject551, subject552, subject553, subject554, subject555, subject556, subject557, subject558, subject559,
            subject560, subject561, subject562, subject563, subject564, subject565, subject566, subject567, subject568, subject569,
            subject570, subject571, subject572, subject573, subject574, subject575, subject576, subject577, subject578, subject579,
            subject580, subject581, subject582, subject583, subject584, subject585, subject586, subject587, subject588, subject589,
            subject590, subject591, subject592, subject593, subject594, subject595, subject596, subject597, subject598, subject599;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level16);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        parent = (ScrollView) findViewById(R.id.level05);

        level050 = (ScrollView) findViewById(R.id.level050);
        level051 = (ScrollView) findViewById(R.id.level051);
        level052 = (ScrollView) findViewById(R.id.level052);
        level053 = (ScrollView) findViewById(R.id.level053);
        level054 = (ScrollView) findViewById(R.id.level054);
        level055 = (ScrollView) findViewById(R.id.level055);
        level056 = (ScrollView) findViewById(R.id.level056);
        level057 = (ScrollView) findViewById(R.id.level057);
        level058 = (ScrollView) findViewById(R.id.level058);
        level059 = (ScrollView) findViewById(R.id.level059);

        subject50 = (LinearLayout) findViewById(R.id.Subject50);
        subject51 = (LinearLayout) findViewById(R.id.Subject51);
        subject52 = (LinearLayout) findViewById(R.id.Subject52);
        subject53 = (LinearLayout) findViewById(R.id.Subject53);
        subject54 = (LinearLayout) findViewById(R.id.Subject54);
        subject55 = (LinearLayout) findViewById(R.id.Subject55);
        subject56 = (LinearLayout) findViewById(R.id.Subject56);
        subject57 = (LinearLayout) findViewById(R.id.Subject57);
        subject58 = (LinearLayout) findViewById(R.id.Subject58);
        subject59 = (LinearLayout) findViewById(R.id.Subject59);

        subject50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level050;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level051;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level052;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level053;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level054;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level055;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject56.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level056;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject57.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level057;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject58.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level058;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject59.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level059;
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
