
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jahn
 */
public class FeedbackPanel extends JPanel {

    JLabel resultLabel;
    JTextArea result;
    
    public FeedbackPanel() {
        
        setBackground(new Color(205,208,246));
        setLayout(new BorderLayout());
        
        resultLabel = new JLabel("Result: ");
        add(resultLabel, BorderLayout.NORTH);
        result = new JTextArea(5, 25);      
        add(new JScrollPane(result), BorderLayout.CENTER);
            
    }
    
    public void appendText(String text) {
        result.append(text + "\n" + "\r");
    }
    
}
