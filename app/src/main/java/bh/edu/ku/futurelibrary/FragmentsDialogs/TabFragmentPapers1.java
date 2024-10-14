package bh.edu.ku.futurelibrary.FragmentsDialogs;

import android.os.Bundle;
import android.text.Html;
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
            itemVolume.setText(Html.fromHtml("<b>" + getText(R.string.volume) + ": </b>" + item.getVolume()));
        }
        TextView itemPages = (TextView) rootView.findViewById(R.id.itemPages);
        if (item.getPages().equals("")) {
            itemPages.setVisibility(View.GONE);
        } else {
            itemPages.setText(Html.fromHtml("<b>" + getText(R.string.pages) + ": </b>" + item.getPages()));
        }
        TextView itemPublishedIn = (TextView) rootView.findViewById(R.id.itemPublishedIn);
        if (item.getPublishedIn().equals("")) {
            itemPublishedIn.setVisibility(View.GONE);
        } else {
            itemPublishedIn.setText(Html.fromHtml("<b>" + getText(R.string.published_in) + ": </b>" + item.getPublishedIn()));
        }
        TextView itemPublishedAt = (TextView) rootView.findViewById(R.id.itemPublishedAt);
        if (item.getPublishedAt().equals("")) {
            itemPublishedAt.setVisibility(View.GONE);
        } else {
            itemPublishedAt.setText(Html.fromHtml("<b>" + getText(R.string.published_at) + ": </b>" + item.getPublishedAt()));
        }
        TextView itemSerialName = (TextView) rootView.findViewById(R.id.itemSerialName);
        if (item.getSerialName().equals("")) {
            itemSerialName.setVisibility(View.GONE);
        } else {
            itemSerialName.setText(Html.fromHtml("<b>" + getText(R.string.serial_name) + ": </b>" + item.getSerialName()));
        }
        return rootView;
    }
}
