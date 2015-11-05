package eg.edu.eulc.librarysystem;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static final String PREF_FILE_NAME = "LibrarySystemPref";
    private SharedPreferences sharedPreferences;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = MainActivity.this.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("langChanged", false);
        editor.apply();
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        if (sharedPreferences.getInt("lang", 0) == 0) {
            conf.locale = new Locale("ar");
        } else {
            conf.locale = new Locale("en");
        }
        res.updateConfiguration(conf, dm);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new StartFragment(), "FragmentStart").commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            StartFragment startFragment = (StartFragment) getSupportFragmentManager().findFragmentByTag("FragmentStart");
            HoldingsFragment holdingsFragment = (HoldingsFragment) getSupportFragmentManager().findFragmentByTag("FragmentHoldings");
            ThesesFragment thesesFragment = (ThesesFragment) getSupportFragmentManager().findFragmentByTag("FragmentTheses");
            if (navigationView.getMenu().getItem(0).isChecked()) {
                if (startFragment.getLayoutVisibility()) {
                    startFragment.showSearch();
                } else {
                    super.onBackPressed();
                }
            } else if (navigationView.getMenu().getItem(1).isChecked() && holdingsFragment.getLayoutVisibility()) {
                holdingsFragment.showSearch();
            } else if (navigationView.getMenu().getItem(4).isChecked() && thesesFragment.getLayoutVisibility()) {
                thesesFragment.showSearch();
            } else {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new StartFragment(), "FragmentStart").commit();
                setSelectedItem(0);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        item.setChecked(true);

        int id = item.getItemId();
        Fragment fragment = null;
        String tag = "";

        if (id == R.id.nav_start) {
            fragment = new StartFragment();
            tag = "FragmentStart";
        } else if (id == R.id.nav_holdings) {
            fragment = new HoldingsFragment();
            tag = "FragmentHoldings";
        } else if (id == R.id.nav_internet_search) {
            fragment = new InternetSearchFragment();
            tag = "FragmentInternetSearch";
        } else if (id == R.id.nav_databases) {
            fragment = new DatabasesFragment();
            tag = "FragmentDatabases";
        } else if (id == R.id.nav_thesis) {
            fragment = new ThesesFragment();
            tag = "FragmentTheses";
        } else if (id == R.id.nav_draft_thesis) {
            fragment = new DraftThesesFragment();
            tag = "FragmentDraftTheses";
        } else if (id == R.id.nav_papers) {
            fragment = new PapersFragment();
            tag = "FragmentPapers";
        } else if (id == R.id.nav_local_journals) {
            fragment = new LocalJournalsFragment();
            tag = "FragmentLocalJournals";
        } else if (id == R.id.nav_e_publish) {
            fragment = new EPublishFragment();
            tag = "FragmentEPublish";
        } else if (id == R.id.nav_digital_contents) {
            fragment = new DigitalContentsFragment();
            tag = "FragmentDigitalContents";
        } else if (id == R.id.nav_my_account) {
            fragment = new MyAccountFragment();
            tag = "FragmentMyAccount";
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment, tag).commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sharedPreferences.getBoolean("langChanged", false)) {
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            if (sharedPreferences.getInt("lang", 0) == 0) {
                conf.locale = new Locale("ar");
            } else {
                conf.locale = new Locale("en");
            }
            res.updateConfiguration(conf, dm);
            finish();
            startActivity(getIntent());
        }
    }

    public void setSelectedItem(int position) {
        navigationView.getMenu().getItem(position).setChecked(true);
    }
}
