package jumptojava;

import java.util.ArrayList;

public class SampleThread implements Runnable {
    int seq;

    public SampleThread(int seq) {
        this.seq = seq;
    }

    public void run() { // If Thread extended, you should implement run method.
        System.out.println("Thread " + this.seq + " running");
        try {
            Thread.sleep(1000); // wait for 1 sec
        } catch (Exception e) {

        }
        System.out.println("Thread " + this. seq + " ended.");    // thread ended
    }
    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new SampleThread(i));
            t.start();
            threads.add(t);
        }
        for (int i = 0; i < threads.size(); i++) {
            Thread t = threads.get(i);
            try {
                t.join();   // Wait until thread t ends.
            } catch (Exception e) {

            }
        }
        System.out.println("Main ended.");
    }
}
