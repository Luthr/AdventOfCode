import tasks.day2.Day2Part2;
import tasks.day3.Day3Part1;
import utils.CommonMethods;
import tasks.day1.Day1Part2;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    static Day1Part2 day1Part2 = new Day1Part2();
    static Day2Part2 day2Part2 = new Day2Part2();
    static Day3Part1 day3Part1 = new Day3Part1();

    public static void main(String[] args) {

        String task = "Day3Part1";

        String output = switch (task) {
            case "Day1Part1" ->
                    day1Part2.returnCalibrationSum(CommonMethods.readFileContent("src/tasks/day1/input/input.txt"));
            case "Day1Part2" ->
                    day1Part2.returnPartTwoCalibrationSum(CommonMethods.readFileContent("src/tasks/day1/input/input.txt"));
            case "Day2Part1" ->
                    day2Part2.returnValidIdSum(CommonMethods.readFileContent("src/tasks/day2/input/input.txt"));
            case "Day2Part2" ->
                    day2Part2.returnMinRequiredSum(CommonMethods.readFileContent("src/tasks/day2/input/input.txt"));
            case "Day3Part1" ->
                    day3Part1.returnSumOfAllParts(CommonMethods.readFileContent("src/tasks/day3/input/input.txt"));
            default -> "No valid task chosen";
        };

        logger.info(task + " result: " + output);
    }
}