package org.aoc23.tasks.day1;

import org.aoc23.utils.CommonMethods;

import java.util.List;

public class Day1Part1 {
    public String returnCalibrationSum (List<String> content) {
        if (content != null) {
            return String.valueOf(retrieveCalibrationSum(content));
        } else {
            return "Input Empty/Error";
        }
    }

    private int retrieveCalibrationSum(List<String> content) {
        int calibrationSum = 0;
        for (String line : content) {
            line = retrieveLineCalibration(line);
            calibrationSum = calibrationSum + Integer.parseInt(line);
        }
        return calibrationSum;
    }

    private String retrieveLineCalibration(String line) {
        line = CommonMethods.removeAlphabeticCharacters(line);

        char firstDigit = line.charAt(0);
        char secondDigit = line.charAt(line.length()-1);

        return Character.toString(firstDigit) + secondDigit;
    }

}
