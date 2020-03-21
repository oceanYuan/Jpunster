package sdy;

import java.util.concurrent.TimeUnit;

/***
 * @author Jpunster
 * @date 2020/3/21 4:19 下午
 */
public class lock07 {
    public static void main(String[] args) {
        Phone07 phone = new Phone07();
        new Thread(() -> phone.call(), "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> phone.sendSms(), "B").start();
    }
}


class Phone07 {
    /**
     *synchronized 和 static 修饰 锁的是Phone07 类模板
     */
    public synchronized static void call() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("call");
    }
    /**
     * 普通同步锁：对象锁
     */
    public synchronized void sendSms() {
        System.out.println("sendSms");
    }
}
