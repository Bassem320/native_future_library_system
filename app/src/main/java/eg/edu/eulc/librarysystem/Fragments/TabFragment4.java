package eg.edu.eulc.librarysystem.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import eg.edu.eulc.librarysystem.R;
import eg.edu.eulc.librarysystem.Objects.ResultsStartItem;

/**
 * Created by Eslam El-Meniawy on 01-Dec-15.
 */
public class TabFragment4 extends Fragment {
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
                TextView buyNowHeader = (TextView) rootView.findViewById(R.id.itemBuyNow);
                final JSONObject buyNow = services.getJSONObject("buyNow");
                if (buyNow.has("barnesAndNoble") && !buyNow.isNull("barnesAndNoble") && !buyNow.getString("barnesAndNoble").equals("")) {
                    buyNowHeader.setVisibility(View.VISIBLE);
                    ImageView barnesAndNoble = (ImageView) rootView.findViewById(R.id.itemBuyBarnesAndNoble);
                    barnesAndNoble.setVisibility(View.VISIBLE);
                    barnesAndNoble.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(buyNow.getString("barnesAndNoble")));
                                startActivity(browserIntent);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                if (buyNow.has("amazon") && !buyNow.isNull("amazon") && !buyNow.getString("amazon").equals("")) {
                    buyNowHeader.setVisibility(View.VISIBLE);
                    ImageView amazon = (ImageView) rootView.findViewById(R.id.itemBuyAmazon);
                    amazon.setVisibility(View.VISIBLE);
                    amazon.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(buyNow.getString("amazon")));
                                startActivity(browserIntent);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                if (buyNow.has("abeBooks") && !buyNow.isNull("abeBooks") && !buyNow.getString("abeBooks").equals("")) {
                    buyNowHeader.setVisibility(View.VISIBLE);
                    ImageView abeBooks = (ImageView) rootView.findViewById(R.id.itemBuyAbeBooks);
                    abeBooks.setVisibility(View.VISIBLE);
                    abeBooks.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(buyNow.getString("abeBooks")));
                                startActivity(browserIntent);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rootView;
    }
}
