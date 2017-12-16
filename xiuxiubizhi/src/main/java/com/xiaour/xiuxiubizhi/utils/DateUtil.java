package com.xiaour.xiuxiubizhi.utils;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @title :日期转换工具 
 * @description :包含常用日期格式转换操作
 * @author: hyf
 * @data: 
 */
public class DateUtil {
	
	private static final String pattern = "yyyy-MM-dd";
	private static final String patternDetail = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 日期格式化正则枚举
	 */
	public static String[] DATE_FORMATS_REG = new String[]{
		"^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$",
		"^\\d{4}-\\d{2}-\\d{2}$",
		"^\\d{4}-\\d{2}$",
		"^\\d{2}:\\d{2}:\\d{2}$"};

	/**
	 * 日期格式化内容枚举
	 */
	public static String[] DATE_FORMATS_CONTENTS = new String[]{
		"yyyy-MM-dd HH:mm:ss",
		"yyyy-MM-dd",
		"yyyy-MM",
		"HH:mm:ss"};


	/**
	 * 得到当前时间上一天的时间
	 * @return Date
	 * 
	 */
	public static Date getUpDate() {
		Date date = null;
		String time = null;
		int year = 0;
		int month = 0;
		int day = 0;
		Calendar c = Calendar.getInstance();// 获得系统当前日期
		try {
			year = c.get(Calendar.YEAR);
			month = c.get(Calendar.MONTH) + 1; 
			day = c.get(Calendar.DAY_OF_MONTH);
		 
			time = year + "-" + month + "-" + (day-1);
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			date =  sf.parse(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
    
	/**
	 * 给定时间的字符串。得到上一天时间的字符串
	 * @param dateString
	 * @throws Exception
	 * @author  hyf
	 */
	
	public static String getUpday(String  dateString){
		int year = Integer.parseInt(dateString.substring(0, 4));
		int month = Integer.parseInt( dateString.substring(5, 7));
		int day = Integer.parseInt(dateString.substring(8, 10)); 
		Calendar c = Calendar.getInstance();// 获得系统当前日期
		 // 设置自己的时间属性
		c.set(year, month-1, day);
		c.add(Calendar.DAY_OF_MONTH, -1);  // 得到时间的上一天
		int y  = c.get(Calendar.YEAR);
	    int	m  = c.get(Calendar.MONTH)+1; 
	    int	d = c.get(Calendar.DAY_OF_MONTH);
		String time = y  + "-" + m  + "-" +  d  ;
		return time;
	}
	

	
    /** 得到系统当前日期及时间 格式为 yyyy-MM-dd HH:mm:ss * */
    public static String getDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }


    public static String getDateString(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }
	
	/**
	 * 根据时间字符串返回Date类型
	 * @param time
	 * @return
	 */
	public static Date getDateByTime(String time) throws Exception{
		Date date = null;
		for (int i = 0; i < DateUtil.DATE_FORMATS_REG.length; i ++) {
			//如果符合正则表达式
			if(time.matches(DateUtil.DATE_FORMATS_REG[i])){
				date = new SimpleDateFormat(DateUtil.DATE_FORMATS_CONTENTS[i]).parse(time);
				break;
			}
		}
		return date;
	}

    /** 得到long型的日期值 * */
    public static Time getSqlTime() {
        return new Time(getTime());
    }

    /** 获取系统当前时间 * */
    public static long getTime() {
        Date dt = new Date();
        return dt.getTime();
    }

    /** 获取系统当前时间 * */
    public static Date getJavaDate() {
        return new Date();
    }

    /** 获取系统当前日期 得到的日期格式如：2004-10-09 * */
    public static java.sql.Date getSqlDate() {
        return new java.sql.Date(getTime());
    }

    /** 取得Timestamp类型时间 * */
    public static Timestamp getTimestamp() {
        return new Timestamp(getTime());
    }

    /** 得到Calendar对象 * */
    public static Calendar getCD() {
        Calendar mycd = Calendar.getInstance();
        return mycd;
    }

    /** 得到sStr格式日期 * */
    public static String getAll(String sStr) {
        Calendar mycd = Calendar.getInstance();
        return mycd.get(Calendar.YEAR) + sStr + (mycd.get(Calendar.MONTH) + 1)
                + sStr + mycd.get(Calendar.DATE);
    }

    /** 得到日期,以-为分割符 * */
    public static String getAll() {
        return getAll("-");
    }

    /** 得到系统当前年 * */
    public static int getYear() {
        Calendar mycd = Calendar.getInstance();
        return mycd.get(Calendar.YEAR);
    }

    /** 得到系统当前月 * */
    public static int getMonth() {
        Calendar mycd = Calendar.getInstance();
        return mycd.get(Calendar.MONTH) + 1;
    }

    /** 得到系统当前日 * */
    public static int getDate() {
        Calendar mycd = Calendar.getInstance();
        return mycd.get(Calendar.DATE);
    }

    /** 得到系统年 * */
    public static int getAddYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    /** 得到系统月 * */
    public static int getAddMonth() {
        return Calendar.getInstance().get(Calendar.MONTH) + 1;
    }

    /** 得到系统日 * */
    public static int getAddDate() {
        return Calendar.getInstance().get(Calendar.DATE);
    }

    /** 得到日期格式为yyyy-mm-dd * */
    public static String getMiddle() {
        return getMiddle("-");
    }
    
    /** 得到日期格式为YYYY $sStr MM 其中sStr为分割字符 * */
    public static String getMiddleYM(String sStr) {
        Calendar mycd = Calendar.getInstance();
        int year = mycd.get(Calendar.YEAR);
        int month = mycd.get(Calendar.MONTH) + 1;
        String re = "" + String.valueOf(year);
        if (month < 10)
            re += sStr + "0" + String.valueOf(month);
        else
            re += sStr + String.valueOf(month);
        return re;
    }

    /** 得到日期格式为YYYY $sStr MM $sStr DD其中sStr为分割字符 * */
    public static String getMiddle(String sStr) {
        Calendar mycd = Calendar.getInstance();
        int year = mycd.get(Calendar.YEAR);
        int month = mycd.get(Calendar.MONTH) + 1;
        int date = mycd.get(Calendar.DATE);
        String re = "" + String.valueOf(year);
        if (month < 10)
            re += sStr + "0" + String.valueOf(month);
        else
            re += sStr + String.valueOf(month);
        if (date < 10)
            re += sStr + "0" + String.valueOf(date);
        else
            re += sStr + String.valueOf(date);
        return re;
    }

    /** 得到日期格式为 YYYY $sStr MM $sStr DD $sStr hh:mm:ss其中sStr为分割字符 * */
    public static String getTimeStr(String sStr) {

        Calendar mycd = Calendar.getInstance();
        String re = "" + mycd.get(Calendar.YEAR);
        if (mycd.get(Calendar.MONTH) + 1 < 10)
            re += sStr + "0" + String.valueOf(mycd.get(Calendar.MONTH) + 1);
        else
            re += sStr + String.valueOf(mycd.get(Calendar.MONTH) + 1);
        if (mycd.get(Calendar.DATE) < 10)
            re += sStr + "0" + String.valueOf(mycd.get(Calendar.DATE));
        else
            re += sStr + String.valueOf(mycd.get(Calendar.DATE));

        if (mycd.get(Calendar.HOUR) < 10)
            re += " " + "0" + String.valueOf(mycd.get(Calendar.HOUR));
        else
            re += " " + String.valueOf(mycd.get(Calendar.HOUR));
        if (mycd.get(Calendar.MINUTE) < 10)
            re += ":0" + String.valueOf(mycd.get(Calendar.MINUTE));
        else
            re += ":" + String.valueOf(mycd.get(Calendar.MINUTE));
        if (mycd.get(Calendar.SECOND) < 10)
            re += ":0" + String.valueOf(mycd.get(Calendar.SECOND));
        else
            re += ":" + String.valueOf(mycd.get(Calendar.SECOND));
        return re;
    }


    /** 取得两个日期的相隔天数 * */
    public static int getDays(Date sd, Date ed) {
        return (int)((ed.getTime() - sd.getTime()) / (3600 * 24 * 1000));
    }

    /***************************************************************************
     * 取得yyyymm,参数一：yyyymm,参数二：number 得到减去月份的日期
     **************************************************************************/

    public static String getTime(String s) {
        if (s == null || s.equals(""))
            return "";
        String s1 = "";
        try {
            SimpleDateFormat simpledateformat = new SimpleDateFormat(s);
            s1 = simpledateformat.format(Calendar.getInstance().getTime());
        } catch (Exception exception) {
            System.out.println(Calendar.getInstance().toString()
                    + "cannot format time [function:getTime(String)]");
            exception.printStackTrace();
        }
        return s1;
    }
    
    /** 将String 转换操作，将sDt替换为Timestamp型的日期型 **/
    public static Timestamp getDateTime(String sDt) {
		try {
			return Timestamp.valueOf(sDt); // sDt
			// format:yyyy-mm-dd
			// hh:mm:ss.fffffffff
		} catch (IllegalArgumentException iae) {
			sDt = sDt + " 00:00:00";
			try {
				return Timestamp.valueOf(sDt);
			} catch (Exception e) {
				return null;
			}
		}
	}

    /**
	 * 将字符串日期格式formFmt转换成其他日期格式toFmt
	 * 
	 * @param str
	 * @param fromFmt
	 * @param toFmt
	 * @return
	 */
	public static String formatDate(String str, String fromFmt, String toFmt) {
		DateFormat dateFormat = new SimpleDateFormat(fromFmt);
		try {
			Date date = dateFormat.parse(str);
			return new SimpleDateFormat(toFmt).format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * @description:  根据字符串日期格式获得对应的星期
	 * @param str str 字符串日期
	 * @return String
	 */
	public static String getWeekDay(String str){
		
		  SimpleDateFormat formatYMD = new SimpleDateFormat("yyyy-MM-dd");
		  SimpleDateFormat formatD = new SimpleDateFormat("E");
		  Date d = null;
		  try {
		   d = formatYMD.parse(str);
		  }catch(Exception e){
		   e.printStackTrace();
		  }
		  return formatD.format(d);
	}
	/**
	 *  @description:获取当前日期
	 */
	public static String getNowDate(String format) {
		Date nowDate=new Date();//获取当前日期
		SimpleDateFormat dateFormat=new SimpleDateFormat(format);//定义日期格式
		return dateFormat.format(nowDate);//返回获取的日期
	}

	/**
	 *  @description:根据日期的字符串封装为Date对象
	 */
	public static Date getUtilDate(String datestr, String format) {
		SimpleDateFormat dateFormat=new SimpleDateFormat(format);//定义日期格式
		Date date=null;
		try {
			date=dateFormat.parse(datestr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 *  @description:获取日期的上个月当天(yyyy-MM-dd)
	 */
	public static String getLastMonthDate(Date date) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");//定义日期格式
		Calendar nowdate=new GregorianCalendar();
		nowdate.add(Calendar.MONTH, -1);
		return dateFormat.format(nowdate.getTime());
	}
	
	/**
	 *  @description:获取日期的上个月(yyyy-MM)
	 */
	public static String getLastMonth(Date date) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM");//定义日期格式
		Calendar nowdate=new GregorianCalendar();
		nowdate.add(Calendar.MONTH, -1);
		return dateFormat.format(nowdate.getTime());
	}
	/**
	 *  @description:获取日期的下个月
	 */
	public static String getNextMonthDate(Date date,String format) {
		SimpleDateFormat dateFormat=new SimpleDateFormat(format);//定义日期格式
		Calendar nowdate=new GregorianCalendar();
		nowdate.add(Calendar.MONTH, 1);
		return dateFormat.format(nowdate.getTime());
	}

	/**
	 * @description:获取日期的去年当天(yyyy-MM-dd)
	 * @param date
	 * 
	 * @return
	 */
	public static String getLastYearDate(Date date) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");//定义日期格式
		Calendar nowdate=new GregorianCalendar();
		nowdate.add(Calendar.YEAR, -1);
		return dateFormat.format(nowdate.getTime());
	}

	/**
	 *  @description:获取日期的明年当天(yyyy-MM-dd)
	 */
	public static String getNextYearDate(Date date) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");//定义日期格式
		Calendar nowdate=new GregorianCalendar();
		nowdate.add(Calendar.YEAR, 1);
		return dateFormat.format(nowdate.getTime());
	}
	/**
	 * 获取日期的本周周一(yyyy-MM-dd)
	 */
	public static String getWeekMonday() {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");//定义日期格式
		Calendar nowdate=new GregorianCalendar();
		nowdate.set(Calendar.DAY_OF_WEEK,2);
		return dateFormat.format(nowdate.getTime());
	}
	/**
	 * 获取日期的周一(yyyy-MM-dd)
	 */
	public static String getWeekMonday(Date date) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");//定义日期格式
		Calendar nowdate=new GregorianCalendar();
		nowdate.setTime(date);
		nowdate.set(Calendar.DAY_OF_WEEK,2);
		return dateFormat.format(nowdate.getTime());
	}
	/**
	 * 获取日期的本周周末(yyyy-MM-dd)
	 */
	public static String getWeekSunday() {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");//定义日期格式
		Calendar nowdate=new GregorianCalendar();
		nowdate.add(Calendar.WEEK_OF_MONTH,1);
		nowdate.set(Calendar.DAY_OF_WEEK,1);
		return dateFormat.format(nowdate.getTime());
	}
	/**
	 * 获取日期的周末(yyyy-MM-dd)
	 */
	public static String getWeekSundy(Date date) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");//定义日期格式
		Calendar nowdate=new GregorianCalendar();
		nowdate.setTime(date);
		nowdate.add(Calendar.WEEK_OF_MONTH,1);
		nowdate.set(Calendar.DAY_OF_WEEK,1);
		return dateFormat.format(nowdate.getTime());
	}
	/**
	 * 获取日期的本月月初(yyyy-MM-dd)
	 */
	public static String getMonthFirstDay() {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");//定义日期格式
		Calendar nowdate=new GregorianCalendar();
		nowdate.set(Calendar.DAY_OF_MONTH,1);
		return dateFormat.format(nowdate.getTime());
	}
	/**
	 * 获取日期的月初(yyyy-MM-dd)
	 */
	public static String getMonthFirstDay(Date date) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");//定义日期格式
		Calendar nowdate=new GregorianCalendar();
		nowdate.setTime(date);
		nowdate.set(Calendar.DAY_OF_MONTH,1);
		return dateFormat.format(nowdate.getTime());
	}
	/**
	 * 获取日期的本月月末(yyyy-MM-dd)
	 */
	public static String getMonthEndDay() {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");//定义日期格式
		Calendar nowdate=new GregorianCalendar();
		nowdate.add(Calendar.MONTH,1);
		nowdate.set(Calendar.DAY_OF_MONTH,1);
		nowdate.add(Calendar.DAY_OF_MONTH, -1);
		return dateFormat.format(nowdate.getTime());
	}
	/**
	 * 获取日期的月末(yyyy-MM-dd)
	 */
	public static String getMonthEndDay(Date date) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");//定义日期格式
		Calendar nowdate=new GregorianCalendar();
		nowdate.setTime(date);
		nowdate.add(Calendar.MONTH,1);
		nowdate.set(Calendar.DAY_OF_MONTH,1);
		nowdate.add(Calendar.DAY_OF_MONTH, -1);
		return dateFormat.format(nowdate.getTime());
	}
	/**
	 * 两天之间的间隔天数[前者-后者]
	 */
	public static int dayDiff(Date date1, Date date2) {
		long diffMillseconds=date1.getTime()-date2.getTime();
		int diffDay=(int)(diffMillseconds/1000/60/60/24);
		return diffDay;
	}

	/**
	 * 获取日期处理后的日期
	 */
	public static Date getAddedDate(Date date, int addYear, int addMonth,
			int addDay, int addHour, int addMinute, int addSecond) {
		Calendar nowdate=new GregorianCalendar();
		nowdate.setTime(date);
		nowdate.add(Calendar.YEAR,addYear);
		nowdate.add(Calendar.MONTH,addMonth);
		nowdate.add(Calendar.DAY_OF_MONTH,addDay);
		nowdate.add(Calendar.HOUR_OF_DAY,addHour);
		nowdate.add(Calendar.MINUTE,addMinute);
		nowdate.add(Calendar.SECOND,addSecond);
		return nowdate.getTime();
	}
	
	/**
	 * 日期按天数偏移（加减）
	 * @param date
	 * @param addDay
	 * @return
	 */
	public static Date getAddDay(Date date, int addDay) {
		return getAddedDate(date, 0, 0, addDay, 0, 0, 0);
	}
	
	/**
	 * 获取该日期为星期几(1-7)
	 * @param date
	 * @return
	 */
	public static int getDayOfWeek(Date date) {
		Calendar nowdate=new GregorianCalendar();
		nowdate.setTime(date);
		return nowdate.get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * @description:获取日期的第几周（周报固定值）
	 * (yyyy-MM-WW) WW指01-05
	 */
   	public static String getMonthWeek(Date date ){
		Calendar nowdate=new GregorianCalendar();
		nowdate.setTime(date);
		nowdate.set(Calendar.DAY_OF_WEEK,6);//设置周五
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-WW");//定义日期格式
   		return dateFormat.format(nowdate.getTime());
   	}
	/**
	 * @description:根据返回类型构造java.sql.Date数据
	 * @param obj 数据库Date对应JDBC类型实例
	 * @return java.sql.Date数据
	 */
	public static java.sql.Date getSqlDate(Object obj){
		if (obj instanceof java.sql.Date){
			return (java.sql.Date) obj;
		}else if (obj instanceof Timestamp){
			return new java.sql.Date(((Timestamp)obj).getTime());
		}else if(obj instanceof Date){
			return new java.sql.Date(((Date)obj).getTime());
		}
		return null;
	}
	/**
	 * @description:根据返回类型构造java.util.Date数据
	 * @param obj 数据库Date对应JDBC类型实例
	 * @return java.util.Date数据
	 */
	public static Date getUtilDate(Object obj){
		if (obj instanceof java.sql.Date){
			return  new Date(((java.sql.Date)obj).getTime());
		}else if (obj instanceof Timestamp){
			return new Date(((Timestamp)obj).getTime());
		}
		return null;
	}
	/**
	 * 
	 * @description: 时间转string
	 * @param date java.util.Date
	 * @param formatModle 时间格式 : String
	 * @return：String字符串
	 */
	public static String dateToString(Date date,String formatModle) {
		if(date!=null) {
			return new SimpleDateFormat(formatModle).format(date);
		}else 		return null;
	}
	/**
	 * @description  string转java.util.Date数据
	 * @param sourceString : String
	 * @param formatModle 时间格式 : String
	 * @return java.util.Date数据
	 */
	public static Date stringToDate(String sourceString , String formatModle) {
		SimpleDateFormat format=new SimpleDateFormat(formatModle);
		Date date=null;
		try {
			 date=format.parse(sourceString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * @param dateStr "20121228";
	 * @param dayNum  后推几天
	 * @return  "20121229";
	 */
	public static String nextDayString(String dateStr,int dayNum){
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		try {
			Date date = format.parse(dateStr);
			long s = date.getTime()+dayNum*24*60*60*1000;
			date.setTime(s) ;
			return format.format(date);
		} catch (ParseException e) { 
			e.printStackTrace();
		}
		return null;
		 
	}
	
	/** 星期天 7  星期六 6……
	 * @param str  "2013-01-12"
	 * @return
	 */
	public static int getWeekDayNum(String str) {
		Date date = DateUtil.stringToDate(str, "yyyyMMdd");
		int num = (DateUtil.getDayOfWeek(date)-1+7)%7;
		if(num==0) num +=7;
		return num;	 
	}
	
	/** 
	 * @param start "2012-12-03"
	 * @param end "2012-12-31"
	 * @return
	 */
	public static int getTipDays(String start,String end){
		String formatModle = "yyyy-MM-dd";
		Date d1 = stringToDate(start, formatModle);
		Date d2 = stringToDate(end, formatModle);
		return Math.abs(getDays(d1, d2))+1;
	}
	
	/**
	  * 方法描述: 返回当前时间 数字类型
	  * @return int
	  * @since Ver 1.00
	 */
	public static Long getNowTimeByInt(int length){
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String str = sdf.format(date);
		return Long.valueOf(str.substring(0, length));
	}
	/**
	  * 方法描述: 返回指定时间 数字类型
	  * @return int
	  * @since Ver 1.00
	 */
	public static Long getNowTimeByInt(Date date,int length){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String str = sdf.format(date);
		return Long.valueOf(str.substring(0, length));
	}
	
	public static String getNowTimeByStr(Long date){
	
		String newStr ="";
		String str = String.valueOf(date);
		if(str.length()==6){
			newStr = str.substring(0, 3)+"-"+str.substring(4, 5)+"-"+str.substring(6, 7);
		}
		if(str.length()==14){
			newStr = str.substring(0, 4)+"-"+str.substring(4, 6)+"-"+str.substring(6, 8)+" "+str.substring(8, 10)+":"+str.substring(10, 12)+":"+str.substring(12, 14);
		}
		return newStr;
		
	}
	
	public static long getDateTimeByLong(Long date){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			return sdf.parse(sdf.format(date)).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 日期往前推 n是负数，日期往后推那是整数
	 * @param date
	 * @param n
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static String preOrNextDate(Date date,int n){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(cal.DATE, n);// 把日期往后增加一天.整数往后推,负数往前移动
		return dateFormatStrDay(cal.getTime()); 
	}
	
	/**
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String dateFormatStrDay(Date date) {

		if (date == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	public static String dateFormatStrDayDetail(Date date) {
		
		if (date == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(patternDetail);
		return sdf.format(date);
	}

	/**
	 * 获取本月的周期
	 * @param spacingDay 间隔日期
	 * @return
	 */
	public static Map<String,Object> getMonthCycleBySpacing(int spacingDay) {
		//最后一次获取日期要追加剩余不在周期内的
		int maxDay=getCurrentMonthLastDay();
		//如果间距天数大于本月天数，则取整月
		if(spacingDay>maxDay){
			spacingDay=maxDay;
		}

		int shang=maxDay/spacingDay;//取商数

		int yu=maxDay%spacingDay;//取余数

		//开始日期为本月第一天
		Date startDate= stringToDate(getMonthFirstDay(new Date()),"yyyy-MM-dd");

		Date endDate=startDate;

		Map map;
		for (int i = 1; i <=shang; i++) {

			startDate=endDate;

			map= new HashMap();

			endDate=getAddDay(startDate,spacingDay);

			if(i==shang&&yu>0){

				endDate=getAddDay(endDate,yu);

			}

			map.put(dateFormatStrDay(startDate),getUpday(dateFormatStrDay(endDate)));

			System.out.println(map);
		}

		return  null;
	}

	private static int getCurrentMonthLastDay()
	{
		Calendar a = Calendar.getInstance();
		a.set(Calendar.DATE, 1);//把日期设置为当月第一天
		a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	/**
	 * 使用main函数进行测试
	 *
	 * @param args
	 */
	public static void main(String args[]){
		/*Date d = getAddedDate(new Date(), 0, 0, 0, 0, 120, 0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(d));*/

		getMonthCycleBySpacing(15);

	}

}