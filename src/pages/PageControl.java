package pages;

import javax.swing.*;
import java.awt.*;
import auth.*;

public class PageControl {
    JFrame frame = new JFrame();
    static JPanel panelCont = new JPanel();
    static CardLayout pages = new CardLayout();
    Login login = new Login();
    static Signup signup;


    public PageControl(){
        initialize();
    }


    public void initialize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int defaultWidth = (int ) screenSize.getWidth();
        int defaultHeight = (int) screenSize.getHeight();

        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(new Dimension(defaultWidth, defaultHeight));
        frame.getContentPane().setBackground(new Color(20, 23, 29));
        
        panelCont.setLayout(pages);
        panelCont.add(login.getPanel(), "login");
        
        frame.add(panelCont);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

        showSignUp();
    }
    
    public static void showLogIn(){
        pages.show(panelCont, "login");
    }

    public static void showSignUp(){
        signup = new Signup();
        panelCont.add(signup.getPanel(), "signup");
        pages.show(panelCont, "signup");
    }
}