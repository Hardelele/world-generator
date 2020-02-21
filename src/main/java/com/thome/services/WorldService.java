package com.thome.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thome.entities.WorldEntity;
import com.thome.models.World;
import com.thome.repositories.WorldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorldService {

    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();

    private final GeneratorService generatorService;
    private final WorldRepository worldRepository;

    @Autowired
    public WorldService(GeneratorService generatorService, WorldRepository worldRepository) {
        this.generatorService = generatorService;
        this.worldRepository = worldRepository;
    }

    public World generateWorld(String name) {

        return worldRepository.save();
    }

    public WorldEntity getWorldById(String id) {
        Optional<WorldEntity> worldEntity = worldRepository.findById(id);
        return worldEntity.get();
    }
}
