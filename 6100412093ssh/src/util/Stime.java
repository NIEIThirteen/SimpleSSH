package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Stime {
	public  String getCurrentTime() {  
        String returnStr = null;  
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        Date date = new Date();  
        returnStr = f.format(date);  
        return returnStr;  
    } 
	public String getDate(){
		 Date date = new Date();    
		 String year = String.format("%tY", date);   
		 String month = String.format("%tB", date);   
		 String day = String.format("%te", date);    
		 String d=""+year+"-"+month+"-"+day;
		 return d;
	}
	public String gettime(){
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改   
		int hour = c.get(Calendar.HOUR_OF_DAY);   
		int minute = c.get(Calendar.MINUTE);   
		int second = c.get(Calendar.SECOND);    
		String d=""+hour+":"+minute+":"+second;
		return d;
	}
}
