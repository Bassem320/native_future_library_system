package bh.edu.ku.futurelibrary.FragmentsDialogs;

import android.os.Bundle;
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
    private ResultsStartItem item;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        item = args.getParcelable("item");
        View rootView = inflater.inflate(R.layout.tab_fragment_2, container, false);
        try {
            JSONObject details = new JSONObject(item.getDetails());
            if (details.has("DDC") && !details.isNull("DDC") && !details.getString("DDC").equals("")) {
                TextView ddcHead = (TextView) rootView.findViewById(R.id.itemDDCHead);
                TextView ddc = (TextView) rootView.findViewById(R.id.itemDDC);
                ddcHead.setVisibility(View.VISIBLE);
                ddc.setVisibility(View.VISIBLE);
                ddc.setText(details.getString("DDC"));
            }
            if (details.has("statementOfResponsibility") && !details.isNull("statementOfResponsibility") && !details.getString("statementOfResponsibility").equals("")) {
                TextView statOfResHead = (TextView) rootView.findViewById(R.id.itemStatOfResHead);
                TextView statOfRes = (TextView) rootView.findViewById(R.id.itemStatOfRes);
                statOfResHead.setVisibility(View.VISIBLE);
                statOfRes.setVisibility(View.VISIBLE);
                statOfRes.setText(details.getString("statementOfResponsibility"));
            }
            if (details.has("alternateTitle") && !details.isNull("alternateTitle") && details.getJSONArray("alternateTitle").length() > 0) {
                String alternateTitle = "";
                JSONArray arrayAlternateTitle = details.getJSONArray("alternateTitle");
                for (int j = 0; j < arrayAlternateTitle.length(); j++) {
                    alternateTitle += arrayAlternateTitle.getString(j);
                    if (j < (arrayAlternateTitle.length() - 1)) {
                        alternateTitle += "\n\n";
                    }
                }
                TextView altTitleHead = (TextView) rootView.findViewById(R.id.itemAltTitleHead);
                TextView altTitle = (TextView) rootView.findViewById(R.id.itemAltTitle);
                altTitleHead.setVisibility(View.VISIBLE);
                altTitle.setVisibility(View.VISIBLE);
                altTitle.setText(alternateTitle);
            }
            if (details.has("placeOfPublication") && !details.isNull("placeOfPublication") && details.getJSONArray("placeOfPublication").length() > 0) {
                String placeOfPublication = "";
                JSONArray arrayPlaceOfPublication = details.getJSONArray("placeOfPublication");
                for (int j = 0; j < arrayPlaceOfPublication.length(); j++) {
                    placeOfPublication += arrayPlaceOfPublication.getString(j);
                    if (j < (arrayPlaceOfPublication.length() - 1)) {
                        placeOfPublication += "\n\n";
                    }
                }
                TextView placeOfPubHead = (TextView) rootView.findViewById(R.id.itemPlaceOfPubHead);
                TextView placeOfPub = (TextView) rootView.findViewById(R.id.itemPlaceOfPub);
                placeOfPubHead.setVisibility(View.VISIBLE);
                placeOfPub.setVisibility(View.VISIBLE);
                placeOfPub.setText(placeOfPublication);
            }
            if (details.has("extent") && !details.isNull("extent") && !details.getString("extent").equals("")) {
                TextView extentHead = (TextView) rootView.findViewById(R.id.itemExtentHead);
                TextView extent = (TextView) rootView.findViewById(R.id.itemExtent);
                extentHead.setVisibility(View.VISIBLE);
                extent.setVisibility(View.VISIBLE);
                extent.setText(details.getString("extent"));
            }
            if (details.has("dimensions") && !details.isNull("dimensions") && !details.getString("dimensions").equals("")) {
                TextView dimensionsHead = (TextView) rootView.findViewById(R.id.itemDimensionsHead);
                TextView dimensions = (TextView) rootView.findViewById(R.id.itemDimensions);
                dimensionsHead.setVisibility(View.VISIBLE);
                dimensions.setVisibility(View.VISIBLE);
                dimensions.setText(details.getString("dimensions"));
            }
            if (details.has("generalNote") && !details.isNull("generalNote") && details.getJSONArray("generalNote").length() > 0) {
                String generalNoteText = "";
                JSONArray arrayGeneralNote = details.getJSONArray("generalNote");
                for (int j = 0; j < arrayGeneralNote.length(); j++) {
                    generalNoteText += arrayGeneralNote.getString(j);
                    if (j < (arrayGeneralNote.length() - 1)) {
                        generalNoteText += "\n\n";
                    }
                }
                TextView generalNoteHead = (TextView) rootView.findViewById(R.id.itemGeneralNoteHead);
                TextView generalNote = (TextView) rootView.findViewById(R.id.itemGeneralNote);
                generalNoteHead.setVisibility(View.VISIBLE);
                generalNote.setVisibility(View.VISIBLE);
                generalNote.setText(generalNoteText);
            }
            if (details.has("topicalTerm") && !details.isNull("topicalTerm") && details.getJSONArray("topicalTerm").length() > 0) {
                String topicalTermText = "";
                JSONArray arrayTopicalTerm = details.getJSONArray("topicalTerm");
                for (int j = 0; j < arrayTopicalTerm.length(); j++) {
                    topicalTermText += arrayTopicalTerm.getString(j);
                    if (j < (arrayTopicalTerm.length() - 1)) {
                        topicalTermText += "\n\n";
                    }
                }
                TextView topicalTermHead = (TextView) rootView.findViewById(R.id.itemTopicalTermHead);
                TextView topicalTerm = (TextView) rootView.findViewById(R.id.itemTopicalTerm);
                topicalTermHead.setVisibility(View.VISIBLE);
                topicalTerm.setVisibility(View.VISIBLE);
                topicalTerm.setText(topicalTermText);
            }
            if (details.has("personalName") && !details.isNull("personalName") && details.getJSONArray("personalName").length() > 0) {
                String personalNameText = "";
                JSONArray arrayPersonalName = details.getJSONArray("personalName");
                for (int j = 0; j < arrayPersonalName.length(); j++) {
                    personalNameText += arrayPersonalName.getString(j);
                    if (j < (arrayPersonalName.length() - 1)) {
                        personalNameText += "\n\n";
                    }
                }
                TextView personalNameHead = (TextView) rootView.findViewById(R.id.itePersonalNameHead);
                TextView personalName = (TextView) rootView.findViewById(R.id.itemPersonalName);
                personalNameHead.setVisibility(View.VISIBLE);
                personalName.setVisibility(View.VISIBLE);
                personalName.setText(personalNameText);
            }
            if (details.has("corporateName") && !details.isNull("corporateName") && details.getJSONArray("corporateName").length() > 0) {
                String corporateName = "";
                JSONArray arrayCorporateName = details.getJSONArray("corporateName");
                for (int j = 0; j < arrayCorporateName.length(); j++) {
                    corporateName += arrayCorporateName.getString(j);
                    if (j < (arrayCorporateName.length() - 1)) {
                        corporateName += "\n\n";
                    }
                }
                TextView corpNameHead = (TextView) rootView.findViewById(R.id.itemCorpNameHead);
                TextView corpName = (TextView) rootView.findViewById(R.id.itemCorpName);
                corpNameHead.setVisibility(View.VISIBLE);
                corpName.setVisibility(View.VISIBLE);
                corpName.setText(corporateName);
            }
            if (details.has("descriptionOfAttached") && !details.isNull("descriptionOfAttached") && details.getJSONArray("descriptionOfAttached").length() > 0) {
                String descriptionOfAttached = "";
                JSONArray arrayDescriptionOfAttached = details.getJSONArray("descriptionOfAttached");
                for (int j = 0; j < arrayDescriptionOfAttached.length(); j++) {
                    descriptionOfAttached += arrayDescriptionOfAttached.getString(j);
                    if (j < (arrayDescriptionOfAttached.length() - 1)) {
                        descriptionOfAttached += "\n\n";
                    }
                }
                TextView desOfAttachHead = (TextView) rootView.findViewById(R.id.itemDesOfAttachHead);
                TextView desOfAttach = (TextView) rootView.findViewById(R.id.itemDesOfAttach);
                desOfAttachHead.setVisibility(View.VISIBLE);
                desOfAttach.setVisibility(View.VISIBLE);
                desOfAttach.setText(descriptionOfAttached);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rootView;
    }
}
