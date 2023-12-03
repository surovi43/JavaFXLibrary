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

public class adminUI {
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private TextField searchItem;

	@FXML
	private Button searchBtn;

	@FXML
	void gotoDashBoard(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/adminCollection.fxml"));
		root = loader.load();
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void onCheckouts(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/CheckOutRecords.fxml"));
		root = loader.load();
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void onMembers(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/Members.fxml"));
		root = loader.load();
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void onSearch(ActionEvent event) {

	}

}
