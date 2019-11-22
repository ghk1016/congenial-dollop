package com.bw.movie.homefrag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.model.bean.QueryRegionBean;
import com.bw.movie.model.bean.RegionCinemaBean;
import com.bw.movie.presenter.RegionCinemaPresenter;
import com.bw.movie.view.interfaces.IMainView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者： 姓名
 * 日期： 2019/10/11 15:52
 */
public class Thridfag extends Fragment implements IMainView.IRegionCinema {
    @BindView(R.id.thrid_recy1)
    RecyclerView thridRecy1;
    @BindView(R.id.thrid_recy2)
    RecyclerView thridRecy2;
    Unbinder unbinder;
    private RegionCinemaPresenter regionCinemaPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.thrid_activity, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        regionCinemaPresenter = new RegionCinemaPresenter();
        regionCinemaPresenter.attach(this);
        regionCinemaPresenter.getDatee();
        return inflate;
    }

    @Override
    public void region(QueryRegionBean queryRegionBean) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        thridRecy1.setLayoutManager(linearLayoutManager);
        final List<QueryRegionBean.ResultBean> result = queryRegionBean.result;
        ThridAdapter thridAdapter = new ThridAdapter(result, getActivity());
        thridAdapter.setSetOnItemCilck(new ThridAdapter.setOnItemCilck() {
            @Override
            public void onItemClick(int position) {
                int regionId = result.get(position).regionId;
                regionCinemaPresenter.getDate(regionId);
            }
        });
        thridRecy1.setAdapter(thridAdapter);
    }

    @Override
    public void regioncinema(RegionCinemaBean regionCinemaBean) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        thridRecy2.setLayoutManager(linearLayoutManager);
        List<RegionCinemaBean.ResultBean> result = regionCinemaBean.result;
        ThridChildAdapter thridChildAdapter = new ThridChildAdapter(result, getActivity());
        thridRecy2.setAdapter(thridChildAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
