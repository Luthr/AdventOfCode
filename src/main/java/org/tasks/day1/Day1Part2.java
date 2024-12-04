package org.tasks.day1;

import java.util.List;

public class Day1Part2 extends Day1Part1 {
    public String returnSimilarityScore(List<String> input) {
            populateLists(input);
            calculateSimilarityScore();
        return String.valueOf(finalId);
    }

    private void calculateSimilarityScore() {
        for (int location : first) {
            long count = second.stream()
                    .filter(secondLocation -> secondLocation.equals(location))
                    .count();
            finalId = finalId + (location * (int) count);
        }
    }
}
