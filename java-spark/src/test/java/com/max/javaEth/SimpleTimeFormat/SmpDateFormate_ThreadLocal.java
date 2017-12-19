package com.max.javaEth.SimpleTimeFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhongailing(zhongailing@daojia.com)
 * @version V1.0
 * @Description:
 * @date Created in 2017-12-5 16:02
 */
public class SmpDateFormate_ThreadLocal {

    //存放N个SimpleDateFormat实例
    private static  ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-mm-dd");
        }
    };

    public static void main(String[] agrs){

        ExecutorService tmpool = Executors.newFixedThreadPool(100);
        for(int i=0;i<100;i++)
        {
            tmpool.execute(new MyThread());
        }
        tmpool.shutdown();
        System.out.println("pool close");
    }

    public static Date getDate(){
        try {
            //从threadLocal中获取DateFormat实例
            return df.get().parse("1970-01-01");

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":date:"+SmpDateFormate_ThreadLocal.getDate());
    }
}
