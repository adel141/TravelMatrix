package Classes.AdminOperations.UserManagement;

import Classes.UI.Dashboards.AdminDashboard;
import java.awt.*; // Assuming User class exists
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.JTableHeader;

public class ShowUsers implements ActionListener {
    private JFrame frame;
    private JLabel showallUPgImg;
    private JTable userTable;
    private JButton backB;
    private final String filePath = "./Data/userdata.txt"; 

    public ShowUsers() {

        showallUPgImg = new JLabel();
        showallUPgImg.setIcon(new ImageIcon(new ImageIcon("image/showUsers.png").getImage().getScaledInstance(1260, 700, Image.SCALE_SMOOTH)));
        showallUPgImg.setBounds(0, 0, 1260, 700);

        frame = new JFrame("Travel Matrix | Show All Users");
        frame.setSize(1270, 700);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/TravelMatrixApp.png")));
        
        String[] columnNames = {"First Name", "Surname", "User Name", "Email", "Gender"};
        String[][] data = fetchUserData();

        userTable = new JTable(data, columnNames);
        userTable.setFont(new Font("Poppins", Font.PLAIN, 18));
        userTable.setBackground(Color.WHITE);
        userTable.setForeground(new Color(51, 61, 84));
        userTable.setRowHeight(25);
        userTable.setEnabled(false);
        

        JTableHeader header = userTable.getTableHeader();
        header.setFont(new Font("Poppins", Font.BOLD, 18));
        header.setBackground(new Color(51, 61, 84)); // Header background color
        header.setForeground(Color.WHITE); // Header text color




        JScrollPane scrollPane = new JScrollPane(userTable);
        scrollPane.setBounds(90, 50, 1110, 555);
        frame.add(scrollPane);
        backB = new JButton();
        backB.setBounds(30,30,50,50);
        backB.setIcon(new ImageIcon(new ImageIcon("image/BackWhite.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        backB.setOpaque(false);
        backB.setBorderPainted(false);
        backB.setContentAreaFilled(false); 
        backB.setCursor(new Cursor(Cursor.HAND_CURSOR));

       
        backB.addActionListener(this);

        frame.add(backB);
        frame.add(showallUPgImg);
        frame.setVisible(true);
    }

    private String[][] fetchUserData() {
        String[][] userData = new String[100][5]; 
        int index = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String firstName = "", surname = "", userName = "", email = "", gender = "";
            boolean isInsideBlock = false;

            while ((line = br.readLine()) != null) {
                if (line.startsWith("First Name: ")) {
                    firstName = line.substring("First Name: ".length());
                    isInsideBlock = true;
                } else if (line.startsWith("SurName: ")) {
                    surname = line.substring("SurName: ".length());
                } else if (line.startsWith("User Name: ")) {
                    userName = line.substring("User Name: ".length());
                } else if (line.startsWith("Email: ")) {
                    email = line.substring("Email: ".length());
                } else if (line.startsWith("Gender: ")) {
                    gender = line.substring("Gender: ".length());
                } else if (line.contains("=========================================") && isInsideBlock) {
                    userData[index][0] = firstName;
                    userData[index][1] = surname;
                    userData[index][2] = userName;
                    userData[index][3] = email;
                    userData[index][4] = gender;
                    index++;
                    isInsideBlock = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userData;
    }

    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==backB)
        {
            new AdminDashboard();
            frame.dispose();
        }

    }


}
