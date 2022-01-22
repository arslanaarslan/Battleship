package battleship;

import battleship.Vessels.Battleship;
import battleship.Vessels.Vessel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Shooting {
    static Scanner scanner = new Scanner(System.in);
    Map map;
    ArrayList<Coordinate> shotCoordinates;

    public Shooting(Map map) {
        shotCoordinates = new ArrayList<>();
        this.map = map;
    }


    public void sendTorpedo() {
        /*
        System.out.println("The game starts!");
        System.out.println();
        map.showHitMap();
        System.out.println("Take a shot");
        System.out.println();
         */
        boolean isValid = false;
        boolean result = false;

        Coordinate shotCoordinate = null;

        while (map.vesselList.get(0).isAlive() || map.vesselList.get(1).isAlive()
                || map.vesselList.get(2).isAlive() || map.vesselList.get(3).isAlive()
                || map.vesselList.get(4).isAlive()) {
            while (true) {
                String toBeShotCoordinate = scanner.nextLine();
                shotCoordinate = new Coordinate(map, toBeShotCoordinate);
                System.out.println();
                // System.out.println(shotCoordinate.getX());
                // System.out.println(shotCoordinate.getY());

                if (shotCoordinate.getX() >= 0 && shotCoordinate.getY() >= 0) {
                    isValid = true;
                    result = map.didItShot(shotCoordinate);
                } else {
                    /*
                    System.out.println("Error! You entered the wrong coordinates! Try again:");
                    System.out.println();
                    */
                }
                break;
            }

            if (result) {
                shotCoordinates.add(shotCoordinate);

                //map.showHitMap();
                if (isSankAnyShip()) {
                    if (!map.vesselList.get(0).isAlive() && !map.vesselList.get(1).isAlive()
                            && !map.vesselList.get(2).isAlive() && !map.vesselList.get(3).isAlive()
                            && !map.vesselList.get(4).isAlive()) {
                        System.out.println("You sank the last ship. You won. Congratulations!");
                    } else {
                        //System.out.println("You sank a ship! Specify a new target:");
                        System.out.println("You sank a ship!");
                    }
                } else {
                    System.out.println("You hit a ship!");
                }
                System.out.println();
//                map.showMap();
            } else {
                //map.showHitMap();
                //System.out.println("You missed. Try again:");
                System.out.println("You missed!");
                System.out.println();
//                map.showMap();
            }
            break;
        }

    }

    public boolean isSankAnyShip() {
        // AirCroftCarrier
        if (isSank(shotCoordinates, map.vesselList.get(0).getLocation().getAllCoordinates())) {
            if (map.vesselList.get(0).isAlive()) {
                map.vesselList.get(0).setAlive(false);
                return true;
            }
        }

        // Battleship
        if (isSank(shotCoordinates, map.vesselList.get(1).getLocation().getAllCoordinates())) {
            if (map.vesselList.get(1).isAlive()) {
                map.vesselList.get(1).setAlive(false);
                return true;
            }
        }

        // Submarine
        if (isSank(shotCoordinates, map.vesselList.get(2).getLocation().getAllCoordinates())) {
            if (map.vesselList.get(2).isAlive()) {
                map.vesselList.get(2).setAlive(false);
                return true;
            }
        }

        // Cruiser
        if (isSank(shotCoordinates, map.vesselList.get(3).getLocation().getAllCoordinates())) {
            if (map.vesselList.get(3).isAlive()) {
                map.vesselList.get(3).setAlive(false);
                return true;
            }
        }

        // Destroyer
        if (isSank(shotCoordinates, map.vesselList.get(4).getLocation().getAllCoordinates())) {
            if (map.vesselList.get(4).isAlive()) {
                map.vesselList.get(4).setAlive(false);
                return true;
            }
        }

        return false;
    }

    public static boolean isSank(ArrayList<Coordinate> shotCoordinates, ArrayList<Coordinate> vesselCoordinates) {
        boolean[] vesselState = new boolean[vesselCoordinates.size()];

        int i = 0;
        for (Coordinate vesselCoordinate: vesselCoordinates) {
            for (Coordinate shotCoordinate : shotCoordinates) {
                if (Coordinate.equal(vesselCoordinate, shotCoordinate)) {
                    vesselState[i] = true;
                    break;
                }
            }
            i++;
        }

//        for (Coordinate coordinate : vesselCoordinates) {
//            System.out.println("Vessel Coordinate x = " + coordinate.getX() + " y = " + coordinate.getY());
//        }
//
//        for (Coordinate coordinate : shotCoordinates) {
//            System.out.println("Shot Coordinate x = " + coordinate.getX() + " y = " + coordinate.getY());
//        }

        for (i = 0; i < vesselState.length; i++) {
//            System.out.println("Vessel Array State =" + vesselState[i]);
            if (vesselState[i] == false) {
                return false;
            }
        }

        return true;
    }
}
