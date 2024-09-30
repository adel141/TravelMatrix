package Classes.AdminOperations.UserManagement;

import Classes.Entity.User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class RemoveUser {
    private JTextField searchUsernameT;
    private JLabel usernameL, firstNameL, surnameL, emailL, genderL,searchUsernameL;
    private Image iconFrame;
    private JButton removeB, cancelB, searchB;
    private JFrame frame;
    private final String filePath = "./Data/userdata.txt";
    private User currentUser;

    public RemoveUser() {
        iconFrame = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/TravelMatrixApp.png"));

        frame = new JFrame("Remove User");

        searchUsernameL = new JLabel("Search Username:");
        searchUsernameL.setForeground(Color.WHITE);

        searchUsernameT = new JTextField(20);

        usernameL = new JLabel("Username:");
        usernameL.setForeground(Color.WHITE);

        firstNameL = new JLabel("First Name:");
        firstNameL.setForeground(Color.WHITE);

        surnameL = new JLabel("Surname:");
        surnameL.setForeground(Color.WHITE);

        emailL = new JLabel("Email:");
        emailL.setForeground(Color.WHITE);

        genderL = new JLabel("Gender:");
        genderL.setForeground(Color.WHITE);

        removeB = new JButton("Remove");
        removeB.setFont(new Font("Poppins", Font.BOLD, 15));
        removeB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        removeB.setFocusable(false);
        removeB.setBorderPainted(false);
        removeB.setBackground(Color.WHITE);
        removeB.setForeground(new Color(51, 61, 84));

        cancelB = new JButton("Cancel");
        cancelB.setFont(new Font("Poppins", Font.BOLD, 15));
        cancelB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancelB.setFocusable(false);
        cancelB.setBorderPainted(false);
        cancelB.setBackground(Color.WHITE);
        cancelB.setForeground(new Color(51, 61, 84));

        searchB = new JButton("Search");
        searchB.setFont(new Font("Poppins", Font.BOLD, 15));
        searchB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchB.setFocusable(false);
        searchB.setBorderPainted(false);
        searchB.setBackground(Color.WHITE);
        searchB.setForeground(new Color(51, 61, 84));

        // Action Listeners
        searchB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchUser();
            }
        });

        removeB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeUser();
            }
        });

        cancelB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.setLayout(null);
        searchUsernameL.setBounds(30, 20, 150, 30);
        searchUsernameT.setBounds(180, 20, 200, 30);
        searchB.setBounds(390, 20, 100, 30);
        usernameL.setBounds(30, 60, 300, 30);
        firstNameL.setBounds(30, 100, 300, 30);
        surnameL.setBounds(30, 140, 300, 30);
        emailL.setBounds(30, 180, 300, 30);
        genderL.setBounds(30, 220, 300, 30);
        removeB.setBounds(100, 270, 100, 30);
        cancelB.setBounds(250, 270, 100, 30);

        frame.add(searchUsernameL);
        frame.add(searchUsernameT);
        frame.add(searchB);
        frame.add(usernameL);
        frame.add(firstNameL);
        frame.add(surnameL);
        frame.add(emailL);
        frame.add(genderL);
        frame.add(removeB);
        frame.add(cancelB);

        frame.setSize(550, 350);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setIconImage(iconFrame);
        frame.getContentPane().setBackground(new Color(51, 61, 84));
        frame.setLocationRelativeTo(null);
    }

    private void searchUser() {
        String searchUsername = searchUsernameT.getText().trim() + "\n";
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
            clearUserData();
        }
    }

    private void removeUser() {
        if (currentUser == null) {
            JOptionPane.showMessageDialog(frame, "No user selected!");
            return;
        }

        File inputFile = new File(filePath);
        File tempFile = new File("temp_users.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            StringBuilder userBlock = new StringBuilder();
            boolean isInsideBlock = false;
            boolean userRemoved = false;

            while ((line = br.readLine()) != null) {
                if (line.contains("=========================================")) {
                    if (isInsideBlock) {
                        if (userBlock.toString().contains("User Name: " + currentUser.getUserName())) {
                            userRemoved = true;
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

            if (userRemoved) {
                JOptionPane.showMessageDialog(frame, "User removed successfully!");
                clearUserData();
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
        usernameL.setText("Username: " + user.getUserName());
        firstNameL.setText("First Name: " + user.getFirstName());
        surnameL.setText("Surname: " + user.getSurName());
        emailL.setText("Email: " + user.getEmail());
        genderL.setText("Gender: " + user.getGender());
    }

    private void clearUserData() {
        usernameL.setText("Username:");
        firstNameL.setText("First Name:");
        surnameL.setText("Surname:");
        emailL.setText("Email:");
        genderL.setText("Gender:");
    }



}
