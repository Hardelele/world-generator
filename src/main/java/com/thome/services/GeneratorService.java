package com.thome.services;

import com.google.common.collect.Table;
import com.thome.models.World;
import com.thome.utils.TableInstance;
import javafx.scene.control.TableRow;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GeneratorService {

    Random random = new Random();

    public World generateNewWorld() {
        String randomGeneratedKey = UUID.randomUUID().toString();
        return generateNewWorld(randomGeneratedKey);
    }

    public World generateNewWorld(String key) {
        Table<Integer, Integer, Integer> worldState = TableInstance.get();
        constructRandomWorld(worldState);
        return new World(worldState);
    }

    private Table<Integer, Integer, Integer> constructRandomWorld(Table<Integer, Integer, Integer> worldState) {
        Set<Integer> columnKeys = worldState.columnKeySet();
        columnKeys.forEach(columnKey -> {
            processingOneColumn(columnKey, worldState);
            newMethod(worldState.rowMap());
        });
        return
    }

    private void processingOneColumn(Integer columnKey, Table<Integer, Integer, Integer> worldState) {

    }

    private int generateRandomCellValue() {
        return random.nextInt(255) + 1;
    }
}
