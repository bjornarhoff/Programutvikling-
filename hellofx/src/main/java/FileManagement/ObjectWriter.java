package FileManagement;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectWriter extends FileWriter {

    /**
     * a method which writes an object to file
     * @param obj
     */
    public void writeToFile (Object obj) {

        try {

            FileOutputStream fous = new FileOutputStream(System.getProperty("user.home")+"/obj");
            ObjectOutputStream oos = new ObjectOutputStream(fous);
            oos.writeObject(obj);
            oos.close();
            fous.close();
            System.out.println("Succesfully done! Write object to file!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
