package eg.edu.eulc.librarysystem.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import eg.edu.eulc.librarysystem.R;


/**
 * Created by Eslam El-Meniawy on 07-Dec-15.
 */
public class GridDownloadAdapter extends BaseAdapter {
    private Context context;
    private String[] urls;

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
            gridView = new View(context);
            gridView = inflater.inflate(R.layout.grid_download_item, null);
            Button download = (Button) gridView.findViewById(R.id.download);
            download.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urls[position]));
                    context.startActivity(browserIntent);
                }
            });
        } else {
            gridView = (View) convertView;
        }
        return gridView;
    }
}
