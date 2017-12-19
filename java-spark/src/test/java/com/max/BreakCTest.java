package com.max;

public class BreakCTest {
    /** 
     * 测试continue 
     * continue用来结束本次循环 
     */
    @org.junit.Test
    public void testContinue1() {
     System.out.println("--------测试continue-------");
     for (int i = 1; i <= 5; i++) {
     if (i == 3) continue; //只是不打印 3 ，跳出当前循环，接着执行下一个即可
     System.out.println("i=" + i);
     }
     }
     /**
     * break用来结束整个循环体
     */
    @org.junit.Test
    public void testBreak1() {
        System.out.println("--------测试break1-------");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) break;  //只打印了1,2；直接跳出循环，不再继续执行
            System.out.println("i=" + i);
        }
    }

    /**
     * 测试带标签的break语句 
     * 标签只能写在循环体之前，顺便学习一下java中语句标签的定义和使用 
     */
    @org.junit.Test
    public void testBreak2() { 
        System.out.println("--------测试break2-------"); 
        int i = 1; 
        int k = 4; 
        lable1: 
        for (; i <= 5; i++, k--) { 
            if (k == 0) break lable1; 
            System.out.println("i=" + i + " ; k=" + k); 
        } 
    } 

    @org.junit.Test
    public void testContinue2() { 
        System.out.println("--------测试continue2-------"); 
        lable1: 
        for (int i = 1; i < 10; i++) { 
            lable2: 
            System.out.println("i=" + i); 
            for (int j = 0; j < 10; j++) { 
                if (j == 9) continue lable1; 
            } 
        } 
    } 
}