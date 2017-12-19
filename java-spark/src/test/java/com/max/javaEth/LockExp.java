package com.max.javaEth;

import com.sun.corba.se.impl.orbutil.concurrent.Mutex;
import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.locks.*;

/**
 * @author zhongailing(zhongailing@daojia.com)
 * @version V1.0
 * @Description:
 * @date Created in 2017-12-11 9:21
 */
public class LockExp {

//    StampedLock
//    AbstractQueuedSynchronizer 独占、自旋
//    ReentrantLock
//    Mutex
//    java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock
//        ReadWriteLock
//    实现
//    ReentrantReadWriteLock

//    Condition

    @Test
    public void lockSupportTest(){
        System.out.println("start");
        LockSupport.parkNanos(1000000000);//1秒(s)=1000000000纳秒(ns)
        System.out.println("end");
//一开始会block线程，直到给定时间过去后才往下走

        System.out.println("start");
        LockSupport.unpark(Thread.currentThread());
        LockSupport.parkNanos(1000000000);
        System.out.println("end");
//不会block，因为一开始给了一个permit

        System.out.println("start");
        LockSupport.unpark(Thread.currentThread());
        LockSupport.unpark(Thread.currentThread());
        LockSupport.parkNanos(1000000000);
        System.out.println("inter");
        LockSupport.parkNanos(1000000000);
        System.out.println("end");
//第一个park不会block，第2个会，因为permit不会因为多次调用unpark就积累
        //LockSupport是可不重入 的，如果一个线程连续2次调用 LockSupport .park()(因为最大就是1，取完就阻塞了)，那么该线程一定会一直阻塞下去。
    }

    //测试LS对线程中断的响应
    @Test
    public void lockSupInterruptTest() throws Exception
    {
        Thread t = new Thread(new Runnable()
        {
            private int count = 0;
            @Override
            public void run()
            {
                long start = System.currentTimeMillis();
                long end = 0;
                while ((end - start) <= 1000)
                {
                    count++;
                    end = System.currentTimeMillis();
                }

                System.out.println("after 1 second.count=" + count);
                //等待或许许可
                LockSupport.park();
                //线程如果因为调用park而阻塞的话，能够响应中断请求(中断状态被设置成true)，但是不会抛出InterruptedException 。
                System.out.println("thread over." + Thread.currentThread().isInterrupted()); //返回true
            }
        });
        t.start();
        Thread.sleep(2000);
        // 中断线程
        t.interrupt();
        System.out.println("main over");
    }

    //工作窃取算法
    public  void  forkJoinTest(){
        ForkJoinPool forkJoinPool=new ForkJoinPool();

    }

}
