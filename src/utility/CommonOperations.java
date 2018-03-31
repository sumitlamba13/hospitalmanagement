package utility;

import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class CommonOperations {
    public static void openInternalFrame(JDesktopPane deskpane,JInternalFrame jif){
    jif.setVisible(true);
        deskpane.add(jif);
        try{
            jif.setSelected(true);
        }catch(PropertyVetoException ex){
        }
    } 
}
