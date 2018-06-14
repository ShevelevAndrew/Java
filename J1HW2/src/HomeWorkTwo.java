public class HomeWorkTwo {
    public static void main(String[] args ) {

        System.out.println("Question number 1");
        invertArray();

        System.out.println("Question number 2");
        fillArray();

        System.out.println("Question number 3");
        changeArray();

        System.out.println("Question number 4");
        fillDiagonal();

        System.out.println("Question number 5");
        arrMinMaxValue();

        System.out.println("Question number 6");
        int[] arr =  { 1, 4, 3, 2, 11, 10, 2, 3, 5, 1 };
        System.out.println(checkBalance(arr));
        int[] arrOne =  { 1, 2, 3, 4, 2 };
        System.out.println(checkBalance(arrOne));
        int[] arrTwo =  { 10, 2, 3, 4, 2, 5, 10, 5};
        System.out.println(checkBalance(arrTwo));

        System.out.println("Question number 7");
        int[] arrOff =  { 1, 2, 3, 4, 5, 6, 7, 8 };
        registerOffset(arrOff,-2);
        int[] arrOffOne =  { 1, 2, 3, 4, 5, 6, 7, 8 };
        registerOffset(arrOffOne,0);
        int[] arrOffTwo =  { 1, 2, 3, 4, 5, 6, 7, 8 };
        registerOffset(arrOffTwo, 1);


    }




/**1. Задать целочисленный массив, состоящий из элементов 0 и 1.
 * С помощью цикла и условия заменить 0 на 1, 1 на 0;
 */
        public static void invertArray() {
            int[] arr = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0  };
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();


            System.out.println("First option Substitution 1 to 0");

            for (int i = 0; i < arr.length; i++) { //Первый вариант замены с использованием switch...case...default
                switch (arr[i]) {
                    case 0:
                        arr[i] = 1;
                        System.out.print(arr[i] + " ");
                        break;

                    case 1:
                        arr[i] = 0;
                        System.out.print(arr[i] + " ");
                        break;

                    default: break;

                }
            }
            System.out.println();


            System.out.println("The second option Substitution 1 for 0");

            for (int i = 0; i < arr.length; i++) { //второй вариант с использованием if...else
                if (arr[i] == 0) {
                    arr[i] = 1;
                    System.out.print(arr[i] + " ");
                }
                else {
                    arr[i] = 0;
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();

        }

    /**2. Задать пустой целочисленный массив размером 8.
     * С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21
     */

    public static void fillArray() {  // Первый выриант
        System.out.println("The first variant of filling with values");
        int[] arr = new int[8];

        for (int i = 0; i < arr.length; i++) {

            arr[i] = i * 3;
            System.out.print(arr[i] + " ");

        }
        System.out.println();

        System.out.println("The second variant of filling with values");
        int[] nums = new int[8]; //Второй вариант

        for (int i = 0, j = 0; i < nums.length; i++, j += 3) {
            nums[i] = j;
            System.out.print(nums[i] + " ");
        }
        System.out.println();


        System.out.println("The third variant of filling with values");
        int[] errNums = new int[8];
        int i = 0;
        while (i < errNums.length) {
            errNums[i] = i*3;
            System.out.print(errNums[i] + " ");
            i++;
        }
        System.out.println();

    }

    /**3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
     * и числа меньшие 6 умножить на 2;
     */

    public static void changeArray() {
        int[] err = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        for (int i = 0; i < err.length; i++) {
            if (err[i] < 6) {
                err[i] = err[i] * 2;

            }
            System.out.print(err[i] + " ");

        }
        System.out.println();

    }

    /**4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
     * и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
     */

    public static void fillDiagonal() {
        int[][] arr = new int[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == j) arr[i][i] = 1;
                if (j == 7-i) arr[i][j] = 1;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }

    /**5. ** Задать одномерный массив и найти в
     * нем минимальный и максимальный элементы
     * (без помощи интернета);
     */

    public  static void arrMinMaxValue() {
        int[] arr = { 1, 5, 3, -2, 11, -14, 5, 2, 4, 8, 9, -1 };
        int minV = 0;
        int maxV = 0;
        for (int i = 0; i < arr.length; i++) {
            if (minV > arr[i]) {
                minV = arr[i];
            }
            if (maxV < arr[i]) {
                maxV = arr[i];
            }

        }
        System.out.println("MaxValue = "+ maxV + " MinValue = "+minV);

    }

    /**6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
     * метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
     * Примеры: checkBalance([1, 1, 1, || 2, 1]) → true,
     * checkBalance ([2, 1, 1, 2, 1]) → false,
     * checkBalance ([10, || 10]) → true,
     * граница показана символами ||, эти символы в массив не входят.
     */
    public static boolean checkBalance(int[] arr) {

        int sumS = 0;
        int sumSh;
        int j = 0;
        boolean bool=false;
        System.out.print("[ ");

        for (int i = 0; i < arr.length; i++){
            sumS = sumS + arr[i];
            sumSh = 0;
            System.out.print(arr[i]+" ");

            for (j = i+1; j < arr.length; j++) {
                sumSh = sumSh + arr[j];
            }

            if (sumS == sumSh ) {
                System.out.print("|| ");
                bool = true;
            }
        }
        System.out.print("]-> ");
        return bool;
    }


    /**7. **** Написать метод, которому на вход подается одномерный массив и число n
     * (может быть положительным, или отрицательным), при этом метод должен сместить
     * все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться
     * вспомогательными массивами.
     */

    public static void registerOffset (int[] arr, int n) {

        int j = 0;

        if (n > 0) {

            for (int i = 0 ; i < n; i++) {
                for (j = 0; j < arr.length - 1; j++ ) {
                    arr[j] = arr[j+1];
                }
                arr[j] = 0;
            }

        }
        else {
            int k = 0;

            for (int i = n; i < 0 ; i++) {
                for (k = arr.length - 1; k > 0; k--) {
                    arr[k] = arr[k-1];
                }
                arr[k] = 0;
            }

        }


        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        System.out.println("-> "+n);

    }

}
