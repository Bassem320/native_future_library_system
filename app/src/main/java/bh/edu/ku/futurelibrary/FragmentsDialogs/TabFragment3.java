package bh.edu.ku.futurelibrary.FragmentsDialogs;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
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
public class TabFragment3 extends Fragment {

    public static final String TAG = "TabFragment3";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        ResultsStartItem item = args.getParcelable("item");
        View rootView = inflater.inflate(R.layout.tab_fragment_3, container, false);
        try {
            JSONArray holdings = new JSONArray(item.getHoldings());
            if (holdings.length() > 0) {
                for (int i = 0; i < holdings.length(); i++) {
                    JSONObject currentHolding = holdings.getJSONObject(i);
                    TableLayout tableLayout = rootView.findViewById(R.id.itemHoldings);
                    TableRow headingRow = new TableRow(getActivity());
                    TextView headView = new TextView(getActivity());
                    headView.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
                    headView.setPadding(0, 5, 0, 5);
                    headView.setTypeface(Typeface.DEFAULT_BOLD);
                    headView.setText(currentHolding.getString("place"));
                    headingRow.addView(headView);
                    tableLayout.addView(headingRow);
                    JSONArray currentRows = currentHolding.getJSONArray("details");
                    for (int j = 0; j < currentRows.length(); j++) {
                        JSONObject currentDetail = currentRows.getJSONObject(j);
                        TableRow row = new TableRow(getActivity());
                        TextView textView1 = new TextView(getActivity());
                        textView1.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
                        textView1.setText(currentDetail.getString("generalNo"));
                        textView1.setPadding(5, 5, 5, 5);
                        textView1.setGravity(Gravity.CENTER_HORIZONTAL);
                        textView1.setBackgroundResource(R.drawable.table_cell_background);
                        TextView textView2 = new TextView(getActivity());
                        textView2.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
                        textView2.setText(currentDetail.getString("callNo"));
                        textView2.setPadding(5, 5, 5, 5);
                        textView2.setGravity(Gravity.CENTER_HORIZONTAL);
                        textView2.setBackgroundResource(R.drawable.table_cell_background);
                        TextView textView3 = new TextView(getActivity());
                        textView3.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 3f));
                        textView3.setText(currentDetail.getString("location"));
                        textView3.setPadding(5, 5, 5, 5);
                        textView3.setGravity(Gravity.CENTER_HORIZONTAL);
                        row.addView(textView1);
                        row.addView(textView2);
                        row.addView(textView3);
                        tableLayout.addView(row);
                    }
                }
            }
        } catch (JSONException e) {
            Log.e(TAG, "onCreateView: "+ e);
        }
        return rootView;
    }
}
