
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
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
       
    Random random = new Random();

    private int target;
    private Boolean start = false;
    
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
                int guess = 0;
                if (e.getStart()) {
                    start = true;
                    resultPanel.resetText();
                    target = random.nextInt(100);
                    System.out.println("Number: " + target);
                    resultPanel.appendText("Game Start!", new Color(20,22,101));
                } else if (start == false) {
                    resultPanel.appendText("\nGame not started! Press Start to begin", new Color(20,22,101));
                } else {
                    guess = e.getGuess();
                    if (guess > target) {
                        resultPanel.appendText("Your guess is HIGHER than the target", new Color(13,138,56));
                    } else if (guess < target) {
                        resultPanel.appendText("Your guess is LOWER than the target", Color.RED);
                    } else {
                        resultPanel.appendText("== Congratulations, your guess is correct! ==", new Color(204,138,0));
                        start = false;
                    }
                }
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
        setLocationRelativeTo(null); // Center the frame on the screen
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
