package Threads;

import java.util.Random;

public class Threadexample implements Runnable {

    String name;
    int time;
    Random r = new Random();


    public Threadexample (String x){
        name = x;
        time = r.nextInt(999);
    }


    public void run(){
        try {
            System.out.printf("%s is sleeping for %d\n", name, time);
            java.lang.Thread.sleep(40);
            System.out.printf("%s is done\n", name);

        }
        catch(Exception e){

        }
    }


}
