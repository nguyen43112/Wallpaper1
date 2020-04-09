package com.macbook.wallpaper.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.macbook.wallpaper.R;
import com.macbook.wallpaper.model.Photo;

import java.util.List;

import uk.co.senab.photoview.PhotoView;

public class SlidePagerAdapter extends PagerAdapter {
    private Context context;
    private List<Photo> listPhotos;
    private LayoutInflater inflater;

    public SlidePagerAdapter(Context context, List<Photo> listPhotos) {
        this.context = context;
        this.listPhotos = listPhotos;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return listPhotos.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.item_slide, view, false);
        assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout
                .findViewById(R.id.image);

        Glide.with(context)
                .load(listPhotos.get(position).getUrlL())
                .into(imageView);

        view.addView(imageLayout, 0);

        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
}
