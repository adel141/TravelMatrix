package Classes.UserOperations;

import Classes.UI.Dashboards.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UserPayment extends JFrame implements ActionListener {
    
    JLabel titleLabel, acceptedLabel, nameOnCardLabel, cardNumberLabel, validLabel, cvvLabel;
    JTextField nameField, cardField, validField, cvvField;
	String user;
    JButton confirmButton, exitButton, backButton;
    
    public UserPayment(String user, String amount) {
        this.user = user;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        
        // Title label
        titleLabel = new JLabel("Complete Your payment Total Amount: " + amount);
        titleLabel.setBounds(110, 40, 1000, 50);
        titleLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 22));
        this.add(titleLabel);
        
        // Accepted Payment Methods
        acceptedLabel = new JLabel("We Accept Only");
        acceptedLabel.setBounds(130, 100, 200, 50);
        acceptedLabel.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));
        this.add(acceptedLabel);
        
        // MasterCard Image
        JLabel masterCardLabel = new JLabel();
        masterCardLabel.setIcon(new ImageIcon(getClass().getResource("/Image/MasterCard.png")));
        masterCardLabel.setBounds(280, 100, 100, 50);
        this.add(masterCardLabel);
        
        // VisaCard Image
        JLabel visaCardLabel = new JLabel();
        visaCardLabel.setIcon(new ImageIcon(getClass().getResource("/Image/VisaCard.png")));
        visaCardLabel.setBounds(360, 100, 100, 50);
        this.add(visaCardLabel);
        
        // Card details section
        titleLabel = new JLabel("Card Details");
        titleLabel.setBounds(130, 150, 200, 50);
        titleLabel.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));
        this.add(titleLabel);
        
        // Name on Card
        nameOnCardLabel = new JLabel("Name On Card:");
        nameOnCardLabel.setBounds(140, 190, 200, 50);
        nameOnCardLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(nameOnCardLabel);
        
        nameField = new JTextField();
        nameField.setBounds(275, 200, 300, 30);
        nameField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(nameField);
        
        // Card Number
        cardNumberLabel = new JLabel("Card Number:");
        cardNumberLabel.setBounds(140, 230, 200, 50);
        cardNumberLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(cardNumberLabel);
        
        cardField = new JTextField();
        cardField.setBounds(275, 240, 300, 30);
        cardField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(cardField);
        
        // Valid On
        validLabel = new JLabel("Valid On:");
        validLabel.setBounds(140, 270, 120, 50);
        validLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(validLabel);
        
        validField = new JTextField();
        validField.setBounds(230, 280, 120, 30);
        validField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(validField);
        
        // CVV Code
        cvvLabel = new JLabel("CVV Code:");
        cvvLabel.setBounds(365, 270, 120, 50);
        cvvLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(cvvLabel);
        
        cvvField = new JTextField();
        cvvField.setBounds(460, 280, 120, 30);
        cvvField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(cvvField);
        
        // Confirm Button
        confirmButton = new JButton("Confirm payment");
        confirmButton.setBounds(330, 330, 250, 50);
        confirmButton.setFocusable(false);
        confirmButton.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 25));
        confirmButton.setForeground(Color.white);
        confirmButton.setBackground(Color.decode("#2E75B6"));
        this.add(confirmButton);
        
        // Exit Button
        exitButton = new JButton("EXIT");
        exitButton.setBounds(140, 330, 140, 50);
        exitButton.setFocusable(false);
        exitButton.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 25));
        exitButton.setForeground(Color.white);
        exitButton.setBackground(Color.decode("#C00000"));
        this.add(exitButton);
        
        // Back Button
        backButton = new JButton();
        backButton.setBounds(30, 30, 50, 50);
        backButton.setOpaque(false);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setIcon(new ImageIcon(new ImageIcon("image/BackThemeWhite.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        backButton.addActionListener(this);
        this.add(backButton);
        
        this.setVisible(true);
        
        // Add action listeners
        confirmButton.addActionListener(this);
        exitButton.addActionListener(this);
        backButton.addActionListener(e -> {
            if (e.getSource() == backButton) {
                this.dispose();
                new UserDashboard(user);
            }
        });
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        

        
        if (e.getSource() == exitButton) {
            System.exit(0);
        }
        
        
        if (e.getSource() == confirmButton) {
            String name = nameField.getText();
            String card = cardField.getText();
            String valid = validField.getText();
            String cvv = cvvField.getText();
            
            if (name.isEmpty() || card.isEmpty() || valid.isEmpty() || cvv.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            } else {
				JOptionPane.showMessageDialog(null, "Payment SuccessFUll");
                this.dispose();
                new  UserDashboard(user);
            }
        }
    }
}
