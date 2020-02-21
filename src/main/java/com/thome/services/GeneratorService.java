package com.thome.services;

import com.google.common.collect.Table;
import com.thome.models.World;
import com.thome.utils.TableInstance;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Set;
import java.util.UUID;

@Service
public class GeneratorService {

    Random random = new Random();

    public World generateNewWorld() {
        String randomGeneratedKey = UUID.randomUUID().toString();
        return generateNewWorld(randomGeneratedKey);
    }

    public World generateNewWorld(String key) {
        Table<Integer, Integer, Integer> worldState = TableInstance.get();
        fillWorldStateRandom(worldState);
        return new World(worldState);
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
