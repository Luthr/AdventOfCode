package org.aoc23.tasks.day2;

import org.aoc23.models.CubeGame;
import org.aoc23.utils.CommonMethods;

import java.util.ArrayList;
import java.util.List;

public class Day2Part1 {
    public String returnValidIdSum(List<String> content) {
        if (content != null) {
            return String.valueOf(retrieveValidIdSum(content));
        } else {
            return "Input Empty/Error";
        }
    }

    private int retrieveValidIdSum(List<String> content) {
        int idSum = 0;
        for (String line : content) {
            idSum = idSum + verifyGameValidity(line);
        }
        return idSum;
    }

    private int verifyGameValidity(String line) {
        CubeGame cubeGame = retrieveGameStats(line);

        for (int score : cubeGame.getBlue()) {
            if (score > 14) {
                return 0;
            }
        }
        for (int score : cubeGame.getRed()) {
            if (score > 12) {
                return 0;
            }
        }
        for (int score : cubeGame.getGreen()) {
            if (score > 13) {
                return 0;
            }
        }

        return cubeGame.getGame();
    }

    CubeGame retrieveGameStats(String line) {
        String[] game = line.split(":");
        String[] rounds = game[1].split(";");

        CubeGame cubeGame = retrieveRoundStats(rounds);
        cubeGame.setGame(Integer.parseInt(CommonMethods.removeAlphabeticCharacters(game[0])));

        return cubeGame;
    }

    private CubeGame retrieveRoundStats(String[] rounds) {
        ArrayList<Integer> blueCubes = new ArrayList<>();
        ArrayList<Integer> redCubes = new ArrayList<>();
        ArrayList<Integer> greenCubes = new ArrayList<>();

        for (String round : rounds) {
            String[] cubes = round.split(",");
            for (String cube : cubes) {
                int amount = Integer.parseInt(CommonMethods.removeAlphabeticCharacters(cube.trim()));
                if (cube.contains("blue")) {
                    blueCubes.add(amount);
                } else if (cube.contains("green")) {
                    greenCubes.add(amount);
                } else {
                    redCubes.add(amount);
                }
            }
        }

        return new CubeGame(0, redCubes, blueCubes, greenCubes);
    }
}

