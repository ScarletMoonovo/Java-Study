package Multithreading.ExecutorService.ByCallable;

import java.util.concurrent.Callable;

public class TaskCallable implements Callable<Object> {
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 1000; i++) {
            System.out.println("自定义线程任务在执行" + i);
        }
        return null;
    }
}
