package com.example.mytabsearchview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ListView sv_listView;
    SearchView searchView;
    ArrayAdapter<String> arrayadapter;

    String[] months ={"January","February","March","April","May","June","July","August","September","October","November","December"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sv_listView=(ListView)findViewById(R.id.listview_search);
        searchView=(SearchView)findViewById(R.id.search_view);

        arrayadapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,months);
        sv_listView.setAdapter(arrayadapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                arrayadapter.getFilter().filter(newText);
                return false;
            }
        });



    }
}