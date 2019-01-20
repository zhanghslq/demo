package com.example.demo.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 *  --状态：  自己实现Lock锁
 * 实现一把自己的锁
 */
public class NeteseLock implements Lock {

    AtomicReference<Thread> owner=new AtomicReference<>();

    //集合，来存储我们的等待信息
    LinkedBlockingQueue<Thread> waiters=new LinkedBlockingQueue<>();
    /**
     * 如果拿不到锁会一直等待
     */
    @Override
    public void lock() {

        boolean park=false;
        while (!tryLock()){

            if(!park){//加入等待集合
                waiters.offer(Thread.currentThread());
                park=true;
            }else {//进入等待许可
                LockSupport.park();
            }


        }
        waiters.remove(Thread.currentThread());
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        /**
         * cas 调用操作内存
         */

        return owner.compareAndSet(null,Thread.currentThread());
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        //释放锁之后通知等到这
        if(owner.compareAndSet(Thread.currentThread(),null)){

            //遍历等待这

            Thread next=null;
            while ((next=waiters.peek())!=null){
                LockSupport.unpark(next);
            }
        }

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
