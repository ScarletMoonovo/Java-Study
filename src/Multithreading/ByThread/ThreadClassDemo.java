package Multithreading.ByThread;

public class ThreadClassDemo {
    public static void main(String[] args) {
        // 线程1:通过实现Runnable接口创建线程
        Runnable hello = new DisplayMessage("Hello"); // 创建一个实现Runnable的实例
        Thread thread1 = new Thread(hello); // 创建一个线程
        thread1.setDaemon(true); // 将该线程标记为守护线程或用户线程
        thread1.setName("hello"); // 改变线程名字，使之与参数name相同
        System.out.println("Starting hello thread...");
        thread1.start(); // 使该线程开始执行；Java虚拟机调用该线程的run方法

        // 线程2:通过实现Runnable接口创建线程，但修改了线程优先级
        Runnable bye = new DisplayMessage("Goodbye");
        Thread thread2 = new Thread(bye);
        thread2.setPriority(Thread.MIN_PRIORITY); // 更改线程的优先级（1-10）
        thread2.setDaemon(true);
        System.out.println("Starting goodbye thread...");
        thread2.start();

        // 线程3：通过继承Thread类创建线程，这里的功能是猜一个数
        System.out.println("Starting thread3...");
        Thread thread3 = new GuessANumber(27);
        thread3.start();
        try {
            thread3.join(); // 若参数是long millisec等待该线程终止的时间最长为millis毫秒
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        // 线程4:通过继承Thread类创建线程
        System.out.println("Starting thread4...");

        Thread thread4 = new GuessANumber(75);

        thread4.start();
        System.out.println("main() is ending");
    }
}
