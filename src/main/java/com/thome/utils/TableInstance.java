package com.thome.utils;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;

import java.util.List;

public class TableInstance {

    public static Table<Integer, Integer, Integer> get() {
        return createEmptyWorldTable();
    }

    private static Table<Integer, Integer, Integer> createEmptyWorldTable() {
        List<Integer> keys = buildKeysLine();
        return ArrayTable.create(keys, keys);
    }

    private static List<Integer> buildKeysLine() {
        //TODO:: add size into World class and take it here
        int tableSize = 10;
        List<Integer> keys = Lists.newArrayList();
        for (int counter = 0; counter < tableSize; counter++) {
            keys.add(counter);
        }
        return keys;
    }
}
