package com.example.soulsborne_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Soulsborne> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<>(); // ArrayList to hold Json element
        RecyclerAdapter adapter = new RecyclerAdapter(this, itemList);
        recyclerView.setAdapter(adapter);

        JsonTask jsonLoader = new JsonTask(this);

        /* Navigate to About activity*/
        Button btnAbout = findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        });
    }
    private void onPostExecute(String json) {
        Log.d("MainActivity", json);
        Gson gson = new Gson();
        Type type = new TypeToken<List<Soulsborne>>() {}.getType();
        List<Soulsborne> items = gson.fromJson(json, type);

        itemList.addAll(items); // Adds Json elements to itemList
    }
}