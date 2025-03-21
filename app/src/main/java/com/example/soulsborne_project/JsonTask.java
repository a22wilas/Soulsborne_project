package com.example.soulsborne_project;
import android.content.Context;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;


public class JsonTask {
    private final Context context;

    public JsonTask(Context context) {
        this.context = context;
    }

    /* Retrieves data from the Json file*/
    public String loadJson() {
        try {
            InputStream is = context.getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            return new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error loading JSON", Toast.LENGTH_SHORT).show();
            return null;
        }
    }
}
