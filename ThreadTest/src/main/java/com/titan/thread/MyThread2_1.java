package com.titan.thread;

/**
 * Created with IntelliJ IDEA.
 * User: Titan
 * Date: 2018/8/16
 * Time: 19:59
 * Explain: 使用lamda
 * 两个线程调用两个对象，保证运行结果正确
 * 类级别锁，方法添加static synchronized
 * static保证所有对象访问同一方法地址
 * synchronized控制锁
 */
public class MyThread2_1 {

    private static int num = 100;

    public static synchronized void printNum(String tag) {
        try {
            if("a".equals(tag)) {
                num = 100;
                System.out.println("tag a get num over");
                Thread.sleep(1000);
            } else {
                num = 200;
                System.out.println("tag b get num over");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("tag : " + tag + "; num : " + num);
    }

    public static void main(String[] args){
        final MyThread2_1 myThread1 = new MyThread2_1();
        final MyThread2_1 myThread2 = new MyThread2_1();

        Thread t1 = new Thread(() -> myThread1.printNum("a"));

        Thread t2 = new Thread(() -> myThread2.printNum("b"));

        t1.start();
        t2.start();
    }

}
