package com.macbook.wallpaper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.macbook.wallpaper.R;
import com.macbook.wallpaper.model.Photo;

import java.util.List;

public class WallpaperAdapter extends RecyclerView.Adapter<WallpaperAdapter.ViewHolder> {
    private List<Photo> list;
    private Context context;
    private AdapterListener adapterListener;

    public WallpaperAdapter(List<Photo> list, Context context, AdapterListener adapterListener) {
        this.list = list;
        this.context = context;
        this.adapterListener = adapterListener;
    }

        public interface AdapterListener{
            void OnClick(int position);
        }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        try {
            Glide.with(context).load(list.get(position).getUrlL()).centerCrop().into(holder.img);
            holder.tvView.setText(list.get(position).getViews());
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapterListener.OnClick(position);
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvView;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgPost);
            tvView = itemView.findViewById(R.id.tvView);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
