package eg.edu.eulc.librarysystem.FragmentsDialogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import eg.edu.eulc.librarysystem.Objects.PapersItem;
import eg.edu.eulc.librarysystem.R;

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
        TextView itemAbstract = (TextView) rootView.findViewById(R.id.abstractText);
        if (!item.getAbstractText().equals("")) {
            itemAbstract.setText(item.getAbstractText());
        } else {
            itemAbstract.setText(getText(R.string.no_abstract));
        }
        return rootView;
    }
}
