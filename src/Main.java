import day2.Day2Part2;
import utils.CommonMethods;
import day1.Day1Part2;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    static Day1Part2 day1Part2 = new Day1Part2();
    static Day2Part2 day2Part2 = new Day2Part2();

    public static void main(String[] args) {

        String task = "Day2Part2";

        String output = switch (task) {
            case "Day1Part1" ->
                    day1Part2.returnCalibrationSum(CommonMethods.readFileContent("src/day1/input/input.txt"));
            case "Day1Part2" ->
                    day1Part2.returnPartTwoCalibrationSum(CommonMethods.readFileContent("src/day1/input/input.txt"));
            case "Day2Part1" -> day2Part2.returnValidIdSum(CommonMethods.readFileContent("src/day2/input/input.txt"));
            case "Day2Part2" -> day2Part2.returnMinRequiredSum(CommonMethods.readFileContent("src/day2/input/input.txt"));
            default -> "No valid task chosen";
        };

        logger.info(task + " result: " + output);
    }
}