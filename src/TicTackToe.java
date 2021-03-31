import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTackToe {
    public static void main(String[] args) {
        //create an invitation()+;
        //create a  gamefield() +
        //create block checkOfVictory() +
        // create exit() +
        //create usersEnters(usersTurn) with checking +
        //create computersTurn() +
        invitation();
        int[] signs = new int[9];
        int turnsCounter = 0;
        boolean fortune = whoTurnsFirst();
        while (true) {
            if (fortune) {
                usersTurn(signs);
                display(signs);
                checkOfVictory(signs);
                computersTurn(signs);
                display(signs);
                checkOfVictory(signs);
            } else {
                computersTurn(signs);
                display(signs);
                checkOfVictory(signs);
                usersTurn(signs);
                display(signs);
                checkOfVictory(signs);
            }
            turnsCounter++;
            if (turnsCounter > 3) {
                System.out.println("Sorry, DRAW!");
                exit();
            }
        }
    }

    public static void checkOfVictory(int[] array) {
        boolean justOneisNotNull = true;
        int notNull = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[0] == 2 && array[1] == 2 && array[2] == 2 ||
                    array[3] == 2 && array[4] == 2 && array[5] == 2 ||
                    array[6] == 2 && array[7] == 2 && array[8] == 2 ||

                    array[0] == 2 && array[3] == 2 && array[6] == 2 ||
                    array[1] == 2 && array[4] == 2 && array[7] == 2 ||
                    array[2] == 2 && array[5] == 2 && array[8] == 2 ||

                    array[6] == 2 && array[4] == 2 && array[2] == 2 ||
                    array[0] == 2 && array[4] == 2 && array[8] == 2) {
                System.out.println("Computer WIN!!!");
                exit();
            } else if ((array[0] == 1 && array[1] == 1 && array[2] == 1 ||
                    array[3] == 1 && array[4] == 1 && array[5] == 1 ||
                    array[6] == 1 && array[7] == 1 && array[8] == 1 ||

                    array[0] == 1 && array[3] == 1 && array[6] == 1 ||
                    array[1] == 1 && array[4] == 1 && array[7] == 1 ||
                    array[2] == 1 && array[5] == 1 && array[8] == 1 ||

                    array[6] == 1 && array[4] == 1 && array[2] == 1 ||
                    array[0] == 1 && array[4] == 1 && array[8] == 1)) {
                System.out.println("Congratulations!!! You WIN!!!");
                exit();
            }
            return;
        }
    }

    public static void invitation() {
        System.out.println("Welcome to TicTackToe");
        System.out.println();
        System.out.println("You are going to play with sign \"X\".");
        System.out.println("Use buttons with digits (from 1 to 9) to make your turn");
        System.out.println();
        System.out.println("___________________");
        System.out.println("|  7  |  8  |  9  |");
        System.out.println("-------------------");
        System.out.println("|  4  |  5  |  6  |");
        System.out.println("-------------------");
        System.out.println("|  1  |  2  |  3  |");
        System.out.println("___________________");
        System.out.println();
        System.out.println("Put three X-es inline to win! GooD LucK!)");
    }

    public static void display(int[] gamefield) {
        char[] g = new char[9];
        for (int i = 0; i < gamefield.length; i++) {
            if (gamefield[i] == 1) {
                g[i] = 'X';
            } else if (gamefield[i] == 2) {
                g[i] = 'O';
            } else g[i] = ' ';
        }
        System.out.println("___________________");
        System.out.println("|  " + g[6] + "  |  " + g[7] + "  |  " + g[8] + "  |");
        System.out.println("-------------------");
        System.out.println("|  " + g[3] + "  |  " + g[4] + "  |  " + g[5] + "  |");
        System.out.println("-------------------");
        System.out.println("|  " + g[0] + "  |  " + g[1] + "  |  " + g[2] + "  |");
        System.out.println("___________________");
    }

    public static int usersTurn(int[] array) {
        int usersEnter;
        while (true) {
            System.out.println("Make your turn, please:");
            usersEnter = new Scanner(System.in).nextInt();
            usersEnter = usersEnter - 1;
            if (usersEnter < 0 || usersEnter > 9) { // why can't I  cross this conditions ?
                System.out.println("Your number MUST be from 1 to 9! Try again");
            } else if (array[usersEnter] == 1 || array[usersEnter] == 2) {
                System.out.println("This position is busy, choose other position");
            } else {
                break;
            }
        }
        return array[usersEnter] = 1;
    }

    public static int computersTurn(int[] array) {
        int computerEnter = 0;
        boolean isNotEmpty = true;
        while (isNotEmpty) {
            computerEnter = new Random().nextInt(8);
            if (array[computerEnter] == 1 || array[computerEnter] == 2) {
                isNotEmpty = true;
            } else {
                break;
            }
        }
        return array[computerEnter] = 2;
    }

    public static boolean whoTurnsFirst() {
        int fortune = new Random().nextInt(2);
        if (fortune == 1) {
            return true;
        }
        return false;
    }

    public static void exit() {
        System.out.println("GAME OVER!");
        System.exit(2);
    }
}


