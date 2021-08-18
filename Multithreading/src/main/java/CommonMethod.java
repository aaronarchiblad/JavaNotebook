public class CommonMethod {
    /*
    Commonly used method
    1. start(): start thread, and execute run().
    2. run(): operations when thread is executed.
    3. getName(): get the name of the thread.
    4. setName(): set the name of the thread.
    5. Thread.currentThread(): get the current thread(the object, not the name).
    6. yield(): release current CPU execution authority, which basically means that the thread is not doing anything
                particularly important and if any other threads or processes need to be run, they should run.
                Otherwise, the current thread will continue to run.
    7. join(): in thread 1, when join() method of thread 2 is called, thread 1 will get blocked until thread 2 finished.
    8. stop(): force to terminate current thread. Note: it is deprecate, DO NOT USE IT.
    9. sleep(millisecond x): thread get blocked by x milliseconds.
    10. isAlive(): determine if the thread is still alive.
     */

    static class myThread extends Thread{
        @Override
        public void run() {
            for (int i=0; i <= 100; i++) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }

                if (i % 20 == 0) {
                    /*
                    Note: OOP concept, when you call a class method: yield() within a class method: run(), you are
                    calling the class method, so you need to specify keyword this to tell Java that I am calling
                    the class method, not the method outside the class. "this" in here means the object.
                     */
                    Thread.yield();
                    /*
                    By add yield(), we can see when i = 20, 40, 60, and so on, the current thread have a possibility
                    to release, so that other thread can use the CPU. The result is that you will see the following
                    content on the console, Thread 1: 20 Thread 2: 6, ... but this is not guarantee.
                     */

                    /*
                    In here, it is possible for sleep() to throw a exception, you HAVE TO use try/catch, you cannot
                    throw exception, because myThread inherit from Thread, when you override run() method, run() method
                    originally do not throws exception. Therefore, you cannot throw exception when you override it.
                    Child class cannot throw an exception that is bigger than Parent exception.
                     */
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /*
        We can build a constructor without threadName argument, so that we only use default threadName argument.
         */
        public myThread(){
            super();
        }

        /*
        Since class Thread already provide a constructor with threadName argument, We can provide a constructor
        with threadName argument.
         */
        public myThread(String name) {
            super(name);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        myThread myThread = new myThread();
        myThread.setName("T1");

        // instantiate a thread with name
        myThread myThread1 = new myThread("T3");


        myThread.start();
        myThread1.start();
        Thread.currentThread().setName("main");
        for (int i = 0; i<= 100; i++){
            System.out.println(Thread.currentThread().getName() + ": " + i);
            if (i == 5) {
                /*
                Now we are in main thread, we call join() method of myThread, myThread get executed. main Thread will
                wait until myThread finished.
                 */
                myThread.join();
            }
        }

        System.out.println(myThread.isAlive());


    }
}
