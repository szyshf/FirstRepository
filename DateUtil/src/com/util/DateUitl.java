package com.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateUitl {
    
    public static long getDateAumont(String start, String  end) throws Exception{
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        long start_ = format.parse(start).getTime();
        long end_ = format.parse(end).getTime();
        
        return (end_ - start_) / (24 * 60 * 60 * 1000);
    }

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        String start = "2014-11-17";
        System.out.println(getDateAumont(start, args[0]));
    }

}
