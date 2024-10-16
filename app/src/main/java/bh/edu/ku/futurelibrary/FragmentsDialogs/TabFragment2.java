package bh.edu.ku.futurelibrary.FragmentsDialogs;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import bh.edu.ku.futurelibrary.Objects.ResultsStartItem;
import bh.edu.ku.futurelibrary.R;

/**
 * Created by Eslam El-Meniawy on 01-Dec-15.
 */
public class TabFragment2 extends Fragment {
    public static final String TAG = "TabFragment2";
    private ResultsStartItem item;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        item = args.getParcelable("item");
        View rootView = inflater.inflate(R.layout.tab_fragment_2, container, false);
        try {
            JSONObject details = new JSONObject(item.getDetails());
            if (details.has("DDC") && !details.isNull("DDC") && !details.getString("DDC").isEmpty()) {
                TextView ddcHead = rootView.findViewById(R.id.itemDDCHead);
                TextView ddc = rootView.findViewById(R.id.itemDDC);
                ddcHead.setVisibility(View.VISIBLE);
                ddc.setVisibility(View.VISIBLE);
                ddc.setText(details.getString("DDC"));
            }
            if (details.has("statementOfResponsibility") && !details.isNull("statementOfResponsibility") && !details.getString("statementOfResponsibility").isEmpty()) {
                TextView statOfResHead = rootView.findViewById(R.id.itemStatOfResHead);
                TextView statOfRes = rootView.findViewById(R.id.itemStatOfRes);
                statOfResHead.setVisibility(View.VISIBLE);
                statOfRes.setVisibility(View.VISIBLE);
                statOfRes.setText(details.getString("statementOfResponsibility"));
            }
            if (details.has("alternateTitle") && !details.isNull("alternateTitle") && details.getJSONArray("alternateTitle").length() > 0) {
                StringBuilder alternateTitle = new StringBuilder();
                JSONArray arrayAlternateTitle = details.getJSONArray("alternateTitle");
                for (int j = 0; j < arrayAlternateTitle.length(); j++) {
                    alternateTitle.append(arrayAlternateTitle.getString(j));
                    if (j < (arrayAlternateTitle.length() - 1)) {
                        alternateTitle.append("\n\n");
                    }
                }
                TextView altTitleHead = rootView.findViewById(R.id.itemAltTitleHead);
                TextView altTitle = rootView.findViewById(R.id.itemAltTitle);
                altTitleHead.setVisibility(View.VISIBLE);
                altTitle.setVisibility(View.VISIBLE);
                altTitle.setText(alternateTitle.toString());
            }
            if (details.has("placeOfPublication") && !details.isNull("placeOfPublication") && details.getJSONArray("placeOfPublication").length() > 0) {
                StringBuilder placeOfPublication = new StringBuilder();
                JSONArray arrayPlaceOfPublication = details.getJSONArray("placeOfPublication");
                for (int j = 0; j < arrayPlaceOfPublication.length(); j++) {
                    placeOfPublication.append(arrayPlaceOfPublication.getString(j));
                    if (j < (arrayPlaceOfPublication.length() - 1)) {
                        placeOfPublication.append("\n\n");
                    }
                }
                TextView placeOfPubHead = rootView.findViewById(R.id.itemPlaceOfPubHead);
                TextView placeOfPub = rootView.findViewById(R.id.itemPlaceOfPub);
                placeOfPubHead.setVisibility(View.VISIBLE);
                placeOfPub.setVisibility(View.VISIBLE);
                placeOfPub.setText(placeOfPublication.toString());
            }
            if (details.has("extent") && !details.isNull("extent") && !details.getString("extent").isEmpty()) {
                TextView extentHead = rootView.findViewById(R.id.itemExtentHead);
                TextView extent = rootView.findViewById(R.id.itemExtent);
                extentHead.setVisibility(View.VISIBLE);
                extent.setVisibility(View.VISIBLE);
                extent.setText(details.getString("extent"));
            }
            if (details.has("dimensions") && !details.isNull("dimensions") && !details.getString("dimensions").isEmpty()) {
                TextView dimensionsHead = rootView.findViewById(R.id.itemDimensionsHead);
                TextView dimensions = rootView.findViewById(R.id.itemDimensions);
                dimensionsHead.setVisibility(View.VISIBLE);
                dimensions.setVisibility(View.VISIBLE);
                dimensions.setText(details.getString("dimensions"));
            }
            if (details.has("generalNote") && !details.isNull("generalNote") && details.getJSONArray("generalNote").length() > 0) {
                StringBuilder generalNoteText = new StringBuilder();
                JSONArray arrayGeneralNote = details.getJSONArray("generalNote");
                for (int j = 0; j < arrayGeneralNote.length(); j++) {
                    generalNoteText.append(arrayGeneralNote.getString(j));
                    if (j < (arrayGeneralNote.length() - 1)) {
                        generalNoteText.append("\n\n");
                    }
                }
                TextView generalNoteHead = rootView.findViewById(R.id.itemGeneralNoteHead);
                TextView generalNote = rootView.findViewById(R.id.itemGeneralNote);
                generalNoteHead.setVisibility(View.VISIBLE);
                generalNote.setVisibility(View.VISIBLE);
                generalNote.setText(generalNoteText.toString());
            }
            if (details.has("topicalTerm") && !details.isNull("topicalTerm") && details.getJSONArray("topicalTerm").length() > 0) {
                StringBuilder topicalTermText = new StringBuilder();
                JSONArray arrayTopicalTerm = details.getJSONArray("topicalTerm");
                for (int j = 0; j < arrayTopicalTerm.length(); j++) {
                    topicalTermText.append(arrayTopicalTerm.getString(j));
                    if (j < (arrayTopicalTerm.length() - 1)) {
                        topicalTermText.append("\n\n");
                    }
                }
                TextView topicalTermHead = rootView.findViewById(R.id.itemTopicalTermHead);
                TextView topicalTerm = rootView.findViewById(R.id.itemTopicalTerm);
                topicalTermHead.setVisibility(View.VISIBLE);
                topicalTerm.setVisibility(View.VISIBLE);
                topicalTerm.setText(topicalTermText.toString());
            }
            if (details.has("personalName") && !details.isNull("personalName") && details.getJSONArray("personalName").length() > 0) {
                StringBuilder personalNameText = new StringBuilder();
                JSONArray arrayPersonalName = details.getJSONArray("personalName");
                for (int j = 0; j < arrayPersonalName.length(); j++) {
                    personalNameText.append(arrayPersonalName.getString(j));
                    if (j < (arrayPersonalName.length() - 1)) {
                        personalNameText.append("\n\n");
                    }
                }
                TextView personalNameHead = rootView.findViewById(R.id.itePersonalNameHead);
                TextView personalName = rootView.findViewById(R.id.itemPersonalName);
                personalNameHead.setVisibility(View.VISIBLE);
                personalName.setVisibility(View.VISIBLE);
                personalName.setText(personalNameText.toString());
            }
            if (details.has("corporateName") && !details.isNull("corporateName") && details.getJSONArray("corporateName").length() > 0) {
                StringBuilder corporateName = new StringBuilder();
                JSONArray arrayCorporateName = details.getJSONArray("corporateName");
                for (int j = 0; j < arrayCorporateName.length(); j++) {
                    corporateName.append(arrayCorporateName.getString(j));
                    if (j < (arrayCorporateName.length() - 1)) {
                        corporateName.append("\n\n");
                    }
                }
                TextView corpNameHead = rootView.findViewById(R.id.itemCorpNameHead);
                TextView corpName = rootView.findViewById(R.id.itemCorpName);
                corpNameHead.setVisibility(View.VISIBLE);
                corpName.setVisibility(View.VISIBLE);
                corpName.setText(corporateName.toString());
            }
            if (details.has("descriptionOfAttached") && !details.isNull("descriptionOfAttached") && details.getJSONArray("descriptionOfAttached").length() > 0) {
                StringBuilder descriptionOfAttached = new StringBuilder();
                JSONArray arrayDescriptionOfAttached = details.getJSONArray("descriptionOfAttached");
                for (int j = 0; j < arrayDescriptionOfAttached.length(); j++) {
                    descriptionOfAttached.append(arrayDescriptionOfAttached.getString(j));
                    if (j < (arrayDescriptionOfAttached.length() - 1)) {
                        descriptionOfAttached.append("\n\n");
                    }
                }
                TextView desOfAttachHead = rootView.findViewById(R.id.itemDesOfAttachHead);
                TextView desOfAttach = rootView.findViewById(R.id.itemDesOfAttach);
                desOfAttachHead.setVisibility(View.VISIBLE);
                desOfAttach.setVisibility(View.VISIBLE);
                desOfAttach.setText(descriptionOfAttached.toString());
            }
        } catch (JSONException e) {
            Log.e(TAG, "onCreateView: " + e);
        }
        return rootView;
    }
}
