package com.json;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONTest{

  public static void main(String[] args) throws ParseException{
    List<String> dates = getSquList("2011-03-10","2011-03-31");
    List<Map<String,String>> list = getListMap("2011-03-10","2011-03-31");
    System.out.println(dates);
    System.out.println(list);
    list = merger(list, dates);
    System.out.println(list);
  }
  
  public static List<Map<String,String>> getListMap(String start,String end) throws ParseException{
	  List<Map<String,String>> list = new ArrayList<Map<String,String>>();
	  DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	   Date startDate = format.parse(start);
	   Date endDate = format.parse(end);
	   Calendar c = Calendar.getInstance();
	   c.setTime(startDate);
	   while(!c.getTime().after(endDate)){
		   Map<String,String> map = new HashMap<String, String>();
		   map.put("days",format.format(c.getTime()));
		   map.put("value",format.format(c.getTime()).substring(8,10));
		   list.add(map);
		   c.add(Calendar.DAY_OF_MONTH,2);
	   }
	   return list;
  }
  
  public static List<String> getSquList(String start,String end) throws ParseException{
	  List<String> list = new ArrayList<String>();
	  DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	   Date startDate = format.parse(start);
	   Date endDate = format.parse(end);
	   Calendar c = Calendar.getInstance();
	   c.setTime(startDate);
	   while(!c.getTime().after(endDate)){
		   list.add(format.format(c.getTime()));
		   c.add(Calendar.DAY_OF_MONTH,1);
	   }
	   return list;
  }
  
  public static List<Map<String,String>> merger(List<Map<String,String>> list1 ,List<String> dates){
	 List<Map<String,String>> result = new ArrayList<Map<String,String>>();
	 String count = "0";
	  for (int i = 0; i < dates.size(); i++) {
		String days = dates.get(i);
		Map<String,String> map = new HashMap<String, String>();
		result.add(map);
		map.put("days",days);
		for(int j=0;j<list1.size();j++){
			String date = list1.get(j).get("days");
			if(days.equals(date)){
				String value = list1.get(j).get("value");
				count = value;
				map.put("value",value);
				break;
			}else{
				map.put("value",count);
			}
		}
	}
	  return result;
  }
}
