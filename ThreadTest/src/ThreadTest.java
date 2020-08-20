import java.util.*;

public class ThreadTest implements Runnable {
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("Other thread time : " + new Date());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadTest test = new ThreadTest();
        Thread thread = new Thread(test);
        thread.start();
        System.out.println("Main thread");
    }
}