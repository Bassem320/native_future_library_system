package eg.edu.eulc.librarysystem;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

/**
 * Created by Eslam El-Meniawy on 01-Nov-15.
 */
public class InternetSearchFragment extends Fragment {
    private Spinner keywordsSpinner1, keywordsSpinner2, keywordsSpinner3, concSpinner1, concSpinner2;
    private int keywords1 = 0, keywords2 = 0, keywords3 = 0, conc1 = 0, conc2 = 0;
    private LinearLayout searchLayout, resultsLayout;
    private EditText searchTextET1, searchTextET2, searchTextET3;
    private Button searchButton;

    public InternetSearchFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_internet_search, container, false);

        keywordsSpinner1 = (Spinner) rootView.findViewById(R.id.keyword1);
        keywordsSpinner2 = (Spinner) rootView.findViewById(R.id.keyword2);
        keywordsSpinner3 = (Spinner) rootView.findViewById(R.id.keyword3);
        concSpinner1 = (Spinner) rootView.findViewById(R.id.conc1);
        concSpinner2 = (Spinner) rootView.findViewById(R.id.conc2);
        searchTextET1 = (EditText) rootView.findViewById(R.id.SearchText1);
        searchTextET2 = (EditText) rootView.findViewById(R.id.SearchText2);
        searchTextET3 = (EditText) rootView.findViewById(R.id.SearchText3);
        searchButton = (Button) rootView.findViewById(R.id.searchButton);
        searchLayout = (LinearLayout) rootView.findViewById(R.id.searchLayout);
        resultsLayout = (LinearLayout) rootView.findViewById(R.id.resultsLayout);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(), R.array.search_in_list, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getContext(), R.array.concs, android.R.layout.simple_spinner_item);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        keywordsSpinner1.setAdapter(adapter1);
        keywordsSpinner1.setSelection(1);
        keywordsSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                keywords1 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        keywordsSpinner2.setAdapter(adapter1);
        keywordsSpinner2.setSelection(1);
        keywordsSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                keywords2 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        keywordsSpinner3.setAdapter(adapter1);
        keywordsSpinner3.setSelection(1);
        keywordsSpinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                keywords3 = position;
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
                String searchText1 = searchTextET1.getText().toString();
                if (searchText1.equals("") || searchText1 == null) {
                    Snackbar.make(v, getResources().getText(R.string.enter_text), Snackbar.LENGTH_LONG).show();
                } else {
                    searchLayout.setVisibility(View.GONE);
                    resultsLayout.setVisibility(View.VISIBLE);
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
}
