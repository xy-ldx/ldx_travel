package cn.itcast.travel.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class DateUtils {

	
	//日期转字符串
	public static String date2String(Date date,String pattern){
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		String format = sdf.format(date);
		return format;
		
	}
	
	//生成32位字符串
	public static String getUUID(){
	//	return "";
		//return UUID.randomUUID().toString().toUpperCase().replace("-", "");
		//return UUID.randomUUID().toString().toUpperCase().replace("-", "");
		return UUID.randomUUID().toString().toUpperCase().replace("-", "");
	}

}
