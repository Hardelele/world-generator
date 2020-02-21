package com.thome.controllers;

import com.thome.models.World;
import com.thome.models.WorldConfig;
import com.thome.services.WorldService;
import io.vertx.core.json.Json;
import org.springframework.web.bind.annotation.*;

@RestController
public class WorldController {

    private final WorldService worldService;

    public WorldController(WorldService worldService) {
        this.worldService = worldService;
    }

    @PostMapping("/world")
    public World generateWorld(@RequestBody WorldConfig worldConfig) {
        return worldService.generateWorld(worldConfig.getName());
    }

    @GetMapping("/world/{id}")
    public World getWorld(@PathVariable String id) {
        String jsonEntity = Json.encode(worldService.getWorldById(id));
        return (World) Json.decodeValue(jsonEntity);
    }
}
