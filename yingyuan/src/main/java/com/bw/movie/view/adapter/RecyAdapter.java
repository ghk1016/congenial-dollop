package com.bw.movie.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.model.bean.ShangMovieBean;
import com.bw.movie.view.activity.MovieActivity;
import com.bw.movie.view.movies.DetailsMovie;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * 作者： 姓名
 * 日期： 2019/10/10 19:53
 */
public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.ViewHolder> {
    private List<ShangMovieBean.ResultBean> list;
    private Context context;

    public RecyAdapter(List<ShangMovieBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.tv.setText(list.get(i).name);
        Glide.with(context).load(list.get(i).imageUrl).into(viewHolder.img);
        viewHolder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MovieActivity.class);
                context.startActivity(intent);
            }
        });
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnItem.setOn(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView tv;
        private final Button btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.recy1_img);
            tv = itemView.findViewById(R.id.recy1_tv);
            btn = itemView.findViewById(R.id.recy1_btn);
        }
    }
    public interface setOnItem{
        void setOn(int position);
    }
    private setOnItem setOnItem;

    public void setSetOnItem(RecyAdapter.setOnItem setOnItem) {
        this.setOnItem = setOnItem;
    }
}