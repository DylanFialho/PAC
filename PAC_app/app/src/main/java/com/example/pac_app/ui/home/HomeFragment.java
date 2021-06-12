package com.example.pac_app.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pac_app.AppDatabase;
import com.example.pac_app.Constants;
import com.example.pac_app.GameListAdapter;
import com.example.pac_app.GameListObject;
import com.example.pac_app.R;
import com.example.pac_app.model.Game;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;

    private List<GameListObject> gameListObjectsList  = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = root.findViewById(R.id.recyclerViewMain);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<String> categoryList = Constants.categoryList;

        for (int i = 0; i < categoryList.size(); i++) {
            gameListObjectsList.add(new GameListObject(AppDatabase.getInstance(getContext()).getGameDao().
                    getAllFromCat(categoryList.get(i)), categoryList.get(i)));
        }

        GameListAdapter adapter = new GameListAdapter(getContext(), gameListObjectsList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }
}