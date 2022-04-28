package lanqiaobei.lanqiao_11.t5;

import java.util.Calendar;
import java.util.Date;

public class Main {


    public static void main(String[] args) {
//        Calendar calendar = Calendar.getInstance();
//        Calendar calendar1 = Calendar.getInstance();
//        calendar.set(2000,0,1);
//        calendar1.set(2000,0,1);
//
//        System.out.println(calendar.after(calendar1));
//        System.out.println(calendar1.after(calendar));
        Date date = new Date();
        Date date1 = new Date(2020, 11, 1);
        Calendar ca1 = Calendar.getInstance();
        ca1.clear();
        ca1.set(2000, 1, 1);
        System.out.println(ca1.getTimeInMillis());
    }
}
