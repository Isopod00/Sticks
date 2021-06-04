package sticks;

import java.util.Scanner;

public class Game {

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
                player1.add(player1.getRH().getFingers() * -1, player1.getRH());
            }
            if (player2.getRH().dead()) {
                player2.add(player2.getRH().getFingers() * -1, player2.getRH());
            }
            if (player1.getLH().dead()) {
                player1.add(player1.getLH().getFingers() * -1, player1.getLH());
            }
            if (player2.getLH().dead()) {
                player2.add(player2.getLH().getFingers() * -1, player2.getLH());
            }

            if (turn % 2 == 0) {
                boolean actionChosen = false;
                System.out.println("\n\tIt's " + player1.getName() + "'s turn!");
                System.out.println(player1);
                System.out.println(player2);
                while (!actionChosen) {
                    System.out.print("\tYour next move: ");
                    String move = scan.nextLine();
                    if (move.equalsIgnoreCase("RL") && player2.add(player1.getRH().getFingers(), player2.getLH())) {
                        actionChosen = true;
                    } else if (move.equalsIgnoreCase("LR") && player2.add(player1.getLH().getFingers(), player2.getRH())) {
                        actionChosen = true;
                    } else if (move.equalsIgnoreCase("RR") && player2.add(player1.getRH().getFingers(), player2.getRH())) {
                        actionChosen = true;
                    } else if (move.equalsIgnoreCase("LL") && player2.add(player1.getLH().getFingers(), player2.getLH())) {
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
                    if (move.equalsIgnoreCase("RL") && player1.add(player2.getRH().getFingers(), player1.getLH())) {
                        actionChosen = true;
                    } else if (move.equalsIgnoreCase("LR") && player1.add(player2.getLH().getFingers(), player1.getRH())) {
                        actionChosen = true;
                    } else if (move.equalsIgnoreCase("RR") && player1.add(player2.getRH().getFingers(), player1.getRH())) {
                        actionChosen = true;
                    } else if (move.equalsIgnoreCase("LL") && player1.add(player2.getLH().getFingers(), player1.getLH())) {
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
                player1.add(player1.getRH().getFingers() * -1, player1.getRH());
            }
            if (player2.getRH().dead()) {
                player2.add(player2.getRH().getFingers() * -1, player2.getRH());
            }
            if (player1.getLH().dead()) {
                player1.add(player1.getLH().getFingers() * -1, player1.getLH());
            }
            if (player2.getLH().dead()) {
                player2.add(player2.getLH().getFingers() * -1, player2.getLH());
            }

            if (turn % 2 == 0) {
                System.out.println("\n\tIt's the Computer's turn!");
                System.out.println(player1);
                System.out.println(player2);
                System.out.print("\tThe Computer's move: ");
                boolean actionChosen = false;

                while (!actionChosen) {
                    int choice = (int) (Math.random() * 4);
                    if (choice == 0 && player1.add(player2.getRH().getFingers(), player1.getLH())) {
                        System.out.println("RL");
                        actionChosen = true;
                    } else if (choice == 1 && player1.add(player2.getLH().getFingers(), player1.getRH())) {
                        System.out.println("LR");
                        actionChosen = true;
                    } else if (choice == 2 && player1.add(player2.getRH().getFingers(), player1.getRH())) {
                        System.out.println("RR");
                        actionChosen = true;
                    } else if (choice == 3 && player1.add(player2.getLH().getFingers(), player1.getLH())) {
                        System.out.println("LL");
                        actionChosen = true;
                    } else if (choice == 4 && player2.split()) {
                        System.out.println("Split");
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
                    if (move.equalsIgnoreCase("RL") && player2.add(player1.getRH().getFingers(), player2.getLH())) {
                        actionChosen = true;
                    } else if (move.equalsIgnoreCase("LR") && player2.add(player1.getLH().getFingers(), player2.getRH())) {
                        actionChosen = true;
                    } else if (move.equalsIgnoreCase("RR") && player2.add(player1.getRH().getFingers(), player2.getRH())) {
                        actionChosen = true;
                    } else if (move.equalsIgnoreCase("LL") && player2.add(player1.getLH().getFingers(), player2.getLH())) {
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
