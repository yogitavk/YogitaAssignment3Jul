package starter.utils;

import starter.GetDataFromCSV;
import starter.SourceCSVPojo;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class csvUtils {

    public static String read_userName_and_due_date(String name) throws IOException {
        String date = "";
        List<SourceCSVPojo> userDataPojoIter = GetDataFromCSV.getUserDataDataFromCSV();
        for (Iterator iterator = userDataPojoIter.iterator(); iterator.hasNext();) {
            SourceCSVPojo userPojo = (SourceCSVPojo) iterator.next();
            if(userPojo.getName().contains(name)) {
                //System.out.println(userPojo.getId() + "  " + userPojo.getPrice() + "  " + userPojo.getDate() + "  " + userPojo.getProgramme() + "  " + userPojo.getName());
                date = userPojo.getDate();
            }
        }
        return date;
    }

}
