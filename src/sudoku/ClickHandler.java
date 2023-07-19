
package sudoku;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Creates a new ClickHandler. Allows user the 
 * ability to click on buttons in main game panel
 * and number pad. 
 * @author Vishal Thilak
 */
public class ClickHandler implements ActionListener {
    private Sudoku game;
    
    /**
     * Constructor of ClickHandler class takes in 
     * Sudoku game so it's responsible for the clicking done
     * in the game.
     * @param game Takes in the Sudoku game.
     */
    public ClickHandler(Sudoku game) {
        this.game = game;
    }
    
    /**
     * Determines if user clicks on either the game panel
     * button or number pad buttons and changes button values
     * accordingly. 
     * @param action_event Event that is performed.
     */
    @Override
    public void actionPerformed(ActionEvent action_event) {
        if (!game.victory()){
            if (action_event.getSource() instanceof Button){
                Button b = (Button)action_event.getSource();
                if (!b.getBool() && game.getNumber() != 0){
                    b.setVal(game.getNumber());
                }     
            }
            
            else{
            PadButton c = (PadButton)action_event.getSource();
            game.setCurVal(c.getVal());
            }
            
            // showing the victory pop up upon finishing sudoku game
            if (game.victory()){
                for (int i = 0; i < 9; i++){
                    for (int j = 0; j  < 9; j++){
                        Button b = game.buttons[i][j];
                        b.setForeground(Color.YELLOW);
                    }
                }
                JOptionPane.showMessageDialog(null, "You won!", "whoop-de-do", JOptionPane.PLAIN_MESSAGE);
            }
        }
        
    }
    
}
