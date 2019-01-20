package com.example.demo.thread;


import java.util.concurrent.locks.ReentrantLock;

public class Demo3 {
    private static int i;
    public static void main(String[] args) throws InterruptedException {
        Demo3 demo3=new Demo3();

        NeteseLock lock = new NeteseLock();

        Thread[] threads=new Thread[7];

        for (int i = 0; i < threads.length; i++) {
           int finall=i;
           Thread thread=new Thread(()->{
               System.out.println("线程"+finall+"开始执行");
               for (int j = 0; j < 10000; j++) {
                   lock.lock();
                   try {
                       demo3.i++;
                   } finally {
                       lock.unlock();
                   }


               }
               System.out.println("线程"+finall+"执行结束");

           });
           threads[i]=thread;

            thread.start();

        }
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("执行结束"+demo3.i);
    }
}
