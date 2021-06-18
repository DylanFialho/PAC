package com.example.pac_app.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pac_app.AppDatabase;
import com.example.pac_app.Constants;
import com.example.pac_app.GameCategoryAdapter;
import com.example.pac_app.GameListAdapter;
import com.example.pac_app.GameListObject;
import com.example.pac_app.R;
import com.example.pac_app.model.Game;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerViewMain;
    private RecyclerView recyclerViewCategory;

    private List<GameListObject> gameListObjectsList  = new ArrayList<>();
    private Spinner spinner;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerViewMain = root.findViewById(R.id.recyclerViewMain);
        recyclerViewCategory = root.findViewById(R.id.recyclerViewCategory);
        spinner = root.findViewById(R.id.spinnerCategory);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<String> categoryList = Constants.categoryList;

        recyclerViewCategory.setVisibility(View.INVISIBLE);

        for (int i = 0; i < categoryList.size(); i++) {
            gameListObjectsList.add(new GameListObject(AppDatabase.getInstance(getContext()).getGameDao().
                    getAllFromCat(categoryList.get(i)), categoryList.get(i)));
        }

        GameListAdapter adapter = new GameListAdapter(getContext(), gameListObjectsList);
        recyclerViewMain.setAdapter(adapter);
        recyclerViewMain.setLayoutManager(new LinearLayoutManager(getContext()));

        List<String> spinnerStrings = new ArrayList<>();
        spinnerStrings.add("Todos");
        spinnerStrings.addAll(Constants.categoryList);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, spinnerStrings);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                if(!spinner.getItemAtPosition(position).toString().equals("Todos")){
                    recyclerViewMain.setVisibility(View.INVISIBLE);
                    recyclerViewCategory.setVisibility(View.VISIBLE);

                    GameCategoryAdapter categoryAdapter = new GameCategoryAdapter(getContext(),
                            AppDatabase.getInstance(getContext()).getGameDao().getAllFromCat(spinner.getItemAtPosition(position).toString()));

                    recyclerViewCategory.setAdapter(categoryAdapter);
                    recyclerViewCategory.setLayoutManager(new LinearLayoutManager(getContext()));
                }else {
                    recyclerViewMain.setVisibility(View.VISIBLE);
                    recyclerViewCategory.setVisibility(View.INVISIBLE);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}