package FileManagement;

import CustomerModell.Customer;

public abstract class FileWriter {

    public abstract void writeObjectToCSV (Customer customer);
    public abstract void writeObjectToJOBJ ();
}
