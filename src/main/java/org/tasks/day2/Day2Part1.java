package org.tasks.day2;

import java.util.List;

public class Day2Part1 {

    private boolean increase = false;
    private int currentLevel;
    private int previousLevel = 0;

    public String returnSafeReportCount(List<String> input) {
        int count = 0;
        for (String report : input) {
            if (verifyReportSafe(report.split(" "))) {
                count++;
            }
        }
        return String.valueOf(count);
    }

    private boolean verifyReportSafe(String[] levels) {
        int count = 0;
        for (String level : levels) {
            currentLevel = Integer.parseInt(level);
            if (count != 0) {
                if (isLevelDifferenceValid()) {
                    if (count == 1) {
                        increase = (currentLevel > previousLevel);
                    } else {
                        if (increase != (currentLevel > previousLevel)) {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
            previousLevel = currentLevel;
            count++;
        }
        return true;
    }

    private boolean isLevelDifferenceValid() {
        return Math.abs(currentLevel - previousLevel) > 0 && Math.abs(currentLevel - previousLevel) < 4;
    }
}
