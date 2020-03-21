package sdy;

/***
 * @author Jpunster
 * @date 2020/3/21 1:59 下午
 */
public class lock01 {
    /*** 8锁，就是关于锁的8个问题
     1、标准情况下，两个线程先打印 是先发短信还是打电话？
     结果：1.发短信 2.打电话 */
    public static void main(String[] args) {
        Phone01 phone = new Phone01();
        //有synchronized 锁的存在
        new Thread(() -> {
            phone.sendSms();
        }, "A").start();
        new Thread(() -> {
            phone.call();
        }, "B").start();
    }
}
class Phone01 {
    // synchronized 锁的对象是方法的调用者！
    // 两个方法用的是同一个锁，谁先拿到谁执行！
    public synchronized void sendSms() {
        System.out.println("发短信");
    }
    public synchronized void call() {
        System.out.println("打电话");
    }
}

