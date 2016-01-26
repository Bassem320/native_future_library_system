package eg.edu.eulc.librarysystem.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import eg.edu.eulc.librarysystem.FragmentsDialogs.ResultsStartAdapter;
import eg.edu.eulc.librarysystem.MyApplication;
import eg.edu.eulc.librarysystem.Objects.ResultsStartItem;
import eg.edu.eulc.librarysystem.R;
import eg.edu.eulc.librarysystem.VolleySingleton;

public class Level16Activity extends AppCompatActivity {
    public static final String PREF_FILE_NAME = "LibrarySystemPref";
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
        setContentView(R.layout.activity_level16);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

        subject500 = (LinearLayout) findViewById(R.id.Subject500);
        subject501 = (LinearLayout) findViewById(R.id.Subject501);
        subject502 = (LinearLayout) findViewById(R.id.Subject502);
        subject503 = (LinearLayout) findViewById(R.id.Subject503);
        subject504 = (LinearLayout) findViewById(R.id.Subject504);
        subject505 = (LinearLayout) findViewById(R.id.Subject505);
        subject506 = (LinearLayout) findViewById(R.id.Subject506);
        subject507 = (LinearLayout) findViewById(R.id.Subject507);
        subject508 = (LinearLayout) findViewById(R.id.Subject508);
        subject509 = (LinearLayout) findViewById(R.id.Subject509);

        subject510 = (LinearLayout) findViewById(R.id.Subject510);
        subject511 = (LinearLayout) findViewById(R.id.Subject511);
        subject512 = (LinearLayout) findViewById(R.id.Subject512);
        subject513 = (LinearLayout) findViewById(R.id.Subject513);
        subject514 = (LinearLayout) findViewById(R.id.Subject514);
        subject515 = (LinearLayout) findViewById(R.id.Subject515);
        subject516 = (LinearLayout) findViewById(R.id.Subject516);
        subject517 = (LinearLayout) findViewById(R.id.Subject517);
        subject518 = (LinearLayout) findViewById(R.id.Subject518);
        subject519 = (LinearLayout) findViewById(R.id.Subject519);

        subject520 = (LinearLayout) findViewById(R.id.Subject520);
        subject521 = (LinearLayout) findViewById(R.id.Subject521);
        subject522 = (LinearLayout) findViewById(R.id.Subject522);
        subject523 = (LinearLayout) findViewById(R.id.Subject523);
        subject524 = (LinearLayout) findViewById(R.id.Subject524);
        subject525 = (LinearLayout) findViewById(R.id.Subject525);
        subject526 = (LinearLayout) findViewById(R.id.Subject526);
        subject527 = (LinearLayout) findViewById(R.id.Subject527);
        subject528 = (LinearLayout) findViewById(R.id.Subject528);
        subject529 = (LinearLayout) findViewById(R.id.Subject529);

        subject530 = (LinearLayout) findViewById(R.id.Subject530);
        subject531 = (LinearLayout) findViewById(R.id.Subject531);
        subject532 = (LinearLayout) findViewById(R.id.Subject532);
        subject533 = (LinearLayout) findViewById(R.id.Subject533);
        subject534 = (LinearLayout) findViewById(R.id.Subject534);
        subject535 = (LinearLayout) findViewById(R.id.Subject535);
        subject536 = (LinearLayout) findViewById(R.id.Subject536);
        subject537 = (LinearLayout) findViewById(R.id.Subject537);
        subject538 = (LinearLayout) findViewById(R.id.Subject538);
        subject539 = (LinearLayout) findViewById(R.id.Subject539);

        subject540 = (LinearLayout) findViewById(R.id.Subject540);
        subject541 = (LinearLayout) findViewById(R.id.Subject541);
        subject542 = (LinearLayout) findViewById(R.id.Subject542);
        subject543 = (LinearLayout) findViewById(R.id.Subject543);
        subject544 = (LinearLayout) findViewById(R.id.Subject544);
        subject545 = (LinearLayout) findViewById(R.id.Subject545);
        subject546 = (LinearLayout) findViewById(R.id.Subject546);
        subject547 = (LinearLayout) findViewById(R.id.Subject547);
        subject548 = (LinearLayout) findViewById(R.id.Subject548);
        subject549 = (LinearLayout) findViewById(R.id.Subject549);

        subject550 = (LinearLayout) findViewById(R.id.Subject550);
        subject551 = (LinearLayout) findViewById(R.id.Subject551);
        subject552 = (LinearLayout) findViewById(R.id.Subject552);
        subject553 = (LinearLayout) findViewById(R.id.Subject553);
        subject554 = (LinearLayout) findViewById(R.id.Subject554);
        subject555 = (LinearLayout) findViewById(R.id.Subject555);
        subject556 = (LinearLayout) findViewById(R.id.Subject556);
        subject557 = (LinearLayout) findViewById(R.id.Subject557);
        subject558 = (LinearLayout) findViewById(R.id.Subject558);
        subject559 = (LinearLayout) findViewById(R.id.Subject559);

        subject560 = (LinearLayout) findViewById(R.id.Subject560);
        subject561 = (LinearLayout) findViewById(R.id.Subject561);
        subject562 = (LinearLayout) findViewById(R.id.Subject562);
        subject563 = (LinearLayout) findViewById(R.id.Subject563);
        subject564 = (LinearLayout) findViewById(R.id.Subject564);
        subject565 = (LinearLayout) findViewById(R.id.Subject565);
        subject566 = (LinearLayout) findViewById(R.id.Subject566);
        subject567 = (LinearLayout) findViewById(R.id.Subject567);
        subject568 = (LinearLayout) findViewById(R.id.Subject568);
        subject569 = (LinearLayout) findViewById(R.id.Subject569);

        subject570 = (LinearLayout) findViewById(R.id.Subject570);
        subject571 = (LinearLayout) findViewById(R.id.Subject571);
        subject572 = (LinearLayout) findViewById(R.id.Subject572);
        subject573 = (LinearLayout) findViewById(R.id.Subject573);
        subject574 = (LinearLayout) findViewById(R.id.Subject574);
        subject575 = (LinearLayout) findViewById(R.id.Subject575);
        subject576 = (LinearLayout) findViewById(R.id.Subject576);
        subject577 = (LinearLayout) findViewById(R.id.Subject577);
        subject578 = (LinearLayout) findViewById(R.id.Subject578);
        subject579 = (LinearLayout) findViewById(R.id.Subject579);

        subject580 = (LinearLayout) findViewById(R.id.Subject580);
        subject581 = (LinearLayout) findViewById(R.id.Subject581);
        subject582 = (LinearLayout) findViewById(R.id.Subject582);
        subject583 = (LinearLayout) findViewById(R.id.Subject583);
        subject584 = (LinearLayout) findViewById(R.id.Subject584);
        subject585 = (LinearLayout) findViewById(R.id.Subject585);
        subject586 = (LinearLayout) findViewById(R.id.Subject586);
        subject587 = (LinearLayout) findViewById(R.id.Subject587);
        subject588 = (LinearLayout) findViewById(R.id.Subject588);
        subject589 = (LinearLayout) findViewById(R.id.Subject589);

        subject590 = (LinearLayout) findViewById(R.id.Subject590);
        subject591 = (LinearLayout) findViewById(R.id.Subject591);
        subject592 = (LinearLayout) findViewById(R.id.Subject592);
        subject593 = (LinearLayout) findViewById(R.id.Subject593);
        subject594 = (LinearLayout) findViewById(R.id.Subject594);
        subject595 = (LinearLayout) findViewById(R.id.Subject595);
        subject596 = (LinearLayout) findViewById(R.id.Subject596);
        subject597 = (LinearLayout) findViewById(R.id.Subject597);
        subject598 = (LinearLayout) findViewById(R.id.Subject598);
        subject599 = (LinearLayout) findViewById(R.id.Subject599);

        resultsSwipe = (SwipeRefreshLayout) findViewById(R.id.ResultsSwipeRefresh);
        resultsRecycler = (RecyclerView) findViewById(R.id.ResultsRecycler);

        sharedPreferences = Level16Activity.this.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);

        VolleySingleton volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();

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

        resultsSwipe.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent);
        resultsSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                startBrowse();
            }
        });

        subject500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.1.1.";
                classNo = "500";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject501.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.1.2.";
                classNo = "501";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject502.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.1.3.";
                classNo = "502";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject503.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.1.4.";
                classNo = "503";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject504.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.1.5.";
                classNo = "504";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject505.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.1.6.";
                classNo = "505";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject506.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.1.7.";
                classNo = "506";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject507.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.1.8.";
                classNo = "507";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject508.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.1.9.";
                classNo = "508";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject509.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.1.10.";
                classNo = "509";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject510.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.2.1.";
                classNo = "510";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject511.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.2.2.";
                classNo = "511";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject512.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.2.3.";
                classNo = "512";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject513.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.2.4.";
                classNo = "513";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject514.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.2.5.";
                classNo = "514";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject515.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.2.6.";
                classNo = "515";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject516.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.2.7.";
                classNo = "516";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject517.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.2.8.";
                classNo = "517";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject518.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.2.9.";
                classNo = "518";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject519.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.2.10.";
                classNo = "519";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject520.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.3.1.";
                classNo = "520";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject521.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.3.2.";
                classNo = "521";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject522.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.3.3.";
                classNo = "522";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject523.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.3.4.";
                classNo = "523";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject524.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.3.5.";
                classNo = "524";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject525.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.3.6.";
                classNo = "525";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject526.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.3.7.";
                classNo = "526";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject527.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.3.8.";
                classNo = "527";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject528.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.3.9.";
                classNo = "528";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject529.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.3.10.";
                classNo = "529";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject530.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.4.1.";
                classNo = "530";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject531.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.4.2.";
                classNo = "531";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject532.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.4.3.";
                classNo = "532";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject533.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.4.4.";
                classNo = "533";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject534.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.4.5.";
                classNo = "534";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject535.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.4.6.";
                classNo = "535";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject536.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.4.7.";
                classNo = "536";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject537.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.4.8.";
                classNo = "537";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject538.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.4.9.";
                classNo = "538";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject539.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.4.10.";
                classNo = "539";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject540.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.5.1.";
                classNo = "540";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject541.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.5.2.";
                classNo = "541";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject542.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.5.3.";
                classNo = "542";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject543.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.5.4.";
                classNo = "543";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject544.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.5.5.";
                classNo = "544";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject545.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.5.6.";
                classNo = "545";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject546.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.5.7.";
                classNo = "546";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject547.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.5.8.";
                classNo = "547";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject548.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.5.9.";
                classNo = "548";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject549.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.5.10.";
                classNo = "549";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject550.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.6.1.";
                classNo = "550";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject551.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.6.2.";
                classNo = "551";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject552.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.6.3.";
                classNo = "552";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject553.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.6.4.";
                classNo = "553";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject554.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.6.5.";
                classNo = "554";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject555.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.6.6.";
                classNo = "555";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject556.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.6.7.";
                classNo = "556";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject557.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.6.8.";
                classNo = "557";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject558.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.6.9.";
                classNo = "558";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject559.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.6.10.";
                classNo = "559";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject560.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.7.1.";
                classNo = "560";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject561.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.7.2.";
                classNo = "561";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject562.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.7.3.";
                classNo = "562";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject563.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.7.4.";
                classNo = "563";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject564.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.7.5.";
                classNo = "564";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject565.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.7.6.";
                classNo = "565";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject566.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.7.7.";
                classNo = "566";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject567.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.7.8.";
                classNo = "567";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject568.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.7.9.";
                classNo = "568";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject569.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.7.10.";
                classNo = "569";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject570.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.8.1.";
                classNo = "570";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject571.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.8.2.";
                classNo = "571";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject572.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.8.3.";
                classNo = "572";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject573.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.8.4.";
                classNo = "573";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject574.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.8.5.";
                classNo = "574";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject575.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.8.6.";
                classNo = "575";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject576.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.8.7.";
                classNo = "576";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject577.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.8.8.";
                classNo = "577";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject578.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.8.9.";
                classNo = "578";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject579.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.8.10.";
                classNo = "579";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject580.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.9.1.";
                classNo = "580";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject581.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.9.2.";
                classNo = "581";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject582.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.9.3.";
                classNo = "582";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject583.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.9.4.";
                classNo = "583";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject584.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.9.5.";
                classNo = "584";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject585.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.9.6.";
                classNo = "585";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject586.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.9.7.";
                classNo = "586";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject587.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.9.8.";
                classNo = "587";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject588.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.9.9.";
                classNo = "588";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject589.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.9.10.";
                classNo = "589";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject590.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.10.1.";
                classNo = "590";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject591.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.10.2.";
                classNo = "591";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject592.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.10.3.";
                classNo = "592";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject593.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.10.4.";
                classNo = "593";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject594.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.10.5.";
                classNo = "594";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject595.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.10.6.";
                classNo = "595";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject596.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.10.7.";
                classNo = "596";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject597.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.10.8.";
                classNo = "597";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject598.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.10.9.";
                classNo = "598";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject599.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.6.10.10.";
                classNo = "599";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level16Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level16Activity.this, null);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
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
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, ((MyApplication) this.getApplication()).getServerName() + "libraries/FuAPI.aspx?fn=BrowseCategories&ScopeID=1.&Id=" + layout + "&ClassNo=" + classNo, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(classNo, response.toString());
                    editor.apply();
                    resultsList = parseResults(response, true);
                    if (!nextPage.equals("")) {
                        resultsList.add(null);
                    }
                    resultsAdapter.notifyDataSetChanged();
                    resultsAdapter.setResultsStartItems(resultsList);
                    resultsRecycler.setVisibility(View.VISIBLE);
                    resultsSwipe.setRefreshing(false);
                } catch (NullPointerException e) {
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    resultsSwipe.setRefreshing(false);
                    if (error instanceof NoConnectionError) {
                        Snackbar.make(Level16Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.no_internet), Snackbar.LENGTH_LONG).show();
                    } else {
                        Snackbar.make(Level16Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_subject), Snackbar.LENGTH_LONG).show();
                    }
                    String strJson = sharedPreferences.getString(classNo, "");
                    if (!strJson.equals("")) {
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
                }
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
                        String classification = "";
                        if (currentItem.has("classification") && !currentItem.isNull("classification")) {
                            JSONArray arrayClassification = currentItem.getJSONArray("classification");
                            for (int j = 0; j < arrayClassification.length(); j++) {
                                classification += "\u00BB " + arrayClassification.getString(j);
                                if (j < (arrayClassification.length() - 1)) {
                                    classification += "\t\t";
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
                        item.setClassification(classification);
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
                            Snackbar.make(Level16Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_subject), Snackbar.LENGTH_LONG).show();
                            resultsSwipe.setVisibility(View.GONE);
                            child.setVisibility(View.VISIBLE);
                        } else {
                            resultsSwipe.setRefreshing(false);
                        }
                    } catch (NullPointerException e) {
                    }
                }
            } catch (JSONException e) {
                try {
                    Snackbar.make(Level16Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_subject), Snackbar.LENGTH_LONG).show();
                    resultsSwipe.setVisibility(View.GONE);
                    child.setVisibility(View.VISIBLE);
                } catch (NullPointerException ex) {
                }
            }
        }
        return listResults;
    }

    public void loadMore() {
        if (!nextPage.equals("")) {
            resultsSwipe.setRefreshing(true);
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, nextPage, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
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
                        if (!nextPage.equals("")) {
                            resultsList.add(null);
                            resultsAdapter.notifyItemInserted(resultsList.size());
                        }
                    } catch (NullPointerException e) {
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    try {
                        resultsSwipe.setRefreshing(false);
                        resultsList.remove(resultsList.size() - 1);
                        resultsAdapter.notifyItemRemoved(resultsList.size());
                        resultsList.add(null);
                        resultsAdapter.notifyItemInserted(resultsList.size());
                    } catch (NullPointerException e) {
                    }
                }
            });
            int socketTimeout = 60000;
            RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            request.setRetryPolicy(policy);
            requestQueue.add(request);
        }
    }

}
