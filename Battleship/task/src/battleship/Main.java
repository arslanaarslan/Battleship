package battleship;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Write your code here
        Player player1;
        Player player2;

        boolean rivalIsFound = false;

        System.out.println("Player 1, place your ships on the game field\n");
        player1 = new Player();

        System.out.println("Press Enter and pass the move to another player");
        System.out.println("...");
        System.in.read();

        System.out.println("Player 2, place your ships on the game field\n");
        player2 = new Player();

        Player player = player2;
        Player rival = player1;

        while (true) {
            System.out.println("Press Enter and pass the move to another player");
            System.out.println("...");
            System.in.read();
            System.out.println();
            if (player.equals(player2)) {
                player = player1;
                rival = player2;
            } else {
                player = player2;
                rival = player1;
            }

            if (!rivalIsFound) {
                player1.findARival(player2);
                player2.findARival(player1);
                rivalIsFound = true;
            }

            rival.map.showHitMap();
            System.out.println("---------------------");
            player.map.showMap();
            System.out.println();

            if (player.equals(player1)) {
                System.out.println("Player 1, it's your turn:");
                System.out.println();
                player1.shooting.sendTorpedo();
            } else {
                System.out.println("Player 2, it's your turn:");
                System.out.println();
                player2.shooting.sendTorpedo();
            }
        }
    }
}


/*
    F3 F7
    A1 D1
    J10 J8
    B9 D9
    I2 J2

    Rival Ships Location:

    H2 H6
    F3 F6
    H8 F8
    D4 D6
    C8 D8
* */