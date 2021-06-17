package com.example.pac_app.ui.highlights;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pac_app.AppDatabase;
import com.example.pac_app.GameCategoryAdapter;
import com.example.pac_app.R;

public class HighlightsFragment extends Fragment {

    private HighlightsViewModel highlightsViewModel;
    private RecyclerView recyclerView;
    GameCategoryAdapter categoryAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        highlightsViewModel =
                new ViewModelProvider(this).get(HighlightsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        recyclerView = root.findViewById(R.id.recyclerViewHL);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GameCategoryAdapter categoryAdapter = new GameCategoryAdapter(getContext(),
                AppDatabase.getInstance(getContext()).getGameDao().getHighLights());

        recyclerView.setAdapter(categoryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }
}