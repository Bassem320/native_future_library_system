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

public class Level18Activity extends AppCompatActivity {
    ScrollView parent, child = null,
            level070, level071, level072, level073, level074, level075, level076, level077, level078, level079;

    LinearLayout subject70, subject71, subject72, subject73, subject74, subject75, subject76, subject77, subject78, subject79,
            subject700, subject701, subject702, subject703, subject704, subject705, subject706, subject707, subject708, subject709,
            subject710, subject711, subject712, subject713, subject714, subject715, subject716, subject717, subject718, subject719,
            subject720, subject721, subject722, subject723, subject724, subject725, subject726, subject727, subject728, subject729,
            subject730, subject731, subject732, subject733, subject734, subject735, subject736, subject737, subject738, subject739,
            subject740, subject741, subject742, subject743, subject744, subject745, subject746, subject747, subject748, subject749,
            subject750, subject751, subject752, subject753, subject754, subject755, subject756, subject757, subject758, subject759,
            subject760, subject761, subject762, subject763, subject764, subject765, subject766, subject767, subject768, subject769,
            subject770, subject771, subject772, subject773, subject774, subject775, subject776, subject777, subject778, subject779,
            subject780, subject781, subject782, subject783, subject784, subject785, subject786, subject787, subject788, subject789,
            subject790, subject791, subject792, subject793, subject794, subject795, subject796, subject797, subject798, subject799;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level18);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        parent = (ScrollView) findViewById(R.id.level07);

        level070 = (ScrollView) findViewById(R.id.level070);
        level071 = (ScrollView) findViewById(R.id.level071);
        level072 = (ScrollView) findViewById(R.id.level072);
        level073 = (ScrollView) findViewById(R.id.level073);
        level074 = (ScrollView) findViewById(R.id.level074);
        level075 = (ScrollView) findViewById(R.id.level075);
        level076 = (ScrollView) findViewById(R.id.level076);
        level077 = (ScrollView) findViewById(R.id.level077);
        level078 = (ScrollView) findViewById(R.id.level078);
        level079 = (ScrollView) findViewById(R.id.level079);

        subject70 = (LinearLayout) findViewById(R.id.Subject70);
        subject71 = (LinearLayout) findViewById(R.id.Subject71);
        subject72 = (LinearLayout) findViewById(R.id.Subject72);
        subject73 = (LinearLayout) findViewById(R.id.Subject73);
        subject74 = (LinearLayout) findViewById(R.id.Subject74);
        subject75 = (LinearLayout) findViewById(R.id.Subject75);
        subject76 = (LinearLayout) findViewById(R.id.Subject76);
        subject77 = (LinearLayout) findViewById(R.id.Subject77);
        subject78 = (LinearLayout) findViewById(R.id.Subject78);
        subject79 = (LinearLayout) findViewById(R.id.Subject79);

        subject70.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level070;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject71.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level071;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject72.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level072;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject73.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level073;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject74.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level074;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject75.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level075;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject76.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level076;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject77.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level077;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject78.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level078;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level079;
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
