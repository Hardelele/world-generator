package com.thome.services;

import com.thome.entities.WorldEntity;
import com.thome.models.World;
import com.thome.repositories.WorldRepository;
import io.vertx.core.json.Json;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class WorldService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorldService.class);

    private final GeneratorService generatorService;
    private final WorldRepository worldRepository;

    @Autowired
    public WorldService(GeneratorService generatorService, WorldRepository worldRepository) {
        this.generatorService = generatorService;
        this.worldRepository = worldRepository;
    }

    public Mono<WorldEntity> generateWorld(String name) {
        World world = validateNameAndGenerate(name);
        return Mono.fromCallable(() -> worldRepository.save(buildWorldEntity(world, name)))
                .subscribeOn(Schedulers.elastic());
    }

    public Mono<WorldEntity> getWorldById(UUID id) {
        Optional<WorldEntity> worldEntity = worldRepository.findById(id);
        return Mono.fromCallable( () -> worldEntity.get())
                .subscribeOn(Schedulers.elastic());
    }

    /**
     * utils
     */

    private WorldEntity buildWorldEntity(World world, String name) {
        WorldEntity worldEntity = new WorldEntity();
        worldEntity.setId(UUID.randomUUID());
        worldEntity.setState(world.getState());
        worldEntity.setName(name);
        LOGGER.info("Prepare world entity to save: " + Json.encode(worldEntity));
        return worldEntity;
    }

    private World validateNameAndGenerate(String name) {
        if (name != null) {
            LOGGER.info("Generating new world by key word: " + name);
            return generatorService.generateNewWorld(name);
        } else {
            LOGGER.info("Generating new world without key word...");
            return generatorService.generateNewWorld();
        }
    }
}
