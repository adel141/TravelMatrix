package Classes.UI.Dashboards;

import Classes.AdminOperations.PackageManagement.AddPackage;
import Classes.AdminOperations.PackageManagement.ManagePackage;
import Classes.AdminOperations.PackageManagement.ShowPackage;
import Classes.AdminOperations.UserManagement.*;
import Classes.UI.Login;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminDashboard implements ActionListener
{
    
    
    private JFrame admindashF;
    
    private JButton logoutB;
    private JButton adduser,removeuser,searchuserB,edituser,showAlluser;
    private JButton addTRPack, showTRPack,searchTRPack;
    private  JTabbedPane adminPane;
    private Image iconFrame;
    private  JLabel userLabel,bookLabel,tripLabel;
    private  JPanel userPanel,bookingPanel,tripPanel;
    private ImageIcon userBg,bookingbg,tripbg,userIcon,tripIcon,bookIcon;


    public AdminDashboard()
    {
        iconFrame = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/TravelMatrixApp.png"));
        
        //tabbedpane icon
        userIcon = new ImageIcon(new ImageIcon("image/usericon.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        tripIcon = new ImageIcon(new ImageIcon("image/tripicon.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        bookIcon = new ImageIcon(new ImageIcon("image/bookicon.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        
        //pane img
        userBg = new ImageIcon(new ImageIcon("image/userMana.png").getImage().getScaledInstance(890, 660, Image.SCALE_SMOOTH));
        bookingbg = new ImageIcon(new ImageIcon("image/bookingmana.png").getImage().getScaledInstance(890, 660, Image.SCALE_SMOOTH));
        tripbg = new ImageIcon(new ImageIcon("image/tripmana.png").getImage().getScaledInstance(890, 660, Image.SCALE_SMOOTH));


        admindashF = new JFrame();

        //userMana
        adminPane = new JTabbedPane();
        adminPane.setTabPlacement(JTabbedPane.LEFT);
        adminPane.setFont(new Font("Poppins",Font.PLAIN,25));
        adminPane.setBackground(new Color(51,61,84));
        adminPane.setForeground(Color.WHITE);

        logoutB = new JButton("Logout");
        logoutB.setBounds(50,600,250,50);
        logoutB.setFont(new  Font("Poppins", Font.BOLD,20));
        logoutB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logoutB.setBackground(new Color(51,61,84));
        logoutB.setFocusable(false);
        logoutB.setBorderPainted(false);
        logoutB.setForeground(Color.WHITE);
        logoutB.addActionListener(this);
        
        adduser = new JButton("Add New User");
        adduser.setBounds(600,100,250,50);
        adduser.setFont(new  Font("Poppins", Font.BOLD,20));
        adduser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        adduser.setBackground(Color.white);
        adduser.setFocusable(false);
        adduser.setBorderPainted(false);
        adduser.setForeground(new Color(51,61,84));
        adduser.addActionListener(this);
        

        edituser = new JButton("Edit User");
        edituser.setBounds(600,170,250,50);
        edituser.setFont(new  Font("Poppins", Font.BOLD,20));
        edituser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        edituser.setBackground(Color.white);
        edituser.setFocusable(false);
        edituser.setBorderPainted(false);
        edituser.setForeground(new Color(51,61,84));
        edituser.addActionListener(this);



        searchuserB = new JButton("Search User");
        searchuserB.setBounds(600,240,250,50);
        searchuserB.setFont(new  Font("Poppins", Font.BOLD,20));
        searchuserB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchuserB.setBackground(Color.white);
        searchuserB.setFocusable(false);
        searchuserB.setBorderPainted(false);
        searchuserB.setForeground(new Color(51,61,84));
        searchuserB.addActionListener(this);

        removeuser = new JButton("Remove User");
        removeuser.setBounds(600,310,250,50);
        removeuser.setFont(new  Font("Poppins", Font.BOLD,20));
        removeuser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        removeuser.setBackground(Color.white);
        removeuser.setFocusable(false);
        removeuser.setBorderPainted(false);
        removeuser.setForeground(new Color(51,61,84));
        removeuser.addActionListener(this);

        showAlluser = new JButton("Show Users");
        showAlluser.setBounds(600,380,250,50);
        showAlluser.setFont(new  Font("Poppins", Font.BOLD,20));
        showAlluser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        showAlluser.setBackground(Color.white);
        showAlluser.setFocusable(false);
        showAlluser.setBorderPainted(false);
        showAlluser.setForeground(new Color(51,61,84));
        showAlluser.addActionListener(this);

        userPanel = new JPanel();
        userLabel = new JLabel(userBg);
        userLabel.setBounds(0, 0, 890, 660);
        userPanel.add(userLabel);
        userLabel.add(adduser);
        userLabel.add(edituser);
        userLabel.add(removeuser);
        userLabel.add(searchuserB);
        userLabel.add(showAlluser);

        //booking managment

        bookingPanel = new JPanel();
        bookLabel = new JLabel(bookingbg);
        bookLabel.setBounds(0, 0, 890, 660);
        bookingPanel.add(bookLabel);


        //trip managment
        addTRPack = new JButton("Add New Package");
        addTRPack.setBounds(50,120,250,50);
        addTRPack.setFont(new  Font("Poppins", Font.BOLD,20));
        addTRPack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addTRPack.setBackground(Color.white);
        addTRPack.setFocusable(false);
        addTRPack.setBorderPainted(false);
        addTRPack.setForeground(new Color(51,61,84));
        addTRPack.addActionListener(this);


        showTRPack = new JButton("Show Packages");
        showTRPack.setBounds(320,120,250,50);
        showTRPack.setFont(new  Font("Poppins", Font.BOLD,20));
        showTRPack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        showTRPack.setBackground(Color.white);
        showTRPack.setFocusable(false);
        showTRPack.setBorderPainted(false);
        showTRPack.setForeground(new Color(51,61,84));
        showTRPack.addActionListener(this);



        searchTRPack = new JButton("Search Package");
        searchTRPack.setBounds(590,120,250,50);
        searchTRPack.setFont(new  Font("Poppins", Font.BOLD,20));
        searchTRPack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchTRPack.setBackground(Color.white);
        searchTRPack.setFocusable(false);
        searchTRPack.setBorderPainted(false);
        searchTRPack.setForeground(new Color(51,61,84));
        searchTRPack.addActionListener(this);


        tripPanel = new JPanel();
        tripLabel = new JLabel(tripbg);
        tripPanel.add(tripLabel);
        tripLabel.setBounds(0, 0, 890, 660);
        tripLabel.add(addTRPack);
        tripLabel.add(showTRPack);
        tripLabel.add(searchTRPack);







        adminPane.addTab("User Management",userIcon, userPanel);
        adminPane.addTab("Trip Management",tripIcon, tripPanel);
        adminPane.addTab("Booking Management",bookIcon, bookingPanel);
    
        admindashF.add(logoutB);
        admindashF.add(adminPane);


        // admindashF.setLayout(null);
        admindashF.setTitle("Travel Matrix | Admin Dashboard");
        admindashF.setSize(1260, 700);
        admindashF.setIconImage(iconFrame);
        admindashF.setVisible(true);
        admindashF.setResizable(false);
        admindashF.setLocationRelativeTo(null);
        admindashF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }   

    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==logoutB)
        {
            new Login();
            admindashF.dispose();
        }

        else if(e.getSource()==edituser)
        {
            new EditUser();
        }

        else if(e.getSource()==adduser)
        {
            new  AddUser();
            admindashF.dispose();
        }
        else if (e.getSource()== searchuserB)
        {
            new SearchUser();
        }
        else if (e.getSource()== removeuser)
        {
            new RemoveUser();
        }
        else if (e.getSource()==showAlluser)
        {
            new ShowUsers();
            admindashF.dispose();
        }
        else if (e.getSource() == addTRPack)
        {
            new AddPackage();
            admindashF.dispose();
        }
        else if (e.getSource()==showTRPack)
        {
            new ShowPackage();
            admindashF.dispose();
        }
        else if (e.getSource() == searchTRPack)
        {
            admindashF.dispose();
            new ManagePackage();
        }
    }

    

}
