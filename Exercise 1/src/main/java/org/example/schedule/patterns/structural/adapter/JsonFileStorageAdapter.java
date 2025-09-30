package org.example.ei.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.ei.model.Task;
import org.example.ei.util.LocalTimeAdapter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class JsonFileStorageAdapter implements TaskStorage {
    private final Path file;
    private final Gson gson;

    public JsonFileStorageAdapter(String filepath) {
        this.file = Path.of(filepath);
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalTime.class, new LocalTimeAdapter())
                .setPrettyPrinting()
                .create();
    }

   
    public void save(List<Task> tasks) throws IOException {
        String json = gson.toJson(tasks);
        Files.writeString(file, json);
    }

    public List<Task> load() throws IOException {
        if (!Files.exists(file)) return new ArrayList<>();
        String json = Files.readString(file);
        Type type = new TypeToken<List<Task>>() {}.getType();
        List<Task> list = gson.fromJson(json, type);
        return list == null ? new ArrayList<>() : list;
    }
}
