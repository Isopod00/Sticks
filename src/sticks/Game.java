package sticks;

import java.util.Scanner;

public class Game {

    /* Game Class
       creates a Hand object that has the number of fingers stored.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the game of Sticks... in JAVA!");
        System.out.print("So, would you like to play? ");

        String response = scan.nextLine();
        if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y")) {
            System.out.print("\nAwesome, would you like to play 2 player or 1 player? Enter a 1 or a 2: ");
            response = scan.nextLine();
            if (response.equals("2")) {
                play();
            } else if (response.equals("1")) {
                playComputer();
            }
        } else {
            System.out.println("Oh okay, goodbye then!");
        }
    }

    // Creates game for 2 player
    private static void play() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Player 1, what is your name? ");
        Player player1 = new Player(scan.nextLine());
        System.out.print("Player 2, what is your name? ");
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
                boolean actionChosen = false;
                System.out.println("\n\tIt's " + player1.getName() + "'s turn!");
                System.out.println(player1);
                System.out.println(player2);
                while (!actionChosen) {
                    System.out.print("\tYour next move: ");
                    String move = scan.nextLine();
                    if (move.equalsIgnoreCase("RL") && !player1.getRH().dead() && player2.getLH().add(player1.getRH().getFingers())) {
                        actionChosen = true;
                    } else if (move.equalsIgnoreCase("LR") && !player1.getLH().dead() && player2.getLH().add(player1.getLH().getFingers())) {
                        actionChosen = true;
                    } else if (move.equalsIgnoreCase("RR") && !player1.getRH().dead() && player2.getRH().add(player1.getRH().getFingers())) {
                        actionChosen = true;
                    } else if (move.equalsIgnoreCase("LL") && !player1.getLH().dead() && player2.getLH().add(player1.getLH().getFingers())) {
                        actionChosen = true;
                    } else if (move.equalsIgnoreCase("Split") && player1.split()) {
                        actionChosen = true;
                    }
                }
            } else {
                boolean actionChosen = false;
                System.out.println("\n\tIt's " + player2.getName() + "'s turn!");
                System.out.println(player1);
                System.out.println(player2);
                while (!actionChosen) {
                    System.out.print("\tYour next move: ");
                    String move = scan.nextLine();
                    if (move.equalsIgnoreCase("RL") && !player2.getRH().dead() && player1.getLH().add(player2.getRH().getFingers())) {
                        actionChosen = true;
                    } else if (move.equalsIgnoreCase("LR") && !player2.getLH().dead() && player1.getRH().add(player2.getLH().getFingers())) {
                        actionChosen = true;
                    } else if (move.equalsIgnoreCase("RR") && !player2.getRH().dead() && player1.getRH().add(player2.getRH().getFingers())) {
                        actionChosen = true;
                    } else if (move.equalsIgnoreCase("LL") && !player2.getLH().dead() && player1.getLH().add(player2.getLH().getFingers())) {
                        actionChosen = true;
                    } else if (move.equalsIgnoreCase("Split") && player2.split()) {
                        actionChosen = true;
                    }
                }
            }
            if (player1.dead()) {
                System.out.println("\n" + player2.getName() + " has won after " + turn + " turns!");
                playing = false;
            } else if (player2.dead()) {
                System.out.println("\n" + player1.getName() + " has won after " + turn + " turns!");
                playing = false;
            } else {
                System.out.println();
                turn++;
            }
        }
        gameOver();
    }

    // Creates game for 1 player against computer
    private static void playComputer() {
        Scanner scan = new Scanner(System.in);

        System.out.print("What is your name? ");
        Player player1 = new Player(scan.nextLine());
        Player player2 = new Player("Computer");

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
                System.out.println("\n\tIt's the Computer's turn!");
                System.out.println(player1);
                System.out.println(player2);
                System.out.print("\tThe Computer's move: ");
                boolean actionChosen = false;

                while (!actionChosen) {
                    int choice = (int) (Math.random() * 4);
                    if (player2.split()) {
                        System.out.println("Split");
                        actionChosen = true;
                    } else if (choice == 0 && !player2.getRH().dead() && player1.getLH().add(player2.getRH().getFingers())) {
                        System.out.println("RL");
                        actionChosen = true;
                    } else if (choice == 1 && !player2.getLH().dead() && player1.getRH().add(player2.getLH().getFingers())) {
                        System.out.println("LR");
                        actionChosen = true;
                    } else if (choice == 2 && !player2.getRH().dead() && player1.getRH().add(player2.getRH().getFingers())) {
                        System.out.println("RR");
                        actionChosen = true;
                    } else if (choice == 3 && !player2.getLH().dead() && player1.getLH().add(player2.getLH().getFingers())) {
                        System.out.println("LL");
                        actionChosen = true;
                    }
                }
            } else {
                boolean actionChosen = false;
                System.out.println("\n\tIt's " + player1.getName() + "'s turn!");
                System.out.println(player1);
                System.out.println(player2);
                while (!actionChosen) {
                    System.out.print("\tYour next move: ");
                    String move = scan.nextLine();
                    if (move.equalsIgnoreCase("RL") && !player1.getRH().dead() && player2.getLH().add(player1.getRH().getFingers())) {
                        actionChosen = true;
                    } else if (move.equalsIgnoreCase("LR") && !player1.getLH().dead() && player2.getRH().add(player1.getLH().getFingers())) {
                        actionChosen = true;
                    } else if (move.equalsIgnoreCase("RR") && !player1.getRH().dead() && player2.getRH().add(player1.getRH().getFingers())) {
                        actionChosen = true;
                    } else if (move.equalsIgnoreCase("LL") && !player1.getLH().dead() && player2.getLH().add(player1.getLH().getFingers())) {
                        actionChosen = true;
                    } else if (move.equalsIgnoreCase("Split") && player1.split()) {
                        actionChosen = true;
                    }
                }
            }
            if (player1.dead()) {
                System.out.println("\n The Computer has won after " + turn + " turns!");
                playing = false;
            } else if (player2.dead()) {
                System.out.println("\n" + player1.getName() + " has won after " + turn + " turns!");
                playing = false;
            } else {
                System.out.println();
                turn++;
            }
        }

        gameOver();
    }

    private static void gameOver() {
        Scanner scan = new Scanner(System.in);

        System.out.print("\nGame Over, would you like to play again? ");

        String response = scan.nextLine();
        if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y")) {
            System.out.print("\nAwesome, would you like to play 2 player or 1 player? Enter a 1 or a 2: ");
            response = scan.nextLine();
            if (response.equals("2")) {
                play();
            } else if (response.equals("1")) {
                playComputer();
            }
        } else {
            System.out.println("Oh okay, goodbye then!");
        }
    }
}
