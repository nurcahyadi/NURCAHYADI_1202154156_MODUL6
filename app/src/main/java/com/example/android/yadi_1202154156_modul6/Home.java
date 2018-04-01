package com.example.android.yadi_1202154156_modul6;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    ViewPager VP;
    TabLayout tl;
    AppBarLayout ab;
    FirebaseAuth auth;
    private SectionsPagerAdapter mSectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        VP = findViewById(R.id.vp);
        tl = findViewById(R.id.tabs);
        ab = findViewById(R.id.appbar);
        auth = FirebaseAuth.getInstance();
//        setupPager(VP);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.

        VP.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        VP.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(VP));
    }
//    public void setupPager(ViewPager v) {
//        VPAdapter adapter = new VPAdapter(getSupportFragmentManager());
//        adapter.addFragment(new fraghomeall(), "NEWEST");
//        adapter.addFragment(new fraghomeuser(), "ME");
//
//        v.setAdapter(adapter);
//    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.signout){
            auth.signOut();
            startActivity(new Intent(Home.this, LoginActivity.class));
            finish();
        }
        return true;
    }


    public void post(View view) {
        startActivity(new Intent(Home.this, UploadActivity.class));
    }

    class VPAdapter extends FragmentPagerAdapter{
        private final List<Fragment> listfragment = new ArrayList<>();
        private final List<String> listfragmenttitle = new ArrayList<>();

        public VPAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return listfragment.get(position);
        }
        public void addFragment(Fragment f, String title){
            listfragment.add(f);
            listfragmenttitle.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return listfragmenttitle.get(position);
        }

        @Override
        public int getCount() {
            return listfragment.size();
        }
    }
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    fraghomeall tab1 = new fraghomeall();
                    return tab1;
                case 1:
                    fraghomeuser tab2 = new fraghomeuser();
                    return tab2;

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }
    }
}
