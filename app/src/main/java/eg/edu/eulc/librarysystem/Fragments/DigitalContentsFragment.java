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
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eg.edu.eulc.librarysystem.CustomRequest;
import eg.edu.eulc.librarysystem.FragmentsDialogs.ResultsStartAdapter;
import eg.edu.eulc.librarysystem.MyApplication;
import eg.edu.eulc.librarysystem.Objects.ResultsStartItem;
import eg.edu.eulc.librarysystem.R;
import eg.edu.eulc.librarysystem.VolleySingleton;

/**
 * Created by Eslam El-Meniawy on 01-Nov-15.
 */
public class DigitalContentsFragment extends Fragment {
    private int itemType = 0, keywords1 = 0, keywords2 = 0, keywords3 = 0, conc1 = 0, conc2 = 0, wordProcessing = 0, orderBy = 0;
    private String[] itemTypes = {"", "24.2.1.", "24.2.10.", "24.2.11.", "24.2.12.", "24.2.13.", "24.2.14.", "24.2.15.", "24.2.16.", "24.2.17.", "24.2.18.", "24.2.19.", "24.2.2.", "24.2.20.", "24.2.21.", "24.2.22.", "24.2.23.", "24.2.24.", "24.2.25.", "24.2.26.", "24.2.27.", "24.2.28.", "24.2.29.", "24.2.3.", "24.2.5.", "24.2.6.", "24.2.7.", "24.2.8.", "24.2.9."},
            keywords = {"1.", "0.", "2.", "3.", "9.", "6.", "7.", "8.", "5."}, concs = {"and", "or", "and not"},
            wordProcess = {"", "INFLECTIONAL", "THESAURUS"}, orders = {"", "Title", "Author", "publishYear asc", "publishYear desc"};
    private EditText searchTextET1, searchTextET2, searchTextET3, attachContainsET, bibIDET, publishYearET;
    private String searchText1, searchText2, searchText3, attachContains, bibID, publishYear, nextPage = "";
    private LinearLayout resultsLayout;
    private ScrollView searchLayout;
    private SwipeRefreshLayout resultsSwipe;
    private RecyclerView resultsRecycler;
    private ArrayList<ResultsStartItem> resultsList = new ArrayList<>();
    private ResultsStartAdapter resultsAdapter;
    private RequestQueue requestQueue;
    private LinearLayoutManager linearLayoutManager;
    private TextView resultsNumber;

    public DigitalContentsFragment() {
    }

    public static void hide_keyboard_from(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_digital_contents, container, false);

        Spinner itemTypeSpinner = (Spinner) rootView.findViewById(R.id.theses_search_type);
        Spinner keywordsSpinner1 = (Spinner) rootView.findViewById(R.id.keyword1);
        Spinner keywordsSpinner2 = (Spinner) rootView.findViewById(R.id.keyword2);
        Spinner keywordsSpinner3 = (Spinner) rootView.findViewById(R.id.keyword3);
        Spinner concSpinner1 = (Spinner) rootView.findViewById(R.id.conc1);
        Spinner concSpinner2 = (Spinner) rootView.findViewById(R.id.conc2);
        Spinner wordProcessingSpinner = (Spinner) rootView.findViewById(R.id.WordProcessingSpinner);
        Spinner orderBySpinner = (Spinner) rootView.findViewById(R.id.OrderBySpinner);
        searchTextET1 = (EditText) rootView.findViewById(R.id.SearchText1);
        searchTextET2 = (EditText) rootView.findViewById(R.id.SearchText2);
        searchTextET3 = (EditText) rootView.findViewById(R.id.SearchText3);
        attachContainsET = (EditText) rootView.findViewById(R.id.attach_contains);
        bibIDET = (EditText) rootView.findViewById(R.id.BibID);
        publishYearET = (EditText) rootView.findViewById(R.id.Publishyear);
        Button searchButton = (Button) rootView.findViewById(R.id.searchButton);
        searchLayout = (ScrollView) rootView.findViewById(R.id.searchLayout);
        resultsLayout = (LinearLayout) rootView.findViewById(R.id.resultsLayout);
        resultsRecycler = (RecyclerView) rootView.findViewById(R.id.ResultsDigitalContent);
        resultsSwipe = (SwipeRefreshLayout) rootView.findViewById(R.id.ResultsDigitalContentSwipeRefresh);
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

        bibIDET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hide_keyboard_from(getActivity(), bibIDET);
                }
            }
        });

        publishYearET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hide_keyboard_from(getActivity(), publishYearET);
                }
            }
        });

        attachContainsET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hide_keyboard_from(getActivity(), attachContainsET);
                }
            }
        });

        VolleySingleton volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(), R.array.holdings_item_types, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getContext(), R.array.keywords, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getContext(), R.array.concs, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(getContext(), R.array.word_processing_list, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(getContext(), R.array.order_by_list, android.R.layout.simple_spinner_item);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        itemTypeSpinner.setAdapter(adapter1);
        itemTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemType = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        keywordsSpinner1.setAdapter(adapter2);
        keywordsSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                keywords1 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        keywordsSpinner2.setAdapter(adapter2);
        keywordsSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                keywords2 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        keywordsSpinner3.setAdapter(adapter2);
        keywordsSpinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                keywords3 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        concSpinner1.setAdapter(adapter3);
        concSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                conc1 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        concSpinner2.setAdapter(adapter3);
        concSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                conc2 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        wordProcessingSpinner.setAdapter(adapter4);
        wordProcessingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                wordProcessing = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        orderBySpinner.setAdapter(adapter5);
        orderBySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                orderBy = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchText1 = searchTextET1.getText().toString();

                bibID = bibIDET.getText().toString();
                if (bibID == null) {
                    bibID = "";
                }

                publishYear = publishYearET.getText().toString();
                if (publishYear == null) {
                    publishYear = "";
                }

                searchText2 = searchTextET2.getText().toString();
                if (searchText2 == null) {
                    searchText2 = "";
                }
                searchText3 = searchTextET3.getText().toString();
                if (searchText3 == null) {
                    searchText3 = "";
                }
                attachContains = attachContainsET.getText().toString();
                if (attachContains == null) {
                    attachContains = "";
                }

                if ((searchText1.equals("") || searchText1 == null) && (bibID.equals("") || bibID == null)) {
                    Snackbar.make(v, getResources().getText(R.string.enter_text), Snackbar.LENGTH_LONG).show();
                } else if ((!(bibID.equals("") || bibID == null)) || (!(publishYear.equals("") || publishYear == null))) {
                    String BIB_PATTERN = "\\b\\d{1,9}-\\d{1,9}|\\d{1,9}\\b";
                    String YEAR_PATTERN = "\\b((19|20)\\d{2}[-](19|20)\\d{2})|(19|20)\\d{2}\\b";
                    Pattern patternBib = Pattern.compile(BIB_PATTERN);
                    Pattern patternYear = Pattern.compile(YEAR_PATTERN);
                    Matcher matcherBib = patternBib.matcher(bibID);
                    Matcher matcherYear = patternYear.matcher(publishYear);
                    if ((!(bibID.equals("") || bibID == null)) && (!(publishYear.equals("") || publishYear == null))) {
                        boolean bibOK, yearOK;
                        if (!matcherBib.matches()) {
                            bibOK = false;
                            bibIDET.setError(getText(R.string.bib_id_error));
                        } else {
                            bibOK = true;
                        }
                        if (!matcherYear.matches()) {
                            yearOK = false;
                            publishYearET.setError(getText(R.string.pub_year_error));
                        } else {
                            yearOK = true;
                        }
                        if (bibOK && yearOK) {
                            completeSearch();
                        }
                    } else if (!(bibID.equals("") || bibID == null)) {
                        if (!matcherBib.matches()) {
                            bibIDET.setError(getText(R.string.bib_id_error));
                        } else {
                            completeSearch();
                        }
                    } else if (!(publishYear.equals("") || publishYear == null)) {
                        if (!matcherYear.matches()) {
                            publishYearET.setError(getText(R.string.pub_year_error));
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
        return resultsLayout.getVisibility() == View.VISIBLE;
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
        resultsAdapter = new ResultsStartAdapter(getActivity(), DigitalContentsFragment.this);
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

    private void startSearch() {
        nextPage = "";
        Map<String, String> params = new HashMap<String, String>();
        params.put("ScopeID", ((MyApplication) getActivity().getApplication()).getScopeID());
        params.put("fn", "DLibApplySearch");
        params.put("SearchIdForm", "");
        params.put("ScopeIDSelect", "1.");
        params.put("ItemType", itemTypes[itemType]);
        params.put("SearchText1", searchText1);
        params.put("criteria1", keywords[keywords1]);
        params.put("opr1", concs[conc1]);
        params.put("SearchText2", searchText2);
        params.put("criteria2", keywords[keywords2]);
        params.put("opr2", concs[conc2]);
        params.put("SearchText3", searchText3);
        params.put("criteria3", keywords[keywords3]);
        params.put("SearchTextFT", attachContains);
        params.put("Generation_Term", wordProcess[wordProcessing]);
        params.put("BibID", bibID);
        params.put("PublishYear", publishYear);
        params.put("OrderKey", orders[orderBy]);
        CustomRequest request = new CustomRequest(Request.Method.POST, ((MyApplication) getActivity().getApplication()).getServerName() + "libraries/fuapi.aspx?fn=ApplyMobileSearch&Dlib=True", params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
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
                        Snackbar.make(getActivity().findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.no_internet), Snackbar.LENGTH_LONG).show();
                    } else {
                        Snackbar.make(getActivity().findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_results), Snackbar.LENGTH_LONG).show();
                    }
                    resultsLayout.setVisibility(View.GONE);
                    searchLayout.setVisibility(View.VISIBLE);
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
                    try {
                        if (firstLoad) {
                            Snackbar.make(getActivity().findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_results), Snackbar.LENGTH_LONG).show();
                            resultsLayout.setVisibility(View.GONE);
                            searchLayout.setVisibility(View.VISIBLE);
                        } else {
                            resultsSwipe.setRefreshing(false);
                        }
                    } catch (NullPointerException e) {
                    }
                }
            } catch (JSONException e) {
                try {
                    Snackbar.make(getActivity().findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_results), Snackbar.LENGTH_LONG).show();
                    resultsLayout.setVisibility(View.GONE);
                    searchLayout.setVisibility(View.VISIBLE);
                } catch (NullPointerException ex) {
                }
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
