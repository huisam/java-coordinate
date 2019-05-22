package coordinatecalculator;

import coordinatecalculator.factory.ShapeMaker;
import coordinatecalculator.util.InputManager;
import coordinatecalculator.util.OutputManager;

public class CoordinateApplication {
    public static void main(String[] args) {
        OutputManager.separateShape(ShapeMaker.createShape(InputManager.getCoordinates()));
    }
}
