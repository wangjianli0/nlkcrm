package cn.deepcoding.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil
{
  public static final String YYMMDD_hhmmss = "yyyy-MM-dd hh:mm:ss";
  public static final String YYMMDD_HHmmss_24 = "yyyy-MM-dd HH:mm:ss";
  public static final String YYMMDD = "yyyy-MM-dd";
  
  public static String dateToStr(String format, Date date)
  {
    try
    {
      DateFormat fmt = new SimpleDateFormat(format);
      return fmt.format(date);
    }
    catch (Exception e) {}
    return null;
  }
  
  public static String dateToStr(Date date)
  {
    try
    {
      DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
      return fmt.format(date);
    }
    catch (Exception e) {}
    return null;
  }
  
  public static Date strToDate(String format, String timeStr)
  {
    try
    {
      SimpleDateFormat sdf = new SimpleDateFormat(format);
      return sdf.parse(timeStr);
    }
    catch (ParseException e) {}
    return null;
  }
  
  public static Date getTaskTime(Date date, Integer taskDay)
  {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(6, taskDay.intValue());
    return cal.getTime();
  }
  
  public static Date getTaskTime(Integer taskDay)
  {
    Calendar cal = Calendar.getInstance();
    cal.add(6, taskDay.intValue());
    return cal.getTime();
  }
  
  public static String getQuarterCode()
  {
    Calendar c = Calendar.getInstance();
    int month_index = c.get(2);
    String quarterCode = c.get(1) + "_";
    if ((month_index < 3) && (month_index >= 0)) {
      quarterCode = quarterCode + "1";
    } else if ((month_index < 6) && (month_index >= 3)) {
      quarterCode = quarterCode + "2";
    } else if ((month_index < 9) && (month_index >= 6)) {
      quarterCode = quarterCode + "3";
    } else {
      quarterCode = quarterCode + "4";
    }
    return quarterCode;
  }
}
