package courses.formatter.lexer.implementation;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class LexemeMap {
    private final Map<String, String> hashMap;

    /**
     *
     */
    LexemeMap() {
        hashMap = new HashMap<>();

        hashMap.put(" ", "space");
        hashMap.put("\t", "tab");
        hashMap.put("\n", "newLine");
        hashMap.put("{", "openingBracket");
        hashMap.put("}", "closingBracket");
        hashMap.put(";", "semicolon");
        hashMap.put("/", "comment");
        hashMap.put("\"", "literal");

        hashMap.put("(", "openingRoundBracket");
        hashMap.put(")", "closingRoundBracket");
    }

    /**
     *
     * getting the name of lexeme, by using first char;
     * @param lexeme - lexeme to name;
     * @return name of lexeme;
     */
    String getName(final String lexeme) {
        return hashMap.getOrDefault(lexeme.substring(0,1), "regularCharacter");
    }

}
