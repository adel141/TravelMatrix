package Classes.UserOperations;

import Classes.Entity.User;
import Classes.UI.Login;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

public class ForgetPass implements ActionListener
{
    
    
    private JFrame frgtPassF;
    private JLabel frgPassImg, frgtPassL, usernameL,captchaL, captchaL1, emailL,passwordL,repasswordL ,otpL;
    private  JTextField userNameT, CaptchaT, emailT, otpT;
    private JPasswordField passwordF,repasswordF;
    private Image iconFrame;
    private  JButton backB, submitB, sendOtpB,showPass,reshowPass, changePassB;
    private User currentUser;
    private int a,b, otp;

    public ForgetPass()
    {
        iconFrame = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/TravelMatrixApp.png"));
        frgtPassF = new JFrame();

        frgPassImg = new JLabel();
        frgPassImg.setIcon(new ImageIcon(new ImageIcon("image/FrgPassBg.png").getImage().getScaledInstance(1260, 700, Image.SCALE_SMOOTH)));
        frgPassImg.setBounds(0, 0, 1260, 700);
  
        
        frgtPassL = new JLabel("Password Recovery");
        frgtPassL.setBounds(745,50,355,50);
        frgtPassL.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(51,61,84)));
        frgtPassL.setForeground(new Color(51, 61, 84));
        frgtPassL.setFont(new Font("Poppins", Font.BOLD, 35));
        


        usernameL = new JLabel("User Name");
        usernameL.setBounds(650,150,180,35);
        usernameL.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));
        usernameL.setForeground(new Color(51, 61, 84));

        userNameT = new JTextField();
        userNameT.setBounds(810,150,350,35);
        userNameT.setForeground(new Color(51, 61, 84));
        userNameT.setFont(new Font("Segoe UI", Font.PLAIN, 20));


// Captcha
        Random rand = new Random();
        a = rand.nextInt(10);
        b = rand.nextInt(10);
        otp = rand.nextInt(9999);

        captchaL1 = new JLabel("Captcha");
        captchaL1.setBounds(650,195,120,35);
        captchaL1.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));
        captchaL1.setForeground(new Color(51, 61, 84));

        
        captchaL = new JLabel();
        captchaL.setText("   " + a + " + " + b + "  "+" = ");
        captchaL.setBounds(810,195,120,35);
        captchaL.setForeground(Color.white);
        captchaL.setBackground(new Color(51,61,84));
        captchaL.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        captchaL.setBorder(null);
        captchaL.setOpaque(true);
        
        CaptchaT = new JTextField();
        CaptchaT.setBounds(950,195,210,35);
        CaptchaT.setForeground(new Color(51, 61, 84));
        CaptchaT.setFont(new Font("Segoe UI", Font.PLAIN, 20));




        submitB = new JButton("Submit");
        submitB.setBounds(850,250,180,45);
        submitB.setFont(new  Font("Poppins", Font.PLAIN,30));
        submitB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submitB.setBackground(new Color(51, 61, 84));
        submitB.setFocusable(false);
        submitB.setBorderPainted(false);
        submitB.setForeground(Color.WHITE);
        submitB.addActionListener(this);


        emailL = new JLabel("Email");
        emailL.setBounds(650,315,120,35);
        emailL.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));
        emailL.setForeground(new Color(51, 61, 84));
        
        
        emailT = new JTextField();
        emailT.setBounds(810,315,350,35);
        emailT.setForeground(new Color(51, 61, 84));
        emailT.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        emailT.setEnabled(false);

        sendOtpB = new JButton("Send Otp");
        sendOtpB.setBounds(850,370,180,45);
        sendOtpB.setFont(new  Font("Poppins", Font.PLAIN,30));
        sendOtpB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sendOtpB.setBackground(new Color(51,61,84));
        sendOtpB.setFocusable(false);
        sendOtpB.setBorderPainted(false);
        sendOtpB.setForeground(Color.WHITE);
        sendOtpB.addActionListener(this);


        otpL = new JLabel("OTP");
        otpL.setBounds(650,435,120,35);
        otpL.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));
        otpL.setForeground(new Color(51, 61, 84));
        
        
        otpT = new JTextField();
        otpT.setBounds(810,435,350,35);
        otpT.setForeground(new Color(51, 61, 84));
        otpT.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        otpT.setEnabled(false);




        passwordL = new JLabel("Password");
        passwordL.setBounds(650,490,350,35);
        passwordL.setForeground(new Color(51, 61, 84));
        passwordL.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));

        
        passwordF = new JPasswordField();
        passwordF.setBounds(810,490,350,35);
        passwordF.setForeground(new Color(51, 61, 84));
        passwordF.setFont( new Font("Segoe UI", Font.PLAIN, 20));
        passwordF.setEnabled(false);

        showPass = new JButton("‍");
        showPass.setFont(new Font("Segoe Fluent Icons",Font.PLAIN,18));
        showPass.setMargin(new Insets(10, 0, 0, 0));
        showPass.setBorderPainted(false);
        showPass.setCursor(new Cursor(Cursor.HAND_CURSOR));
        showPass.setBounds(1160,485,30,40);
        showPass.setOpaque(false);
        showPass.setBorderPainted(false);
        showPass.setFocusable(false);
        showPass.setContentAreaFilled(false);
        showPass.addActionListener(this);
        
        repasswordL = new JLabel("ReType Password");
        repasswordL.setBounds(650,545,350,35);
        repasswordL.setForeground(new Color(51, 61, 84));
        repasswordL.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 18));


        repasswordF = new JPasswordField();
        repasswordF.setBounds(810,545,350,35);
        repasswordF.setForeground(new Color(51, 61, 84));
        repasswordF.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        repasswordF.setEnabled(false);

        reshowPass = new JButton("");
        reshowPass.setFont(new Font("Segoe Fluent Icons",Font.PLAIN,18));
        reshowPass.setMargin(new Insets(10, 0, 0, 0));
        reshowPass.setBorderPainted(false);
        reshowPass.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reshowPass.setBounds(1160,540,30,40);
        reshowPass.setOpaque(false);
        reshowPass.setBorderPainted(false);
        reshowPass.setFocusable(false);
        reshowPass.setContentAreaFilled(false);
        reshowPass.addActionListener(this);

        changePassB = new JButton("Set Password");
        changePassB.setBounds(850,600,180,30);
        changePassB.setFont(new  Font("Poppins", Font.PLAIN,18));
        changePassB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        changePassB.setBackground(new Color(51,61,84));
        changePassB.setFocusable(false);
        changePassB.setBorderPainted(false);
        changePassB.setForeground(Color.WHITE);
        changePassB.addActionListener(this);






        backB = new JButton();
        backB.setBounds(30,30,50,50);
        backB.setIcon(new ImageIcon(new ImageIcon("image/BackWhite.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        backB.setOpaque(false);
        backB.setBorderPainted(false);
        backB.setContentAreaFilled(false); 
        backB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backB.addActionListener(this);
        
        frgtPassF.add(backB);
        frgtPassF.add(CaptchaT);
        frgtPassF.add(frgtPassL);
        frgtPassF.add(usernameL);
        frgtPassF.add(captchaL);
        frgtPassF.add(captchaL1);
        frgtPassF.add(emailL);
        frgtPassF.add(emailT);
        frgtPassF.add(passwordL);
        frgtPassF.add(passwordF);
        frgtPassF.add(reshowPass);
        frgtPassF.add(repasswordL);
        frgtPassF.add(repasswordF);
        frgtPassF.add(showPass);
        frgtPassF.add(changePassB);
        frgtPassF.add(otpL);
        frgtPassF.add(otpT);
        frgtPassF.add(userNameT);
        frgtPassF.add(passwordL);
        frgtPassF.add(submitB);
        frgtPassF.add(sendOtpB);
        frgtPassF.add(frgPassImg);

        frgtPassF.setLayout(null);
        frgtPassF.setTitle("Travel Matrix | Password Recovery");
        frgtPassF.setSize(1260, 700);
        frgtPassF.setIconImage(iconFrame);
        frgtPassF.setVisible(true);
        frgtPassF.setResizable(false);
        frgtPassF.setLocationRelativeTo(null);
        frgtPassF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) 
    {
        JButton button = (JButton) e.getSource();
        if (e.getSource() == backB) 
        {
            new Login();
            frgtPassF.dispose();
        }
        else if (button.getText().equals("‍"))
        {
            passwordF.setEchoChar((char) 0);
            showPass.setText("‍");
        } 
        else if (button.getText().equals("‍")) 
        {
            passwordF.setEchoChar('•');
            showPass.setText("‍");
        }
        //show retype pass
        else if (button.getText().equals(""))
        {
            repasswordF.setEchoChar((char) 0);
            reshowPass.setText("");
        } 
        else if (button.getText().equals("")) 
        {
            repasswordF.setEchoChar('•');
            reshowPass.setText("");
        }
        else if (button.getText().equals("Submit"))
        {
            if (CaptchaT.getText().isEmpty() || userNameT.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(frgtPassF, "Please fill up all information","Missing Information",JOptionPane.WARNING_MESSAGE);
            }
            else if(String.valueOf(a+b).equals(CaptchaT.getText()))
            {
                searchUser();
            }
            else
            {
               JOptionPane.showMessageDialog(frgtPassF, "Captcha verification failed. Please try again. ","CAPTCHA",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (button.getText().equals("Send Otp")) 
        {
            if (CaptchaT.getText().isEmpty() || userNameT.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(frgtPassF, "Please fill up all information","Missing Information",JOptionPane.WARNING_MESSAGE);
            }
            else if(emailT.getText().equals(currentUser.getEmail()))
            {
                JOptionPane.showMessageDialog(frgtPassF, "Your Otp: "+otp+". Don't Share with anyobe","OTP Message",JOptionPane.INFORMATION_MESSAGE);
                emailT.setEnabled(false);
                button.setEnabled(false);
                otpT.setEnabled(true);
                passwordF.setEnabled(true);
                repasswordF.setEnabled(true);

            }
            else
            {
                JOptionPane.showMessageDialog(frgtPassF, "UserName and Email Mismatch","Wrong Email",JOptionPane.WARNING_MESSAGE);
            }
            
        }
        else if(button.getText().equals("Set Password"))
        {
            if (otpT.getText().isEmpty() || passwordF.getText().isEmpty()|| repasswordF.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(frgtPassF, "Please fill up all information","Missing Information",JOptionPane.WARNING_MESSAGE);
            }
            else if(String.valueOf(otp).equals(otpT.getText()))
            {
                if(passwordF.getText().equals(repasswordF.getText()))
                {
                    saveUserData(currentUser);
                    new Login();
                    frgtPassF.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "The passwords you entered do not match. Please make sure both fields are identical.","Password Missmatch",JOptionPane.WARNING_MESSAGE);
                }
            }
            else if(!String.valueOf(otp).equals(otpT.getText()))
            {
                JOptionPane.showMessageDialog(null, "Wrong OTP","OTP Missmatch",JOptionPane.WARNING_MESSAGE);
            }
        }
}


    private void searchUser() {
        String searchUsername = userNameT.getText() + "\n";
        boolean userFound = false;

        try (BufferedReader br = new BufferedReader(new FileReader("./Data/userdata.txt"))) {
            String line;
            StringBuilder userBlock = new StringBuilder();
            boolean isInsideBlock = false;

            while ((line = br.readLine()) != null) {
                if (line.contains("=========================================")) {
                    if (isInsideBlock) {
                        if (userBlock.toString().contains("User Name: " + searchUsername)) {
                            currentUser = parseUserBlock(userBlock.toString());
                            // setUserData(currentUser);
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
                // setUserData(currentUser);
                userFound = true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!userFound) {
            JOptionPane.showMessageDialog(frgtPassF, "User not found!");
        }
        if (userFound) {
            emailT.setEnabled(true);
            userNameT.setEnabled(false);
            CaptchaT.setEnabled(false);
            submitB.setEnabled(false);
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


    private void saveUserData(User user) {
        if (currentUser == null) {
            JOptionPane.showMessageDialog(frgtPassF, "No user selected!");
            return;
        }

        currentUser = new User(
                user.getFirstName(),
                user.getSurName(),
                user.getUserName(),
                user.getEmail(),
                new String(passwordF.getPassword()),
                user.getGender()
        );

        String updatedUserBlock = generateUserBlock(currentUser);

        File inputFile = new File("./data/userdata.txt");
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
                JOptionPane.showMessageDialog(frgtPassF, "Password updated successfully!","Successfull!",JOptionPane.CANCEL_OPTION);
            } else {
                JOptionPane.showMessageDialog(frgtPassF, "User not found!");
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
}
