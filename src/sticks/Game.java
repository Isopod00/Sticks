package sticks;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the game of Sticks... in JAVA!");
        System.out.println("So, would you like to play?");

        if (scan.next().equalsIgnoreCase("yes") || scan.next().equalsIgnoreCase("y")) {
            System.out.println("Awesome, have fun!");
            play();
        } else {
            System.out.println("Oh okay, goodbye then!");
        }
    }

    private static void play() {
        Player player1 = new Player();
        Player player2 = new Player();
        boolean playing = true;
        int turn = 1;

        System.out.println();

        while (playing) {
            if (turn % 2 == 0) {
                System.out.println("It's Player 1's turn!");
            } else {
                System.out.println("It's Player 2's turn!");
            }
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
