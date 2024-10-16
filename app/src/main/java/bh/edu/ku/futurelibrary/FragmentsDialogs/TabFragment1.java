package bh.edu.ku.futurelibrary.FragmentsDialogs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import bh.edu.ku.futurelibrary.Adapters.GridDownloadAdapter;
import bh.edu.ku.futurelibrary.Objects.ResultsStartItem;
import bh.edu.ku.futurelibrary.VolleySingleton;
import bh.edu.ku.futurelibrary.R;

/**
 * Created by Eslam El-Meniawy on 01-Dec-15.
 */
public class TabFragment1 extends Fragment {
    private ResultsStartItem item;
    public static final String TAG = "TabFragment1";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        item = args.getParcelable("item");
        View rootView = inflater.inflate(R.layout.tab_fragment_1, container, false);
        final ImageView itemImage = rootView.findViewById(R.id.itemImage);
        String imageName = item.getImage();
        VolleySingleton volleySingleton = VolleySingleton.getInstance();
        ImageLoader imageLoader = volleySingleton.getImageLoader();
        if (imageName != null && !imageName.isEmpty()) {
            imageLoader.get(imageName, new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                    itemImage.setImageBitmap(response.getBitmap());
                }

                @Override
                public void onErrorResponse(VolleyError error) {
                }
            });
        }
        TextView itemType = rootView.findViewById(R.id.itemType);
        itemType.setText(item.getType());
        TextView itemTitle = rootView.findViewById(R.id.itemTitle);
        itemTitle.setText(item.getTitle());
        TextView itemClassification = rootView.findViewById(R.id.itemClassification);
        itemClassification.setText(item.getClassification());
        TextView itemPublisher = rootView.findViewById(R.id.itemPublisher);
        itemPublisher.setText(item.getPublisher());
        final JSONObject moreTitle;
        try {
            moreTitle = new JSONObject(item.getMoreTitle());
            if (moreTitle.has("author") && !moreTitle.isNull("author")) {
                TextView itemAuthor = rootView.findViewById(R.id.itemAuthor);
                itemAuthor.setText(moreTitle.getString("author"));
            }
            if (moreTitle.has("ISBN") && !moreTitle.isNull("ISBN")) {
                StringBuilder isbn = new StringBuilder("ISBN: ");
                JSONArray arrayISBN = moreTitle.getJSONArray("ISBN");
                for (int j = 0; j < arrayISBN.length(); j++) {
                    isbn.append(arrayISBN.getString(j));
                    if (j < (arrayISBN.length() - 1)) {
                        isbn.append(", ");
                    }
                }
                TextView itemISBN = rootView.findViewById(R.id.itemISBN);
                itemISBN.setText(isbn.toString());
            }
            if (moreTitle.has("info") && !moreTitle.isNull("info") && !moreTitle.getString("info").isEmpty()) {
                Button info = rootView.findViewById(R.id.itemBookInfo);
                info.setVisibility(View.VISIBLE);
                info.setOnClickListener(v -> {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(moreTitle.getString("info")));
                        startActivity(browserIntent);
                    } catch (JSONException e) {
                        Log.e(TAG, "onClick: " + e);
                    }
                });
            }
            if (moreTitle.has("preview") && !moreTitle.isNull("preview") && !moreTitle.getString("preview").isEmpty()) {
                Button preview = rootView.findViewById(R.id.itemPreview);
                preview.setVisibility(View.VISIBLE);
                preview.setOnClickListener(v -> {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(moreTitle.getString("preview")));
                        startActivity(browserIntent);
                    } catch (JSONException e) {
                        Log.e(TAG, "onClick: " + e);
                    }
                });
            }
            if (moreTitle.has("download") && !moreTitle.isNull("download") && moreTitle.getJSONArray("download").length() > 0) {
                JSONArray downloadJSON = moreTitle.getJSONArray("download");
                List<String> downloadList = new ArrayList<>();
                for(int i = 0; i < downloadJSON.length(); i++){
                    downloadList.add(downloadJSON.getString(i));
                }
                String[] download = downloadList.toArray(new String[downloadList.size()]);
                GridView gridView = rootView.findViewById(R.id.itemDownloadGrid);
                gridView.setAdapter(new GridDownloadAdapter(getActivity(), download));
            }
        } catch (JSONException e) {
            Log.e(TAG, "onCreateView: " + e);
        }
        return rootView;
    }
}
