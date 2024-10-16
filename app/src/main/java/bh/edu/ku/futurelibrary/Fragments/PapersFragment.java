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
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bh.edu.ku.futurelibrary.CustomRequest;
import bh.edu.ku.futurelibrary.FragmentsDialogs.ResultsPapersAdapter;
import bh.edu.ku.futurelibrary.MyApplication;
import bh.edu.ku.futurelibrary.Objects.PapersItem;
import bh.edu.ku.futurelibrary.VolleySingleton;
import bh.edu.ku.futurelibrary.R;

/**
 * Created by Eslam El-Meniawy on 01-Nov-15.
 */
public class PapersFragment extends Fragment {
    public static final String TAG = "PapersFragment";
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
    private TextView resultsNumber;

    public PapersFragment() {
    }

    public static void hide_keyboard_from(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_papers, container, false);

        paperTitleET = rootView.findViewById(R.id.PaperTitle);
        authorsET = rootView.findViewById(R.id.Authors);
        keywordsET = rootView.findViewById(R.id.Keywords);
        paperAbstractET = rootView.findViewById(R.id.Abstract);
        authorNationalIDET = rootView.findViewById(R.id.AuthorNationalID);
        authorIDET = rootView.findViewById(R.id.AuthorID);
        SwitchCompat hasAttachments = rootView.findViewById(R.id.HasAttachments);
        Button searchButton = rootView.findViewById(R.id.searchButton);
        searchLayout = rootView.findViewById(R.id.searchLayout);
        resultsLayout = rootView.findViewById(R.id.resultsLayout);
        resultsRecycler = rootView.findViewById(R.id.ResultsPapers);
        resultsSwipe = rootView.findViewById(R.id.ResultsPapersSwipeRefresh);
        resultsNumber = rootView.findViewById(R.id.ResultsNumber);

        paperTitleET.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                hide_keyboard_from(getActivity(), paperTitleET);
            }
        });

        authorsET.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                hide_keyboard_from(getActivity(), authorsET);
            }
        });

        keywordsET.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                hide_keyboard_from(getActivity(), keywordsET);
            }
        });

        paperAbstractET.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                hide_keyboard_from(getActivity(), paperAbstractET);
            }
        });

        authorNationalIDET.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                hide_keyboard_from(getActivity(), authorNationalIDET);
            }
        });

        authorIDET.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                hide_keyboard_from(getActivity(), authorIDET);
            }
        });

        VolleySingleton volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();

        hasAttachments.setOnCheckedChangeListener((buttonView, isChecked) -> hasAttach = isChecked);

        searchButton.setOnClickListener(v -> {
            paperTitle = paperTitleET.getText().toString();

            authors = authorsET.getText().toString();

            keywords = keywordsET.getText().toString();

            paperAbstract = paperAbstractET.getText().toString();

            authorNationalID = authorNationalIDET.getText().toString();

            authorID = authorIDET.getText().toString();

            String NAT_ID_PATTERN = "(2|3)[0-9][1-9][0-1][1-9][0-3][1-9](01|02|03|04|11|12|13|14|15|16|17|18|19|21|22|23|24|25|26|27|28|29|31|32|33|34|35|88)\\d\\d\\d\\d\\d";
            Pattern patternNatId = Pattern.compile(NAT_ID_PATTERN);
            Matcher matcherNatId = patternNatId.matcher(authorNationalID);

            if ((paperTitle == null || paperTitle.isEmpty()) && (authors == null || authors.isEmpty()) && (keywords == null || keywords.isEmpty()) && (paperAbstract == null || paperAbstract.isEmpty()) && (authorNationalID == null || authorNationalID.isEmpty()) && (authorID == null || authorID.isEmpty())) {
                Snackbar.make(v, getResources().getText(R.string.enter_text), Snackbar.LENGTH_LONG).show();
            } else if (authorNationalID != null && !authorNationalID.isEmpty() && !matcherNatId.matches()) {
                authorNationalIDET.setError(getText(R.string.national_id_error));
            } else {
                searchLayout.setVisibility(View.GONE);
                resultsLayout.setVisibility(View.VISIBLE);
                linearLayoutManager = new LinearLayoutManager(getActivity());
                resultsRecycler.setLayoutManager(linearLayoutManager);
                resultsAdapter = new ResultsPapersAdapter(getActivity(), PapersFragment.this);
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
        params.put("ScopeIDSelect", ((MyApplication) getActivity().getApplication()).getScopeID());
        params.put("PaperTitle", paperTitle);
        params.put("PaperAuthor", authors);
        params.put("PaperKeyword", keywords);
        params.put("IS_Abstract", paperAbstract);
        params.put("ResearchID", authorNationalID);
        params.put("BorrowerID", authorID);
        params.put("attach", hasAttach ? "1" : "0");
        CustomRequest request = new CustomRequest(Request.Method.POST, ((MyApplication) getActivity().getApplication()).getServerName() + "libraries/fuapi.aspx?fn=ApplaySearch4Serial", params, response -> {
            try {
                resultsList = parseResults(response, true);
                if (!nextPage.isEmpty()) {
                    resultsList.add(null);
                }
                resultsAdapter.notifyDataSetChanged();
                resultsAdapter.setPapersItems(resultsList);
                resultsRecycler.setVisibility(View.VISIBLE);
                resultsSwipe.setRefreshing(false);
            } catch (NullPointerException e) {
                Log.e(TAG, "onResponse: " + e);
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
                Log.e(TAG, "onErrorResponse: " + e);
            }
        });
        int socketTimeout = 60000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        request.setRetryPolicy(policy);
        requestQueue.add(request);
    }

    private ArrayList<PapersItem> parseResults(JSONObject response, boolean firstLoad) {
        ArrayList<PapersItem> listItems = new ArrayList<>();
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
                        String id = "-1";
                        if (currentItem.has("id") && !currentItem.isNull("id")) {
                            id = currentItem.getString("id");
                        }
                        String title = "No Data Available";
                        if (currentItem.has("title") && !currentItem.isNull("title")) {
                            title = currentItem.getString("title");
                        }
                        StringBuilder authors = new StringBuilder();
                        if (currentItem.has("authors") && !currentItem.isNull("authors")) {
                            JSONArray arrayAuthors = currentItem.getJSONArray("authors");
                            for (int j = 0; j < arrayAuthors.length(); j++) {
                                authors.append(arrayAuthors.getString(j));
                                if (j < (arrayAuthors.length() - 1)) {
                                    authors.append("\n");
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
                        item.setAuthors(authors.toString());
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
                    Log.e(TAG, "parseResults: " + null);
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
                    ArrayList<PapersItem> resultsListMore = parseResults(response, false);
                    resultsSwipe.setRefreshing(false);
                    resultsList.remove(resultsList.size() - 1);
                    resultsAdapter.notifyItemRemoved(resultsList.size());
                    for (int i = 0; i < resultsListMore.size(); i++) {
                        PapersItem result = resultsListMore.get(i);
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
                    Log.e(TAG, "onErrorResponse: " + null);
                }
            });
            int socketTimeout = 60000;
            RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            request.setRetryPolicy(policy);
            requestQueue.add(request);
        }
    }
}
