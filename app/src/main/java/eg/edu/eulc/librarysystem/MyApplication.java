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
        //String[] servers = {"http://slbapp.kfu.edu.sa/KFU_v6/", "http://www.aradoportal.org.eg/Fuls_v5/", "http://main.eulc.edu.eg/eulc_v5/", "http://library.asu.edu.bh/ASU6.0/Libraries/", "http://library.ku.edu.bh/ku5.5/Libraries/", "http://su.mans.edu.eg/su/libraries/", "http://www.nublibrary.com/NUB/", "http://www.nublibrary.com/NUB/", "http://main.eulc.edu.eg/eulc_v5/", "http://main.eulc.edu.eg/eulc_v5/", "http://main.eulc.edu.eg/eulc_v5/", "http://main.eulc.edu.eg/eulc_v5/", "http://main.eulc.edu.eg/eulc_v5/", "http://aljwhara.mans.edu.eg/aljwhara/", "http://schools.mans.edu.eg/NewSchools/Libraries/", "http://gocp.mans.edu.eg/Palaces/libraries/", "http://www.eulc.edu.eg/eulc_v5/"};
        String[] servers = {"http://slbapp.kfu.edu.sa/KFU_v6/", "http://main.eulc.edu.eg/eulc_v5/", "http://library.asu.edu.bh/ASU6.0/Libraries/", "http://library.ku.edu.bh/ku5.5/Libraries/", "http://su.mans.edu.eg/su/libraries/", "http://main.eulc.edu.eg/eulc_v5/", "http://main.eulc.edu.eg/eulc_v5/", "http://main.eulc.edu.eg/eulc_v5/", "http://main.eulc.edu.eg/eulc_v5/", "http://main.eulc.edu.eg/eulc_v5/", "http://aljwhara.mans.edu.eg/aljwhara/", "http://schools.mans.edu.eg/NewSchools/Libraries/", "http://gocp.mans.edu.eg/Palaces/libraries/", "http://www.eulc.edu.eg/eulc_v5/"};
        return servers[sInstance.getApplicationContext().getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE).getInt("site", 13)];
    }

    public String getScopeID() {
        //String[] scopes = {"1.", "1.", "1.115.", "1.", "1.", "1.", "1.", "1.", "1.23.4.", "1.109.", "1.105.", "1.106.", "1.110.", "1.", "1.", "1.", "1."};
        String[] scopes = {"1.", "1.115.", "1.", "1.", "1.", "1.23.4.", "1.109.", "1.105.", "1.106.", "1.110.", "1.", "1.", "1.", "1."};
        return scopes[sInstance.getApplicationContext().getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE).getInt("site", 13)];
    }

    public int getLogo() {
        //String[] logos = {R.drawable.logo0, R.drawable.logo1, R.drawable.logo2, R.drawable.logo3, R.drawable.logo4, R.drawable.logo5, R.drawable.logo6, R.drawable.logo6, R.drawable.logo8, R.drawable.logo9, R.drawable.logo10, R.drawable.logo11, R.drawable.logo12, R.drawable.logo13, R.drawable.logo14, R.drawable.logo15, R.drawable.logo16};
        int[] logos = {R.drawable.logo0, R.drawable.logo2, R.drawable.logo3, R.drawable.logo4, R.drawable.logo5, R.drawable.logo8, R.drawable.logo9, R.drawable.logo10, R.drawable.logo11, R.drawable.logo12, R.drawable.logo13, R.drawable.logo14, R.drawable.logo15, R.drawable.logo16};
        return logos[sInstance.getApplicationContext().getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE).getInt("site", 13)];
    }
}
