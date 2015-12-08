package eg.edu.eulc.librarysystem.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import eg.edu.eulc.librarysystem.Activities.SiteNewsDetailsActivity;
import eg.edu.eulc.librarysystem.R;
import eg.edu.eulc.librarysystem.Objects.SiteNewsItem;

/**
 * Created by Eslam El-Meniawy on 05-Nov-15.
 */
public class SiteNewsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static ArrayList<SiteNewsItem> listSiteNewsItems = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private static Context context;

    public SiteNewsListAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void setListSiteNewsItems(ArrayList<SiteNewsItem> listSiteNewsItems) {
        this.listSiteNewsItems = listSiteNewsItems;
        notifyItemRangeChanged(0, listSiteNewsItems.size());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        View view = layoutInflater.inflate(R.layout.site_news_item, parent, false);
        viewHolder = new ViewHolderSiteNewsList(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SiteNewsItem currentItem = listSiteNewsItems.get(position);
        final ViewHolderSiteNewsList holderItem = (ViewHolderSiteNewsList) holder;
        holderItem.siteNewsItemTitle.setText(currentItem.getTitle());
    }

    @Override
    public int getItemCount() {
        return listSiteNewsItems.size();
    }

    static class ViewHolderSiteNewsList extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView siteNewsItemTitle;

        public ViewHolderSiteNewsList(View itemView) {
            super(itemView);
            siteNewsItemTitle = (TextView) itemView.findViewById(R.id.SiteNewsItem);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, SiteNewsDetailsActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("SiteNewsItem", listSiteNewsItems.get(getLayoutPosition()));
            intent.putExtras(bundle);
            context.startActivity(intent);
        }
    }
}
