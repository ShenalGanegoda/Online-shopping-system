import javax.swing.*;
import java.awt.*;

public class GUIShopping extends JFrame {
    String backButton = "Back";
    String shoppingTitle = "Shopping Cart";
    GUIShopping(){
        JPanel shoppingPanel = new JPanel();
        shoppingPanel.setBounds( 50 , 0 , 100 , 50);
        shoppingPanel.setBackground(new Color(0xFBF9F1));

        JButton backButtonShopping = new JButton(backButton);
        backButtonShopping.setBackground(Color.WHITE);
        backButtonShopping.setBounds(0 , 0 , 30 , 10);
        add(backButtonShopping);

        backButtonShopping.addActionListener(e -> {
            this.dispose();
            new GUI();
        });

        setTitle(shoppingTitle);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600 , 600 );
        setVisible(true); // Controls the visibility of the frame
        getContentPane().setBackground(new Color(0xAAD7D9));

        add(shoppingPanel);
        shoppingPanel.add(backButtonShopping);

    }

}
