package com.bw.movie.myactivity.morefragment;

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

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.view.activity.MovieActivity;
import com.bw.movie.model.bean.JiMoviewBean;
import com.bw.movie.view.movies.DetailsMovie;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 作者： 姓名
 * 日期： 2019/10/21 19:59
 */
public class BeAdapter extends RecyclerView.Adapter<BeAdapter.Holder> {
    private List<JiMoviewBean.ResultBean> list;
    private Context context;

    public BeAdapter(List<JiMoviewBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item1, null);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int i) {
        holder.tv.setText(list.get(i).name);
        Glide.with(context).load(list.get(i).imageUrl).into(holder.img);
        long releaseTime = list.get(i).releaseTime;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
        String format = simpleDateFormat.format(releaseTime);
        holder.tvv.setText(""+format);
        holder.tvvv.setText(list.get(i).wantSeeNum+"");
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MovieActivity.class);
                context.startActivity(intent);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsMovie.class);
                intent.putExtra("movieId",list.get(i).movieId);
                intent.putExtra("name",list.get(i).name);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        private final ImageView img;
        private final TextView tv;
        private final TextView tvv;
        private final TextView tvvv;
        private final Button btn;
        public Holder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.recy2_img);
            tv = itemView.findViewById(R.id.recy2_tv);
            tvv = itemView.findViewById(R.id.recy2_tvv);
            tvvv = itemView.findViewById(R.id.recy2_tvvv);
            btn = itemView.findViewById(R.id.recy2_btn);
        }
    }
}
