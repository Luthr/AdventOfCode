package org.tasks.day2;

import java.util.ArrayList;
import java.util.List;

public class Day2 {

    private boolean increase = false;
    private List<String> levels;
    private int currentLevel;
    private int previousLevel = 0;
    private int levelCount = 0;
    private int errorCount = 0;

    public String returnSafeReportCount(List<String> input, boolean dampenerActive) {
        int count = 0;
        for (String report : input) {
            levels = new ArrayList<>(List.of(report.split(" ")));
            if (verifyReportSafe(dampenerActive)) {
                count++;
            }
        }
        return String.valueOf(count);
    }

    private boolean verifyReportSafe(boolean dampenerActive) {
        resetCounts();
        for (String level : levels) {
            if (!verifyLevelSafe(level, dampenerActive)) {
                return false;
            }
        }
        return true;
    }

    private boolean verifyLevelSafe(String level, boolean dampenerActive) {
        currentLevel = Integer.parseInt(level);
        if (levelCount != 0) {
            if (isLevelDifferenceValid()) {
                if (levelCount == 1) {
                    increase = (currentLevel > previousLevel);
                } else {
                    if (increase != (currentLevel > previousLevel)) {
                        errorCount++;
                        if (!dampenerActive || errorCount > 1) {
                            return false;
                        }
                        levels.remove(levelCount);
                    }
                }
            } else {
                errorCount++;
                if (!dampenerActive || errorCount > 1) {
                    return false;
                }
                levels.remove(levelCount);
            }
        }
        if (errorCount != 1) {
            previousLevel = currentLevel;
            levelCount++;
        }
        return true;
    }

    private boolean isLevelDifferenceValid() {
        return Math.abs(currentLevel - previousLevel) > 0 && Math.abs(currentLevel - previousLevel) < 4;
    }

    private void resetCounts() {
        levelCount = 0;
        errorCount = 0;
        previousLevel = 0;
    }
}
