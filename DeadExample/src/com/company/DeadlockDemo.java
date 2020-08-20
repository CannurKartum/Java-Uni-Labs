package com.company;

class DeadlockDemo extends Thread {
    static Thread mainThread;
    public void run()
    {
        System.out.println("Child Thread waiting for" +  " main thread completion");
        try {

            // Child thread waiting for completion
            // of Dad thread
            mainThread.join();
        }
        catch (InterruptedException e) {
            System.out.println("Child thread execution" +  " completes");
        }
    }
    public static void main(String[] args)
            throws InterruptedException
    {
        DeadlockDemo.mainThread = Thread.currentThread();
        DeadlockDemo thread = new DeadlockDemo();

        thread.start();
        System.out.println("Dad thread waiting for " + "Child thread completion");

        // Dad thread is waiting for the completion
        // of Child thread
        thread.join();

        System.out.println("Dad thread execution" +  " completes");
    }
}