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

public class Level17Activity extends AppCompatActivity {
    ScrollView parent, child = null,
            level060, level061, level062, level063, level064, level065, level066, level067, level068, level069;

    LinearLayout subject60, subject61, subject62, subject63, subject64, subject65, subject66, subject67, subject68, subject69,
            subject600, subject601, subject602, subject603, subject604, subject605, subject606, subject607, subject608, subject609,
            subject610, subject611, subject612, subject613, subject614, subject615, subject616, subject617, subject618, subject619,
            subject620, subject621, subject622, subject623, subject624, subject625, subject626, subject627, subject628, subject629,
            subject630, subject631, subject632, subject633, subject634, subject635, subject636, subject637, subject638, subject639,
            subject640, subject641, subject642, subject643, subject644, subject645, subject646, subject647, subject648, subject649,
            subject650, subject651, subject652, subject653, subject654, subject655, subject656, subject657, subject658, subject659,
            subject660, subject661, subject662, subject663, subject664, subject665, subject666, subject667, subject668, subject669,
            subject670, subject671, subject672, subject673, subject674, subject675, subject676, subject677, subject678, subject679,
            subject680, subject681, subject682, subject683, subject684, subject685, subject686, subject687, subject688, subject689,
            subject690, subject691, subject692, subject693, subject694, subject695, subject696, subject697, subject698, subject699;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level17);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        parent = (ScrollView) findViewById(R.id.level06);

        level060 = (ScrollView) findViewById(R.id.level060);
        level061 = (ScrollView) findViewById(R.id.level061);
        level062 = (ScrollView) findViewById(R.id.level062);
        level063 = (ScrollView) findViewById(R.id.level063);
        level064 = (ScrollView) findViewById(R.id.level064);
        level065 = (ScrollView) findViewById(R.id.level065);
        level066 = (ScrollView) findViewById(R.id.level066);
        level067 = (ScrollView) findViewById(R.id.level067);
        level068 = (ScrollView) findViewById(R.id.level068);
        level069 = (ScrollView) findViewById(R.id.level069);

        subject60 = (LinearLayout) findViewById(R.id.Subject60);
        subject61 = (LinearLayout) findViewById(R.id.Subject61);
        subject62 = (LinearLayout) findViewById(R.id.Subject62);
        subject63 = (LinearLayout) findViewById(R.id.Subject63);
        subject64 = (LinearLayout) findViewById(R.id.Subject64);
        subject65 = (LinearLayout) findViewById(R.id.Subject65);
        subject66 = (LinearLayout) findViewById(R.id.Subject66);
        subject67 = (LinearLayout) findViewById(R.id.Subject67);
        subject68 = (LinearLayout) findViewById(R.id.Subject68);
        subject69 = (LinearLayout) findViewById(R.id.Subject69);

        subject60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level060;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level061;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level062;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level063;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level064;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject65.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level065;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level066;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject67.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level067;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject68.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level068;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject69.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level069;
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
