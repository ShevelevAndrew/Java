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
        Phonebook pbk = new Phonebook();
        pbk.add("Pupkin","568745697");
        pbk.add("Ivanov","123456789");
        pbk.add("Petrov","45678923");
        pbk.add("Ivanov","96325874123");
        System.out.println(pbk.getBook("Ivanov"));


        try {
            str = reedFile("fileStr.txt");
            uniqueWords(convToArrList(str));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Phonebook.phoneBook(reedFile("PhoneBook.txt"));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    static void uniqueWords(List<String> list) {
        Set<String> hs = new HashSet<>();

        for (String al : list) {
            hs.add(al);
            //System.out.println("####"+al);
        }
        //System.out.println(hs);
        //System.out.println(hs.size());

        for (String hhs : hs) {
            int i = 0;
            for (String al : list) {
                if (hhs.equals(al))
                    i++;
            }
            System.out.println(hhs.toLowerCase() + "  :word repeats->" + i);
        }
    }

    static List<String> convToArrList(String textStr) {
        List<String> list = new ArrayList<>();
        //Set<String> hs = new HashSet<>();

        textStr = textStr.replaceAll("[.,\"!&?:;]", "");
        for (String retval : textStr.split("[\\s+]")) {
            list.add(retval.toLowerCase());
            //hs.add(retval);
        }
        System.out.println(list);
        System.out.println("Number of words: " + list.size() + "\n");

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
