package Multithreading.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

public class CompletableFutureDemo {
    public static void main(String[] args) throws InterruptedException {
        long l = System.currentTimeMillis();
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行耗时操作...");
            timeConsumingOperation();
            return 100;
        });
        completableFuture.whenComplete((result, e) -> {
            System.out.println("结果：" + result);
        });
        System.out.println("主线程运算耗时：" + (System.currentTimeMillis() - l) + " ms");
        new CountDownLatch(1).await();
    }

    static void timeConsumingOperation() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// 可以发现耗时操作没有占用主线程的时间片，达到了异步调用的效果。我们也不需要引入任何第三方的依赖，这都是依赖于java.util.concurrent.CompletableFuture的出现
// CompletableFuture 提供了近50多个方法，大大便捷了java多线程操作，和异步调用的写法