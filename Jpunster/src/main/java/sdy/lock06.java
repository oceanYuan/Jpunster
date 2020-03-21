package sdy;

import java.util.concurrent.TimeUnit;

/***
 * @author Jpunster
 * @date 2020/3/21 4:07 下午
 */
public class lock06 {
    public static void main(String[] args) {
        Phone06 phone1 = new Phone06();
        Phone06 phone2 = new Phone06();
        new Thread(() -> phone1.call(), "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> phone2.sendSms(), "B").start();
    }
}
class Phone06 {
    /**
      被 synchronized 修饰 和 static 修饰的方法，锁的对象是类的 class 对象，是唯一的一把锁。
      Class锁是唯一的，所以多个对象使用的也是同一个Class锁。
     */
    public synchronized static void call() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("call");
    }
    public synchronized static void sendSms() {
        System.out.println("sendSms");
    }
}
