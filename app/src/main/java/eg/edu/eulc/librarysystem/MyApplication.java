package eg.edu.eulc.librarysystem;

import android.app.Application;
import android.content.Context;

/**
 * Created by Eslam El-Meniawy on 25-Oct-15.
 */
public class MyApplication extends Application {
    public static final String PREF_FILE_NAME = "LibrarySystemPref";
    private static MyApplication sInstance;

    public static MyApplication getInstance() {
        return sInstance;
    }

    public static Context getAppContext() {
        return sInstance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public String getServerName() {
        String[] servers = {"http://slbapp.kfu.edu.sa/KFU_v6/", "http://www.aradoportal.org.eg/Fuls_v5/", "http://main.eulc.edu.eg/eulc_v5/", "http://library.asu.edu.bh/asu/", "http://library.ku.edu.bh/KUv5/", "http://www.library.su.edu.eg/suV4/", "http://www.nublibrary.com/NUB/", "http://www.nublibrary.com/NUB/", "http://main.eulc.edu.eg/eulc_v5/", "http://main.eulc.edu.eg/eulc_v5/", "http://main.eulc.edu.eg/eulc_v5/", "http://main.eulc.edu.eg/eulc_v5/", "http://main.eulc.edu.eg/eulc_v5/", "http://aljwhara.mans.edu.eg/aljwhara/", "http://schools.mans.edu.eg/schoolsNew/", "http://gocp.mans.edu.eg/", "http://www.eulc.edu.eg/demo/"};
        return servers[sInstance.getApplicationContext().getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE).getInt("site", 16)];
    }

    public String getScopeID() {
        String[] scopes = {"1.", "1.", "1.115.", "1.", "1.", "1.", "1.", "1.", "1.23.4.", "1.109.", "1.105.", "1.106.", "1.110.", "1.", "1.", "1.", "1."};
        return scopes[sInstance.getApplicationContext().getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE).getInt("site", 16)];
    }
}
