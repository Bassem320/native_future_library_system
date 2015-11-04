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
import android.widget.RelativeLayout;
import android.widget.Spinner;

/**
 * Created by Eslam El-Meniawy on 01-Nov-15.
 */
public class StartFragment extends Fragment {
    private EditText startSearchText;
    private Spinner searchTypeSpinner;
    private int searchType = 0;
    private Button startSearch, startAdvancedSearch;
    private LinearLayout searchLayout, resultsLayout, subject0, subject1, subject2, subject3, subject4, subject5, subject6, subject7, subject8, subject9;

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
