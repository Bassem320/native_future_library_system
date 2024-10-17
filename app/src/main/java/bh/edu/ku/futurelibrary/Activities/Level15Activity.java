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

public class Level15Activity extends AppCompatActivity {
    public static final String PREF_FILE_NAME = "LibrarySystemPref";
    public static final String TAG = "LEVEL15";
    ScrollView parent, child = null,
            level040, level041, level042, level043, level044, level045, level046, level047, level048, level049;
    LinearLayout subject40, subject41, subject42, subject43, subject44, subject45, subject46, subject47, subject48, subject49,
            subject400, subject401, subject402, subject403, subject404, subject405, subject406, subject407, subject408, subject409,
            subject410, subject411, subject412, subject413, subject414, subject415, subject416, subject417, subject418, subject419,
            subject420, subject421, subject422, subject423, subject424, subject425, subject426, subject427, subject428, subject429,
            subject430, subject431, subject432, subject433, subject434, subject435, subject436, subject437, subject438, subject439,
            subject440, subject441, subject442, subject443, subject444, subject445, subject446, subject447, subject448, subject449,
            subject450, subject451, subject452, subject453, subject454, subject455, subject456, subject457, subject458, subject459,
            subject460, subject461, subject462, subject463, subject464, subject465, subject466, subject467, subject468, subject469,
            subject470, subject471, subject472, subject473, subject474, subject475, subject476, subject477, subject478, subject479,
            subject480, subject481, subject482, subject483, subject484, subject485, subject486, subject487, subject488, subject489,
            subject490, subject491, subject492, subject493, subject494, subject495, subject496, subject497, subject498, subject499;
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
        setContentView(R.layout.activity_level15);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        parent = findViewById(R.id.level04);

        level040 = findViewById(R.id.level040);
        level041 = findViewById(R.id.level041);
        level042 = findViewById(R.id.level042);
        level043 = findViewById(R.id.level043);
        level044 = findViewById(R.id.level044);
        level045 = findViewById(R.id.level045);
        level046 = findViewById(R.id.level046);
        level047 = findViewById(R.id.level047);
        level048 = findViewById(R.id.level048);
        level049 = findViewById(R.id.level049);

        subject40 = findViewById(R.id.Subject40);
        subject41 = findViewById(R.id.Subject41);
        subject42 = findViewById(R.id.Subject42);
        subject43 = findViewById(R.id.Subject43);
        subject44 = findViewById(R.id.Subject44);
        subject45 = findViewById(R.id.Subject45);
        subject46 = findViewById(R.id.Subject46);
        subject47 = findViewById(R.id.Subject47);
        subject48 = findViewById(R.id.Subject48);
        subject49 = findViewById(R.id.Subject49);

        subject400 = findViewById(R.id.Subject400);
        subject401 = findViewById(R.id.Subject401);
        subject402 = findViewById(R.id.Subject402);
        subject403 = findViewById(R.id.Subject403);
        subject404 = findViewById(R.id.Subject404);
        subject405 = findViewById(R.id.Subject405);
        subject406 = findViewById(R.id.Subject406);
        subject407 = findViewById(R.id.Subject407);
        subject408 = findViewById(R.id.Subject408);
        subject409 = findViewById(R.id.Subject409);

        subject410 = findViewById(R.id.Subject410);
        subject411 = findViewById(R.id.Subject411);
        subject412 = findViewById(R.id.Subject412);
        subject413 = findViewById(R.id.Subject413);
        subject414 = findViewById(R.id.Subject414);
        subject415 = findViewById(R.id.Subject415);
        subject416 = findViewById(R.id.Subject416);
        subject417 = findViewById(R.id.Subject417);
        subject418 = findViewById(R.id.Subject418);
        subject419 = findViewById(R.id.Subject419);

        subject420 = findViewById(R.id.Subject420);
        subject421 = findViewById(R.id.Subject421);
        subject422 = findViewById(R.id.Subject422);
        subject423 = findViewById(R.id.Subject423);
        subject424 = findViewById(R.id.Subject424);
        subject425 = findViewById(R.id.Subject425);
        subject426 = findViewById(R.id.Subject426);
        subject427 = findViewById(R.id.Subject427);
        subject428 = findViewById(R.id.Subject428);
        subject429 = findViewById(R.id.Subject429);

        subject430 = findViewById(R.id.Subject430);
        subject431 = findViewById(R.id.Subject431);
        subject432 = findViewById(R.id.Subject432);
        subject433 = findViewById(R.id.Subject433);
        subject434 = findViewById(R.id.Subject434);
        subject435 = findViewById(R.id.Subject435);
        subject436 = findViewById(R.id.Subject436);
        subject437 = findViewById(R.id.Subject437);
        subject438 = findViewById(R.id.Subject438);
        subject439 = findViewById(R.id.Subject439);

        subject440 = findViewById(R.id.Subject440);
        subject441 = findViewById(R.id.Subject441);
        subject442 = findViewById(R.id.Subject442);
        subject443 = findViewById(R.id.Subject443);
        subject444 = findViewById(R.id.Subject444);
        subject445 = findViewById(R.id.Subject445);
        subject446 = findViewById(R.id.Subject446);
        subject447 = findViewById(R.id.Subject447);
        subject448 = findViewById(R.id.Subject448);
        subject449 = findViewById(R.id.Subject449);

        subject450 = findViewById(R.id.Subject450);
        subject451 = findViewById(R.id.Subject451);
        subject452 = findViewById(R.id.Subject452);
        subject453 = findViewById(R.id.Subject453);
        subject454 = findViewById(R.id.Subject454);
        subject455 = findViewById(R.id.Subject455);
        subject456 = findViewById(R.id.Subject456);
        subject457 = findViewById(R.id.Subject457);
        subject458 = findViewById(R.id.Subject458);
        subject459 = findViewById(R.id.Subject459);

        subject460 = findViewById(R.id.Subject460);
        subject461 = findViewById(R.id.Subject461);
        subject462 = findViewById(R.id.Subject462);
        subject463 = findViewById(R.id.Subject463);
        subject464 = findViewById(R.id.Subject464);
        subject465 = findViewById(R.id.Subject465);
        subject466 = findViewById(R.id.Subject466);
        subject467 = findViewById(R.id.Subject467);
        subject468 = findViewById(R.id.Subject468);
        subject469 = findViewById(R.id.Subject469);

        subject470 = findViewById(R.id.Subject470);
        subject471 = findViewById(R.id.Subject471);
        subject472 = findViewById(R.id.Subject472);
        subject473 = findViewById(R.id.Subject473);
        subject474 = findViewById(R.id.Subject474);
        subject475 = findViewById(R.id.Subject475);
        subject476 = findViewById(R.id.Subject476);
        subject477 = findViewById(R.id.Subject477);
        subject478 = findViewById(R.id.Subject478);
        subject479 = findViewById(R.id.Subject479);

        subject480 = findViewById(R.id.Subject480);
        subject481 = findViewById(R.id.Subject481);
        subject482 = findViewById(R.id.Subject482);
        subject483 = findViewById(R.id.Subject483);
        subject484 = findViewById(R.id.Subject484);
        subject485 = findViewById(R.id.Subject485);
        subject486 = findViewById(R.id.Subject486);
        subject487 = findViewById(R.id.Subject487);
        subject488 = findViewById(R.id.Subject488);
        subject489 = findViewById(R.id.Subject489);

        subject490 = findViewById(R.id.Subject490);
        subject491 = findViewById(R.id.Subject491);
        subject492 = findViewById(R.id.Subject492);
        subject493 = findViewById(R.id.Subject493);
        subject494 = findViewById(R.id.Subject494);
        subject495 = findViewById(R.id.Subject495);
        subject496 = findViewById(R.id.Subject496);
        subject497 = findViewById(R.id.Subject497);
        subject498 = findViewById(R.id.Subject498);
        subject499 = findViewById(R.id.Subject499);

        resultsSwipe = findViewById(R.id.ResultsSwipeRefresh);
        resultsRecycler = findViewById(R.id.ResultsRecycler);

        sharedPreferences = Level15Activity.this.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);

        VolleySingleton volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();

        subject40.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level040;
            child.setVisibility(View.VISIBLE);
        });
        subject41.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level041;
            child.setVisibility(View.VISIBLE);
        });
        subject42.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level042;
            child.setVisibility(View.VISIBLE);
        });
        subject43.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level043;
            child.setVisibility(View.VISIBLE);
        });
        subject44.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level044;
            child.setVisibility(View.VISIBLE);
        });
        subject45.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level045;
            child.setVisibility(View.VISIBLE);
        });
        subject46.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level046;
            child.setVisibility(View.VISIBLE);
        });
        subject47.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level047;
            child.setVisibility(View.VISIBLE);
        });
        subject48.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level048;
            child.setVisibility(View.VISIBLE);
        });
        subject49.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level049;
            child.setVisibility(View.VISIBLE);
        });

        resultsSwipe.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent);
        resultsSwipe.setOnRefreshListener(() -> resultsSwipe.setRefreshing(false));

        subject400.setOnClickListener(v -> {
            layout = "1.5.1.1.";
            classNo = "400";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject401.setOnClickListener(v -> {
            layout = "1.5.1.2.";
            classNo = "401";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject402.setOnClickListener(v -> {
            layout = "1.5.1.3.";
            classNo = "402";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject403.setOnClickListener(v -> {
            layout = "1.5.1.4.";
            classNo = "403";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject404.setOnClickListener(v -> {
            layout = "1.5.1.5.";
            classNo = "404";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject405.setOnClickListener(v -> {
            layout = "1.5.1.6.";
            classNo = "405";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject406.setOnClickListener(v -> {
            layout = "1.5.1.7.";
            classNo = "406";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject407.setOnClickListener(v -> {
            layout = "1.5.1.8.";
            classNo = "407";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject408.setOnClickListener(v -> {
            layout = "1.5.1.9.";
            classNo = "408";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject409.setOnClickListener(v -> {
            layout = "1.5.1.10.";
            classNo = "409";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject410.setOnClickListener(v -> {
            layout = "1.5.2.1.";
            classNo = "410";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject411.setOnClickListener(v -> {
            layout = "1.5.2.2.";
            classNo = "411";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject412.setOnClickListener(v -> {
            layout = "1.5.2.3.";
            classNo = "412";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject413.setOnClickListener(v -> {
            layout = "1.5.2.4.";
            classNo = "413";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject414.setOnClickListener(v -> {
            layout = "1.5.2.5.";
            classNo = "414";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject415.setOnClickListener(v -> {
            layout = "1.5.2.6.";
            classNo = "415";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject416.setOnClickListener(v -> {
            layout = "1.5.2.7.";
            classNo = "416";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject417.setOnClickListener(v -> {
            layout = "1.5.2.8.";
            classNo = "417";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject418.setOnClickListener(v -> {
            layout = "1.5.2.9.";
            classNo = "418";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject419.setOnClickListener(v -> {
            layout = "1.5.2.10.";
            classNo = "419";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject420.setOnClickListener(v -> {
            layout = "1.5.3.1.";
            classNo = "420";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject421.setOnClickListener(v -> {
            layout = "1.5.3.2.";
            classNo = "421";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject422.setOnClickListener(v -> {
            layout = "1.5.3.3.";
            classNo = "422";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject423.setOnClickListener(v -> {
            layout = "1.5.3.4.";
            classNo = "423";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject424.setOnClickListener(v -> {
            layout = "1.5.3.5.";
            classNo = "424";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject425.setOnClickListener(v -> {
            layout = "1.5.3.6.";
            classNo = "425";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject426.setOnClickListener(v -> {
            layout = "1.5.3.7.";
            classNo = "426";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject427.setOnClickListener(v -> {
            layout = "1.5.3.8.";
            classNo = "427";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject428.setOnClickListener(v -> {
            layout = "1.5.3.9.";
            classNo = "428";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject429.setOnClickListener(v -> {
            layout = "1.5.3.10.";
            classNo = "429";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject430.setOnClickListener(v -> {
            layout = "1.5.4.1.";
            classNo = "430";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject431.setOnClickListener(v -> {
            layout = "1.5.4.2.";
            classNo = "431";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject432.setOnClickListener(v -> {
            layout = "1.5.4.3.";
            classNo = "432";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject433.setOnClickListener(v -> {
            layout = "1.5.4.4.";
            classNo = "433";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject434.setOnClickListener(v -> {
            layout = "1.5.4.5.";
            classNo = "434";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject435.setOnClickListener(v -> {
            layout = "1.5.4.6.";
            classNo = "435";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject436.setOnClickListener(v -> {
            layout = "1.5.4.7.";
            classNo = "436";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject437.setOnClickListener(v -> {
            layout = "1.5.4.8.";
            classNo = "437";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject438.setOnClickListener(v -> {
            layout = "1.5.4.9.";
            classNo = "438";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject439.setOnClickListener(v -> {
            layout = "1.5.4.10.";
            classNo = "439";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject440.setOnClickListener(v -> {
            layout = "1.5.5.1.";
            classNo = "440";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject441.setOnClickListener(v -> {
            layout = "1.5.5.2.";
            classNo = "441";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject442.setOnClickListener(v -> {
            layout = "1.5.5.3.";
            classNo = "442";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject443.setOnClickListener(v -> {
            layout = "1.5.5.4.";
            classNo = "443";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject444.setOnClickListener(v -> {
            layout = "1.5.5.5.";
            classNo = "444";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject445.setOnClickListener(v -> {
            layout = "1.5.5.6.";
            classNo = "445";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject446.setOnClickListener(v -> {
            layout = "1.5.5.7.";
            classNo = "446";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject447.setOnClickListener(v -> {
            layout = "1.5.5.8.";
            classNo = "447";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject448.setOnClickListener(v -> {
            layout = "1.5.5.9.";
            classNo = "448";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject449.setOnClickListener(v -> {
            layout = "1.5.5.10.";
            classNo = "449";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject450.setOnClickListener(v -> {
            layout = "1.5.6.1.";
            classNo = "450";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject451.setOnClickListener(v -> {
            layout = "1.5.6.2.";
            classNo = "451";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject452.setOnClickListener(v -> {
            layout = "1.5.6.3.";
            classNo = "452";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject453.setOnClickListener(v -> {
            layout = "1.5.6.4.";
            classNo = "453";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject454.setOnClickListener(v -> {
            layout = "1.5.6.5.";
            classNo = "454";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject455.setOnClickListener(v -> {
            layout = "1.5.6.6.";
            classNo = "455";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject456.setOnClickListener(v -> {
            layout = "1.5.6.7.";
            classNo = "456";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject457.setOnClickListener(v -> {
            layout = "1.5.6.8.";
            classNo = "457";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject458.setOnClickListener(v -> {
            layout = "1.5.6.9.";
            classNo = "458";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject459.setOnClickListener(v -> {
            layout = "1.5.6.10.";
            classNo = "459";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject460.setOnClickListener(v -> {
            layout = "1.5.7.1.";
            classNo = "460";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject461.setOnClickListener(v -> {
            layout = "1.5.7.2.";
            classNo = "461";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject462.setOnClickListener(v -> {
            layout = "1.5.7.3.";
            classNo = "462";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject463.setOnClickListener(v -> {
            layout = "1.5.7.4.";
            classNo = "463";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject464.setOnClickListener(v -> {
            layout = "1.5.7.5.";
            classNo = "464";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject465.setOnClickListener(v -> {
            layout = "1.5.7.6.";
            classNo = "465";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject466.setOnClickListener(v -> {
            layout = "1.5.7.7.";
            classNo = "466";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject467.setOnClickListener(v -> {
            layout = "1.5.7.8.";
            classNo = "467";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject468.setOnClickListener(v -> {
            layout = "1.5.7.9.";
            classNo = "468";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject469.setOnClickListener(v -> {
            layout = "1.5.7.10.";
            classNo = "469";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject470.setOnClickListener(v -> {
            layout = "1.5.8.1.";
            classNo = "470";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject471.setOnClickListener(v -> {
            layout = "1.5.8.2.";
            classNo = "471";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject472.setOnClickListener(v -> {
            layout = "1.5.8.3.";
            classNo = "472";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject473.setOnClickListener(v -> {
            layout = "1.5.8.4.";
            classNo = "473";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject474.setOnClickListener(v -> {
            layout = "1.5.8.5.";
            classNo = "474";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject475.setOnClickListener(v -> {
            layout = "1.5.8.6.";
            classNo = "475";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject476.setOnClickListener(v -> {
            layout = "1.5.8.7.";
            classNo = "476";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject477.setOnClickListener(v -> {
            layout = "1.5.8.8.";
            classNo = "477";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject478.setOnClickListener(v -> {
            layout = "1.5.8.9.";
            classNo = "478";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject479.setOnClickListener(v -> {
            layout = "1.5.8.10.";
            classNo = "479";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject480.setOnClickListener(v -> {
            layout = "1.5.9.1.";
            classNo = "480";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject481.setOnClickListener(v -> {
            layout = "1.5.9.2.";
            classNo = "481";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject482.setOnClickListener(v -> {
            layout = "1.5.9.3.";
            classNo = "482";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject483.setOnClickListener(v -> {
            layout = "1.5.9.4.";
            classNo = "483";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject484.setOnClickListener(v -> {
            layout = "1.5.9.5.";
            classNo = "484";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject485.setOnClickListener(v -> {
            layout = "1.5.9.6.";
            classNo = "485";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject486.setOnClickListener(v -> {
            layout = "1.5.9.7.";
            classNo = "486";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject487.setOnClickListener(v -> {
            layout = "1.5.9.8.";
            classNo = "487";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject488.setOnClickListener(v -> {
            layout = "1.5.9.9.";
            classNo = "488";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject489.setOnClickListener(v -> {
            layout = "1.5.9.10.";
            classNo = "489";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject490.setOnClickListener(v -> {
            layout = "1.5.10.1.";
            classNo = "490";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject491.setOnClickListener(v -> {
            layout = "1.5.10.2.";
            classNo = "491";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject492.setOnClickListener(v -> {
            layout = "1.5.10.3.";
            classNo = "492";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject493.setOnClickListener(v -> {
            layout = "1.5.10.4.";
            classNo = "493";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject494.setOnClickListener(v -> {
            layout = "1.5.10.5.";
            classNo = "494";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject495.setOnClickListener(v -> {
            layout = "1.5.10.6.";
            classNo = "495";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject496.setOnClickListener(v -> {
            layout = "1.5.10.7.";
            classNo = "496";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject497.setOnClickListener(v -> {
            layout = "1.5.10.8.";
            classNo = "497";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject498.setOnClickListener(v -> {
            layout = "1.5.10.9.";
            classNo = "498";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject499.setOnClickListener(v -> {
            layout = "1.5.10.10.";
            classNo = "499";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level15Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level15Activity.this, null);
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
                    Snackbar.make(Level15Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.no_internet), Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(Level15Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_subject), Snackbar.LENGTH_LONG).show();
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
                            Snackbar.make(Level15Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_subject), Snackbar.LENGTH_LONG).show();
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
                    Snackbar.make(Level15Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_subject), Snackbar.LENGTH_LONG).show();
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
                    Log.e(TAG, "loadMore: "+e);
                }
            });
            int socketTimeout = 60000;
            RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            request.setRetryPolicy(policy);
            requestQueue.add(request);
        }
    }

}
