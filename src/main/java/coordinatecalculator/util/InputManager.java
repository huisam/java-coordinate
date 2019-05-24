package coordinatecalculator.util;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import coordinatecalculator.domain.Coordinate;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputManager {
    private static final String COORDINATE_PATTERN = "[(]([0-9]+),([0-9]+)[)]";
    private static final String HYPHEN = "-";
    private static final String OPEN_PARENTHESIS = "(";
    private static final String CLOSE_PARENTHESIS = ")";
    private static final int MAX_LENGTH = 7;
    public static final int X = 1;
    public static final int Y = 2;

    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<Coordinate> getCoordinates() {
        System.out.println("좌표를 입력하세요.");
        return makeCoordinates(Splitter.on(HYPHEN)
                .trimResults()
                .omitEmptyStrings()
                .split(SCANNER.nextLine()));
    }

    private static List<Coordinate> makeCoordinates(Iterable<String> inputCoordinates) {
        List<Coordinate> coordinates = Lists.newArrayList();

        for (String coordinate : inputCoordinates) {
            Matcher matcher = Pattern.compile(COORDINATE_PATTERN).matcher(coordinate);
            checkValidPattern(matcher, coordinate);
            coordinates.add(new Coordinate(Integer.valueOf(matcher.group(X)), Integer.valueOf(matcher.group(Y))));
        }
        Collections.sort(coordinates);
        return coordinates;
    }

    private static void checkValidPattern(final Matcher matcher, final String coordinate) {
        Preconditions.checkArgument(matcher.find(), "올바르지 않는 입력입니다!!");
        Preconditions.checkArgument(coordinate.length() <= MAX_LENGTH, "(-)올바르게 넣어주세요!!");
        Preconditions.checkArgument(coordinate.startsWith(OPEN_PARENTHESIS) && coordinate.endsWith(CLOSE_PARENTHESIS),
                "괄호를 올바르게 쳐주세요!");
    }
}
