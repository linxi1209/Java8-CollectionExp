package com.max.jdk8.SimpleTimeFormat;

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
 * @date Created in 2017-12-5 15:55
 */
public class SmpDateFormate {

    private static DateFormat df = new SimpleDateFormat("yyyy-mm-dd");

    public static void main(String[] agrs){

        ExecutorService tmpool = Executors.newFixedThreadPool(100);
        for(int i=0;i<100;i++)
        {
            tmpool.execute(new MyThread2());
        }
        tmpool.shutdown();
        System.out.println("pool close");
    }

    public static Date getDate(){
        try {
            return df.parse("1970-01-01");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}
    class MyThread2 extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ":date:"+SmpDateFormate.getDate());
        }
    }


