package Multithreading.ExecutorService.ByCallable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3); // 创建线程池对象
        TaskCallable c = new TaskCallable(); // 创建Callable接口子类对象
        // 线程池中获取线程对象，调用run方法
        service.submit(c);
        // 再获取一个
        service.submit(c);
        // 关闭线程池
        service.shutdown();
    }
}
