package sdy;

import java.util.concurrent.TimeUnit;

/***
 * @author Jpunster
 * @date 2020/3/21 3:32 下午
 */
public class lock04 {
    public static void main(String[] args) {
        // 两个对象，两个调用者，两把锁！
        Phone04 phone1 = new Phone04();
        Phone04 phone2 = new Phone04();
        // 锁的存在
        new Thread(() -> {
            phone1.sendSms();
        }, "A").start();
        // 捕获
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            phone2.call();
        }, "B").start();
    }
}

class Phone04 {
    //synchronized 锁的对象是方法的调用者！
    public synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendSms");
    }
    public synchronized void call() {
        System.out.println("call");
    }
}


