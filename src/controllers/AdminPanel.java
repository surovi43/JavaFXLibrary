package controllers;

import application.Store;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminPanel implements Initializable {

   @FXML
   private Button allCollection, book, movie, publication, checkouts, members, addItem, addMember, logoutBtn;

   @FXML
   private VBox rootContainer;

   @FXML
   void logOut(ActionEvent event) {
      try {
         Parent root = FXMLLoader.load(getClass().getResource("../resources/LoginPage.fxml"));
         Scene scene = new Scene(root);
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         stage.setScene(scene);
         stage.show();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @FXML
   void onAddItem(ActionEvent event) {
      Store.currentPage = "Add Item";
      loadPage("AddItem");
   }

   @FXML
   void onAddMember(ActionEvent event) {
      Store.currentPage = "Add Member";
      loadPage("AddMember");
   }

   @FXML
   void showCollection(ActionEvent event) {
      Store.currentPage = ((Button) event.getSource()).getText();
      loadPage("Collections");
   }

   @FXML
   void onCheckout(ActionEvent event) {

   }

   @FXML
   void onMember(ActionEvent event) {
      loadPage("Members");
   }

   @Override
   public void initialize(URL location, ResourceBundle resources) {
      Store.rootContainer = rootContainer;
      loadPage("Collections");
   }

   private Object loadPage(String pageLocation) {
      Object pageController = null;
      try {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/" + pageLocation + ".fxml"));
         Parent page = loader.load();
         pageController = loader.getController();
         Store.nevigateTo(page);
      } catch (IOException e) {
         e.printStackTrace();
      }
      return pageController;
   }

}
