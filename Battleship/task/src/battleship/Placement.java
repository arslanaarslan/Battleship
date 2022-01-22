package battleship;

import battleship.Vessels.*;

import javax.swing.plaf.basic.BasicTextAreaUI;
import java.util.Scanner;

public class Placement {
    Scanner scanner = new Scanner(System.in);

    private Map  map;

    public void selectMap(Map map) {
        this.map = map;
    }

    public void placeVessels() {
        /*--------------------------------------------------*/
        // Aircraft Carrier Placement
        boolean validVessel1 = false;
        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
        while (!validVessel1) {
            AircraftCarrier aircraftCarrier = new AircraftCarrier(map, scanner.nextLine());

            validVessel1 = aircraftCarrier.isValid();

            if (validVessel1) {
                map.placeOnMap(aircraftCarrier);
                map.showMap();
            }
        }
        /*--------------------------------------------------*/
        // Battleship Placement
        boolean validVessel2 = false;
        System.out.println("Enter the coordinates of the Battleship (4 cells):");
        while (!validVessel2) {
            Battleship battleship = new Battleship(map, scanner.nextLine());

            validVessel2 = battleship.isValid();

            if (validVessel2) {
                map.placeOnMap(battleship);
                map.showMap();
            }
        }
        /*--------------------------------------------------*/
        // Submarine Placement
        boolean validVessel3 = false;
        System.out.println("Enter the coordinates of the Submarine (3 cells):");
        while (!validVessel3) {
            Submarine submarine = new Submarine(map, scanner.nextLine());

            validVessel3 = submarine.isValid();

            if (validVessel3) {
                map.placeOnMap(submarine);
                map.showMap();
            }
        }
        /*--------------------------------------------------*/
        // Cruiser Placement
        boolean validVessel4 = false;
        System.out.println("Enter the coordinates of the Cruiser (3 cells):");
        while (!validVessel4) {
            Cruiser cruiser = new Cruiser(map, scanner.nextLine());

            validVessel4 = cruiser.isValid();

            if (validVessel4) {
                map.placeOnMap(cruiser);
                map.showMap();
            }
        }
        /*--------------------------------------------------*/
        // Destroyer Placement
        boolean validVessel5 = false;
        System.out.println("Enter the coordinates of the Destroyer (2 cells):");
        while (!validVessel5) {
            Destroyer destroyer = new Destroyer(map, scanner.nextLine());

            validVessel5 = destroyer.isValid();

            if (validVessel5) {
                map.placeOnMap(destroyer);
                map.showMap();
            }
        }
        /*--------------------------------------------------*/
    }

    public Map getMap() {
        return this.map;
    }
}
