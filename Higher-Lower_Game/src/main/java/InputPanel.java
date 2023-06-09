
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jahn
 */

public class InputPanel extends JPanel{
    private JLabel enterLabel;
    private JTextField guessTextfield;
    private JButton enterGuessButton;
    private FormListener formListener;
    
    public void setFormListener(FormListener formListener) {
        this.formListener = formListener;
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
        gbconstraints.gridy=0;
        gbconstraints.gridheight=1;
        gbconstraints.gridwidth=1;
        add(enterLabel,gbconstraints);
        
        guessTextfield = new JTextField (10);
        gbconstraints.gridx=1;
        gbconstraints.gridy=0;
        gbconstraints.gridheight=1;
        gbconstraints.gridwidth=1;
        add(guessTextfield,gbconstraints);
        
        enterGuessButton = new JButton ("Enter Guess");
        gbconstraints.anchor=GridBagConstraints.CENTER;
        gbconstraints.gridx=0;
        gbconstraints.gridy=1;
        gbconstraints.gridheight=1;
        gbconstraints.gridwidth=2;
        add(enterGuessButton,gbconstraints);
        
        enterGuessButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int num = Integer.parseInt(guessTextfield.getText());
                //tPanel.ta.setText(Integer.toString(num*num));
                FormEvent ev=new FormEvent(this,num);
                
                if(formListener != null){
                    formListener.formEventOccurred(ev);
                }
            }
        });
    }
}
