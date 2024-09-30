package Classes.AdminOperations.PackageManagement;

import Classes.Entity.TrPackage;
import Classes.UI.Dashboards.AdminDashboard;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AddPackage implements  ActionListener
{

        
    private JFrame addPackageF;
    private Image iconFrame;
    private JLabel addPackimg,addPackL,packIDL,packNameL, packImg,packDetailsL,transpL,hotelL,priceL;
    private  JTextField packIDT, packNameT,packDetailsT,transpT,hotelT, priceT;
    private  JButton backButton, openButton,addPackB;
    private  String pathImg="";
    private  TrPackage newPackage ;
    public AddPackage()
    {
        iconFrame = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/TravelMatrixApp.png"));
        addPackageF = new JFrame();


        addPackL = new JLabel("Add Package");
        addPackL.setBounds(800,110,250,50);
        addPackL.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(51,61,84)));
        addPackL.setForeground(new Color(51, 61, 84));
        addPackL.setFont(new Font("Poppins", Font.BOLD, 35));

        addPackimg = new JLabel();
        addPackimg.setIcon(new ImageIcon(new ImageIcon("image/addPackage.png").getImage().getScaledInstance(1260, 700, Image.SCALE_SMOOTH)));
        addPackimg.setBounds(0, 0, 1260, 700);


        packIDL = new JLabel("Package ID: ");
        packIDL.setBounds(650,190,350,35);
        packIDL.setForeground(new Color(51, 61, 84));
        packIDL.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));

        packIDT = new JTextField();
        packIDT.setBounds(810,190,350,35);
        packIDT.setForeground(new Color(51, 61, 84));
        packIDT.setFont(new Font("Segoe UI", Font.PLAIN, 20));


        packNameL = new JLabel("Package Name: ");
        packNameL.setBounds(650,235,350,35);
        packNameL.setForeground(new Color(51, 61, 84));
        packNameL.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));

        packNameT = new JTextField();
        packNameT.setBounds(810,235,350,35);
        packNameT.setForeground(new Color(51, 61, 84));
        packNameT.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        openButton = new JButton("Add Image");
        openButton.setBounds(830,275,220,45);
        openButton.setFont(new  Font("Poppins", Font.PLAIN,20));
        openButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        openButton.setBackground(new Color(51,61,84));
        openButton.setFocusable(false);
        openButton.setBorderPainted(false);
        openButton.setForeground(Color.WHITE);
        openButton.addActionListener(this);
        

        packDetailsL = new JLabel("Package Details: ");
        packDetailsL.setBounds(650,225,350,35);
        packDetailsL.setForeground(new Color(51, 61, 84));
        packDetailsL.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));

        packDetailsT = new JTextField();
        packDetailsT.setBounds(810,225,350,35);
        packDetailsT.setForeground(new Color(51, 61, 84));
        packDetailsT.setFont(new Font("Segoe UI", Font.PLAIN, 20));


        packImg = new JLabel("                   No Image Selected");
        packImg.setBounds(830, 330, 200, 100);



        
        packDetailsL = new JLabel("Package Details: ");
        packDetailsL.setBounds(650,440,350,35);
        packDetailsL.setForeground(new Color(51, 61, 84));
        packDetailsL.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));

        packDetailsT = new JTextField();
        packDetailsT.setBounds(810,440,350,35);
        packDetailsT.setForeground(new Color(51, 61, 84));
        packDetailsT.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        transpL = new JLabel("Transport: ");
        transpL.setBounds(650,485,350,35);
        transpL.setForeground(new Color(51, 61, 84));
        transpL.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));

        transpT = new JTextField();
        transpT.setBounds(810,485,350,35);
        transpT.setForeground(new Color(51, 61, 84));
        transpT.setFont(new Font("Segoe UI", Font.PLAIN, 20));


        hotelL = new JLabel("Hotel: ");
        hotelL.setBounds(650,530,350,35);
        hotelL.setForeground(new Color(51, 61, 84));
        hotelL.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));

        hotelT = new JTextField();
        hotelT.setBounds(810,530,350,35);
        hotelT.setForeground(new Color(51, 61, 84));
        hotelT.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        priceL = new JLabel("Price: ");
        priceL.setBounds(650,575,350,35);
        priceL.setForeground(new Color(51, 61, 84));
        priceL.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));

        priceT = new JTextField();
        priceT.setBounds(810,575,350,35);
        priceT.setForeground(new Color(51, 61, 84));
        priceT.setFont(new Font("Segoe UI", Font.PLAIN, 20));


        backButton = new JButton();
        backButton.setBounds(30, 30, 50, 50);
        backButton.setOpaque(false);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setIcon(new ImageIcon(new ImageIcon("image/BackWhite.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        backButton.addActionListener(this);

        addPackB = new JButton("Add Package");
        addPackB.setBounds(830,620,220,45);
        addPackB.setFont(new  Font("Poppins", Font.PLAIN,20));
        addPackB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addPackB.setBackground(new Color(51,61,84));
        addPackB.setFocusable(false);
        addPackB.setBorderPainted(false);
        addPackB.setForeground(Color.WHITE);
        addPackB.addActionListener(this);

        addPackageF.add(addPackL);
        addPackageF.add(packIDL);
        addPackageF.add(openButton);
        addPackageF.add(packNameL);
        addPackageF.add(packNameT);
        addPackageF.add(backButton);
        addPackageF.add(packImg);
        addPackageF.add(packDetailsT);
        addPackageF.add(hotelL);
        addPackageF.add(hotelT);
        addPackageF.add(priceL);
        addPackageF.add(priceT);
        addPackageF.add(addPackB);
        addPackageF.add(transpL);
        addPackageF.add(transpT);
        addPackageF.add(packDetailsL);
        addPackageF.add(packIDT);
        addPackageF.add(addPackimg);


        addPackageF.setLayout(null);
        addPackageF.setTitle("Travel Matrix | Add Package");
        addPackageF.setSize(1275, 730);
        addPackageF.setIconImage(iconFrame);
        addPackageF.setResizable(false);
        addPackageF.setVisible(true);
        addPackageF.setLocationRelativeTo(null);
        addPackageF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private boolean isPackIdExists(String packID) {
        try {
            File file = new File("./Data/packagedata.txt");
            if (!file.exists()) {
                return false;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(packID)) {
                    reader.close();
                    return true;
                }
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

     private void register() {
        String packId = packIDT.getText();
        String packName = packNameT.getText();
        String packImgS = packImg.getText();
        String packDetails = packDetailsT.getText();
        String transS = transpT.getText();
        String hotelS = hotelT.getText();
        
        String price = priceT.getText();
        // Check for empty fields
        if (packId.isEmpty() || packName.isEmpty() || pathImg.isEmpty() || packImgS.equals("                   No Image Selected") || packDetails.isEmpty() || transS.isEmpty() || hotelS.isEmpty()  || price.isEmpty() ) 
        {
            JOptionPane.showMessageDialog(addPackageF, "Please fill all fields!");
            return;
            
        }

        // Check for existing email
        if (isPackIdExists(packId)) {
            JOptionPane.showMessageDialog(addPackageF, "Package with same ID already exists!");
            return;
        }
        try 
            {
                double priceD = Double.parseDouble(priceT.getText());

                
                 newPackage = new TrPackage(packId, packName, pathImg, packDetails,transS,hotelS,priceD);

            } 
            catch (Exception e1) 
            {
                JOptionPane.showMessageDialog(addPackageF, "Please Enter Number in price!");

            }

        try {
            FileWriter writer = new FileWriter("./Data/packagedata.txt", true);
            writer.write(newPackage.getPackageId() + "," + newPackage.getPackageName() + "," + newPackage.getPackageImgPath() + "," + newPackage.getPackageDetails() + "," + newPackage.getTransport() + "," +newPackage.getHotel() + "," + newPackage.getPrice() + "\n");
            writer.close();
            JOptionPane.showMessageDialog(null, "Package Added Successful!");
            addPackageF.dispose();
            new AdminDashboard();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    public void ImgAdd(){
        JFileChooser fileChooser = new JFileChooser();

            fileChooser.setDialogTitle("Select a File");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); 
            fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files (jpg, jpeg, png, gif, bmp)", "jpg", "jpeg", "png", "gif", "bmp"));
            int result = fileChooser.showOpenDialog(addPackageF);
            
            if (result == JFileChooser.APPROVE_OPTION) 
                { // Get the selected file
                    File selectedFile = fileChooser.getSelectedFile();
                    File targetDirectory = new File("./Image/locationPic"); // Replace with your target directory
                    // Ensure the directory exists
                    if (!targetDirectory.exists()) 
                    {
                        targetDirectory.mkdirs(); // Create the directory if it doesn't exist
                    }
                    
                    // Create a target file in the target directory with the same name as the selected file
                    File targetFile = new File(targetDirectory, selectedFile.getName());
                    
                    // Copy the file
                    try 
                    {
                        Files.copy(selectedFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        // Display a success message
                        ImageIcon icon = new ImageIcon(targetFile.getPath());
                        Image scaledImage = icon.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
                        icon = new ImageIcon(scaledImage);
                        pathImg = targetFile.getPath();
                        packImg.setText("");
                        packImg.setIcon(icon);
                    } 
                    catch (IOException ex) 
                    {
                        // Handle any errors during the file copy
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Failed to copy file: " + ex.getMessage());
                    }
                }
            
            else 
            {
                JOptionPane.showMessageDialog(addPackageF, "No file selected");
            }
    }

    public void  actionPerformed(ActionEvent e)
    {
        if(e.getSource() == backButton)
        {
            new AdminDashboard();
            addPackageF.dispose();
        }
        else if(e.getSource() == addPackB)
        {
            register();
        }
        else if(e.getSource() == openButton)
        {
            ImgAdd();
        }
    }
   
}
