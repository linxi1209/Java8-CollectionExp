package com.max.javaEth;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author zhongailing(zhongailing@daojia.com)
 * @version V1.0
 * @Description:
 * @date Created in 2017-12-1 9:08
 */
public class ListExp {

    @Test
    public void listTest() {
        ArrayList<Integer> list = new ArrayList<Integer>(); //List 接口不行（因为List没有重写clone方法。接口只有实现）。只能是ArrayList实现
        list.add(1);
        list.add(2);

        //克隆
        ArrayList<Integer> listCopy = (ArrayList<Integer>) list.clone(); //开辟了一个新的堆空间。listCopy 和list完全独立的两个对象
        //移除且不修改
//        listCopy.remove(1);  //list 中的1并未被删除
//        System.out.println(list);
//        System.out.println(listCopy);
        System.out.println(list == listCopy);
        System.out.println(list.equals(listCopy));
        //浅复制：clone后的对象修改，并不影响克隆前，（新增一个引用地址，指向已有内存空间）
        //原因所有的对其他对象的引用仍然指向原来的对象。换言之，浅复制仅仅复制所考虑的对象，而不复制它所引用的对象。
        //深复制：clone后怎么改，对应的，clone前做出相应改变（新增一个引用地址&&新内存空间）
        //那些引用其他对象的变量将指向被复制过的新对象，而不再是原有的那些被引用的对象。换言之，深复制把要复制的对象所引用的对象都复制了一遍。
    }

    @Test
    public void test2() {
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.add(1);
        a1.add(10);
        //执行remove之后（删除该对象），再copy
        a1.remove(1);

        ArrayList<Integer> aCopy = (ArrayList<Integer>) a1.clone();
        System.out.println(aCopy);//只剩1
        System.out.println(a1); //只剩1
    }

    @Test
    public  void test3(){
        Map map=new HashMap();
        map.put(1,1);
        map.put(3,2);
        map.put(2,1);
        System.out.println(map.entrySet());//[1=1, 2=1, 3=2]
        System.out.println(map.keySet());
        System.out.println(map.values());
        if (map.values().contains(2)){
            System.out.println("2");
        }
        if (map.keySet().contains(1)){
            System.out.println("1");
        }
        for (Object o:map.entrySet()){
            System.out.println(o);
        }
//        LinkedHashMap
//        Properties


    }

    public void  test4(){
        Hashtable hashtable=new Hashtable();
        TreeMap treeMap=new TreeMap();
    }

    public  void test5(){
        HashSet set=new HashSet();
    }

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream=new FileInputStream(new File("C:\\plugin.txt"));
            System.out.println(fileInputStream.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
