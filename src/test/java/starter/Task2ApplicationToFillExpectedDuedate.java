package starter;

import starter.utils.csvUtils;
import starter.utils.driverUtils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ValueRange;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class Task2ApplicationToFillExpectedDuedate{
    public static String dueDate = "";
    private static SimpleDateFormat DateFor;


    public static void main(String[] args) throws IOException, InterruptedException, ParseException {
        String userName = driverUtils.read_userName_from_html_files();
        System.out.println("userName: "+userName);

        String date = csvUtils.read_userName_and_due_date(userName);
//        System.out.println("date: "+date);

        String actualDueDate = calculate_the_actual_due_date(date);

        driverUtils.fill_actual_due_date_fill_the_due_date_in_form(actualDueDate);

    }


    private static String calculate_the_actual_due_date(String dueDate) throws ParseException {
        System.out.println("date: "+dueDate);

        Date date = new Date();
        DateFor = new SimpleDateFormat("EEEEE, dd MMM yyyy");
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dueDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);;
        int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        Calendar c = Calendar.getInstance();
        c.set(year+3, month, day, 0, 0);
        String dt = DateFor.format(c.getTime());  //
        System.out.println("ActualDueDate: "+dt);
        return dt;
    }
    public static String getMyDate(String myDate, String requiredFormat, String mycurrentFormat) {
        DateFormat dateFormat = new SimpleDateFormat(requiredFormat);
        Date date = null;
        String returnValue = "";
        try {
            date = new SimpleDateFormat(mycurrentFormat, Locale.ENGLISH).parse(myDate);
            returnValue = dateFormat.format(date);
        } catch (ParseException e) {
            returnValue = myDate;
        }
        return returnValue;
    }


    private static void fill_actual_due_date_fill_the_due_date_in_form() {
    }

}
