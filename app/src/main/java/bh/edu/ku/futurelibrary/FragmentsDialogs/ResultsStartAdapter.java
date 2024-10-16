package bh.edu.ku.futurelibrary.FragmentsDialogs;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import java.util.ArrayList;

import bh.edu.ku.futurelibrary.Activities.Level110Activity;
import bh.edu.ku.futurelibrary.Activities.Level11Activity;
import bh.edu.ku.futurelibrary.Activities.Level12Activity;
import bh.edu.ku.futurelibrary.Activities.Level13Activity;
import bh.edu.ku.futurelibrary.Activities.Level14Activity;
import bh.edu.ku.futurelibrary.Activities.Level15Activity;
import bh.edu.ku.futurelibrary.Activities.Level16Activity;
import bh.edu.ku.futurelibrary.Activities.Level17Activity;
import bh.edu.ku.futurelibrary.Activities.Level18Activity;
import bh.edu.ku.futurelibrary.Activities.Level19Activity;
import bh.edu.ku.futurelibrary.Fragments.DigitalContentsFragment;
import bh.edu.ku.futurelibrary.Fragments.HoldingsFragment;
import bh.edu.ku.futurelibrary.Fragments.InternetSearchFragment;
import bh.edu.ku.futurelibrary.Fragments.LocalJournalsFragment;
import bh.edu.ku.futurelibrary.Fragments.StartFragment;
import bh.edu.ku.futurelibrary.Fragments.ThesesFragment;
import bh.edu.ku.futurelibrary.Objects.ResultsStartItem;
import bh.edu.ku.futurelibrary.VolleySingleton;
import bh.edu.ku.futurelibrary.R;

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
    private final LayoutInflater layoutInflater;
    private final ImageLoader imageLoader;

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
            holderItem.itemType.setText(String.format("(%s)", currentItem.getType()));
            holderItem.itemTitle.setText(currentItem.getTitle());
            holderItem.itemClassification.setText(currentItem.getClassification());
            holderItem.itemPublisher.setText(currentItem.getPublisher());
            String imageName = currentItem.getImage();
            if (imageName != null && !imageName.isEmpty() && loadImage) {
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
        private final ImageView itemImage;
        private final TextView itemType;
        private final TextView itemTitle;
        private final TextView itemClassification;
        private final TextView itemPublisher;
        private ResultsStartItem item;

        public ViewHolderResultsStartList(View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemType = itemView.findViewById(R.id.itemType);
            itemTitle = itemView.findViewById(R.id.itemTitle);
            itemClassification = itemView.findViewById(R.id.itemClassification);
            itemPublisher = itemView.findViewById(R.id.itemPublisher);
            LinearLayout titleLayout = itemView.findViewById(R.id.title_layout);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels < 480) {
                loadImage = false;
                itemImage.setVisibility(View.GONE);
            }
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE).getInt("lang", 0) == 0) {
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
            loadMore = itemView.findViewById(R.id.load_more);
            loadMore.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            loadMore.setEnabled(false);
            if (fragment != null) {
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
            } else {
                if (context instanceof Level11Activity) {
                    ((Level11Activity) context).loadMore();
                } else if (context instanceof Level12Activity) {
                    ((Level12Activity) context).loadMore();
                } else if (context instanceof Level13Activity) {
                    ((Level13Activity) context).loadMore();
                } else if (context instanceof Level14Activity) {
                    ((Level14Activity) context).loadMore();
                } else if (context instanceof Level15Activity) {
                    ((Level15Activity) context).loadMore();
                } else if (context instanceof Level16Activity) {
                    ((Level16Activity) context).loadMore();
                } else if (context instanceof Level17Activity) {
                    ((Level17Activity) context).loadMore();
                } else if (context instanceof Level18Activity) {
                    ((Level18Activity) context).loadMore();
                } else if (context instanceof Level19Activity) {
                    ((Level19Activity) context).loadMore();
                } else if (context instanceof Level110Activity) {
                    ((Level110Activity) context).loadMore();
                }
            }
        }
    }
}
