package FileManagement;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class OpenFileChooser {


    public void configuringFC(FileChooser fileChooser,String title, String path) {

        // Set title for FileChooser
        fileChooser.setTitle(title);

        // Set Initial Directory
        fileChooser.setInitialDirectory(new File(System.getProperty(path)));

        fileChooser.getExtensionFilters().addAll(//
                        new FileChooser.ExtensionFilter("CSV files", "*.csv"),
                        new FileChooser.ExtensionFilter("jObj file ", "*.ser"));

        Stage stage = new Stage();

        File selectedFile = fileChooser.showSaveDialog(stage);

        if (selectedFile != null) {
            try {
                selectedFile.createNewFile();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
