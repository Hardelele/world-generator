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

    private GsonBuilder builder = new GsonBuilder();
    private Gson gson = builder.create();

    private final GeneratorService generatorService;
    private final WorldRepository worldRepository;

    @Autowired
    public WorldService(GeneratorService generatorService, WorldRepository worldRepository) {
        this.generatorService = generatorService;
        this.worldRepository = worldRepository;
    }

    public WorldEntity generateWorld(String name) {
        World world = validateNameAndGenerate(name);
        return worldRepository.save(buildWorldEntity(world, name));
    }

    public WorldEntity getWorldById(String id) {
        Optional<WorldEntity> worldEntity = worldRepository.findById(id);
        return worldEntity.get();
    }

    /**
     * utils
     */

    private WorldEntity buildWorldEntity(World world, String name) {
        String jsonWorld = gson.toJson(world);
        WorldEntity worldEntity = gson.fromJson(jsonWorld, WorldEntity.class);
        worldEntity.setName(name);
        return worldEntity;
    }

    private World validateNameAndGenerate(String name) {
        if (name != null) {
            return generatorService.generateNewWorld(name);
        }
        return generatorService.generateNewWorld();
    }
}
