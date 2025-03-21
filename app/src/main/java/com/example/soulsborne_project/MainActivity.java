package com.example.soulsborne_project;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import android.widget.Button;
import android.content.Intent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainActivity extends AppCompatActivity {

    private List<Soulsborne> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<>(); // ArrayList to hold Json element
        RecyclerAdapter adapter = new RecyclerAdapter(this, itemList);
        recyclerView.setAdapter(adapter);

        /* Load JSON */
        JsonTask jsonLoader = new JsonTask(this);
        String json = jsonLoader.loadJson();
        onPostExecute(json);


        /* Navigate to About activity*/
        Button btnAbout = findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        });
    }

    /* Executes the Json into a Gson */
    private void onPostExecute(String json) {
        Log.d("MainActivity", json);
        Gson gson = new Gson();
        Type type = new TypeToken<List<Soulsborne>>() {}.getType();
        List<Soulsborne> items = gson.fromJson(json, type);

        itemList.addAll(items); // Adds Json elements to itemList
    }
}