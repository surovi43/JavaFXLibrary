package controllers.old;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import library.Item;
import library.Library;

public class addItem {
    Library library = new Library("uap library");

    @FXML
    private Button book;

    @FXML
    private Button publication;

    @FXML
    private Button moive;

    @FXML
    private TextField itemHeading = new TextField();

    @FXML
    private TextField inputTitle = new TextField();

    @FXML
    private TextField inputCategory = new TextField();

    @FXML
    private Label authorTitle;

    @FXML
    private TextField inputAuthors = new TextField();

    @FXML
    private HBox publisherBox;

    @FXML
    private TextField inputPublisher = new TextField();

    @FXML
    private Label publishTitle;

    @FXML
    private TextField inputPublishYear = new TextField();

    @FXML
    private HBox journalCheck;

    @FXML
    private RadioButton yesbtn;

    @FXML
    private RadioButton nobtn;

    @FXML
    private Button addbtn;

    @FXML
    void clickBook(ActionEvent event) {
        itemHeading.setText("BOOK");
        authorTitle.setText("Authors");
        inputAuthors.setPromptText("author 1 , author 2....");
        publisherBox.setVisible(true);
        publishTitle.setText("Publish Year");
        journalCheck.setVisible(false);
        journalCheck.setMaxHeight(0);
        publisherBox.setMaxHeight(65);
        cleanInput();
    }

    @FXML
    void clickMovie(ActionEvent event) {
        itemHeading.setText("MOVIE");
        authorTitle.setText("Directors");
        inputAuthors.setPromptText("director 1 , director 2....");
        publisherBox.setVisible(false);
        publisherBox.setMaxHeight(0);
        publishTitle.setText("Release Year");
        journalCheck.setVisible(false);
        journalCheck.setMaxHeight(0);
        cleanInput();
    }

    @FXML
    void clickNo(ActionEvent event) {

    }

    @FXML
    void clickPublication(ActionEvent event) {
        itemHeading.setText("PUBLICATION");
        journalCheck.setVisible(true);
        journalCheck.setMaxHeight(65);
        publisherBox.setVisible(true);
        publishTitle.setText("Publish Year");
        authorTitle.setText("Authors");
        inputAuthors.setPromptText("author 1 , author 2....");
        publisherBox.setMaxHeight(65);
        cleanInput();
    }

    @FXML
    void clickYes(ActionEvent event) {

    }

    public void cleanInput() {
        inputTitle.setText("");
        inputCategory.setText("");
        inputAuthors.setText("");
        inputPublishYear.setText("");
        inputPublisher.setText("");
    }

    void inputNull() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Required to fill all input field");
        alert.showAndWait();

    }

    void addSuccess() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Item added successfully");
        alert.showAndWait();
    }

    String itemId;

    @FXML
    void clickAddButton(ActionEvent event) throws IOException {

        if (itemHeading.getText().equals("BOOK")) {
            if (inputTitle.getText().equals("") || inputCategory.getText().equals("")
                    || inputAuthors.getText().equals("") || inputPublishYear.getText().equals("")
                    || inputPublisher.getText().equals("")) {
                inputNull();
            } else {
                ArrayList<String> authors = new ArrayList<String>(Arrays.asList(inputAuthors.getText().split(", ")));

                itemId = library.addItem(inputTitle.getText(), inputCategory.getText(), authors,
                        Integer.parseInt(inputPublishYear.getText()), inputPublisher.getText());

                cleanInput();
                addSuccess();
            }

        } else if (itemHeading.getText().equals("PUBLICATION")) {
            if (inputTitle.getText().equals("") || inputCategory.getText().equals("")
                    || inputAuthors.getText().equals("") || inputPublishYear.getText().equals("")
                    || inputPublisher.getText().equals("")) {
                inputNull();
            } else {
                ArrayList<String> authors = new ArrayList<String>(Arrays.asList(inputAuthors.getText().split(", ")));
                itemId = library.addItem(inputTitle.getText(), inputCategory.getText(), authors,
                        Integer.parseInt(inputPublishYear.getText()), inputPublisher.getText());
                cleanInput();
                addSuccess();
            }
        } else if (itemHeading.getText().equals("MOVIE")) {
            if (inputTitle.getText().equals("") || inputCategory.getText().equals("")
                    || inputAuthors.getText().equals("") || inputPublishYear.getText().equals("")) {
                inputNull();
            } else {
                ArrayList<String> authors = new ArrayList<String>(Arrays.asList(inputAuthors.getText().split(", ")));
                itemId = library.addItem(inputTitle.getText(), inputCategory.getText(), authors,
                        Integer.parseInt(inputPublishYear.getText()));
                cleanInput();
                addSuccess();
            }
        }

    }

}
