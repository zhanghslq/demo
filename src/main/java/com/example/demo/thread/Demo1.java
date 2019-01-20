package com.example.demo.thread;

public class Demo1 {
    private static Thread thread1;
    private static Demo1 obj;
    public static void main(String[] args) throws InterruptedException {
        //第一种状态
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1当前状态"+Thread.currentThread().getState().toString());
                System.out.println("thread1执行");
            }
        });
        System.out.println("没调用start方法，thread1当前状态 ："+thread.getState().toString());


        thread.start();

        Thread.sleep(2000L);

        System.out.println("等待两秒，再看thread1当前状态"+thread.getState().toString() );


        System.out.println("第二种：新建，运行，等待，运行，终止");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(" ："+Thread.currentThread().getState().toString());
                System.out.println("thread2执行了" );
            }
        });

    }
}
