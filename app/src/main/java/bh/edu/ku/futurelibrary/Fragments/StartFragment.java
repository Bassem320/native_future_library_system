package bh.edu.ku.futurelibrary.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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
import java.util.HashMap;
import java.util.Map;

import bh.edu.ku.futurelibrary.Activities.Level110Activity;
import bh.edu.ku.futurelibrary.Activities.Level11Activity;
import bh.edu.ku.futurelibrary.Activities.Level12Activity;
import bh.edu.ku.futurelibrary.Activities.Level13Activity;
import bh.edu.ku.futurelibrary.Activities.Level14Activity;
import bh.edu.ku.futurelibrary.Activities.Level15Activity;
import bh.edu.ku.futurelibrary.Activities.Level16Activity;
import bh.edu.ku.futurelibrary.Activities.Level17Activity;
import bh.edu.ku.futurelibrary.Activities.Level18Activity;
import bh.edu.ku.futurelibrary.Activities.Level19Activity;
import bh.edu.ku.futurelibrary.Adapters.SiteNewsListAdapter;
import bh.edu.ku.futurelibrary.CustomRequest;
import bh.edu.ku.futurelibrary.FragmentsDialogs.ResultsStartAdapter;
import bh.edu.ku.futurelibrary.MyApplication;
import bh.edu.ku.futurelibrary.Objects.ResultsStartItem;
import bh.edu.ku.futurelibrary.Objects.SiteNewsItem;
import bh.edu.ku.futurelibrary.VolleySingleton;
import bh.edu.ku.futurelibrary.R;

/**
 * Created by Eslam El-Meniawy on 01-Nov-15.
 */
public class StartFragment extends Fragment {
    public static final String PREF_FILE_NAME = "LibrarySystemPref";
    public static final String TAG = "StartFragment";
    private EditText startSearchText;
    private int searchType = 0;
    private final String[] searchTypes = {"", "24.2.1.", "24.2.5.", "24.2.2."};
    private String searchText, nextPage = "";
    private LinearLayout resultsLayout;
    private ScrollView searchLayout;
    private SwipeRefreshLayout resultsStartSwipe;
    private RecyclerView listItemsRecycler, resultsStartRecycler;
    private ProgressBar loadingItems;
    private SharedPreferences sharedPreferences;
    private ArrayList<SiteNewsItem> siteNewsList = new ArrayList<>();
    private ArrayList<ResultsStartItem> resultsStartList = new ArrayList<>();
    private SiteNewsListAdapter itemsListAdapter;
    private ResultsStartAdapter resultsStartAdapter;
    private RequestQueue requestQueue;
    private LinearLayoutManager linearLayoutManager;
    private boolean stop = false;
    private TextView resultsNumber;

    public StartFragment() {
    }

    public static void hide_keyboard_from(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_start, container, false);

        startSearchText = rootView.findViewById(R.id.start_search_EditText);
        Spinner searchTypeSpinner = rootView.findViewById(R.id.start_search_type);
        Button startSearch = rootView.findViewById(R.id.search_button);
        searchLayout = rootView.findViewById(R.id.searchLayout);
        resultsLayout = rootView.findViewById(R.id.resultsLayout);
        LinearLayout subject0 = rootView.findViewById(R.id.Subject0);
        LinearLayout subject1 = rootView.findViewById(R.id.Subject1);
        LinearLayout subject2 = rootView.findViewById(R.id.Subject2);
        LinearLayout subject3 = rootView.findViewById(R.id.Subject3);
        LinearLayout subject4 = rootView.findViewById(R.id.Subject4);
        LinearLayout subject5 = rootView.findViewById(R.id.Subject5);
        LinearLayout subject6 = rootView.findViewById(R.id.Subject6);
        LinearLayout subject7 = rootView.findViewById(R.id.Subject7);
        LinearLayout subject8 = rootView.findViewById(R.id.Subject8);
        LinearLayout subject9 = rootView.findViewById(R.id.Subject9);
        listItemsRecycler = rootView.findViewById(R.id.RecyclerNews);
        loadingItems = rootView.findViewById(R.id.SiteNewsProgress);
        resultsStartRecycler = rootView.findViewById(R.id.ResultsStart);
        resultsStartSwipe = rootView.findViewById(R.id.ResultsStartSwipeRefresh);
        resultsNumber = rootView.findViewById(R.id.ResultsNumber);

        startSearchText.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                hide_keyboard_from(getActivity(), startSearchText);
            }
        });

        sharedPreferences = getActivity().getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);

        linearLayoutManager = new LinearLayoutManager(getActivity());
        listItemsRecycler.setLayoutManager(linearLayoutManager);
        itemsListAdapter = new SiteNewsListAdapter(getActivity());
        listItemsRecycler.setAdapter(itemsListAdapter);
        VolleySingleton volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.start_search_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        searchTypeSpinner.setAdapter(adapter);
        searchTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                searchType = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        startSearch.setOnClickListener(v -> {
            searchText = startSearchText.getText().toString();
            if (searchText.isEmpty()) {
                startSearchText.setError(getText(R.string.enter_text));
            } else {
                searchLayout.setVisibility(View.GONE);
                resultsLayout.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(getActivity());
                resultsStartRecycler.setLayoutManager(linearLayoutManager);
                resultsStartAdapter = new ResultsStartAdapter(getActivity(), StartFragment.this);
                resultsStartSwipe.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent);
                resultsStartSwipe.setOnRefreshListener(() -> resultsStartSwipe.setRefreshing(false));
                resultsStartRecycler.setAdapter(resultsStartAdapter);
                resultsStartSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsStartSwipe.setRefreshing(true);
                startSearch();
            }
        });

        subject0.setOnClickListener(v -> startActivity(new Intent(getActivity(), Level11Activity.class)));

        subject1.setOnClickListener(v -> startActivity(new Intent(getActivity(), Level12Activity.class)));

        subject2.setOnClickListener(v -> startActivity(new Intent(getActivity(), Level13Activity.class)));

        subject3.setOnClickListener(v -> startActivity(new Intent(getActivity(), Level14Activity.class)));

        subject4.setOnClickListener(v -> startActivity(new Intent(getActivity(), Level15Activity.class)));

        subject5.setOnClickListener(v -> startActivity(new Intent(getActivity(), Level16Activity.class)));

        subject6.setOnClickListener(v -> startActivity(new Intent(getActivity(), Level17Activity.class)));

        subject7.setOnClickListener(v -> startActivity(new Intent(getActivity(), Level18Activity.class)));

        subject8.setOnClickListener(v -> startActivity(new Intent(getActivity(), Level19Activity.class)));

        subject9.setOnClickListener(v -> startActivity(new Intent(getActivity(), Level110Activity.class)));

        requestSiteNews();

        return rootView;
    }

    public boolean getLayoutVisibility() {
        return resultsLayout.getVisibility() == View.VISIBLE;
    }

    public void showSearch() {
        resultsLayout.setVisibility(View.GONE);
        searchLayout.setVisibility(View.VISIBLE);
    }

    public void stopRequest(boolean stop) {
        this.stop = stop;
    }

    private void requestSiteNews() {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, ((MyApplication) getActivity().getApplication()).getServerName() + "libraries/fuapi.aspx?ScopeID=" + ((MyApplication) getActivity().getApplication()).getScopeID() + "&fn=MobileNews", response -> {
            try {
                if (!stop) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("siteNewsList", response.toString());
                    editor.apply();
                    siteNewsList = parseSiteNews(response);
                    itemsListAdapter.notifyDataSetChanged();
                    itemsListAdapter.setListSiteNewsItems(siteNewsList);
                    listItemsRecycler.setVisibility(View.VISIBLE);
                    loadingItems.setVisibility(View.GONE);
                }
            } catch (NullPointerException e) {
                Log.e(TAG, "requestSiteNews: " + e );
            }
        }, error -> {
            Log.e(TAG, "requestSiteNews: " + error );
            try {
                if (!stop) {
                    loadingItems.setVisibility(View.GONE);
                    if (error instanceof NoConnectionError) {
                        Snackbar.make(getActivity().findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.no_internet), Snackbar.LENGTH_LONG).show();
                    } else {
                        Snackbar.make(getActivity().findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_site_news), Snackbar.LENGTH_LONG).show();
                    }
                    String strJson = sharedPreferences.getString("siteNewsList", "");
                    if (!strJson.isEmpty()) {
                        try {
                            JSONObject jsonData = new JSONObject(strJson);
                            siteNewsList = parseSiteNews(jsonData);
                            itemsListAdapter.setListSiteNewsItems(siteNewsList);
                        } catch (JSONException e) {
                            Log.e(TAG, "requestSiteNews: " + e);
                        }
                    }
                }
            } catch (NullPointerException e) {
                Log.e(TAG, "requestSiteNews: " + e);
            }
        });
        int socketTimeout = 60000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        request.setRetryPolicy(policy);
        requestQueue.add(request);
    }

    private ArrayList<SiteNewsItem> parseSiteNews(JSONObject response) {
        ArrayList<SiteNewsItem> listItems = new ArrayList<>();
        if (response != null && response.length() > 0) {
            try {
                if (response.has("news")) {
                    JSONArray arrayItems = response.getJSONArray("news");
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
                        String details = "No Details Available!";
                        if (currentItem.has("details") && !currentItem.isNull("details")) {
                            details = currentItem.getString("details");
                        }
                        SiteNewsItem item = new SiteNewsItem();
                        item.setId(id);
                        item.setTitle(title);
                        item.setDetails(details);
                        if (id != -1 && !title.equals("No Data Available")) {
                            listItems.add(item);
                        }
                    }
                } else {
                    String strJson = sharedPreferences.getString("siteNewsList", "");
                    if (!strJson.isEmpty()) {
                        try {
                            JSONObject jsonData = new JSONObject(strJson);
                            siteNewsList = parseSiteNews(jsonData);
                            itemsListAdapter.setListSiteNewsItems(siteNewsList);
                        } catch (JSONException e) {
                            Log.e(TAG, "parseSiteNews: " + e);
                        }
                    }
                }
            } catch (JSONException e) {
                String strJson = sharedPreferences.getString("siteNewsList", "");
                if (!strJson.isEmpty()) {
                    try {
                        JSONObject jsonData = new JSONObject(strJson);
                        siteNewsList = parseSiteNews(jsonData);
                        itemsListAdapter.setListSiteNewsItems(siteNewsList);
                    } catch (JSONException ex) {
                        Log.e(TAG, "parseSiteNews: " + e);
                    }
                }
            }
        }
        return listItems;
    }

    private void startSearch() {
        nextPage = "";
        Map<String, String> params = new HashMap<>();
        params.put("ScopeID", ((MyApplication) getActivity().getApplication()).getScopeID());
        params.put("fn", "ApplyMobileSearch");
        params.put("criteria1", "1.");
        params.put("OrderKey", "publishYear desc");
        params.put("SearchText1", searchText);
        params.put("ItemType", searchTypes[searchType]);
        CustomRequest request = new CustomRequest(Request.Method.POST, ((MyApplication) getActivity().getApplication()).getServerName() + "libraries/fuapi.aspx?fn=ApplyMobileSearch", params, response -> {
            try {
                resultsStartList = parseResults(response, true);
                if (!nextPage.isEmpty()) {
                    resultsStartList.add(null);
                }
                resultsStartAdapter.notifyDataSetChanged();
                resultsStartAdapter.setResultsStartItems(resultsStartList);
                resultsStartRecycler.setVisibility(View.VISIBLE);
                resultsStartSwipe.setRefreshing(false);
            } catch (NullPointerException e) {
                Log.e(TAG, "startSearch: " + e );
            }
        }, error -> {
            Log.e(TAG, "startSearch: " +error);
            try {
                resultsStartSwipe.setRefreshing(false);
                if (error instanceof NoConnectionError) {
                    Snackbar.make(getActivity().findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.no_internet), Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(getActivity().findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_results), Snackbar.LENGTH_LONG).show();
                }
                resultsLayout.setVisibility(View.GONE);
                searchLayout.setVisibility(View.VISIBLE);
            } catch (NullPointerException e) {
                Log.e(TAG, "startSearch: " + e);
            }
        });
        int socketTimeout = 60000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        request.setRetryPolicy(policy);
        requestQueue.add(request);
    }

    private ArrayList<ResultsStartItem> parseResults(JSONObject response, boolean firstLoad) {
        ArrayList<ResultsStartItem> listItems = new ArrayList<>();
        if (response != null && response.length() > 0) {
            try {
                if (response.has("TotalNoOfResults") && !response.isNull("TotalNoOfResults")) {
                    resultsNumber.setText(String.format("%s %s", getText(R.string.total_result), response.getString("TotalNoOfResults")));
                } else {
                    resultsNumber.setVisibility(View.GONE);
                }
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
                            listItems.add(item);
                        }
                    }
                } else {
                    try {
                        if (firstLoad) {
                            Snackbar.make(getActivity().findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_results), Snackbar.LENGTH_LONG).show();
                            resultsLayout.setVisibility(View.GONE);
                            searchLayout.setVisibility(View.VISIBLE);
                        } else {
                            resultsStartSwipe.setRefreshing(false);
                        }
                    } catch (NullPointerException e) {
                        Log.e(TAG, "parseResults: " + e);
                    }
                }
            } catch (JSONException | NullPointerException | IllegalStateException e) {
                try {
                    Snackbar.make(getActivity().findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_results), Snackbar.LENGTH_LONG).show();
                    resultsLayout.setVisibility(View.GONE);
                    searchLayout.setVisibility(View.VISIBLE);
                } catch (NullPointerException ex) {
                    Log.e(TAG, "parseResults: " + e);
                }
            }
        }
        return listItems;
    }

    public void loadMore() {
        if (!nextPage.isEmpty()) {
            resultsStartSwipe.setRefreshing(true);
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, nextPage, response -> {
                try {
                    ArrayList<ResultsStartItem> resultsStartListMore = parseResults(response, false);
                    resultsStartSwipe.setRefreshing(false);
                    resultsStartList.remove(resultsStartList.size() - 1);
                    resultsStartAdapter.notifyItemRemoved(resultsStartList.size());
                    for (int i = 0; i < resultsStartListMore.size(); i++) {
                        ResultsStartItem result = resultsStartListMore.get(i);
                        resultsStartList.add(result);
                        resultsStartAdapter.notifyItemInserted(resultsStartList.size());
                    }
                    if (!nextPage.isEmpty()) {
                        resultsStartList.add(null);
                        resultsStartAdapter.notifyItemInserted(resultsStartList.size());
                    }
                } catch (NullPointerException e) {
                    Log.e(TAG, "onResponse: " + e );
                }
            }, error -> {
                try {
                    resultsStartSwipe.setRefreshing(false);
                    resultsStartList.remove(resultsStartList.size() - 1);
                    resultsStartAdapter.notifyItemRemoved(resultsStartList.size());
                    resultsStartList.add(null);
                    resultsStartAdapter.notifyItemInserted(resultsStartList.size());
                } catch (NullPointerException e) {
                    Log.e(TAG, "loadMore: " + e );
                }
            });
            int socketTimeout = 60000;
            RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            request.setRetryPolicy(policy);
            requestQueue.add(request);
        }
    }
}
