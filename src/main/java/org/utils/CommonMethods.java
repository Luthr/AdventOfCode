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
}
