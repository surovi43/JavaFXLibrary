package controllers.old;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class frontend {

    @FXML
    private TextField inputId;

    @FXML
    private TextField inputPass;

    @FXML
    void onSubmit(ActionEvent event) {
        String id = inputId.getText();
        int ID = Integer.parseInt(id);
        String pass = inputPass.getText();
        int PASS = Integer.parseInt(pass);
        if (ID == 123 && PASS == 21) {
            System.out.println("login successful");
        } else {
            System.out.println("login fail");
        }

    }

}
