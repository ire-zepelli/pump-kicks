package auth;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import create_component.*;
import database.dbActions;
import pages.PageControl;

public class Login {
    private JPanel mainPanel, authForm, logoImage, profileIcon, inputMarker_1, passwordIcon, inputMarker_2, googleIcon, facebookIcon, discordIcon;
    private JLabel loginText, usernameText, passwordText, loginWithText, signupText;
    private JButton loginBtn, signupButton;
    private JTextField userField;
    private JPasswordField passwordField;

    public Login(){
        initialize();
    }

    private void initialize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int defaultHeight = (int) screenSize.getHeight();
        int defaultWidth = (int) screenSize.getWidth();
        
        mainPanel = new JPanel();
        authForm = new JPanel();

        logoImage = Create_Component.ImagePanel("public/Pumped.png", 130, -10, 250, 120);
        profileIcon = Create_Component.ImagePanel("public/icons/profile-icon.png", 60,190,25, 30);
        passwordIcon = Create_Component.ImagePanel("public/icons/password-icon.png", 60,275,25, 30);

        inputMarker_1 = Create_Component.Panel(50, 225, 400,2, 120, 67, 230, 255, 120, 67, 230, 255, 0);
        inputMarker_2 = Create_Component.Panel(50, 310  , 400,2, 120, 67, 230, 255, 120, 67, 230, 255, 0);

        userField = Create_Component.TextField(90,190,360,30,162,54,246,"Comic Sans", Font.BOLD, 20, 255,255,255);
        passwordField = Create_Component.PasswordField(90,275,360,30,162,54,246,"Comic Sans", Font.BOLD, 20, 255,255,255);
        userField.setBorder(new EmptyBorder(new Insets(0, 0, 0, 0)));
        userField.setCaretColor(new Color(162,54,246));
        passwordField.setBorder(new EmptyBorder(new Insets(0, 0, 0, 0)));
        passwordField.setCaretColor(new Color(162,54,246));

        loginBtn = Create_Component.Button(150,350,200,70,"","",0,0,0,0,0,0,0,0);
        loginBtn.setOpaque(false);
        loginBtn.setFocusPainted(false);
        loginBtn.setFocusable(false);
        loginBtn.setContentAreaFilled(false);
        buttonAction(loginBtn, "login");

        signupButton = Create_Component.Button(300,600,60,20,"", "", 0,0,0,0,0,0,0,0);
        signupButton.setOpaque(false);
        signupButton.setFocusPainted(false);
        signupButton.setFocusable(false);
        signupButton.setContentAreaFilled(false);
        buttonAction(signupButton, "register");

        loginText = Create_Component.Label(225, 70, 100, 100, "Login", "Comic Sans", Font.BOLD, 20, 255, 255, 255, 162, 54,246 );
        loginWithText = Create_Component.Label(200, 370, 300, 200, "<html><p style=\"text-align:center\">Or<br/>Login with</p></html>", "Comic Sans", Font.BOLD, 20, 255, 255, 255, 162, 54,246 );
        usernameText = Create_Component.Label(50, 125, 100, 100, "Username", "Comic Sans", Font.BOLD, 20, 255, 255, 255, 162, 54,246 );
        passwordText = Create_Component.Label(50, 210, 100, 100, "Password", "Comic Sans", Font.BOLD, 20, 255, 255, 255, 162, 54,246 );
        signupText = Create_Component.Label(140,555,300,100,"<html><p style=\"color:#511B7B;\">Don't have an account? <span style=\"color:#a236f6;\">Sign Up</span></p></html>", "Comic Sans", Font.PLAIN, 15, 255, 255, 255, 0, 0, 0);

        mainPanel.setPreferredSize(new Dimension(defaultWidth, defaultHeight));
        mainPanel.setBackground(new Color(120,67,230));
        mainPanel.setLayout(null);

        authForm = Create_Component.Panel(525,100,500,660,255,255,255,255,255,255,255,255,0);
        authForm.setLayout(null);

        facebookIcon = Create_Component.ImagePanel("public/icons/facebook-icon.png",100,520,50,50);
        googleIcon = Create_Component.ImagePanel("public/icons/google-icon.png",225,520,50,50);
        discordIcon = Create_Component.ImagePanel("public/icons/discord-icon.png",340,520,50,50);

        authForm.add(logoImage);
        authForm.add(loginText);
        authForm.add(usernameText);
        authForm.add(profileIcon);
        authForm.add(userField);
        authForm.add(inputMarker_1);
        authForm.add(passwordText);
        authForm.add(passwordIcon);
        authForm.add(passwordField);
        authForm.add(inputMarker_2);
        authForm.add(loginBtn);
        authForm.add(loginButton());
        authForm.add(loginWithText);
        authForm.add(facebookIcon);
        authForm.add(googleIcon);
        authForm.add(discordIcon);
        authForm.add(signupText);
        authForm.add(signupButton);

        mainPanel.add(authForm);
    }

    private void buttonAction(JButton button, String dispatch){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (dispatch) {
                    case "login":
                        String enteredUsername = userField.getText();
                        String enteredPassword = new String(passwordField.getPassword());
                        
                        if(enteredUsername.isBlank() || enteredPassword.isBlank()){
                            System.out.println("Fields are empty.");
                            return;
                        }
                        
                        try {
                            System.out.println(dbActions.checkAuth(enteredUsername, enteredPassword));
                        } catch (ClassNotFoundException | SQLException e1) {
                            System.out.println("Failed To Authenticate User.");
                        }   
                        break;

                    case "register":
                        //redirect to register
                        System.out.println("inside here");
                        PageControl.showSignUp();
                        break;

                    default:
                        break;
                }
            }
        });
    }
    
    private JPanel loginButton(){
        JPanel loginPanel = new JPanel();
        loginPanel.setBounds(150,350,200,80);
        loginPanel.setBackground(new Color(255,255,255));
        loginPanel.setLayout(null);
        JPanel outline = Create_Component.Panel(0,0,200,60,255,255,255,255,255,255,255,255,60);
        JPanel profileIcon = Create_Component.ImagePanel("public/icons/profile-icon.png", 10, 8, 20,25);
        JPanel iconContainer = Create_Component.Panel(145,4,40,40,255,255,255,255,255,255,255,255,100);
        JPanel content = Create_Component.Panel(5,5,190,50,120,67,230,255,120,67,230,255,60);
        JPanel shadow = Create_Component.Panel(0,5,200,60,120,67,230,255,120,67,230,255,60);
        JLabel loginText = Create_Component.Label(50, 0, 100, 50, "LOGIN", "Comic Sans", Font.BOLD, 20, 120, 67, 230, 255, 255, 255);
        outline.setLayout(null);

        iconContainer.add(profileIcon);
        content.add(iconContainer);
        content.add(loginText);
        outline.add(content);
        loginPanel.add(outline);
        loginPanel.add(shadow);

        return loginPanel;
    }

   public JPanel getPanel(){
    return mainPanel;
   } 
}
