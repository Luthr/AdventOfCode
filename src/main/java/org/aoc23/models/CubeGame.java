package org.aoc23.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor

public class CubeGame {
    int game;
    List<Integer> red;
    List<Integer> blue;
    List<Integer> green;
}
