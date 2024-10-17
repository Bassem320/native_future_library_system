package bh.edu.ku.futurelibrary.FragmentsDialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import bh.edu.ku.futurelibrary.Objects.ResultsStartItem;
import bh.edu.ku.futurelibrary.R;

/**
 * Created by Eslam El-Meniawy on 01-Dec-15.
 */
public class FragmentDialog extends DialogFragment {
    private SectionsPagerAdapter sectionsPagerAdapter;
    private ViewPager viewPager;
    ResultsStartItem item;

    static FragmentDialog newInstance(ResultsStartItem item) {
        FragmentDialog f = new FragmentDialog();

        Bundle args = new Bundle();
        args.putParcelable("item", item);
        f.setArguments(args);

        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        item = getArguments().getParcelable("item");
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_start_results, container);

        sectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());

        viewPager = view.findViewById(R.id.detailsPager);
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabLayout = view.findViewById(R.id.detailsTabLayout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.search_results_title));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.search_results_details));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.search_results_holdings));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.search_results_services));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        return view;
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("item", item);
            switch (position) {
                case 0:
                    TabFragment1 tab1 = new TabFragment1();
                    tab1.setArguments(bundle);
                    return tab1;
                case 1:
                    TabFragment2 tab2 = new TabFragment2();
                    tab2.setArguments(bundle);
                    return tab2;
                case 2:
                    TabFragment3 tab3 = new TabFragment3();
                    tab3.setArguments(bundle);
                    return tab3;
                case 3:
                    TabFragment4 tab4 = new TabFragment4();
                    tab4.setArguments(bundle);
                    return tab4;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
