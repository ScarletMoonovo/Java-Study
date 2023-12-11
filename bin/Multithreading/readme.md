# 线程池
1. 线程池，其实就是一个容纳多个线程的容器，其中的线程可以反复使用，省去了频繁创建线程对象的操作，无需反复创建线程而消耗过多资源

2. 为什么要用到线程池？每次用的时候手动创建不行吗？
在Java中，如果每个请求到达就创建一个新线程，开销是相当大的。在实际使用中，创建和销毁线程花费的系统资源都相当大，甚至可能要比在处理实际的用户请求的时间和资源要多得多。除了创建和销毁线程的开销之外，活动的线程也需要消耗系统资源。如果在一个jcm里创建太多的线程，可能会使系统由于过度消耗内存或“切换过度”而导致系统资源不足。为了防止资源不足，需要采取一些办法来限制任何给定时刻处理的请求数目，尽可能减少创建和销毁线程的次数，特别是一些资源耗费比较大的线程的创建和销毁，尽量利用已有对象来进行服务。

线程池主要用来解决线程生命周期开销问题和资源不足问题。通过对多个任务重复使用线程，线程创建的开销就被分摊到了多个任务上了，而且由于在请求到达时线程已经存在，所以消除了线程创建所带来的延迟。这样，就可以立即为请求服务，使用应用程序响应更快；另外，通过适当的调整线程中的线程数目可以防止出现资源不足的情况 

3. 线程池都是通过线程池工厂创建，再调用线程池中的方法获取线程，再通过线程去执行任务方法

- Executors：线程池创建工厂类
- public static ExecutorServicenewFixedThreadPool(int nThreads): 返回线程池对象
- ExecutorService：线程池类
- Future<?> submit(Runnable task)：获取线程池中的某一个线程对象，并执行
- Future接口：用来记录线程任务执行完毕后产生的结果。线程池创建与使用

4. 两种使用线程池创建线程的方法
- 使用Runnable接口创建线程池
  使用线程池中线程对象的步骤：
  1. 创建线程池对象
  2. 创建Runnable接口子类对象
  3. 提交Runnable接口子类对象
  4. 关闭线程池
  详见Multithreading/ExecutorService/ByRunnable/
- 使用Callable接口创建线程池
  Callable接口：与Runnable接口功能相似，用来指定线程的任务。其中的call()方法，用来返回线程任务执行完毕后的结果，call()方法可抛出异常
  ExecutorService：线程池类
  <T> Future<T> submit(Callable<T> task)：获取线程池中的某一个线程对象，并执行
  Future接口：用来记录线程任务完毕后产生的结果。线程池创建与使用

  使用线程池中线程对象的步骤：
  1. 创建线程池对象
  2. 创建Callable接口子类对象
  3. 提交Callable接口子类对象
  4. 关闭线程池
## 详见Multithreading/ExecutorService/ByCallable/

# 线程安全问题
产生原因：多个线程竞争同一资源（访问同一数据），可参考经典的生产者消费者问题。
解决方案：run方法内：同步代码块synchronized {}
`public synchronized 返回值类型 方法名() {} 自动释放对象锁`
使用Lock锁
Lock锁需要程序员（在finally代码块中）手动释放
`Lock lock = new ReentranttLock() // Reentrant(可重用的)`
Lock实现提供了比使用synchronized方法和语句可获得的更广泛的锁定操作，是JDK1.5之后出现的
Lock接口中的方法：
```
void lock() // 获取锁
void Unlock() // 释放锁
```
Lock接口的实现类
`java.util.concurrent.locks.ReentrantLock implements Lock`

使用步骤：
1. 在成员位置创建一个ReetrantLock对象
2. 在可能出现线程安全的代码前，调用Lock接口中的方法lock获取锁对象
3. 在可能出现线程安全问题的代码后，调用Lock接口中的方法unlock释放锁对象
## 详见SafeByLock包

# 用CompletableFuture来解决回调的问题
## 详见CompletableFuture包

# 补充Object类的线程方法
notify()：通知一个在对象上等待的线程，使其从wait()返回，而返回的前提是该线程获取到了对象的锁
notifyAll()：通知所有等待在该对象上的线程
wait()：调用该方法的线程进入WAITING状态，只有等待另外线程的通知或被中断才会返回，需要注意：调用wait()方法后，会释放对象的锁
wait(long)：超时等待一段时间，这里的参数是毫秒，也就是等待长达n毫秒，如果没有通知就超时返回
wait(long, int)：对于超时时间更细粒度的控制，可以达到毫秒