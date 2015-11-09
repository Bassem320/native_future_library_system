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
public class DraftThesesFragment extends Fragment {
    private Spinner searchinSpinner1, searchinSpinner2, searchinSpinner3, concSpinner1, concSpinner2, specialitySpinner, subSpecialitySpinner, degreeSpinner;
    private int searchin1 = 0, searchin2 = 0, searchin3 = 0, conc1 = 0, conc2 = 0, speciality = 0, subSpeciality = 0, degree = 0;
    private LinearLayout searchLayout, resultsLayout;
    private EditText searchTextET1, searchTextET2, searchTextET3;
    private Button searchButton;

    public DraftThesesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_draft_theses, container, false);

        searchinSpinner1 = (Spinner) rootView.findViewById(R.id.searchin1);
        searchinSpinner2 = (Spinner) rootView.findViewById(R.id.searchin2);
        searchinSpinner3 = (Spinner) rootView.findViewById(R.id.searchin3);
        concSpinner1 = (Spinner) rootView.findViewById(R.id.conc1);
        concSpinner2 = (Spinner) rootView.findViewById(R.id.conc2);
        specialitySpinner = (Spinner) rootView.findViewById(R.id.SpecialitySpinner);
        subSpecialitySpinner = (Spinner) rootView.findViewById(R.id.SubSpecialitySpinner);
        degreeSpinner = (Spinner) rootView.findViewById(R.id.DegreeSpinner);
        searchTextET1 = (EditText) rootView.findViewById(R.id.SearchText1);
        searchTextET2 = (EditText) rootView.findViewById(R.id.SearchText2);
        searchTextET3 = (EditText) rootView.findViewById(R.id.SearchText3);
        searchButton = (Button) rootView.findViewById(R.id.searchButton);
        searchLayout = (LinearLayout) rootView.findViewById(R.id.searchLayout);
        resultsLayout = (LinearLayout) rootView.findViewById(R.id.resultsLayout);

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
