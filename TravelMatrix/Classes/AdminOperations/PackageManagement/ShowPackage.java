package Classes.AdminOperations.PackageManagement;

import Classes.UI.Dashboards.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class ShowPackage extends JFrame implements ActionListener {
    private JLabel showallPkgImg;
    private JTable packageTable;
    private JButton backB;
    private final String filePath = "./Data/packagedata.txt"; 

    public ShowPackage() {
        showallPkgImg = new JLabel();
        showallPkgImg.setIcon(new ImageIcon(new ImageIcon("image/showPackage.png").getImage().getScaledInstance(1260, 700, Image.SCALE_SMOOTH)));
        showallPkgImg.setBounds(0, 0, 1260, 700);

        setTitle("Travel Matrix | Show All Packages");
        setSize(1270, 735);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/TravelMatrixApp.png")));

        String[] columnNames = {"ID", "Name", "Image", "Details", "Transportation", "Hotel", "Cost"};
        Object[][] data = fetchPackageData();

        packageTable = new JTable(data, columnNames) {
            @Override
            public String getToolTipText(java.awt.event.MouseEvent e) {
                int row = rowAtPoint(e.getPoint());
                int col = columnAtPoint(e.getPoint());
                Object value = getValueAt(row, col);
                
                if (col != 2 && value != null) { // No tooltip for the Image column (index 2)
                    return value.toString();
                }
                return null; // No tooltip for image cells or null values
            }
        };

        // Setting a custom renderer for the image column (index 2)
        packageTable.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value instanceof ImageIcon) {
                    JLabel label = new JLabel();
                    label.setIcon((ImageIcon) value);
                    return label;
                }
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        });

        packageTable.setFont(new Font("Poppins", Font.PLAIN, 16));
        packageTable.setRowHeight(100);
        packageTable.setBackground(Color.WHITE);
        packageTable.setForeground(new Color(51, 61, 84));
        packageTable.setEnabled(false);

        JTableHeader header = packageTable.getTableHeader();
        header.setFont(new Font("Poppins", Font.BOLD, 18));
        header.setBackground(new Color(51, 61, 84));
        header.setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(packageTable);
        scrollPane.setBounds(60, 140, 1128, 465);
        add(scrollPane);

        backB = new JButton();
        backB.setBounds(30, 30, 50, 50);
        backB.setIcon(new ImageIcon(new ImageIcon("image/BackWhite.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        backB.setOpaque(false);
        backB.setBorderPainted(false);
        backB.setContentAreaFilled(false);
        backB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backB.addActionListener(this);
        
        add(backB);
        add(showallPkgImg);
        setVisible(true);
    }

    private Object[][] fetchPackageData() {
        Object[][] packageData = new Object[100][7]; // Fixed array for up to 100 packages
        int index = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] packageInfo = line.split(",");
                if (packageInfo.length == 7 && index < packageData.length) {
                    packageData[index][0] = packageInfo[0]; // ID
                    packageData[index][1] = packageInfo[1]; // Name
                    packageData[index][2] = new ImageIcon(new ImageIcon(packageInfo[2]).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)); // Image
                    packageData[index][3] = packageInfo[3]; // Details
                    packageData[index][4] = packageInfo[4]; // Transportation
                    packageData[index][5] = packageInfo[5]; // Hotel
                    packageData[index][6] = packageInfo[6]; // Cost
                    index++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return packageData;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backB) {
            new AdminDashboard();
            dispose();
        }
    }
}
