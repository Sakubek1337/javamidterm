package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Controller {

    @FXML
    private MenuItem newFile;

    @FXML
    private MenuItem opening;

    @FXML
    private MenuItem saving;

    @FXML
    private MenuItem studentInfo;

    @FXML
    private MenuItem infoUni;

    @FXML
    private TextArea textArea;

    public Controller() {
    }

    @FXML
    void UniversityInfo(ActionEvent event) {
        String message = "Ala-Too International University . Kyrgyzstan , Bishkek 2021";
        JOptionPane.showMessageDialog(null, message);
    }

    @FXML
    void infoStudent(ActionEvent event) {
        String message = "Name: Salamatbek\n" + "Surname: Mambetkadyrov\n" + "Faculty: Computer Science\n" +
                "Date of birth: 10.09.2003\n" + "Gender: Male";
        JOptionPane.showMessageDialog(null, message);
    }

    @FXML
    void newfile(ActionEvent event) {
        textArea.setText("");
    }

    @FXML
    void open(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file  = fileChooser.showOpenDialog(javafx.stage.Stage.getWindows().get(0));
        String newText = "";
        if (file != null) {
            try {
                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    newText += data + "\n";
                }
                myReader.close();
                textArea.setText(newText);
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

    @FXML
    void save(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        File file = fileChooser.showSaveDialog(javafx.stage.Stage.getWindows().get(0));
        String text = textArea.getText();

        if (file != null) {
            saveTextToFile(text, file);
        }
    }

    void saveTextToFile(String content, File file){
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

