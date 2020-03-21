package sdy;

import java.util.concurrent.TimeUnit;

/***
 * @author Jpunster
 * @date 2020/3/21 1:59 下午
 */
public class lock03 {
    public static void main(String[] args) {
        Phone03 phone = new Phone03();
        // 两个线程使用的是同一个对象。两个线程是一把锁！先调用的先执行！
        new Thread(() -> phone.call(), "A").start();
        new Thread(() -> phone.sendSms(), "B").start();
        new Thread(() -> phone.getWeixinMs(), "C").start();
    }
}
    class Phone03 {
        // 被 synchronized 修饰的方法、锁的对象是方法的调用者
        public synchronized void call() {
            //多个线程使用一把锁
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("call");
        }
        public synchronized void sendSms() {
            System.out.println("sendSms");
        }
        //接收微信，没有锁
        public void getWeixinMs() {
            System.out.println("getWeixinMs");
        }
    }


