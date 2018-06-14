/**
 * Java 1. Home work 4
 * Реализовано 2 и 3 задание
 * При изменении SIZE - меняется размер поля диапозон от 3 до ~
 * При изменении CHIPS - количество фишек от 3 до SIZE
 *
 *
 * @author Andrew Shrvelev Author of the code Sergey Iryupin Lesson 4. Tic-tac-toe in console
 * @version dated Feb 09, 2018
 */
import java.util.Random;
import java.util.Scanner;

   class HomeWorkFour {

    final int SIZE = 6;
    final int CHIPS = 4;
    final char DOT_X = 'x';
    final char DOT_O = 'o';
    final char DOT_EMPTY = '.';
    char[][] map = new char[SIZE][SIZE];
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    public static void main(String[] args) {
        new HomeWorkFour();
    }

    HomeWorkFour() {
        initMap();
        while (true) {
            humanTurn();
            if (checkWin(DOT_X)) {
                System.out.println("YOU WON!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("AI WON!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
        }
        System.out.println("GAME OVER.");
        printMap();
    }

    void initMap() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                map[i][j] = DOT_EMPTY;
    }

    void printMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    void humanTurn() {
        int x, y;
        do {
            System.out.println("Enter X and Y (1.."+SIZE+"):");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = DOT_O;
    }

    /**
     * 2. Переделать проверку победы, чтобы она не была реализована просто набором условий,
     * например, с использованием циклов.
     * 3.*  Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и
     * количества фишек 4. Очень желательно не делать это просто набором условий для каждой
     * из возможных ситуаций;
     */

    boolean checkWin(char dot) {

        for (int i = 0; i < map.length; i++) {
            int hor = 0;
            int ver = 0;
            int diagR = 0;
            int diagL = 0;
            for (int j = 0; j < map.length; j++) {

                if (map[i][j] == dot && hor != CHIPS)
                    hor++;
                else hor = 0;

                if (map[j][i] == dot && ver != CHIPS)
                    ver++;
                else ver = 0;

                if (map[i][j] == dot) {

                    for (int k = i, l = j; k < map.length; k++, l++) {
                        if (l >= map.length || diagR == CHIPS) break;
                        if (map[k][l] == dot)
                            diagR++;
                    else break;
                    }

                    for (int k = i, l = j; l < map.length; k--, l++) {
                        if (l == -1 || k == -1 || diagL == CHIPS) break;
                        if (map[k][l] == dot)
                            diagL++;
                        else  break;
                    }
                }

                if (hor == CHIPS || ver == CHIPS || diagR == CHIPS || diagL == CHIPS)
                    return true;

                }



        }
        // check horizontals
        //if (map[0][0] == dot && map[0][1] == dot && map[0][2] == dot) return true;
        //if (map[1][0] == dot && map[1][1] == dot && map[1][2] == dot) return true;
        //if (map[2][0] == dot && map[2][1] == dot && map[2][2] == dot) return true;

        // check verticals

        //if (map[0][0] == dot && map[1][0] == dot && map[2][0] == dot) return true;
        //if (map[0][1] == dot && map[1][1] == dot && map[2][1] == dot) return true;
        //if (map[0][2] == dot && map[1][2] == dot && map[2][2] == dot) return true;

        // check diagonals
        //if (map[0][0] == dot && map[1][1] == dot && map[2][2] == dot) return true;
        //if (map[2][0] == dot && map[1][1] == dot && map[0][2] == dot) return true;
        return false;
    }

    boolean isMapFull() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (map[i][j] == DOT_EMPTY)
                    return false;
        return true;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE)
            return false;
        return map[y][x] == DOT_EMPTY; // by DSerov
    }
}