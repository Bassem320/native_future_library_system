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

public class Level18Activity extends AppCompatActivity {
    public static final String PREF_FILE_NAME = "LibrarySystemPref";
    public static final String TAG = "LEVEL18";
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
        setContentView(R.layout.activity_level18);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        parent = findViewById(R.id.level07);

        level070 = findViewById(R.id.level070);
        level071 = findViewById(R.id.level071);
        level072 = findViewById(R.id.level072);
        level073 = findViewById(R.id.level073);
        level074 = findViewById(R.id.level074);
        level075 = findViewById(R.id.level075);
        level076 = findViewById(R.id.level076);
        level077 = findViewById(R.id.level077);
        level078 = findViewById(R.id.level078);
        level079 = findViewById(R.id.level079);

        subject70 = findViewById(R.id.Subject70);
        subject71 = findViewById(R.id.Subject71);
        subject72 = findViewById(R.id.Subject72);
        subject73 = findViewById(R.id.Subject73);
        subject74 = findViewById(R.id.Subject74);
        subject75 = findViewById(R.id.Subject75);
        subject76 = findViewById(R.id.Subject76);
        subject77 = findViewById(R.id.Subject77);
        subject78 = findViewById(R.id.Subject78);
        subject79 = findViewById(R.id.Subject79);

        subject700 = findViewById(R.id.Subject700);
        subject701 = findViewById(R.id.Subject701);
        subject702 = findViewById(R.id.Subject702);
        subject703 = findViewById(R.id.Subject703);
        subject704 = findViewById(R.id.Subject704);
        subject705 = findViewById(R.id.Subject705);
        subject706 = findViewById(R.id.Subject706);
        subject707 = findViewById(R.id.Subject707);
        subject708 = findViewById(R.id.Subject708);
        subject709 = findViewById(R.id.Subject709);

        subject710 = findViewById(R.id.Subject710);
        subject711 = findViewById(R.id.Subject711);
        subject712 = findViewById(R.id.Subject712);
        subject713 = findViewById(R.id.Subject713);
        subject714 = findViewById(R.id.Subject714);
        subject715 = findViewById(R.id.Subject715);
        subject716 = findViewById(R.id.Subject716);
        subject717 = findViewById(R.id.Subject717);
        subject718 = findViewById(R.id.Subject718);
        subject719 = findViewById(R.id.Subject719);

        subject720 = findViewById(R.id.Subject720);
        subject721 = findViewById(R.id.Subject721);
        subject722 = findViewById(R.id.Subject722);
        subject723 = findViewById(R.id.Subject723);
        subject724 = findViewById(R.id.Subject724);
        subject725 = findViewById(R.id.Subject725);
        subject726 = findViewById(R.id.Subject726);
        subject727 = findViewById(R.id.Subject727);
        subject728 = findViewById(R.id.Subject728);
        subject729 = findViewById(R.id.Subject729);

        subject730 = findViewById(R.id.Subject730);
        subject731 = findViewById(R.id.Subject731);
        subject732 = findViewById(R.id.Subject732);
        subject733 = findViewById(R.id.Subject733);
        subject734 = findViewById(R.id.Subject734);
        subject735 = findViewById(R.id.Subject735);
        subject736 = findViewById(R.id.Subject736);
        subject737 = findViewById(R.id.Subject737);
        subject738 = findViewById(R.id.Subject738);
        subject739 = findViewById(R.id.Subject739);

        subject740 = findViewById(R.id.Subject740);
        subject741 = findViewById(R.id.Subject741);
        subject742 = findViewById(R.id.Subject742);
        subject743 = findViewById(R.id.Subject743);
        subject744 = findViewById(R.id.Subject744);
        subject745 = findViewById(R.id.Subject745);
        subject746 = findViewById(R.id.Subject746);
        subject747 = findViewById(R.id.Subject747);
        subject748 = findViewById(R.id.Subject748);
        subject749 = findViewById(R.id.Subject749);

        subject750 = findViewById(R.id.Subject750);
        subject751 = findViewById(R.id.Subject751);
        subject752 = findViewById(R.id.Subject752);
        subject753 = findViewById(R.id.Subject753);
        subject754 = findViewById(R.id.Subject754);
        subject755 = findViewById(R.id.Subject755);
        subject756 = findViewById(R.id.Subject756);
        subject757 = findViewById(R.id.Subject757);
        subject758 = findViewById(R.id.Subject758);
        subject759 = findViewById(R.id.Subject759);

        subject760 = findViewById(R.id.Subject760);
        subject761 = findViewById(R.id.Subject761);
        subject762 = findViewById(R.id.Subject762);
        subject763 = findViewById(R.id.Subject763);
        subject764 = findViewById(R.id.Subject764);
        subject765 = findViewById(R.id.Subject765);
        subject766 = findViewById(R.id.Subject766);
        subject767 = findViewById(R.id.Subject767);
        subject768 = findViewById(R.id.Subject768);
        subject769 = findViewById(R.id.Subject769);

        subject770 = findViewById(R.id.Subject770);
        subject771 = findViewById(R.id.Subject771);
        subject772 = findViewById(R.id.Subject772);
        subject773 = findViewById(R.id.Subject773);
        subject774 = findViewById(R.id.Subject774);
        subject775 = findViewById(R.id.Subject775);
        subject776 = findViewById(R.id.Subject776);
        subject777 = findViewById(R.id.Subject777);
        subject778 = findViewById(R.id.Subject778);
        subject779 = findViewById(R.id.Subject779);

        subject780 = findViewById(R.id.Subject780);
        subject781 = findViewById(R.id.Subject781);
        subject782 = findViewById(R.id.Subject782);
        subject783 = findViewById(R.id.Subject783);
        subject784 = findViewById(R.id.Subject784);
        subject785 = findViewById(R.id.Subject785);
        subject786 = findViewById(R.id.Subject786);
        subject787 = findViewById(R.id.Subject787);
        subject788 = findViewById(R.id.Subject788);
        subject789 = findViewById(R.id.Subject789);

        subject790 = findViewById(R.id.Subject790);
        subject791 = findViewById(R.id.Subject791);
        subject792 = findViewById(R.id.Subject792);
        subject793 = findViewById(R.id.Subject793);
        subject794 = findViewById(R.id.Subject794);
        subject795 = findViewById(R.id.Subject795);
        subject796 = findViewById(R.id.Subject796);
        subject797 = findViewById(R.id.Subject797);
        subject798 = findViewById(R.id.Subject798);
        subject799 = findViewById(R.id.Subject799);

        resultsSwipe = findViewById(R.id.ResultsSwipeRefresh);
        resultsRecycler = findViewById(R.id.ResultsRecycler);

        sharedPreferences = Level18Activity.this.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);

        VolleySingleton volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();

        subject70.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level070;
            child.setVisibility(View.VISIBLE);
        });
        subject71.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level071;
            child.setVisibility(View.VISIBLE);
        });
        subject72.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level072;
            child.setVisibility(View.VISIBLE);
        });
        subject73.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level073;
            child.setVisibility(View.VISIBLE);
        });
        subject74.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level074;
            child.setVisibility(View.VISIBLE);
        });
        subject75.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level075;
            child.setVisibility(View.VISIBLE);
        });
        subject76.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level076;
            child.setVisibility(View.VISIBLE);
        });
        subject77.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level077;
            child.setVisibility(View.VISIBLE);
        });
        subject78.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level078;
            child.setVisibility(View.VISIBLE);
        });
        subject79.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level079;
            child.setVisibility(View.VISIBLE);
        });

        resultsSwipe.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent);
        resultsSwipe.setOnRefreshListener(() -> resultsSwipe.setRefreshing(false));

        subject700.setOnClickListener(v -> {
            layout = "1.8.1.1.";
            classNo = "700";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject701.setOnClickListener(v -> {
            layout = "1.8.1.2.";
            classNo = "701";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject702.setOnClickListener(v -> {
            layout = "1.8.1.3.";
            classNo = "702";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject703.setOnClickListener(v -> {
            layout = "1.8.1.4.";
            classNo = "703";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject704.setOnClickListener(v -> {
            layout = "1.8.1.5.";
            classNo = "704";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject705.setOnClickListener(v -> {
            layout = "1.8.1.6.";
            classNo = "705";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject706.setOnClickListener(v -> {
            layout = "1.8.1.7.";
            classNo = "706";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject707.setOnClickListener(v -> {
            layout = "1.8.1.8.";
            classNo = "707";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject708.setOnClickListener(v -> {
            layout = "1.8.1.9.";
            classNo = "708";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject709.setOnClickListener(v -> {
            layout = "1.8.1.10.";
            classNo = "709";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject710.setOnClickListener(v -> {
            layout = "1.8.2.1.";
            classNo = "710";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject711.setOnClickListener(v -> {
            layout = "1.8.2.2.";
            classNo = "711";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject712.setOnClickListener(v -> {
            layout = "1.8.2.3.";
            classNo = "712";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject713.setOnClickListener(v -> {
            layout = "1.8.2.4.";
            classNo = "713";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject714.setOnClickListener(v -> {
            layout = "1.8.2.5.";
            classNo = "714";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject715.setOnClickListener(v -> {
            layout = "1.8.2.6.";
            classNo = "715";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject716.setOnClickListener(v -> {
            layout = "1.8.2.7.";
            classNo = "716";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject717.setOnClickListener(v -> {
            layout = "1.8.2.8.";
            classNo = "717";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject718.setOnClickListener(v -> {
            layout = "1.8.2.9.";
            classNo = "718";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject719.setOnClickListener(v -> {
            layout = "1.8.2.10.";
            classNo = "719";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject720.setOnClickListener(v -> {
            layout = "1.8.3.1.";
            classNo = "720";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject721.setOnClickListener(v -> {
            layout = "1.8.3.2.";
            classNo = "721";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject722.setOnClickListener(v -> {
            layout = "1.8.3.3.";
            classNo = "722";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject723.setOnClickListener(v -> {
            layout = "1.8.3.4.";
            classNo = "723";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject724.setOnClickListener(v -> {
            layout = "1.8.3.5.";
            classNo = "724";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject725.setOnClickListener(v -> {
            layout = "1.8.3.6.";
            classNo = "725";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject726.setOnClickListener(v -> {
            layout = "1.8.3.7.";
            classNo = "726";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject727.setOnClickListener(v -> {
            layout = "1.8.3.8.";
            classNo = "727";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject728.setOnClickListener(v -> {
            layout = "1.8.3.9.";
            classNo = "728";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject729.setOnClickListener(v -> {
            layout = "1.8.3.10.";
            classNo = "729";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject730.setOnClickListener(v -> {
            layout = "1.8.4.1.";
            classNo = "730";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject731.setOnClickListener(v -> {
            layout = "1.8.4.2.";
            classNo = "731";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject732.setOnClickListener(v -> {
            layout = "1.8.4.3.";
            classNo = "732";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject733.setOnClickListener(v -> {
            layout = "1.8.4.4.";
            classNo = "733";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject734.setOnClickListener(v -> {
            layout = "1.8.4.5.";
            classNo = "734";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject735.setOnClickListener(v -> {
            layout = "1.8.4.6.";
            classNo = "735";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject736.setOnClickListener(v -> {
            layout = "1.8.4.7.";
            classNo = "736";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject737.setOnClickListener(v -> {
            layout = "1.8.4.8.";
            classNo = "737";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject738.setOnClickListener(v -> {
            layout = "1.8.4.9.";
            classNo = "738";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject739.setOnClickListener(v -> {
            layout = "1.8.4.10.";
            classNo = "739";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject740.setOnClickListener(v -> {
            layout = "1.8.5.1.";
            classNo = "740";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject741.setOnClickListener(v -> {
            layout = "1.8.5.2.";
            classNo = "741";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject742.setOnClickListener(v -> {
            layout = "1.8.5.3.";
            classNo = "742";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject743.setOnClickListener(v -> {
            layout = "1.8.5.4.";
            classNo = "743";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject744.setOnClickListener(v -> {
            layout = "1.8.5.5.";
            classNo = "744";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject745.setOnClickListener(v -> {
            layout = "1.8.5.6.";
            classNo = "745";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject746.setOnClickListener(v -> {
            layout = "1.8.5.7.";
            classNo = "746";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject747.setOnClickListener(v -> {
            layout = "1.8.5.8.";
            classNo = "747";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject748.setOnClickListener(v -> {
            layout = "1.8.5.9.";
            classNo = "748";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject749.setOnClickListener(v -> {
            layout = "1.8.5.10.";
            classNo = "749";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject750.setOnClickListener(v -> {
            layout = "1.8.6.1.";
            classNo = "750";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject751.setOnClickListener(v -> {
            layout = "1.8.6.2.";
            classNo = "751";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject752.setOnClickListener(v -> {
            layout = "1.8.6.3.";
            classNo = "752";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject753.setOnClickListener(v -> {
            layout = "1.8.6.4.";
            classNo = "753";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject754.setOnClickListener(v -> {
            layout = "1.8.6.5.";
            classNo = "754";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject755.setOnClickListener(v -> {
            layout = "1.8.6.6.";
            classNo = "755";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject756.setOnClickListener(v -> {
            layout = "1.8.6.7.";
            classNo = "756";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject757.setOnClickListener(v -> {
            layout = "1.8.6.8.";
            classNo = "757";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject758.setOnClickListener(v -> {
            layout = "1.8.6.9.";
            classNo = "758";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject759.setOnClickListener(v -> {
            layout = "1.8.6.10.";
            classNo = "759";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject760.setOnClickListener(v -> {
            layout = "1.8.7.1.";
            classNo = "760";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject761.setOnClickListener(v -> {
            layout = "1.8.7.2.";
            classNo = "761";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject762.setOnClickListener(v -> {
            layout = "1.8.7.3.";
            classNo = "762";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject763.setOnClickListener(v -> {
            layout = "1.8.7.4.";
            classNo = "763";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject764.setOnClickListener(v -> {
            layout = "1.8.7.5.";
            classNo = "764";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject765.setOnClickListener(v -> {
            layout = "1.8.7.6.";
            classNo = "765";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject766.setOnClickListener(v -> {
            layout = "1.8.7.7.";
            classNo = "766";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject767.setOnClickListener(v -> {
            layout = "1.8.7.8.";
            classNo = "767";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject768.setOnClickListener(v -> {
            layout = "1.8.7.9.";
            classNo = "768";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject769.setOnClickListener(v -> {
            layout = "1.8.7.10.";
            classNo = "769";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject770.setOnClickListener(v -> {
            layout = "1.8.8.1.";
            classNo = "770";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject771.setOnClickListener(v -> {
            layout = "1.8.8.2.";
            classNo = "771";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject772.setOnClickListener(v -> {
            layout = "1.8.8.3.";
            classNo = "772";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject773.setOnClickListener(v -> {
            layout = "1.8.8.4.";
            classNo = "773";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject774.setOnClickListener(v -> {
            layout = "1.8.8.5.";
            classNo = "774";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject775.setOnClickListener(v -> {
            layout = "1.8.8.6.";
            classNo = "775";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject776.setOnClickListener(v -> {
            layout = "1.8.8.7.";
            classNo = "776";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject777.setOnClickListener(v -> {
            layout = "1.8.8.8.";
            classNo = "777";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject778.setOnClickListener(v -> {
            layout = "1.8.8.9.";
            classNo = "778";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject779.setOnClickListener(v -> {
            layout = "1.8.8.10.";
            classNo = "779";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject780.setOnClickListener(v -> {
            layout = "1.8.9.1.";
            classNo = "780";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject781.setOnClickListener(v -> {
            layout = "1.8.9.2.";
            classNo = "781";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject782.setOnClickListener(v -> {
            layout = "1.8.9.3.";
            classNo = "782";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject783.setOnClickListener(v -> {
            layout = "1.8.9.4.";
            classNo = "783";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject784.setOnClickListener(v -> {
            layout = "1.8.9.5.";
            classNo = "784";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject785.setOnClickListener(v -> {
            layout = "1.8.9.6.";
            classNo = "785";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject786.setOnClickListener(v -> {
            layout = "1.8.9.7.";
            classNo = "786";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject787.setOnClickListener(v -> {
            layout = "1.8.9.8.";
            classNo = "787";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject788.setOnClickListener(v -> {
            layout = "1.8.9.9.";
            classNo = "788";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject789.setOnClickListener(v -> {
            layout = "1.8.9.10.";
            classNo = "789";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject790.setOnClickListener(v -> {
            layout = "1.8.10.1.";
            classNo = "790";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject791.setOnClickListener(v -> {
            layout = "1.8.10.2.";
            classNo = "791";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject792.setOnClickListener(v -> {
            layout = "1.8.10.3.";
            classNo = "792";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject793.setOnClickListener(v -> {
            layout = "1.8.10.4.";
            classNo = "793";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject794.setOnClickListener(v -> {
            layout = "1.8.10.5.";
            classNo = "794";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject795.setOnClickListener(v -> {
            layout = "1.8.10.6.";
            classNo = "795";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject796.setOnClickListener(v -> {
            layout = "1.8.10.7.";
            classNo = "796";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject797.setOnClickListener(v -> {
            layout = "1.8.10.8.";
            classNo = "797";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject798.setOnClickListener(v -> {
            layout = "1.8.10.9.";
            classNo = "798";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject799.setOnClickListener(v -> {
            layout = "1.8.10.10.";
            classNo = "799";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level18Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level18Activity.this, null);
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
                Log.e(TAG, "onResponse: " + e );
            }
        }, error -> {
            Log.e(TAG, "startBrowse: " + error);
            try {
                resultsSwipe.setRefreshing(false);
                if (error instanceof NoConnectionError) {
                    Snackbar.make(Level18Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.no_internet), Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(Level18Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_subject), Snackbar.LENGTH_LONG).show();
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
                Log.e(TAG, "onErrorResponse: " + e );
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
                            Snackbar.make(Level18Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_subject), Snackbar.LENGTH_LONG).show();
                            resultsSwipe.setVisibility(View.GONE);
                            child.setVisibility(View.VISIBLE);
                        } else {
                            resultsSwipe.setRefreshing(false);
                        }
                    } catch (NullPointerException e) {
                        Log.e(TAG, "parseResults: " + e );
                    }
                }
            } catch (JSONException e) {
                try {
                    Snackbar.make(Level18Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_subject), Snackbar.LENGTH_LONG).show();
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
