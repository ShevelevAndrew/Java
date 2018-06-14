
/**
 * class phone book
 * @author Andrew Shevelev
 * @version Jun, 12 2018
 */

import java.util.*;

public class Phonebook {
    Map <String,String> pb;

    Phonebook() {
        pb = new HashMap<>();
    }

    void add(String name, String phone) {
        pb.put(phone, name);
    }

    List getBook(String fullName) {
        List<String> strLst = new ArrayList<>();
        Set<Map.Entry<String, String>> set = pb.entrySet();
        for (Map.Entry<String, String> o : set)
            if (fullName.equals(o.getValue())) {
                strLst.add("FullName" + o.getValue() + " tel:" + o.getKey());
            }
        return strLst;
    }



    public static void phoneBook (String phoneBook) {
       // Map<String, String> tm = new TreeMap<>();
        List<String> list = new ArrayList<>();
        List<AssociatePB> pb = new ArrayList<>();



        //pb.add(new AssociatePB("Vasya","+79128888888"));
        //pb.add(new AssociatePB("Petya","+79128888888"));
        //System.out.println(pb);



        for (String retval : phoneBook.split("[\n]")) {
            list.add(retval);
            list.clear();
            for (String ret : retval.split("\\s+")) {
                System.out.println(ret);
                list.add(ret);
            }
            //tm.put(list.get(1),list.get(0));
            pb.add(new AssociatePB(list.get(0),list.get(1)));
        }
        for (AssociatePB pbb : pb) {
            if (pbb.getFullName().compareTo("Ivanov") == 0)
                System.out.println("Nombe phone " +pbb.getFullName() + " " + pbb.getPhone());
        }
        //System.out.println(tm.values());


        //for (String al : list) {
        //}


        //phoneBook.split("\\s+")





    }

}

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

    String getFullName() {
        return fullName;
    }

    String getPhone() {
        return phone;
    }


    void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return fullName+","+post+","+email+","+phone+","+pay+","+age;
    }

    public void printConsol(String fullName, String post, String email, String phone, int pay, int age){
        //System.out.println("FullName:"+fullName+", Post:"+post+", Email:"+email+", Phone:"+phone+", Pay:"+pay+", Age:"+age);

    }

}
