package com.example.pac_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pac_app.model.Game;

import org.w3c.dom.Text;

import java.util.List;

public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.ViewHolder> {

    private final Context context;
    private List<GameListObject> gameList;

    public GameListAdapter(Context context, List<GameListObject> gameList) {
        this.context = context;
        this.gameList = gameList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.game_item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        GameListObject gameListObject = this.gameList.get(position);

        GameItemAdapter adapter = new GameItemAdapter(context, gameListObject.getGameList());

        holder.getCategory().setText(gameListObject.getCategory());
        holder.getRecyclerView().setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        holder.getRecyclerView().setLayoutManager(linearLayoutManager);

        holder.getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

    }

    @Override
    public int getItemCount() {
        return this.gameList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View view;
        private RecyclerView recyclerView;
        private TextView category;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            this.recyclerView = view.findViewById(R.id.recyclerViewGameItem);
            this.category = view.findViewById(R.id.textViewCategory);
        }

        public View getView() {
            return view;
        }

        public RecyclerView getRecyclerView() {
            return recyclerView;
        }

        public TextView getCategory() {
            return category;
        }
    }
}
