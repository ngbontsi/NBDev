package development.ngbontsi.com.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by nbontsi on 2017/07/07.
 */

public class DateUtills {
private static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public static String today(){

        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String calendarToday(){
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar);
    }

    public static String dateMinus(int numberOfDays){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,-numberOfDays);
        Date date = calendar.getTime();
        return dateFormat.format(date);
    }
    public static String datePlus(int numberOfDays){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,numberOfDays);
        Date date = calendar.getTime();
        return dateFormat.format(date);
    }

}
