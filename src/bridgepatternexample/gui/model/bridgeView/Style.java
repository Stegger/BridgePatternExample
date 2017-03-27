/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgepatternexample.gui.model.bridgeView;

/**
 *
 * @author pgn
 */
public interface Style
{

    public static Style getStyle(String style)
    {
        if (style.equals("Style one"))
        {
            return new Style()
            {

                @Override
                public String getStylesheet()
                {
                    return "bridgepatternexample/gui/style/StyleOne.css";
                }
            };
        }
        else
        {
            return new Style()
            {

                @Override
                public String getStylesheet()
                {
                    return "bridgepatternexample/gui/style/StyleTwo.css";
                }
            };
        }
    }

    public String getStylesheet();
}
