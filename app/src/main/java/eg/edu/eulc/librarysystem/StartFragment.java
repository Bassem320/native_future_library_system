package eg.edu.eulc.librarysystem;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Eslam El-Meniawy on 01-Nov-15.
 */
public class StartFragment extends Fragment {
    private EditText startSearchText;
    private Spinner searchTypeSpinner;
    private int searchType = 0;
    private Button startSearch, startAdvancedSearch;
    private LinearLayout searchLayout, resultsLayout, subject0, subject1, subject2, subject3, subject4, subject5, subject6, subject7, subject8, subject9;
    private RecyclerView listItemsRecycler;
    private ProgressBar loadingItems;
    public static final String PREF_FILE_NAME = "LibrarySystemPref";
    private SharedPreferences sharedPreferences;
    private VolleySingleton volleySingleton;
    private ArrayList<SiteNewsItem> siteNewsList = new ArrayList<>();
    private SiteNewsListAdapter itemsListAdapter;
    private RequestQueue requestQueue;
    private LinearLayoutManager linearLayoutManager;

    public StartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_start, container, false);

        startSearchText = (EditText) rootView.findViewById(R.id.start_search_EditText);
        searchTypeSpinner = (Spinner) rootView.findViewById(R.id.start_search_type);
        startSearch = (Button) rootView.findViewById(R.id.search_button);
        startAdvancedSearch = (Button) rootView.findViewById(R.id.advanced_search_button);
        searchLayout = (LinearLayout) rootView.findViewById(R.id.searchLayout);
        resultsLayout = (LinearLayout) rootView.findViewById(R.id.resultsLayout);
        subject0 = (LinearLayout) rootView.findViewById(R.id.Subject0);
        subject1 = (LinearLayout) rootView.findViewById(R.id.Subject1);
        subject2 = (LinearLayout) rootView.findViewById(R.id.Subject2);
        subject3 = (LinearLayout) rootView.findViewById(R.id.Subject3);
        subject4 = (LinearLayout) rootView.findViewById(R.id.Subject4);
        subject5 = (LinearLayout) rootView.findViewById(R.id.Subject5);
        subject6 = (LinearLayout) rootView.findViewById(R.id.Subject6);
        subject7 = (LinearLayout) rootView.findViewById(R.id.Subject7);
        subject8 = (LinearLayout) rootView.findViewById(R.id.Subject8);
        subject9 = (LinearLayout) rootView.findViewById(R.id.Subject9);
        listItemsRecycler = (RecyclerView) rootView.findViewById(R.id.RecyclerNews);
        loadingItems = (ProgressBar) rootView.findViewById(R.id.SiteNewsProgress);

        sharedPreferences = getActivity().getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);

        linearLayoutManager = new LinearLayoutManager(getActivity());
        listItemsRecycler.setLayoutManager(linearLayoutManager);
        itemsListAdapter = new SiteNewsListAdapter(getActivity());
        listItemsRecycler.setAdapter(itemsListAdapter);
        volleySingleton = VolleySingleton.getInstance();
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

        startAdvancedSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.frame_container, new HoldingsFragment(), "FragmentHoldings").commit();
                ((MainActivity) getActivity()).setSelectedItem(1);
            }
        });

        startSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchText = startSearchText.getText().toString();
                if (searchText.equals("") || searchText == null) {
                    Snackbar.make(v, getResources().getText(R.string.enter_text), Snackbar.LENGTH_LONG).show();
                } else {
                    searchLayout.setVisibility(View.GONE);
                    resultsLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        subject0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Subject 0", Snackbar.LENGTH_LONG).show();
            }
        });

        subject1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Subject 1", Snackbar.LENGTH_LONG).show();
            }
        });

        subject2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Subject 2", Snackbar.LENGTH_LONG).show();
            }
        });

        subject3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Subject 3", Snackbar.LENGTH_LONG).show();
            }
        });

        subject4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Subject 4", Snackbar.LENGTH_LONG).show();
            }
        });

        subject5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Subject 5", Snackbar.LENGTH_LONG).show();
            }
        });

        subject6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Subject 6", Snackbar.LENGTH_LONG).show();
            }
        });

        subject7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Subject 7", Snackbar.LENGTH_LONG).show();
            }
        });

        subject8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Subject 8", Snackbar.LENGTH_LONG).show();
            }
        });

        subject9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Subject 9", Snackbar.LENGTH_LONG).show();
            }
        });

        requestSiteNews();

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

    private void requestSiteNews() {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, "http://10.19.1.34:1234/librarySystem/siteNews.json", new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("siteNewsList", response.toString());
                editor.apply();
                siteNewsList = parseSiteNews(response);
                itemsListAdapter.setListSiteNewsItems(siteNewsList);
                listItemsRecycler.setMinimumHeight(listItemsRecycler.getHeight());
                loadingItems.setVisibility(View.GONE);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loadingItems.setVisibility(View.GONE);
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    Snackbar.make(getActivity().findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.no_internet), Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(getActivity().findViewById(R.id.MainCoordinatorLayout), getResources().getText(R.string.error_fetching_site_news), Snackbar.LENGTH_LONG).show();
                }
                String strJson = sharedPreferences.getString("siteNewsList", "");
                if (!strJson.equals("")) {
                    try {
                        JSONObject jsonData = new JSONObject(strJson);
                        siteNewsList = parseSiteNews(jsonData);
                        itemsListAdapter.setListSiteNewsItems(siteNewsList);
                    } catch (JSONException e) {
                    }
                }
            }
        });
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
                        SiteNewsItem item = new SiteNewsItem();
                        item.setId(id);
                        item.setTitle(title);
                        if (id != -1 && !title.equals("No Data Available")) {
                            listItems.add(item);
                        }
                    }
                } else {
                    String strJson = sharedPreferences.getString("siteNewsList", "");
                    if (!strJson.equals("")) {
                        try {
                            JSONObject jsonData = new JSONObject(strJson);
                            siteNewsList = parseSiteNews(jsonData);
                            itemsListAdapter.setListSiteNewsItems(siteNewsList);
                        } catch (JSONException e) {
                        }
                    }
                }
            } catch (JSONException e) {
                String strJson = sharedPreferences.getString("siteNewsList", "");
                if (!strJson.equals("")) {
                    try {
                        JSONObject jsonData = new JSONObject(strJson);
                        siteNewsList = parseSiteNews(jsonData);
                        itemsListAdapter.setListSiteNewsItems(siteNewsList);
                    } catch (JSONException ex) {
                    }
                }
            }
        }
        return listItems;
    }
}
