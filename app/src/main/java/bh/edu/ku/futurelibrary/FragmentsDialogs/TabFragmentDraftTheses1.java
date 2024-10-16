package bh.edu.ku.futurelibrary.FragmentsDialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import bh.edu.ku.futurelibrary.Objects.DraftThesesItem;
import bh.edu.ku.futurelibrary.R;

/**
 * Created by Eslam El-Meniawy on 30-Dec-15.
 */
public class TabFragmentDraftTheses1 extends Fragment {
    private DraftThesesItem item;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        item = args.getParcelable("item");
        View rootView = inflater.inflate(R.layout.tab_fragment_draft_theses1, container, false);
        TextView itemYear = rootView.findViewById(R.id.itemYear);
        itemYear.setText(item.getYear());
        TextView itemID = rootView.findViewById(R.id.itemID);
        itemID.setText(String.format("ID: %s", item.getId()));
        TextView itemTitle = rootView.findViewById(R.id.itemTitle);
        itemTitle.setText(item.getTitle());
        TextView itemDescription = rootView.findViewById(R.id.itemDescription);
        itemDescription.setText(item.getDescription());
        TextView itemAuthor = rootView.findViewById(R.id.itemAuthor);
        itemAuthor.setText(item.getAuthor());
        return rootView;
    }
}
