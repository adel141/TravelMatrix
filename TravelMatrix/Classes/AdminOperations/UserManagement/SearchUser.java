package Classes.AdminOperations.UserManagement;

import Classes.Entity.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class SearchUser {
    private JTextField searchUsernameT, usernameT, firstNameT, surnameT, emailT;
    private JLabel searchUsernameL,genderL,usernameL,firstNameL,surnameL,passwordL,emailL;
    private JPasswordField passwordT;
    private JRadioButton maleR, femaleR, otherR;
    private ButtonGroup genderGroup;
    private Image iconFrame;
    private JButton searchB;
    private JFrame frame;
    private final String filePath = "./Data/userdata.txt"; 

    private User currentUser; 

    public SearchUser() {
        iconFrame = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/TravelMatrixApp.png"));

        frame = new JFrame("Travel Matrix | Search User Details");

        searchUsernameL = new JLabel("Search Username:");
        searchUsernameL.setForeground(new Color(51, 61, 84));
        
        usernameL = new JLabel("Username:");
        usernameL.setForeground(new Color(51, 61, 84));
        
        firstNameL = new JLabel("First Name:");
        firstNameL.setForeground(new Color(51, 61, 84));
        
        surnameL = new JLabel("Surname:");
        surnameL.setForeground(new Color(51, 61, 84));
        
        passwordL = new JLabel("Password:");
        passwordL.setForeground(new Color(51, 61, 84));
        
        emailL = new JLabel("Email:");
        emailL.setForeground(new Color(51, 61, 84));
        
        genderL = new JLabel("Gender:");
        genderL.setForeground(new Color(51, 61, 84));

        
        searchUsernameT = new JTextField(20);
        usernameT = new JTextField(20);
        firstNameT = new JTextField(20);
        surnameT = new JTextField(20);
        passwordT = new JPasswordField(20);
        emailT = new JTextField(20);

        maleR = new JRadioButton("Male");
        femaleR = new JRadioButton("Female");
        otherR = new JRadioButton("Other");

        genderGroup = new ButtonGroup();
        genderGroup.add(maleR);
        genderGroup.add(femaleR);
        genderGroup.add(otherR);

        usernameT.setEditable(false);
        firstNameT.setEditable(false);
        surnameT.setEditable(false);
        passwordT.setEditable(false);
        emailT.setEditable(false);

        searchB = new JButton("Search");
        
        searchB.setFont(new Font("Poppins", Font.BOLD, 15));
        searchB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchB.setFocusable(false);
        searchB.setBorderPainted(false);
        searchB.setBackground(new Color(51, 61, 84)); 
        searchB.setForeground(Color.WHITE); 

        searchB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchUser(); 
            }
        });

        frame.setLayout(new GridLayout(9, 2, 10, 10));

        frame.add(searchUsernameL); frame.add(searchUsernameT);
        frame.add(new JLabel("")); frame.add(searchB);  
        frame.add(usernameL); frame.add(usernameT);
        frame.add(firstNameL); frame.add(firstNameT);
        frame.add(surnameL); frame.add(surnameT);
        frame.add(passwordL); frame.add(passwordT);
        frame.add(emailL); frame.add(emailT);
        frame.add(genderL); frame.add(createGenderPanel());

        frame.setSize(450, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);        
        frame.setResizable(false);
        frame.setIconImage(iconFrame);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLocationRelativeTo(null); 
    }

    private void searchUser() {
        String searchUsername = searchUsernameT.getText() +"\n"; 
        boolean userFound = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder userBlock = new StringBuilder();
            boolean isInsideBlock = false;

            while ((line = br.readLine()) != null) {
                if (line.contains("=========================================")) {
                    if (isInsideBlock) {
                        // Check for exact username match in the user block
                        if (userBlock.toString().contains("User Name: " + searchUsername)) {
                            currentUser = parseUserBlock(userBlock.toString()); 
                            setUserData(currentUser);
                            userFound = true;
                            break;
                        }
                        userBlock.setLength(0); // Clear the buffer
                        isInsideBlock = false;
                    }
                } else {
                    if (line.startsWith("First Name: ")) {
                        isInsideBlock = true; 
                    }
                    if (isInsideBlock) {
                        userBlock.append(line).append("\n"); 
                    }
                }
            }

            if (isInsideBlock && userBlock.toString().contains("User Name: " + searchUsername)) {
                currentUser = parseUserBlock(userBlock.toString());
                setUserData(currentUser);
                userFound = true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!userFound) {
            JOptionPane.showMessageDialog(frame, "User not found!");
        }
    }

    // Method to set user data into the form fields
    private void setUserData(User user) {
        firstNameT.setText(user.getFirstName());
        surnameT.setText(user.getSurName());
        usernameT.setText(user.getUserName());
        passwordT.setText(user.getPassword());
        emailT.setText(user.getEmail());

        switch (user.getGender().toLowerCase()) {
            case "male":
                maleR.setSelected(true);
                break;
            case "female":
                femaleR.setSelected(true);
                break;
            default:
                otherR.setSelected(true);
                break;
        }
    }

    private JPanel createGenderPanel() {
        JPanel genderPanel = new JPanel();
        genderPanel.setLayout(new FlowLayout());
        genderPanel.add(maleR);
        genderPanel.add(femaleR);
        genderPanel.add(otherR);
        return genderPanel;
    }


    private User parseUserBlock(String userBlock) {
        String[] userData = new String[6];
        String[] lines = userBlock.split("\n");

        for (String line : lines) {
            if (line.startsWith("First Name: ")) {
                userData[0] = line.substring("First Name: ".length());
            } else if (line.startsWith("SurName: ")) {
                userData[1] = line.substring("SurName: ".length());
            } else if (line.startsWith("User Name: ")) {
                userData[2] = line.substring("User Name: ".length());
            } else if (line.startsWith("Password: ")) {
                userData[3] = line.substring("Password: ".length());
            } else if (line.startsWith("Email: ")) {
                userData[4] = line.substring("Email: ".length());
            } else if (line.startsWith("Gender: ")) {
                userData[5] = line.substring("Gender: ".length());
            }
        }

        return new User(userData[0], userData[1], userData[2], userData[4], userData[3], userData[5]);
    }
}
