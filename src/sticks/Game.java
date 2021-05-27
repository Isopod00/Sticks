package sticks;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the game of Sticks... in JAVA!");
        System.out.println("So, would you like to play?");

        String response = scan.next();
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
        Player player1 = new Player(scan.next());
        System.out.println("Player 2, what is your name?");
        Player player2 = new Player(scan.next());
        boolean playing = true;
        int turn = 1;

        System.out.println();

        while (playing) {
            if (turn % 2 == 0) {
                System.out.println("It's " + player1.getName() + "'s turn!");
                player1.toString();
                player2.toString();
                System.out.print("Your next move: ");
                String move = scan.next();
                if (move.equalsIgnoreCase("RL")) {

                } else if (move.equalsIgnoreCase("LR")) {

                } else if (move.equalsIgnoreCase("Split")) {
                    player1.split();
                }
            } else {
                System.out.println("It's " + player2.getName() + "'s turn!");
                player1.toString();
                player2.toString();
                System.out.print("Your next move: ");
                String move = scan.next();
                if (move.equalsIgnoreCase("RL")) {

                } else if (move.equalsIgnoreCase("LR")) {

                } else if (move.equalsIgnoreCase("Split")) {
                    player2.split();
                }
            }
            System.out.println();
            turn++;
        }

        gameOver();
    }

    private static void gameOver() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Game Over, would you like to play again?");

        if (scan.next().equalsIgnoreCase("yes")) {
            System.out.println("Awesome, have fun!");
            play();
        } else {
            System.out.println("Oh okay, goodbye then!");
        }
    }
}
