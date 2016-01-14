package eg.edu.eulc.librarysystem.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import eg.edu.eulc.librarysystem.R;

public class SettingsActivity extends AppCompatActivity {
    public static final String PREF_FILE_NAME = "LibrarySystemPref";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sharedPreferences = SettingsActivity.this.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        Spinner langSpinner = (Spinner) findViewById(R.id.lang_spinner);
        Spinner siteSpinner = (Spinner) findViewById(R.id.site_spinner);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.langs, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.sites, android.R.layout.simple_spinner_item);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        langSpinner.setAdapter(adapter1);
        siteSpinner.setAdapter(adapter2);

        langSpinner.setSelection(sharedPreferences.getInt("lang", 0));
        siteSpinner.setSelection(sharedPreferences.getInt("site", 16));

        langSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != sharedPreferences.getInt("lang", 0)) {
                    editor.putInt("lang", position);
                    editor.apply();
                    editor.putBoolean("langChanged", true);
                    editor.apply();
                    SettingsActivity.this.finish();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        siteSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != sharedPreferences.getInt("site", 16)) {
                    editor.putInt("site", position);
                    editor.apply();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

}
