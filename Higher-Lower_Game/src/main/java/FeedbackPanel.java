
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


/**
 *
 * @author Jahn
 */
public class FeedbackPanel extends JPanel {

    JLabel resultLabel;
    private JTextPane feedbackTextpane;
    private StyledDocument doc;
    
    
    
    public FeedbackPanel() {
        
        setBackground(new Color(205,208,246));
        setLayout(new BorderLayout());
        
        feedbackTextpane = new JTextPane();
        feedbackTextpane.setText("<<< Welcome! Press the Start button to begin >>>\n");
        
        feedbackTextpane.setPreferredSize(new Dimension(300,200));
        feedbackTextpane.setEditable(false);
        feedbackTextpane.setBackground(Color.WHITE);       
        
        resultLabel = new JLabel("Result: ");
        add(resultLabel, BorderLayout.NORTH);
        
        JScrollPane scrollPane = new JScrollPane(feedbackTextpane);
        add(scrollPane, BorderLayout.CENTER);

        doc = feedbackTextpane.getStyledDocument();
    }
      
    public void appendText(String text, Color color) {
        Style style = feedbackTextpane.addStyle("FeedbackStyle", null);
        StyleConstants.setForeground(style, color);

        try {
            doc.insertString(doc.getLength(), text + "\n", style);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        // Scroll to the bottom
        feedbackTextpane.setCaretPosition(doc.getLength());
    }
    
    public void resetText () {
        feedbackTextpane.setText("");
    }
}
