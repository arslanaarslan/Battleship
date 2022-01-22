package battleship;

import battleship.Vessels.Vessel;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private final int[] topHeaderArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private final char[] sideHeaderArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    private char[][] map = new char[10][10];

    public List<Vessel> vesselList;

    Map() {
        vesselList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                map[i][j] = '~';
            }
        }

        showMap();
    }

    public int[] getTopHeaderArray() {
        return topHeaderArray;
    }

    public char[] getSideHeaderArray() {
        return sideHeaderArray;
    }

    public char[][] getMap() {
        return map;
    }

    public void showMap() {
        System.out.print("  ");
        for(int element : topHeaderArray) {
            System.out.print(element + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(sideHeaderArray[i] + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void showHitMap() {
        System.out.print("  ");
        for(int element : topHeaderArray) {
            System.out.print(element + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(sideHeaderArray[i] + " ");
            for (int j = 0; j < 10; j++) {
                if (map[i][j] != 'O') {
                    System.out.print(map[i][j] + " ");
                } else {
                    System.out.print("~ ");
                }
            }
            System.out.println();
        }
        //System.out.println();
    }

    public void placeOnMap(Vessel vessel) {
        vesselList.add(vessel);
        int[][] vesselCoordinates = vessel.getLocation().getBodyCoordinates();
        for (int i = 0; i < vesselCoordinates.length; i++) {
            map[vesselCoordinates[i][1]][vesselCoordinates[i][0]] = 'O';
        }
    }

    public boolean checkCoincide(Location location) {
        boolean result = false;
        int[][] toBeCheckedCoordinates = location.getBodyCoordinates();

        for (Vessel vessel: vesselList) {
            int[][] coincideSearchedItem = vessel.getLocation().getBodyBoundaryCoordinates();
            for (int i = 0; i < toBeCheckedCoordinates.length; i++) {
                for (int j = 0; j < coincideSearchedItem.length; j++) {
                    int toBeCheckedCoordinateX = toBeCheckedCoordinates[i][0];
                    int toBeCheckedCoordinateY = toBeCheckedCoordinates[i][1];
                    int coincideSearchedItemX = coincideSearchedItem[j][0];
                    int coincideSearchedItemY = coincideSearchedItem[j][1];
                    if (toBeCheckedCoordinateX == coincideSearchedItemX
                        && toBeCheckedCoordinateY == coincideSearchedItemY) {
                        result = true;
                    }
                }
            }
        }

        return result;
    }

    public boolean didItShot(Coordinate coordinate) {
        if (map[coordinate.getY()][coordinate.getX()] == 'O' || map[coordinate.getY()][coordinate.getX()] == 'X' ) {
            map[coordinate.getY()][coordinate.getX()] = 'X';
            return true;
        } else {
            map[coordinate.getY()][coordinate.getX()] = 'M';
        }
        return false;
    }
}
