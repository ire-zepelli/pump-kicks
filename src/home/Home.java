package home;

import javax.swing.*;
import java.awt.*;
import create_component.*;

public class Home {
   private JPanel mainPanel, headerPanel, logoImage, contentPanel, shoesBanner, bannerText, navMarker;
   private JButton homeButton, productsButton, cartButton;
   private JLabel navText;
   private JScrollPane scrollPane;
   
   public Home(){
    initialize();
   }

   private void initialize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int) screenSize.getHeight();
        int width = (int) screenSize.getWidth();

        mainPanel = new JPanel();
        mainPanel.setLayout(null);

        navText = Create_Component.Label(50, 0, 100, 30, "Home", "Comic Sans", Font.BOLD, 20, 249,249, 237, 161, 52, 246);

        contentPanel = new JPanel();
        contentPanel.setPreferredSize(new Dimension(width-20, height));
        contentPanel.setBackground(new Color(246,246,237));
        contentPanel.setLayout(null);

        scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBounds(0,120, width+2, height-120);;
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        shoesBanner = Create_Component.ImagePanel("public/shoes-banner.png", 0,50,width-16, 450);
        bannerText = Create_Component.ImagePanel("public/banner-text.png", 20, 80, 427, 369);

        contentPanel.add(navText);
        contentPanel.add(bannerText);
        contentPanel.add(shoesBanner);

        mainPanel.setBackground(new Color(246, 246, 237));

        headerPanel = Header(width);

        mainPanel.add(headerPanel);
        mainPanel.add(scrollPane);
   }

   public JPanel getPanel(){
    return mainPanel;
   }

   public JPanel Header(int w){
    JPanel header = new JPanel();

    header.setLayout(null);
    header.setBounds(0,0, w, 120);
    header.setBackground(new Color(246,246,237));

    logoImage = Create_Component.ImagePanel("public/Pumped.png", 50, 0, 250, 120);

    homeButton = Create_Component.Button(350,45,100,30,"HOME", "Comic Sans", Font.BOLD, 20, 255,255,255, 161,52,246);
    productsButton = Create_Component.Button(500,45,150,30,"PRODUCTS", "Comic Sans", Font.BOLD, 20, 255,255,255, 161,52,246);
    cartButton = Create_Component.Button(700,45,150,30,"MY CART", "Comic Sans", Font.BOLD, 20, 255,255,255, 161,52,246);

    homeButton.setOpaque(false);
    homeButton.setFocusPainted(false);
    productsButton.setOpaque(false);
    productsButton.setFocusPainted(false);
    cartButton.setOpaque(false);
    cartButton.setFocusPainted(false);

    //235 192 0
    navMarker = Create_Component.Panel(350,75, 100, 5, 235, 192, 0, 255, 235, 192, 0, 255, 0);

    header.add(logoImage);
    header.add(homeButton);
    header.add(productsButton);
    header.add(cartButton);
    header.add(navMarker);
    return header;
   }
}
