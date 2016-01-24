package eg.edu.eulc.librarysystem.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

import eg.edu.eulc.librarysystem.Fragments.DigitalContentsFragment;
import eg.edu.eulc.librarysystem.Fragments.DraftThesesFragment;
import eg.edu.eulc.librarysystem.Fragments.HoldingsFragment;
import eg.edu.eulc.librarysystem.Fragments.LocalJournalsFragment;
import eg.edu.eulc.librarysystem.Fragments.PapersFragment;
import eg.edu.eulc.librarysystem.Fragments.StartFragment;
import eg.edu.eulc.librarysystem.Fragments.ThesesFragment;
import eg.edu.eulc.librarysystem.MyApplication;
import eg.edu.eulc.librarysystem.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static final String PREF_FILE_NAME = "LibrarySystemPref";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = MainActivity.this.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if (sharedPreferences.getBoolean("FirstRun", true)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            final View firstRunLayout = MainActivity.this.getLayoutInflater().inflate(R.layout.dialog_first_run, null);

            TabLayout tabLayout = (TabLayout) firstRunLayout.findViewById(R.id.firstRunTabLayout);
            tabLayout.addTab(tabLayout.newTab().setText("عربي"));
            tabLayout.addTab(tabLayout.newTab().setText("English"));
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
            tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    TextView selectLangAr = (TextView) firstRunLayout.findViewById(R.id.select_lang_ar);
                    TextView selectLangEn = (TextView) firstRunLayout.findViewById(R.id.select_lang_en);
                    TextView canChangeAr = (TextView) firstRunLayout.findViewById(R.id.can_change_ar);
                    TextView canChangeEn = (TextView) firstRunLayout.findViewById(R.id.can_change_en);
                    TextView langAr = (TextView) firstRunLayout.findViewById(R.id.lang_ar);
                    TextView langEn = (TextView) firstRunLayout.findViewById(R.id.lang_en);
                    TextView siteAr = (TextView) firstRunLayout.findViewById(R.id.site_ar);
                    TextView siteEn = (TextView) firstRunLayout.findViewById(R.id.site_en);
                    if (tab.getPosition() == 0) {
                        selectLangEn.setVisibility(View.GONE);
                        canChangeEn.setVisibility(View.GONE);
                        langEn.setVisibility(View.GONE);
                        siteEn.setVisibility(View.GONE);

                        selectLangAr.setVisibility(View.VISIBLE);
                        canChangeAr.setVisibility(View.VISIBLE);
                        langAr.setVisibility(View.VISIBLE);
                        siteAr.setVisibility(View.VISIBLE);
                    } else {
                        selectLangAr.setVisibility(View.GONE);
                        canChangeAr.setVisibility(View.GONE);
                        langAr.setVisibility(View.GONE);
                        siteAr.setVisibility(View.GONE);

                        selectLangEn.setVisibility(View.VISIBLE);
                        canChangeEn.setVisibility(View.VISIBLE);
                        langEn.setVisibility(View.VISIBLE);
                        siteEn.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {
                }
            });

            Spinner langSpinner = (Spinner) firstRunLayout.findViewById(R.id.dialog_langs);
            Spinner sitesSpinner = (Spinner) firstRunLayout.findViewById(R.id.dialog_sites);

            ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
            ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.sites, android.R.layout.simple_spinner_item);

            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            langSpinner.setAdapter(adapter1);
            sitesSpinner.setAdapter(adapter2);

            langSpinner.setSelection(sharedPreferences.getInt("lang", 0));
            sitesSpinner.setSelection(sharedPreferences.getInt("site", 13));

            langSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position != sharedPreferences.getInt("lang", 0)) {
                        editor.putInt("lang", position);
                        editor.apply();
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });

            sitesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position != sharedPreferences.getInt("site", 13)) {
                        editor.putInt("site", position);
                        editor.apply();
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });

            builder.setView(firstRunLayout);
            builder.setCancelable(false);
            builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    editor.putBoolean("FirstRun", false);
                    editor.apply();
                    editor.putBoolean("Change1", false);
                    editor.apply();
                    finish();
                    startActivity(getIntent());
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        } else {
            if (sharedPreferences.getBoolean("Change1", true)) {
                editor.remove("langChanged");
                editor.apply();
                switch (sharedPreferences.getInt("site", 16)) {
                    case 1:
                    case 6:
                    case 7:
                    case 16:
                        editor.putInt("site", 13);
                        editor.apply();
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        editor.putInt("site", sharedPreferences.getInt("site", 16) - 1);
                        editor.apply();
                        break;
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        editor.putInt("site", sharedPreferences.getInt("site", 16) - 3);
                        editor.apply();
                        break;
                    default:
                        break;
                }
                editor.putBoolean("Change1", false);
                editor.apply();
            }
            editor.putBoolean("settingsChanged", false);
            editor.apply();
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            if (sharedPreferences.getInt("lang", 0) == 0) {
                conf.locale = new Locale("ar");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    conf.setLayoutDirection(conf.locale);
                }
            } else {
                conf.locale = new Locale("en");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    conf.setLayoutDirection(conf.locale);
                }
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

            View headerView = navigationView.inflateHeaderView(R.layout.nav_header_main);
            ImageView logo = (ImageView) headerView.findViewById(R.id.imageView);
            logo.setImageResource(((MyApplication) MainActivity.this.getApplication()).getLogo());

            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new StartFragment(), "FragmentStart").commit();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            StartFragment startFragment = (StartFragment) getSupportFragmentManager().findFragmentByTag("FragmentStart");
            HoldingsFragment holdingsFragment = (HoldingsFragment) getSupportFragmentManager().findFragmentByTag("FragmentHoldings");
            //InternetSearchFragment internetSearchFragment = (InternetSearchFragment) getSupportFragmentManager().findFragmentByTag("FragmentInternetSearch");

            ThesesFragment thesesFragment = (ThesesFragment) getSupportFragmentManager().findFragmentByTag("FragmentTheses");
            DraftThesesFragment draftThesesFragment = (DraftThesesFragment) getSupportFragmentManager().findFragmentByTag("FragmentDraftTheses");
            PapersFragment papersFragment = (PapersFragment) getSupportFragmentManager().findFragmentByTag("FragmentPapers");
            LocalJournalsFragment localJournalsFragment = (LocalJournalsFragment) getSupportFragmentManager().findFragmentByTag("FragmentLocalJournals");

            DigitalContentsFragment digitalContentsFragment = (DigitalContentsFragment) getSupportFragmentManager().findFragmentByTag("FragmentDigitalContents");
            if (navigationView.getMenu().getItem(0).isChecked()) {
                if (startFragment.getLayoutVisibility()) {
                    startFragment.showSearch();
                } else {
                    startFragment.stopRequest(true);
                    super.onBackPressed();
                }
            } else if (navigationView.getMenu().getItem(1).isChecked() && holdingsFragment.getLayoutVisibility()) {
                holdingsFragment.showSearch();
            } /*else if (navigationView.getMenu().getItem(2).isChecked() && internetSearchFragment.getLayoutVisibility()) {
                internetSearchFragment.showSearch();
            }*/ else if (navigationView.getMenu().getItem(2).isChecked() && thesesFragment.getLayoutVisibility()) {
                thesesFragment.showSearch();
            } else if (navigationView.getMenu().getItem(3).isChecked() && draftThesesFragment.getLayoutVisibility()) {
                draftThesesFragment.showSearch();
            } else if (navigationView.getMenu().getItem(4).isChecked() && papersFragment.getLayoutVisibility()) {
                papersFragment.showSearch();
            } else if (navigationView.getMenu().getItem(5).isChecked() && localJournalsFragment.getLayoutVisibility()) {
                localJournalsFragment.showSearch();
            } else if (navigationView.getMenu().getItem(6).isChecked() && digitalContentsFragment.getLayoutVisibility()) {
                digitalContentsFragment.showSearch();
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
        } /*else if (id == R.id.nav_internet_search) {
            fragment = new InternetSearchFragment();
            tag = "FragmentInternetSearch";
        } else if (id == R.id.nav_databases) {
            fragment = new DatabasesFragment();
            tag = "FragmentDatabases";
        }*/ else if (id == R.id.nav_thesis) {
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
        } /*else if (id == R.id.nav_e_publish) {
            fragment = new EPublishFragment();
            tag = "FragmentEPublish";
        }*/ else if (id == R.id.nav_digital_contents) {
            fragment = new DigitalContentsFragment();
            tag = "FragmentDigitalContents";
        } /*else if (id == R.id.nav_my_account) {
            fragment = new MyAccountFragment();
            tag = "FragmentMyAccount";
        }*/ else if (id == R.id.nav_settings) {
            item.setChecked(false);
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
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
        if (sharedPreferences.getBoolean("settingsChanged", false)) {
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            if (sharedPreferences.getInt("lang", 0) == 0) {
                conf.locale = new Locale("ar");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    conf.setLayoutDirection(conf.locale);
                }
            } else {
                conf.locale = new Locale("en");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    conf.setLayoutDirection(conf.locale);
                }
            }
            res.updateConfiguration(conf, dm);
            finish();
            startActivity(getIntent());
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
        }
    }

    public void setSelectedItem(int position) {
        navigationView.getMenu().getItem(position).setChecked(true);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        if (sharedPreferences.getInt("lang", 0) == 0) {
            conf.locale = new Locale("ar");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                conf.setLayoutDirection(conf.locale);
            }
        } else {
            conf.locale = new Locale("en");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                conf.setLayoutDirection(conf.locale);
            }
        }
        res.updateConfiguration(conf, dm);
    }
}
