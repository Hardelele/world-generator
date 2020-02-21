package com.thome.models;

import com.google.common.collect.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class World {

    private Table<Integer, Integer, Integer> state;
}
