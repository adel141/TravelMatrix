package Classes.UI.Dashboards;

import Classes.UI.Login;
import Classes.UserOperations.EditUserdata;
import Classes.UserOperations.UserPayment;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;

public class UserDashboard implements  ActionListener {
    
    
    private JFrame userDashF;
    private JPanel scrollablePanel;
    private JLabel userDashL;
    private Image iconFrame;
    private JButton backB,editB;
    final private  String user;
    



    public UserDashboard(String userName)
    {
        user = userName;
        iconFrame = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/TravelMatrixApp.png"));
        userDashF = new JFrame();

        userDashL = new JLabel();
        userDashL.setIcon(new ImageIcon(new ImageIcon("image/userdash.png").getImage().getScaledInstance(1260, 700, Image.SCALE_SMOOTH)));
        userDashL.setBounds(0, 0, 1260, 700);
        
        scrollablePanel = new JPanel();
        scrollablePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JScrollPane scrollPane = new JScrollPane(scrollablePanel);
        scrollPane.setBounds(110, 145, 1035, 440);
        
        
        loadPackages(scrollablePanel);
        
        backB = new JButton();
        backB.setBounds(30,30,50,50);
        backB.setIcon(new ImageIcon(new ImageIcon("image/Logout.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        backB.setOpaque(false);
        backB.setBorderPainted(false);
        backB.setContentAreaFilled(false); 
        backB.setCursor(new Cursor(Cursor.HAND_CURSOR));

        editB = new JButton();
        editB.setBounds(1190,30,50,50);
        editB.setIcon(new ImageIcon(new ImageIcon("image/useredit.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        editB.setOpaque(false);
        editB.setBorderPainted(false);
        editB.setContentAreaFilled(false); 
        editB.setCursor(new Cursor(Cursor.HAND_CURSOR));

       
        backB.addActionListener(this);
        editB.addActionListener(this);

        userDashF.add(backB);
        userDashF.add(scrollPane);
        userDashF.add(editB); 
        userDashF.add(userDashL);



        userDashF.setLayout(null);
        userDashF.setTitle("Travel Matrix | UserDashboard");
        userDashF.setSize(1270, 735);
        userDashF.setIconImage(iconFrame);
        userDashF.setVisible(true);
        userDashF.setResizable(false);
        userDashF.setLocationRelativeTo(null);
        userDashF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==backB)
        {
            new Login();
            userDashF.dispose();
        }
        else if(e.getSource() == editB)
        {
            new EditUserdata(user);
        }

    }

    private void loadPackages(JPanel scrollablePanel) 
    {
        String filename = "./Data/packagedata.txt"; // Ensure this is the correct path
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 7) continue; // Skip lines with insufficient data

                String packageName = data[1].trim();
                String imagePath = data[2].trim();
                String packageDetails = data[3].trim();
                String transportation = data[4].trim();
                String hotels = data[5].trim();
                String price = data[6].trim();

                JPanel packagePanel = createPackagePanel(packageName, imagePath, packageDetails, transportation, hotels,price);
                scrollablePanel.add(packagePanel);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

    }


    private JPanel createPackagePanel(String packageName, String imagePath, String details, String transportation, String hotels, String price) 
    {
        JPanel packagePanel = new JPanel();
        packagePanel.setLayout(null);
        packagePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        packagePanel.setBackground(Color.LIGHT_GRAY);
        packagePanel.setPreferredSize(new Dimension(400, 412)); // Fixed size for each package panel

        ImageIcon icon = new ImageIcon(imagePath);
        Image scaledImage = icon.getImage().getScaledInstance(390, 200, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBounds(10, 10, 380, 200);
        packagePanel.add(imageLabel);

        JLabel nameLabel = new JLabel(packageName);
        nameLabel.setBounds(20, 210, 400, 40);
        nameLabel.setFont(new Font("Poppins",Font.BOLD,25));
        packagePanel.add(nameLabel);


        JLabel detailsLabel = new JLabel();
        detailsLabel.setText("Details: " + details);
        detailsLabel.setBounds(10, 250, 380, 60); 
        detailsLabel.setFont(new Font("Poppins",Font.PLAIN,15));
        detailsLabel.setForeground(Color.BLACK);
        detailsLabel.setToolTipText("Details: " + details);
        detailsLabel.setOpaque(false); 
        packagePanel.add(detailsLabel); 

        JLabel transportationLabel = new JLabel("Transport: " + transportation);
        transportationLabel.setBounds(10, 295, 380, 30);
        transportationLabel.setForeground(Color.BLACK);
        transportationLabel.setFont(new Font("Poppins",Font.PLAIN,15));
        packagePanel.add(transportationLabel);

        JLabel hotelsLabel = new JLabel("Hotels: " + hotels);
        hotelsLabel.setBounds(10, 320, 380, 30);
        hotelsLabel.setFont(new Font("Poppins",Font.PLAIN,15));
        hotelsLabel.setForeground(Color.BLACK);
        packagePanel.add(hotelsLabel);

        JLabel priceLabel = new JLabel("Price: " + price);
        priceLabel.setBounds(10, 350, 380, 30);
        priceLabel.setFont(new Font("Poppins",Font.PLAIN,15));
        priceLabel.setForeground(Color.BLACK);
        packagePanel.add(priceLabel);

        JButton bookButton = new JButton("Book Now");
        bookButton.setBounds(120, 380, 150, 30);
        bookButton.setFont(new  Font("Overpass", Font.PLAIN,20));
        bookButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bookButton.setBackground(new Color(51,61,84));
        bookButton.setFocusable(false);
        bookButton.setBorderPainted(false);
        bookButton.setForeground(Color.WHITE);


        bookButton.addActionListener(e -> {new UserPayment(user,price); userDashF.dispose();});
        packagePanel.add(bookButton);

        return packagePanel;
    }
}
