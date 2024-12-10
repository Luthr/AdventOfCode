package org.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonMethods {

    private CommonMethods() {
        throw new IllegalStateException("Utility class");
    }

    private static final Logger logger = Logger.getLogger(CommonMethods.class.getName());

    public static List<String> readFileContentLines(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            logger.warning("Failed reading file content!");
        }
        return null;
    }

    public static List<String> findFileSpecificContent(String filepath, String regex) throws IOException {
        final Pattern pattern = Pattern.compile(regex,  Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(Files.readString(Paths.get(filepath)));

        if (matcher.find()) {
            return matcher.results()
                    .map(MatchResult::group)
                    .toList();
        } else {
            throw new IllegalArgumentException("No matching content found in the file");
        }
    }
}
