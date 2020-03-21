package sdy;

import java.util.concurrent.TimeUnit;

/***
 * @author Jpunster
 * @date 2020/3/21 3:47 下午
 */
public class lock05 {
    public static void main(String[] args){

        new Thread(()->{Phone05.call();},"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{Phone05.sendSms();},"B").start();
    }
}
class Phone05 {
    /**
     * 被 synchronized  和 static 修饰的方法，锁的对象是类的 class 对象，是唯一的一把锁。线程之间是顺序执行。
     * static 静态方法  类一加载就有了！锁的是Class
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
