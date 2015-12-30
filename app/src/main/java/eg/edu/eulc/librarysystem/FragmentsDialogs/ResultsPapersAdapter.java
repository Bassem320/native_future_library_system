package eg.edu.eulc.librarysystem.FragmentsDialogs;

import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import eg.edu.eulc.librarysystem.Objects.PapersItem;
import eg.edu.eulc.librarysystem.R;

/**
 * Created by Eslam El-Meniawy on 30-Dec-15.
 */
public class ResultsPapersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static ArrayList<PapersItem> listPapersItems = new ArrayList<>();
    private static Context context;
    private LayoutInflater layoutInflater;

    public ResultsPapersAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        ResultsPapersAdapter.context = context;
    }

    public void setPapersItems(ArrayList<PapersItem> listPapersItems) {
        ResultsPapersAdapter.listPapersItems = listPapersItems;
        notifyItemRangeChanged(0, listPapersItems.size());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        View view = layoutInflater.inflate(R.layout.papers_item, parent, false);
        viewHolder = new ViewHolderPapersList(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
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
            holderItem.itemVolume.setText(currentItem.getVolume());
        }
        if (currentItem.getPages().equals("")) {
            holderItem.itemPages.setVisibility(View.GONE);
        } else {
            holderItem.itemPages.setText(currentItem.getPages());
        }
        if (currentItem.getPublishedIn().equals("")) {
            holderItem.itemPublishedIn.setVisibility(View.GONE);
        } else {
            holderItem.itemPublishedIn.setText(currentItem.getPublishedIn());
        }
        if (currentItem.getPublishedAt().equals("")) {
            holderItem.itemPublishedAt.setVisibility(View.GONE);
        } else {
            holderItem.itemPublishedAt.setText(currentItem.getPublishedAt());
        }
        if (currentItem.getSerialName().equals("")) {
            holderItem.itemSerialName.setVisibility(View.GONE);
        } else {
            holderItem.itemSerialName.setText(currentItem.getSerialName());
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
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            FragmentManager fm = ((FragmentActivity) context).getSupportFragmentManager();
            DialogFragment overlay = FragmentDialogPapers.newInstance(item);
            overlay.show(fm, "FragmentDialog");
        }
    }
}
