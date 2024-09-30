package Classes.UI;
import Classes.UI.Dashboards.*;
import Classes.UserOperations.ForgetPass;
import Interfaces.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import javax.swing.*;

public class Login implements ActionListener, IloginOperation
{
    private JFrame loginFrame;
    private JLabel userNameLabel, passLabel, lgnPgImg, loginPageText;
    private JTextField userTextField;
    private JPasswordField passField;
    private JButton signInButton, signUpButton, forgetPassButton, showPass, aboutus;
    private Image iconFrame;
    private String user;


    public Login()
    {
        iconFrame = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/TravelMatrixApp.png"));
        loginFrame = new JFrame();

        lgnPgImg = new JLabel();
        lgnPgImg.setIcon(new ImageIcon(new ImageIcon("image/lgnPgImg.png").getImage().getScaledInstance(1260, 700, Image.SCALE_SMOOTH)));
        lgnPgImg.setBounds(0, 0, 1260, 700);



        loginPageText = new JLabel("Welcome Back");
        loginPageText.setBounds(720,350,275,40);
        loginPageText.setFont(new Font("Overpass", Font.BOLD, 40));

        userNameLabel = new JLabel("User Name");
        userNameLabel.setBounds(650,400,150,40);
        userNameLabel.setFont( new Font("Overpass", Font.PLAIN, 25));

        userTextField = new JTextField();
        userTextField.setBounds(790,400,250,40);
        userTextField.setFont( new Font("Overpass", Font.PLAIN, 25));

        passLabel = new JLabel("Password");
        passLabel.setBounds(650,450,150,40);
        passLabel.setFont( new Font("Overpass", Font.PLAIN, 25));

        passField = new JPasswordField();
        passField.setBounds(790,450,250,40);
        passField.setFont( new Font("Overpass", Font.PLAIN, 25));

        showPass = new JButton("");
        showPass.setFont(new Font("Segoe Fluent Icons",Font.PLAIN,20));
        showPass.setMargin(new Insets(10, 0, 0, 0));
        showPass.setBorderPainted(false);
        showPass.setCursor(new Cursor(Cursor.HAND_CURSOR));
        showPass.setBounds(1040,448,30,40);
        showPass.setOpaque(false);
        showPass.setBorderPainted(false);
        showPass.setFocusable(false);
        showPass.setContentAreaFilled(false);




        signInButton = new JButton("Sign In");
        signInButton.setBounds(790,515,150,45);
        signInButton.setFont(new  Font("Overpass", Font.PLAIN,30));
        signInButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signInButton.setBackground(new Color(51,61,84));
        signInButton.setFocusable(false);
        signInButton.setBorderPainted(false);
        signInButton.setForeground(Color.WHITE);



        signUpButton = new JButton("<html>Don't Have a account? <b><u>Register Here</u></b><html>");
        signUpButton.setBounds(720,568,265,20);
        signUpButton.setFont(new  Font("Overpass", Font.PLAIN,15));
        signUpButton.setOpaque(false);
        signUpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signUpButton.setFocusable(false);
        signUpButton.setContentAreaFilled(false);
        signUpButton.setBorderPainted(false);
        signUpButton.setForeground(new Color(51,61,84));

        forgetPassButton = new JButton("<html><u>Forget Password?</u><html>");
        forgetPassButton.setBounds(912,490,135,20);
        forgetPassButton.setFont(new  Font("Overpass", Font.PLAIN,15));
        forgetPassButton.setOpaque(false);
        forgetPassButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        forgetPassButton.setFocusable(false);
        forgetPassButton.setContentAreaFilled(false);
        forgetPassButton.setBorderPainted(false);
        forgetPassButton.setForeground(new Color(51,61,84));

        
        aboutus = new JButton("About Us");
        aboutus.setBounds(20,600,150,35);
        aboutus.setFont(new  Font("Segoe UI", Font.PLAIN,25));
        aboutus.setCursor(new Cursor(Cursor.HAND_CURSOR));
        aboutus.setFocusable(false);
        aboutus.setBackground(Color.WHITE);
        aboutus.setBorderPainted(false);
        aboutus.setForeground(new Color(51,61,84));

        loginFrame.add(showPass);
        loginFrame.add(aboutus);
        loginFrame.add(loginPageText);
        loginFrame.add(userTextField);
        loginFrame.add(userNameLabel);
        loginFrame.add(passLabel);
        loginFrame.add(passField);
        loginFrame.add(signInButton);
        loginFrame.add(signUpButton);
        loginFrame.add(forgetPassButton);
        loginFrame.add(passField);
        loginFrame.add(lgnPgImg);

        showPass.addActionListener(this);
        signInButton.addActionListener(this);
        forgetPassButton.addActionListener(this);
        signUpButton.addActionListener(this);
        aboutus.addActionListener(this);




        loginFrame.setLayout(null);
        loginFrame.setTitle("Travel Matrix | Login");
        loginFrame.setSize(1260, 700);
        loginFrame.setIconImage(iconFrame);
        loginFrame.setVisible(true);
        loginFrame.setResizable(false);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() instanceof JButton) 
        {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals(""))
            {
                passField.setEchoChar((char) 0);
                showPass.setText("");
            } 
            else if (button.getText().equals("")) 
            {
                passField.setEchoChar('•');
                showPass.setText("");
            }
            else if (button.getText().equals("<html>Don't Have a account? <b><u>Register Here</u></b><html>"))
            {
                new Registration();
                loginFrame.dispose();
            }
            else if (button.getText().equals("<html><u>Forget Password?</u><html>"))
            {
                new ForgetPass();
                loginFrame.dispose();
            }
            else if (button.getText().equals("About Us"))
            {
                new AboutUs();
            }
            else if (button.getText().equals("Sign In"))
            {
                matchUser();
            }
        }
    }
    public boolean matchUser(String user, String pass)
    {
        if(user.equals("admin") && pass.equals("admin"))
        {
            return true;
        }
            return false;
    }
    public void matchUser()
    {
         user = userTextField.getText();
        String pass = new String(passField.getPassword());
        String file = "Data/userdata.txt";
        if (user.isEmpty() || pass.isEmpty())
        {

            JOptionPane.showMessageDialog(null, "Please fill up all information","Missing Information",JOptionPane.WARNING_MESSAGE);
        }
        else 
        {
            if(matchUser(user,pass))
            {
                new AdminDashboard();
                loginFrame.dispose();
            }
            else
            {
                try 
                {
                    String userName = "User Name: " + user;
                    String password = "Password: " + pass;
                    BufferedReader reader = new BufferedReader(new FileReader(file));

                    int totalLines = 0;
                    while (reader.readLine() != null)
                    totalLines++;
                    reader.close();

                    for (int i = 0; i <= totalLines; i++)
                    {
                        String line1 = Files.readAllLines(Paths.get(file)).get(i+2);
                        if (line1.equals(userName))
                        {
                            String line2 = Files.readAllLines(Paths.get(file)).get((i + 3));
                            if (line2.equals(password)) 
                            {
                                new UserDashboard(user);
                                loginFrame.dispose();
                                break;
                            }
                        }  
                    }
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Invalid User Name or Password!", "Warning!",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }
}