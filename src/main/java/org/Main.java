package org;

import org.tasks.day1.Day1;
import org.tasks.day2.Day2;

import org.utils.CommonMethods;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    static Day1 day1 = new Day1();
    static Day2 day2 = new Day2();

    public static void main(String[] args) {
        String task = "Day2Part1";
        String inputPath = "src/main/java/org/input/%s";

        String output = switch (task) {
            case "Day1Part1" ->
                    day1.returnDistance(CommonMethods.readFileContent(String.format(inputPath, "Day1")));
            case "Day1Part2" ->
                    day1.returnSimilarityScore(CommonMethods.readFileContent(String.format(inputPath, "Day1")));
            case "Day2Part1" ->
                    day2.returnSafeReportCount(CommonMethods.readFileContent(String.format(inputPath, "Day2")));
            default -> "No valid task chosen";
        };

        logger.info(task + " result: " + output);
    }
}