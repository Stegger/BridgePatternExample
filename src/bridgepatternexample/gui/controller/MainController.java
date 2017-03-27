/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgepatternexample.gui.controller;

import bridgepatternexample.gui.model.bridgeView.Style;
import bridgepatternexample.gui.model.bridgeView.StyleablePane;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author pgn
 */
public class MainController implements Initializable
{

    @FXML
    private ComboBox<String> comboTheme;
    @FXML
    private ComboBox<String> comboView;
    @FXML
    private BorderPane root;

    private StyleablePane page;
    private Style style;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        setComboboxes();
        setupListners();
    }

    private void setComboboxes()
    {
        comboTheme.getItems().add("Style one");
        comboTheme.getItems().add("Style two");
        comboView.getItems().add("Page one");
        comboView.getItems().add("Page two");
    }

    private void setupListners()
    {
        comboTheme.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
        {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
            {
                if (comboView.getSelectionModel().getSelectedItem() != null && !comboView.getSelectionModel().getSelectedItem().isEmpty())
                {
                    try
                    {
                        updatePage(comboView.getSelectionModel().getSelectedItem(), newValue);
                    } catch (MalformedURLException ex)
                    {
                        //TODO Handle exception
                    }
                }
            }
        });
        comboView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
        {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
            {
                if (comboTheme.getSelectionModel().getSelectedItem() != null && !comboTheme.getSelectionModel().getSelectedItem().isEmpty())
                {
                    try
                    {
                        updatePage(newValue, comboTheme.getSelectionModel().getSelectedItem());
                    } catch (MalformedURLException ex)
                    {
                        //TODO Handle exception
                    }
                }
            }
        });
    }

    private void updatePage(String page, String style) throws MalformedURLException
    {
        Style styleTheme = Style.getStyle(style);

        switch (page)
        {
            case "Page one":
                this.page = new PageOneController(styleTheme);
                root.setCenter(this.page);
                break;
            case "Page two":
                this.page = new PageTwoController(styleTheme);
                root.setCenter(this.page);
                break;
        }

    }

}
