package eg.edu.eulc.librarysystem.FragmentsDialogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import eg.edu.eulc.librarysystem.Objects.DraftThesesItem;
import eg.edu.eulc.librarysystem.R;

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
        TextView itemYear = (TextView) rootView.findViewById(R.id.itemYear);
        itemYear.setText(item.getYear());
        TextView itemID = (TextView) rootView.findViewById(R.id.itemID);
        itemID.setText("ID: " + item.getId());
        TextView itemTitle = (TextView) rootView.findViewById(R.id.itemTitle);
        itemTitle.setText(item.getTitle());
        TextView itemDescription = (TextView) rootView.findViewById(R.id.itemDescription);
        itemDescription.setText(item.getDescription());
        TextView itemAuthor = (TextView) rootView.findViewById(R.id.itemAuthor);
        itemAuthor.setText(item.getAuthor());
        return rootView;
    }
}
