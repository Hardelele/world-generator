package com.thome;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;

import java.util.List;
import java.util.Random;

public class Generator {

    Random random = new Random();

    public Table<Integer, Integer, Particle> generateFlatWorld(Table<Integer, Integer, Particle> state) {

        state.rowKeySet().forEach(row -> state.columnKeySet().forEach(column -> {
            state.put(row, column, generateParticle(5));
        }));

        return state;
    }

    public Table<Integer, Integer, Particle> addMountain(Table<Integer, Integer, Particle> state, int mountainSize) {

        int length = state.rowKeySet().size();
        int mountainCenterRow = random.nextInt(length) + 1;
        int mountainCenterColumn = random.nextInt(length) + 1;
        Particle mountainCenterParticle = state.get(mountainCenterRow, mountainCenterColumn);
        mountainCenterParticle.setHeight(mountainCenterParticle.getHeight() + mountainSize - 1);

        System.out.println(mountainCenterParticle.getHeight());

        state.rowKeySet().forEach(row -> state.columnKeySet().forEach(column -> {
            Particle thisParticle = state.get(row, column);
            int rowDiff = Math.abs(row - mountainCenterRow);
            int columnDiff = Math.abs(column - mountainCenterColumn);
            if(rowDiff <= mountainSize  && columnDiff <= mountainSize) {
                thisParticle = generateParticle(mountainCenterParticle.getHeight() - ((columnDiff + rowDiff - 1) / 2));
            }
            state.put(row, column, thisParticle);
        }));

        return state;
    }

    public Table<Integer, Integer, Particle> addPits(Table<Integer, Integer, Particle> state, int deep) {

        state.rowKeySet().forEach(row -> state.columnKeySet().forEach(column -> {
            Particle thisParticle = state.get(row, column);
            thisParticle = generateParticle(thisParticle.getHeight() - random.nextInt(deep));
            state.put(row, column, thisParticle);
        }));

        return state;
    }

    private Particle generateParticle(int height) {
        if(height <= 0) {
            return new Particle(false, height, Element.WATER);
        } else {
            return new Particle(false, height, Element.GROUND);
        }
    }

    public Table<Integer, Integer, Particle> buildEmptyWorldState(int size) {

        List<Integer> keys = buildKeysLine(size);

        Table<Integer, Integer, Particle> worldState;
        worldState = ArrayTable.create(keys, keys);

        return worldState;
    }

    private List<Integer> buildKeysLine(int length) {

        List<Integer> keys = Lists.newArrayList();

        for (int counter = 0; counter < length; counter++) {
            keys.add(counter + 1);
        }

        return keys;
    }
}
