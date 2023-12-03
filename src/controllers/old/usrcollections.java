package controllers.old;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import library.Book;
import library.Item;
import library.Library;
import library.Movie;

public class usrcollections implements Initializable {
    Library library = new Library("UAP library");
    @FXML
    private Button book;

    @FXML
    private Button publication;

    @FXML
    private Button movie;

    @FXML
    private Button members;

    @FXML
    private Button checkouts;

    @FXML
    private Button addItem;

    @FXML
    private Button addMember;

    @FXML
    private TextField searchByTitle;

    @FXML
    private TextField searchByAuthor;

    @FXML
    private Button searchBtn;

    @FXML
    private TableView<Item> table;

    @FXML
    private TableColumn<Item, String> tabletitle;

    @FXML
    private TableColumn<Item, ArrayList<String>> author;

    @FXML
    private TableColumn<Item, String> category;

    @FXML
    private TableColumn<Item, Integer> pyear;

    @FXML
    private TableColumn<Item, String> publiser;

    @FXML
    private TableColumn<?, ?> action;

    @FXML
    private Object itemID;

    ObservableList<Item> initialItem() {

        Item I1 = new Book("java", "boook", null, 1230, "skkk");
        Item I3 = new Book("c++", "programming", null, 1990, "shms");
        return FXCollections.observableArrayList(I1, I3);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for (Item item : library.getItems()) {
            addDatatoTabel(
                    item.getItemId(),
                    item.getTitle(),
                    item.getCategory(),
                    item.getAuthors().toString().replaceAll("[\\[\\]]", ""),
                    String.valueOf(item.getPublishYear()),
                    "Publisher");
        }

        tabletitle.setCellValueFactory(new PropertyValueFactory<Item, String>("Title"));
        category.setCellValueFactory(new PropertyValueFactory<Item, String>("Category"));
        author.setCellValueFactory(new PropertyValueFactory<Item, ArrayList<String>>("Author"));
        pyear.setCellValueFactory(new PropertyValueFactory<Item, Integer>("PublishYear"));
        publiser.setCellValueFactory(new PropertyValueFactory<Item, String>("Publisher"));
        table.setItems(initialItem());
    }

    private void addDatatoTabel(String itemId, String title, String category, String authors, String PublisYear,
            String publisher) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/adminCollection.fxml"));
            Parent node = loader.load();
            usrcollections controller = (usrcollections) loader.getController();
            controller.setData(title, author, category, PublisYear, publisher, itemID);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setData(String title, TableColumn<Item, ArrayList<String>> author2, String category2,
            String publisYear, String publisher, Object itemID) {
        // TODO Auto-generated method stub
        this.itemID = itemID;
        this.tabletitle.setText(title);
        this.category.setText(category2);
        this.pyear.setText(publisYear);
        this.publiser.setText(publisher);

    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void onAddItem(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/addItem.fxml"));
        root = loader.load();
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void onAddMember(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/addMember.fxml"));
        root = loader.load();
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void onBook(ActionEvent event) {

    }

    @FXML
    void onCheckout(ActionEvent event) {

    }

    @FXML
    void onMember(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/Members.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onMoive(ActionEvent event) {

    }

    @FXML
    void onPublication(ActionEvent event) {

    }

}
