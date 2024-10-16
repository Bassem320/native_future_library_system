package bh.edu.ku.futurelibrary.FragmentsDialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import bh.edu.ku.futurelibrary.Objects.PapersItem;
import bh.edu.ku.futurelibrary.R;

/**
 * Created by Eslam El-Meniawy on 30-Dec-15.
 */
public class TabFragmentPapers2 extends Fragment {
    private PapersItem item;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        item = args.getParcelable("item");
        View rootView = inflater.inflate(R.layout.tab_fragment_papers2, container, false);
        TextView itemAbstract = rootView.findViewById(R.id.abstractText);
        if (!item.getAbstractText().isEmpty()) {
            itemAbstract.setText(item.getAbstractText());
        } else {
            itemAbstract.setText(getText(R.string.no_abstract));
        }
        return rootView;
    }
}
