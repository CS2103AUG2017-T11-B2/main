package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.util.ResourceBundle;

public class AutoCompleteTextField implements Initializable {

    @FXML
    private TextField commandTextField;

    private String[] suggestions = {"add", "sort", "delete", "list", "find", "findTag"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TextFields.bindAutoCompletion(commandTextField, suggestions);
    }
}
