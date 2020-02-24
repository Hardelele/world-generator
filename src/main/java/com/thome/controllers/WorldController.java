package com.thome.controllers;

import com.thome.models.World;
import com.thome.models.WorldConfig;
import com.thome.services.WorldService;
import io.vertx.core.json.Json;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class WorldController {

    private final WorldService worldService;

    public WorldController(WorldService worldService) {
        this.worldService = worldService;
    }

    @PostMapping("/world")
    public Mono<World> generateWorld(@RequestBody WorldConfig worldConfig) {
        return Mono.fromCallable(() -> worldService.generateWorld(worldConfig.getName()));
    }

    @GetMapping("/world/{id}")
    public Mono<World> getWorld(@PathVariable UUID id) {
        String jsonEntity = Json.encode(worldService.getWorldById(id));
        return Mono.fromCallable(() -> (World) Json.decodeValue(jsonEntity));
    }
}
