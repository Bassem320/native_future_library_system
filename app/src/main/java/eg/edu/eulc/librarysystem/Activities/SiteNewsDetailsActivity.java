package eg.edu.eulc.librarysystem.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import eg.edu.eulc.librarysystem.R;
import eg.edu.eulc.librarysystem.Objects.SiteNewsItem;

public class SiteNewsDetailsActivity extends AppCompatActivity {

    TextView title, details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_news_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        title = (TextView) findViewById(R.id.siteNewsTitle);
        details = (TextView) findViewById(R.id.siteNewsDetails);

        Bundle bundle = SiteNewsDetailsActivity.this.getIntent().getExtras();
        if(bundle!=null) {
            SiteNewsItem item = bundle.getParcelable("SiteNewsItem");
            title.setText(item.getTitle());
            details.setText(item.getDetails());
        }
    }

}
