package com.example.pac_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pac_app.model.Game;

import java.util.List;

public class GameItemAdapter extends RecyclerView.Adapter<GameItemAdapter.ViewHolder> {

    private final Context context;
    private List<Game> gameList;

    public GameItemAdapter(Context context, List<Game> gameList) {
        this.context = context;
        this.gameList = gameList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.game_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Game game = this.gameList.get(position);
        Glide.with(context).load(game.getImgURL()).into(holder.getGameImageView());
        holder.getTextViewTitle().setText(game.getTitle());
        holder.getTextViewPrice().setText(String.valueOf(game.getPrice()));
    }

    @Override
    public int getItemCount() {
        return this.gameList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View root;
        private ImageView gameImageView;
        private TextView textViewTitle;
        private TextView textViewPrice;

        public ViewHolder(@NonNull View gameView) {
            super(gameView);
            this.root = gameView;
            this.gameImageView = gameView.findViewById(R.id.imageGame);
            this.textViewTitle = gameView.findViewById(R.id.textViewName);
            this.textViewPrice = gameView.findViewById(R.id.textViewPrice);
        }

        public ImageView getGameImageView(){
            return  gameImageView;
        }

        public TextView getTextViewTitle() {
            return textViewTitle;
        }

        public TextView getTextViewPrice() {
            return textViewPrice;
        }
    }
}
