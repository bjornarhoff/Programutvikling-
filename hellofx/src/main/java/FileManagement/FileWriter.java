package FileManagement;

import Customer_Controller.Customer;

public abstract class FileWriter {

    public abstract void writeObjectToCSV (Customer customer);
    public abstract void writeObjectToJOBJ ();
}
