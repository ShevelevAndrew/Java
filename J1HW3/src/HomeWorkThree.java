import java.util.Random;
import java.util.Scanner;

/**
 *  Home work three
 *
 * @author Andrew Shevelev
 * @version dated Feb 4, 2018
 */
public class HomeWorkThree {
    public static void main(String[] args) {
        int selNum;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("************************************");
            System.out.println("* Run - Guess number / Press 1     *");
            System.out.println("* Run - Guess the Word / Press 2   *");
            System.out.println("* Exit / Press 3                   *");
            System.out.println("************************************");
            selNum = sc.nextInt();

            switch (selNum) {
                case 1:
                    randomNumber();
                    break;

                case 2:
                    randomWord();
                    break;

                case 3:
                    break;

                default:
                    System.out.println("Invalid number");
                    break;
            }

        } while (selNum < 3 || selNum > 3);


    }




    /**1. Написать программу, которая загадывает случайное число от 0 до 9,
     * и пользователю дается 3 попытки угадать это число. При каждой попытке
     * компьютер должен сообщить больше ли указанное пользователем число чем загаданное,
     * или меньше.
     * После победы или проигрыша выводится запрос
     * – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
     */

    public static void randomNumber() {
        Random random = new Random();
        int ranNum = random.nextInt(10);
        int j = 0;
        int i = 0;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Number of attempts: " + (3-j));
            System.out.println("Enter the number: ");
            i = sc.nextInt();
            if (i > ranNum) {
                System.out.println("Not true, the number is greater " );
            } else {
                if (i < ranNum) {
                    System.out.println("Not true, the number is less ");
                }
            }

            j++;

            if (i==ranNum) {
                System.out.println("Right!!! ");
                System.out.println("Guessed from an attempt " + j);
            }

            if ((j == 3) || (i==ranNum) ) {
                System.out.println("Repeat the game again? 1 - yes / 0 - no");
                i = sc.nextInt();
                do {
                    switch (i) {
                        case 1: {
                            ranNum = random.nextInt(10);
                            j = 0;
                            break;
                        }

                        case 0:
                            j = 3;
                            break;

                        default:
                            System.out.println("Invalid number");
                            break;
                    }
                } while (i < 0);

        }

        } while (j < 3);


    }


    /**
     * 2 * Создать массив из слов
     * String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
     * "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
     * "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
     * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
     * сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
     * Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
     * apple – загаданное
     * apricot - ответ игрока
     * ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
     */

    public static void randomWord() {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi",
                "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        Scanner s = new Scanner(System.in);
        String str;
        int j = 0;

        int ranStr = random.nextInt(words.length);

        do {
            System.out.println("Enter the word: ");
            System.out.print(">");
            str = s.nextLine();

            j++;

            if (!str.equals(words[ranStr])) {
                for (int i = 0; i < j; i++) {
                char c = words[ranStr].charAt(i);
                System.out.print(c);
                }
                for (int i = 0; i < 15-j; i++) {
                    System.out.print("#");
                }
                System.out.println();

            }


        }while (!str.equals(words[ranStr]));
        System.out.println("Right!!!");
        System.out.println("Guessed from an attempt " + j);

    }

}
