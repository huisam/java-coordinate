package coordinatecalculator.domain;

public class Coordinate implements Comparable<Coordinate> {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double calculate(Coordinate coordinate) {
        return coordinate.calculate(x, y);
    }

    private double calculate(int x, int y) {
        return Math.sqrt(Math.pow(Math.abs(x - this.x), 2) + Math.pow(Math.abs(y - this.y), 2));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(final Coordinate o) {
        if (this.x == o.x) {
            return Integer.compare(this.y, o.y);
        }
        return Integer.compare(this.x, o.x);
    }


}