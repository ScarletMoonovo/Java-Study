package Multithreading.ByCallableAndFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* 1. 创建Callable接口的实现类,并实现call()方法,该call()方法将作为线程执行体,并且有返回值
2. 创建Callable实现类的实例,使用Future Task类来包装Callable对象,该FutureTask对象封装来该Callable对象的call()方法的返回值
3. 使用FutureTask对象作为Thread对象的target创建并启动新线程
4. 调用FutureTask对象的get()方法来获得子线程执行结束后的返回值 */

public class CallableThreadTest implements Callable<Integer> {
    public static void main(String[] args) {
        CallableThreadTest ctt = new CallableThreadTest();
        FutureTask<Integer> ft = new FutureTask<>(ctt);
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
            if (i == 20) {
                new Thread(ft, "有返回值的线程").start();
            }
        }

        try {
            System.out.println("子线程的返回值: " + ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return i;
    }
}

/*创建线程的三种方式的对比
 * 1. 采用实现Runnable、Callable接口的方式创建多线程时，线程类只是实现了Runnable接口或Callable接口，还可以继承其他类
 * 2. 使用继承Thread类的方式创建多线程时，编写简单，如果需要访问当前线程，则无需使用Thread.currentThread()方法，直接使用this即可获得当前线程
*/

/*线程的几个主要概念
 * 线程同步
 * 线程间通信
 * 线程死锁
 * 线程控制：挂起、停止和恢复
*/

/*多线程的使用 
 * 有效利用多线程的关键是理解程序是并发执行而不是串行执行的。例如：程序中有两个子系统需要并发执行，这时候就需要利用多线程编程
 * 通过对多线程的使用，可以编写出非常高效的程序。不过请注意，如果你创建太多的线程，程序执行的效率实际上是降低了，而不是提升了
 * 上下文的开销也很重要，如果创建了太多线程，CPU花费在上下文的切换的时间将多余执行程序的时间
*/