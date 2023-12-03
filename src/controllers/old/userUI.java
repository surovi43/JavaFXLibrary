package controllers.old;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class userUI {

    @FXML
    private Button login;

    @FXML
    private Button book;

    @FXML
    private Button publication;

    @FXML
    private Button movie;

    @FXML
    private TextField searchItem;

    @FXML
    private Button searchBtn;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void gotoCollection(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/userCollection.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onLogin(ActionEvent event) {

    }

    @FXML
    void onSearch(ActionEvent event) {

    }

}
