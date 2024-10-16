package bh.edu.ku.futurelibrary.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import bh.edu.ku.futurelibrary.FragmentsDialogs.ResultsStartAdapter;
import bh.edu.ku.futurelibrary.MyApplication;
import bh.edu.ku.futurelibrary.Objects.ResultsStartItem;
import bh.edu.ku.futurelibrary.VolleySingleton;
import bh.edu.ku.futurelibrary.R;

public class Level110Activity extends AppCompatActivity {
    public static final String PREF_FILE_NAME = "LibrarySystemPref";
    public static final String TAG = "LEVEL10";
    ScrollView parent, child = null,
            level090, level091, level092, level093, level094, level095, level096, level097, level098, level099;
    LinearLayout subject90, subject91, subject92, subject93, subject94, subject95, subject96, subject97, subject98, subject99,
            subject900, subject901, subject902, subject903, subject904, subject905, subject906, subject907, subject908, subject909,
            subject910, subject911, subject912, subject913, subject914, subject915, subject916, subject917, subject918, subject919,
            subject920, subject921, subject922, subject923, subject924, subject925, subject926, subject927, subject928, subject929,
            subject930, subject931, subject932, subject933, subject934, subject935, subject936, subject937, subject938, subject939,
            subject940, subject941, subject942, subject943, subject944, subject945, subject946, subject947, subject948, subject949,
            subject950, subject951, subject952, subject953, subject954, subject955, subject956, subject957, subject958, subject959,
            subject960, subject961, subject962, subject963, subject964, subject965, subject966, subject967, subject968, subject969,
            subject970, subject971, subject972, subject973, subject974, subject975, subject976, subject977, subject978, subject979,
            subject980, subject981, subject982, subject983, subject984, subject985, subject986, subject987, subject988, subject989,
            subject990, subject991, subject992, subject993, subject994, subject995, subject996, subject997, subject998, subject999;
    private SwipeRefreshLayout resultsSwipe;
    private RecyclerView resultsRecycler;
    private ArrayList<ResultsStartItem> resultsList = new ArrayList<>();
    private ResultsStartAdapter resultsAdapter;
    private LinearLayoutManager linearLayoutManager;
    private SharedPreferences sharedPreferences;

    private RequestQueue requestQueue;

    private String layout, classNo, nextPage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level110);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        parent = findViewById(R.id.level09);

        level090 = findViewById(R.id.level090);
        level091 = findViewById(R.id.level091);
        level092 = findViewById(R.id.level092);
        level093 = findViewById(R.id.level093);
        level094 = findViewById(R.id.level094);
        level095 = findViewById(R.id.level095);
        level096 = findViewById(R.id.level096);
        level097 = findViewById(R.id.level097);
        level098 = findViewById(R.id.level098);
        level099 = findViewById(R.id.level099);

        subject90 = findViewById(R.id.Subject90);
        subject91 = findViewById(R.id.Subject91);
        subject92 = findViewById(R.id.Subject92);
        subject93 = findViewById(R.id.Subject93);
        subject94 = findViewById(R.id.Subject94);
        subject95 = findViewById(R.id.Subject95);
        subject96 = findViewById(R.id.Subject96);
        subject97 = findViewById(R.id.Subject97);
        subject98 = findViewById(R.id.Subject98);
        subject99 = findViewById(R.id.Subject99);

        subject900 = findViewById(R.id.Subject900);
        subject901 = findViewById(R.id.Subject901);
        subject902 = findViewById(R.id.Subject902);
        subject903 = findViewById(R.id.Subject903);
        subject904 = findViewById(R.id.Subject904);
        subject905 = findViewById(R.id.Subject905);
        subject906 = findViewById(R.id.Subject906);
        subject907 = findViewById(R.id.Subject907);
        subject908 = findViewById(R.id.Subject908);
        subject909 = findViewById(R.id.Subject909);

        subject910 = findViewById(R.id.Subject910);
        subject911 = findViewById(R.id.Subject911);
        subject912 = findViewById(R.id.Subject912);
        subject913 = findViewById(R.id.Subject913);
        subject914 = findViewById(R.id.Subject914);
        subject915 = findViewById(R.id.Subject915);
        subject916 = findViewById(R.id.Subject916);
        subject917 = findViewById(R.id.Subject917);
        subject918 = findViewById(R.id.Subject918);
        subject919 = findViewById(R.id.Subject919);

        subject920 = findViewById(R.id.Subject920);
        subject921 = findViewById(R.id.Subject921);
        subject922 = findViewById(R.id.Subject922);
        subject923 = findViewById(R.id.Subject923);
        subject924 = findViewById(R.id.Subject924);
        subject925 = findViewById(R.id.Subject925);
        subject926 = findViewById(R.id.Subject926);
        subject927 = findViewById(R.id.Subject927);
        subject928 = findViewById(R.id.Subject928);
        subject929 = findViewById(R.id.Subject929);

        subject930 = findViewById(R.id.Subject930);
        subject931 = findViewById(R.id.Subject931);
        subject932 = findViewById(R.id.Subject932);
        subject933 = findViewById(R.id.Subject933);
        subject934 = findViewById(R.id.Subject934);
        subject935 = findViewById(R.id.Subject935);
        subject936 = findViewById(R.id.Subject936);
        subject937 = findViewById(R.id.Subject937);
        subject938 = findViewById(R.id.Subject938);
        subject939 = findViewById(R.id.Subject939);

        subject940 = findViewById(R.id.Subject940);
        subject941 = findViewById(R.id.Subject941);
        subject942 = findViewById(R.id.Subject942);
        subject943 = findViewById(R.id.Subject943);
        subject944 = findViewById(R.id.Subject944);
        subject945 = findViewById(R.id.Subject945);
        subject946 = findViewById(R.id.Subject946);
        subject947 = findViewById(R.id.Subject947);
        subject948 = findViewById(R.id.Subject948);
        subject949 = findViewById(R.id.Subject949);

        subject950 = findViewById(R.id.Subject950);
        subject951 = findViewById(R.id.Subject951);
        subject952 = findViewById(R.id.Subject952);
        subject953 = findViewById(R.id.Subject953);
        subject954 = findViewById(R.id.Subject954);
        subject955 = findViewById(R.id.Subject955);
        subject956 = findViewById(R.id.Subject956);
        subject957 = findViewById(R.id.Subject957);
        subject958 = findViewById(R.id.Subject958);
        subject959 = findViewById(R.id.Subject959);

        subject960 = findViewById(R.id.Subject960);
        subject961 = findViewById(R.id.Subject961);
        subject962 = findViewById(R.id.Subject962);
        subject963 = findViewById(R.id.Subject963);
        subject964 = findViewById(R.id.Subject964);
        subject965 = findViewById(R.id.Subject965);
        subject966 = findViewById(R.id.Subject966);
        subject967 = findViewById(R.id.Subject967);
        subject968 = findViewById(R.id.Subject968);
        subject969 = findViewById(R.id.Subject969);

        subject970 = findViewById(R.id.Subject970);
        subject971 = findViewById(R.id.Subject971);
        subject972 = findViewById(R.id.Subject972);
        subject973 = findViewById(R.id.Subject973);
        subject974 = findViewById(R.id.Subject974);
        subject975 = findViewById(R.id.Subject975);
        subject976 = findViewById(R.id.Subject976);
        subject977 = findViewById(R.id.Subject977);
        subject978 = findViewById(R.id.Subject978);
        subject979 = findViewById(R.id.Subject979);

        subject980 = findViewById(R.id.Subject980);
        subject981 = findViewById(R.id.Subject981);
        subject982 = findViewById(R.id.Subject982);
        subject983 = findViewById(R.id.Subject983);
        subject984 = findViewById(R.id.Subject984);
        subject985 = findViewById(R.id.Subject985);
        subject986 = findViewById(R.id.Subject986);
        subject987 = findViewById(R.id.Subject987);
        subject988 = findViewById(R.id.Subject988);
        subject989 = findViewById(R.id.Subject989);

        subject990 = findViewById(R.id.Subject990);
        subject991 = findViewById(R.id.Subject991);
        subject992 = findViewById(R.id.Subject992);
        subject993 = findViewById(R.id.Subject993);
        subject994 = findViewById(R.id.Subject994);
        subject995 = findViewById(R.id.Subject995);
        subject996 = findViewById(R.id.Subject996);
        subject997 = findViewById(R.id.Subject997);
        subject998 = findViewById(R.id.Subject998);
        subject999 = findViewById(R.id.Subject999);

        resultsSwipe = findViewById(R.id.ResultsSwipeRefresh);
        resultsRecycler = findViewById(R.id.ResultsRecycler);

        sharedPreferences = Level110Activity.this.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);

        VolleySingleton volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();

        subject90.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level090;
            child.setVisibility(View.VISIBLE);
        });
        subject91.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level091;
            child.setVisibility(View.VISIBLE);
        });
        subject92.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level092;
            child.setVisibility(View.VISIBLE);
        });
        subject93.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level093;
            child.setVisibility(View.VISIBLE);
        });
        subject94.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level094;
            child.setVisibility(View.VISIBLE);
        });
        subject95.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level095;
            child.setVisibility(View.VISIBLE);
        });
        subject96.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level096;
            child.setVisibility(View.VISIBLE);
        });
        subject97.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level097;
            child.setVisibility(View.VISIBLE);
        });
        subject98.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level098;
            child.setVisibility(View.VISIBLE);
        });
        subject99.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level099;
            child.setVisibility(View.VISIBLE);
        });

        resultsSwipe.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent);
        resultsSwipe.setOnRefreshListener(() -> resultsSwipe.setRefreshing(false));

        subject900.setOnClickListener(v -> {
            layout = "1.10.1.1.";
            classNo = "900";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject901.setOnClickListener(v -> {
            layout = "1.10.1.2.";
            classNo = "901";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject902.setOnClickListener(v -> {
            layout = "1.10.1.3.";
            classNo = "902";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject903.setOnClickListener(v -> {
            layout = "1.10.1.4.";
            classNo = "903";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject904.setOnClickListener(v -> {
            layout = "1.10.1.5.";
            classNo = "904";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject905.setOnClickListener(v -> {
            layout = "1.10.1.6.";
            classNo = "905";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject906.setOnClickListener(v -> {
            layout = "1.10.1.7.";
            classNo = "906";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject907.setOnClickListener(v -> {
            layout = "1.10.1.8.";
            classNo = "907";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject908.setOnClickListener(v -> {
            layout = "1.10.1.9.";
            classNo = "908";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject909.setOnClickListener(v -> {
            layout = "1.10.1.10.";
            classNo = "909";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject910.setOnClickListener(v -> {
            layout = "1.10.2.1.";
            classNo = "910";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject911.setOnClickListener(v -> {
            layout = "1.10.2.2.";
            classNo = "911";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject912.setOnClickListener(v -> {
            layout = "1.10.2.3.";
            classNo = "912";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject913.setOnClickListener(v -> {
            layout = "1.10.2.4.";
            classNo = "913";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject914.setOnClickListener(v -> {
            layout = "1.10.2.5.";
            classNo = "914";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject915.setOnClickListener(v -> {
            layout = "1.10.2.6.";
            classNo = "915";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject916.setOnClickListener(v -> {
            layout = "1.10.2.7.";
            classNo = "916";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject917.setOnClickListener(v -> {
            layout = "1.10.2.8.";
            classNo = "917";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject918.setOnClickListener(v -> {
            layout = "1.10.2.9.";
            classNo = "918";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject919.setOnClickListener(v -> {
            layout = "1.10.2.10.";
            classNo = "919";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject920.setOnClickListener(v -> {
            layout = "1.10.3.1.";
            classNo = "920";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject921.setOnClickListener(v -> {
            layout = "1.10.3.2.";
            classNo = "921";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject922.setOnClickListener(v -> {
            layout = "1.10.3.3.";
            classNo = "922";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject923.setOnClickListener(v -> {
            layout = "1.10.3.4.";
            classNo = "923";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject924.setOnClickListener(v -> {
            layout = "1.10.3.5.";
            classNo = "924";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject925.setOnClickListener(v -> {
            layout = "1.10.3.6.";
            classNo = "925";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject926.setOnClickListener(v -> {
            layout = "1.10.3.7.";
            classNo = "926";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject927.setOnClickListener(v -> {
            layout = "1.10.3.8.";
            classNo = "927";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject928.setOnClickListener(v -> {
            layout = "1.10.3.9.";
            classNo = "928";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject929.setOnClickListener(v -> {
            layout = "1.10.3.10.";
            classNo = "929";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject930.setOnClickListener(v -> {
            layout = "1.10.4.1.";
            classNo = "930";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject931.setOnClickListener(v -> {
            layout = "1.10.4.2.";
            classNo = "931";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject932.setOnClickListener(v -> {
            layout = "1.10.4.3.";
            classNo = "932";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject933.setOnClickListener(v -> {
            layout = "1.10.4.4.";
            classNo = "933";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject934.setOnClickListener(v -> {
            layout = "1.10.4.5.";
            classNo = "934";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject935.setOnClickListener(v -> {
            layout = "1.10.4.6.";
            classNo = "935";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject936.setOnClickListener(v -> {
            layout = "1.10.4.7.";
            classNo = "936";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject937.setOnClickListener(v -> {
            layout = "1.10.4.8.";
            classNo = "937";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject938.setOnClickListener(v -> {
            layout = "1.10.4.9.";
            classNo = "938";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject939.setOnClickListener(v -> {
            layout = "1.10.4.10.";
            classNo = "939";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject940.setOnClickListener(v -> {
            layout = "1.10.5.1.";
            classNo = "940";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject941.setOnClickListener(v -> {
            layout = "1.10.5.2.";
            classNo = "941";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject942.setOnClickListener(v -> {
            layout = "1.10.5.3.";
            classNo = "942";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject943.setOnClickListener(v -> {
            layout = "1.10.5.4.";
            classNo = "943";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject944.setOnClickListener(v -> {
            layout = "1.10.5.5.";
            classNo = "944";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject945.setOnClickListener(v -> {
            layout = "1.10.5.6.";
            classNo = "945";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject946.setOnClickListener(v -> {
            layout = "1.10.5.7.";
            classNo = "946";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject947.setOnClickListener(v -> {
            layout = "1.10.5.8.";
            classNo = "947";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject948.setOnClickListener(v -> {
            layout = "1.10.5.9.";
            classNo = "948";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject949.setOnClickListener(v -> {
            layout = "1.10.5.10.";
            classNo = "949";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject950.setOnClickListener(v -> {
            layout = "1.10.6.1.";
            classNo = "950";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject951.setOnClickListener(v -> {
            layout = "1.10.6.2.";
            classNo = "951";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject952.setOnClickListener(v -> {
            layout = "1.10.6.3.";
            classNo = "952";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject953.setOnClickListener(v -> {
            layout = "1.10.6.4.";
            classNo = "953";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject954.setOnClickListener(v -> {
            layout = "1.10.6.5.";
            classNo = "954";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject955.setOnClickListener(v -> {
            layout = "1.10.6.6.";
            classNo = "955";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject956.setOnClickListener(v -> {
            layout = "1.10.6.7.";
            classNo = "956";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject957.setOnClickListener(v -> {
            layout = "1.10.6.8.";
            classNo = "957";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject958.setOnClickListener(v -> {
            layout = "1.10.6.9.";
            classNo = "958";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject959.setOnClickListener(v -> {
            layout = "1.10.6.10.";
            classNo = "959";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject960.setOnClickListener(v -> {
            layout = "1.10.7.1.";
            classNo = "960";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject961.setOnClickListener(v -> {
            layout = "1.10.7.2.";
            classNo = "961";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject962.setOnClickListener(v -> {
            layout = "1.10.7.3.";
            classNo = "962";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject963.setOnClickListener(v -> {
            layout = "1.10.7.4.";
            classNo = "963";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject964.setOnClickListener(v -> {
            layout = "1.10.7.5.";
            classNo = "964";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject965.setOnClickListener(v -> {
            layout = "1.10.7.6.";
            classNo = "965";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject966.setOnClickListener(v -> {
            layout = "1.10.7.7.";
            classNo = "966";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject967.setOnClickListener(v -> {
            layout = "1.10.7.8.";
            classNo = "967";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject968.setOnClickListener(v -> {
            layout = "1.10.7.9.";
            classNo = "968";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject969.setOnClickListener(v -> {
            layout = "1.10.7.10.";
            classNo = "969";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject970.setOnClickListener(v -> {
            layout = "1.10.8.1.";
            classNo = "970";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject971.setOnClickListener(v -> {
            layout = "1.10.8.2.";
            classNo = "971";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject972.setOnClickListener(v -> {
            layout = "1.10.8.3.";
            classNo = "972";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject973.setOnClickListener(v -> {
            layout = "1.10.8.4.";
            classNo = "973";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject974.setOnClickListener(v -> {
            layout = "1.10.8.5.";
            classNo = "974";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject975.setOnClickListener(v -> {
            layout = "1.10.8.6.";
            classNo = "975";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject976.setOnClickListener(v -> {
            layout = "1.10.8.7.";
            classNo = "976";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject977.setOnClickListener(v -> {
            layout = "1.10.8.8.";
            classNo = "977";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject978.setOnClickListener(v -> {
            layout = "1.10.8.9.";
            classNo = "978";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject979.setOnClickListener(v -> {
            layout = "1.10.8.10.";
            classNo = "979";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject980.setOnClickListener(v -> {
            layout = "1.10.9.1.";
            classNo = "980";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject981.setOnClickListener(v -> {
            layout = "1.10.9.2.";
            classNo = "981";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject982.setOnClickListener(v -> {
            layout = "1.10.9.3.";
            classNo = "982";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject983.setOnClickListener(v -> {
            layout = "1.10.9.4.";
            classNo = "983";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject984.setOnClickListener(v -> {
            layout = "1.10.9.5.";
            classNo = "984";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject985.setOnClickListener(v -> {
            layout = "1.10.9.6.";
            classNo = "985";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject986.setOnClickListener(v -> {
            layout = "1.10.9.7.";
            classNo = "986";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject987.setOnClickListener(v -> {
            layout = "1.10.9.8.";
            classNo = "987";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject988.setOnClickListener(v -> {
            layout = "1.10.9.9.";
            classNo = "988";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject989.setOnClickListener(v -> {
            layout = "1.10.9.10.";
            classNo = "989";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject990.setOnClickListener(v -> {
            layout = "1.10.10.1.";
            classNo = "990";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject991.setOnClickListener(v -> {
            layout = "1.10.10.2.";
            classNo = "991";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject992.setOnClickListener(v -> {
            layout = "1.10.10.3.";
            classNo = "992";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject993.setOnClickListener(v -> {
            layout = "1.10.10.4.";
            classNo = "993";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject994.setOnClickListener(v -> {
            layout = "1.10.10.5.";
            classNo = "994";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject995.setOnClickListener(v -> {
            layout = "1.10.10.6.";
            classNo = "995";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject996.setOnClickListener(v -> {
            layout = "1.10.10.7.";
            classNo = "996";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject997.setOnClickListener(v -> {
            layout = "1.10.10.8.";
            classNo = "997";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject998.setOnClickListener(v -> {
            layout = "1.10.10.9.";
            classNo = "998";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject999.setOnClickListener(v -> {
            layout = "1.10.10.10.";
            classNo = "099";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level110Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level110Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
    }

    @Override
    public void onBackPressed() {
        if (child != null) {
            if (resultsSwipe.getVisibility() == View.VISIBLE) {
                resultsSwipe.setVisibility(View.GONE);
                int size = resultsList.size();
                resultsList.clear();
                resultsAdapter.notifyItemRangeRemoved(0, size);
                child.setVisibility(View.VISIBLE);
            } else if (child.getVisibility() == View.VISIBLE) {
                child.setVisibility(View.GONE);
                parent.setVisibility(View.VISIBLE);
            } else {
                super.onBackPressed();
            }
        } else {
            super.onBackPressed();
        }
    }

    private void startBrowse() {
        nextPage = "";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, ((MyApplication) this.getApplication()).getServerName() + "libraries/FuAPI.aspx?fn=BrowseCategories&ScopeID=1.&Id=" + layout + "&ClassNo=" + classNo, response -> {
            try {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(classNo, response.toString());
                editor.apply();
                resultsList = parseResults(response, true);
                if (!nextPage.isEmpty()) {
                    resultsList.add(null);
                }
                resultsAdapter.notifyDataSetChanged();
                resultsAdapter.setResultsStartItems(resultsList);
                resultsRecycler.setVisibility(View.VISIBLE);
                resultsSwipe.setRefreshing(false);
            } catch (NullPointerException e) {
                Log.e(TAG, "onResponse: " + e);
            }
        }, error -> {
            try {
                resultsSwipe.setRefreshing(false);
                if (error instanceof NoConnectionError) {
                    Snackbar.make(Level110Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.no_internet), Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(Level110Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_subject), Snackbar.LENGTH_LONG).show();
                }
                String strJson = sharedPreferences.getString(classNo, "");
                if (!strJson.isEmpty()) {
                    try {
                        JSONObject jsonData = new JSONObject(strJson);
                        resultsList = parseResults(jsonData, true);
                        resultsAdapter.setResultsStartItems(resultsList);
                    } catch (JSONException e) {
                        resultsSwipe.setVisibility(View.GONE);
                        child.setVisibility(View.VISIBLE);
                    }
                } else {
                    resultsSwipe.setVisibility(View.GONE);
                    child.setVisibility(View.VISIBLE);
                }
            } catch (NullPointerException e) {
                Log.e(TAG, "onErrorResponse: " + e);
            }
        });
        int socketTimeout = 60000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        request.setRetryPolicy(policy);
        requestQueue.add(request);
    }

    private ArrayList<ResultsStartItem> parseResults(JSONObject response, boolean firstLoad) {
        ArrayList<ResultsStartItem> listResults = new ArrayList<>();
        if (response != null && response.length() > 0) {
            try {
                if (response.has("Link4NextPage") && !response.isNull("Link4NextPage")) {
                    nextPage = response.getString("Link4NextPage");
                }
                if (response.has("results")) {
                    JSONArray arrayItems = response.getJSONArray("results");
                    for (int i = 0; i < arrayItems.length(); i++) {
                        JSONObject currentItem = arrayItems.getJSONObject(i);
                        long id = -1;
                        if (currentItem.has("id") && !currentItem.isNull("id")) {
                            id = currentItem.getLong("id");
                        }
                        String title = "No Data Available";
                        if (currentItem.has("title") && !currentItem.isNull("title")) {
                            title = currentItem.getString("title");
                        }
                        String image = "";
                        if (currentItem.has("image") && !currentItem.isNull("image")) {
                            image = currentItem.getString("image");
                        }
                        String type = "";
                        if (currentItem.has("type") && !currentItem.isNull("type")) {
                            type = currentItem.getString("type");
                        }
                        StringBuilder classification = new StringBuilder();
                        if (currentItem.has("classification") && !currentItem.isNull("classification")) {
                            JSONArray arrayClassification = currentItem.getJSONArray("classification");
                            for (int j = 0; j < arrayClassification.length(); j++) {
                                classification.append("» ").append(arrayClassification.getString(j));
                                if (j < (arrayClassification.length() - 1)) {
                                    classification.append("\t\t");
                                }
                            }
                        }
                        String publisher = "";
                        if (currentItem.has("publisher") && !currentItem.isNull("publisher")) {
                            publisher = currentItem.getString("publisher");
                        }
                        String moreTitle = "";
                        if (currentItem.has("moreTitle") && !currentItem.isNull("moreTitle")) {
                            moreTitle = currentItem.getJSONObject("moreTitle").toString();
                        }
                        String details = "";
                        if (currentItem.has("details") && !currentItem.isNull("details")) {
                            details = currentItem.getJSONObject("details").toString();
                        }
                        String holdings = "";
                        if (currentItem.has("holdings") && !currentItem.isNull("holdings")) {
                            holdings = currentItem.getJSONArray("holdings").toString();
                        }
                        String services = "";
                        if (currentItem.has("services") && !currentItem.isNull("services")) {
                            services = currentItem.getJSONObject("services").toString();
                        }
                        ResultsStartItem item = new ResultsStartItem();
                        item.setId(id);
                        item.setTitle(title);
                        item.setImage(image);
                        item.setType(type);
                        item.setClassification(classification.toString());
                        item.setPublisher(publisher);
                        item.setMoreTitle(moreTitle);
                        item.setDetails(details);
                        item.setHoldings(holdings);
                        item.setServices(services);
                        if (id != -1 && !title.equals("No Data Available")) {
                            listResults.add(item);
                        }
                    }
                } else {
                    try {
                        if (firstLoad) {
                            Snackbar.make(Level110Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_subject), Snackbar.LENGTH_LONG).show();
                            resultsSwipe.setVisibility(View.GONE);
                            child.setVisibility(View.VISIBLE);
                        } else {
                            resultsSwipe.setRefreshing(false);
                        }
                    } catch (NullPointerException e) {
                        Log.e(TAG, "parseResults: " + e);
                    }
                }
            } catch (JSONException e) {
                try {
                    Snackbar.make(Level110Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_subject), Snackbar.LENGTH_LONG).show();
                    resultsSwipe.setVisibility(View.GONE);
                    child.setVisibility(View.VISIBLE);
                } catch (NullPointerException ex) {
                    Log.e(TAG, "parseResults: " + e);
                }
            }
        }
        return listResults;
    }

    public void loadMore() {
        if (!nextPage.isEmpty()) {
            resultsSwipe.setRefreshing(true);
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, nextPage, response -> {
                try {
                    ArrayList<ResultsStartItem> resultsListMore = parseResults(response, false);
                    resultsSwipe.setRefreshing(false);
                    resultsList.remove(resultsList.size() - 1);
                    resultsAdapter.notifyItemRemoved(resultsList.size());
                    for (int i = 0; i < resultsListMore.size(); i++) {
                        ResultsStartItem result = resultsListMore.get(i);
                        resultsList.add(result);
                        resultsAdapter.notifyItemInserted(resultsList.size());
                    }
                    if (!nextPage.isEmpty()) {
                        resultsList.add(null);
                        resultsAdapter.notifyItemInserted(resultsList.size());
                    }
                } catch (NullPointerException e) {
                    Log.e(TAG, "onResponse: " + e);
                }
            }, error -> {
                try {
                    resultsSwipe.setRefreshing(false);
                    resultsList.remove(resultsList.size() - 1);
                    resultsAdapter.notifyItemRemoved(resultsList.size());
                    resultsList.add(null);
                    resultsAdapter.notifyItemInserted(resultsList.size());
                } catch (NullPointerException e) {
                    Log.e(TAG, "onErrorResponse: " + e);
                }
            });
            int socketTimeout = 60000;
            RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            request.setRetryPolicy(policy);
            requestQueue.add(request);
        }
    }

}
