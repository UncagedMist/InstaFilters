package kk.techbytecare.instafilters.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.github.rockerhieu.emojicon.EmojiconTextView;
import kk.techbytecare.instafilters.Interface.EmojiAdapterListener;
import kk.techbytecare.instafilters.R;

public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.EmojiViewHolder> {

    private Context context;
    private List<String> emojiList;
    private EmojiAdapterListener listener;

    public EmojiAdapter(Context context, List<String> emojiList, EmojiAdapterListener listener) {
        this.context = context;
        this.emojiList = emojiList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public EmojiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.emoji_item,parent,false);

        return new EmojiViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EmojiViewHolder holder, int position) {
        holder.emoji_text_view.setText(emojiList.get(position));
    }

    @Override
    public int getItemCount() {
        return emojiList.size();
    }

    public class EmojiViewHolder extends RecyclerView.ViewHolder {

        public EmojiconTextView emoji_text_view;

        EmojiViewHolder(View itemView) {
            super(itemView);

            emoji_text_view = itemView.findViewById(R.id.emoji_text_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onEmojiItemSelected(emojiList.get(getAdapterPosition()));
                }
            });
        }
    }
}
