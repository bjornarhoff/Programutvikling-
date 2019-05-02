package Threads;

import java.util.Random;

import javafx.concurrent.Task;

public class Thread implements Runnable {

    String name;
    int time;
    Random r = new Random();
    private Runnable runnable;


    public Thread(String x) {
        name = x;
        time = r.nextInt(999);
    }


    public void run() {
        try {
            System.out.printf("%s is sleeping for %d\n", name, time);
            java.lang.Thread.sleep(3000);
            System.out.printf("%s is done\n", name);

        } catch (Exception e) {

        }
    }

}
