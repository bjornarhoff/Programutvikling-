package FileManagement;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CsvReader {

   public static void read () {
       String line;

       List<List<String>> dataFromCsv = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home")+"/customer2.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                dataFromCsv.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       System.out.println(dataFromCsv.toString());

    }

}