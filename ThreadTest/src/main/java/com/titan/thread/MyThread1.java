package com.titan.thread;

/**
 * Created with IntelliJ IDEA.
 * User: Titan
 * Date: 2018/8/16
 * Time: 19:59
 * Explain: 多个线程调用同一个对象，保证运行结果正确
 * 此种使用的是对象锁，在方法上添加synchronized即可
 */
public class MyThread1 extends Thread{

    private int count = 5;

    @Override
    public synchronized void run() {
        count --;
        System.out.println(this.currentThread().getName() + ":" + count);
    }

    public static void main(String[] args){
        MyThread1 myThread1 = new MyThread1();
        Thread t1 = new Thread(myThread1);
        Thread t2 = new Thread(myThread1);
        Thread t3 = new Thread(myThread1);
        Thread t4 = new Thread(myThread1);
        Thread t5 = new Thread(myThread1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

}
