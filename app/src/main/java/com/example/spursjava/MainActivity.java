package com.example.spursjava;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private SharedPreferences mSharedPreferences;
    private RecyclerView mRecyclerView;
    private MyAdapter mMyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mSharedPreferences = getSharedPreferences("My_Pref", MODE_PRIVATE);
        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<Model> arrayList = new ArrayList<>();
        arrayList.add(new Model("Tim Duncan", "This is Tim Duncan", R.drawable.timduncan));
        arrayList.add(new Model("Tony Parker", "This is Tony Parker", R.drawable.tonyparker));
        arrayList.add(new Model("Manu Ginobili", "This is Manu Ginobili", R.drawable.manu_ginobili));
        arrayList.add(new Model("Kawhi Leonard", "This is Kawhi Leonard", R.drawable.kawhi_leonard));
        arrayList.add(new Model("Popovich", "This is Popovich", R.drawable.popovich));
        arrayList.add(new Model("Boris Diaw", "This is Boris Diaw", R.drawable.boris_diaw));
        arrayList.add(new Model("Patty Mills", "This is Patty Mills", R.drawable.patty_mills));
        arrayList.add(new Model("Tiago Splitter", "This is Tiago Splitter", R.drawable.tiago_splitter));
        arrayList.add(new Model("Stephen Jackson", "This is Stephen Jackson", R.drawable.stephen_jackson));
        arrayList.add(new Model("Matty Bonner", "This is Matty Bonner", R.drawable.matt_bonner));
        arrayList.add(new Model("Nando De Colo", "This is Nando De Colo", R.drawable.nando_de_colo));

        String sortBy = mSharedPreferences.getString("sort_by", "ascending");
        if (sortBy.equals("ascending")) {
            Collections.sort(arrayList, Model.BY_TITLE_ASCENDING);
        }
        if (sortBy.equals("descending")) {
            Collections.sort(arrayList, Model.BY_TITLE_DESCENDING);
        }
        mMyAdapter = new MyAdapter(arrayList);
        mRecyclerView.setAdapter(mMyAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.i(TAG, "onQueryTextSubmit: ");
                mMyAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.i(TAG, "onQueryTextChange: ");
                mMyAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.sorting) {
            sortDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void sortDialog() {
        String[] options = {"Ascending", "Descending"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Sort by");
        builder.setIcon(R.drawable.ic_action_sort);
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    SharedPreferences.Editor editor = mSharedPreferences.edit();
                    editor.putString("sort_by", "Ascending");
                    editor.apply();
                    initRecyclerView();
                }
                if (which == 1) {
                    SharedPreferences.Editor editor = mSharedPreferences.edit();
                    editor.putString("sort_by", "Descending");
                    editor.apply();
                    initRecyclerView();
                }
            }
        });
        builder.create().show();
    }
}