package com.thome.services;

import com.google.common.collect.Table;
import com.thome.models.World;
import com.thome.utils.TableInstance;
import io.vertx.core.json.Json;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Set;
import java.util.UUID;

@Service
@Slf4j
public class GeneratorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorldService.class);

    private Random random = new Random();

    public World generateNewWorld() {
        String randomGeneratedKey = UUID.randomUUID().toString();
        return generateNewWorld(randomGeneratedKey);
    }

    public World generateNewWorld(String key) {
        Table<Integer, Integer, Integer> worldState = TableInstance.get();
        fillWorldStateRandom(worldState);
        World world = new World(0, worldState);
        LOGGER.info("New world generated: " + Json.encode(world));
        return world;
    }

    /**
     * Utils
     */

    private void fillWorldStateRandom(Table<Integer, Integer, Integer> worldState) {
        Set<Integer> columnKeys = worldState.columnKeySet();
        Set<Integer> rowKeys = worldState.rowKeySet();
        columnKeys.forEach(column -> {
            rowKeys.forEach(row -> {
                worldState.put(column, row, generateRandomCellValue());
            });
        });
    }

    private int generateRandomCellValue() {
        return random.nextInt(255) + 1;
    }
}
