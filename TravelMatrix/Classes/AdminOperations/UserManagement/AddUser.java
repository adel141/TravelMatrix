package Classes.AdminOperations.UserManagement;

import Classes.Entity.*;
import Classes.UI.Dashboards.AdminDashboard;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class AddUser implements ActionListener{
    
    
    private JFrame addUserF;
    private Image iconFrame;
    private JLabel regPgImg, regPgLable, userNameLabel,FirstNameLabel, surenamLabel, passwordLabel, repasswordLabel, genderLabel, emailLabel;
    private  JTextField userNameTF,firstNameTF,sureNameTF,emailTF;
    private  JPasswordField passwordField, ConfirmPasswordField;
    private  JButton backButton, signUpButton,showPass, reshowPass;
    private  JRadioButton gender1,gender2,gender3;

    public AddUser()
    {
        iconFrame = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/TravelMatrixApp.png"));
        addUserF = new JFrame();



        regPgImg = new JLabel();
        regPgImg.setIcon(new ImageIcon(new ImageIcon("image/adduserPgImg.png").getImage().getScaledInstance(1260, 700, Image.SCALE_SMOOTH)));
        regPgImg.setBounds(0, 0, 1261, 700);

        regPgLable = new JLabel("Add User");
        regPgLable.setBounds(850,100,165,50);
        regPgLable.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(51,61,84)));
        regPgLable.setForeground(new Color(51, 61, 84));
        regPgLable.setFont(new Font("Poppins", Font.BOLD, 35));

        FirstNameLabel = new JLabel("First Name");
        FirstNameLabel.setBounds(650,170,180,35);
        FirstNameLabel.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));
        FirstNameLabel.setForeground(new Color(51, 61, 84));

        firstNameTF = new JTextField();
        firstNameTF.setBounds(810,170,350,35);
        firstNameTF.setForeground(new Color(51, 61, 84));
        firstNameTF.setFont(new Font("Segoe UI", Font.PLAIN, 20));


        backButton = new JButton();
        backButton.setBounds(30, 30, 50, 50);
        backButton.setOpaque(false);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setIcon(new ImageIcon(new ImageIcon("image/BackThemeWhite.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        backButton.addActionListener(this);



        surenamLabel = new JLabel("Sure Name");
        surenamLabel.setBounds(650,220,180,35);
        surenamLabel.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));
        surenamLabel.setForeground(new Color(51, 61, 84));

        sureNameTF = new JTextField();
        sureNameTF.setBounds(810,220,350,35);
        sureNameTF.setForeground(new Color(51, 61, 84));
        sureNameTF.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        userNameLabel = new JLabel("UserName");
        userNameLabel.setBounds(650,270,180,35);
        userNameLabel.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));
        userNameLabel.setForeground(new Color(51, 61, 84));

        userNameTF = new JTextField();
        userNameTF.setBounds(810,270,350,35);
        userNameTF.setForeground(new Color(51, 61, 84));
        userNameTF.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        surenamLabel = new JLabel("Sure Name");
        surenamLabel.setBounds(650,220,180,35);
        surenamLabel.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));
        surenamLabel.setForeground(new Color(51, 61, 84));

        emailLabel = new JLabel("E-mail");
        emailLabel.setBounds(650,320,180,35);
        emailLabel.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));
        emailLabel.setForeground(new Color(51, 61, 84));
        
        emailTF = new JTextField();
        emailTF.setBounds(810,320,350,35);
        emailTF.setForeground(new Color(51, 61, 84));
        emailTF.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(650,370,350,35);
        passwordLabel.setForeground(new Color(51, 61, 84));
        passwordLabel.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));

        
        passwordField = new JPasswordField();
        passwordField.setBounds(810,370,350,35);
        passwordField.setForeground(new Color(51, 61, 84));
        passwordField.setFont( new Font("Segoe UI", Font.PLAIN, 20));

        showPass = new JButton("‍");
        showPass.setFont(new Font("Segoe Fluent Icons",Font.PLAIN,18));
        showPass.setMargin(new Insets(10, 0, 0, 0));
        showPass.setBorderPainted(false);
        showPass.setCursor(new Cursor(Cursor.HAND_CURSOR));
        showPass.setBounds(1160,365,30,40);
        showPass.setOpaque(false);
        showPass.setBorderPainted(false);
        showPass.setFocusable(false);
        showPass.setContentAreaFilled(false);
        showPass.addActionListener(this);
        
        repasswordLabel = new JLabel("ReType Password");
        repasswordLabel.setBounds(650,420,350,35);
        repasswordLabel.setForeground(new Color(51, 61, 84));
        repasswordLabel.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 18));


        ConfirmPasswordField = new JPasswordField();
        ConfirmPasswordField.setBounds(810,420,350,35);
        ConfirmPasswordField.setForeground(new Color(51, 61, 84));
        ConfirmPasswordField.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        reshowPass = new JButton("");
        reshowPass.setFont(new Font("Segoe Fluent Icons",Font.PLAIN,18));
        reshowPass.setMargin(new Insets(10, 0, 0, 0));
        reshowPass.setBorderPainted(false);
        reshowPass.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reshowPass.setBounds(1160,415,30,40);
        reshowPass.setOpaque(false);
        reshowPass.setBorderPainted(false);
        reshowPass.setFocusable(false);
        reshowPass.setContentAreaFilled(false);
        reshowPass.addActionListener(this);

        genderLabel = new JLabel("Select Gender");
        genderLabel.setBounds(650,470,350,35);
        genderLabel.setForeground(new Color(51, 61, 84));
        genderLabel.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));


        gender1 = new JRadioButton("Male");
        gender1.setBounds(810,470,100,35);
        gender1.setForeground(new Color(51, 61, 84));
        gender1.setContentAreaFilled(false);
        gender1.setFocusable(false);
        gender1.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));

        gender2 = new JRadioButton("Female");
        gender2.setBounds(920,470,100,35);
        gender2.setForeground(new Color(51, 61, 84));
        gender2.setContentAreaFilled(false);
        gender2.setFocusable(false);
        gender2.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));

        gender3 = new JRadioButton("Others");
        gender3.setBounds(1030,470,100,35);
        gender3.setForeground(new Color(51, 61, 84));
        gender3.setContentAreaFilled(false);
        gender3.setFocusable(false);
        gender3.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));

        ButtonGroup gendeGroup=new ButtonGroup();
        gendeGroup.add(gender1);
        gendeGroup.add(gender2);
        gendeGroup.add(gender3);


        signUpButton = new JButton("Add User");
        signUpButton.setBounds(830,515,180,45);
        signUpButton.setFont(new  Font("Poppins", Font.PLAIN,30));
        signUpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signUpButton.setBackground(new Color(51,61,84));
        signUpButton.setFocusable(false);
        signUpButton.setBorderPainted(false);
        signUpButton.setForeground(Color.WHITE);
        signUpButton.addActionListener(this);




  // Captcha
    //   Random rand = new Random();
    //   int a = rand.nextInt(10);
    //   int b = rand.nextInt(10);

    //   captcha = new JLabel();
    //   captcha.setText("   " + a + " + " + b + "  ");
    //   captcha.setBounds(650,515,90,45);
    //   captcha.setForeground(Color.white);
    //   captcha.setBackground(new Color(51,61,84));
    //   captcha.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    //   captcha.setBorder(null);
    //   captcha.setOpaque(true);

        addUserF.add(regPgLable);
        addUserF.add(FirstNameLabel);
        addUserF.add(firstNameTF);
        addUserF.add(sureNameTF);
        addUserF.add(surenamLabel);
        addUserF.add(emailLabel);
        addUserF.add(gender1);
        addUserF.add(gender2);
        addUserF.add(gender3);
        addUserF.add(emailTF);
        addUserF.add(passwordField);
        addUserF.add(passwordLabel);
        addUserF.add(ConfirmPasswordField);
        addUserF.add(backButton);
        addUserF.add(showPass);
        addUserF.add(reshowPass); 
        addUserF.add(genderLabel);
        addUserF.add(signUpButton);
        addUserF.add(repasswordLabel);
        addUserF.add(userNameLabel);
        addUserF.add(userNameTF);
        addUserF.add(regPgImg);


        // addUserF.setUndecorated(true);

        addUserF.setLayout(null);
        addUserF.setTitle("Travel Matrix | Add User");
        addUserF.setSize(1260, 700);
        addUserF.setIconImage(iconFrame);
        addUserF.setResizable(false);
        addUserF.setVisible(true);
        addUserF.setLocationRelativeTo(null);
        addUserF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) 
    {
        JButton button = (JButton) e.getSource();
        if(e.getSource()==signUpButton)
        {
            register();
        }
        else if(e.getSource()==backButton)
        {
            new AdminDashboard();
            addUserF.dispose();
        }
        else if (e.getSource() instanceof JButton) 
        {
            
            //show pass
            if (button.getText().equals("‍"))
            {
                passwordField.setEchoChar((char) 0);
                showPass.setText("‍");
            } 
            else if (button.getText().equals("‍")) 
            {
                passwordField.setEchoChar('•');
                showPass.setText("‍");
            }
            //show retype pass
            if (button.getText().equals(""))
            {
                ConfirmPasswordField.setEchoChar((char) 0);
                reshowPass.setText("");
            } 
            else if (button.getText().equals("")) 
            {
                ConfirmPasswordField.setEchoChar('•');
                reshowPass.setText("");
            }
        }
    }



    private boolean isUserExists(String userName) 
    {
        try {
            File file = new File("./data/userdata.txt");
            if (!file.exists()) {
                return false;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            userName = "User Name: " + userName;
            while ((line = reader.readLine()) != null) 
            {
                if (line.equals(userName)) {
                    reader.close();
                    return true;
                }
            }
            reader.close();
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }




    
    private void register()
    {
        String firstName = firstNameTF.getText();
        String sureName = sureNameTF.getText();
        String userName = userNameTF.getText();
        String email = emailTF.getText();
        String password = new String(passwordField.getPassword());
        String rePassword = new String(ConfirmPasswordField.getPassword());
        String gender ="";
        //gender from jradiobutton
        if (gender1.isSelected()) 
        {
            gender = "Male";
        }
        else if (gender2.isSelected()) 
        {
            gender = "Female";
        }
        else if (gender3.isSelected()) 
        {
            gender = "others";
        }


        if (firstName.isEmpty() || sureName.isEmpty() || userName.isEmpty() || email.isEmpty() || password.isEmpty() ||  rePassword.isEmpty() || gender.isEmpty())
        	{
        		JOptionPane.showMessageDialog(null, "Please fill up all information","Missing Information",JOptionPane.WARNING_MESSAGE);
        	}
        	
       	else 
        {
            if(!password.equals(rePassword))
            {
                JOptionPane.showMessageDialog(null, "The passwords you entered do not match. Please make sure both fields are identical.","Password Missmatch",JOptionPane.WARNING_MESSAGE);
            }
            else if(isUserExists(userName))
            {
                JOptionPane.showMessageDialog(null, "The username you entered already exists. Please choose a different username.","Username Already Taken",JOptionPane.INFORMATION_MESSAGE);

            }
            else
            {
                try 
                {	 
                    User newUser = new User(firstName,sureName,userName,email,password,gender);
                    File file = new File ("./Data/userdata.txt");
                    if(!file.exists()) 
                    {
                        file.createNewFile();
                    }
                    FileWriter fileWriter = new FileWriter(file,true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    PrintWriter printWriter = new PrintWriter(fileWriter);
                    
                    
                    printWriter.println("First Name: "+newUser.getFirstName());
                    printWriter.println("Sure Name: "+newUser.getSurName());
                    printWriter.println("User Name: "+newUser.getUserName());
                    printWriter.println("Password: "+newUser.getPassword());
                    printWriter.println("Email: "+newUser.getEmail());
                    printWriter.println("Gender: "+newUser.getGender());
                    printWriter.println("=========================================");
                    printWriter.close();
                } 
                    catch (Exception e2) 
                    {
                        System.out.println(e2);
                    }
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                addUserF.dispose();
                new AdminDashboard();
            }
        }
        	
    }
}

