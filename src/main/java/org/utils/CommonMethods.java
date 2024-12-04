package org.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class CommonMethods {

    private CommonMethods() {
        throw new IllegalStateException("Utility class");
    }

    private static final Logger logger = Logger.getLogger(CommonMethods.class.getName());

    public static List<String> readFileContent(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            logger.warning("Failed reading file content!");
        }
        return null;
    }

    public static String removeAlphabeticCharacters(String line) {
        return line.replaceAll("[t\s+[A-Za-z]]", "");
    }

    public static HashMap<String, Character> retrieveNumberToTextMap() {
        HashMap<String, Character> map = new HashMap<>();
        map.put("one", '1');
        map.put("two", '2');
        map.put("three", '3');
        map.put("four", '4');
        map.put("five", '5');
        map.put("six", '6');
        map.put("seven", '7');
        map.put("eight", '8');
        map.put("nine", '9');
        return map;
    }

}
