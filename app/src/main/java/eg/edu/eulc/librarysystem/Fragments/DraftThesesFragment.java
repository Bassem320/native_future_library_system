package eg.edu.eulc.librarysystem.Fragments;

import android.net.Uri;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eg.edu.eulc.librarysystem.FragmentsDialogs.ResultsStartAdapter;
import eg.edu.eulc.librarysystem.Objects.ResultsStartItem;
import eg.edu.eulc.librarysystem.R;
import eg.edu.eulc.librarysystem.VolleySingleton;

/**
 * Created by Eslam El-Meniawy on 01-Nov-15.
 */
public class DraftThesesFragment extends Fragment {
    Spinner subSpecialitySpinner;
    private int searchin1 = 0, searchin2 = 0, searchin3 = 0, conc1 = 0, conc2 = 0, speciality = 0, subSpeciality = 0, degree = 0, getPage = 1;
    private EditText searchTextET1, searchTextET2, searchTextET3, dateFromET, dateToET, draftThesesIDET;
    private String searchText1, searchText2, searchText3, dateFrom, dateTo, draftThesesID;
    private LinearLayout resultsLayout;
    private ScrollView searchLayout;
    private SwipeRefreshLayout resultsSwipe;
    private RecyclerView resultsRecycler;
    private ArrayList<ResultsStartItem> resultsList = new ArrayList<>();
    private ResultsStartAdapter resultsAdapter;
    private RequestQueue requestQueue;
    private LinearLayoutManager linearLayoutManager;
    private boolean mLoadingItems = true;
    private int mOnScreenItems, mTotalItemsInList, mFirstVisibleItem, mPreviousTotal = 0, mVisibleThreshold = 1;

    public DraftThesesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_draft_theses, container, false);

        Spinner searchinSpinner1 = (Spinner) rootView.findViewById(R.id.searchin1);
        Spinner searchinSpinner2 = (Spinner) rootView.findViewById(R.id.searchin2);
        Spinner searchinSpinner3 = (Spinner) rootView.findViewById(R.id.searchin3);
        Spinner concSpinner1 = (Spinner) rootView.findViewById(R.id.conc1);
        Spinner concSpinner2 = (Spinner) rootView.findViewById(R.id.conc2);
        Spinner specialitySpinner = (Spinner) rootView.findViewById(R.id.SpecialitySpinner);
        subSpecialitySpinner = (Spinner) rootView.findViewById(R.id.SubSpecialitySpinner);
        Spinner degreeSpinner = (Spinner) rootView.findViewById(R.id.DegreeSpinner);
        searchTextET1 = (EditText) rootView.findViewById(R.id.SearchText1);
        searchTextET2 = (EditText) rootView.findViewById(R.id.SearchText2);
        searchTextET3 = (EditText) rootView.findViewById(R.id.SearchText3);
        dateFromET = (EditText) rootView.findViewById(R.id.date_from);
        dateToET = (EditText) rootView.findViewById(R.id.date_to);
        draftThesesIDET = (EditText) rootView.findViewById(R.id.DraftTheses_ID);
        Button searchButton = (Button) rootView.findViewById(R.id.searchButton);
        searchLayout = (ScrollView) rootView.findViewById(R.id.searchLayout);
        resultsLayout = (LinearLayout) rootView.findViewById(R.id.resultsLayout);
        resultsRecycler = (RecyclerView) rootView.findViewById(R.id.ResultsDraftTheses);
        resultsSwipe = (SwipeRefreshLayout) rootView.findViewById(R.id.ResultsDraftThesesSwipeRefresh);

        VolleySingleton volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_search_in, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getContext(), R.array.concs, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_specialities, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(getContext(), R.array.degrees, android.R.layout.simple_spinner_item);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        searchinSpinner1.setAdapter(adapter1);
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

        specialitySpinner.setAdapter(adapter3);
        specialitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                speciality = position;
                subSpeciality = 0;
                ArrayAdapter<CharSequence> adapter;
                switch (position) {
                    case 0:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_0, android.R.layout.simple_spinner_item);
                        break;
                    case 1:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_1, android.R.layout.simple_spinner_item);
                        break;
                    case 2:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_2, android.R.layout.simple_spinner_item);
                        break;
                    case 3:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_3, android.R.layout.simple_spinner_item);
                        break;
                    case 4:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_4, android.R.layout.simple_spinner_item);
                        break;
                    case 5:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_5, android.R.layout.simple_spinner_item);
                        break;
                    case 6:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_6, android.R.layout.simple_spinner_item);
                        break;
                    case 7:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_7, android.R.layout.simple_spinner_item);
                        break;
                    case 8:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_8, android.R.layout.simple_spinner_item);
                        break;
                    case 9:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_9, android.R.layout.simple_spinner_item);
                        break;
                    case 10:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_10, android.R.layout.simple_spinner_item);
                        break;
                    case 11:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_11, android.R.layout.simple_spinner_item);
                        break;
                    case 12:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_12, android.R.layout.simple_spinner_item);
                        break;
                    case 13:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_13, android.R.layout.simple_spinner_item);
                        break;
                    case 14:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_14, android.R.layout.simple_spinner_item);
                        break;
                    case 15:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_15, android.R.layout.simple_spinner_item);
                        break;
                    case 16:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_16, android.R.layout.simple_spinner_item);
                        break;
                    case 17:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_17, android.R.layout.simple_spinner_item);
                        break;
                    case 18:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_18, android.R.layout.simple_spinner_item);
                        break;
                    case 19:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_19, android.R.layout.simple_spinner_item);
                        break;
                    case 20:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_20, android.R.layout.simple_spinner_item);
                        break;
                    case 21:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_21, android.R.layout.simple_spinner_item);
                        break;
                    case 22:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_22, android.R.layout.simple_spinner_item);
                        break;
                    case 23:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_23, android.R.layout.simple_spinner_item);
                        break;
                    case 24:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_24, android.R.layout.simple_spinner_item);
                        break;
                    case 25:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_25, android.R.layout.simple_spinner_item);
                        break;
                    case 26:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_26, android.R.layout.simple_spinner_item);
                        break;
                    case 27:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_27, android.R.layout.simple_spinner_item);
                        break;
                    case 28:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_28, android.R.layout.simple_spinner_item);
                        break;
                    case 29:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_29, android.R.layout.simple_spinner_item);
                        break;
                    default:
                        adapter = ArrayAdapter.createFromResource(getContext(), R.array.draft_theses_sub_specialities_0, android.R.layout.simple_spinner_item);
                        break;
                }
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                subSpecialitySpinner.setAdapter(adapter);
                subSpecialitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        subSpeciality = position;
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        degreeSpinner.setAdapter(adapter4);
        degreeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                degree = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchText1 = searchTextET1.getText().toString();
                dateFrom = dateFromET.getText().toString();
                dateTo = dateToET.getText().toString();

                searchText2 = searchTextET2.getText().toString();
                if (searchText2 == null) {
                    searchText2 = "";
                }
                searchText3 = searchTextET3.getText().toString();
                if (searchText3 == null) {
                    searchText3 = "";
                }
                draftThesesID = draftThesesIDET.getText().toString();
                if (draftThesesID == null) {
                    draftThesesID = "";
                }

                if (searchText1.equals("") || searchText1 == null) {
                    searchTextET1.setError(getText(R.string.enter_text));
                } else if ((!(dateFrom.equals("") || dateFrom == null)) || (!(dateTo.equals("") || dateTo == null))) {
                    String DATE_PATTERN = "^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d{2}$";
                    Pattern patternDate = Pattern.compile(DATE_PATTERN);
                    Matcher matcherDateFrom = patternDate.matcher(dateFrom);
                    Matcher matcherDateTo = patternDate.matcher(dateTo);
                    if ((!(dateFrom.equals("") || dateFrom == null)) && (!(dateTo.equals("") || dateTo == null))) {
                        boolean fromOK, toOK;
                        if (!matcherDateFrom.matches()) {
                            fromOK = false;
                            dateFromET.setError(getText(R.string.date_error));
                        } else {
                            fromOK = true;
                        }
                        if (!matcherDateTo.matches()) {
                            toOK = false;
                            dateToET.setError(getText(R.string.date_error));
                        } else {
                            toOK = true;
                        }
                        if (fromOK && toOK) {
                            completeSearch();
                        }
                    } else if (!(dateFrom.equals("") || dateFrom == null)) {
                        if (!matcherDateFrom.matches()) {
                            dateFromET.setError(getText(R.string.date_error));
                        } else {
                            completeSearch();
                        }
                    } else if (!(dateTo.equals("") || dateTo == null)) {
                        if (!matcherDateTo.matches()) {
                            dateToET.setError(getText(R.string.date_error));
                        } else {
                            completeSearch();
                        }
                    }
                } else {
                    completeSearch();
                }
            }
        });

        return rootView;
    }

    public boolean getLayoutVisibility() {
        if (resultsLayout.getVisibility() == View.VISIBLE) {
            return true;
        }
        return false;
    }

    public void showSearch() {
        resultsLayout.setVisibility(View.GONE);
        searchLayout.setVisibility(View.VISIBLE);
    }

    private void completeSearch() {
        searchLayout.setVisibility(View.GONE);
        resultsLayout.setVisibility(View.VISIBLE);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        resultsRecycler.setLayoutManager(linearLayoutManager);
        resultsAdapter = new ResultsStartAdapter(getActivity());
        resultsSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                startSearch();
            }
        });
        resultsRecycler.setAdapter(resultsAdapter);
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
                    if (mTotalItemsInList > mPreviousTotal+1) {
                        mLoadingItems = false;
                        mPreviousTotal = mTotalItemsInList;
                    }
                }
                if (!mLoadingItems && (mTotalItemsInList - mOnScreenItems) <= (mFirstVisibleItem + mVisibleThreshold)) {
                    resultsSwipe.setRefreshing(true);
                    getPage ++;
                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, "http://192.168.0.101:1234/librarySystem/startSearch.json?SearchText1=" + Uri.encode(searchText1) + "&page=" + getPage, new Response.Listener<JSONObject>() {
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
                            getPage --;
                            resultsSwipe.setRefreshing(false);
                        }
                    });
                    requestQueue.add(request);
                    mLoadingItems = true;
                }
            }
        });
        resultsSwipe.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
        resultsSwipe.setRefreshing(true);
        startSearch();
    }

    private void startSearch() {
        getPage = 1;
        mPreviousTotal = 0;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, "http://192.168.0.101:1234/librarySystem/startSearch.json?SearchText1=" + Uri.encode(searchText1) + "&page=1", new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                resultsList = parseResults(response, true);
                resultsAdapter.setResultsStartItems(resultsList);
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
}
