import java.util.Random;
import java.util.Scanner;

public class TicTackToeWithLogic {
    private static final int X = 1;
    private static final int O = 2;

    public static void main(String[] args) {

        showInvitation();
        int[] signs = new int[9];
        while (true) {
            if (whoTurnsFirst()) {
                usersTurn(signs);
                displayGameField(signs);
                if(checkOfVictory(signs, X)) {
                    break;
                }
                if(checkForDraw(signs)) {
                    break;
                }
                computersTurn(signs);
                displayGameField(signs);
                if(checkOfVictory(signs, O)) {
                    break;
                }
            } else {
                computersTurn(signs);
                displayGameField(signs);
                if(checkOfVictory(signs, O)) {
                    break;
                }
                if(checkForDraw(signs)) {
                    break;
                }
                usersTurn(signs);
                displayGameField(signs);
                if(checkOfVictory(signs, X)) {
                    break;
                }
            }
            checkForDraw(signs);
        }
        if (checkOfVictory(signs, O)) {
            System.out.println("Computer WIN!!!");
        } else if (checkOfVictory(signs, X)) {
            System.out.println("Congratulations!!! You WIN!!!");
        }
        exit();
    }

    public static boolean checkOfVictory(int[] array, int sign) {
        return array[0] == sign && array[1] == sign && array[2] == sign ||
                array[3] == sign && array[4] == sign && array[5] == sign ||
                array[6] == sign && array[7] == sign && array[8] == sign ||

                array[0] == sign && array[3] == sign && array[6] == sign ||
                array[1] == sign && array[4] == sign && array[7] == sign ||
                array[2] == sign && array[5] == sign && array[8] == sign ||

                array[6] == sign && array[4] == sign && array[2] == sign ||
                array[0] == sign && array[4] == sign && array[8] == sign;
    }

    public static void showInvitation() {
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

    public static void displayGameField(int[] gamefield) {
        char[] g = new char[9];
        for (int i = 0; i < gamefield.length; i++) {
            if (gamefield[i] == X) {
                g[i] = 'X';
            } else if (gamefield[i] == O) {
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


    public static void usersTurn(int[] array) {
        while (true) {
            System.out.println("Make your turn, please:");
            int usersEnter = new Scanner(System.in).nextInt();
            usersEnter = usersEnter - 1;
            if (array[usersEnter] == O || array[usersEnter] == X) {
                System.out.println("This position is busy, choose other position");
            } else if (usersEnter < 0 || usersEnter > 9) { // why can't I  cross this conditions ?
                System.out.println("Your number MUST be from 1 to 9! Try again");
            } else {
                array[usersEnter] = X;
                return;
            }
        }
    }



        public static void computersTurn (int[] array){
            if (array[0] == O && array[2] == O && isEmpty(array, 1)) {
                array[1] = O;
                return;
            } else if (array[3] == O && array[5] == O && isEmpty(array, 4)) {
                array[4] = O;
                return;
            } else if (array[6] == O && array[8] == O && isEmpty(array, 7)) {
                array[7] = O;
                return;
            } else if (array[0] == O && array[6] == O && isEmpty(array, 3)) {
                array[3] = O;
                return;
            } else if (array[1] == O && array[7] == O && isEmpty(array, 4)) {
                array[4] = O;
                return;
            } else if (array[2] == O && array[8] == O && isEmpty(array, 5)) {
                array[5] = O;
                return;
            } else if (array[0] == O && array[8] == O && isEmpty(array, 4)) {
                array[4] = O;
                return;
            } else if (array[6] == O && array[2] == O && isEmpty(array, 4)) {
                array[4] = O;
                return;
            } else if (array[0] == X && isEmpty(array, 2)) {
                array[2] = O;
                return;
            } else if (array[3] == X && isEmpty(array, 5)) {
                array[5] = O;
                return;
            } else if (array[6] == X && isEmpty(array, 1)) {
                array[8] = O;
                return;
            } else if (array[7] == X && isEmpty(array, 1)) {
                array[1] = O;
                return;
            } else if (array[8] == X && isEmpty(array, 2)) {
                array[2] = O;
                return;
            }
            while (true) {
                int computerEnter = new Random().nextInt(8);
                if (isEmpty(array, computerEnter)) {
                    array[computerEnter] = O;
                    return;
                }
            }
        }

        public static boolean whoTurnsFirst () {
            return new Random().nextBoolean();
        }

        public static void exit () {
            System.out.println("GAME OVER!");
        }

        public static boolean isEmpty ( int[] array, int position){
            return array[position] == 0;
        }

        public static boolean checkForDraw ( int[] array){
            for (int value : array) {
                if (value == 0) {
                    return false;
                }
            }
            System.out.println("Sorry, DRAW!");
            return true;
        }
    }


