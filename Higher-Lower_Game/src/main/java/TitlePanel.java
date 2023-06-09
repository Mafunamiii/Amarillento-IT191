
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jahn
 */
public class TitlePanel extends JPanel {
    
    public TitlePanel() {
        JLabel titleLabel = new JLabel("Higher - Lower Game");
        
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);
        
        ImageIcon icon = new ImageIcon("src/main/java/Resources/hiloLogo.png");
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(image);
        
        JLabel logo = new JLabel(resizedIcon);
        
        setBackground(new Color(205,208,246));
        add(logo, BorderLayout.WEST);
        add(titleLabel, BorderLayout.WEST);

    }
}
