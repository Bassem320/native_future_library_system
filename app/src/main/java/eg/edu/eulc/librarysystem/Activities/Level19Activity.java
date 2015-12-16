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

public class Level19Activity extends AppCompatActivity {
    ScrollView parent, child = null,
            level080, level081, level082, level083, level084, level085, level086, level087, level088, level089;

    LinearLayout subject80, subject81, subject82, subject83, subject84, subject85, subject86, subject87, subject88, subject89,
            subject800, subject801, subject802, subject803, subject804, subject805, subject806, subject807, subject808, subject809,
            subject810, subject811, subject812, subject813, subject814, subject815, subject816, subject817, subject818, subject819,
            subject820, subject821, subject822, subject823, subject824, subject825, subject826, subject827, subject828, subject829,
            subject830, subject831, subject832, subject833, subject834, subject835, subject836, subject837, subject838, subject839,
            subject840, subject841, subject842, subject843, subject844, subject845, subject846, subject847, subject848, subject849,
            subject850, subject851, subject852, subject853, subject854, subject855, subject856, subject857, subject858, subject859,
            subject860, subject861, subject862, subject863, subject864, subject865, subject866, subject867, subject868, subject869,
            subject870, subject871, subject872, subject873, subject874, subject875, subject876, subject877, subject878, subject879,
            subject880, subject881, subject882, subject883, subject884, subject885, subject886, subject887, subject888, subject889,
            subject890, subject891, subject892, subject893, subject894, subject895, subject896, subject897, subject898, subject899;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level19);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        parent = (ScrollView) findViewById(R.id.level08);

        level080 = (ScrollView) findViewById(R.id.level080);
        level081 = (ScrollView) findViewById(R.id.level081);
        level082 = (ScrollView) findViewById(R.id.level082);
        level083 = (ScrollView) findViewById(R.id.level083);
        level084 = (ScrollView) findViewById(R.id.level084);
        level085 = (ScrollView) findViewById(R.id.level085);
        level086 = (ScrollView) findViewById(R.id.level086);
        level087 = (ScrollView) findViewById(R.id.level087);
        level088 = (ScrollView) findViewById(R.id.level088);
        level089 = (ScrollView) findViewById(R.id.level089);

        subject80 = (LinearLayout) findViewById(R.id.Subject80);
        subject81 = (LinearLayout) findViewById(R.id.Subject81);
        subject82 = (LinearLayout) findViewById(R.id.Subject82);
        subject83 = (LinearLayout) findViewById(R.id.Subject83);
        subject84 = (LinearLayout) findViewById(R.id.Subject84);
        subject85 = (LinearLayout) findViewById(R.id.Subject85);
        subject86 = (LinearLayout) findViewById(R.id.Subject86);
        subject87 = (LinearLayout) findViewById(R.id.Subject87);
        subject88 = (LinearLayout) findViewById(R.id.Subject88);
        subject89 = (LinearLayout) findViewById(R.id.Subject89);

        subject80.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level080;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject81.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level081;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject82.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level082;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject83.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level083;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject84.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level084;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject85.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level085;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject86.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level086;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject87.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level087;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject88.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level088;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject89.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level089;
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
