package lotto.view;

import java.util.Arrays;
import java.util.List;

public class StringParser {

    private static final String DELIMITER_COMMA = ", ";

    private StringParser() {
    }

    public static List<String> split(final String inputText) {
        return Arrays.asList(inputText.split(DELIMITER_COMMA));
    }
}
