/**
 * J2HomeWork3
 *
 * @author Andrew Shevelev
 * @version Jun, 12 2018
 * @link https://github.com/ShevelevAndrew
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class J2HomeWork3 {
    public static void main(String[] args) {
        String str = null;
        /**
         * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
         * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
         * Посчитать сколько раз встречается каждое слово.
         *
         * * (*)С первым заданием работать не с массивом, а с текстовым файлом
         */

        try {
            str = reedFile("fileStr.txt");
            uniqueWords(convToArrList(str));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        /**
         * 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
         * В этот телефонный справочник с помощью метода add() можно добавлять записи.
         * С помощью метода get() искать номер телефона по фамилии.
         * Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
         * тогда при запросе такой фамилии должны выводиться все телефоны.
         */

        /**
         * (*)Проинециализировать телефонный справочник из файла
         */


        Phonebook pbk = new Phonebook();
        pbk.add("Pupkin","568745697"); //  add()
        pbk.add("Ivanov","123456789");
        pbk.add("Petrov","45678923");
        pbk.add("Ivanov","96325874123");

        try {
            str = reedFile("PhoneBook.txt"); //*
            String[] lines = str.split("\n");
            String[][] row = new String[lines.length][];
            String[] line = str.split("\n");
            for (int i = 0; i < lines.length; i++) {
                row[i] = lines[i].split("\\s+");
                pbk.add(row[i][0],row[i][1]);         // adding from file
            }
            pbk.add("Vasichkin","+74957412563");  //  add()
            System.out.println(pbk.getBook("Ivanov")); // get()
            System.out.println(pbk.getBook("Petrov")); // get()
            pbk.saveFile("PhoneBook.txt");        //*
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    static void uniqueWords(List<String> list) {
        Set<String> hs = new HashSet<>();

        for (String al : list) {
            hs.add(al);
        }
        for (String hhs : hs) {
            int i = 0;
            for (String al : list) {
                if (hhs.equals(al))
                    i++;
            }
            System.out.println(hhs.toLowerCase() + "  :word repeats->" + i);
        }
        System.out.println();
    }

    static List<String> convToArrList(String textStr) {
        List<String> list = new ArrayList<>();

        textStr = textStr.replaceAll("[.,\"!&?:;]", "");
        for (String retval : textStr.split("[\\s+]")) {
            list.add(retval.toLowerCase());
        }
        System.out.println(list);
        System.out.println("Unique number of words: " + list.size() + "\n");

        return list;
    }


    static String reedFile(String fileName) throws IOException {

        StringBuffer buffer = new StringBuffer();
        String str = null;
        try (BufferedReader reader = new BufferedReader(
                new FileReader(fileName))) {

            while (reader.ready())
                buffer.append(reader.readLine() + "\n");
            str = buffer.toString();

        } catch (IOException ex) {
            throw new IOException(fileName + " :File not fond"); //He corrected for DZ2, implemented the release Exception
        }

        return str;

    }
}
