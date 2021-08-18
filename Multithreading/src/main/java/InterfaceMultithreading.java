public class InterfaceMultithreading {

    /*
     Implement Multithreading through Interface. There are 3 steps
     1. Create a class which implements Runnable interface and override run() method
     2. Instantiate the class
     3. pass object created in step 2 into Thread class and call start() method.
     Note:
     1. Compare implementing by Interface to inheritance, it is better to use interface, because
        Java does not support multiple inheritance. If you have a class that already inherits from
        another class, this class cannot inherit Thread class.
     2. In Interface, you can make shared data as an attribute, so you don't need to make a static
        attribute to share data between threads.
     */

    static class Mythread implements Runnable {

        @Override
        public void run() {
            for (int i=0; i <= 20; i++) {
                if (i % 2 == 0) {
                    // Unlike inheritance, you cannot call this.getName() here, because Mythread does
                    // not inherit Thread, Runnable does not have getName() method. So, you have to
                    // write Thread.currentThread().getName()
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Mythread mythread = new Mythread();

        // By default, one Thread constructor allows you to pass a Runnable as an argument
        Thread thread = new Thread(mythread);
        Thread thread1 = new Thread(mythread);

        /*
        Here we call start(), start() call run() of the thread. However, the thread we call is
        Thread thread = new Thread(mythread), why does it do the run() method we wrote?
        The reason is that run() method in Thread has a condition, if target != null; it runs
        run() of target, where target is a Runnable. When we build a new thread, and pass in
        an argument to it, that argument is a target.
         */
        thread.start(); // whoever starts the thread, the thread belong to whom
        thread1.start();
        System.out.println("Hello from Thread " + Thread.currentThread().getName());
    }
}
