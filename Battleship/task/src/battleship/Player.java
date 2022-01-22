package battleship;

import battleship.Placement;

public class Player {
    public Map map;
    public Placement placement;
    public Shooting shooting;

    public Player() {
        map = new Map();

        placement = new Placement();
        placement.selectMap(map);
        placement.placeVessels();
    }

    public void findARival(Player rival) {
        shooting = new Shooting(rival.map);
    }
}
