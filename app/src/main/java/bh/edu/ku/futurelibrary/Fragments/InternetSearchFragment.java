package bh.edu.ku.futurelibrary.Fragments;

import android.app.Activity;
import android.content.Context;
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
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import bh.edu.ku.futurelibrary.CustomRequest;
import bh.edu.ku.futurelibrary.FragmentsDialogs.ResultsStartAdapter;
import bh.edu.ku.futurelibrary.Objects.ResultsStartItem;
import bh.edu.ku.futurelibrary.VolleySingleton;
import bh.edu.ku.futurelibrary.R;

/**
 * Created by Eslam El-Meniawy on 01-Nov-15.
 */
public class InternetSearchFragment extends Fragment {
    public  static final String TAG = "InternetSearchFragment";
    private int searchIn1 = 0, searchIn2 = 0, searchIn3 = 0, conc1 = 0, conc2 = 0;
    private final String[] searchIn = {"bath.isbn", "bath.title", "dc.creator", "dc.subject", "bath.keyTitle", "bath.issn"};
    private final String[] concs = {"and", "or", "not"};
    private EditText searchTextET1, searchTextET2, searchTextET3;
    private String searchText1, searchText2, searchText3, nextPage = "";
    private LinearLayout resultsLayout;
    private ScrollView searchLayout;
    private SwipeRefreshLayout resultsSwipe;
    private RecyclerView resultsRecycler;
    private ArrayList<ResultsStartItem> resultsList = new ArrayList<>();
    private ResultsStartAdapter resultsAdapter;
    private RequestQueue requestQueue;
    private LinearLayoutManager linearLayoutManager;
    private TextView resultsNumber;

    public InternetSearchFragment() {
    }

    public static void hide_keyboard_from(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_internet_search, container, false);

        Spinner searchInSpinner1 = rootView.findViewById(R.id.searchin1);
        Spinner searchInSpinner2 = rootView.findViewById(R.id.searchin2);
        Spinner searchInSpinner3 = rootView.findViewById(R.id.searchin3);
        Spinner concSpinner1 = rootView.findViewById(R.id.conc1);
        Spinner concSpinner2 = rootView.findViewById(R.id.conc2);
        searchTextET1 = rootView.findViewById(R.id.SearchText1);
        searchTextET2 = rootView.findViewById(R.id.SearchText2);
        searchTextET3 = rootView.findViewById(R.id.SearchText3);
        Button searchButton = rootView.findViewById(R.id.searchButton);
        searchLayout = rootView.findViewById(R.id.searchLayout);
        resultsLayout = rootView.findViewById(R.id.resultsLayout);
        resultsRecycler = rootView.findViewById(R.id.ResultsInternetSearch);
        resultsSwipe = rootView.findViewById(R.id.ResultsInternetSearchSwipeRefresh);
        resultsNumber = rootView.findViewById(R.id.ResultsNumber);

        searchTextET1.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                hide_keyboard_from(getActivity(), searchTextET1);
            }
        });

        searchTextET2.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                hide_keyboard_from(getActivity(), searchTextET2);
            }
        });

        searchTextET3.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                hide_keyboard_from(getActivity(), searchTextET3);
            }
        });

        VolleySingleton volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(), R.array.search_in_list, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getContext(), R.array.concs, android.R.layout.simple_spinner_item);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        searchInSpinner1.setAdapter(adapter1);
        searchInSpinner1.setSelection(1);
        searchInSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                searchIn1 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        searchInSpinner2.setAdapter(adapter1);
        searchInSpinner2.setSelection(1);
        searchInSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                searchIn2 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        searchInSpinner3.setAdapter(adapter1);
        searchInSpinner3.setSelection(1);
        searchInSpinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                searchIn3 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        concSpinner1.setAdapter(adapter2);
        concSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                conc1 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        concSpinner2.setAdapter(adapter2);
        concSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                conc2 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        searchButton.setOnClickListener(v -> {
            searchText1 = searchTextET1.getText().toString();

            searchText2 = searchTextET2.getText().toString();
            searchText3 = searchTextET3.getText().toString();
            if (searchText1 == null || searchText1.isEmpty()) {
                searchTextET1.setError(getText(R.string.enter_text));
            } else {
                searchLayout.setVisibility(View.GONE);
                resultsLayout.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(getActivity());
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsStartAdapter(getActivity(), InternetSearchFragment.this);
                resultsSwipe.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent);
                resultsSwipe.setOnRefreshListener(() -> resultsSwipe.setRefreshing(false));
                resultsRecycler.setAdapter(resultsAdapter);
                resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                resultsSwipe.setRefreshing(true);
                startSearch();
            }
        });

        return rootView;
    }

    public boolean getLayoutVisibility() {
        return resultsLayout.getVisibility() == View.VISIBLE;
    }

    public void showSearch() {
        resultsLayout.setVisibility(View.GONE);
        searchLayout.setVisibility(View.VISIBLE);
    }

    private void startSearch() {
        nextPage = "";
        Map<String, String> params = new HashMap<>();
        params.put("SearchText1", searchText1);
        params.put("criteria1", searchIn[searchIn1]);
        params.put("opr1", concs[conc1]);
        params.put("SearchText2", searchText2);
        params.put("criteria2", searchIn[searchIn2]);
        params.put("opr2", concs[conc2]);
        params.put("SearchText3", searchText3);
        params.put("criteria3", searchIn[searchIn3]);
        //TODO change url
        CustomRequest request = new CustomRequest(Request.Method.POST, "http://192.168.200.217:3000/librarySystem/startSearch", params, response -> {
            try {
                resultsList = parseResults(response, true);
                if (!nextPage.isEmpty()) {
                    resultsList.add(null);
                }
                resultsAdapter.setResultsStartItems(resultsList);
                resultsRecycler.setVisibility(View.VISIBLE);
                resultsSwipe.setRefreshing(false);
            } catch (NullPointerException e) {
                Log.e(TAG, "startSearch: " + e);
            }
        }, error -> {
            try {
                resultsSwipe.setRefreshing(false);
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
                            resultsSwipe.setRefreshing(false);
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
            requestQueue.add(request);
        }
    }
}
