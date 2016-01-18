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

public class Level13Activity extends AppCompatActivity {
    public static final String PREF_FILE_NAME = "LibrarySystemPref";
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
    private SwipeRefreshLayout resultsSwipe;
    private RecyclerView resultsRecycler;
    private ArrayList<ResultsStartItem> resultsList = new ArrayList<>();
    private ResultsStartAdapter resultsAdapter;
    private LinearLayoutManager linearLayoutManager;
    private boolean mLoadingItems = true;
    private int mOnScreenItems, mTotalItemsInList, mFirstVisibleItem, mPreviousTotal = 0, mVisibleThreshold = 1;
    private SharedPreferences sharedPreferences;

    private RequestQueue requestQueue;

    private String layout, classNo, nextPage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level13);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

        subject200 = (LinearLayout) findViewById(R.id.Subject200);
        subject201 = (LinearLayout) findViewById(R.id.Subject201);
        subject202 = (LinearLayout) findViewById(R.id.Subject202);
        subject203 = (LinearLayout) findViewById(R.id.Subject203);
        subject204 = (LinearLayout) findViewById(R.id.Subject204);
        subject205 = (LinearLayout) findViewById(R.id.Subject205);
        subject206 = (LinearLayout) findViewById(R.id.Subject206);
        subject207 = (LinearLayout) findViewById(R.id.Subject207);
        subject208 = (LinearLayout) findViewById(R.id.Subject208);
        subject209 = (LinearLayout) findViewById(R.id.Subject209);

        subject210 = (LinearLayout) findViewById(R.id.Subject210);
        subject211 = (LinearLayout) findViewById(R.id.Subject211);
        subject212 = (LinearLayout) findViewById(R.id.Subject212);
        subject213 = (LinearLayout) findViewById(R.id.Subject213);
        subject214 = (LinearLayout) findViewById(R.id.Subject214);
        subject215 = (LinearLayout) findViewById(R.id.Subject215);
        subject216 = (LinearLayout) findViewById(R.id.Subject216);
        subject217 = (LinearLayout) findViewById(R.id.Subject217);
        subject218 = (LinearLayout) findViewById(R.id.Subject218);
        subject219 = (LinearLayout) findViewById(R.id.Subject219);

        subject220 = (LinearLayout) findViewById(R.id.Subject220);
        subject221 = (LinearLayout) findViewById(R.id.Subject221);
        subject222 = (LinearLayout) findViewById(R.id.Subject222);
        subject223 = (LinearLayout) findViewById(R.id.Subject223);
        subject224 = (LinearLayout) findViewById(R.id.Subject224);
        subject225 = (LinearLayout) findViewById(R.id.Subject225);
        subject226 = (LinearLayout) findViewById(R.id.Subject226);
        subject227 = (LinearLayout) findViewById(R.id.Subject227);
        subject228 = (LinearLayout) findViewById(R.id.Subject228);
        subject229 = (LinearLayout) findViewById(R.id.Subject229);

        subject230 = (LinearLayout) findViewById(R.id.Subject230);
        subject231 = (LinearLayout) findViewById(R.id.Subject231);
        subject232 = (LinearLayout) findViewById(R.id.Subject232);
        subject233 = (LinearLayout) findViewById(R.id.Subject233);
        subject234 = (LinearLayout) findViewById(R.id.Subject234);
        subject235 = (LinearLayout) findViewById(R.id.Subject235);
        subject236 = (LinearLayout) findViewById(R.id.Subject236);
        subject237 = (LinearLayout) findViewById(R.id.Subject237);
        subject238 = (LinearLayout) findViewById(R.id.Subject238);
        subject239 = (LinearLayout) findViewById(R.id.Subject239);

        subject240 = (LinearLayout) findViewById(R.id.Subject240);
        subject241 = (LinearLayout) findViewById(R.id.Subject241);
        subject242 = (LinearLayout) findViewById(R.id.Subject242);
        subject243 = (LinearLayout) findViewById(R.id.Subject243);
        subject244 = (LinearLayout) findViewById(R.id.Subject244);
        subject245 = (LinearLayout) findViewById(R.id.Subject245);
        subject246 = (LinearLayout) findViewById(R.id.Subject246);
        subject247 = (LinearLayout) findViewById(R.id.Subject247);
        subject248 = (LinearLayout) findViewById(R.id.Subject248);
        subject249 = (LinearLayout) findViewById(R.id.Subject249);

        subject250 = (LinearLayout) findViewById(R.id.Subject250);
        subject251 = (LinearLayout) findViewById(R.id.Subject251);
        subject252 = (LinearLayout) findViewById(R.id.Subject252);
        subject253 = (LinearLayout) findViewById(R.id.Subject253);
        subject254 = (LinearLayout) findViewById(R.id.Subject254);
        subject255 = (LinearLayout) findViewById(R.id.Subject255);
        subject256 = (LinearLayout) findViewById(R.id.Subject256);
        subject257 = (LinearLayout) findViewById(R.id.Subject257);
        subject258 = (LinearLayout) findViewById(R.id.Subject258);
        subject259 = (LinearLayout) findViewById(R.id.Subject259);

        subject260 = (LinearLayout) findViewById(R.id.Subject260);
        subject261 = (LinearLayout) findViewById(R.id.Subject261);
        subject262 = (LinearLayout) findViewById(R.id.Subject262);
        subject263 = (LinearLayout) findViewById(R.id.Subject263);
        subject264 = (LinearLayout) findViewById(R.id.Subject264);
        subject265 = (LinearLayout) findViewById(R.id.Subject265);
        subject266 = (LinearLayout) findViewById(R.id.Subject266);
        subject267 = (LinearLayout) findViewById(R.id.Subject267);
        subject268 = (LinearLayout) findViewById(R.id.Subject268);
        subject269 = (LinearLayout) findViewById(R.id.Subject269);

        subject270 = (LinearLayout) findViewById(R.id.Subject270);
        subject271 = (LinearLayout) findViewById(R.id.Subject271);
        subject272 = (LinearLayout) findViewById(R.id.Subject272);
        subject273 = (LinearLayout) findViewById(R.id.Subject273);
        subject274 = (LinearLayout) findViewById(R.id.Subject274);
        subject275 = (LinearLayout) findViewById(R.id.Subject275);
        subject276 = (LinearLayout) findViewById(R.id.Subject276);
        subject277 = (LinearLayout) findViewById(R.id.Subject277);
        subject278 = (LinearLayout) findViewById(R.id.Subject278);
        subject279 = (LinearLayout) findViewById(R.id.Subject279);

        subject280 = (LinearLayout) findViewById(R.id.Subject280);
        subject281 = (LinearLayout) findViewById(R.id.Subject281);
        subject282 = (LinearLayout) findViewById(R.id.Subject282);
        subject283 = (LinearLayout) findViewById(R.id.Subject283);
        subject284 = (LinearLayout) findViewById(R.id.Subject284);
        subject285 = (LinearLayout) findViewById(R.id.Subject285);
        subject286 = (LinearLayout) findViewById(R.id.Subject286);
        subject287 = (LinearLayout) findViewById(R.id.Subject287);
        subject288 = (LinearLayout) findViewById(R.id.Subject288);
        subject289 = (LinearLayout) findViewById(R.id.Subject289);

        subject290 = (LinearLayout) findViewById(R.id.Subject290);
        subject291 = (LinearLayout) findViewById(R.id.Subject291);
        subject292 = (LinearLayout) findViewById(R.id.Subject292);
        subject293 = (LinearLayout) findViewById(R.id.Subject293);
        subject294 = (LinearLayout) findViewById(R.id.Subject294);
        subject295 = (LinearLayout) findViewById(R.id.Subject295);
        subject296 = (LinearLayout) findViewById(R.id.Subject296);
        subject297 = (LinearLayout) findViewById(R.id.Subject297);
        subject298 = (LinearLayout) findViewById(R.id.Subject298);
        subject299 = (LinearLayout) findViewById(R.id.Subject299);

        resultsSwipe = (SwipeRefreshLayout) findViewById(R.id.ResultsSwipeRefresh);
        resultsRecycler = (RecyclerView) findViewById(R.id.ResultsRecycler);

        sharedPreferences = Level13Activity.this.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);

        VolleySingleton volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();

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

        resultsSwipe.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent);
        resultsSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                startBrowse();
            }
        });

        resultsRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                mOnScreenItems = resultsRecycler.getChildCount();
                mTotalItemsInList = linearLayoutManager.getItemCount();
                mFirstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();
                if (mLoadingItems) {
                    if (mTotalItemsInList > mPreviousTotal + 1) {
                        mLoadingItems = false;
                        mPreviousTotal = mTotalItemsInList;
                    }
                }
                if (!mLoadingItems && (mTotalItemsInList - mOnScreenItems) <= (mFirstVisibleItem + mVisibleThreshold)) {
                    if (!nextPage.equals("")) {
                        resultsSwipe.setRefreshing(true);
                        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, nextPage, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                ArrayList<ResultsStartItem> resultsListMore = parseResults(response, false);
                                resultsSwipe.setRefreshing(false);
                                for (int i = 0; i < resultsListMore.size(); i++) {
                                    ResultsStartItem result = resultsListMore.get(i);
                                    resultsList.add(result);
                                    resultsAdapter.notifyItemInserted(resultsList.size());
                                }
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                resultsSwipe.setRefreshing(false);
                            }
                        });
                        int socketTimeout = 60000;
                        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                        request.setRetryPolicy(policy);
                        requestQueue.add(request);
                        mLoadingItems = true;
                    }
                }
            }
        });

        subject200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.1.1.";
                classNo = "200";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject201.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.1.2.";
                classNo = "201";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject202.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.1.3.";
                classNo = "202";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject203.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.1.4.";
                classNo = "203";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject204.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.1.5.";
                classNo = "204";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject205.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.1.6.";
                classNo = "205";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject206.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.1.7.";
                classNo = "206";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject207.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.1.8.";
                classNo = "207";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject208.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.1.9.";
                classNo = "208";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject209.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.1.10.";
                classNo = "209";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject210.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.2.1.";
                classNo = "210";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject211.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.2.2.";
                classNo = "211";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject212.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.2.3.";
                classNo = "212";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject213.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.2.4.";
                classNo = "213";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject214.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.2.5.";
                classNo = "214";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.2.6.";
                classNo = "215";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject216.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.2.7.";
                classNo = "216";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject217.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.2.8.";
                classNo = "217";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject218.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.2.9.";
                classNo = "218";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject219.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.2.10.";
                classNo = "219";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject220.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.3.1.";
                classNo = "220";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject221.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.3.2.";
                classNo = "221";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject222.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.3.3.";
                classNo = "222";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject223.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.3.4.";
                classNo = "223";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject224.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.3.5.";
                classNo = "224";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject225.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.3.6.";
                classNo = "225";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject226.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.3.7.";
                classNo = "226";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject227.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.3.8.";
                classNo = "227";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject228.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.3.9.";
                classNo = "228";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject229.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.3.10.";
                classNo = "229";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject230.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.4.1.";
                classNo = "230";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject231.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.4.2.";
                classNo = "231";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject232.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.4.3.";
                classNo = "232";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject233.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.4.4.";
                classNo = "233";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject234.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.4.5.";
                classNo = "234";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject235.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.4.6.";
                classNo = "235";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject236.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.4.7.";
                classNo = "236";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject237.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.4.8.";
                classNo = "237";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject238.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.4.9.";
                classNo = "238";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject239.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.4.10.";
                classNo = "239";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject240.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.5.1.";
                classNo = "240";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject241.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.5.2.";
                classNo = "241";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject242.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.5.3.";
                classNo = "242";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject243.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.5.4.";
                classNo = "243";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject244.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.5.5.";
                classNo = "244";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject245.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.5.6.";
                classNo = "245";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject246.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.5.7.";
                classNo = "246";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject247.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.5.8.";
                classNo = "247";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject248.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.5.9.";
                classNo = "248";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject249.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.5.10.";
                classNo = "249";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject250.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.6.1.";
                classNo = "250";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject251.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.6.2.";
                classNo = "251";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject252.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.6.3.";
                classNo = "252";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject253.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.6.4.";
                classNo = "253";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject254.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.6.5.";
                classNo = "254";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject255.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.6.6.";
                classNo = "255";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject256.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.6.7.";
                classNo = "256";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject257.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.6.8.";
                classNo = "257";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject258.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.6.9.";
                classNo = "258";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject259.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.6.10.";
                classNo = "259";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject260.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.7.1.";
                classNo = "260";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject261.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.7.2.";
                classNo = "261";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject262.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.7.3.";
                classNo = "262";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject263.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.7.4.";
                classNo = "263";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject264.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.7.5.";
                classNo = "264";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject265.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.7.6.";
                classNo = "265";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject266.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.7.7.";
                classNo = "266";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject267.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.7.8.";
                classNo = "267";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject268.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.7.9.";
                classNo = "268";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject269.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.7.10.";
                classNo = "269";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject270.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.8.1.";
                classNo = "270";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject271.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.8.2.";
                classNo = "271";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject272.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.8.3.";
                classNo = "272";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject273.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.8.4.";
                classNo = "273";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject274.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.8.5.";
                classNo = "274";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject275.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.8.6.";
                classNo = "275";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject276.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.8.7.";
                classNo = "276";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject277.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.8.8.";
                classNo = "277";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject278.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.8.9.";
                classNo = "278";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject279.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.8.10.";
                classNo = "279";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject280.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.9.1.";
                classNo = "280";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject281.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.9.2.";
                classNo = "281";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject282.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.9.3.";
                classNo = "282";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject283.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.9.4.";
                classNo = "283";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject284.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.9.5.";
                classNo = "284";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject285.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.9.6.";
                classNo = "285";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject286.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.9.7.";
                classNo = "286";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject287.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.9.8.";
                classNo = "287";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject288.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.9.9.";
                classNo = "288";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject289.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.9.10.";
                classNo = "289";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject290.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.10.1.";
                classNo = "290";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject291.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.10.2.";
                classNo = "291";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject292.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.10.3.";
                classNo = "292";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject293.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.10.4.";
                classNo = "293";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject294.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.10.5.";
                classNo = "294";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject295.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.10.6.";
                classNo = "295";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject296.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.10.7.";
                classNo = "296";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject297.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.10.8.";
                classNo = "297";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject298.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.10.9.";
                classNo = "298";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject299.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.3.10.10.";
                classNo = "299";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level13Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level13Activity.this);
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
        mPreviousTotal = 0;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, ((MyApplication) this.getApplication()).getServerName() + "libraries/FuAPI.aspx?fn=BrowseCategories&ScopeID=1.&Id=" + layout + "&ClassNo=" + classNo, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(classNo, response.toString());
                editor.apply();
                resultsList = parseResults(response, true);
                resultsAdapter.setResultsStartItems(resultsList);
                resultsSwipe.setRefreshing(false);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                resultsSwipe.setRefreshing(false);
                if (error instanceof NoConnectionError) {
                    Snackbar.make(Level13Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.no_internet), Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(Level13Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_subject), Snackbar.LENGTH_LONG).show();
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
                    if (firstLoad) {
                        Snackbar.make(Level13Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_subject), Snackbar.LENGTH_LONG).show();
                        resultsSwipe.setVisibility(View.GONE);
                        child.setVisibility(View.VISIBLE);
                    } else {
                        resultsSwipe.setRefreshing(false);
                    }
                }
            } catch (JSONException e) {
                Snackbar.make(Level13Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_subject), Snackbar.LENGTH_LONG).show();
                resultsSwipe.setVisibility(View.GONE);
                child.setVisibility(View.VISIBLE);
            }
        }
        return listResults;
    }

}
