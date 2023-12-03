package controllers.old;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class checkOutRecords {

    @FXML
    private Button book;

    @FXML
    private Button publication;

    @FXML
    private Button movie;

    @FXML
    private Button checkout;

    @FXML
    private Button members;

    @FXML
    private Button addItem;

    @FXML
    private Button addMember;

    @FXML
    private Button collections;

    @FXML
    private TextField search;

    @FXML
    private Button view;

    @FXML
    private TableColumn<?, ?> itemId;

    @FXML
    private TableColumn<?, ?> memberId;

    @FXML
    private TableColumn<?, ?> ckOutDate;

    @FXML
    private TableColumn<?, ?> exCkoutDate;

    @FXML
    private TableColumn<?, ?> checkInDate;

    @FXML
    private TableColumn<?, ?> action;
    private Stage stage;
    private Parent root;
    private Scene scene;

    @FXML
    void gotoCollection(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/adminCollection.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void gotoMember(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/Members.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onAddItem(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/addItem.fxml"));
        root = loader.load();
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void onAddMember(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/addMember.fxml"));
        root = loader.load();
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void onViewClick(ActionEvent event) {

    }

    @FXML
    void oncheckOutClick(ActionEvent event) {

    }

}
