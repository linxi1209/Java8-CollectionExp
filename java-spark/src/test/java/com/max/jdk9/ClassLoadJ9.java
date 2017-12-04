package com.max.jdk9;


/**
 * @author zhongailing(zhongailing@daojia.com)
 * @version V1.0
 * @Description:
 * @date Created in 2017-11-29 14:24
 */
public class ClassLoadJ9 {

    //bootstrap classLoader
    public static void main(String[] args) {
        System.out.println(Object.class.getClassLoader());
        System.out.println(ClassLoadJ9.class.getClassLoader());
    }
}
