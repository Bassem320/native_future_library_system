package bh.edu.ku.futurelibrary.FragmentsDialogs;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bh.edu.ku.futurelibrary.Fragments.PapersFragment;
import bh.edu.ku.futurelibrary.Objects.PapersItem;
import bh.edu.ku.futurelibrary.R;

/**
 * Created by Eslam El-Meniawy on 30-Dec-15.
 */
public class ResultsPapersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String PREF_FILE_NAME = "LibrarySystemPref";
    private static ArrayList<PapersItem> listPapersItems = new ArrayList<>();
    private static Context context;
    private static Fragment fragment;
    private final int VIEW_ITEM = 1;
    private final LayoutInflater layoutInflater;

    public ResultsPapersAdapter(Context context, Fragment fragment) {
        layoutInflater = LayoutInflater.from(context);
        ResultsPapersAdapter.context = context;
        ResultsPapersAdapter.fragment = fragment;
    }

    public void setPapersItems(ArrayList<PapersItem> listPapersItems) {
        ResultsPapersAdapter.listPapersItems = listPapersItems;
        notifyItemRangeChanged(0, listPapersItems.size());
    }

    @Override
    public int getItemViewType(int position) {
        return listPapersItems.get(position) != null ? VIEW_ITEM : 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        if (viewType == VIEW_ITEM) {
            View view = layoutInflater.inflate(R.layout.papers_item, parent, false);
            viewHolder = new ViewHolderPapersList(view);
        } else {
            View view = layoutInflater.inflate(R.layout.load_more_item, parent, false);
            viewHolder = new LoadViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderPapersList) {
            PapersItem currentItem = listPapersItems.get(position);
            final ViewHolderPapersList holderItem = (ViewHolderPapersList) holder;
            holderItem.item = currentItem;
            holderItem.itemTitle.setText(currentItem.getTitle());
            if (currentItem.getAuthors().isEmpty()) {
                holderItem.itemAuthors.setVisibility(View.GONE);
            } else {
                holderItem.itemAuthors.setText(currentItem.getAuthors());
            }
            if (currentItem.getVolume().isEmpty()) {
                holderItem.itemVolume.setVisibility(View.GONE);
            } else {
                holderItem.itemVolume.setText(Html.fromHtml("<b>" + context.getText(R.string.volume) + ": </b>" + currentItem.getVolume(), Html.FROM_HTML_MODE_LEGACY));
            }
            if (currentItem.getPages().isEmpty()) {
                holderItem.itemPages.setVisibility(View.GONE);
            } else {
                holderItem.itemPages.setText(Html.fromHtml("<b>" + context.getText(R.string.pages) + ": </b>" + currentItem.getPages(), Html.FROM_HTML_MODE_LEGACY));
            }
            if (currentItem.getPublishedIn().isEmpty()) {
                holderItem.itemPublishedIn.setVisibility(View.GONE);
            } else {
                holderItem.itemPublishedIn.setText(Html.fromHtml("<b>" + context.getText(R.string.published_in) + ": </b>" + currentItem.getPublishedIn(), Html.FROM_HTML_MODE_LEGACY));
            }
            if (currentItem.getPublishedAt().isEmpty()) {
                holderItem.itemPublishedAt.setVisibility(View.GONE);
            } else {
                holderItem.itemPublishedAt.setText(Html.fromHtml("<b>" + context.getText(R.string.published_at) + ": </b>" + currentItem.getPublishedAt(), Html.FROM_HTML_MODE_LEGACY));
            }
            if (currentItem.getSerialName().isEmpty()) {
                holderItem.itemSerialName.setVisibility(View.GONE);
            } else {
                holderItem.itemSerialName.setText(Html.fromHtml("<b>" + context.getText(R.string.serial_name) + ": </b>" + currentItem.getSerialName(), Html.FROM_HTML_MODE_LEGACY));
            }
        } else {
            LoadViewHolder holderItem = (LoadViewHolder) holder;
            holderItem.loadMore.setEnabled(true);
        }
    }

    @Override
    public int getItemCount() {
        return listPapersItems.size();
    }

    static class ViewHolderPapersList extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView itemTitle;
        private final TextView itemAuthors;
        private final TextView itemVolume;
        private final TextView itemPages;
        private final TextView itemPublishedIn;
        private final TextView itemPublishedAt;
        private final TextView itemSerialName;
        private PapersItem item;

        public ViewHolderPapersList(View itemView) {
            super(itemView);
            itemTitle = itemView.findViewById(R.id.itemTitle);
            itemAuthors = itemView.findViewById(R.id.itemAuthors);
            itemVolume = itemView.findViewById(R.id.itemVolume);
            itemPages = itemView.findViewById(R.id.itemPages);
            itemPublishedIn = itemView.findViewById(R.id.itemPublishedIn);
            itemPublishedAt = itemView.findViewById(R.id.itemPublishedAt);
            itemSerialName = itemView.findViewById(R.id.itemSerialName);
            ImageView itemImage = itemView.findViewById(R.id.itemImage);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels < 480) {
                itemImage.setVisibility(View.GONE);
            }
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE).getInt("lang", 0) == 0) {
                RelativeLayout.LayoutParams titleParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                titleParams.addRule(RelativeLayout.LEFT_OF, itemImage.getId());

                RelativeLayout.LayoutParams authorsParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                authorsParams.addRule(RelativeLayout.LEFT_OF, itemImage.getId());
                authorsParams.addRule(RelativeLayout.BELOW, itemTitle.getId());

                RelativeLayout.LayoutParams volumeParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                volumeParams.addRule(RelativeLayout.LEFT_OF, itemImage.getId());
                volumeParams.addRule(RelativeLayout.BELOW, itemAuthors.getId());

                RelativeLayout.LayoutParams pagesParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                pagesParams.addRule(RelativeLayout.LEFT_OF, itemImage.getId());
                pagesParams.addRule(RelativeLayout.BELOW, itemVolume.getId());

                RelativeLayout.LayoutParams publishedInParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                publishedInParams.addRule(RelativeLayout.LEFT_OF, itemImage.getId());
                publishedInParams.addRule(RelativeLayout.BELOW, itemPages.getId());

                RelativeLayout.LayoutParams publishedAtParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                publishedAtParams.addRule(RelativeLayout.LEFT_OF, itemImage.getId());
                publishedAtParams.addRule(RelativeLayout.BELOW, itemPublishedIn.getId());

                RelativeLayout.LayoutParams serialNameParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                serialNameParams.addRule(RelativeLayout.LEFT_OF, itemImage.getId());
                serialNameParams.addRule(RelativeLayout.BELOW, itemPublishedAt.getId());

                itemTitle.setLayoutParams(titleParams);
                itemAuthors.setLayoutParams(authorsParams);
                itemVolume.setLayoutParams(volumeParams);
                itemPages.setLayoutParams(pagesParams);
                itemPublishedIn.setLayoutParams(publishedInParams);
                itemPublishedAt.setLayoutParams(publishedAtParams);
                itemSerialName.setLayoutParams(serialNameParams);
            }
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            FragmentManager fm = ((FragmentActivity) context).getSupportFragmentManager();
            DialogFragment overlay = FragmentDialogPapers.newInstance(item);
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
            PapersFragment f = (PapersFragment) fragment;
            f.loadMore();
        }
    }
}
