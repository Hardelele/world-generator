package com.thome.entities;

import com.thome.models.World;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorldEntity extends World {

    @Id
    private int id;
    private String name;
}
