package Classes.AdminOperations.UserManagement;

import Classes.Entity.User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class EditUser {
    protected JTextField searchUsernameT;
    protected JButton searchB;
    protected JLabel searchUsernameL;
    private JTextField  usernameT, firstNameT, surnameT, emailT;
    private JPasswordField passwordT;
    private JLabel usernameL;
    private JRadioButton maleR, femaleR, otherR;
    private ButtonGroup genderGroup;
    private Image iconFrame;
    private JButton saveB, cancelB;
    private JFrame frame;
    private final String filePath = "./Data/userdata.txt";

    private User currentUser;

    public EditUser() {
        iconFrame = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/TravelMatrixApp.png"));

        frame = new JFrame("Edit User Details");

        searchUsernameL = new JLabel("Search Username:");
        searchUsernameL.setForeground(Color.WHITE);
        
        usernameL = new JLabel("Username:");
        usernameL.setForeground(Color.WHITE);
        
        JLabel firstNameL = new JLabel("First Name:");
        firstNameL.setForeground(Color.WHITE);
        
        JLabel surnameL = new JLabel("Surname:");
        surnameL.setForeground(Color.WHITE);
        
        JLabel passwordL = new JLabel("Password:");
        passwordL.setForeground(Color.WHITE);
        
        JLabel emailL = new JLabel("Email:");
        emailL.setForeground(Color.WHITE);
        
        JLabel genderL = new JLabel("Gender:");
        genderL.setForeground(Color.WHITE);

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

        saveB = new JButton("Save");
        setButtonStyle(saveB);

        cancelB = new JButton("Cancel");
        setButtonStyle(cancelB);

        searchB = new JButton("Search");
        setButtonStyle(searchB);

        searchB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchUser();
            }
        });

        saveB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveUserData();
            }
        });

        cancelB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
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
        frame.add(saveB); frame.add(cancelB);

        frame.setSize(450, 400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setIconImage(iconFrame);
        frame.getContentPane().setBackground(new Color(51, 61, 84));
        frame.setLocationRelativeTo(null);
    }

    private void searchUser() {
        String searchUsername = searchUsernameT.getText() + "\n";
        boolean userFound = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder userBlock = new StringBuilder();
            boolean isInsideBlock = false;

            while ((line = br.readLine()) != null) {
                if (line.contains("=========================================")) {
                    if (isInsideBlock) {
                        if (userBlock.toString().contains("User Name: " + searchUsername)) {
                            currentUser = parseUserBlock(userBlock.toString());
                            setUserData(currentUser);
                            userFound = true;
                            break;
                        }
                        userBlock.setLength(0);
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

    private void saveUserData() {
        if (currentUser == null) {
            JOptionPane.showMessageDialog(frame, "No user selected!");
            return;
        }

        currentUser = new User(
                firstNameT.getText(),
                surnameT.getText(),
                currentUser.getUserName(),
                emailT.getText(),
                new String(passwordT.getPassword()),
                getSelectedGender()
        );

        String updatedUserBlock = generateUserBlock(currentUser);

        File inputFile = new File(filePath);
        File tempFile = new File("temp_users.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            StringBuilder userBlock = new StringBuilder();
            boolean isInsideBlock = false;
            boolean userUpdated = false;

            while ((line = br.readLine()) != null) {
                if (line.contains("=========================================")) {
                    if (isInsideBlock) {
                        if (userBlock.toString().contains("User Name: " + currentUser.getUserName())) {
                            bw.write(updatedUserBlock);
                            userUpdated = true;
                        } else {
                            bw.write(userBlock.toString());
                        }
                        bw.write(line + "\n");
                        userBlock.setLength(0);
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

            if (userBlock.length() > 0) {
                if (userBlock.toString().contains("User Name: " + currentUser.getUserName())) {
                    bw.write(updatedUserBlock);
                    userUpdated = true;
                } else {
                    bw.write(userBlock.toString());
                }
                bw.write("=========================================\n");
            }

            if (userUpdated) {
                JOptionPane.showMessageDialog(frame, "User details updated successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "User not found!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!inputFile.delete()) {
            System.out.println("Could not delete original file");
        }
        if (!tempFile.renameTo(inputFile)) {
            System.out.println("Could not rename temp file");
        }
    }

    private String generateUserBlock(User user) {
        return "First Name: " + user.getFirstName() + "\n" +
                "SurName: " + user.getSurName() + "\n" +
                "User Name: " + user.getUserName() + "\n" +
                "Password: " + user.getPassword() + "\n" +
                "Email: " + user.getEmail() + "\n" +
                "Gender: " + user.getGender() + "\n";
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

    private String getSelectedGender() {
        if (maleR.isSelected()) {
            return "Male";
        } else if (femaleR.isSelected()) {
            return "Female";
        } else {
            return "Other";
        }
    }

    private void setButtonStyle(JButton button) {
        button.setFont(new Font("Poppins", Font.BOLD, 15));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusable(false);
        button.setBorderPainted(false);
        button.setBackground(Color.WHITE);
        button.setForeground(new Color(51, 61, 84));
    }
}
