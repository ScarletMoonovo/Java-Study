package Multithreading.SafeByLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableImpl implements Runnable {
    // 定义一个共享的票源
    private int ticket = 100;
    // 1.在成员位置创建一个ReentrantLock对象
    Lock l = new ReentrantLock();
    // 设置线程任务：卖票
    @Override
    public void run() {
        // 使用死循环，让卖票重复执行
        while (true) {
            // 2.在可能出现线程安全问题的代码前，调用Lock接口中的方法lock获取锁对象
            l.lock();
            // 判断票是否大于0
            if (ticket > 0) {
                // 为了提高线程安全问题出现的几率，让程序睡眠10毫秒
                try {
                    // 可能会产生异常的代码
                    Thread.sleep(10);
                    // 进行卖票 ticket--
                    System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票！");
                    ticket--;
                } catch (InterruptedException e) {
                    // 异常的处理逻辑
                    e.printStackTrace();
                } finally {
                    // 一定会执行的代码，一般用于资源释放(资源回收)
                    // 3.在可能出现线程安全问题的代码后，调用Lock接口中的方法unlock释放锁对象
                    l.unlock(); // 无论程序是否有异常，都让锁对象释放掉，节约内存，提高程序的效率
                }
            }
        }
    }
}