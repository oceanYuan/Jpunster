package sdy;
import java.util.concurrent.TimeUnit;

public class lock02 {
    /*** 8锁，就是关于锁的8个问题
     1、sendSms延迟4秒，两个线程先打印 发短信还是 打电话？
     1.发短信 2.打电话 */
    public static void main(String[] args) {
        Phone02 phone = new Phone02();
        //锁的存在
        new Thread(() -> {
            phone.sendSms();
        }, "A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            phone.call();
        }, "B").start();

    }
}
class Phone02 {
    // synchronized 锁的对象是方法的调用者！
    // 两个方法用的是同一个锁，谁先拿到谁执行！
    public synchronized void call() {
        System.out.println("打电话");
    }

    public synchronized void sendSms() {
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("发短信");
    }
}

