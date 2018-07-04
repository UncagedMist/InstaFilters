package kk.techbytecare.instafilters.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import kk.techbytecare.instafilters.R;

public class ThumbnailViewHolder extends RecyclerView.ViewHolder {

    public TextView filter_name;
    public ImageView thumbnail;

    public ThumbnailViewHolder(View itemView) {
        super(itemView);

        filter_name = itemView.findViewById(R.id.filter_name);
        thumbnail = itemView.findViewById(R.id.thumbnail);
    }
}
