package com.example.armint.testtutor;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

/**
 * ****note guys ******
 * This is the Activity that holds all the framing stuffs.
 * It is the framework, it creates the tabbed fragment changer.
 * Furthermore, if you want to make any changes to the layout, like
 * add stuff such as a search bar, this is the place to do it and it's corresponding
 * xml file which is activity_user_view.
 * ****note over friend devs********
 */
public class UserView extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view);

        TabLayout tablayout;
        ViewPager viewPager;

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);


        tablayout = (TabLayout)findViewById(R.id.tabs);
        tablayout.setupWithViewPager(viewPager);
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TutorViewFrag(), "ONE");
        adapter.addFragment(new TutoreeViewFrag(), "TWO");
        adapter.addFragment(new OptionsViewFrag(), "THREE");
        viewPager.setAdapter(adapter);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList      = new ArrayList<>();
        private final List<String>   mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position );
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
