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
        return "http://library.ku.edu.bh/ku5.5/";
    }

    public String getScopeID() {
        return "1.";
    }
}
