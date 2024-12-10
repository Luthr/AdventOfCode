package org;

import org.tasks.day1.Day1;

import org.tasks.day2.Day2;
import org.tasks.day3.Day3;
import org.utils.CommonMethods;

import java.io.IOException;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    static Day1 day1 = new Day1();
    static Day2 day2 = new Day2();
    static Day3 day3 = new Day3();

    public static void main(String[] args) throws IOException {
        String task = "Day3Part1";
        String inputPath = "src/main/java/org/input/%s";

        String output = switch (task) {
            case "Day1Part1" ->
                    day1.returnDistance(CommonMethods.readFileContentLines(String.format(inputPath, "Day1")));
            case "Day1Part2" ->
                    day1.returnSimilarityScore(CommonMethods.readFileContentLines(String.format(inputPath, "Day1")));
            case "Day2Part1" ->
                    day2.returnSafeReportCount(CommonMethods.readFileContentLines(String.format(inputPath, "Day2")), false);
            case "Day2Part2" ->
                    day2.returnSafeReportCount(CommonMethods.readFileContentLines(String.format(inputPath, "Day2")), true);
            case "Day3Part1" ->
                    day3.returnProgramMultiplication(String.format(inputPath, "Day3"));
            default -> "No valid task chosen";
        };

        logger.info(task + " result: " + output);
    }
}