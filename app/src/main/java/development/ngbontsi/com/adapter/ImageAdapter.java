package development.ngbontsi.com.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import development.ngbontsi.com.R;

/**
 * Created by ndimphiwe.bontsi on 2018/02/12.
 */

public class ImageAdapter extends BaseAdapter {

    private Context context;
    public Integer[] imagesId = {R.drawable.maintenance,R.drawable.anouncments,R.drawable.fan_base,R.drawable.stats_icon};


    public ImageAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        return imagesId.length;
    }

    @Override
    public Object getItem(int position) {
        return imagesId[position];
    }

    @Override
    public long getItemId(int position) {
        return imagesId[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AppCompatImageView imageView = new AppCompatImageView(context);
        imageView.setImageResource(imagesId[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(70,70));


        return imageView;
    }
}
