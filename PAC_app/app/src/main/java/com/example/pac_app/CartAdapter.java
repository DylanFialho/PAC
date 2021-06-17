package com.example.pac_app;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pac_app.model.Game;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {


    private final Context context;
    private List<Game> gameList;

    public CartAdapter(Context context, List<Game> gameList) {
        this.context = context;
        this.gameList = gameList;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.cart_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {

        Game game = this.gameList.get(position);
        Glide.with(context).load(game.getImgURL()).into(holder.getGameImageView());
        holder.getTextViewTitle().setText(game.getTitle());
        holder.getTextViewPrice().setText(String.valueOf(game.getPrice()));

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, game.getTitle(), Toast.LENGTH_SHORT).show();
                game.setInCart(false);

                AppDatabase.getInstance(context).getGameDao().updateGame(game);

                updateList(gameList);
            }
        });

        holder.getRoot().setOnClickListener(view -> {

            Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.custom_dialog);
            dialog.getWindow().setBackgroundDrawable(context.getResources().getDrawable(R.drawable.background));

            Button goToStore = dialog.findViewById(R.id.buttonToCart);
            TextView description = dialog.findViewById(R.id.textViewDescription);
            ImageView gameImageDialog = dialog.findViewById(R.id.imageDialog);

            description.setText(game.getDescription());
            Glide.with(context).load(game.getImgURL()).into(gameImageDialog);


            goToStore.setOnClickListener(view1 -> {
                dialog.dismiss();
            });

            dialog.show();
        });
    }

    @Override
    public int getItemCount() {
        return this.gameList.size();
    }

    public void updateList(List<Game> newGames) {
        this.gameList = newGames;
        this.notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View root;
        private ImageView gameImageView;
        private TextView textViewTitle;
        private TextView textViewPrice;
        private ImageButton button;

        public ViewHolder(@NonNull View gameView) {
            super(gameView);
            this.root = gameView;
            this.gameImageView = gameView.findViewById(R.id.imageViewCart);
            this.textViewTitle = gameView.findViewById(R.id.textViewCartName);
            this.textViewPrice = gameView.findViewById(R.id.textViewCartPrice);
            this.button = gameView.findViewById(R.id.imageButton);
        }

        public View getRoot() {
            return root;
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

        public ImageButton getButton() {
            return button;
        }
    }
}
