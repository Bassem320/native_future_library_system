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

public class Level14Activity extends AppCompatActivity {
    public static final String PREF_FILE_NAME = "LibrarySystemPref";
    public static final String TAG = "LEVEL14";
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
        setContentView(R.layout.activity_level14);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        parent = findViewById(R.id.level03);

        level030 = findViewById(R.id.level030);
        level031 = findViewById(R.id.level031);
        level032 = findViewById(R.id.level032);
        level033 = findViewById(R.id.level033);
        level034 = findViewById(R.id.level034);
        level035 = findViewById(R.id.level035);
        level036 = findViewById(R.id.level036);
        level037 = findViewById(R.id.level037);
        level038 = findViewById(R.id.level038);
        level039 = findViewById(R.id.level039);

        subject30 = findViewById(R.id.Subject30);
        subject31 = findViewById(R.id.Subject31);
        subject32 = findViewById(R.id.Subject32);
        subject33 = findViewById(R.id.Subject33);
        subject34 = findViewById(R.id.Subject34);
        subject35 = findViewById(R.id.Subject35);
        subject36 = findViewById(R.id.Subject36);
        subject37 = findViewById(R.id.Subject37);
        subject38 = findViewById(R.id.Subject38);
        subject39 = findViewById(R.id.Subject39);

        subject300 = findViewById(R.id.Subject300);
        subject301 = findViewById(R.id.Subject301);
        subject302 = findViewById(R.id.Subject302);
        subject303 = findViewById(R.id.Subject303);
        subject304 = findViewById(R.id.Subject304);
        subject305 = findViewById(R.id.Subject305);
        subject306 = findViewById(R.id.Subject306);
        subject307 = findViewById(R.id.Subject307);
        subject308 = findViewById(R.id.Subject308);
        subject309 = findViewById(R.id.Subject309);

        subject310 = findViewById(R.id.Subject310);
        subject311 = findViewById(R.id.Subject311);
        subject312 = findViewById(R.id.Subject312);
        subject313 = findViewById(R.id.Subject313);
        subject314 = findViewById(R.id.Subject314);
        subject315 = findViewById(R.id.Subject315);
        subject316 = findViewById(R.id.Subject316);
        subject317 = findViewById(R.id.Subject317);
        subject318 = findViewById(R.id.Subject318);
        subject319 = findViewById(R.id.Subject319);

        subject320 = findViewById(R.id.Subject320);
        subject321 = findViewById(R.id.Subject321);
        subject322 = findViewById(R.id.Subject322);
        subject323 = findViewById(R.id.Subject323);
        subject324 = findViewById(R.id.Subject324);
        subject325 = findViewById(R.id.Subject325);
        subject326 = findViewById(R.id.Subject326);
        subject327 = findViewById(R.id.Subject327);
        subject328 = findViewById(R.id.Subject328);
        subject329 = findViewById(R.id.Subject329);

        subject330 = findViewById(R.id.Subject330);
        subject331 = findViewById(R.id.Subject331);
        subject332 = findViewById(R.id.Subject332);
        subject333 = findViewById(R.id.Subject333);
        subject334 = findViewById(R.id.Subject334);
        subject335 = findViewById(R.id.Subject335);
        subject336 = findViewById(R.id.Subject336);
        subject337 = findViewById(R.id.Subject337);
        subject338 = findViewById(R.id.Subject338);
        subject339 = findViewById(R.id.Subject339);

        subject340 = findViewById(R.id.Subject340);
        subject341 = findViewById(R.id.Subject341);
        subject342 = findViewById(R.id.Subject342);
        subject343 = findViewById(R.id.Subject343);
        subject344 = findViewById(R.id.Subject344);
        subject345 = findViewById(R.id.Subject345);
        subject346 = findViewById(R.id.Subject346);
        subject347 = findViewById(R.id.Subject347);
        subject348 = findViewById(R.id.Subject348);
        subject349 = findViewById(R.id.Subject349);

        subject350 = findViewById(R.id.Subject350);
        subject351 = findViewById(R.id.Subject351);
        subject352 = findViewById(R.id.Subject352);
        subject353 = findViewById(R.id.Subject353);
        subject354 = findViewById(R.id.Subject354);
        subject355 = findViewById(R.id.Subject355);
        subject356 = findViewById(R.id.Subject356);
        subject357 = findViewById(R.id.Subject357);
        subject358 = findViewById(R.id.Subject358);
        subject359 = findViewById(R.id.Subject359);

        subject360 = findViewById(R.id.Subject360);
        subject361 = findViewById(R.id.Subject361);
        subject362 = findViewById(R.id.Subject362);
        subject363 = findViewById(R.id.Subject363);
        subject364 = findViewById(R.id.Subject364);
        subject365 = findViewById(R.id.Subject365);
        subject366 = findViewById(R.id.Subject366);
        subject367 = findViewById(R.id.Subject367);
        subject368 = findViewById(R.id.Subject368);
        subject369 = findViewById(R.id.Subject369);

        subject370 = findViewById(R.id.Subject370);
        subject371 = findViewById(R.id.Subject371);
        subject372 = findViewById(R.id.Subject372);
        subject373 = findViewById(R.id.Subject373);
        subject374 = findViewById(R.id.Subject374);
        subject375 = findViewById(R.id.Subject375);
        subject376 = findViewById(R.id.Subject376);
        subject377 = findViewById(R.id.Subject377);
        subject378 = findViewById(R.id.Subject378);
        subject379 = findViewById(R.id.Subject379);

        subject380 = findViewById(R.id.Subject380);
        subject381 = findViewById(R.id.Subject381);
        subject382 = findViewById(R.id.Subject382);
        subject383 = findViewById(R.id.Subject383);
        subject384 = findViewById(R.id.Subject384);
        subject385 = findViewById(R.id.Subject385);
        subject386 = findViewById(R.id.Subject386);
        subject387 = findViewById(R.id.Subject387);
        subject388 = findViewById(R.id.Subject388);
        subject389 = findViewById(R.id.Subject389);

        subject390 = findViewById(R.id.Subject390);
        subject391 = findViewById(R.id.Subject391);
        subject392 = findViewById(R.id.Subject392);
        subject393 = findViewById(R.id.Subject393);
        subject394 = findViewById(R.id.Subject394);
        subject395 = findViewById(R.id.Subject395);
        subject396 = findViewById(R.id.Subject396);
        subject397 = findViewById(R.id.Subject397);
        subject398 = findViewById(R.id.Subject398);
        subject399 = findViewById(R.id.Subject399);

        resultsSwipe = findViewById(R.id.ResultsSwipeRefresh);
        resultsRecycler = findViewById(R.id.ResultsRecycler);

        sharedPreferences = Level14Activity.this.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);

        VolleySingleton volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();

        subject30.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level030;
            child.setVisibility(View.VISIBLE);
        });
        subject31.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level031;
            child.setVisibility(View.VISIBLE);
        });
        subject32.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level032;
            child.setVisibility(View.VISIBLE);
        });
        subject33.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level033;
            child.setVisibility(View.VISIBLE);
        });
        subject34.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level034;
            child.setVisibility(View.VISIBLE);
        });
        subject35.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level035;
            child.setVisibility(View.VISIBLE);
        });
        subject36.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level036;
            child.setVisibility(View.VISIBLE);
        });
        subject37.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level037;
            child.setVisibility(View.VISIBLE);
        });
        subject38.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level038;
            child.setVisibility(View.VISIBLE);
        });
        subject39.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level039;
            child.setVisibility(View.VISIBLE);
        });

        resultsSwipe.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent);
        resultsSwipe.setOnRefreshListener(() -> resultsSwipe.setRefreshing(false));

        subject300.setOnClickListener(v -> {
            layout = "1.4.1.1.";
            classNo = "300";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject301.setOnClickListener(v -> {
            layout = "1.4.1.2.";
            classNo = "301";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject302.setOnClickListener(v -> {
            layout = "1.4.1.3.";
            classNo = "302";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject303.setOnClickListener(v -> {
            layout = "1.4.1.4.";
            classNo = "303";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject304.setOnClickListener(v -> {
            layout = "1.4.1.5.";
            classNo = "304";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject305.setOnClickListener(v -> {
            layout = "1.4.1.6.";
            classNo = "305";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject306.setOnClickListener(v -> {
            layout = "1.4.1.7.";
            classNo = "306";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject307.setOnClickListener(v -> {
            layout = "1.4.1.8.";
            classNo = "307";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject308.setOnClickListener(v -> {
            layout = "1.4.1.9.";
            classNo = "308";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject309.setOnClickListener(v -> {
            layout = "1.4.1.10.";
            classNo = "309";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject310.setOnClickListener(v -> {
            layout = "1.4.2.1.";
            classNo = "310";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject311.setOnClickListener(v -> {
            layout = "1.4.2.2.";
            classNo = "311";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject312.setOnClickListener(v -> {
            layout = "1.4.2.3.";
            classNo = "312";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject313.setOnClickListener(v -> {
            layout = "1.4.2.4.";
            classNo = "313";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject314.setOnClickListener(v -> {
            layout = "1.4.2.5.";
            classNo = "314";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject315.setOnClickListener(v -> {
            layout = "1.4.2.6.";
            classNo = "315";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject316.setOnClickListener(v -> {
            layout = "1.4.2.7.";
            classNo = "316";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject317.setOnClickListener(v -> {
            layout = "1.4.2.8.";
            classNo = "317";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject318.setOnClickListener(v -> {
            layout = "1.4.2.9.";
            classNo = "318";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject319.setOnClickListener(v -> {
            layout = "1.4.2.10.";
            classNo = "319";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject320.setOnClickListener(v -> {
            layout = "1.4.3.1.";
            classNo = "320";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject321.setOnClickListener(v -> {
            layout = "1.4.3.2.";
            classNo = "321";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject322.setOnClickListener(v -> {
            layout = "1.4.3.3.";
            classNo = "322";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject323.setOnClickListener(v -> {
            layout = "1.4.3.4.";
            classNo = "323";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject324.setOnClickListener(v -> {
            layout = "1.4.3.5.";
            classNo = "324";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject325.setOnClickListener(v -> {
            layout = "1.4.3.6.";
            classNo = "325";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject326.setOnClickListener(v -> {
            layout = "1.4.3.7.";
            classNo = "326";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject327.setOnClickListener(v -> {
            layout = "1.4.3.8.";
            classNo = "327";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject328.setOnClickListener(v -> {
            layout = "1.4.3.9.";
            classNo = "328";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject329.setOnClickListener(v -> {
            layout = "1.4.3.10.";
            classNo = "329";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject330.setOnClickListener(v -> {
            layout = "1.4.4.1.";
            classNo = "330";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject331.setOnClickListener(v -> {
            layout = "1.4.4.2.";
            classNo = "331";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject332.setOnClickListener(v -> {
            layout = "1.4.4.3.";
            classNo = "332";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject333.setOnClickListener(v -> {
            layout = "1.4.4.4.";
            classNo = "333";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject334.setOnClickListener(v -> {
            layout = "1.4.4.5.";
            classNo = "334";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject335.setOnClickListener(v -> {
            layout = "1.4.4.6.";
            classNo = "335";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject336.setOnClickListener(v -> {
            layout = "1.4.4.7.";
            classNo = "336";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject337.setOnClickListener(v -> {
            layout = "1.4.4.8.";
            classNo = "337";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject338.setOnClickListener(v -> {
            layout = "1.4.4.9.";
            classNo = "338";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject339.setOnClickListener(v -> {
            layout = "1.4.4.10.";
            classNo = "339";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject340.setOnClickListener(v -> {
            layout = "1.4.5.1.";
            classNo = "340";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject341.setOnClickListener(v -> {
            layout = "1.4.5.2.";
            classNo = "341";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject342.setOnClickListener(v -> {
            layout = "1.4.5.3.";
            classNo = "342";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject343.setOnClickListener(v -> {
            layout = "1.4.5.4.";
            classNo = "343";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject344.setOnClickListener(v -> {
            layout = "1.4.5.5.";
            classNo = "344";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject345.setOnClickListener(v -> {
            layout = "1.4.5.6.";
            classNo = "345";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject346.setOnClickListener(v -> {
            layout = "1.4.5.7.";
            classNo = "346";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject347.setOnClickListener(v -> {
            layout = "1.4.5.8.";
            classNo = "347";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject348.setOnClickListener(v -> {
            layout = "1.4.5.9.";
            classNo = "348";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject349.setOnClickListener(v -> {
            layout = "1.4.5.10.";
            classNo = "349";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject350.setOnClickListener(v -> {
            layout = "1.4.6.1.";
            classNo = "350";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject351.setOnClickListener(v -> {
            layout = "1.4.6.2.";
            classNo = "351";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject352.setOnClickListener(v -> {
            layout = "1.4.6.3.";
            classNo = "352";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject353.setOnClickListener(v -> {
            layout = "1.4.6.4.";
            classNo = "353";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject354.setOnClickListener(v -> {
            layout = "1.4.6.5.";
            classNo = "354";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject355.setOnClickListener(v -> {
            layout = "1.4.6.6.";
            classNo = "355";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject356.setOnClickListener(v -> {
            layout = "1.4.6.7.";
            classNo = "356";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject357.setOnClickListener(v -> {
            layout = "1.4.6.8.";
            classNo = "357";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject358.setOnClickListener(v -> {
            layout = "1.4.6.9.";
            classNo = "358";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject359.setOnClickListener(v -> {
            layout = "1.4.6.10.";
            classNo = "359";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject360.setOnClickListener(v -> {
            layout = "1.4.7.1.";
            classNo = "360";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject361.setOnClickListener(v -> {
            layout = "1.4.7.2.";
            classNo = "361";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject362.setOnClickListener(v -> {
            layout = "1.4.7.3.";
            classNo = "362";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject363.setOnClickListener(v -> {
            layout = "1.4.7.4.";
            classNo = "363";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject364.setOnClickListener(v -> {
            layout = "1.4.7.5.";
            classNo = "364";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject365.setOnClickListener(v -> {
            layout = "1.4.7.6.";
            classNo = "365";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject366.setOnClickListener(v -> {
            layout = "1.4.7.7.";
            classNo = "366";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject367.setOnClickListener(v -> {
            layout = "1.4.7.8.";
            classNo = "367";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject368.setOnClickListener(v -> {
            layout = "1.4.7.9.";
            classNo = "368";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject369.setOnClickListener(v -> {
            layout = "1.4.7.10.";
            classNo = "369";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject370.setOnClickListener(v -> {
            layout = "1.4.8.1.";
            classNo = "370";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject371.setOnClickListener(v -> {
            layout = "1.4.8.2.";
            classNo = "371";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject372.setOnClickListener(v -> {
            layout = "1.4.8.3.";
            classNo = "372";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject373.setOnClickListener(v -> {
            layout = "1.4.8.4.";
            classNo = "373";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject374.setOnClickListener(v -> {
            layout = "1.4.8.5.";
            classNo = "374";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject375.setOnClickListener(v -> {
            layout = "1.4.8.6.";
            classNo = "375";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject376.setOnClickListener(v -> {
            layout = "1.4.8.7.";
            classNo = "376";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject377.setOnClickListener(v -> {
            layout = "1.4.8.8.";
            classNo = "377";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject378.setOnClickListener(v -> {
            layout = "1.4.8.9.";
            classNo = "378";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject379.setOnClickListener(v -> {
            layout = "1.4.8.10.";
            classNo = "379";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject380.setOnClickListener(v -> {
            layout = "1.4.9.1.";
            classNo = "380";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject381.setOnClickListener(v -> {
            layout = "1.4.9.2.";
            classNo = "381";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject382.setOnClickListener(v -> {
            layout = "1.4.9.3.";
            classNo = "382";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject383.setOnClickListener(v -> {
            layout = "1.4.9.4.";
            classNo = "383";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject384.setOnClickListener(v -> {
            layout = "1.4.9.5.";
            classNo = "384";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject385.setOnClickListener(v -> {
            layout = "1.4.9.6.";
            classNo = "385";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject386.setOnClickListener(v -> {
            layout = "1.4.9.7.";
            classNo = "386";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject387.setOnClickListener(v -> {
            layout = "1.4.9.8.";
            classNo = "387";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject388.setOnClickListener(v -> {
            layout = "1.4.9.9.";
            classNo = "388";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject389.setOnClickListener(v -> {
            layout = "1.4.9.10.";
            classNo = "389";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject390.setOnClickListener(v -> {
            layout = "1.4.10.1.";
            classNo = "390";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject391.setOnClickListener(v -> {
            layout = "1.4.10.2.";
            classNo = "391";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject392.setOnClickListener(v -> {
            layout = "1.4.10.3.";
            classNo = "392";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject393.setOnClickListener(v -> {
            layout = "1.4.10.4.";
            classNo = "393";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject394.setOnClickListener(v -> {
            layout = "1.4.10.5.";
            classNo = "394";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject395.setOnClickListener(v -> {
            layout = "1.4.10.6.";
            classNo = "395";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject396.setOnClickListener(v -> {
            layout = "1.4.10.7.";
            classNo = "396";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject397.setOnClickListener(v -> {
            layout = "1.4.10.8.";
            classNo = "397";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject398.setOnClickListener(v -> {
            layout = "1.4.10.9.";
            classNo = "398";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject399.setOnClickListener(v -> {
            layout = "1.4.10.10.";
            classNo = "399";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level14Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level14Activity.this, null);
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
            Log.e(TAG, "startBrowse: " + error);
            try {
                resultsSwipe.setRefreshing(false);
                if (error instanceof NoConnectionError) {
                    Snackbar.make(Level14Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.no_internet), Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(Level14Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_subject), Snackbar.LENGTH_LONG).show();
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
                Log.e(TAG, "startBrowse: " + e);
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
                            Snackbar.make(Level14Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_subject), Snackbar.LENGTH_LONG).show();
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
                    Snackbar.make(Level14Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_subject), Snackbar.LENGTH_LONG).show();
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
                    Log.e(TAG, "loadMore: " + e);
                }
            });
            int socketTimeout = 60000;
            RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            request.setRetryPolicy(policy);
            requestQueue.add(request);
        }
    }

}
