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

public class Level17Activity extends AppCompatActivity {
    public static final String PREF_FILE_NAME = "LibrarySystemPref";
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
        setContentView(R.layout.activity_level17);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

        subject600 = (LinearLayout) findViewById(R.id.Subject600);
        subject601 = (LinearLayout) findViewById(R.id.Subject601);
        subject602 = (LinearLayout) findViewById(R.id.Subject602);
        subject603 = (LinearLayout) findViewById(R.id.Subject603);
        subject604 = (LinearLayout) findViewById(R.id.Subject604);
        subject605 = (LinearLayout) findViewById(R.id.Subject605);
        subject606 = (LinearLayout) findViewById(R.id.Subject606);
        subject607 = (LinearLayout) findViewById(R.id.Subject607);
        subject608 = (LinearLayout) findViewById(R.id.Subject608);
        subject609 = (LinearLayout) findViewById(R.id.Subject609);

        subject610 = (LinearLayout) findViewById(R.id.Subject610);
        subject611 = (LinearLayout) findViewById(R.id.Subject611);
        subject612 = (LinearLayout) findViewById(R.id.Subject612);
        subject613 = (LinearLayout) findViewById(R.id.Subject613);
        subject614 = (LinearLayout) findViewById(R.id.Subject614);
        subject615 = (LinearLayout) findViewById(R.id.Subject615);
        subject616 = (LinearLayout) findViewById(R.id.Subject616);
        subject617 = (LinearLayout) findViewById(R.id.Subject617);
        subject618 = (LinearLayout) findViewById(R.id.Subject618);
        subject619 = (LinearLayout) findViewById(R.id.Subject619);

        subject620 = (LinearLayout) findViewById(R.id.Subject620);
        subject621 = (LinearLayout) findViewById(R.id.Subject621);
        subject622 = (LinearLayout) findViewById(R.id.Subject622);
        subject623 = (LinearLayout) findViewById(R.id.Subject623);
        subject624 = (LinearLayout) findViewById(R.id.Subject624);
        subject625 = (LinearLayout) findViewById(R.id.Subject625);
        subject626 = (LinearLayout) findViewById(R.id.Subject626);
        subject627 = (LinearLayout) findViewById(R.id.Subject627);
        subject628 = (LinearLayout) findViewById(R.id.Subject628);
        subject629 = (LinearLayout) findViewById(R.id.Subject629);

        subject630 = (LinearLayout) findViewById(R.id.Subject630);
        subject631 = (LinearLayout) findViewById(R.id.Subject631);
        subject632 = (LinearLayout) findViewById(R.id.Subject632);
        subject633 = (LinearLayout) findViewById(R.id.Subject633);
        subject634 = (LinearLayout) findViewById(R.id.Subject634);
        subject635 = (LinearLayout) findViewById(R.id.Subject635);
        subject636 = (LinearLayout) findViewById(R.id.Subject636);
        subject637 = (LinearLayout) findViewById(R.id.Subject637);
        subject638 = (LinearLayout) findViewById(R.id.Subject638);
        subject639 = (LinearLayout) findViewById(R.id.Subject639);

        subject640 = (LinearLayout) findViewById(R.id.Subject640);
        subject641 = (LinearLayout) findViewById(R.id.Subject641);
        subject642 = (LinearLayout) findViewById(R.id.Subject642);
        subject643 = (LinearLayout) findViewById(R.id.Subject643);
        subject644 = (LinearLayout) findViewById(R.id.Subject644);
        subject645 = (LinearLayout) findViewById(R.id.Subject645);
        subject646 = (LinearLayout) findViewById(R.id.Subject646);
        subject647 = (LinearLayout) findViewById(R.id.Subject647);
        subject648 = (LinearLayout) findViewById(R.id.Subject648);
        subject649 = (LinearLayout) findViewById(R.id.Subject649);

        subject650 = (LinearLayout) findViewById(R.id.Subject650);
        subject651 = (LinearLayout) findViewById(R.id.Subject651);
        subject652 = (LinearLayout) findViewById(R.id.Subject652);
        subject653 = (LinearLayout) findViewById(R.id.Subject653);
        subject654 = (LinearLayout) findViewById(R.id.Subject654);
        subject655 = (LinearLayout) findViewById(R.id.Subject655);
        subject656 = (LinearLayout) findViewById(R.id.Subject656);
        subject657 = (LinearLayout) findViewById(R.id.Subject657);
        subject658 = (LinearLayout) findViewById(R.id.Subject658);
        subject659 = (LinearLayout) findViewById(R.id.Subject659);

        subject660 = (LinearLayout) findViewById(R.id.Subject660);
        subject661 = (LinearLayout) findViewById(R.id.Subject661);
        subject662 = (LinearLayout) findViewById(R.id.Subject662);
        subject663 = (LinearLayout) findViewById(R.id.Subject663);
        subject664 = (LinearLayout) findViewById(R.id.Subject664);
        subject665 = (LinearLayout) findViewById(R.id.Subject665);
        subject666 = (LinearLayout) findViewById(R.id.Subject666);
        subject667 = (LinearLayout) findViewById(R.id.Subject667);
        subject668 = (LinearLayout) findViewById(R.id.Subject668);
        subject669 = (LinearLayout) findViewById(R.id.Subject669);

        subject670 = (LinearLayout) findViewById(R.id.Subject670);
        subject671 = (LinearLayout) findViewById(R.id.Subject671);
        subject672 = (LinearLayout) findViewById(R.id.Subject672);
        subject673 = (LinearLayout) findViewById(R.id.Subject673);
        subject674 = (LinearLayout) findViewById(R.id.Subject674);
        subject675 = (LinearLayout) findViewById(R.id.Subject675);
        subject676 = (LinearLayout) findViewById(R.id.Subject676);
        subject677 = (LinearLayout) findViewById(R.id.Subject677);
        subject678 = (LinearLayout) findViewById(R.id.Subject678);
        subject679 = (LinearLayout) findViewById(R.id.Subject679);

        subject680 = (LinearLayout) findViewById(R.id.Subject680);
        subject681 = (LinearLayout) findViewById(R.id.Subject681);
        subject682 = (LinearLayout) findViewById(R.id.Subject682);
        subject683 = (LinearLayout) findViewById(R.id.Subject683);
        subject684 = (LinearLayout) findViewById(R.id.Subject684);
        subject685 = (LinearLayout) findViewById(R.id.Subject685);
        subject686 = (LinearLayout) findViewById(R.id.Subject686);
        subject687 = (LinearLayout) findViewById(R.id.Subject687);
        subject688 = (LinearLayout) findViewById(R.id.Subject688);
        subject689 = (LinearLayout) findViewById(R.id.Subject689);

        subject690 = (LinearLayout) findViewById(R.id.Subject690);
        subject691 = (LinearLayout) findViewById(R.id.Subject691);
        subject692 = (LinearLayout) findViewById(R.id.Subject692);
        subject693 = (LinearLayout) findViewById(R.id.Subject693);
        subject694 = (LinearLayout) findViewById(R.id.Subject694);
        subject695 = (LinearLayout) findViewById(R.id.Subject695);
        subject696 = (LinearLayout) findViewById(R.id.Subject696);
        subject697 = (LinearLayout) findViewById(R.id.Subject697);
        subject698 = (LinearLayout) findViewById(R.id.Subject698);
        subject699 = (LinearLayout) findViewById(R.id.Subject699);

        resultsSwipe = (SwipeRefreshLayout) findViewById(R.id.ResultsSwipeRefresh);
        resultsRecycler = (RecyclerView) findViewById(R.id.ResultsRecycler);

        sharedPreferences = Level17Activity.this.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);

        VolleySingleton volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();

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

        subject600.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.1.1.";
                classNo = "600";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject601.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.1.2.";
                classNo = "601";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject602.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.1.3.";
                classNo = "602";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject603.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.1.4.";
                classNo = "603";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject604.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.1.5.";
                classNo = "604";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject605.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.1.6.";
                classNo = "605";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject606.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.1.7.";
                classNo = "606";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject607.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.1.8.";
                classNo = "607";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject608.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.1.9.";
                classNo = "608";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject609.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.1.10.";
                classNo = "609";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject610.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.2.1.";
                classNo = "610";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject611.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.2.2.";
                classNo = "611";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject612.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.2.3.";
                classNo = "612";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject613.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.2.4.";
                classNo = "613";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject614.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.2.5.";
                classNo = "614";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject615.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.2.6.";
                classNo = "615";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject616.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.2.7.";
                classNo = "616";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject617.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.2.8.";
                classNo = "617";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject618.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.2.9.";
                classNo = "618";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject619.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.2.10.";
                classNo = "619";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject620.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.3.1.";
                classNo = "620";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject621.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.3.2.";
                classNo = "621";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject622.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.3.3.";
                classNo = "622";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject623.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.3.4.";
                classNo = "623";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject624.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.3.5.";
                classNo = "624";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject625.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.3.6.";
                classNo = "625";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject626.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.3.7.";
                classNo = "626";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject627.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.3.8.";
                classNo = "627";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject628.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.3.9.";
                classNo = "628";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject629.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.3.10.";
                classNo = "629";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject630.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.4.1.";
                classNo = "630";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject631.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.4.2.";
                classNo = "631";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject632.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.4.3.";
                classNo = "632";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject633.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.4.4.";
                classNo = "633";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject634.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.4.5.";
                classNo = "634";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject635.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.4.6.";
                classNo = "635";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject636.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.4.7.";
                classNo = "636";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject637.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.4.8.";
                classNo = "637";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject638.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.4.9.";
                classNo = "638";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject639.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.4.10.";
                classNo = "639";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject640.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.5.1.";
                classNo = "640";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject641.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.5.2.";
                classNo = "641";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject642.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.5.3.";
                classNo = "642";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject643.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.5.4.";
                classNo = "643";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject644.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.5.5.";
                classNo = "644";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject645.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.5.6.";
                classNo = "645";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject646.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.5.7.";
                classNo = "646";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject647.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.5.8.";
                classNo = "647";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject648.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.5.9.";
                classNo = "648";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject649.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.5.10.";
                classNo = "649";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject650.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.6.1.";
                classNo = "650";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject651.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.6.2.";
                classNo = "651";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject652.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.6.3.";
                classNo = "652";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject653.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.6.4.";
                classNo = "653";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject654.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.6.5.";
                classNo = "654";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject655.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.6.6.";
                classNo = "655";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject656.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.6.7.";
                classNo = "656";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject657.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.6.8.";
                classNo = "657";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject658.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.6.9.";
                classNo = "658";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject659.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.6.10.";
                classNo = "659";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject660.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.7.1.";
                classNo = "660";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject661.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.7.2.";
                classNo = "661";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject662.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.7.3.";
                classNo = "662";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject663.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.7.4.";
                classNo = "663";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject664.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.7.5.";
                classNo = "664";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject665.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.7.6.";
                classNo = "665";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject666.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.7.7.";
                classNo = "666";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject667.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.7.8.";
                classNo = "667";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject668.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.7.9.";
                classNo = "668";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject669.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.7.10.";
                classNo = "669";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject670.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.8.1.";
                classNo = "670";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject671.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.8.2.";
                classNo = "671";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject672.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.8.3.";
                classNo = "672";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject673.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.8.4.";
                classNo = "673";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject674.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.8.5.";
                classNo = "674";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject675.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.8.6.";
                classNo = "675";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject676.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.8.7.";
                classNo = "676";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject677.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.8.8.";
                classNo = "677";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject678.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.8.9.";
                classNo = "678";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject679.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.8.10.";
                classNo = "679";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject680.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.9.1.";
                classNo = "680";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject681.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.9.2.";
                classNo = "681";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject682.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.9.3.";
                classNo = "682";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject683.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.9.4.";
                classNo = "683";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject684.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.9.5.";
                classNo = "684";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject685.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.9.6.";
                classNo = "685";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject686.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.9.7.";
                classNo = "686";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject687.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.9.8.";
                classNo = "687";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject688.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.9.9.";
                classNo = "688";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject689.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.9.10.";
                classNo = "689";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });

        subject690.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.10.1.";
                classNo = "690";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject691.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.10.2.";
                classNo = "691";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject692.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.10.3.";
                classNo = "692";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject693.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.10.4.";
                classNo = "693";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject694.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.10.5.";
                classNo = "694";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject695.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.10.6.";
                classNo = "695";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject696.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.10.7.";
                classNo = "696";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject697.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.10.8.";
                classNo = "697";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject698.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.10.9.";
                classNo = "698";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startBrowse();
            }
        });
        subject699.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = "1.7.10.10.";
                classNo = "699";
                child.setVisibility(View.GONE);
                resultsSwipe.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(Level17Activity.this);
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(Level17Activity.this);
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
                    Snackbar.make(Level17Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.no_internet), Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(Level17Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_subject), Snackbar.LENGTH_LONG).show();
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
                        Snackbar.make(Level17Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_subject), Snackbar.LENGTH_LONG).show();
                        resultsSwipe.setVisibility(View.GONE);
                        child.setVisibility(View.VISIBLE);
                    } else {
                        resultsSwipe.setRefreshing(false);
                    }
                }
            } catch (JSONException e) {
                Snackbar.make(Level17Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_subject), Snackbar.LENGTH_LONG).show();
                resultsSwipe.setVisibility(View.GONE);
                child.setVisibility(View.VISIBLE);
            }
        }
        return listResults;
    }

}
