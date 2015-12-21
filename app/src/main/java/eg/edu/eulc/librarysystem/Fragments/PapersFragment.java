package eg.edu.eulc.librarysystem.Fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

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

import eg.edu.eulc.librarysystem.FragmentsDialogs.ResultsStartAdapter;
import eg.edu.eulc.librarysystem.Objects.ResultsStartItem;
import eg.edu.eulc.librarysystem.R;
import eg.edu.eulc.librarysystem.VolleySingleton;

/**
 * Created by Eslam El-Meniawy on 01-Nov-15.
 */
public class PapersFragment extends Fragment {
    private int getPage = 1;
    private EditText paperTitleET, authorsET, keywordsET, paperAbstractET, authorNationalIDET, authorIDET;
    private String paperTitle, authors, keywords, paperAbstract, authorNationalID, authorID;
    private boolean hasAttach = false;
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

    public PapersFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_papers, container, false);

        paperTitleET = (EditText) rootView.findViewById(R.id.PaperTitle);
        authorsET = (EditText) rootView.findViewById(R.id.Authors);
        keywordsET = (EditText) rootView.findViewById(R.id.Keywords);
        paperAbstractET = (EditText) rootView.findViewById(R.id.Abstract);
        authorNationalIDET = (EditText) rootView.findViewById(R.id.AuthorNationalID);
        authorIDET = (EditText) rootView.findViewById(R.id.AuthorID);
        SwitchCompat hasAttachments = (SwitchCompat) rootView.findViewById(R.id.HasAttachments);
        Button searchButton = (Button) rootView.findViewById(R.id.searchButton);
        searchLayout = (ScrollView) rootView.findViewById(R.id.searchLayout);
        resultsLayout = (LinearLayout) rootView.findViewById(R.id.resultsLayout);
        resultsRecycler = (RecyclerView) rootView.findViewById(R.id.ResultsInternetSearch);
        resultsSwipe = (SwipeRefreshLayout) rootView.findViewById(R.id.ResultsInternetSearchSwipeRefresh);

        VolleySingleton volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();

        hasAttachments.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                hasAttach = isChecked;
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String paperTitle = paperTitleET.getText().toString();
                String authors = authorsET.getText().toString();
                String keywords = keywordsET.getText().toString();
                String paperAbstract = paperAbstractET.getText().toString();
                String authorNationalID = authorNationalIDET.getText().toString();
                String authorID = authorIDET.getText().toString();
                if ((paperTitle.equals("") || paperTitle == null) && (authors.equals("") || authors == null) && (keywords.equals("") || keywords == null) && (paperAbstract.equals("") || paperAbstract == null) && (authorNationalID.equals("") || authorNationalID == null) && (authorID.equals("") || authorID == null)) {
                    Snackbar.make(v, getResources().getText(R.string.enter_text), Snackbar.LENGTH_LONG).show();
                } else {
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
                                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, "http://192.168.0.101:1234/librarySystem/startSearch.json?SearchText1=" + Uri.encode(paperTitle) + "&page=" + getPage, new Response.Listener<JSONObject>() {
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

    private void startSearch() {
        getPage = 1;
        mPreviousTotal = 0;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, "http://192.168.0.101:1234/librarySystem/startSearch.json?SearchText1=" + Uri.encode(paperTitle) + "&page=1", new Response.Listener<JSONObject>() {
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
