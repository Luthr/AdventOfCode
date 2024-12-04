package org.aoc23.tasks.day2;

import org.aoc23.models.CubeGame;
import java.util.List;

public class Day2Part2 extends Day2Part1 {
    public String returnMinRequiredSum(List<String> content) {
        if (content != null) {
            return String.valueOf(calculateSum(content));
        } else {
            return "Input Empty/Error";
        }
    }

    private int calculateSum(List<String> content) {
        int sum = 0;
        for (String line : content) {
            sum = sum + calculateGameSum(line);
        }
        return sum;
    }

    private int calculateGameSum(String line) {
        CubeGame cubeGame = retrieveGameStats(line);
        int minRed = findLargestNumber(cubeGame.getRed());
        int minGreen = findLargestNumber(cubeGame.getGreen());
        int minBlue = findLargestNumber(cubeGame.getBlue());

        return minRed * minGreen * minBlue;
    }

    private int findLargestNumber(List<Integer> list) {
        int count = 0;
        int largestNumber = 0;

        for (Integer item : list) {
            if (count != 0) {
                if (item > largestNumber) {
                    largestNumber = item;
                }
            } else {
                largestNumber = item;
            }
            count++;
        }
        return largestNumber;
    }
}

