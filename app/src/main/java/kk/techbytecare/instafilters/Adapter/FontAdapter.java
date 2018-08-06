package kk.techbytecare.instafilters.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kk.techbytecare.instafilters.Interface.FontAdapterClickListener;
import kk.techbytecare.instafilters.R;

public class FontAdapter extends RecyclerView.Adapter<FontAdapter.FontViewHolder> {

    private Context context;
    private FontAdapterClickListener listener;
    private List<String> fontList;

    private int row_selected = -1;

    public FontAdapter(Context context, FontAdapterClickListener listener) {
        this.context = context;
        this.listener = listener;
        fontList = loadFontList();
    }

    private List<String> loadFontList() {
        List<String> result = new ArrayList<>();

        result.add("8bitlim.ttf");
        result.add("11S0BLTI.TTF");
        result.add("12tonsushi.ttf");
        result.add("Aaargh.ttf");
        result.add("ABBERANC.TTF");
        result.add("ABEAKRG.TTF");
        result.add("absci___.ttf");
        result.add("abscib__.ttf");
        result.add("accid__.ttf");
        result.add("Action Man Bold.ttf");
        result.add("Action_Force.ttf");
        result.add("ADD-JAZZ.TTF");
        result.add("AdineKirnberg-Script.ttf");
        result.add("AdobeGothicStd-Bold.otf");
        result.add("AdobeHeitiStd-Regular.otf");
        result.add("advent-Lt1.otf");
        result.add("advent-Lt3.otf");
        result.add("advent-Re.otf");
        result.add("Adventure.ttf");
        result.add("Advokat Modern.ttf");
        result.add("Aerovias Brasil NF.ttf");
        result.add("aggstock.ttf");
        result.add("Aileenation.ttf");
        result.add("AIR_____.TTF");
        result.add("AldotheApache.ttf");
        result.add("ALEXA.TTF");
        result.add("Alice and the Wicked Monster.ttf");
        result.add("ALIEES__.TTF");
        result.add("ALIEESB_.TTF");
        result.add("ALIEESBI.TTF");
        result.add("ALIEESI_.TTF");
        result.add("ALIEN5.TTF");
        result.add("Aliquam.ttf");
        result.add("AliquamREG.ttf");
        result.add("AliquamRit.ttf");
        result.add("Aliquamulti.ttf");
        result.add("AllCaps.ttf");
        result.add("Alpha Thin.ttf");
        result.add("AmazOOSTROVFine.ttf");
        result.add("American Captain.ttf");
        result.add("Anabelle Script Light.otf");
        result.add("Ancillary-Bold.otf");
        result.add("ANDOVER_.TTF");
        result.add("AnkeHand.ttf");
        result.add("annifont.ttf");
        result.add("ap.ttf");
        result.add("ARCHBLC_.TTF");
        result.add("arialbd.ttf");
        result.add("ARMOPB__.TTF");
        result.add("Artbrush.ttf");
        result.add("Atlantic_Cruise-Demo.ttf");
        result.add("ATOMIC__.TTF");
        result.add("ATROX.TTF");
        result.add("autobahn.ttf");
        result.add("AVENGEANCE MIGHTIEST AVENGER.otf");
        result.add("AZRAEL__.TTF");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");
//        result.add("");


        return result;
    }

    @NonNull
    @Override
    public FontViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.font_item,parent,false);

        return new FontViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FontViewHolder holder, int position) {
        if (row_selected == position)   {
            holder.img_check.setVisibility(View.VISIBLE);
        }
        else    {
            holder.img_check.setVisibility(View.INVISIBLE);
        }

        Typeface typeface = Typeface.createFromAsset(context.getAssets(),new StringBuilder("fonts/")
                .append(fontList.get(position)).toString());

        holder.txt_font_name.setText(fontList.get(position));
        holder.txt_font.setTypeface(typeface);
    }

    @Override
    public int getItemCount() {
        return fontList.size();
    }

    public class FontViewHolder extends RecyclerView.ViewHolder {

        TextView txt_font,txt_font_name;
        ImageView img_check;

        public FontViewHolder(View itemView) {
            super(itemView);

            txt_font_name = itemView.findViewById(R.id.txt_font_name);
            txt_font = itemView.findViewById(R.id.txt_font);

            img_check = itemView.findViewById(R.id.img_check);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onFontSelected(fontList.get(getAdapterPosition()));
                    row_selected = getAdapterPosition();
                    notifyDataSetChanged();
                }
            });
        }
    }
}
