import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    String mainTitle = "WESTMINSTER ONLINE SHOPPING";
    String textLabel = "Select Category";
    String[] dropdownList = {"All products" , "Electronics" , "Clothing "};

         GUI(){

            JPanel panel1 = new JPanel();
            panel1.setBounds(0 , 0 , 600 , 350);
            panel1.setBackground(new Color(0x7FC7D9));
            panel1.setLayout(null);

            JPanel panel2 = new JPanel();
            panel2.setBounds(0 , 350 , 600 , 250);
            panel2.setBackground(new Color(0x365486));
            panel2.setLayout(null);


            JLabel textLabel = new JLabel();
            textLabel.setText(this.textLabel);
            textLabel.setBackground(Color.BLACK);
            textLabel.setBounds(100 , 65 , 300 , 10);
            panel1.add(textLabel);

            JButton cartButton = new JButton("Cart");
            cartButton.setBounds(425, 56 , 100, 30);
            cartButton.setBackground(Color.WHITE);
            panel1.add(cartButton);

            cartButton.addActionListener(e -> {
                this.dispose();
                new GUIShopping();
            });

            JButton addToCartButton = new JButton("Add to cart");
            addToCartButton.setBounds(220 , 500, 100 , 30);
            addToCartButton.setBackground(Color.WHITE);
            panel2.add(addToCartButton);

            JComboBox<String> dropdown = new JComboBox<>(dropdownList);
            dropdown.setBackground(Color.WHITE);
            dropdown.setBounds(220 , 22 , 200 , 100);
            panel1.add(dropdown);

            setTitle(mainTitle);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            setSize(600 , 600 );
            setVisible(true); // Controls the visibility of the frame
            getContentPane().setBackground(new Color(0x176B87));

            add(panel1);
            add(panel2);
        }

}
