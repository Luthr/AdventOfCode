package org.tasks.day2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Day2Part1 {

    public String returnSafeReportCount(List<String> input) {
        int count = 0;
        String[] levels = null;
        for (String report : input) {
            levels = report.split(" ");

        }
        return "";
    }

    private boolean onlyIncreaseOrDecrease(String[] report) {
        Iterator<String> levels = Arrays.stream(report).iterator();
        boolean increaseOrDecrease;
        int previousLevel = 0;

        while (levels.hasNext()) {
            if (previousLevel != 0) {
                if (Math.abs(Integer.parseInt(levels.next()) - previousLevel) <= 3) {

                } else {
                    return false;
                }
            }

        }
        return true;
    }
}
