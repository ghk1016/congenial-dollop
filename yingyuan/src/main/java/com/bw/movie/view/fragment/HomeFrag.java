package com.bw.movie.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.homefrag.Homefag;
import com.bw.movie.homefrag.MyAdapter;
import com.bw.movie.homefrag.Otherfag;
import com.bw.movie.homefrag.Thridfag;
import com.bw.movie.view.movies.SearchCinemaActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者： 姓名
 * 日期： 2019/10/10 16:42
 */
public class HomeFrag extends Fragment {
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.moview_view)
    ViewPager moviewView;
    Unbinder unbinder;
    @BindView(R.id.home_search)
    ImageView homeSearch;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.homefrg, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        List<String> list = new ArrayList<>();
        list.add("推荐影院");
        list.add("附近影院");
        list.add("海淀区▼");
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new Homefag());
        fragmentList.add(new Otherfag());
        fragmentList.add(new Thridfag());
        MyAdapter myAdapter = new MyAdapter(getFragmentManager(), list, fragmentList);
        moviewView.setAdapter(myAdapter);
        tab.setupWithViewPager(moviewView);
        homeSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchCinemaActivity.class);
                startActivity(intent);
            }
        });
        return inflate;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
