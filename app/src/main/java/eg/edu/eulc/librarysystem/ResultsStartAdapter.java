package eg.edu.eulc.librarysystem;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import java.util.ArrayList;

/**
 * Created by eslam on 26-Nov-15.
 */
public class ResultsStartAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static ArrayList<ResultsStartItem> listResultsStartItems = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private VolleySingleton volleySingleton;
    private ImageLoader imageLoader;
    private static Context context;

    public ResultsStartAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        volleySingleton = VolleySingleton.getInstance();
        imageLoader = volleySingleton.getImageLoader();
        this.context = context;
    }

    public void setResultsStartItems(ArrayList<ResultsStartItem> listResultsStartItems) {
        this.listResultsStartItems = listResultsStartItems;
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
        holderItem.itemType.setText(currentItem.getType());
        holderItem.itemTitle.setText(currentItem.getTitle());
        holderItem.itemClassification.setText(currentItem.getClassification());
        holderItem.itemPublisher.setText(currentItem.getPublisher());
        String imageName = currentItem.getImage();
        if (imageName != null && !imageName.equals("")) {
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

        public ViewHolderResultsStartList(View itemView) {
            super(itemView);
            itemImage = (ImageView) itemView.findViewById(R.id.itemImage);
            itemType = (TextView) itemView.findViewById(R.id.itemType);
            itemTitle = (TextView) itemView.findViewById(R.id.itemTitle);
            itemClassification = (TextView) itemView.findViewById(R.id.itemClassification);
            itemPublisher = (TextView) itemView.findViewById(R.id.itemPublisher);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            /*Intent intent = new Intent(context, SiteNewsDetailsActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("SiteNewsItem", listResultsStartItems.get(getLayoutPosition()));
            intent.putExtras(bundle);
            context.startActivity(intent);*/
        }
    }
}
