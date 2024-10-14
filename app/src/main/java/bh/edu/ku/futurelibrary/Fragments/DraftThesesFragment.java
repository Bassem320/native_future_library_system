package bh.edu.ku.futurelibrary.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
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

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
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
import bh.edu.ku.futurelibrary.FragmentsDialogs.ResultsDraftThesesAdapter;
import bh.edu.ku.futurelibrary.MyApplication;
import bh.edu.ku.futurelibrary.Objects.DraftThesesItem;
import bh.edu.ku.futurelibrary.VolleySingleton;
import bh.edu.ku.futurelibrary.R;

/**
 * Created by Eslam El-Meniawy on 01-Nov-15.
 */
public class DraftThesesFragment extends Fragment {
    private Spinner subSpecialitySpinner;
    private int searchin1 = 0, searchin2 = 0, searchin3 = 0, conc1 = 0, conc2 = 0, speciality = 0, subSpeciality = 0, degree = 0;
    private String[] searchIn = {"*", "f2", "f8", "f5"}, concs = {"and", "or", "and not"}, degrees = {"", "24.15.1.", "24.15.2."},
           specialities = {"", "100.1.", "100.10.", "100.11.", "100.12.", "100.13.", "100.14.", "100.15.", "100.16.", "100.17.", "100.18.", "100.19.", "100.2.", "100.20.", "100.21.", "100.22.", "100.23.", "100.24.", "100.25.", "100.26.", "100.27.", "100.28.", "100.3.", "100.4.", "100.5.", "100.6.", "100.7.", "100.8.", "100.9.", "100.96."};
    private String[][] subSpecialities = {
            {""}, {"", "100.1.2.", "100.1.8.", "100.1.1.", "100.1.7.", "100.1.5.", "100.1.3.", "100.1.4.", "100.1.11.", "100.1.9.", "100.1.10.", "100.1.6."},
            {"", "100.10.8.", "100.10.13.", "100.10.5.", "100.10.7.", "100.10.6.", "100.10.9.", "100.10.11.", "100.10.10.", "100.10.3.", "100.10.1.", "100.10.12.", "100.10.2.", "100.10.4."},
            {"", "100.11.3.", "100.11.2.", "100.11.1."}, {"", "100.12.5.", "100.12.1.", "100.12.4.", "100.12.3.", "100.12.2."},
            {"", "100.13.9.", "100.13.6.", "100.13.7.", "100.13.5.", "100.13.16.", "100.13.10.", "100.13.11.", "100.13.4.", "100.13.2.", "100.13.12.", "100.13.13.", "100.13.3.", "100.13.1.", "100.13.15.", "100.13.8.", "100.13.14."},
            {"", "100.14.1.", "100.14.6.", "100.14.9.", "100.14.11.", "100.14.8.", "100.14.10.", "100.14.7.", "100.14.5.", "100.14.3.", "100.14.4.", "100.14.2.", "100.14.12."},
            {"", "100.15.1.", "100.15.7.", "100.15.8.", "100.15.6.", "100.15.2.", "100.15.10.", "100.15.5.", "100.15.13.", "100.15.12.", "100.15.3.", "100.15.9.", "100.15.11.", "100.15.4."},
            {"", "100.16.1.", "100.16.4.", "100.16.5.", "100.16.6.", "100.16.3.", "100.16.2."}, {"", "100.17.1.", "100.17.2.", "100.17.3.", "100.17.7.", "100.17.8.", "100.17.4.", "100.17.6.", "100.17.5."},
            {"", "100.18.5.", "100.18.6.", "100.18.7.", "100.18.8.", "100.18.9.", "100.18.13.", "100.18.12.", "100.18.1.", "100.18.10.", "100.18.3.", "100.18.4.", "100.18.14.", "100.18.11.", "100.18.2."},
            {"", "100.19.42.", "100.19.40.", "100.19.32.", "100.19.18.", "100.19.44.", "100.19.47.", "100.19.8.", "100.19.19.", "100.19.4.", "100.19.27.", "100.19.29.", "100.19.41.", "100.19.7.", "100.19.23.", "100.19.2.", "100.19.33.", "100.19.45.", "100.19.39.", "100.19.25.", "100.19.24.", "100.19.5.", "100.19.43.", "100.19.38.", "100.19.6.", "100.19.20.", "100.19.3.", "100.19.1.", "100.19.48.", "100.19.46.", "100.19.35.", "100.19.14.", "100.19.16.", "100.19.10.", "100.19.31.", "100.19.9.", "100.19.26.", "100.19.36.", "100.19.28.", "100.19.34.", "100.19.21.", "100.19.12.", "100.19.30.", "100.19.11.", "100.19.22.", "100.19.15.", "100.19.37.", "100.19.13.", "100.19.17."},
            {"", "100.2.8.", "100.2.4.", "100.2.2.", "100.2.5.", "100.2.12.", "100.2.13.", "100.2.3.", "100.2.7.", "100.2.6.", "100.2.1.", "100.2.9.", "100.2.11.", "100.2.10."},
            {"", "100.20.1."}, {"", "100.21.1.", "100.21.9.", "100.21.2.", "100.21.3.", "100.21.6.", "100.21.8.", "100.21.4.", "100.21.5.", "100.21.7."},
            {"", "100.22.16.", "100.22.13.", "100.22.11.", "100.22.7.", "100.22.21.", "100.22.12.", "100.22.17.", "100.22.2.", "100.22.15.", "100.22.1.", "100.22.20.", "100.22.19.", "100.22.10.", "100.22.4.", "100.22.3.", "100.22.6.", "100.22.5.", "100.22.18.", "100.22.8.", "100.22.9.", "100.22.22.", "100.22.14."},
            {"", "100.23.1.", "100.23.4.", "100.23.3.", "100.23.2.", "100.23.5."}, {"", "100.24.9.", "100.24.7.", "100.24.10.", "100.24.5.", "100.24.8.", "100.24.1.", "100.24.3.", "100.24.6.", "100.24.2.", "100.24.4."},
            {"", "100.25.6.", "100.25.7.", "100.25.4.", "100.25.1.", "100.25.3.", "100.25.5.", "100.25.2."}, {"", "100.26.14.", "100.26.18.", "100.26.25.", "100.26.23.", "100.26.17.", "100.26.1.", "100.26.3.", "100.26.7.", "100.26.6.", "100.26.9.", "100.26.4.", "100.26.22.", "100.26.5.", "100.26.10.", "100.26.19.", "100.26.16.", "100.26.11.", "100.26.15.", "100.26.21.", "100.26.24.", "100.26.26.", "100.26.8.", "100.26.2.", "100.26.20.", "100.26.13.", "100.26.12."},
            {"", "100.27.2.", "100.27.3.", "100.27.4.", "100.27.1."}, {"", "100.28.3.", "100.28.1.", "100.28.5.", "100.28.6.", "100.28.7.", "100.28.4.", "100.28.2."},
            {"", "100.3.1.", "100.3.3.", "100.3.2.", "100.3.4.", "100.3.5.", "100.3.6.", "100.3.7.", "100.3.8.", "100.3.9.", "100.3.10.", "100.3.11.", "100.3.12.", "100.3.13.", "100.3.14.", "100.3.15."},
            {"", "100.4.6.", "100.4.2.", "100.4.3.", "100.4.9.", "100.4.7.", "100.4.8.", "100.4.10.", "100.4.4.", "100.4.1.", "100.4.5."},
            {"", "100.5.2.", "100.5.5.", "100.5.6.", "100.5.7.", "100.5.8.", "100.5.4.", "100.5.1.", "100.5.3."}, {"", "100.6.1.", "100.6.2.", "100.6.3.", "100.6.4.", "100.6.5.", "100.6.6.", "100.6.7."},
            {"", "100.7.1.", "100.7.2.", "100.7.3.", "100.7.4.", "100.7.5.", "100.7.6.", "100.7.7.", "100.7.8.", "100.7.9.", "100.7.10.", "100.7.11.", "100.7.12."},
            {"", "100.8.1.", "100.8.2.", "100.8.3.", "100.8.4."}, {"", "100.9.1.", "100.9.2.", "100.9.3.", "100.9.4.", "100.9.5.", "100.9.6."},
            {"", "100.96.11.1.1.", "100.96.11.1.2.", "100.96.11.1.3.", "100.96.11.1.4.", "100.96.11.1.5.", "100.96.11.1.6.", "100.96.11.1.7.", "100.96.11.1.8.", "100.96.11.1.9.", "100.96.11.1.10.", "100.96.11.1.11.", "100.96.11.1.12.", "100.96.11.1.13.", "100.96.11.1.14.", "100.96.11.1.15.", "100.96.11.1.16.", "100.96.11.1.17.", "100.96.11.1.18.", "100.96.11.1.19.", "100.96.11.1.20.", "100.96.11.1.21.", "100.96.11.1.22.", "100.96.11.1.23.", "100.96.11.1.24.", "100.96.11.1.25.", "100.96.11.1.26.", "100.96.11.1.27.", "100.96.11.1.28.", "100.96.11.2.9.", "100.96.11.2.8.1.", "100.96.11.2.4.1.", "100.96.11.2.5.1.", "100.96.11.2.6.1.", "100.96.11.2.7.1.", "100.96.11.2.1.1.", "100.96.11.2.10.1.", "100.96.11.2.11.1.", "100.96.11.2.13.1.", "100.96.11.2.2.1.", "100.96.11.2.3.1.", "100.96.24.", "100.96.14.", "100.96.16.", "100.96.12.", "100.96.11.", "100.96.19.", "100.96.18.", "100.96.25.", "100.96.28.", "100.96.26.", "100.96.23.", "100.96.15.", "100.96.27.", "100.96.17.", "100.96.21.", "100.96.13.", "100.96.20.", "100.96.22.", "100.96.11.2.1.", "100.96.11.2.2.", "100.96.11.2.3.", "100.96.11.2.3.7.", "100.96.11.2.4.7.", "100.96.11.2.6.7.", "100.96.11.2.5.7.", "100.96.11.2.7.7.", "100.96.11.2.8.7.", "100.96.11.2.13.45.", "100.96.11.2.2.7.", "100.96.11.2.11.7.", "100.96.11.2.1.7.", "100.96.11.2.10.7.", "100.96.11.2.10.3.", "100.96.11.2.11.3.", "100.96.11.2.2.3.", "100.96.11.2.13.3.", "100.96.11.2.1.3.", "100.96.11.2.8.3.", "100.96.11.2.6.3.", "100.96.11.2.7.3.", "100.96.11.2.4.3.", "100.96.11.2.5.3.", "100.96.11.2.3.3.", "100.96.11.2.4.2.", "100.96.11.2.5.2.", "100.96.11.2.7.2.", "100.96.11.2.6.2.", "100.96.11.2.8.2.", "100.96.11.2.1.2.", "100.96.11.2.13.2.", "100.96.11.2.2.2.", "100.96.11.2.3.2.", "100.96.11.2.11.2.", "100.96.11.2.10.2.", "100.96.11.2.10.6.", "100.96.11.2.11.6.", "100.96.11.2.2.6.", "100.96.11.2.13.6.", "100.96.11.2.1.6.", "100.96.11.2.8.6.", "100.96.11.2.4.6.", "100.96.11.2.5.6.", "100.96.11.2.6.6.", "100.96.11.2.7.6.", "100.96.11.2.3.6.", "100.96.11.2.3.4.", "100.96.11.2.5.4.", "100.96.11.2.4.4.", "100.96.11.2.7.4.", "100.96.11.2.6.4.", "100.96.11.2.8.4.", "100.96.11.2.1.4.", "100.96.11.2.13.4.", "100.96.11.2.2.4.", "100.96.11.2.11.4.", "100.96.11.2.10.4.", "100.96.11.9.", "100.96.11.5.", "100.96.11.10.", "100.96.11.8.", "100.96.11.6.", "100.96.11.3.", "100.96.11.1.", "100.96.11.4.", "100.96.11.2.", "100.96.11.7.", "100.96.11.2.8.5.", "100.96.11.2.6.5.", "100.96.11.2.7.5.", "100.96.11.2.4.5.", "100.96.11.2.5.5.", "100.96.11.2.3.5.", "100.96.11.2.1.5.", "100.96.11.2.10.5.", "100.96.11.2.11.5.", "100.96.11.2.2.5.", "100.96.11.2.13.5.", "100.96.11.2.4.", "100.96.11.2.5.", "100.96.11.2.6.", "100.96.11.2.7.", "100.96.11.2.8.", "100.96.11.2.13.", "100.96.11.2.10.", "100.96.11.2.11."}
    };
    private EditText searchTextET1, searchTextET2, searchTextET3, dateFromET, dateToET, draftThesesIDET;
    private String searchText1, searchText2, searchText3, dateFrom, dateTo, draftThesesID, nextPage = "";
    private LinearLayout resultsLayout;
    private ScrollView searchLayout;
    private SwipeRefreshLayout resultsSwipe;
    private RecyclerView resultsRecycler;
    private ArrayList<DraftThesesItem> resultsList = new ArrayList<>();
    private ResultsDraftThesesAdapter resultsAdapter;
    private RequestQueue requestQueue;
    private TextView resultsNumber;

    public DraftThesesFragment() {
    }

    public static void hide_keyboard_from(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
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
        resultsNumber = (TextView) rootView.findViewById(R.id.ResultsNumber);

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

        dateFromET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hide_keyboard_from(getActivity(), dateFromET);
                }
            }
        });

        dateToET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hide_keyboard_from(getActivity(), dateToET);
                }
            }
        });
        draftThesesIDET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hide_keyboard_from(getActivity(), draftThesesIDET);
                }
            }
        });

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
                if (dateFrom == null) {
                    dateFrom = "";
                }

                dateTo = dateToET.getText().toString();
                if (dateTo == null) {
                    dateTo = "";
                }

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
                    String DATE_PATTERN = "^(0?[1-9]|[12][0-9]|3[01])[- /.](0?[1-9]|1[012])[- /.](19|20)\\d{2}$";
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
        return resultsLayout.getVisibility() == View.VISIBLE;
    }

    public void showSearch() {
        resultsLayout.setVisibility(View.GONE);
        searchLayout.setVisibility(View.VISIBLE);
    }

    private void completeSearch() {
        searchLayout.setVisibility(View.GONE);
        resultsLayout.setVisibility(View.VISIBLE);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        resultsRecycler.setLayoutManager(linearLayoutManager);
        resultsAdapter = new ResultsDraftThesesAdapter(getActivity(), DraftThesesFragment.this);
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
        params.put("ScopeIDSelect", ((MyApplication) getActivity().getApplication()).getScopeID());
        params.put("Search1", searchText1);
        params.put("critria1", searchIn[searchin1]);
        params.put("opr1", concs[conc1]);
        params.put("Search2", searchText2);
        params.put("critria2", searchIn[searchin2]);
        params.put("opr2", concs[conc2]);
        params.put("Search3", searchText3);
        params.put("critria3", searchIn[searchin3]);
        params.put("FromDate", dateFrom);
        params.put("ToDate", dateTo);
        params.put("Subject", specialities[speciality]);
        params.put("sub_Subject", subSpecialities[speciality][subSpeciality]);
        params.put("ThesisID", draftThesesID);
        params.put("Degree", degrees[degree]);
        CustomRequest request = new CustomRequest(Request.Method.POST, ((MyApplication) getActivity().getApplication()).getServerName() + "libraries/fuapi.aspx?fn=ApplaySearchDraftThesis", params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    resultsList = parseResults(response, true);
                    if (!nextPage.equals("")) {
                        resultsList.add(null);
                    }
                    resultsAdapter.notifyDataSetChanged();
                    resultsAdapter.setDraftThesesItems(resultsList);
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

    private ArrayList<DraftThesesItem> parseResults(JSONObject response, boolean firstLoad) {
        ArrayList<DraftThesesItem> listItems = new ArrayList<>();
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
                        String year = "";
                        if (currentItem.has("year") && !currentItem.isNull("year")) {
                            year = currentItem.getString("year");
                        }
                        String description = "";
                        if (currentItem.has("description") && !currentItem.isNull("description")) {
                            description = currentItem.getString("description");
                        }
                        String author = "";
                        if (currentItem.has("author") && !currentItem.isNull("author")) {
                            author = currentItem.getString("author");
                        }
                        String details = "";
                        if (currentItem.has("details") && !currentItem.isNull("details")) {
                            details = currentItem.getJSONObject("details").toString();
                        }
                        String abstractText = "";
                        if (currentItem.has("abstract") && !currentItem.isNull("abstract")) {
                            abstractText = currentItem.getString("abstract");
                        }
                        DraftThesesItem item = new DraftThesesItem();
                        item.setId(id);
                        item.setTitle(title);
                        item.setYear(year);
                        item.setDescription(description);
                        item.setAuthor(author);
                        item.setDetails(details);
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
                    }
                }
            } catch (JSONException | NullPointerException | IllegalStateException e) {
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
                        ArrayList<DraftThesesItem> resultsListMore = parseResults(response, false);
                        resultsSwipe.setRefreshing(false);
                        resultsList.remove(resultsList.size() - 1);
                        resultsAdapter.notifyItemRemoved(resultsList.size());
                        for (int i = 0; i < resultsListMore.size(); i++) {
                            DraftThesesItem result = resultsListMore.get(i);
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
