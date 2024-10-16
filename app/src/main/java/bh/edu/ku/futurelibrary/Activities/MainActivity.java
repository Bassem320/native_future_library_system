package bh.edu.ku.futurelibrary.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.Locale;

import bh.edu.ku.futurelibrary.Fragments.BarcodeFragment;
import bh.edu.ku.futurelibrary.Fragments.DigitalContentsFragment;
import bh.edu.ku.futurelibrary.Fragments.DraftThesesFragment;
import bh.edu.ku.futurelibrary.Fragments.HoldingsFragment;
import bh.edu.ku.futurelibrary.Fragments.LocalJournalsFragment;
import bh.edu.ku.futurelibrary.Fragments.PapersFragment;
import bh.edu.ku.futurelibrary.Fragments.QrFragment;
import bh.edu.ku.futurelibrary.Fragments.StartFragment;
import bh.edu.ku.futurelibrary.Fragments.ThesesFragment;
import bh.edu.ku.futurelibrary.R;

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
            TabLayout tabLayout = firstRunLayout.findViewById(R.id.firstRunTabLayout);
            tabLayout.addTab(tabLayout.newTab().setText("عربي"));
            tabLayout.addTab(tabLayout.newTab().setText("English"));
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    TextView selectLangAr = firstRunLayout.findViewById(R.id.select_lang_ar);
                    TextView selectLangEn = firstRunLayout.findViewById(R.id.select_lang_en);
                    TextView canChangeAr = firstRunLayout.findViewById(R.id.can_change_ar);
                    TextView canChangeEn = firstRunLayout.findViewById(R.id.can_change_en);
                    TextView langAr = firstRunLayout.findViewById(R.id.lang_ar);
                    TextView langEn = firstRunLayout.findViewById(R.id.lang_en);
                    if (tab.getPosition() == 0) {
                        selectLangEn.setVisibility(View.GONE);
                        canChangeEn.setVisibility(View.GONE);
                        langEn.setVisibility(View.GONE);

                        selectLangAr.setVisibility(View.VISIBLE);
                        canChangeAr.setVisibility(View.VISIBLE);
                        langAr.setVisibility(View.VISIBLE);
                    } else {
                        selectLangAr.setVisibility(View.GONE);
                        canChangeAr.setVisibility(View.GONE);
                        langAr.setVisibility(View.GONE);

                        selectLangEn.setVisibility(View.VISIBLE);
                        canChangeEn.setVisibility(View.VISIBLE);
                        langEn.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {
                }
            });

            Spinner langSpinner = firstRunLayout.findViewById(R.id.dialog_langs);

            ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);

            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            langSpinner.setAdapter(adapter1);

            langSpinner.setSelection(sharedPreferences.getInt("lang", 0));

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

            builder.setView(firstRunLayout);
            builder.setCancelable(false);
            builder.setNeutralButton("OK", (dialog, which) -> {
                editor.putBoolean("FirstRun", false);
                editor.apply();
                editor.putBoolean("Change1", false);
                editor.apply();
                finish();
                startActivity(getIntent());
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        } else {
            editor.putBoolean("settingsChanged", false);
            editor.apply();
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            Locale newLocale;
            if (sharedPreferences.getInt("lang", 0) == 0) {
                newLocale = new Locale("ar");
            } else {
                newLocale = new Locale("en");
            }
            conf.setLocale(newLocale);
            conf.setLayoutDirection(newLocale);
            LocaleList localeList = new LocaleList(newLocale);
            LocaleList.setDefault(localeList);
            conf.setLocales(localeList);
            res.updateConfiguration(conf, dm);
            setContentView(R.layout.activity_main);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            navigationView = findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);

            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new StartFragment(), "FragmentStart").commit();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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
            BarcodeFragment barcodeFragment = (BarcodeFragment) getSupportFragmentManager().findFragmentByTag("FragmentBarcode");
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
            } else if (navigationView.getMenu().getItem(7).isChecked() && barcodeFragment.getLayoutVisibility()) {
                barcodeFragment.showSearch();
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

//    @SuppressWarnings("StatementWithEmptyBody")
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
        }*/ else if (id == R.id.nav_barcode) {
            fragment = new BarcodeFragment();
            tag = "FragmentBarcode";
        } else if (id == R.id.nav_qr) {
            fragment = new QrFragment();
            tag = "FragmentQr";
        } else if (id == R.id.nav_settings) {
            item.setChecked(false);
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment, tag).commit();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sharedPreferences.getBoolean("settingsChanged", false)) {
            editor.remove("siteNewsList");
            editor.apply();
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            Locale newLocale;
            if (sharedPreferences.getInt("lang", 0) == 0) {
                newLocale = new Locale("ar");
            } else {
                newLocale = new Locale("en");
            }
            conf.setLocale(newLocale);
            conf.setLayoutDirection(newLocale);
            LocaleList localeList = new LocaleList(newLocale);
            LocaleList.setDefault(localeList);
            conf.setLocales(localeList);
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
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        Locale newLocale;
        if (sharedPreferences.getInt("lang", 0) == 0) {
            newLocale = new Locale("ar");
        } else {
            newLocale = new Locale("en");
        }
        conf.setLocale(newLocale);
        conf.setLayoutDirection(newLocale);
        LocaleList localeList = new LocaleList(newLocale);
        LocaleList.setDefault(localeList);
        conf.setLocales(localeList);
        res.updateConfiguration(conf, dm);
    }

    public void setConfig() {
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        Locale newLocale;
        if (sharedPreferences.getInt("lang", 0) == 0) {
            newLocale = new Locale("ar");
        } else {
            newLocale = new Locale("en");
        }
        conf.setLocale(newLocale);
        conf.setLayoutDirection(newLocale);
        LocaleList localeList = new LocaleList(newLocale);
        LocaleList.setDefault(localeList);
        conf.setLocales(localeList);
        // Update context with the new configuration
        res.updateConfiguration(conf, dm);
    }
}
