package com.max.jdk8;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.StringTokenizer;

/**
 * @author zhongailing(zhongailing@daojia.com)
 * @version V1.0
 * @Description:
 * @date Created in 2017-11-30 9:35
 */
public class StringExp {
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("this ,is a ,test",",",true);
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        String string=new String(new char[]{'1','2','3','6'}); //Arrays.copyOf(value, value.length);
        char charPoint=string.charAt(1);
        System.out.println(charPoint);
    }

    @Test
    public  void test(){
        String abc=new String("123");
        String abcd=new String("123");
        System.out.println(abc==abcd?true:false);
        System.out.println(abc.equals(abcd));
        System.out.println();
        System.out.println("dfda"==null?2:4);
        System.out.println("dfjadsfkl"=="dfjadsfkl"?1:2);

        System.out.println("SDLJFLAS".substring(2));
        System.out.println(StringUtils.stripStart("yxabc  ", "xyz")); //剃去与第二个参数相同的字母后返回
    }
}
