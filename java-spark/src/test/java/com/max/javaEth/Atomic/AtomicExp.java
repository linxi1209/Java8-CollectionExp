package com.max.javaEth.Atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author zhongailing(zhongailing@daojia.com)
 * @version V1.0
 * @Description:
 * @date Created in 2017-12-12 9:53
 */
public class AtomicExp {
    private static AtomicReference<User> userAtomicReference=new AtomicReference<User>();

//    private static AtomicIntegerFieldUpdater<User> atomicIntegerFieldUpdater=AtomicIntegerFieldUpdater.newUpdater(User.class,"age");

    @Test
    public  void arrayTest(){
        int[] value=new int[]{1,2};
        AtomicIntegerArray atomicIntegerArray=new AtomicIntegerArray(value);

        System.out.println(atomicIntegerArray.getAndSet(0,3));//index 把第一位替换成3；返回prev值（1）
        System.out.println(atomicIntegerArray.get(0));//[3,2] 第1位变成3
        System.out.println(value[0]);//1  ？？为什么还是1
        // value 没有变 ，AtomicIntegerArray构造函数是把array.clone 修改是array的复制对象，而非array数组本身
    }

    @Test
    public  void refTest(){
        User user=new User("prev",15);
        userAtomicReference.set(user);//set为user对象，再cas是exp又传入user，update值为updater。所以肯定返回true。

        User updater=new User("updater",17);

        System.out.println(user==updater);
        System.out.println(userAtomicReference.compareAndSet(updater,updater));//false 更新失败,返回prev即user对象
        System.out.println(userAtomicReference.get().getName());//prev
        System.out.println(userAtomicReference.get().getAge());//15

        System.out.println(userAtomicReference.compareAndSet(user,updater));//返回true，实体的比较，具体在比什么呢？
        // 比较的对象引用地址：根据this对象的内存valueOffset的位置的值和expect比较，判断是否同一个对象地址；
        // 如果这里user换成Order对象，编译失败  同一对象类型，引用。。。都改源于user对象啊。
        // updater 和user 引用指向不同堆空间，所以cas 在比较时 返回false。
        System.out.println(userAtomicReference.get().getName());//updater
        System.out.println(userAtomicReference.get().getAge());//17
    }

//    @Test
//    public  void fieldTest(){
//        User conna=new User("conan",10);
//        //涨一岁
//        System.out.println(atomicIntegerFieldUpdater.getAndIncrement(conna));//10
//        System.out.println(atomicIntegerFieldUpdater.get(conna));//11
//    }

    static  class User{
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    static  class  Order{}
}
