package battleship;

import java.util.ArrayList;
import java.util.Arrays;

public class Location {
    private Map map;
    private String location;

    private String startPoint;
    private String endPoint;

    private Coordinate startCoordinate;
    private Coordinate endCoordinate;

    private int xSize;
    private int ySize;

    private int vesselSize;

    private int[][] bodyCoordinates;

    private int[][] bodyBoundaryCoordinates;


    public Location(Map map, String location) {
        this.map = map;
        this.location = location;
        String[] locationString = location.split(" ");
        this.startPoint = locationString[0];
        this.endPoint = locationString[1];

        startCoordinate = new Coordinate(map, startPoint);
        endCoordinate = new Coordinate(map, endPoint);

        xSize = Math.abs(startCoordinate.getX() - endCoordinate.getX()) + 1;
        ySize = Math.abs(startCoordinate.getY() - endCoordinate.getY()) + 1;

        vesselSize = xSize > ySize ? xSize : ySize;

        this.bodyCoordinates = getBodyCoordinates();
        this.bodyBoundaryCoordinates = getBodyBoundaryCoordinates();
    }

    public String getLocation() {
        return location;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public Coordinate getStartCoordinate() {
        return startCoordinate;
    }

    public Coordinate getEndCoordinate() {
        return endCoordinate;
    }

    public int getXSize() {
        return xSize;
    }

    public int getYSize() {
        return ySize;
    }

    public int getVesselSize() {
        return vesselSize;
    }

    public int[][] getBodyCoordinates() {

        int[][] vesselBodyCoordinates = new int[xSize > ySize ? xSize : ySize][2];
        if (xSize > ySize) {

            int startPoint;
            if (startCoordinate.getX() < endCoordinate.getX()) {
                startPoint = startCoordinate.getX();
            } else {
                startPoint = endCoordinate.getX();
            }

            for (int i = 0; i < xSize; i++) {
                vesselBodyCoordinates[i][0] = startPoint + i;
                vesselBodyCoordinates[i][1] = startCoordinate.getY();
            }

            return vesselBodyCoordinates;
        }

        if (ySize > xSize) {

            int startPoint;
            if (startCoordinate.getY() < endCoordinate.getY()) {
                startPoint = startCoordinate.getY();
            } else {
                startPoint = endCoordinate.getY();
            }

            for (int i = 0; i < ySize; i++) {
                vesselBodyCoordinates[i][0] = startCoordinate.getX();
                vesselBodyCoordinates[i][1] = startPoint + i;
            }

            return vesselBodyCoordinates;
        }

        return null;
    }

    public int[][] getBodyBoundaryCoordinates() {
        int startPointX = 0;
        int startPointY = 0;
        int endPointX = 0;
        int endPointY = 0;

        if (xSize > ySize) {
            if (startCoordinate.getX() < endCoordinate.getX()) {
                if (startCoordinate.getX() > 1) {
                    startPointX = startCoordinate.getX() - 1;
                } else {
                    startPointX = startCoordinate.getX();
                }

                if (startCoordinate.getY() > 1) {
                    startPointY = startCoordinate.getY() - 1;
                } else {
                    startPointY = startCoordinate.getY();
                }

                if (endCoordinate.getX() < 9) {
                    endPointX = endCoordinate.getX() + 1;
                } else {
                    endPointX = endCoordinate.getX();
                }

                if (endCoordinate.getY() < 9) {
                    endPointY = endCoordinate.getY() + 1;
                } else {
                    endPointY = endCoordinate.getY();
                }
            } else {
                if (endCoordinate.getX() > 1) {
                    startPointX = endCoordinate.getX() - 1;
                } else {
                    startPointX = endCoordinate.getX();
                }

                if (endCoordinate.getY() > 1) {
                    startPointY = endCoordinate.getY() - 1;
                } else {
                    startPointY = endCoordinate.getY();
                }

                if (startCoordinate.getX() < 9) {
                    endPointX = endCoordinate.getX() + 1;
                } else {
                    endPointX = endCoordinate.getX();
                }

                if (startCoordinate.getY() < 9) {
                    endPointY = endCoordinate.getY() + 1;
                } else {
                    endPointY = endCoordinate.getY();
                }
            }
        }

        if (ySize > xSize) {

            if (startCoordinate.getY() < endCoordinate.getY()) {
                if (startCoordinate.getX() > 1) {
                    startPointX = startCoordinate.getX() - 1;
                } else {
                    startPointX = startCoordinate.getX();
                }

                if (startCoordinate.getY() > 1) {
                    startPointY = startCoordinate.getY() - 1;
                } else {
                    startPointY = startCoordinate.getY();
                }

                if (endCoordinate.getX() < 9) {
                    endPointX = endCoordinate.getX() + 1;
                } else {
                    endPointX = endCoordinate.getX();
                }

                if (endCoordinate.getY() < 9) {
                    endPointY = endCoordinate.getY() + 1;
                } else {
                    endPointY = endCoordinate.getY();
                }
            } else {
                if (endCoordinate.getX() > 1) {
                    startPointX = endCoordinate.getX() - 1;
                } else {
                    startPointX = endCoordinate.getX();
                }

                if (endCoordinate.getY() > 1) {
                    startPointY = endCoordinate.getY() - 1;
                } else {
                    startPointY = endCoordinate.getY();
                }

                if (startCoordinate.getX() < 9) {
                    endPointX = endCoordinate.getX() + 1;
                } else {
                    endPointX = endCoordinate.getX();
                }

                if (startCoordinate.getY() < 9) {
                    endPointY = endCoordinate.getY() + 1;
                } else {
                    endPointY = endCoordinate.getY();
                }
            }
        }
        int boundarySize = (Math.abs(startPointX - endPointX) + 1)
                            *
                            (Math.abs(startPointY - endPointY) + 1);

        int[][] vesselBodyBoundaries = new int[boundarySize][2];

        //            System.out.println("startPointX: " + startPointX);
        //            System.out.println("startPointY: " + startPointY);
        //            System.out.println("endPointX: " + endPointX);
        //            System.out.println("endPointY: " + endPointY);

        int k = 0;

        for (int i = startPointY; i <= endPointY; i++) {
            for (int j = startPointX; j <= endPointX; j++) {
                vesselBodyBoundaries[k][0] = j;
                vesselBodyBoundaries[k][1] = i;
                k++;
            }
        }
        return vesselBodyBoundaries;
    }

    public ArrayList<Coordinate> getAllCoordinates() {
        ArrayList<Coordinate> coordinates = new ArrayList<>();

        if (startCoordinate.getX() == endCoordinate.getX()) {
            if (startCoordinate.getY() < endCoordinate.getY()) {
                for (int y = startCoordinate.getY(); y <= endCoordinate.getY(); y++) {
                    coordinates.add(new Coordinate(startCoordinate.getX(), y));
                }
            } else if (startCoordinate.getY() > endCoordinate.getY()) {
                for (int y = startCoordinate.getY(); y >= endCoordinate.getY(); y--) {
                    coordinates.add(new Coordinate(startCoordinate.getX(), y));
                }
            }
        }
        else if (startCoordinate.getY() == endCoordinate.getY()) {
            if (startCoordinate.getX() < endCoordinate.getX()) {
                for (int x = startCoordinate.getX(); x <= endCoordinate.getX(); x++) {
                    coordinates.add(new Coordinate(x, startCoordinate.getY()));
                }
            } else if (startCoordinate.getX() > endCoordinate.getX()) {
                for (int x = startCoordinate.getX(); x >= endCoordinate.getX(); x--) {
                    coordinates.add(new Coordinate(x, startCoordinate.getY()));
                }
            }
        }

//        for (Coordinate coordinate : coordinates) {
//            System.out.println("x = " + coordinate.getX() + " y = " + coordinate.getY());
//        }

        return coordinates;
    }
}