public class InheritanceMultithreading {
    // region DESC
    // Implement Multithreading through inheritance. There are 3 steps
    // 1. Create a class which extends class Thread, and override run() method
    // 2. Instantiate the class
    // 3. call start() method.
    // note:
    // 1. start() method is neither defined in your class, nor overridden. Therefore, start() method is a method of Thread class.
    // 2. Put the code you want to concurrently running in run() method
    // 3. start() method has two main functions. One is causing the Thread to begin executing. The other one is
    //    to call the run() method.
    // endregion

    static class myThread extends Thread{
        /*
        A method that count even number
         */
        @Override
        public void run() {
            for (int i=0; i<=100; i++) {
                if (i % 2 == 0) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
        }
    }



    public static void main(String[] args) {

        // we can also use anonymous method
        new Thread(){
            @Override
            public void run() {
                for (int i=0; i<=100; i++) {
                    if (i % 2 != 0) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                    }
                }
            }
        }.start();

        myThread t1 = new myThread();
        myThread t2 = new myThread();

        /*
         thread object like t1 can only be started once, if you want to create a new thread to do the same thing,
         you cannot just simply t1.start() again, you have to create a new thread, and call start() on new object.
         */

        t1.start();
        // a new thread
        t2.start();
        /*
        you can see that odd numbers and even numbers get printed out alternatively.
        which mean there are two threads doing two things.
         */

        // main thread
        for (int i=0; i<=100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
