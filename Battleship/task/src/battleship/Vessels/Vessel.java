package battleship.Vessels;

import battleship.Coordinate;
import battleship.Location;
import battleship.Map;

import java.util.ArrayList;

public class Vessel {
    private Map map;
    private String locationString;
    private Location location;
    private int size;
    private ArrayList<Coordinate> coordinates = new ArrayList<>();

    private boolean alive;

    private boolean valid;

    public Vessel (Map map, String location, int size) {
        this.map = map;
        this.locationString = location;
        this.location = new Location(map, location);
        this.size = size;
        this.alive = true;
    }

    public String getLocationString() {
        return locationString;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getSize() {
        return this.size;
    }

    protected void setSize(int size) {
        this.size = size;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isValid() {
        valid = false;

        boolean vesselOnXAxis = this.location.getXSize() == 1 && this.location.getYSize() > 1;
        boolean vesselOnYAxis = this.location.getYSize() == 1 && this.location.getXSize() > 1;
        if (!vesselOnXAxis && !vesselOnYAxis) {
            System.out.println("Error! Wrong ship location! Try again:");
            valid = false;
            return false;
        }
        int vesselSize = location.getVesselSize();
        if (vesselSize != this.size) {
            System.out.println("Error! Wrong length of the " + this.getClass().getSimpleName() + "! Try again:");
            valid = false;
            return false;
        }

        boolean coincideResult = map.checkCoincide(this.location);
        if (coincideResult) {
            System.out.println("Error! You placed it too close to another one. Try again:");
            valid = false;
            return false;
        }

        valid = true;
        return true;
    }
}
