package com.thome;

import com.google.common.collect.Table;

public class World {

    private final int WORLD_SIZE;

    Table<Integer, Integer, Particle> state;

    private Generator stateGenerator = new Generator();

    public World(int size) {
        WORLD_SIZE = size;
        state = stateGenerator.buildEmptyWorldState(WORLD_SIZE);
        state = stateGenerator.generateFlatWorld(state);
        state = stateGenerator.addPits(state, 5);
        state = stateGenerator.addMountain(state, 4);
    }

    public Table<Integer, Integer, Particle> getState() {
        return state;
    }

    public Generator getStateGenerator() {
        return stateGenerator;
    }
}
