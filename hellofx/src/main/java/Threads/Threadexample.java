package Threads;

import FileManagement.CsvReader;

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
            CsvReader.read();

        }
        catch(Exception e){

        }
    }


}
