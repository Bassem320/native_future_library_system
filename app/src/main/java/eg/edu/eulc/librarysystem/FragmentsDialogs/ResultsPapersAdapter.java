package eg.edu.eulc.librarysystem.FragmentsDialogs;

import android.content.Context;
import android.os.Build;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import eg.edu.eulc.librarysystem.Fragments.PapersFragment;
import eg.edu.eulc.librarysystem.Objects.PapersItem;
import eg.edu.eulc.librarysystem.R;

/**
 * Created by Eslam El-Meniawy on 30-Dec-15.
 */
public class ResultsPapersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String PREF_FILE_NAME = "LibrarySystemPref";
    private static ArrayList<PapersItem> listPapersItems = new ArrayList<>();
    private static Context context;
    private static Fragment fragment;
    private final int VIEW_ITEM = 1;
    private LayoutInflater layoutInflater;

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
            if (currentItem.getAuthors().equals("")) {
                holderItem.itemAuthors.setVisibility(View.GONE);
            } else {
                holderItem.itemAuthors.setText(currentItem.getAuthors());
            }
            if (currentItem.getVolume().equals("")) {
                holderItem.itemVolume.setVisibility(View.GONE);
            } else {
                holderItem.itemVolume.setText(Html.fromHtml("<b>" + context.getText(R.string.volume) + ": </b>" + currentItem.getVolume()));
            }
            if (currentItem.getPages().equals("")) {
                holderItem.itemPages.setVisibility(View.GONE);
            } else {
                holderItem.itemPages.setText(Html.fromHtml("<b>" + context.getText(R.string.pages) + ": </b>" + currentItem.getPages()));
            }
            if (currentItem.getPublishedIn().equals("")) {
                holderItem.itemPublishedIn.setVisibility(View.GONE);
            } else {
                holderItem.itemPublishedIn.setText(Html.fromHtml("<b>" + context.getText(R.string.published_in) + ": </b>" + currentItem.getPublishedIn()));
            }
            if (currentItem.getPublishedAt().equals("")) {
                holderItem.itemPublishedAt.setVisibility(View.GONE);
            } else {
                holderItem.itemPublishedAt.setText(Html.fromHtml("<b>" + context.getText(R.string.published_at) + ": </b>" + currentItem.getPublishedAt()));
            }
            if (currentItem.getSerialName().equals("")) {
                holderItem.itemSerialName.setVisibility(View.GONE);
            } else {
                holderItem.itemSerialName.setText(Html.fromHtml("<b>" + context.getText(R.string.serial_name) + ": </b>" + currentItem.getSerialName()));
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
        private TextView itemTitle, itemAuthors, itemVolume, itemPages, itemPublishedIn, itemPublishedAt, itemSerialName;
        private PapersItem item;

        public ViewHolderPapersList(View itemView) {
            super(itemView);
            itemTitle = (TextView) itemView.findViewById(R.id.itemTitle);
            itemAuthors = (TextView) itemView.findViewById(R.id.itemAuthors);
            itemVolume = (TextView) itemView.findViewById(R.id.itemVolume);
            itemPages = (TextView) itemView.findViewById(R.id.itemPages);
            itemPublishedIn = (TextView) itemView.findViewById(R.id.itemPublishedIn);
            itemPublishedAt = (TextView) itemView.findViewById(R.id.itemPublishedAt);
            itemSerialName = (TextView) itemView.findViewById(R.id.itemSerialName);
            ImageView itemImage = (ImageView) itemView.findViewById(R.id.itemImage);
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
            loadMore = (Button) itemView.findViewById(R.id.load_more);
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
