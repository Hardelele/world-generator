package com.thome.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thome.models.World;
import com.thome.models.WorldConfig;
import com.thome.services.WorldService;
import org.springframework.web.bind.annotation.*;

@RestController
public class WorldController {

    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();

    private final WorldService worldService;

    public WorldController(WorldService worldService) {
        this.worldService = worldService;
    }

    @PostMapping("/world")
    public World generateWorld(@RequestBody WorldConfig worldConfig) {
        String jsonWorldEntity = gson.toJson(worldService.generateWorld(worldConfig.getName()));
        return gson.fromJson(jsonWorldEntity, World.class);
    }

    @GetMapping("/world/{id}")
    public World getWorld(@PathVariable String id) {
        String jsonEntity = gson.toJson(worldService.getWorldById(id));
        return gson.fromJson(jsonEntity, World.class);
    }
}
