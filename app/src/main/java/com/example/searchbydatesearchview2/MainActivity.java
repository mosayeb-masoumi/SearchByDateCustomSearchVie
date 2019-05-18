package com.example.searchbydatesearchview2;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterPlayer adapter;
    ArrayList<ModelPlayers> modelPlayers=new ArrayList<>();
    SearchView searchView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;

        searchView=findViewById(R.id.mSearch);

        recyclerView=findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new AdapterPlayer(modelPlayers,context);
        recyclerView.setAdapter(adapter);


         // background color
//        searchView.setBackgroundColor(Color.BLUE);
        searchView.setQueryHint("جستجو...");
      // OR in xml = app:defaultQueryHint="جستجو ..."


        EditText searchEditText = searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchEditText.setTextColor(Color.WHITE);
        searchEditText.setHintTextColor(Color.GRAY);


       // change close icon (color shape ...)
        ImageView imvClose = searchView.findViewById(android.support.v7.appcompat.R.id.search_close_btn);
        imvClose.setImageResource(R.drawable.ic_close);

        // delete icon search
        searchView.setIconifiedByDefault(false);


        //SEARCH
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                //FILTER AS YOU TYPE
                adapter.getFilter().filter(query);
                return false;
            }
        });

        loadData();
    }

    private void loadData() {
        modelPlayers.add(new ModelPlayers("ali","forward","1396",R.drawable.ic_launcher_background));
        modelPlayers.add(new ModelPlayers("reza","defend","1856",R.drawable.ic_launcher_background));
        modelPlayers.add(new ModelPlayers("mahdi","forward","1254",R.drawable.ic_launcher_background));
        modelPlayers.add(new ModelPlayers("milad","forward","425",R.drawable.ic_launcher_background));
    }
}
