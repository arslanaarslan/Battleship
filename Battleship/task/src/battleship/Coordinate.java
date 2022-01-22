package battleship;

import battleship.Map;

import java.util.Arrays;

public class Coordinate {
    private Map map;
    private String xStr;
    private String yStr;
    private int x;
    private int y;

    Coordinate (Map map, String point) {
        this.map = map;
        this.xStr = point.substring(1);
//        System.out.println(xChar);
        this.yStr = point.substring(0, 1);
//        System.out.println(yChar);
        findIndex(xStr, yStr);
    }

    Coordinate (int x, int y) {
        this.x = x;
        this.y = y;
    }

    private void findIndex(String xStr, String yStr) {
        this.x = Arrays.binarySearch(map.getTopHeaderArray(), Integer.parseInt(String.valueOf(xStr)));
//        System.out.println(x);
        this.y = Arrays.binarySearch(map.getSideHeaderArray(), yStr.charAt(0));
//        System.out.println(y);
    }

    public int[] getCoordinate() {
        int[] coordinate = new int[2];

        coordinate[0] = this.x;
        coordinate[1] = this.y;

        return coordinate;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + this.x +
                ", y=" + this.y +
                '}';
    }

    public static boolean equal(Coordinate coordinate1, Coordinate coordinate2) {
        if (coordinate1.getX() == coordinate2.getX() && coordinate1.getY() == coordinate2.getY()) {
            return true;
        }

        return false;
    }
}
