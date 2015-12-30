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
public class TabFragmentPapers1 extends Fragment {
    private PapersItem item;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        item = args.getParcelable("item");
        View rootView = inflater.inflate(R.layout.tab_fragment_papers1, container, false);
        TextView itemTitle = (TextView) rootView.findViewById(R.id.itemTitle);
        itemTitle.setText(item.getTitle());
        TextView itemAuthors = (TextView) rootView.findViewById(R.id.itemAuthors);
        if (item.getAuthors().equals("")) {
            itemAuthors.setVisibility(View.GONE);
        } else {
            itemAuthors.setText(item.getAuthors());
        }
        TextView itemVolume = (TextView) rootView.findViewById(R.id.itemVolume);
        if (item.getVolume().equals("")) {
            itemVolume.setVisibility(View.GONE);
        } else {
            itemVolume.setText(item.getVolume());
        }
        TextView itemPages = (TextView) rootView.findViewById(R.id.itemPages);
        if (item.getPages().equals("")) {
            itemPages.setVisibility(View.GONE);
        } else {
            itemPages.setText(item.getPages());
        }
        TextView itemPublishedIn = (TextView) rootView.findViewById(R.id.itemPublishedIn);
        if (item.getPublishedIn().equals("")) {
            itemPublishedIn.setVisibility(View.GONE);
        } else {
            itemPublishedIn.setText(item.getPublishedIn());
        }
        TextView itemPublishedAt = (TextView) rootView.findViewById(R.id.itemPublishedAt);
        if (item.getPublishedAt().equals("")) {
            itemPublishedAt.setVisibility(View.GONE);
        } else {
            itemPublishedAt.setText(item.getPublishedAt());
        }
        TextView itemSerialName = (TextView) rootView.findViewById(R.id.itemSerialName);
        if (item.getSerialName().equals("")) {
            itemSerialName.setVisibility(View.GONE);
        } else {
            itemSerialName.setText(item.getSerialName());
        }
        return rootView;
    }
}
