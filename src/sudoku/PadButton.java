
package sudoku;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Font;

/**
 * This is the number pad which is next to the 
 * main game panel in the Sudoku game. 
 * @author Vishal Thilak
 */
public class PadButton extends JButton{
    public int value;
    
    /**
     * Constructor for the PadButton class which 
     * generates a 9 by 9 grid of numbers 1-9.
     * @param num Number of the button on the number pad.
     */
    public PadButton(int num){
        this.setPreferredSize(new Dimension(50, 50));
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Courier",Font.PLAIN, 50));
        this.setText(String.valueOf(num));
        this.setFocusPainted(false);
        value = num;     
    }
    
    /**
     * Getter method returns the value of the user's
     * most recently clicked on button.
     * @return value Returns the value of the button.
     */
    public int getVal(){
        return value;
    }
}
