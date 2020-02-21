package com.thome.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thome.models.World;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties
public class WorldEntity extends World {

    @Id
    private UUID id;
    private String name;
}
