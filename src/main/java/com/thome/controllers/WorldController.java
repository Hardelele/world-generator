package com.thome.controllers;

import com.thome.models.World;
import com.thome.services.WorldService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldController {

    private final WorldService worldService;

    public WorldController(WorldService worldService) {
        this.worldService = worldService;
    }

    @PostMapping("/world")
    public World generateWorld() {
        return ;
    }

    @GetMapping("/world/{name}")
    public World getWorld(@PathVariable String name) {
        return worldService.getWorld(name);
    }
}
