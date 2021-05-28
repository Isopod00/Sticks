package sticks;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the game of Sticks... in JAVA!");
        System.out.println("So, would you like to play?");

        String response = scan.nextLine();
        if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y")) {
            System.out.println("Awesome, have fun! \n");
            play();
        } else {
            System.out.println("Oh okay, goodbye then!");
        }
    }

    private static void play() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Player 1, what is your name?");

        Player player1 = new Player(scan.nextLine());
        System.out.println("Player 2, what is your name?");
        Player player2 = new Player(scan.nextLine());
        boolean playing = true;
        int turn = 1;

        System.out.println();

        while (playing) {
            if (player1.getRH().dead()) {
                player1.getRH().add(player1.getRH().getFingers() * -1);
            }
            if (player2.getRH().dead()) {
                player2.getRH().add(player2.getRH().getFingers() * -1);
            }
            if (player1.getLH().dead()) {
                player1.getLH().add(player1.getLH().getFingers() * -1);
            }
            if (player2.getLH().dead()) {
                player2.getLH().add(player2.getLH().getFingers() * -1);
            }

            if (turn % 2 == 0) {
                System.out.println("It's " + player1.getName() + "'s turn!\n");
                System.out.println(player1);
                System.out.println(player2);
                System.out.print("Your next move: ");
                String move = scan.nextLine();
                if (move.equalsIgnoreCase("RL")) {
                    player2.getLH().add(player1.getRH().getFingers());
                } else if (move.equalsIgnoreCase("LR")) {
                    player2.getRH().add(player1.getLH().getFingers());
                } else if (move.equalsIgnoreCase("RR")) {
                    player2.getRH().add(player1.getRH().getFingers());
                } else if (move.equalsIgnoreCase("LL")) {
                    player2.getLH().add(player1.getLH().getFingers());
                } else if (move.equalsIgnoreCase("Split")) {
                    player1.split();
                }
            } else {
                System.out.println("It's " + player2.getName() + "'s turn!\n");
                System.out.println(player1);
                System.out.println(player2);
                System.out.print("Your next move: ");
                String move = scan.nextLine();
                if (move.equalsIgnoreCase("RL")) {
                    player1.getLH().add(player2.getRH().getFingers());
                } else if (move.equalsIgnoreCase("LR")) {
                    player1.getRH().add(player2.getLH().getFingers());
                } else if (move.equalsIgnoreCase("RR")) {
                    player1.getRH().add(player2.getRH().getFingers());
                } else if (move.equalsIgnoreCase("LL")) {
                    player1.getLH().add(player2.getLH().getFingers());
                } else if (move.equalsIgnoreCase("Split")) {
                    player2.split();
                }
            }
            if ((player1.getRH().dead() && player1.getLH().dead()) || (player2.getRH().dead() && player2.getLH().dead())) {
                playing = false;
            }
            System.out.println();
            turn++;
        }
        gameOver();
    }

    private static void gameOver() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Game Over, would you like to play again?");

        if (scan.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Awesome, have fun!");
            play();
        } else {
            System.out.println("Oh okay, goodbye then!");
        }
    }
}
