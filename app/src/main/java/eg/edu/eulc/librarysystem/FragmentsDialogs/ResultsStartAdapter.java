package eg.edu.eulc.librarysystem.FragmentsDialogs;

import android.content.Context;
import android.os.Build;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import java.util.ArrayList;

import eg.edu.eulc.librarysystem.Objects.ResultsStartItem;
import eg.edu.eulc.librarysystem.R;
import eg.edu.eulc.librarysystem.VolleySingleton;

/**
 * Created by eslam on 26-Nov-15.
 */
public class ResultsStartAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String PREF_FILE_NAME = "LibrarySystemPref";
    private static ArrayList<ResultsStartItem> listResultsStartItems = new ArrayList<>();
    private static Context context;
    private static boolean loadImage = true;
    private LayoutInflater layoutInflater;
    private VolleySingleton volleySingleton;
    private ImageLoader imageLoader;

    public ResultsStartAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        volleySingleton = VolleySingleton.getInstance();
        imageLoader = volleySingleton.getImageLoader();
        ResultsStartAdapter.context = context;
    }

    public void setResultsStartItems(ArrayList<ResultsStartItem> listResultsStartItems) {
        ResultsStartAdapter.listResultsStartItems = listResultsStartItems;
        notifyItemRangeChanged(0, listResultsStartItems.size());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        View view = layoutInflater.inflate(R.layout.start_result_item, parent, false);
        viewHolder = new ViewHolderResultsStartList(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ResultsStartItem currentItem = listResultsStartItems.get(position);
        final ViewHolderResultsStartList holderItem = (ViewHolderResultsStartList) holder;
        holderItem.item = currentItem;
        holderItem.itemType.setText(currentItem.getType());
        holderItem.itemTitle.setText(currentItem.getTitle());
        holderItem.itemClassification.setText(currentItem.getClassification());
        holderItem.itemPublisher.setText(currentItem.getPublisher());
        String imageName = currentItem.getImage();
        if (imageName != null && !imageName.equals("") && loadImage) {
            imageLoader.get(imageName, new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                    holderItem.itemImage.setImageBitmap(response.getBitmap());
                }

                @Override
                public void onErrorResponse(VolleyError error) {
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listResultsStartItems.size();
    }

    static class ViewHolderResultsStartList extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView itemImage;
        private TextView itemType, itemTitle, itemClassification, itemPublisher;
        private ResultsStartItem item;

        public ViewHolderResultsStartList(View itemView) {
            super(itemView);
            itemImage = (ImageView) itemView.findViewById(R.id.itemImage);
            itemType = (TextView) itemView.findViewById(R.id.itemType);
            itemTitle = (TextView) itemView.findViewById(R.id.itemTitle);
            itemClassification = (TextView) itemView.findViewById(R.id.itemClassification);
            itemPublisher = (TextView) itemView.findViewById(R.id.itemPublisher);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels < 480) {
                loadImage = false;
                itemImage.setVisibility(View.GONE);
            }
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP && context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE).getInt("lang", 0) == 0) {
                RelativeLayout.LayoutParams titleParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                titleParams.addRule(RelativeLayout.LEFT_OF, itemImage.getId());
                titleParams.addRule(RelativeLayout.BELOW, itemType.getId());

                RelativeLayout.LayoutParams classificationParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                classificationParams.addRule(RelativeLayout.LEFT_OF, itemImage.getId());
                classificationParams.addRule(RelativeLayout.BELOW, itemTitle.getId());

                RelativeLayout.LayoutParams publisherParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                publisherParams.addRule(RelativeLayout.LEFT_OF, itemImage.getId());
                publisherParams.addRule(RelativeLayout.BELOW, itemClassification.getId());

                itemTitle.setLayoutParams(titleParams);
                itemClassification.setLayoutParams(classificationParams);
                itemPublisher.setLayoutParams(publisherParams);
            }
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            FragmentManager fm = ((FragmentActivity) context).getSupportFragmentManager();
            DialogFragment overlay = FragmentDialog.newInstance(item);
            overlay.show(fm, "FragmentDialog");
        }
    }
}
