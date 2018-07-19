package kk.techbytecare.instafilters.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import kk.techbytecare.instafilters.Interface.ColorAdapterListener;
import kk.techbytecare.instafilters.R;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ColorViewHolder> {

    private Context context;
    private List<Integer> colorList;
    private ColorAdapterListener listener;

    public ColorAdapter(Context context, ColorAdapterListener listener) {
        this.context = context;
        this.colorList = getColorList();
        this.listener = listener;
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.color_item,parent,false);

        return new ColorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int position) {
        holder.color_section.setCardBackgroundColor(colorList.get(position));
    }

    @Override
    public int getItemCount() {
        return colorList.size();
    }

    private List<Integer> getColorList() {
        List<Integer> colorList = new ArrayList<>();

        colorList.add(Color.parseColor("#000000"));
        colorList.add(Color.parseColor("#ffc0cb"));
        colorList.add(Color.parseColor("#ffffff"));
        colorList.add(Color.parseColor("#008080"));
        colorList.add(Color.parseColor("#ffe4e1"));
        colorList.add(Color.parseColor("#ff0000"));
        colorList.add(Color.parseColor("#ffd700"));
        colorList.add(Color.parseColor("#00ffff"));
        colorList.add(Color.parseColor("#40e0d0"));
        colorList.add(Color.parseColor("#ff7373"));
        colorList.add(Color.parseColor("#e6e6fa"));
        colorList.add(Color.parseColor("#d3ffce"));
        colorList.add(Color.parseColor("#0000ff"));
        colorList.add(Color.parseColor("#f0f8ff"));
        colorList.add(Color.parseColor("#ffa500"));
        colorList.add(Color.parseColor("#b0e0e6"));
        colorList.add(Color.parseColor("#7fffd4"));
        colorList.add(Color.parseColor("#faebd7"));
        colorList.add(Color.parseColor("#c6e2ff"));
        colorList.add(Color.parseColor("#cccccc"));
        colorList.add(Color.parseColor("#eeeeee"));
        colorList.add(Color.parseColor("#800080"));

        colorList.add(Color.parseColor("#fa8072"));
        colorList.add(Color.parseColor("#ffb6c1"));
        colorList.add(Color.parseColor("#800000"));
        colorList.add(Color.parseColor("#333333"));
        colorList.add(Color.parseColor("#00ff00"));
        colorList.add(Color.parseColor("#003366"));
        colorList.add(Color.parseColor("#c0c0c0"));
        colorList.add(Color.parseColor("#ffff00"));
        colorList.add(Color.parseColor("#20b2aa"));
        colorList.add(Color.parseColor("#f08080"));
        colorList.add(Color.parseColor("#ffc3a0"));
        colorList.add(Color.parseColor("#fff68f"));
        colorList.add(Color.parseColor("#f6546a"));
        colorList.add(Color.parseColor("#468499"));
        colorList.add(Color.parseColor("#ff6666"));
        colorList.add(Color.parseColor("#66cdaa"));
        colorList.add(Color.parseColor("#666666"));
        colorList.add(Color.parseColor("#c39797"));
        colorList.add(Color.parseColor("#00ced1"));
        colorList.add(Color.parseColor("#ffdab9"));

        colorList.add(Color.parseColor("#ff00ff"));
        colorList.add(Color.parseColor("#008000"));
        colorList.add(Color.parseColor("#088da5"));
        colorList.add(Color.parseColor("#660066"));
        colorList.add(Color.parseColor("#c0d6e4"));
        colorList.add(Color.parseColor("#f5f5f5"));
        colorList.add(Color.parseColor("#0e2f44"));
        colorList.add(Color.parseColor("#808080"));
        colorList.add(Color.parseColor("#8b0000"));
        colorList.add(Color.parseColor("#ff7f50"));
        colorList.add(Color.parseColor("#afeeee"));
        colorList.add(Color.parseColor("#dddddd"));
        colorList.add(Color.parseColor("#b4eeb4"));
        colorList.add(Color.parseColor("#b4eeb4"));
        colorList.add(Color.parseColor("#990000"));
        colorList.add(Color.parseColor("#cbbeb5"));
        colorList.add(Color.parseColor("#daa520"));
        colorList.add(Color.parseColor("#ffff66"));
        colorList.add(Color.parseColor("#f5f5dc"));
        colorList.add(Color.parseColor("#00ff7f"));
        colorList.add(Color.parseColor("#b6fcd5"));
        colorList.add(Color.parseColor("#66cccc"));
        colorList.add(Color.parseColor("#8a2be2"));
        colorList.add(Color.parseColor("#81d8d0"));
        colorList.add(Color.parseColor("#ff4040"));
        colorList.add(Color.parseColor("#3399ff"));
        colorList.add(Color.parseColor("#a0db8e"));
        colorList.add(Color.parseColor("#794044"));
        colorList.add(Color.parseColor("#cc0000"));
        colorList.add(Color.parseColor("#ccff00"));
        colorList.add(Color.parseColor("#000080"));
        colorList.add(Color.parseColor("#3b5998"));
        colorList.add(Color.parseColor("#999999"));
        colorList.add(Color.parseColor("#191970"));
        colorList.add(Color.parseColor("#31698a"));
        colorList.add(Color.parseColor("#6897bb"));
        colorList.add(Color.parseColor("#0099cc"));
        colorList.add(Color.parseColor("#f7f7f7"));
        colorList.add(Color.parseColor("#ff4444"));
        colorList.add(Color.parseColor("#fef65b"));
        colorList.add(Color.parseColor("#ff1493"));
        colorList.add(Color.parseColor("#191919"));
        colorList.add(Color.parseColor("#6dc066"));

//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));
//        colorList.add(Color.parseColor("#"));

        return colorList;
    }

    public class ColorViewHolder extends RecyclerView.ViewHolder {

        public CardView color_section;

        ColorViewHolder(View itemView) {
            super(itemView);

            color_section = itemView.findViewById(R.id.color_section);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onColorSelected(colorList.get(getAdapterPosition()));
                }
            });
        }
    }
}
