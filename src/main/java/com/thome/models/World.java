package com.thome.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.collect.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class World {

    private Table<Integer, Integer, Integer> state;
}
