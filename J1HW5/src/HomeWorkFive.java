/**
 * Home work five
 *
 * @author Andrew Shevelev
 * @version Feb, 11 2018
 *
 * @link https://github.com/ShevelevAndrew
 */


import java.io.*;
import java.util.Scanner;

class HomeWorkFive {

    public static void main (String[]  args) throws Exception {

        Associate[] persArray = new Associate[5];
        persArray[0] = new Associate("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312310", 30000, 30);
        persArray[1] = new Associate("Ivanov Pavel", "Best Engineer", "pavel@mailbox.com", "892312311", 40000, 41);
        persArray[2] = new Associate("Pavlov Ivan", "Engineer", "ivivanPav@mailbox.com", "892312312", 30000, 43);
        persArray[3] = new Associate("Sidorov Pavel", "Best Engineer", "pavelsid@mailbox.com", "892312313", 40000, 30);
        persArray[4] = new Associate("Petrov Petr", "Engineer", "petrovpetr@mailbox.com", "892312314", 30000, 35);


        for (int i = 0; i < persArray.length; i++) {
            //arrayStr = arrayStr + persArray[i].toString()+"\n";
            if (persArray[i].getAge() > 40)
                System.out.println("Age > 40: "+persArray[i]);
        }
        System.out.println("*********************************************************************");

        writeFile(persArray);
        persArray = reedFile();

        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getAge() < 40)
                System.out.println("Age < 40: "+persArray[i]);

        }

    }



    public static void writeFile(Associate[] arr) throws Exception {

            PrintWriter writer = new PrintWriter("Associate.txt", "UTF-8");
            for (int i = 0; i < arr.length ; i++) {
                writer.println(arr[i]);
            }
            writer.close();

    }

    public static Associate[] reedFile () throws FileNotFoundException {

        FileReader reader = new FileReader("Associate.txt");
        Scanner scan = new Scanner(reader);
        Associate[] persArray = new Associate[5];
        int i = 0;
        String[] str= null;
        while (scan.hasNextLine()) {
            str = scan.nextLine().split(",");
            persArray[i] = new Associate(str[0],str[1],str[2],str[3],Integer.parseInt(str[4])+1000 ,Integer.parseInt(str[5]));
            i++;
        }
        return persArray;
    }


}
/*
class WriteReedFile {


    public static void  () throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("Associate.txt", "UTF-8");
        writer.println("The first line");
        writer.println("The second line");
        writer.close();
    }

}*/

/**
 * Конструктор класса должен заполнять эти поля при создании объекта;
 * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
 *
 * Создать массив из 5 сотрудников
 * Пример:
 * Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
 * persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
 * // потом для каждой ячейки массива задаем объект
 * persArray[1] = new Person(...);
 * ...
 * persArray[4] = new Person(...);
 * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
 */

class Associate {
    private String fullName;
    private String post;
    private String email;
    private String phone;
    private int pay;
    private int age;

    Associate(String fullName, String post, String email, String phone, int pay, int age){
        this.fullName = fullName;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.pay = pay;
        this.age = age;

        printConsol(fullName,post,email,phone,pay,age);
    }

    int getAge() {
        return age;
    }

   void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return fullName+","+post+","+email+","+phone+","+pay+","+age;
    }

    public void printConsol(String fullName, String post, String email, String phone, int pay, int age){
        System.out.println("FullName:"+fullName+", Post:"+post+", Email:"+email+", Phone:"+phone+", Pay:"+pay+", Age:"+age);

    }

}





