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

public class ManagePackage extends PackageOperations implements ActionListener
{
    private JFrame ManagePackF;
    private JLabel ManagePackL,packIDL,packNameL, packImg,packDetailsL,transpL,hotelL,priceL;;
    private  JTextField packIDT, packNameT,packDetailsT,transpT,hotelT, priceT;
    private JButton backB, editB, searchB, openButton, saveB, removeB;
    private Image iconFrame;
    private TrPackage currentTrPackage;
    private  String pathImg="";



    
    public ManagePackage()
    
    {
        iconFrame = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/TravelMatrixApp.png"));

        
        ManagePackF = new JFrame();
        
        
        ManagePackL = new JLabel();
        ManagePackL.setIcon(new ImageIcon(new ImageIcon("image/manaPack.png").getImage().getScaledInstance(1260, 700, Image.SCALE_SMOOTH)));
        ManagePackL.setBounds(0,0,1260,700);



        packIDL = new JLabel("Package ID: ");
        packIDL.setBounds(405,105,350,35);
        packIDL.setForeground(new Color(51, 61, 84));
        packIDL.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));


        packIDT = new JTextField();
        packIDT.setBounds(565,105,350,35);
        packIDT.setForeground(new Color(51, 61, 84));
        packIDT.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        searchB = new JButton("Search");
        searchB.setBounds(442,150,150,45);
        searchB.setFont(new  Font("Poppins", Font.PLAIN,20));
        searchB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchB.setBackground(new Color(51,61,84));
        searchB.setFocusable(false);
        searchB.setBorderPainted(false);
        searchB.setForeground(Color.WHITE);
        searchB.addActionListener(this);

        editB = new JButton("Edit");
        editB.setBounds(710,150,150,45);
        editB.setFont(new  Font("Poppins", Font.PLAIN,20));
        editB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        editB.setBackground(new Color(51,61,84));
        editB.setFocusable(false);
        editB.setBorderPainted(false);
        editB.setEnabled(false);
        editB.setForeground(Color.WHITE);
        editB.addActionListener(this);

        packNameL = new JLabel("Package Name: ");
        packNameL.setBounds(405,205,350,35);
        packNameL.setForeground(new Color(51, 61, 84));
        packNameL.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));

        packNameT = new JTextField();
        packNameT.setBounds(565,205,350,35);
        packNameT.setForeground(new Color(51, 61, 84));
        packNameT.setEnabled(false);
        packNameT.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        
        
        
        
        packImg = new JLabel("                   No Image Selected");
        packImg.setBounds(585, 250, 200, 100);

        openButton = new JButton("Change Image");
        openButton.setBounds(585,360,220,45);
        openButton.setFont(new  Font("Poppins", Font.PLAIN,20));
        openButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        openButton.setBackground(new Color(51,61,84));
        openButton.setFocusable(false);
        openButton.setBorderPainted(false);
        openButton.setForeground(Color.WHITE);
        openButton.setEnabled(false);
        openButton.addActionListener(this);
        
        
        
        packDetailsL = new JLabel("Package Details: ");
        packDetailsL.setBounds(405,415,350,35);
        packDetailsL.setForeground(new Color(51, 61, 84));
        packDetailsL.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));

        packDetailsT = new JTextField();
        packDetailsT.setBounds(565,415,350,35);
        packDetailsT.setForeground(new Color(51, 61, 84));
        packDetailsT.setEnabled(false);
        packDetailsT.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        transpL = new JLabel("Transport: ");
        transpL.setBounds(405,460,350,35);
        transpL.setForeground(new Color(51, 61, 84));
        transpL.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));

        transpT = new JTextField();
        transpT.setEnabled(false);
        transpT.setBounds(565,460,350,35);
        transpT.setForeground(new Color(51, 61, 84));
        transpT.setFont(new Font("Segoe UI", Font.PLAIN, 20));


        hotelL = new JLabel("Hotel: ");
        hotelL.setBounds(405,505,350,35);
        hotelL.setForeground(new Color(51, 61, 84));
        hotelL.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));

        hotelT = new JTextField();
        hotelT.setBounds(565,505,350,35);
        hotelT.setForeground(new Color(51, 61, 84));
        hotelT.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        hotelT.setEnabled(false);

        priceL = new JLabel("Price: ");
        priceL.setBounds(405,550,350,35);
        priceL.setForeground(new Color(51, 61, 84));
        priceL.setFont(new Font("Segoe UI SemiBold", Font.PLAIN, 20));

        priceT = new JTextField();
        priceT.setBounds(565,550,350,35);
        priceT.setForeground(new Color(51, 61, 84));
        priceT.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        priceT.setEnabled(false);


        saveB = new JButton("Save");
        saveB.setBounds(442,595,150,45);
        saveB.setFont(new  Font("Poppins", Font.PLAIN,20));
        saveB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        saveB.setBackground(new Color(51,61,84));
        saveB.setFocusable(false);
        saveB.setBorderPainted(false);
        saveB.setEnabled(false);
        saveB.setForeground(Color.WHITE);
        saveB.addActionListener(this);


        removeB = new JButton("Remove");
        removeB.setBounds(710,595,150,45);
        removeB.setFont(new  Font("Poppins", Font.PLAIN,20));
        removeB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        removeB.setBackground(new Color(51,61,84));
        removeB.setFocusable(false);
        removeB.setBorderPainted(false);
        removeB.setEnabled(false);
        removeB.setForeground(Color.WHITE);
        removeB.addActionListener(this);

        backB = new JButton();
        backB.setBounds(30, 30, 50, 50);
        backB.setOpaque(false);
        backB.setBorderPainted(false);
        backB.setContentAreaFilled(false);
        backB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backB.setIcon(new ImageIcon(new ImageIcon("image/BackTheme.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        backB.addActionListener(this);


        ManagePackF.add(saveB);
        ManagePackF.add(removeB);
        ManagePackF.add(backB);
        ManagePackF.add(searchB);
        ManagePackF.add(editB);
        ManagePackF.add(packIDL);
        ManagePackF.add(openButton);
        ManagePackF.add(packNameL);
        ManagePackF.add(packNameT);
        ManagePackF.add(packImg);
        ManagePackF.add(packDetailsT);
        ManagePackF.add(hotelL);
        ManagePackF.add(hotelT);
        ManagePackF.add(priceL);
        ManagePackF.add(priceT);
        ManagePackF.add(transpL);
        ManagePackF.add(transpT);
        ManagePackF.add(packDetailsL);
        ManagePackF.add(packIDT);
        
        ManagePackF.add(ManagePackL);


        ManagePackF.setLayout(null);
        ManagePackF.setTitle("Travel Matrix | Manage Package");
        ManagePackF.setSize(1260, 720);
        ManagePackF.setIconImage(iconFrame);
        ManagePackF.setVisible(true);
        ManagePackF.setResizable(false);
        ManagePackF.setLocationRelativeTo(null);
        ManagePackF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == backB)
        {
            new AdminDashboard();
            ManagePackF.dispose();
        }
        else if(e.getSource() == searchB)
        {
            searchPackage(packIDT.getText());
        }
        else if(e.getSource() == editB)
        {
            saveB.setEnabled(true);
            packIDT.setEnabled(false);
            packDetailsT.setEnabled(true);
            packNameT.setEnabled(true);
            removeB.setEnabled(false);
            transpT.setEnabled(true);
            hotelT.setEnabled(true);
            openButton.setEnabled(true);
            priceT.setEnabled(true);
        }
        else if(e.getSource() == openButton)
        {
            ImgAdd();
        }
        else if(e.getSource() == saveB)
        {
            editPackage();
            new AdminDashboard();
            ManagePackF.dispose();
        }
        else if(e.getSource() == removeB)
        {
            removePackage();
            new AdminDashboard();
            ManagePackF.dispose();
        }
    }
    public void ImgAdd(){
        JFileChooser fileChooser = new JFileChooser();

            fileChooser.setDialogTitle("Select a File");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); 
            fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files (jpg, jpeg, png, gif, bmp)", "jpg", "jpeg", "png", "gif", "bmp"));
            int result;
        result = fileChooser.showOpenDialog(ManagePackF);
            
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
                JOptionPane.showMessageDialog(ManagePackF, "No file selected");
            }
    }

    public  void editPackage() {
        String packId = packIDT.getText();
        String packName = packNameT.getText();
        String packDetails = packDetailsT.getText();
        String transS = transpT.getText();
        String hotelS = hotelT.getText();
        String price = priceT.getText();
    
        // Check for empty fields
        if (packId.isEmpty() || packName.isEmpty() || pathImg.isEmpty() || packDetails.isEmpty() || transS.isEmpty() || hotelS.isEmpty() || price.isEmpty()) {
            JOptionPane.showMessageDialog(ManagePackF, "Please fill all fields!");
            return;
        }
    
        // Ensure there's a current package to save
        if (currentTrPackage != null) {
            try {
                File inputFile = new File("./Data/packagedata.txt");
                File tempFile = new File("./Data/temp_packagedata.txt");
    
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
                String line;
                boolean found = false;
    
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts[0].equals(currentTrPackage.getPackageId())) {
                        // Update the current package data
                        currentTrPackage = new TrPackage(packId, packName, pathImg, packDetails,transS,hotelS,Double.parseDouble(price)); 
   
                        writer.write(currentTrPackage.getPackageId() + "," + currentTrPackage.getPackageName() + "," + currentTrPackage.getPackageImgPath() + "," + currentTrPackage.getPackageDetails() + "," + currentTrPackage.getTransport() + "," +currentTrPackage.getHotel() + "," + currentTrPackage.getPrice());

                        found = true;
                    } else {
                        writer.write(line);
                    }
                    writer.newLine();
                }
                writer.close();
                reader.close();
    
                // Replace the original file with the updated one
                if (found) {
                    inputFile.delete();
                    tempFile.renameTo(inputFile);
                    JOptionPane.showMessageDialog(ManagePackF, "Package data saved successfully!");
                } else {
                    JOptionPane.showMessageDialog(ManagePackF, "Package ID not found. Unable to save.");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(ManagePackF, "Error saving package data: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(ManagePackF, "No package selected to save.");
        }
    }
    
    // Delete Package Data Method
    public void removePackage() {
        if (currentTrPackage != null) { // Ensure there's a current package to delete
            try {
                File inputFile = new File("./Data/packagedata.txt");
                File tempFile = new File("./Data/temp_packagedata.txt");
                
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
                String line;
                boolean found = false;
    
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (!parts[0].equals(currentTrPackage.getPackageId())) {
                        writer.write(line);
                        writer.newLine();
                    } else {
                        found = true; // Mark that the package was found and deleted
                    }
                }
                writer.close();
                reader.close();
                // Replace the original file with the updated one
                if (found) {
                    inputFile.delete();
                    tempFile.renameTo(inputFile);
                    JOptionPane.showMessageDialog(ManagePackF, "Package deleted successfully!");
                    // Reset the form fields after deletion
                    // ManagePackF.dispose();
                } else {
                    JOptionPane.showMessageDialog(ManagePackF, "Package ID not found. Unable to delete.");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(ManagePackF, "Error deleting package data: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(ManagePackF, "No package selected to delete.");
        }
    }


    public void searchPackage(String searchPackId) {
        if (!searchPackId.isEmpty()) {
            try (BufferedReader br = new BufferedReader(new FileReader("./Data/packagedata.txt"))) {
                String line;
                boolean found = false;

                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts[0].equals(searchPackId)) {
                        found = true;
                        currentTrPackage = new TrPackage(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], Double.parseDouble(parts[6]));
                        packNameT.setText(currentTrPackage.getPackageName());
                        packDetailsT.setText(currentTrPackage.getPackageDetails());
                        transpT.setText(currentTrPackage.getTransport());
                        hotelT.setText(currentTrPackage.getHotel());
                        priceT.setText(String.valueOf(currentTrPackage.getPrice()));
                        pathImg = currentTrPackage.getPackageImgPath();

                        ImageIcon icon = new ImageIcon(currentTrPackage.getPackageImgPath());
                        Image scaledImage = icon.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
                        icon = new ImageIcon(scaledImage);
                        packImg.setIcon(icon);
                        editB.setEnabled(true);
                        removeB.setEnabled(true);
                        break;
                    }
                }

                if (!found) {
                    JOptionPane.showMessageDialog(ManagePackF, "No package found with the given ID.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else 
        {
            JOptionPane.showMessageDialog(ManagePackF, "Please enter a valid Package ID.");
        }
    }
}
