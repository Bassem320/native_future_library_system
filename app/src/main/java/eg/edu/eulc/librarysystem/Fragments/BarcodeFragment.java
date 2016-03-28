package eg.edu.eulc.librarysystem.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import eg.edu.eulc.librarysystem.Activities.MainActivity;
import eg.edu.eulc.librarysystem.CustomRequest;
import eg.edu.eulc.librarysystem.FragmentsDialogs.ResultsStartAdapter;
import eg.edu.eulc.librarysystem.MyApplication;
import eg.edu.eulc.librarysystem.Objects.ResultsStartItem;
import eg.edu.eulc.librarysystem.R;
import eg.edu.eulc.librarysystem.VolleySingleton;

/**
 * Created by Eslam El-Meniawy on 21-Mar-16.
 */
@SuppressWarnings("DefaultFileTemplate")
public class BarcodeFragment extends Fragment {
    private View rootView;
    private LinearLayout resultsLayout;
    private FrameLayout searchLayout;
    private SwipeRefreshLayout resultsSwipe;
    private RecyclerView resultsRecycler;
    private ArrayList<ResultsStartItem> resultsList = new ArrayList<>();
    private ResultsStartAdapter resultsAdapter;
    private RequestQueue requestQueue;
    private TextView resultsNumber;
    private String nextPage = "";

    public BarcodeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_barcode, container, false);

        searchLayout = (FrameLayout) rootView.findViewById(R.id.searchLayout);
        resultsLayout = (LinearLayout) rootView.findViewById(R.id.resultsLayout);
        resultsRecycler = (RecyclerView) rootView.findViewById(R.id.ResultsBarcode);
        resultsSwipe = (SwipeRefreshLayout) rootView.findViewById(R.id.ResultsBarcodeSwipeRefresh);
        resultsNumber = (TextView) rootView.findViewById(R.id.ResultsNumber);

        Button scan = (Button) rootView.findViewById(R.id.scan);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanBarcode();
            }
        });

        VolleySingleton volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();

        scanBarcode();

        return rootView;
    }

    private void scanBarcode() {
        IntentIntegrator.forSupportFragment(this).initiateScan();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ((MainActivity) getActivity()).setConfig();
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Snackbar.make(rootView, getResources().getText(R.string.scan_canceled), Snackbar.LENGTH_LONG).show();
            } else {
                startSearch(result.getContents());
            }
        }
    }

    public boolean getLayoutVisibility() {
        return resultsLayout.getVisibility() == View.VISIBLE;
    }

    public void showSearch() {
        resultsLayout.setVisibility(View.GONE);
        searchLayout.setVisibility(View.VISIBLE);
    }

    private void startSearch(String isbn) {
        searchLayout.setVisibility(View.GONE);
        resultsLayout.setVisibility(View.VISIBLE);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        resultsRecycler.setLayoutManager(linearLayoutManager);
        resultsAdapter = new ResultsStartAdapter(getActivity(), BarcodeFragment.this);
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

        nextPage = "";

        Map<String, String> params = new HashMap<>();
        params.put("ScopeID", ((MyApplication) getActivity().getApplication()).getScopeID());
        params.put("fn", "ApplyMobileSearch");
        params.put("SearchText1", isbn);
        params.put("criteria1", "6.");

        CustomRequest request = new CustomRequest(Request.Method.POST, ((MyApplication) getActivity().getApplication()).getServerName() + "libraries/fuapi.aspx?fn=ApplyMobileSearch", params, new Response.Listener<JSONObject>() {
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
                } catch (NullPointerException ignored) {
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    resultsSwipe.setRefreshing(false);
                    if (error instanceof NoConnectionError) {
                        Snackbar.make(rootView, getResources().getText(R.string.no_internet), Snackbar.LENGTH_LONG).show();
                    } else {
                        Snackbar.make(rootView, getResources().getText(R.string.error_fetching_results), Snackbar.LENGTH_LONG).show();
                    }
                    resultsLayout.setVisibility(View.GONE);
                    searchLayout.setVisibility(View.VISIBLE);
                } catch (NullPointerException ignored) {
                }
            }
        });
        int socketTimeout = 60000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        request.setRetryPolicy(policy);
        requestQueue.add(request);
    }

    @SuppressLint("SetTextI18n")
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
                    } catch (NullPointerException ignored) {
                    }
                }
            } catch (JSONException | NullPointerException | IllegalStateException e) {
                try {
                    Snackbar.make(getActivity().findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_results), Snackbar.LENGTH_LONG).show();
                    resultsLayout.setVisibility(View.GONE);
                    searchLayout.setVisibility(View.VISIBLE);
                } catch (NullPointerException ignored) {
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
                    } catch (NullPointerException ignored) {
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
                    } catch (NullPointerException ignored) {
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
