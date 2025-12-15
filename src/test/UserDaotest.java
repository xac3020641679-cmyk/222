package test;

import domain.DateRange;
import java.util.Date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;



public class UserDaotest {


//    当天的时间范围
    public static Timestamp[] getDateStartAndEnd(){
        Calendar calendar= Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int date=calendar.get(Calendar.DATE);
        Date start1=new Date(year-1900,month,date);
        Date end1=new Date(year-1900,month,date+1);

        Timestamp start2=new Timestamp(start1.getTime());
        Timestamp end2=new Timestamp(end1.getTime());
        Timestamp[] arr=new Timestamp[2];
        arr[0]=start2;
        arr[1]=end2;




        return arr ;

    }

//    public static void main(String[] args) throws ParseException, ParseException {
//        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
//        Date startTime =ft.parse("2019-06-05 03:26:54");
//        Date endTime = ft.parse("2023-06-09 03:26:54");
//        Date nowTime = new Date();
//        boolean effectiveDate = isEffectiveDate(nowTime, startTime, endTime);
//        if (effectiveDate) {
//            System.out.println("当前时间在范围内");
//        }else {
//            System.out.println("当前时间在不在范围内");
//        }
//
//    }

    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {

        SimpleDateFormat DateUtilsTemp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        DateRange thisMonth = getThisMonth();
        System.out.println("当前月份的时间范围: "+DateUtilsTemp.format(thisMonth.getStart())+" - "+DateUtilsTemp.format(thisMonth.getEnd()));



    }

//    获取当前月份的信息
public static DateRange getThisMonth(){
    Calendar startCalendar = Calendar.getInstance();
    startCalendar.set(Calendar.DAY_OF_MONTH, 1);
    setMinTime(startCalendar);

    Calendar endCalendar = Calendar.getInstance();
    endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
    setMaxTime(endCalendar);

    return new DateRange(startCalendar.getTime(), endCalendar.getTime());

}


    private static void setMinTime(Calendar calendar){
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    private static void setMaxTime(Calendar calendar){
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
    }






}
