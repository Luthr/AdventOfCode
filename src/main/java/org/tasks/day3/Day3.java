package org.tasks.day3;

import org.utils.CommonMethods;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Day3 {

    private final String searchRegex = "mul\\([0-9]+,[0-9]+\\)";

    public String returnProgramMultiplication(String input) throws IOException {
        return calculateProgramMultiplication(CommonMethods.findFileSpecificContent(input, searchRegex));
    }

    private String calculateProgramMultiplication(List<String> input) {
        int totalCalulation = 0;
        for (String calculation : input) {
            List<Integer> numbers = Arrays.stream(calculation.split(","))
                    .map(Integer::parseInt)
                    .toList();
            totalCalulation = totalCalulation + (numbers.get(0) * numbers.get(1));
        }
        return String.valueOf(totalCalulation);
    }
}
