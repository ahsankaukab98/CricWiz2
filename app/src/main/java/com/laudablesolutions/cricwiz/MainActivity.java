package com.laudablesolutions.cricwiz;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.laudablesolutions.cricwiz.Fragments.FixturesFragment;
import com.laudablesolutions.cricwiz.Fragments.LiveMatchesFragment;
import com.laudablesolutions.cricwiz.Fragments.NewsFragment;
import com.laudablesolutions.cricwiz.Fragments.StandingsFragment;
import com.laudablesolutions.cricwiz.Fragments.StatisticsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tablayout)
    TabLayout mTabLayout;

    @BindView(R.id.pager)
    ViewPager mViewpager;

    @BindView(R.id.main_toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        mTabLayout.addTab(mTabLayout.newTab().setText(getResources().getString(R.string.news)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getResources().getString(R.string.live_matches)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getResources().getString(R.string.statistics)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getResources().getString(R.string.fixtures)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getResources().getString(R.string.standings)));
        mTabLayout.setTabGravity(mTabLayout.GRAVITY_FILL);

        MyPagerAdapter adapter;
        adapter = new MyPagerAdapter(getSupportFragmentManager(), 5);
        mViewpager.setAdapter(adapter);

        mViewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {


            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                mViewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {
        int mNumOfTabs;

        public MyPagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    NewsFragment newsFragment = new NewsFragment();
                    return newsFragment;

                case 1:
                    LiveMatchesFragment liveMatchesFragment = new LiveMatchesFragment();
                    return liveMatchesFragment;

                case 2:
                    StatisticsFragment statisticsFragment = new StatisticsFragment();
                    return statisticsFragment;

                case 3:
                    FixturesFragment fixturesFragment = new FixturesFragment();
                    return fixturesFragment;

                case 4:
                    StandingsFragment standingsFragment = new StandingsFragment();
                    return standingsFragment;

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }
}
