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

public class Level19Activity extends AppCompatActivity {
    public static final String PREF_FILE_NAME = "LibrarySystemPref";
    public static final String TAG = "LEVEL19";
    ScrollView parent, child = null,
            level080, level081, level082, level083, level084, level085, level086, level087, level088, level089;
    LinearLayout subject80, subject81, subject82, subject83, subject84, subject85, subject86, subject87, subject88, subject89,
            subject800, subject801, subject802, subject803, subject804, subject805, subject806, subject807, subject808, subject809,
            subject810, subject811, subject812, subject813, subject814, subject815, subject816, subject817, subject818, subject819,
            subject820, subject821, subject822, subject823, subject824, subject825, subject826, subject827, subject828, subject829,
            subject830, subject831, subject832, subject833, subject834, subject835, subject836, subject837, subject838, subject839,
            subject840, subject841, subject842, subject843, subject844, subject845, subject846, subject847, subject848, subject849,
            subject850, subject851, subject852, subject853, subject854, subject855, subject856, subject857, subject858, subject859,
            subject860, subject861, subject862, subject863, subject864, subject865, subject866, subject867, subject868, subject869,
            subject870, subject871, subject872, subject873, subject874, subject875, subject876, subject877, subject878, subject879,
            subject880, subject881, subject882, subject883, subject884, subject885, subject886, subject887, subject888, subject889,
            subject890, subject891, subject892, subject893, subject894, subject895, subject896, subject897, subject898, subject899;
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
        setContentView(R.layout.activity_level19);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        parent = findViewById(R.id.level08);

        level080 = findViewById(R.id.level080);
        level081 = findViewById(R.id.level081);
        level082 = findViewById(R.id.level082);
        level083 = findViewById(R.id.level083);
        level084 = findViewById(R.id.level084);
        level085 = findViewById(R.id.level085);
        level086 = findViewById(R.id.level086);
        level087 = findViewById(R.id.level087);
        level088 = findViewById(R.id.level088);
        level089 = findViewById(R.id.level089);

        subject80 = findViewById(R.id.Subject80);
        subject81 = findViewById(R.id.Subject81);
        subject82 = findViewById(R.id.Subject82);
        subject83 = findViewById(R.id.Subject83);
        subject84 = findViewById(R.id.Subject84);
        subject85 = findViewById(R.id.Subject85);
        subject86 = findViewById(R.id.Subject86);
        subject87 = findViewById(R.id.Subject87);
        subject88 = findViewById(R.id.Subject88);
        subject89 = findViewById(R.id.Subject89);

        subject800 = findViewById(R.id.Subject800);
        subject801 = findViewById(R.id.Subject801);
        subject802 = findViewById(R.id.Subject802);
        subject803 = findViewById(R.id.Subject803);
        subject804 = findViewById(R.id.Subject804);
        subject805 = findViewById(R.id.Subject805);
        subject806 = findViewById(R.id.Subject806);
        subject807 = findViewById(R.id.Subject807);
        subject808 = findViewById(R.id.Subject808);
        subject809 = findViewById(R.id.Subject809);

        subject810 = findViewById(R.id.Subject810);
        subject811 = findViewById(R.id.Subject811);
        subject812 = findViewById(R.id.Subject812);
        subject813 = findViewById(R.id.Subject813);
        subject814 = findViewById(R.id.Subject814);
        subject815 = findViewById(R.id.Subject815);
        subject816 = findViewById(R.id.Subject816);
        subject817 = findViewById(R.id.Subject817);
        subject818 = findViewById(R.id.Subject818);
        subject819 = findViewById(R.id.Subject819);

        subject820 = findViewById(R.id.Subject820);
        subject821 = findViewById(R.id.Subject821);
        subject822 = findViewById(R.id.Subject822);
        subject823 = findViewById(R.id.Subject823);
        subject824 = findViewById(R.id.Subject824);
        subject825 = findViewById(R.id.Subject825);
        subject826 = findViewById(R.id.Subject826);
        subject827 = findViewById(R.id.Subject827);
        subject828 = findViewById(R.id.Subject828);
        subject829 = findViewById(R.id.Subject829);

        subject830 = findViewById(R.id.Subject830);
        subject831 = findViewById(R.id.Subject831);
        subject832 = findViewById(R.id.Subject832);
        subject833 = findViewById(R.id.Subject833);
        subject834 = findViewById(R.id.Subject834);
        subject835 = findViewById(R.id.Subject835);
        subject836 = findViewById(R.id.Subject836);
        subject837 = findViewById(R.id.Subject837);
        subject838 = findViewById(R.id.Subject838);
        subject839 = findViewById(R.id.Subject839);

        subject840 = findViewById(R.id.Subject840);
        subject841 = findViewById(R.id.Subject841);
        subject842 = findViewById(R.id.Subject842);
        subject843 = findViewById(R.id.Subject843);
        subject844 = findViewById(R.id.Subject844);
        subject845 = findViewById(R.id.Subject845);
        subject846 = findViewById(R.id.Subject846);
        subject847 = findViewById(R.id.Subject847);
        subject848 = findViewById(R.id.Subject848);
        subject849 = findViewById(R.id.Subject849);

        subject850 = findViewById(R.id.Subject850);
        subject851 = findViewById(R.id.Subject851);
        subject852 = findViewById(R.id.Subject852);
        subject853 = findViewById(R.id.Subject853);
        subject854 = findViewById(R.id.Subject854);
        subject855 = findViewById(R.id.Subject855);
        subject856 = findViewById(R.id.Subject856);
        subject857 = findViewById(R.id.Subject857);
        subject858 = findViewById(R.id.Subject858);
        subject859 = findViewById(R.id.Subject859);

        subject860 = findViewById(R.id.Subject860);
        subject861 = findViewById(R.id.Subject861);
        subject862 = findViewById(R.id.Subject862);
        subject863 = findViewById(R.id.Subject863);
        subject864 = findViewById(R.id.Subject864);
        subject865 = findViewById(R.id.Subject865);
        subject866 = findViewById(R.id.Subject866);
        subject867 = findViewById(R.id.Subject867);
        subject868 = findViewById(R.id.Subject868);
        subject869 = findViewById(R.id.Subject869);

        subject870 = findViewById(R.id.Subject870);
        subject871 = findViewById(R.id.Subject871);
        subject872 = findViewById(R.id.Subject872);
        subject873 = findViewById(R.id.Subject873);
        subject874 = findViewById(R.id.Subject874);
        subject875 = findViewById(R.id.Subject875);
        subject876 = findViewById(R.id.Subject876);
        subject877 = findViewById(R.id.Subject877);
        subject878 = findViewById(R.id.Subject878);
        subject879 = findViewById(R.id.Subject879);

        subject880 = findViewById(R.id.Subject880);
        subject881 = findViewById(R.id.Subject881);
        subject882 = findViewById(R.id.Subject882);
        subject883 = findViewById(R.id.Subject883);
        subject884 = findViewById(R.id.Subject884);
        subject885 = findViewById(R.id.Subject885);
        subject886 = findViewById(R.id.Subject886);
        subject887 = findViewById(R.id.Subject887);
        subject888 = findViewById(R.id.Subject888);
        subject889 = findViewById(R.id.Subject889);

        subject890 = findViewById(R.id.Subject890);
        subject891 = findViewById(R.id.Subject891);
        subject892 = findViewById(R.id.Subject892);
        subject893 = findViewById(R.id.Subject893);
        subject894 = findViewById(R.id.Subject894);
        subject895 = findViewById(R.id.Subject895);
        subject896 = findViewById(R.id.Subject896);
        subject897 = findViewById(R.id.Subject897);
        subject898 = findViewById(R.id.Subject898);
        subject899 = findViewById(R.id.Subject899);

        resultsSwipe = findViewById(R.id.ResultsSwipeRefresh);
        resultsRecycler = findViewById(R.id.ResultsRecycler);

        sharedPreferences = Level19Activity.this.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);

        VolleySingleton volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();

        subject80.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level080;
            child.setVisibility(View.VISIBLE);
        });
        subject81.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level081;
            child.setVisibility(View.VISIBLE);
        });
        subject82.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level082;
            child.setVisibility(View.VISIBLE);
        });
        subject83.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level083;
            child.setVisibility(View.VISIBLE);
        });
        subject84.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level084;
            child.setVisibility(View.VISIBLE);
        });
        subject85.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level085;
            child.setVisibility(View.VISIBLE);
        });
        subject86.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level086;
            child.setVisibility(View.VISIBLE);
        });
        subject87.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level087;
            child.setVisibility(View.VISIBLE);
        });
        subject88.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level088;
            child.setVisibility(View.VISIBLE);
        });
        subject89.setOnClickListener(v -> {
            parent.setVisibility(View.GONE);
            child = level089;
            child.setVisibility(View.VISIBLE);
        });

        resultsSwipe.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent);
        resultsSwipe.setOnRefreshListener(() -> resultsSwipe.setRefreshing(false));

        subject800.setOnClickListener(v -> {
            layout = "1.9.1.1.";
            classNo = "800";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject801.setOnClickListener(v -> {
            layout = "1.9.1.2.";
            classNo = "801";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject802.setOnClickListener(v -> {
            layout = "1.9.1.3.";
            classNo = "802";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject803.setOnClickListener(v -> {
            layout = "1.9.1.4.";
            classNo = "803";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject804.setOnClickListener(v -> {
            layout = "1.9.1.5.";
            classNo = "804";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject805.setOnClickListener(v -> {
            layout = "1.9.1.6.";
            classNo = "805";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject806.setOnClickListener(v -> {
            layout = "1.9.1.7.";
            classNo = "806";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject807.setOnClickListener(v -> {
            layout = "1.9.1.8.";
            classNo = "807";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject808.setOnClickListener(v -> {
            layout = "1.9.1.9.";
            classNo = "808";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject809.setOnClickListener(v -> {
            layout = "1.9.1.10.";
            classNo = "809";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject810.setOnClickListener(v -> {
            layout = "1.9.2.1.";
            classNo = "810";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject811.setOnClickListener(v -> {
            layout = "1.9.2.2.";
            classNo = "811";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject812.setOnClickListener(v -> {
            layout = "1.9.2.3.";
            classNo = "812";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject813.setOnClickListener(v -> {
            layout = "1.9.2.4.";
            classNo = "813";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject814.setOnClickListener(v -> {
            layout = "1.9.2.5.";
            classNo = "814";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject815.setOnClickListener(v -> {
            layout = "1.9.2.6.";
            classNo = "815";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject816.setOnClickListener(v -> {
            layout = "1.9.2.7.";
            classNo = "816";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject817.setOnClickListener(v -> {
            layout = "1.9.2.8.";
            classNo = "817";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject818.setOnClickListener(v -> {
            layout = "1.9.2.9.";
            classNo = "818";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject819.setOnClickListener(v -> {
            layout = "1.9.2.10.";
            classNo = "819";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject820.setOnClickListener(v -> {
            layout = "1.9.3.1.";
            classNo = "820";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject821.setOnClickListener(v -> {
            layout = "1.9.3.2.";
            classNo = "821";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject822.setOnClickListener(v -> {
            layout = "1.9.3.3.";
            classNo = "822";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject823.setOnClickListener(v -> {
            layout = "1.9.3.4.";
            classNo = "823";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject824.setOnClickListener(v -> {
            layout = "1.9.3.5.";
            classNo = "824";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject825.setOnClickListener(v -> {
            layout = "1.9.3.6.";
            classNo = "825";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject826.setOnClickListener(v -> {
            layout = "1.9.3.7.";
            classNo = "826";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject827.setOnClickListener(v -> {
            layout = "1.9.3.8.";
            classNo = "827";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject828.setOnClickListener(v -> {
            layout = "1.9.3.9.";
            classNo = "828";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject829.setOnClickListener(v -> {
            layout = "1.9.3.10.";
            classNo = "829";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject830.setOnClickListener(v -> {
            layout = "1.9.4.1.";
            classNo = "830";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject831.setOnClickListener(v -> {
            layout = "1.9.4.2.";
            classNo = "831";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject832.setOnClickListener(v -> {
            layout = "1.9.4.3.";
            classNo = "832";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject833.setOnClickListener(v -> {
            layout = "1.9.4.4.";
            classNo = "833";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject834.setOnClickListener(v -> {
            layout = "1.9.4.5.";
            classNo = "834";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject835.setOnClickListener((View v) -> {
            layout = "1.9.4.6.";
            classNo = "835";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject836.setOnClickListener(v -> {
            layout = "1.9.4.7.";
            classNo = "836";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject837.setOnClickListener(v -> {
            layout = "1.9.4.8.";
            classNo = "837";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject838.setOnClickListener(v -> {
            layout = "1.9.4.9.";
            classNo = "838";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject839.setOnClickListener(v -> {
            layout = "1.9.4.10.";
            classNo = "839";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject840.setOnClickListener(v -> {
            layout = "1.9.5.1.";
            classNo = "840";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject841.setOnClickListener(v -> {
            layout = "1.9.5.2.";
            classNo = "841";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject842.setOnClickListener(v -> {
            layout = "1.9.5.3.";
            classNo = "842";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject843.setOnClickListener(v -> {
            layout = "1.9.5.4.";
            classNo = "843";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject844.setOnClickListener(v -> {
            layout = "1.9.5.5.";
            classNo = "844";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject845.setOnClickListener(v -> {
            layout = "1.9.5.6.";
            classNo = "845";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject846.setOnClickListener(v -> {
            layout = "1.9.5.7.";
            classNo = "846";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject847.setOnClickListener(v -> {
            layout = "1.9.5.8.";
            classNo = "847";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject848.setOnClickListener(v -> {
            layout = "1.9.5.9.";
            classNo = "848";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject849.setOnClickListener(v -> {
            layout = "1.9.5.10.";
            classNo = "849";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject850.setOnClickListener(v -> {
            layout = "1.9.6.1.";
            classNo = "850";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject851.setOnClickListener(v -> {
            layout = "1.9.6.2.";
            classNo = "851";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject852.setOnClickListener(v -> {
            layout = "1.9.6.3.";
            classNo = "852";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject853.setOnClickListener(v -> {
            layout = "1.9.6.4.";
            classNo = "853";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject854.setOnClickListener(v -> {
            layout = "1.9.6.5.";
            classNo = "854";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject855.setOnClickListener(v -> {
            layout = "1.9.6.6.";
            classNo = "855";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject856.setOnClickListener(v -> {
            layout = "1.9.6.7.";
            classNo = "856";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject857.setOnClickListener(v -> {
            layout = "1.9.6.8.";
            classNo = "857";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject858.setOnClickListener(v -> {
            layout = "1.9.6.9.";
            classNo = "858";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject859.setOnClickListener(v -> {
            layout = "1.9.6.10.";
            classNo = "859";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject860.setOnClickListener(v -> {
            layout = "1.9.7.1.";
            classNo = "860";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject861.setOnClickListener(v -> {
            layout = "1.9.7.2.";
            classNo = "861";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject862.setOnClickListener(v -> {
            layout = "1.9.7.3.";
            classNo = "862";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject863.setOnClickListener(v -> {
            layout = "1.9.7.4.";
            classNo = "863";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject864.setOnClickListener(v -> {
            layout = "1.9.7.5.";
            classNo = "864";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject865.setOnClickListener(v -> {
            layout = "1.9.7.6.";
            classNo = "865";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject866.setOnClickListener(v -> {
            layout = "1.9.7.7.";
            classNo = "866";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject867.setOnClickListener(v -> {
            layout = "1.9.7.8.";
            classNo = "867";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject868.setOnClickListener(v -> {
            layout = "1.9.7.9.";
            classNo = "868";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject869.setOnClickListener(v -> {
            layout = "1.9.7.10.";
            classNo = "869";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject870.setOnClickListener(v -> {
            layout = "1.9.8.1.";
            classNo = "870";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject871.setOnClickListener(v -> {
            layout = "1.9.8.2.";
            classNo = "871";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject872.setOnClickListener(v -> {
            layout = "1.9.8.3.";
            classNo = "872";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject873.setOnClickListener(v -> {
            layout = "1.9.8.4.";
            classNo = "873";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject874.setOnClickListener(v -> {
            layout = "1.9.8.5.";
            classNo = "874";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject875.setOnClickListener(v -> {
            layout = "1.9.8.6.";
            classNo = "875";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject876.setOnClickListener(v -> {
            layout = "1.9.8.7.";
            classNo = "876";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject877.setOnClickListener(v -> {
            layout = "1.9.8.8.";
            classNo = "877";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject878.setOnClickListener(v -> {
            layout = "1.9.8.9.";
            classNo = "878";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject879.setOnClickListener(v -> {
            layout = "1.9.8.10.";
            classNo = "879";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject880.setOnClickListener(v -> {
            layout = "1.9.9.1.";
            classNo = "880";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject881.setOnClickListener(v -> {
            layout = "1.9.9.2.";
            classNo = "881";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject882.setOnClickListener(v -> {
            layout = "1.9.9.3.";
            classNo = "882";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject883.setOnClickListener(v -> {
            layout = "1.9.9.4.";
            classNo = "883";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject884.setOnClickListener(v -> {
            layout = "1.9.9.5.";
            classNo = "884";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject885.setOnClickListener(v -> {
            layout = "1.9.9.6.";
            classNo = "885";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject886.setOnClickListener(v -> {
            layout = "1.9.9.7.";
            classNo = "886";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject887.setOnClickListener(v -> {
            layout = "1.9.9.8.";
            classNo = "887";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject888.setOnClickListener(v -> {
            layout = "1.9.9.9.";
            classNo = "888";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject889.setOnClickListener(v -> {
            layout = "1.9.9.10.";
            classNo = "889";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });

        subject890.setOnClickListener(v -> {
            layout = "1.9.10.1.";
            classNo = "890";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject891.setOnClickListener(v -> {
            layout = "1.9.10.2.";
            classNo = "891";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject892.setOnClickListener(v -> {
            layout = "1.9.10.3.";
            classNo = "892";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject893.setOnClickListener(v -> {
            layout = "1.9.10.4.";
            classNo = "893";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject894.setOnClickListener(v -> {
            layout = "1.9.10.5.";
            classNo = "894";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject895.setOnClickListener(v -> {
            layout = "1.9.10.6.";
            classNo = "895";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject896.setOnClickListener(v -> {
            layout = "1.9.10.7.";
            classNo = "896";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject897.setOnClickListener(v -> {
            layout = "1.9.10.8.";
            classNo = "897";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject898.setOnClickListener(v -> {
            layout = "1.9.10.9.";
            classNo = "898";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
            resultsRecycler.setAdapter(resultsAdapter);
            resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
            resultsSwipe.setRefreshing(true);
            startBrowse();
        });
        subject899.setOnClickListener(v -> {
            layout = "1.9.10.10.";
            classNo = "899";
            child.setVisibility(View.GONE);
            resultsSwipe.setVisibility(View.VISIBLE);
            linearLayoutManager = new LinearLayoutManager(Level19Activity.this);
            resultsRecycler.setLayoutManager(linearLayoutManager);
            resultsAdapter = new ResultsStartAdapter(Level19Activity.this, null);
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
                    Snackbar.make(Level19Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.no_internet), Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(Level19Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_subject), Snackbar.LENGTH_LONG).show();
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
                            Snackbar.make(Level19Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_subject), Snackbar.LENGTH_LONG).show();
                            resultsSwipe.setVisibility(View.GONE);
                            child.setVisibility(View.VISIBLE);
                        } else {
                            resultsSwipe.setRefreshing(false);
                        }
                    } catch (NullPointerException e) {
                        Log.e(TAG, "parseResults: "+e );
                    }
                }
            } catch (JSONException e) {
                try {
                    Snackbar.make(Level19Activity.this.findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_subject), Snackbar.LENGTH_LONG).show();
                    resultsSwipe.setVisibility(View.GONE);
                    child.setVisibility(View.VISIBLE);
                } catch (NullPointerException ex) {
                    Log.e(TAG, "parseResults: "+ e );
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
                    Log.e(TAG, "onResponse: "+e);
                }
            }, error -> {
                try {
                    resultsSwipe.setRefreshing(false);
                    resultsList.remove(resultsList.size() - 1);
                    resultsAdapter.notifyItemRemoved(resultsList.size());
                    resultsList.add(null);
                    resultsAdapter.notifyItemInserted(resultsList.size());
                } catch (NullPointerException e) {
                    Log.e(TAG, "onErrorResponse: "+ e );
                }
            });
            int socketTimeout = 60000;
            RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            request.setRetryPolicy(policy);
            requestQueue.add(request);
        }
    }

}
