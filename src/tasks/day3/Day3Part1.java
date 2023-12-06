package tasks.day3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3Part1 {
    //    ArrayList<ArrayList<Integer>> symbolLocationMap = new ArrayList<>();
    ArrayList<ArrayList<String>> valueLocationMap = new ArrayList<>();
    List<String> inputContent;

    public String returnSumOfAllParts(List<String> content) {
        if (content != null) {
            return String.valueOf(retrieveSumOfAllParts(content));
        } else {
            return "Input Empty/Error";
        }
    }

    private int retrieveSumOfAllParts(List<String> content) {
        inputContent = content;
        int lineCount = 0;
        int sumOfAllParts = 0;

        for (String line : content) {
            sumOfAllParts = sumOfAllParts + retrieveValidValues(line, lineCount);
            lineCount++;
        }
        return sumOfAllParts;
    }

//    private void mapSymbols(List<String> content) {
//        for (String line : content) {
//            int characterCount = 0;
//            ArrayList<Integer> symbolList = new ArrayList<>();
//
//            for (char lineCharacter : line.toCharArray()) {
//                if (!String.valueOf(lineCharacter).matches("[0-9.]")) {
//                    symbolList.add(characterCount);
//                }
//                characterCount++;
//            }
//            symbolLocationMap.add(symbolList);
//        }
//    }

    private List<String> mapNumbers(String line) {
        List<String> numberList = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            numberList.add(matcher.group());
        }

        return numberList;
    }

    private int retrieveValidValues(String line, int lineCount) {
        int verifiedLineValue = 0;

        for (String value : mapNumbers(line)) {
            if (verifyAdjacentCharacters(lineCount, line, value)) {
                verifiedLineValue = verifiedLineValue + Integer.parseInt(value);
            }
        }

        return verifiedLineValue;
    }

    private boolean verifyAdjacentCharacters(int lineCount, String line, String value) {
        int valueStart = line.indexOf(value);
        int valueEnd = line.indexOf(value) + value.length();

        String[] currentLine = line.split("");
        List<String> adjacentLines = new ArrayList<>();

        System.out.println(lineCount+1 + " " + value);
        if (valueStart != 0) {
            if (!currentLine[valueStart - 1].matches("[.]")) {
                return true;
            }
        }

        if (valueEnd != currentLine.length) {
            if (!currentLine[valueEnd].matches("[.]")) {
                return true;
            }
        }

        if (lineCount != 0) {
            adjacentLines.add(new String(inputContent.get(lineCount - 1)));
        }

        if (lineCount + 1 != inputContent.size()) {
            adjacentLines.add(new String(inputContent.get(lineCount + 1)));
        }

        if (!adjacentLines.isEmpty()) {
            if (verifyLinesAboveAndBelow(adjacentLines, valueStart, valueEnd)) {
                return true;
            }
        }
        return false;
    }

    private boolean verifyLinesAboveAndBelow(List<String> adjacentLines, int valueStart, int valueEnd) {
        if (valueStart == 0) {
            valueStart++;
        }
//        if (valueEnd == adjacentLines.get(0).length()) {
//            valueEnd--;
//        }
        for (String adjacentLine : adjacentLines) {
            if (!adjacentLine.substring(valueStart - 1, valueEnd).matches("[.]")) {
                return false;
            }
        }
        return true;
    }
}
