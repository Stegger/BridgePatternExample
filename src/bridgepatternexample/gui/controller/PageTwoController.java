/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgepatternexample.gui.controller;

import bridgepatternexample.gui.model.bridgeView.Style;
import bridgepatternexample.gui.model.bridgeView.StyleablePane;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author pgn
 */
public class PageTwoController extends StyleablePane implements Initializable
{

    public PageTwoController(Style style) throws MalformedURLException
    {
        super(new File("src/bridgepatternexample/gui/view/pages/PageTwo.fxml").toURI().toURL(), style);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

    @Override
    public String toString()
    {
        return "Page two";
    }

    
    
}
