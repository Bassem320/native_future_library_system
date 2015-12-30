package eg.edu.eulc.librarysystem.Fragments;

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
import eg.edu.eulc.librarysystem.FragmentsDialogs.ResultsPapersAdapter;
import eg.edu.eulc.librarysystem.Objects.PapersItem;
import eg.edu.eulc.librarysystem.R;
import eg.edu.eulc.librarysystem.VolleySingleton;

/**
 * Created by Eslam El-Meniawy on 01-Nov-15.
 */
public class PapersFragment extends Fragment {
    private EditText paperTitleET, authorsET, keywordsET, paperAbstractET, authorNationalIDET, authorIDET;
    private String paperTitle, authors, keywords, paperAbstract, authorNationalID, authorID, nextPage = "";
    private boolean hasAttach = false;
    private LinearLayout resultsLayout;
    private ScrollView searchLayout;
    private SwipeRefreshLayout resultsSwipe;
    private RecyclerView resultsRecycler;
    private ArrayList<PapersItem> resultsList = new ArrayList<>();
    private ResultsPapersAdapter resultsAdapter;
    private RequestQueue requestQueue;
    private LinearLayoutManager linearLayoutManager;
    private boolean mLoadingItems = true;
    private int mOnScreenItems, mTotalItemsInList, mFirstVisibleItem, mPreviousTotal = 0, mVisibleThreshold = 1;
    private TextView resultsNumber;

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
        resultsRecycler = (RecyclerView) rootView.findViewById(R.id.ResultsPapers);
        resultsSwipe = (SwipeRefreshLayout) rootView.findViewById(R.id.ResultsPapersSwipeRefresh);
        resultsNumber = (TextView) rootView.findViewById(R.id.ResultsNumber);

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
                paperTitle = paperTitleET.getText().toString();
                if (paperTitle == null) {
                    paperTitle = "";
                }

                authors = authorsET.getText().toString();
                if (authors == null) {
                    authors = "";
                }

                keywords = keywordsET.getText().toString();
                if (keywords == null) {
                    keywords = "";
                }

                paperAbstract = paperAbstractET.getText().toString();
                if (paperAbstract == null) {
                    paperAbstract = "";
                }

                authorNationalID = authorNationalIDET.getText().toString();
                if (authorNationalID == null) {
                    authorNationalID = "";
                }

                authorID = authorIDET.getText().toString();
                if (authorID == null) {
                    authorID = "";
                }

                if ((paperTitle.equals("") || paperTitle == null) && (authors.equals("") || authors == null) && (keywords.equals("") || keywords == null) && (paperAbstract.equals("") || paperAbstract == null) && (authorNationalID.equals("") || authorNationalID == null) && (authorID.equals("") || authorID == null)) {
                    Snackbar.make(v, getResources().getText(R.string.enter_text), Snackbar.LENGTH_LONG).show();
                } else {
                    searchLayout.setVisibility(View.GONE);
                    resultsLayout.setVisibility(View.VISIBLE);
                    linearLayoutManager = new LinearLayoutManager(getActivity());
                    resultsRecycler.setLayoutManager(linearLayoutManager);
                    resultsAdapter = new ResultsPapersAdapter(getActivity());
                    resultsSwipe.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent);
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
                                            ArrayList<PapersItem> resultsListMore = parseResults(response, false);
                                            resultsSwipe.setRefreshing(false);
                                            for (int i = 0; i < resultsListMore.size(); i++) {
                                                PapersItem result = resultsListMore.get(i);
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
                                    requestQueue.add(request);
                                    mLoadingItems = true;
                                }
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
        return resultsLayout.getVisibility() == View.VISIBLE;
    }

    public void showSearch() {
        resultsLayout.setVisibility(View.GONE);
        searchLayout.setVisibility(View.VISIBLE);
    }

    private void startSearch() {
        nextPage = "";
        mPreviousTotal = 0;
        Map<String, String> params = new HashMap<String, String>();
        params.put("ScopeIDSelect", "1.");
        params.put("PaperTitle", paperTitle);
        params.put("PaperAuthor", authors);
        params.put("PaperKeyword", keywords);
        params.put("IS_Abstract", paperAbstract);
        params.put("ResearchID", authorNationalID);
        params.put("BorrowerID", authorID);
        params.put("attach", hasAttach ? "1" : "0");
        CustomRequest request = new CustomRequest(Request.Method.POST, "http://www.eulc.edu.eg/demo/libraries/fuapi.aspx?fn=ApplaySearch4Serial", params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                resultsList = parseResults(response, true);
                resultsAdapter.setPapersItems(resultsList);
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

    private ArrayList<PapersItem> parseResults(JSONObject response, boolean firstLoad) {
        ArrayList<PapersItem> listItems = new ArrayList<>();
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
                        String id = "-1";
                        if (currentItem.has("id") && !currentItem.isNull("id")) {
                            id = currentItem.getString("id");
                        }
                        String title = "No Data Available";
                        if (currentItem.has("title") && !currentItem.isNull("title")) {
                            title = currentItem.getString("title");
                        }
                        String authors = "";
                        if (currentItem.has("authors") && !currentItem.isNull("authors")) {
                            JSONArray arrayAuthors = currentItem.getJSONArray("authors");
                            for (int j = 0; j < arrayAuthors.length(); j++) {
                                authors += arrayAuthors.getString(j);
                                if (j < (arrayAuthors.length() - 1)) {
                                    authors += "\n";
                                }
                            }
                        }
                        String volume = "";
                        if (currentItem.has("volume") && !currentItem.isNull("volume")) {
                            volume = currentItem.getString("volume");
                        }
                        String pages = "";
                        if (currentItem.has("pages") && !currentItem.isNull("pages")) {
                            pages = currentItem.getString("pages");
                        }
                        String publishedIn = "";
                        if (currentItem.has("publishedIn") && !currentItem.isNull("publishedIn")) {
                            publishedIn = currentItem.getString("publishedIn");
                        }
                        String publishedAt = "";
                        if (currentItem.has("publishedAt") && !currentItem.isNull("publishedAt")) {
                            publishedAt = currentItem.getString("publishedAt");
                        }
                        String serialName = "";
                        if (currentItem.has("serialName") && !currentItem.isNull("serialName")) {
                            serialName = currentItem.getString("serialName");
                        }
                        String abstractText = "";
                        if (currentItem.has("abstract") && !currentItem.isNull("abstract")) {
                            abstractText = currentItem.getString("abstract");
                        }
                        PapersItem item = new PapersItem();
                        item.setId(id);
                        item.setTitle(title);
                        item.setAuthors(authors);
                        item.setVolume(volume);
                        item.setPages(pages);
                        item.setPublishedIn(publishedIn);
                        item.setPublishedAt(publishedAt);
                        item.setSerialName(serialName);
                        item.setAbstractText(abstractText);
                        if (!id.equals("-1") && !title.equals("No Data Available")) {
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
