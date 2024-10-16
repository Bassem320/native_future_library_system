package bh.edu.ku.futurelibrary.FragmentsDialogs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.json.JSONException;
import org.json.JSONObject;

import bh.edu.ku.futurelibrary.Objects.ResultsStartItem;
import bh.edu.ku.futurelibrary.R;

/**
 * Created by Eslam El-Meniawy on 01-Dec-15.
 */
public class TabFragment4 extends Fragment {
    public static final String TAG = "TabFragment4";
    private ResultsStartItem item;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        item = args.getParcelable("item");
        View rootView = inflater.inflate(R.layout.tab_fragment_4, container, false);
        try {
            JSONObject services = new JSONObject(item.getServices());
            if (services.has("buyNow") && !services.isNull("buyNow")) {
                TextView buyNowHeader = rootView.findViewById(R.id.itemBuyNow);
                final JSONObject buyNow = services.getJSONObject("buyNow");
                if (buyNow.has("barnesAndNoble") && !buyNow.isNull("barnesAndNoble") && !buyNow.getString("barnesAndNoble").isEmpty()) {
                    buyNowHeader.setVisibility(View.VISIBLE);
                    ImageView barnesAndNoble = rootView.findViewById(R.id.itemBuyBarnesAndNoble);
                    barnesAndNoble.setVisibility(View.VISIBLE);
                    barnesAndNoble.setOnClickListener(v -> {
                        try {
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(buyNow.getString("barnesAndNoble")));
                            startActivity(browserIntent);
                        } catch (JSONException e) {
                            Log.e(TAG, "onCreateView: " + e);
                        }
                    });
                }
                if (buyNow.has("amazon") && !buyNow.isNull("amazon") && !buyNow.getString("amazon").isEmpty()) {
                    buyNowHeader.setVisibility(View.VISIBLE);
                    ImageView amazon = rootView.findViewById(R.id.itemBuyAmazon);
                    amazon.setVisibility(View.VISIBLE);
                    amazon.setOnClickListener(v -> {
                        try {
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(buyNow.getString("amazon")));
                            startActivity(browserIntent);
                        } catch (JSONException e) {
                            Log.e(TAG, "onClick: " + e);
                        }
                    });
                }
                if (buyNow.has("abeBooks") && !buyNow.isNull("abeBooks") && !buyNow.getString("abeBooks").isEmpty()) {
                    buyNowHeader.setVisibility(View.VISIBLE);
                    ImageView abeBooks = rootView.findViewById(R.id.itemBuyAbeBooks);
                    abeBooks.setVisibility(View.VISIBLE);
                    abeBooks.setOnClickListener(v -> {
                        try {
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(buyNow.getString("abeBooks")));
                            startActivity(browserIntent);
                        } catch (JSONException e) {
                            Log.e(TAG, "onClick: " + e);
                        }
                    });
                }
            }
        } catch (JSONException e) {
            Log.e(TAG, "onCreateView: " + e);
        }
        return rootView;
    }
}
