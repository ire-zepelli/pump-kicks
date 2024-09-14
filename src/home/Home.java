package home;

import javax.swing.*;
import java.awt.*;
import create_component.*;

public class Home {
   private JPanel mainPanel, headerPanel, logoImage, contentPanel, shoesBanner, bannerText, navMarker, featured1, featured2, featured3, cartIcon1, cartIcon2, cartIcon3;
   private JButton homeButton, productsButton, cartButton;
   private JLabel navText, copyrightText;
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
        copyrightText = Create_Component.Label(width/2-350/2,height+250, 350, 30, "Copyright © 2024 - Benedict Avenido", "Comic Sans", Font.ITALIC, 20, 249,249, 237, 161, 52, 246);

        contentPanel = new JPanel();
        contentPanel.setPreferredSize(new Dimension(width-20, height+300));
        contentPanel.setBackground(new Color(246,246,237));
        contentPanel.setLayout(null);

        scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBounds(0,120, width+2, height-120);;
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        shoesBanner = Create_Component.ImagePanel("public/shoes-banner.png", 0,50,width, 450);
        bannerText = Create_Component.ImagePanel("public/banner-text.png", 20, 80, 427, 369);
        featured1 = Create_Component.ImagePanel("public/featured-shoes-1.jpg", 200,600, 300,400);
        featured2 = Create_Component.ImagePanel("public/featured-shoes-2.jpg", 600, 600, 300,400);
        featured3 = Create_Component.ImagePanel("public/featured-shoes-3.jpg", 1000, 600, 300,400);
        cartIcon1 = Create_Component.ImagePanel("public/icons/cart-icon.png", 445,605,50,50);
        cartIcon2 = Create_Component.ImagePanel("public/icons/cart-icon.png", 845,605,50,50);
        cartIcon3 = Create_Component.ImagePanel("public/icons/cart-icon.png", 1245,605,50,50);

        contentPanel.add(navText);
        contentPanel.add(bannerText);
        contentPanel.add(shoesBanner);
        contentPanel.add(cartIcon1);
        contentPanel.add(featured1);
        contentPanel.add(cartIcon2);
        contentPanel.add(featured2);
        contentPanel.add(cartIcon3);
        contentPanel.add(featured3);
        contentPanel.add(copyrightText);

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
    productsButton = Create_Component.Button(480,45,150,30,"PRODUCTS", "Comic Sans", Font.BOLD, 20, 255,255,255, 161,52,246);
    cartButton = Create_Component.Button(630,45,150,30,"MY CART", "Comic Sans", Font.BOLD, 20, 255,255,255, 161,52,246);

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
