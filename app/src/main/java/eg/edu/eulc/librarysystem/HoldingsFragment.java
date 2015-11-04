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
public class HoldingsFragment extends Fragment {
    private Spinner itemTypeSpinner, keywordsSpinner1, keywordsSpinner2, keywordsSpinner3, concSpinner1, concSpinner2, wordProcessingSpinner, orderBySpinner;
    private int itemType = 0, keywords1 = 0, keywords2 = 0, keywords3 = 0, conc1 = 0, conc2 = 0, wordProcessing = 0, orderBy = 0;
    private EditText searchTextET1, searchTextET2, searchTextET3, attachContainsET, bibIDET, publishYearET;
    private Button searchButton;
    private LinearLayout searchLayout, resultsLayout;

    public HoldingsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_holdings, container, false);
        itemTypeSpinner = (Spinner) rootView.findViewById(R.id.holdings_search_type);
        keywordsSpinner1 = (Spinner) rootView.findViewById(R.id.keyword1);
        keywordsSpinner2 = (Spinner) rootView.findViewById(R.id.keyword2);
        keywordsSpinner3 = (Spinner) rootView.findViewById(R.id.keyword3);
        concSpinner1 = (Spinner) rootView.findViewById(R.id.conc1);
        concSpinner2 = (Spinner) rootView.findViewById(R.id.conc2);
        wordProcessingSpinner = (Spinner) rootView.findViewById(R.id.WordProcessingSpinner);
        orderBySpinner = (Spinner) rootView.findViewById(R.id.OrderBySpinner);
        searchTextET1 = (EditText) rootView.findViewById(R.id.SearchText1);
        searchTextET2 = (EditText) rootView.findViewById(R.id.SearchText2);
        searchTextET3 = (EditText) rootView.findViewById(R.id.SearchText3);
        attachContainsET = (EditText) rootView.findViewById(R.id.attach_contains);
        bibIDET = (EditText) rootView.findViewById(R.id.BibID);
        publishYearET = (EditText) rootView.findViewById(R.id.Publishyear);
        searchButton = (Button) rootView.findViewById(R.id.searchButton);
        searchLayout = (LinearLayout) rootView.findViewById(R.id.searchLayout);
        resultsLayout = (LinearLayout) rootView.findViewById(R.id.resultsLayout);
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
