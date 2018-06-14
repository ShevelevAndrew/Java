
/**
 * class phone book
 * @author Andrew Shevelev
 * @version Jun, 12 2018
 */

import java.io.FileWriter;
import java.io.IOException;
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
                strLst.add(o.getValue() + " " + o.getKey());
            }
        return strLst;
    }

    void saveFile(String fileName) {
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(toString());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String str = "";
        Set<Map.Entry<String, String>> set = pb.entrySet();
        for (Map.Entry<String, String> o : set)
                str = str + o.getValue() + " " +o.getKey() + "\n";
        return str;
    }


}
