package eg.edu.eulc.librarysystem.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import eg.edu.eulc.librarysystem.CustomRequest;
import eg.edu.eulc.librarysystem.FragmentsDialogs.ResultsStartAdapter;
import eg.edu.eulc.librarysystem.MyApplication;
import eg.edu.eulc.librarysystem.Objects.ResultsStartItem;
import eg.edu.eulc.librarysystem.R;
import eg.edu.eulc.librarysystem.VolleySingleton;

/**
 * Created by Eslam El-Meniawy on 01-Nov-15.
 */
public class InternetSearchFragment extends Fragment {
    private int searchin1 = 0, searchin2 = 0, searchin3 = 0, conc1 = 0, conc2 = 0;
    private String[] searchIn = {"bath.isbn", "bath.title", "dc.creator", "dc.subject", "bath.keyTitle", "bath.issn"}, concs = {"and", "or", "not"};
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

        Spinner searchinSpinner1 = (Spinner) rootView.findViewById(R.id.searchin1);
        Spinner searchinSpinner2 = (Spinner) rootView.findViewById(R.id.searchin2);
        Spinner searchinSpinner3 = (Spinner) rootView.findViewById(R.id.searchin3);
        Spinner concSpinner1 = (Spinner) rootView.findViewById(R.id.conc1);
        Spinner concSpinner2 = (Spinner) rootView.findViewById(R.id.conc2);
        searchTextET1 = (EditText) rootView.findViewById(R.id.SearchText1);
        searchTextET2 = (EditText) rootView.findViewById(R.id.SearchText2);
        searchTextET3 = (EditText) rootView.findViewById(R.id.SearchText3);
        Button searchButton = (Button) rootView.findViewById(R.id.searchButton);
        searchLayout = (ScrollView) rootView.findViewById(R.id.searchLayout);
        resultsLayout = (LinearLayout) rootView.findViewById(R.id.resultsLayout);
        resultsRecycler = (RecyclerView) rootView.findViewById(R.id.ResultsInternetSearch);
        resultsSwipe = (SwipeRefreshLayout) rootView.findViewById(R.id.ResultsInternetSearchSwipeRefresh);
        resultsNumber = (TextView) rootView.findViewById(R.id.ResultsNumber);

        ImageView logo = (ImageView) rootView.findViewById(R.id.logo);
        logo.setImageResource(((MyApplication) getActivity().getApplication()).getLogo());

        searchTextET1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hide_keyboard_from(getActivity(), searchTextET1);
                }
            }
        });

        searchTextET2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hide_keyboard_from(getActivity(), searchTextET2);
                }
            }
        });

        searchTextET3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hide_keyboard_from(getActivity(), searchTextET3);
                }
            }
        });

        VolleySingleton volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(), R.array.search_in_list, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getContext(), R.array.concs, android.R.layout.simple_spinner_item);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        searchinSpinner1.setAdapter(adapter1);
        searchinSpinner1.setSelection(1);
        searchinSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                searchin1 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        searchinSpinner2.setAdapter(adapter1);
        searchinSpinner2.setSelection(1);
        searchinSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                searchin2 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        searchinSpinner3.setAdapter(adapter1);
        searchinSpinner3.setSelection(1);
        searchinSpinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                searchin3 = position;
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

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchText1 = searchTextET1.getText().toString();

                searchText2 = searchTextET2.getText().toString();
                if (searchText2 == null) {
                    searchText2 = "";
                }
                searchText3 = searchTextET3.getText().toString();
                if (searchText3 == null) {
                    searchText3 = "";
                }
                if (searchText1.equals("") || searchText1 == null) {
                    searchTextET1.setError(getText(R.string.enter_text));
                } else {
                    searchLayout.setVisibility(View.GONE);
                    resultsLayout.setVisibility(View.VISIBLE);
                    linearLayoutManager = new LinearLayoutManager(getActivity());
                    resultsRecycler.setLayoutManager(linearLayoutManager);
                    resultsAdapter = new ResultsStartAdapter(getActivity(), InternetSearchFragment.this);
                    resultsSwipe.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent);
                    resultsSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            resultsSwipe.setRefreshing(false);
                        }
                    });
                    resultsRecycler.setAdapter(resultsAdapter);
                    resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
                    resultsSwipe.setRefreshing(true);
                    startSearch();
                }
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
        Map<String, String> params = new HashMap<String, String>();
        params.put("SearchText1", searchText1);
        params.put("criteria1", searchIn[searchin1]);
        params.put("opr1", concs[conc1]);
        params.put("SearchText2", searchText2);
        params.put("criteria2", searchIn[searchin2]);
        params.put("opr2", concs[conc2]);
        params.put("SearchText3", searchText3);
        params.put("criteria3", searchIn[searchin3]);
        CustomRequest request = new CustomRequest(Request.Method.POST, "http://192.168.200.217:3000/librarySystem/startSearch", params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                resultsList = parseResults(response, true);
                if (!nextPage.equals("")) {
                    resultsList.add(null);
                }
                resultsAdapter.setResultsStartItems(resultsList);
                resultsRecycler.setVisibility(View.VISIBLE);
                resultsSwipe.setRefreshing(false);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                resultsSwipe.setRefreshing(false);
                if (error instanceof NoConnectionError) {
                    Snackbar.make(getActivity().findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.no_internet), Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(getActivity().findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_results), Snackbar.LENGTH_LONG).show();
                }
                resultsLayout.setVisibility(View.GONE);
                searchLayout.setVisibility(View.VISIBLE);
            }
        });
        requestQueue.add(request);
    }

    private ArrayList<ResultsStartItem> parseResults(JSONObject response, boolean firstLoad) {
        ArrayList<ResultsStartItem> listItems = new ArrayList<>();
        if (response != null && response.length() > 0) {
            try {
                if (response.has("TotalNoOfResults") && !response.isNull("TotalNoOfResults")) {
                    resultsNumber.setText(getText(R.string.total_result) + " " + response.getString("TotalNoOfResults"));
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
                            listItems.add(item);
                        }
                    }
                } else {
                    if (firstLoad) {
                        Snackbar.make(getActivity().findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_results), Snackbar.LENGTH_LONG).show();
                        resultsLayout.setVisibility(View.GONE);
                        searchLayout.setVisibility(View.VISIBLE);
                    } else {
                        resultsSwipe.setRefreshing(false);
                    }
                }
            } catch (JSONException e) {
                Snackbar.make(getActivity().findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_results), Snackbar.LENGTH_LONG).show();
                resultsLayout.setVisibility(View.GONE);
                searchLayout.setVisibility(View.VISIBLE);
            }
        }
        return listItems;
    }

    public void loadMore() {
        if (!nextPage.equals("")) {
            resultsSwipe.setRefreshing(true);
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, nextPage, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
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
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    resultsSwipe.setRefreshing(false);
                    resultsList.remove(resultsList.size() - 1);
                    resultsAdapter.notifyItemRemoved(resultsList.size());
                    resultsList.add(null);
                    resultsAdapter.notifyItemInserted(resultsList.size());
                }
            });
            requestQueue.add(request);
        }
    }
}
