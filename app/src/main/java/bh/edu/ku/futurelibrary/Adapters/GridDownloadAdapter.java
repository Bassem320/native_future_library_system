package bh.edu.ku.futurelibrary.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import bh.edu.ku.futurelibrary.R;


/**
 * Created by Eslam El-Meniawy on 07-Dec-15.
 */
public class GridDownloadAdapter extends BaseAdapter {
    private final Context context;
    private final String[] urls;

    public GridDownloadAdapter(Context context, String[] urls) {
        this.context = context;
        this.urls = urls;
    }

    @Override
    public int getCount() {
        return urls.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;
        if (convertView == null) {
            gridView = inflater.inflate(R.layout.grid_download_item, null);
            Button download = gridView.findViewById(R.id.download);
            download.setOnClickListener(v -> {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urls[position]));
                context.startActivity(browserIntent);
            });
        } else {
            gridView = convertView;
        }
        return gridView;
    }
}
