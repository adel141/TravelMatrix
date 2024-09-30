package Classes.UI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AboutUs implements ActionListener
{
    private JFrame aboutUsF;
    private JLabel aboutUsJ;
    private JButton  closeB;
    private Image aboutUsI;
    private Image iconFrame;

    public AboutUs()
    { 

        iconFrame = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/TravelMatrixApp.png"));
        aboutUsF = new JFrame("Travel Matrix | About Us");

        aboutUsJ = new JLabel();
        aboutUsJ.setIcon(new ImageIcon(new ImageIcon("image/AboutUs.png").getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH)));
        aboutUsJ.setBounds(0, 0, 500, 500);
        closeB = new JButton("X");
        closeB.setFont(new Font("Poppins",Font.BOLD,50));
        closeB.setBounds(420,-20,100,100);
        closeB.setContentAreaFilled(false);
        closeB.addActionListener(this);

        closeB.setOpaque(false);
        closeB.setBorderPainted(false);
        closeB.setFocusable(false);

        aboutUsF.add(closeB);
        aboutUsF.add(aboutUsJ);
        
        aboutUsF.setUndecorated(true);
        aboutUsF.setLayout(null);
        aboutUsF.setSize(500, 500);
        aboutUsF.setVisible(true);
        aboutUsF.setIconImage(iconFrame);
        aboutUsF.setResizable(true);
        aboutUsF.setLocationRelativeTo(null);
        
    }

    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == closeB)
        {
            aboutUsF.dispose();
        }
    }

    

}
