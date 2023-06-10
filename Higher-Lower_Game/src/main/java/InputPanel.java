
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

/**
 *
 * @author Jahn
 */

public class InputPanel extends JPanel{
    private JLabel enterLabel;
    private JTextField guessTextfield;
    private JButton startButton, enterGuessButton;
    private FormListener formListener;
    
    public void setFormListener(FormListener formListener) {
        this.formListener = formListener;
    }
    
    public class invalidGuessException extends Exception {
        public invalidGuessException(String message) {
            super(message);
        }
    }
    
    public InputPanel() {
        GridBagLayout gridbag=new GridBagLayout();
        GridBagConstraints gbconstraints=new GridBagConstraints();
        gbconstraints.insets=new Insets(5,5,5,5);
        setLayout(gridbag);
        setBorder(BorderFactory.createTitledBorder("Hi-Lo"));
        setBackground(new Color(205,208,246));
        
        enterLabel = new JLabel ("Enter Guess [1-100]: ");
        gbconstraints.anchor=GridBagConstraints.FIRST_LINE_END;
        gbconstraints.gridx=0;
        gbconstraints.gridy=1;
        gbconstraints.gridheight=1;
        gbconstraints.gridwidth=1;
        add(enterLabel,gbconstraints);
        
        guessTextfield = new JTextField (2);
        gbconstraints.anchor = GridBagConstraints.LINE_START;
        guessTextfield.setFont(new Font("Arial", Font.PLAIN, 25)); // Set the font and size
        gbconstraints.gridx=1;
        gbconstraints.gridy=1;
        gbconstraints.gridheight=1;
        gbconstraints.gridwidth=2;
        add(guessTextfield,gbconstraints);
        
        startButton = new JButton("Start");
        startButton.setBackground(new Color(179, 200, 144));
        gbconstraints.anchor=GridBagConstraints.FIRST_LINE_END;
        gbconstraints.gridx=0;
        gbconstraints.gridy=0;
        gbconstraints.gridheight=1;
        gbconstraints.gridwidth=1;
        add(startButton,gbconstraints);
        
        enterGuessButton = new JButton ("Enter Guess");
        enterGuessButton.setBackground(new Color(182, 187,252));
        gbconstraints.anchor=GridBagConstraints.CENTER;
        gbconstraints.gridx=1;
        gbconstraints.gridy=2;
        gbconstraints.gridheight=1;
        gbconstraints.gridwidth=2;
        add(enterGuessButton,gbconstraints);

        startButton.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                FormEvent ev = new FormEvent(this, true);
                if (formListener != null) {
                    formListener.formEventOccurred(ev);
                }
            }
        }); 
        
        ActionListener enterActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                JFrame errorFrame = new JFrame("Error");
                JLabel errorMessage;
                errorFrame.setSize(300, 100);
                errorFrame.setLocationRelativeTo(null);
                
                int guessNum = 0;
                int errorCode = 0;
                try {
                    guessNum = Integer.parseInt(guessTextfield.getText().trim());

                    if (guessNum < 0 || guessNum > 100) {
                        throw new invalidGuessException("Entered number must be between 1 and 100.");
                    }
                } catch (NumberFormatException error) {
                    errorMessage = new JLabel("Entered number must be an integer.");
                    errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
                    errorFrame.add(errorMessage);
                    errorFrame.setVisible(true);
                } catch (invalidGuessException error) {
                    errorMessage = new JLabel(error.getMessage());
                    errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
                    errorFrame.add(errorMessage);
                    errorFrame.setVisible(true);
                }
                
                FormEvent ev = new FormEvent(this, guessNum);

                guessTextfield.setText("");
                guessTextfield.setCaretPosition(guessTextfield.getDocument().getLength()); 
                
                if (formListener != null) {
                    formListener.formEventOccurred(ev);
                }
            }
        };        
        
        enterGuessButton.addActionListener(enterActionListener);
        guessTextfield.addActionListener(enterActionListener);
        
        guessTextfield.registerKeyboardAction(enterActionListener, 
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
                javax.swing.JComponent.WHEN_FOCUSED);
    }
}
