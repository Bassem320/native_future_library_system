package eg.edu.eulc.librarysystem.FragmentsDialogs;

import android.content.Context;
import android.os.Build;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import java.util.ArrayList;

import eg.edu.eulc.librarysystem.Fragments.DigitalContentsFragment;
import eg.edu.eulc.librarysystem.Fragments.HoldingsFragment;
import eg.edu.eulc.librarysystem.Fragments.InternetSearchFragment;
import eg.edu.eulc.librarysystem.Fragments.LocalJournalsFragment;
import eg.edu.eulc.librarysystem.Fragments.StartFragment;
import eg.edu.eulc.librarysystem.Fragments.ThesesFragment;
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
    private static Fragment fragment;
    private final int VIEW_ITEM = 1;
    private LayoutInflater layoutInflater;
    private ImageLoader imageLoader;

    public ResultsStartAdapter(Context context, Fragment fragment) {
        layoutInflater = LayoutInflater.from(context);
        VolleySingleton volleySingleton = VolleySingleton.getInstance();
        imageLoader = volleySingleton.getImageLoader();
        ResultsStartAdapter.context = context;
        ResultsStartAdapter.fragment = fragment;
    }

    public void setResultsStartItems(ArrayList<ResultsStartItem> listResultsStartItems) {
        ResultsStartAdapter.listResultsStartItems = listResultsStartItems;
        notifyItemRangeChanged(0, listResultsStartItems.size());
    }

    @Override
    public int getItemViewType(int position) {
        return listResultsStartItems.get(position) != null ? VIEW_ITEM : 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        if (viewType == VIEW_ITEM) {
            View view = layoutInflater.inflate(R.layout.start_result_item, parent, false);
            viewHolder = new ViewHolderResultsStartList(view);
        } else {
            View view = layoutInflater.inflate(R.layout.load_more_item, parent, false);
            viewHolder = new LoadViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderResultsStartList) {
            ResultsStartItem currentItem = listResultsStartItems.get(position);
            final ViewHolderResultsStartList holderItem = (ViewHolderResultsStartList) holder;
            holderItem.item = currentItem;
            holderItem.itemType.setText("(" + currentItem.getType() + ")");
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
        } else {
            LoadViewHolder holderItem = (LoadViewHolder) holder;
            holderItem.loadMore.setEnabled(true);
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
            LinearLayout titleLayout = (LinearLayout) itemView.findViewById(R.id.title_layout);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels < 480) {
                loadImage = false;
                itemImage.setVisibility(View.GONE);
            }
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 && context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE).getInt("lang", 0) == 0) {
                RelativeLayout.LayoutParams titleParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                titleParams.addRule(RelativeLayout.LEFT_OF, itemImage.getId());

                RelativeLayout.LayoutParams classificationParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                classificationParams.addRule(RelativeLayout.LEFT_OF, itemImage.getId());
                classificationParams.addRule(RelativeLayout.BELOW, titleLayout.getId());

                RelativeLayout.LayoutParams publisherParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                publisherParams.addRule(RelativeLayout.LEFT_OF, itemImage.getId());
                publisherParams.addRule(RelativeLayout.BELOW, itemClassification.getId());

                titleLayout.setLayoutParams(titleParams);
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

    static class LoadViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public Button loadMore;

        public LoadViewHolder(View itemView) {
            super(itemView);
            loadMore = (Button) itemView.findViewById(R.id.load_more);
            loadMore.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            loadMore.setEnabled(false);
            if (fragment == ((FragmentActivity) context).getSupportFragmentManager().findFragmentByTag("FragmentStart")) {
                StartFragment f = (StartFragment) fragment;
                f.loadMore();
            } else if (fragment == ((FragmentActivity) context).getSupportFragmentManager().findFragmentByTag("FragmentHoldings")) {
                HoldingsFragment f = (HoldingsFragment) fragment;
                f.loadMore();
            } else if (fragment == ((FragmentActivity) context).getSupportFragmentManager().findFragmentByTag("FragmentInternetSearch")) {
                InternetSearchFragment f = (InternetSearchFragment) fragment;
                f.loadMore();
            } else if (fragment == ((FragmentActivity) context).getSupportFragmentManager().findFragmentByTag("FragmentTheses")) {
                ThesesFragment f = (ThesesFragment) fragment;
                f.loadMore();
            } else if (fragment == ((FragmentActivity) context).getSupportFragmentManager().findFragmentByTag("FragmentLocalJournals")) {
                LocalJournalsFragment f = (LocalJournalsFragment) fragment;
                f.loadMore();
            } else if (fragment == ((FragmentActivity) context).getSupportFragmentManager().findFragmentByTag("FragmentDigitalContents")) {
                DigitalContentsFragment f = (DigitalContentsFragment) fragment;
                f.loadMore();
            }
        }
    }
}
