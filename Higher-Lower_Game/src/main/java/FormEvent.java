
import java.util.EventObject;


/**
 *
 * @author Jahn
 */
public class FormEvent extends EventObject {
    private int guess;
    
    public int getGuess() { return guess; }
    public void setGuess(int guess) {this.guess = guess;}
    public FormEvent(Object source) { super(source); }

    public FormEvent(Object source, int guess) {
        super(source);
        this.guess = guess;
    }
    
    
}
