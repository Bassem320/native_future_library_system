package eg.edu.eulc.librarysystem;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Eslam El-Meniawy on 01-Nov-15.
 */
public class DigitalContentsFragment extends Fragment {
    public DigitalContentsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_digital_contents, container, false);
        return rootView;
    }
}
