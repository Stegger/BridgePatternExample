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
    private ComboBox<Style> comboTheme;
    @FXML
    private ComboBox<StyleablePane> comboView;
    @FXML
    private BorderPane root;

    private AnchorPane page;
    private Style style;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        comboView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<StyleablePane>()
        {
            @Override
            public void changed(ObservableValue<? extends StyleablePane> observable, StyleablePane oldValue, StyleablePane newValue)
            {
                page = newValue;
                if (style != null)
                {
                    page.setStyle(style);
                }
                root.setCenter(page);
            }
        });

        try
        {
            comboView.getItems().add(new PageOneController(null));
            comboView.getItems().add(new PageTwoController(null));

        } catch (MalformedURLException ex)
        {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
