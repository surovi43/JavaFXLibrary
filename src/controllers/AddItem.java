package controllers;

import java.util.ArrayList;
import java.util.Arrays;

import application.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class AddItem {
    String form = "BOOK";

    @FXML
    private Button book, publication, movie;

    @FXML
    private VBox bookBox, publicationBox, movieBox;

    @FXML
    private ToggleGroup isJournal;

    @FXML
    private TextField itemTitle, itemCategory,
            bookAuthors, bookPublishYear, bookPublisher,
            pubAuthors, pubPublishYear, pubPublisher,
            movieDirectors, movieReleaseYear;

    @FXML
    void clickAddButton(ActionEvent event) {
        String title = itemTitle.getText();
        String category = itemCategory.getText();
        switch (form) {
            case "BOOK":
                addBook(title, category);
                break;
            case "PUBLICATION":
                addPublication(title, category);
                break;
            case "MOVIE":
                addMovie(title, category);
                break;
        }
        resetForm();
    }

    @FXML
    void switchForm(ActionEvent event) {
        form = ((Button) event.getSource()).getText();

        switch (form) {
            case "BOOK":
                book.getStyleClass().add("active");
                publication.getStyleClass().removeAll("active");
                movie.getStyleClass().removeAll("active");
                bookBox.setVisible(true);
                publicationBox.setVisible(false);
                movieBox.setVisible(false);
                break;

            case "PUBLICATION":
                book.getStyleClass().removeAll("active");
                publication.getStyleClass().add("active");
                movie.getStyleClass().removeAll("active");
                bookBox.setVisible(false);
                publicationBox.setVisible(true);
                movieBox.setVisible(false);
                break;

            case "MOVIE":
                book.getStyleClass().removeAll("active");
                publication.getStyleClass().removeAll("active");
                movie.getStyleClass().add("active");
                bookBox.setVisible(false);
                publicationBox.setVisible(false);
                movieBox.setVisible(true);
                break;
        }
    }

    private void resetForm() {
        itemTitle.clear();
        itemCategory.clear();
        bookAuthors.clear();
        bookPublishYear.clear();
        bookPublisher.clear();
        pubAuthors.clear();
        pubPublishYear.clear();
        pubPublisher.clear();
        movieDirectors.clear();
        movieReleaseYear.clear();
    }

    private void addBook(String title, String category) {
        ArrayList<String> authors = new ArrayList<>(Arrays.asList(bookAuthors.getText().split(", ")));
        String year = bookPublishYear.getText();
        int publishYear = year.matches("\\d{4}") ? Integer.parseInt(year) : 2000;
        String publisherName = bookPublisher.getText();
        Store.library.addItem(title, category, authors, publishYear, publisherName);
    }

    private void addPublication(String title, String category) {
        ArrayList<String> authors = new ArrayList<>(Arrays.asList(pubAuthors.getText().split(", ")));
        String year = pubPublishYear.getText();
        int publishYear = year.matches("\\d{4}") ? Integer.parseInt(year) : 2000;
        String publisherName = pubPublisher.getText();
        boolean isJournalPaper = isJournal.getSelectedToggle().toString().contains("YES");
        Store.library.addItem(title, category, authors, publishYear, isJournalPaper, publisherName);
    }

    private void addMovie(String title, String category) {
        ArrayList<String> directors = new ArrayList<>(Arrays.asList(movieDirectors.getText().split(", ")));
        String year = movieReleaseYear.getText();
        int releaseYear = year.matches("\\d{4}") ? Integer.parseInt(year) : 2000;
        Store.library.addItem(title, category, directors, releaseYear);
    }
}
