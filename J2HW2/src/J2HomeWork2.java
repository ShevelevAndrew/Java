/**
 * J2HomeWork2
 *
 * @author Andrew Shevelev
 * @version Jun, 09 2018
 * @link https://github.com/ShevelevAndrew
 */

import reedFile.*;

import java.io.*;
import java.io.FileReader;
import java.util.Scanner;

public class J2HomeWork2 {
    public static void main(String[] args) {
        reedFileStr("ArrIntLstNew.txt"); // Not fond
        reedFileStr("ArrIntLstErr.txt"); // Array list error - OutIndexOfBoud, Character in line
        reedFileStr("ArrIntLst.txt"); // all OK!
    }

    public static void reedFileStr(String fileName) {
        int[][] intArrLst = new int[4][4];
        int summArr = 0;
        try {
            FileReader reader = new FileReader(fileName);
            Scanner sn = new Scanner(reader);
            int i = 0;
            String[] str = null;
            while (sn.hasNextLine()) {
                str = sn.nextLine().split(",");
                //System.out.println(Arrays.toString(str)+"<-до преобразования");
                for (int j = 0; j < str.length; j++) {
                    try {
                        intArrLst[i][j] = Integer.parseInt(str[j]);
                        summArr = summArr + intArrLst[i][j];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("OutIndexOfBoud, index No: " + j +
                                "\n Delete parse str:" + str[j]);
                        // e.printStackTrace();
                    } catch (NumberFormatException n) {
                        System.out.println("NumberFormatException, index No: " + j +
                                "\n Delete the character, it will be 0:" + str[j]);
                        //n.printStackTrace();
                    }
                }
                //System.out.println(Arrays.toString(intArrLst[i])+"<-после преобразования");
                i++;
            }
            System.out.println("Summ array: " + summArr);
        } catch (FileNotFoundException ex) {
            //ex.printStackTrace();
            System.out.println("FileNotFoundException - file:" + fileName);
        }

    }

}
