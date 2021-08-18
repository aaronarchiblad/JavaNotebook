import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    /*
    Use ThreadPool to implement multithreading
    1. build a thread pool, you can specify the number of thread
    2. execute a program, you need to provide an object that implements Runnable or a Callable interface.
    3. shutdown() thread pool

    Note: There are 3 benefits
    1. increase performance, you don't need to create threads, threads are already created, when you
       need it, you just go to the pool and take it. After you finish your job, you give back the threads.
       Therefore, it save your creating threads' time.
    2. easy to manage: You can specify corePoolSize, maximumPoolSize, keepAliveTime, etc.
     */

    static class MyThreadPoolThread1 implements Runnable {

        @Override
        public void run() {
            for (int i=0; i<=20; i++) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
        }
    }

    static class MyThreadPoolThread2 implements Runnable {

        @Override
        public void run() {
            for (int i=0; i<=20; i++) {
                if (i % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) service;
//        executorService.setKeepAliveTime();
//        executorService.setCorePoolSize(15);

        executorService.execute(new MyThreadPoolThread1()); // suitable for Runnable()
//        executorService.submit(); // suitable for Callable()
        executorService.execute(new MyThreadPoolThread2());
        executorService.shutdown();
    }
}
