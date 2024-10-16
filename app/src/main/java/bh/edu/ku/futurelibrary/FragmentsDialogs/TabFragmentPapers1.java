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
        TextView itemTitle = rootView.findViewById(R.id.itemTitle);
        itemTitle.setText(item.getTitle());
        TextView itemAuthors = rootView.findViewById(R.id.itemAuthors);
        if (item.getAuthors().isEmpty()) {
            itemAuthors.setVisibility(View.GONE);
        } else {
            itemAuthors.setText(item.getAuthors());
        }
        TextView itemVolume = rootView.findViewById(R.id.itemVolume);
        if (item.getVolume().isEmpty()) {
            itemVolume.setVisibility(View.GONE);
        } else {
            itemVolume.setText(Html.fromHtml("<b>" + getText(R.string.volume) + ": </b>" + item.getVolume(), Html.FROM_HTML_MODE_LEGACY));
        }
        TextView itemPages = rootView.findViewById(R.id.itemPages);
        if (item.getPages().isEmpty()) {
            itemPages.setVisibility(View.GONE);
        } else {
            itemPages.setText(Html.fromHtml("<b>" + getText(R.string.pages) + ": </b>" + item.getPages(), Html.FROM_HTML_MODE_LEGACY));
        }
        TextView itemPublishedIn = rootView.findViewById(R.id.itemPublishedIn);
        if (item.getPublishedIn().isEmpty()) {
            itemPublishedIn.setVisibility(View.GONE);
        } else {
            itemPublishedIn.setText(Html.fromHtml("<b>" + getText(R.string.published_in) + ": </b>" + item.getPublishedIn(), Html.FROM_HTML_MODE_LEGACY));
        }
        TextView itemPublishedAt = rootView.findViewById(R.id.itemPublishedAt);
        if (item.getPublishedAt().isEmpty()) {
            itemPublishedAt.setVisibility(View.GONE);
        } else {
            itemPublishedAt.setText(Html.fromHtml("<b>" + getText(R.string.published_at) + ": </b>" + item.getPublishedAt(), Html.FROM_HTML_MODE_LEGACY));
        }
        TextView itemSerialName = rootView.findViewById(R.id.itemSerialName);
        if (item.getSerialName().isEmpty()) {
            itemSerialName.setVisibility(View.GONE);
        } else {
            itemSerialName.setText(Html.fromHtml("<b>" + getText(R.string.serial_name) + ": </b>" + item.getSerialName(), Html.FROM_HTML_MODE_LEGACY));
        }
        return rootView;
    }
}
