package sdy;

import java.util.concurrent.TimeUnit;

/***
 * @author Jpunster
 * @date 2020/3/21 4:32 下午
 */
public class lock08 {
    public static void main(String[] args) {
        Phone08 phone1 = new Phone08();
        Phone08 phone2 = new Phone08();
        new Thread(() -> phone1.call(), "A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> phone2.sendSms(), "B").start();
    }
}


class Phone08 {
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


