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

public class Level14Activity extends AppCompatActivity {
    ScrollView parent, child = null,
            level030, level031, level032, level033, level034, level035, level036, level037, level038, level039;

    LinearLayout subject30, subject31, subject32, subject33, subject34, subject35, subject36, subject37, subject38, subject39,
            subject300, subject301, subject302, subject303, subject304, subject305, subject306, subject307, subject308, subject309,
            subject310, subject311, subject312, subject313, subject314, subject315, subject316, subject317, subject318, subject319,
            subject320, subject321, subject322, subject323, subject324, subject325, subject326, subject327, subject328, subject329,
            subject330, subject331, subject332, subject333, subject334, subject335, subject336, subject337, subject338, subject339,
            subject340, subject341, subject342, subject343, subject344, subject345, subject346, subject347, subject348, subject349,
            subject350, subject351, subject352, subject353, subject354, subject355, subject356, subject357, subject358, subject359,
            subject360, subject361, subject362, subject363, subject364, subject365, subject366, subject367, subject368, subject369,
            subject370, subject371, subject372, subject373, subject374, subject375, subject376, subject377, subject378, subject379,
            subject380, subject381, subject382, subject383, subject384, subject385, subject386, subject387, subject388, subject389,
            subject390, subject391, subject392, subject393, subject394, subject395, subject396, subject397, subject398, subject399;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level14);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        parent = (ScrollView) findViewById(R.id.level03);

        level030 = (ScrollView) findViewById(R.id.level030);
        level031 = (ScrollView) findViewById(R.id.level031);
        level032 = (ScrollView) findViewById(R.id.level032);
        level033 = (ScrollView) findViewById(R.id.level033);
        level034 = (ScrollView) findViewById(R.id.level034);
        level035 = (ScrollView) findViewById(R.id.level035);
        level036 = (ScrollView) findViewById(R.id.level036);
        level037 = (ScrollView) findViewById(R.id.level037);
        level038 = (ScrollView) findViewById(R.id.level038);
        level039 = (ScrollView) findViewById(R.id.level039);

        subject30 = (LinearLayout) findViewById(R.id.Subject30);
        subject31 = (LinearLayout) findViewById(R.id.Subject31);
        subject32 = (LinearLayout) findViewById(R.id.Subject32);
        subject33 = (LinearLayout) findViewById(R.id.Subject33);
        subject34 = (LinearLayout) findViewById(R.id.Subject34);
        subject35 = (LinearLayout) findViewById(R.id.Subject35);
        subject36 = (LinearLayout) findViewById(R.id.Subject36);
        subject37 = (LinearLayout) findViewById(R.id.Subject37);
        subject38 = (LinearLayout) findViewById(R.id.Subject38);
        subject39 = (LinearLayout) findViewById(R.id.Subject39);

        subject30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level030;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level031;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level032;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level033;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level034;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level035;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level036;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level037;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level038;
                child.setVisibility(View.VISIBLE);
            }
        });
        subject39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setVisibility(View.GONE);
                child = level039;
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
