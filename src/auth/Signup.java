package auth;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import create_component.*;
import database.dbActions;
import pages.*;

public class Signup {
    private JPanel mainPanel, authForm, logoImage, profileIcon, inputMarker_1, passwordIcon, inputMarker_2, inputMarker_3, confirmPasswordIcon;
    private JLabel signUpText, usernameText, passwordText, confirmPasswordText, logInText;
    private JButton signUpButton, logInButton;
    private JTextField userField;
    private JPasswordField passwordField, confirmPasswordField;

    public Signup(){
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
        confirmPasswordIcon = Create_Component.ImagePanel("public/icons/password-icon.png", 60,360,25, 30);

        inputMarker_1 = Create_Component.Panel(50, 225, 400,2, 120, 67, 230, 255, 120, 67, 230, 255, 0);
        inputMarker_2 = Create_Component.Panel(50, 310  , 400,2, 120, 67, 230, 255, 120, 67, 230, 255, 0);
        inputMarker_3 = Create_Component.Panel(50, 395 , 400,2, 120, 67, 230, 255, 120, 67, 230, 255, 0);

        userField = Create_Component.TextField(90,190,360,30,162,54,246,"Comic Sans", Font.BOLD, 20, 255,255,255);
        passwordField = Create_Component.PasswordField(90,275,360,30,162,54,246,"Comic Sans", Font.BOLD, 20, 255,255,255);
        confirmPasswordField = Create_Component.PasswordField(90,360,360,30,162,54,246,"Comic Sans", Font.BOLD, 20, 255,255,255);
        userField.setBorder(new EmptyBorder(new Insets(0, 0, 0, 0)));
        userField.setCaretColor(new Color(162,54,246));
        passwordField.setBorder(new EmptyBorder(new Insets(0, 0, 0, 0)));
        passwordField.setCaretColor(new Color(162,54,246));
        confirmPasswordField.setBorder(new EmptyBorder(new Insets(0, 0, 0, 0)));
        confirmPasswordField.setCaretColor(new Color(162,54,246));

        signUpButton = Create_Component.Button(150,470,200,70,"","",0,0,0,0,0,0,0,0);
        signUpButton.setOpaque(false);
        signUpButton.setFocusPainted(false);
        signUpButton.setFocusable(false);
        signUpButton.setContentAreaFilled(false);
        
        logInButton = Create_Component.Button(300,600,60,20,"", "", 0,0,0,0,0,0,0,0);
        logInButton.setOpaque(false);
        logInButton.setFocusPainted(false);
        logInButton.setFocusable(false);
        logInButton.setContentAreaFilled(false);
        
        signUpText = Create_Component.Label(225, 70, 100, 100, "Sign Up", "Comic Sans", Font.BOLD, 20, 255, 255, 255, 162, 54,246 );
        usernameText = Create_Component.Label(50, 125, 100, 100, "Username", "Comic Sans", Font.BOLD, 20, 255, 255, 255, 162, 54,246 );
        passwordText = Create_Component.Label(50, 210, 100, 100, "Password", "Comic Sans", Font.BOLD, 20, 255, 255, 255, 162, 54,246 );
        confirmPasswordText = Create_Component.Label(50, 295, 200, 100, "Confirm Password", "Comic Sans", Font.BOLD, 20, 255, 255, 255, 162, 54,246 );
        logInText = Create_Component.Label(140,555,300,100,"<html><p style=\"color:#511B7B;\">Already have an account? <span style=\"color:#a236f6;\">Log In</span></p></html>", "Comic Sans", Font.PLAIN, 15, 255, 255, 255, 0, 0, 0);
        
        mainPanel.setPreferredSize(new Dimension(defaultWidth, defaultHeight));
        mainPanel.setBackground(new Color(120,67,230));
        mainPanel.setLayout(null);

        authForm = Create_Component.Panel(525,100,500,660,255,255,255,255,255,255,255,255,0);
        authForm.setLayout(null);

        authForm.add(logoImage);
        authForm.add(signUpText);
        authForm.add(usernameText);
        authForm.add(profileIcon);
        authForm.add(userField);
        authForm.add(inputMarker_1);
        authForm.add(passwordText);
        authForm.add(passwordIcon);
        authForm.add(passwordField);
        authForm.add(inputMarker_2);
        authForm.add(confirmPasswordIcon);
        authForm.add(confirmPasswordText);
        authForm.add(confirmPasswordField);
        authForm.add(inputMarker_3);
        authForm.add(signUpButton);
        authForm.add(signUpButton());
        authForm.add(logInText);
        authForm.add(logInButton);
        
        mainPanel.add(authForm);

        buttonAction(signUpButton, "signup");
        buttonAction(logInButton, "login");
    }

    private void buttonAction(JButton button, String dispatch){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (dispatch) {
                    case "login":
                    PageControl.showLogIn();
                    break;
                    case "signup":
                    String enteredUsername = userField.getText();
                    String enteredPassword = new String(passwordField.getPassword());
                    String enteredConfirmPassword = new String(confirmPasswordField.getPassword());
                    
                    if(!enteredPassword.equals(enteredConfirmPassword)){
                        passwordText.setForeground(Color.red);
                        confirmPasswordText.setForeground(Color.red);

                        Timer timer = new Timer(500, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                passwordText.setForeground(new Color(162,52,246));
                                confirmPasswordText.setForeground(new Color(162,52,246));
                                passwordField.setText("");
                                confirmPasswordField.setText("");
                            }
                        });
                        timer.setRepeats(false);
                        timer.start();
                        return;
                    }

                        try {
                            dbActions.addUser(enteredUsername, enteredPassword);
                            PageControl.showLogIn();
                        } catch (ClassNotFoundException | SQLException e1) {
                            System.out.println("Failed to Add User.");
                        }
                        break;
                    default:
                        break;
                }
            }
        });
    }
    
    private JPanel signUpButton(){
        JPanel signUp = new JPanel();
        signUp.setBounds(150,470,200,80);
        signUp.setBackground(new Color(255,255,255));
        signUp.setLayout(null);
        JPanel outline = Create_Component.Panel(0,0,200,60,255,255,255,255,255,255,255,255,60);
        JPanel profileIcon = Create_Component.ImagePanel("public/icons/profile-icon.png", 10, 8, 20,25);
        JPanel iconContainer = Create_Component.Panel(145,4,40,40,255,255,255,255,255,255,255,255,100);
        JPanel content = Create_Component.Panel(5,5,190,50,120,67,230,255,120,67,230,255,60);
        JPanel shadow = Create_Component.Panel(0,5,200,60,120,67,230,255,120,67,230,255,60);
        JLabel loginText = Create_Component.Label(50, 0, 100, 50, "Sign Up", "Comic Sans", Font.BOLD, 20, 120, 67, 230, 255, 255, 255);
        outline.setLayout(null);

        iconContainer.add(profileIcon);
        content.add(iconContainer);
        content.add(loginText);
        outline.add(content);
        signUp.add(outline);
        signUp.add(shadow);

        return signUp;
    }

   public JPanel getPanel(){
    return mainPanel;
   } 
}
