package controllers.old;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class login {
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private Button member;

	@FXML
	private Button librarian;

	@FXML
	void gotoLibrarian(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/adminUI.fxml"));
		root = loader.load();
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void gotoMember(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/userUI.fxml"));
		root = loader.load();
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
