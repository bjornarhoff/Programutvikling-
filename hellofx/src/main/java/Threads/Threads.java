package Threads;

import FileManagement.CsvReader;
import javafx.concurrent.Task;

public class Threads extends Task<Void> {


    @Override
    protected Void call() throws Exception {
        int iterations;
        for (iterations = 0; iterations < 100000; iterations++) {
            if (isCancelled()) {
                updateMessage("Thread cancelled");
                break;
            }
        }

        try {
            java.lang.Thread.sleep(3000);
            CsvReader.read();
            System.out.println(CsvReader.read());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    }
