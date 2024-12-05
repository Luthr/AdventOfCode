package org.aoc23.tasks.day1;

import java.util.HashMap;
import java.util.List;

import static org.aoc23.utils.CommonMethods.retrieveNumberToTextMap;

public class Day1Part2 extends Day1Part1 {

    public String returnPartTwoCalibrationSum(List<String> content) {
        return returnCalibrationSum(convertTextToNumbers(content));
    }

    private List<String> convertTextToNumbers(List<String> content) {
        HashMap<String, Character> numberMap = retrieveNumberToTextMap();

        int count = 0;
        for (String line : content) {
            for (String numberText : numberMap.keySet()) {
                if (line.contains(numberText)) {
                    while (line.contains(numberText)) {
                        char[] lineArray = line.toCharArray();
                        lineArray[line.indexOf(numberText) + 1] = numberMap.get(numberText);
                        line = new String(lineArray);
                    }
                    content.set(count, line);
                }
            }
            count++;
        }
        return content;
    }
}
