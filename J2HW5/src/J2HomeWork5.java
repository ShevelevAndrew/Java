/**
 * J2HomeWork5
 *
 * @author Andrew Shevelev
 * @version Jun, 20 2018
 * @link https://github.com/ShevelevAndrew
 * <p>
 * (*)Что такое volatile? - описать в комментариях
 * volatile означает, что значение этой переменной может изменяться другими потоками.
 * volatile-переменным, но с одной очень большой оговоркой:
 * чтение volatile-переменной и запись в volatile-переменную синхронизированы, а неатомарные операции ― нет.
 * Это означает, что следующий код не является потокобезопасным: myVolatileVar++;
 * Потокобезопасное synchronize( myVolatileVar )
 */


import java.util.Arrays;

class J2HomeWork5 {

    static final int size = 10000000;
    final int h = size / 2;

    public static void main(String[] args) {
        J2HomeWork5 initClass = new J2HomeWork5();
        /**1) Создают одномерный длинный массив, например:
         * 2) Заполняют этот массив единицами;
         * 3) Засекают время выполнения: long a = System.currentTimeMillis();
         */

        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        initClass.runsThroughArray(arr);
        initClass.runsArrThroughThread(arr);
    }

    void runsThroughArray(float[] arr) {
        long workHours = System.currentTimeMillis();
        //4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        /**
         * 5) Проверяется время окончания метода System.currentTimeMillis();
         * 6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
         */
        System.out.println("Working hours first method (Ms)" + (System.currentTimeMillis() - workHours));
    }

    void runsArrThroughThread(float[] arr) {
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        //Arrays.fill(arr, 1);
        long workHours = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);//Разделяем массив
        System.arraycopy(arr, h, a2, 0, h);
        Thread firstTh = new Thread(new CalcTwoArr(a1, 0)); //Запуск потоков
        Thread secondTh = new Thread(new CalcTwoArr(a2, h));
        firstTh.start(); //Старт потоков
        secondTh.start();
        try {
            firstTh.join();
            secondTh.join(); // Ждем выполнения потоков
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.arraycopy(a1, 0, arr, 0, h); //Слейка массива
        System.arraycopy(a2, 0, arr, h, h);
        /**
         * Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
         */
        System.out.println("Working hours second method (Ms) " + (System.currentTimeMillis() - workHours));
    }

    class CalcTwoArr implements Runnable {
        private float[] arr;
        private int manyCells;

        CalcTwoArr(float[] arr, int manyCells) {
            this.arr = arr;
            this.manyCells = manyCells;
        }

        @Override
        public void run() {
            for (int i = 0; i < arr.length; i++)
                arr[i] = (float) (arr[i] * Math.sin(0.2f + (i + manyCells) / 5) * Math.cos(0.2f + (i + manyCells) / 5) *
                        Math.cos(0.4f + (i + manyCells) / 2));
        }
    }
}