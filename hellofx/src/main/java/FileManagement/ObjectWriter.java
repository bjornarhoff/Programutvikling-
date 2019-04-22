package FileManagement;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectWriter {

    public void WriteObjectToFile (Object obj) {

        try {

            FileOutputStream fous = new FileOutputStream(System.getProperty("user.home")+"/obj");
            ObjectOutputStream oos = new ObjectOutputStream(fous);
            oos.writeObject(obj);
            oos.close();
            System.out.println("Succesfully done! Write object to file!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
