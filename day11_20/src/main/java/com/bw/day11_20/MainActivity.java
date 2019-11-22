package com.bw.day11_20;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tab;
    private ViewPager vp;
    private List<String> datas = new ArrayList<String>();
    private String[] status = new String[]{"0","1","3","4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab = findViewById(R.id.tab);
        vp = findViewById(R.id.vp);
        datas.add("11-20");
        datas.add("11-21");
        datas.add("11-22");
        datas.add("11-23");
        vp.setAdapter(new MyAdapter(getSupportFragmentManager()));
        tab.setupWithViewPager(vp);
    }
    class MyAdapter extends FragmentPagerAdapter{
        public MyAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return datas.get(position);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            Bundle bundle = new Bundle();
            bundle.putString("url",status[position]);
            AllFragment allFragment = new AllFragment();
            allFragment.setArguments(bundle);
            return allFragment;
        }


    }
}
