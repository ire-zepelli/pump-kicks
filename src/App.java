import javax.swing.*;
import pages.*;

public class App {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new PageControl();   
            }
        });
    }
}
