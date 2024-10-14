package bh.edu.ku.futurelibrary.FragmentsDialogs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.json.JSONException;
import org.json.JSONObject;

import bh.edu.ku.futurelibrary.Objects.DraftThesesItem;
import bh.edu.ku.futurelibrary.R;

/**
 * Created by Eslam El-Meniawy on 30-Dec-15.
 */
public class TabFragmentDraftTheses2 extends Fragment {
    public static final String PREF_FILE_NAME = "LibrarySystemPref";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        Bundle args = getArguments();
        DraftThesesItem item = args.getParcelable("item");
        View rootView = inflater.inflate(R.layout.tab_fragment_draft_theses2, container, false);
        try {
            JSONObject details = new JSONObject(item.getDetails());
            if (details.has("supervisors") && !details.isNull("supervisors")) {
                TextView supervisors = (TextView) rootView.findViewById(R.id.supervisors);
                supervisors.setText(details.getString("supervisors"));
            }
            if (details.has("subjects") && !details.isNull("subjects")) {
                TextView subjects = (TextView) rootView.findViewById(R.id.subjects);
                subjects.setText(details.getString("subjects"));
            }
            if (details.has("degree") && !details.isNull("degree")) {
                TextView degree = (TextView) rootView.findViewById(R.id.degree);
                String degreeText = details.getString("degree");
                if (degreeText.contains("\u007c")) {
                    String[] parts = degreeText.split("\\u007c");
                    if (sharedPreferences.getInt("lang", 0) == 0) {
                        degree.setText(parts[0]);
                    } else {
                        degree.setText(parts[1]);
                    }
                } else {
                    degree.setText(degreeText);
                }
            }
            if (details.has("specialty") && !details.isNull("specialty")) {
                TextView specialty = (TextView) rootView.findViewById(R.id.specialty);
                specialty.setText(details.getString("specialty"));
            }
            if (details.has("siteRegistration") && !details.isNull("siteRegistration")) {
                TextView siteRegistration = (TextView) rootView.findViewById(R.id.siteRegistration);
                String siteRegistrationText = details.getString("siteRegistration");
                if (siteRegistrationText.contains("\u007c")) {
                    String[] parts = siteRegistrationText.split("\\u007c");
                    if (sharedPreferences.getInt("lang", 0) == 0) {
                        siteRegistration.setText(parts[0]);
                    } else {
                        siteRegistration.setText(parts[1]);
                    }
                } else {
                    siteRegistration.setText(siteRegistrationText);
                }
            }
        } catch (JSONException e) {
        }
        return rootView;
    }
}
