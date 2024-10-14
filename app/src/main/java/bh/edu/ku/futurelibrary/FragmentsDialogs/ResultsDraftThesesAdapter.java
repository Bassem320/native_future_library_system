package bh.edu.ku.futurelibrary.FragmentsDialogs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bh.edu.ku.futurelibrary.Fragments.DraftThesesFragment;
import bh.edu.ku.futurelibrary.Objects.DraftThesesItem;
import bh.edu.ku.futurelibrary.R;

/**
 * Created by Eslam El-Meniawy on 30-Dec-15.
 */
public class ResultsDraftThesesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static ArrayList<DraftThesesItem> listDraftThesesItems = new ArrayList<>();
    private static Context context;
    private static Fragment fragment;
    private final int VIEW_ITEM = 1;
    private LayoutInflater layoutInflater;

    public ResultsDraftThesesAdapter(Context context, Fragment fragment) {
        layoutInflater = LayoutInflater.from(context);
        ResultsDraftThesesAdapter.context = context;
        ResultsDraftThesesAdapter.fragment = fragment;
    }

    public void setDraftThesesItems(ArrayList<DraftThesesItem> listDraftThesesItems) {
        ResultsDraftThesesAdapter.listDraftThesesItems = listDraftThesesItems;
        notifyItemRangeChanged(0, listDraftThesesItems.size());
    }

    @Override
    public int getItemViewType(int position) {
        return listDraftThesesItems.get(position) != null ? VIEW_ITEM : 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        if (viewType == VIEW_ITEM) {
            View view = layoutInflater.inflate(R.layout.draft_theses_item, parent, false);
            viewHolder = new ViewHolderDraftThesesList(view);
        } else {
            View view = layoutInflater.inflate(R.layout.load_more_item, parent, false);
            viewHolder = new LoadViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderDraftThesesList) {
            DraftThesesItem currentItem = listDraftThesesItems.get(position);
            final ViewHolderDraftThesesList holderItem = (ViewHolderDraftThesesList) holder;
            holderItem.item = currentItem;
            holderItem.itemYear.setText(currentItem.getYear());
            holderItem.itemID.setText("ID: " + currentItem.getId());
            holderItem.itemTitle.setText(currentItem.getTitle());
            if (currentItem.getDescription().equals("")) {
                holderItem.itemDescription.setVisibility(View.GONE);
            } else {
                holderItem.itemDescription.setText(currentItem.getDescription());
            }
            holderItem.itemAuthor.setText(currentItem.getAuthor());
        } else {
            LoadViewHolder holderItem = (LoadViewHolder) holder;
            holderItem.loadMore.setEnabled(true);
        }
    }

    @Override
    public int getItemCount() {
        return listDraftThesesItems.size();
    }

    static class ViewHolderDraftThesesList extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView itemYear, itemID, itemTitle, itemDescription, itemAuthor;
        private DraftThesesItem item;

        public ViewHolderDraftThesesList(View itemView) {
            super(itemView);
            itemYear = (TextView) itemView.findViewById(R.id.itemYear);
            itemID = (TextView) itemView.findViewById(R.id.itemID);
            itemTitle = (TextView) itemView.findViewById(R.id.itemTitle);
            itemDescription = (TextView) itemView.findViewById(R.id.itemDescription);
            itemAuthor = (TextView) itemView.findViewById(R.id.itemAuthor);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            FragmentManager fm = ((FragmentActivity) context).getSupportFragmentManager();
            DialogFragment overlay = FragmentDialogDraftTheses.newInstance(item);
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
            DraftThesesFragment f = (DraftThesesFragment) fragment;
            f.loadMore();
        }
    }
}
