package com.thome;

import com.google.common.collect.Table;

public class Application {
    public static void main(String[] args) {
        World world = new World(10);
        Table<Integer, Integer, Particle> flatWorld = world.getState();
        flatWorld.rowKeySet().forEach(row ->{
            flatWorld.row(row).values().forEach(particle -> {
                if(particle.getFloor().equals(Element.GROUND)) {
                    System.out.print(particle.getHeight() + " ");
                } else {
                    System.out.print("W ");
                }
            });
            System.out.println();
        });
    }
}
