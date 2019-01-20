package com.example.demo.thread;

import org.junit.Test;
import org.junit.jupiter.api.TestTemplate;

import java.util.concurrent.locks.LockSupport;

import static org.springframework.test.context.transaction.TestTransaction.start;

public class WaitNotify {
    public static  Object baozidian =null;

    public static void main(String[] args) {

    }
    @Test
    public void waitNotifyTest() throws InterruptedException {
        new Thread(()->{
           if(baozidian==null){
               synchronized (this){
                   try {
                       System.out.println("进入等待");
                       this.wait();
                   } catch (InterruptedException e){

                       e.printStackTrace();
                   }
               }
           }
            System.out.println("2,买到包子回家");
        }).start();

        //3秒之后产生一个包子
        Thread.sleep(3000L);
        baozidian=new Object();
        synchronized (this){
            this.notifyAll();
            System.out.println("3.通知消费者");
        }
    }

    @Test
    public void waitNotifyPark() throws InterruptedException {
        Thread thread = new Thread(() -> {
            if (baozidian == null) {
                try {
                        Thread.sleep(5000L);
                        System.out.println("进入等待");
                        LockSupport.park();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            System.out.println("2,买到包子回家");
        });
        thread.start();

        //3秒之后产生一个包子
        Thread.sleep(3000L);
        baozidian=new Object();
        synchronized (this){
            this.notifyAll();
            System.out.println("3.通知消费者");

            LockSupport.unpark(thread);//给制定线程，办法继续与运行的许可
            Thread.sleep(10000L);
        }
    }
}
