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

import eg.edu.eulc.librarysystem.Objects.DraftThesesItem;
import eg.edu.eulc.librarysystem.R;

/**
 * Created by Eslam El-Meniawy on 30-Dec-15.
 */
public class ResultsDraftThesesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static ArrayList<DraftThesesItem> listDraftThesesItems = new ArrayList<>();
    private static Context context;
    private LayoutInflater layoutInflater;

    public ResultsDraftThesesAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        ResultsDraftThesesAdapter.context = context;
    }

    public void setDraftThesesItems(ArrayList<DraftThesesItem> listDraftThesesItems) {
        ResultsDraftThesesAdapter.listDraftThesesItems = listDraftThesesItems;
        notifyItemRangeChanged(0, listDraftThesesItems.size());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        View view = layoutInflater.inflate(R.layout.draft_theses_item, parent, false);
        viewHolder = new ViewHolderDraftThesesList(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
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
}
