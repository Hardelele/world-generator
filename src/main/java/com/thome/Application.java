package com.thome;

import com.google.common.collect.Table;

public class Application {
    public static void main(String[] args) {
        World world = new World(10);
        Table<Integer, Integer, Particle> flatWorld = world.getState();
        flatWorld.rowKeySet().forEach(row ->{
            flatWorld.row(row).values().forEach(particle -> {
                switch (particle.getFloor()) {
                    case HILL:
                        System.out.print("H ");
                        break;
                    case WATER:
                        System.out.print("W ");
                        break;
                    case GROUND:
                        System.out.print("G ");
                        break;
                    case MOUNTAIN:
                        System.out.print("M ");
                        break;
                }
            });
            System.out.println();
        });
    }
}
