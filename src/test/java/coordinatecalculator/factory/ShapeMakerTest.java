package coordinatecalculator.factory;

import coordinatecalculator.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShapeMakerTest {
    @Test
    void 좌표의_개수에_따라서_모양이_제대로_나오는지_테스트() {
        /* Given */
        List<Coordinate> coordinates1 = Arrays.asList(new Coordinate(1, 1), new Coordinate(1, 2),
                new Coordinate(2, 1), new Coordinate(2, 2));
        List<Coordinate> coordinates2 = Arrays.asList(new Coordinate(2, 1), new Coordinate(1, 2),
                new Coordinate(23, 3));
        List<Coordinate> coordinates3 = Arrays.asList(new Coordinate(2, 1), new Coordinate(1, 24));

        /* Then */
        assertThat(ShapeMaker.createShape(new Coordinates(coordinates1, coordinates1.size())))
                .isEqualTo(new Rectangle(new Coordinates(coordinates1, 4)));
        assertThat(ShapeMaker.createShape(new Coordinates(coordinates2, coordinates2.size())))
                .isEqualTo(new Triangle(new Coordinates(coordinates2, 3)));
        assertThat(ShapeMaker.createShape(new Coordinates(coordinates3, coordinates3.size())))
                .isEqualTo(new Line(new Coordinates(coordinates3, 2)));
    }

    @Test
    void 좌표의_개수가_이상하면_예외를_던지는지_테스트() {
        /* Given */
        List<Coordinate> coordinates1 = Collections.singletonList(new Coordinate(1, 1));
        List<Coordinate> coordinates2 = Arrays.asList(new Coordinate(1, 14), new Coordinate(14, 1),
                new Coordinate(1, 2), new Coordinate(2, 1), new Coordinate(2, 2));

        /* Then */
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeMaker.createShape(new Coordinates(coordinates1, coordinates1.size()));
        });
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeMaker.createShape(new Coordinates(coordinates2, coordinates2.size()));
        });
    }
}