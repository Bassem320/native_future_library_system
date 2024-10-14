package eg.edu.eulc.librarysystem;

import android.app.Application;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.core.app.ApplicationProvider;

import android.app.Application;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(AndroidJUnit4.class)
public class ApplicationTest {
    @Test
    public void testApplication() {
        // Use ApplicationProvider to get the application context
        Application application = ApplicationProvider.getApplicationContext();

        // Add your test logic here
        assertNotNull(application);
    }
}