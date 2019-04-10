package FileManagement;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader {
    private static int countRows;
    private static String[] data;



    public static String [] createArrayFromCSV (){
        BufferedReader bf = null;
        String rows = null;

        try {
            bf = new BufferedReader(new FileReader(System.getProperty("user.home") + "/customer2.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            while ((rows = bf.readLine()) != null) {
                /** Regex function ->
                 / = delimiter
                 .* = zero or more of anything but newline
                 \s = anything except a whitespace (newline, tab, space) */

                data = rows.split("\\s*,\\s*");
                countRows++;
                //System.out.println("Row" + countRows + ":" + rows);

            }

        } catch (IOException e) {
            System.out.println("Error in BufferedReader");
            e.printStackTrace();
        } finally {
            try {

                bf.close();
            } catch (IOException e) {
                System.out.println("Error while closing BufferedReader");
                e.printStackTrace();
            }
        }
        return data;
    }


        public static void readFromCsv () {
        BufferedReader bf = null;
        //String [] rowFromFile = createArrayFromCSV();
        String[] data;
        //ArrayList<String> arrayList = new ArrayList<>();



        try {
            bf = new BufferedReader(new FileReader(System.getProperty("user.home") + "/customer2.csv"));
            String rows = null;
            while ((rows = bf.readLine()) != null) {
                /** Regex function ->
                 / = delimiter
                 .* = zero or more of anything but newline
                 \s = anything except a whitespace (newline, tab, space) */

                data = rows.split("\\s*,\\s*");
                countRows++;
                System.out.println("Row" + countRows + ":" + rows);
            }
           /** for (int i = 1; i < rowFromFile.length; i++) {
                arrayList.add(rowFromFile[i]);
            } */
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error in BufferedReader");
            e.printStackTrace();

        } finally {
            try {

                bf.close();
            } catch (IOException e) {
                System.out.println("Error while closing BufferedReader");
                e.printStackTrace();
            }
        }
    }


}