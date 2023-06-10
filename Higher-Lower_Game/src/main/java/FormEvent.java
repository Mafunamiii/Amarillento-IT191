
import java.util.EventObject;


/**
 *
 * @author Jahn
 */
public class FormEvent extends EventObject {
    private int guess;
    private Boolean start = false;

    public Boolean getStart() { return start; }
    public void setStart(Boolean target) { this.start = target; }
        
    public int getGuess() { return guess; }
    public void setGuess(int guess) { this.guess = guess; }
    
    public FormEvent(Object source) { super(source); }

    public FormEvent(Object source, int guess) {
        super(source);
        this.guess = guess;
    }
    
    public FormEvent(Object source, Boolean start) {
        super(source);
        this.start = start;
    }
}
