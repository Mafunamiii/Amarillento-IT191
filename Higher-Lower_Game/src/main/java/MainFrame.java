
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


/**
 *
 * @author Jahn
 */
public class MainFrame extends JFrame{
    TitlePanel titlePanel;
    InputPanel guessPanel;
    FeedbackPanel resultPanel;

        
    JLabel titleLabel, logo;
    
    Random random = new Random();
    private Timer timer;
    private int timeElapsed = 0;
    private int timeLimit = 120;
    private int target, guessAttempts;
    

    
    public MainFrame () {
        super("Hi-Lo");
        
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/java/Resources/hiloLogo.png"));
        
        titlePanel = new TitlePanel();
        titlePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(titlePanel, BorderLayout.NORTH);
        
        guessPanel = new InputPanel();
        guessPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 25, 10));
        
        add(guessPanel, BorderLayout.WEST);
        
        guessPanel.setFormListener(new FormListener() {
            public void formEventOccurred(FormEvent e) {
                int guess = e.getGuess();
                
                resultPanel.appendText(Integer.toString(guess));
            }
        });
        
        resultPanel = new FeedbackPanel();
        resultPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 25, 10));

        add(resultPanel, BorderLayout.EAST);
        
        JLabel footerLabel = new JLabel("J.Amarillento");
        footerLabel.setHorizontalAlignment(JLabel.LEFT);
        footerLabel.setBackground(new Color(205,208,246));
        footerLabel.setOpaque(true);
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 10));
        footerLabel.setBorder(BorderFactory.createEmptyBorder(10, 5, 5, 10));
        
        add(footerLabel, BorderLayout.PAGE_END);
        
        setSize(300,300);
        setVisible(true);
        this.pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() { new MainFrame(); }
        });
    }
}
