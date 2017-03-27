/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgepatternexample.gui.model.bridgeView;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author pgn
 */
public abstract class StyleablePane extends AnchorPane
{

    private Style style;

    public StyleablePane(URL page, Style style)
    {
        FXMLLoader fxmlLoader = new FXMLLoader(page);
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        
        try
        {
            fxmlLoader.load();

        } catch (IOException exception)
        {
            throw new RuntimeException(exception);
        }
    }

}
