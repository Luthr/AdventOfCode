package org.tasks.day4;

import java.util.List;

public class Day4 {

    private final String xmas = "XMAS";

    public String returnWordCount(List<String> input) {
        int result = 0;
        int lineCount = 0;
        for (String line : input) {
            int characterCount = 0;
            for (char character : line.toCharArray()) {
                if (character == 'X' && verifySurroundingCharacters(input, character, characterCount, lineCount)) {
                    result++;
                }
                characterCount++;
            }
            lineCount++;
        }
        return String.valueOf(result);
    }

    private boolean verifySurroundingCharacters(List<String> input, int lineCount, int characterIndex) {
        char initialCharacter = xmas.charAt(characterIndex);
        if (lineCount > 0) {
            if (verifyLineCharacters(input.get(lineCount - 1), characterIndex)) {
                return true;
            }
        }
        return

    }

    private boolean verifyLineCharacters (String line, int characterIndex) {
        if ((characterIndex > 0 && verifyCharacter(line.charAt(characterIndex), line.charAt(characterIndex - 1))) ||
                (characterIndex < (line.length() - 1) && verifyCharacter(line.charAt(characterIndex), line.charAt(characterIndex + 1)))) {
            return true;
        }

        //        for (int count = -1; count < 2; count++) {
        //            if (verifyCharacter(line.charAt(characterIndex), line.charAt(characterIndex + count))) {
        //                return true;
        //            }
        //        }
        return verifyCharacter(line.charAt(characterIndex), line.charAt(characterIndex));;
    }

    private boolean verifyCharacter (int indexOfXmas, char characterCompared) {
        return (xmas.charAt(indexOfXmas + 1) == characterCompared);
    }
}
