package eg.edu.eulc.librarysystem;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Eslam El-Meniawy on 01-Dec-15.
 */
public class TabFragment3 extends Fragment {
    private ResultsStartItem item;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        item = args.getParcelable("item");
        View rootView = inflater.inflate(R.layout.tab_fragment_3, container, false);
        TextView tv = (TextView) rootView.findViewById(R.id.textView);
        tv.setText(item.getPublisher());
        return rootView;
    }
}
