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
public class TabFragmentDraftTheses3 extends Fragment {
    private DraftThesesItem item;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        item = args.getParcelable("item");
        View rootView = inflater.inflate(R.layout.tab_fragment_draft_theses3, container, false);
        TextView itemAbstract = (TextView) rootView.findViewById(R.id.abstractText);
        if (!item.getAbstractText().equals("")) {
            itemAbstract.setText(item.getAbstractText());
        } else {
            itemAbstract.setText(getText(R.string.no_abstract));
        }
        return rootView;
    }
}
