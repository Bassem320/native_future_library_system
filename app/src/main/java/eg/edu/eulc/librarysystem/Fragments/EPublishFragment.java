package eg.edu.eulc.librarysystem.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import eg.edu.eulc.librarysystem.R;

/**
 * Created by Eslam El-Meniawy on 01-Nov-15.
 */
public class EPublishFragment extends Fragment {
    public EPublishFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_e_publish, container, false);
        return rootView;
    }
}
