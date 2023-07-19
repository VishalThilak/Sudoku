
package sudoku;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Font; 

/**
 * This is the button class for the main game panel
 * in the Sudoku game.
 * @author Vishal Thilak
 */
public class Button extends JButton {
    private int value;
    private boolean displayed;
    
    /**
     * This constructor sets up buttons in the Sudoku Panel.
     * It displays the value of the text if it's initially
     * suppose to be given. 
     * @param num This is the value on the button.
     * @param displayed This is if it is initially displayed at the start of the game.
     */
    public Button(int num, boolean displayed) {
        this.setPreferredSize(new Dimension(80, 80));
        this.setBackground(Color.WHITE);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Courier",Font.PLAIN, 50));
        this.setFocusPainted(false);
        String text = String.valueOf(num);
        
        // Only displaying the values which have a boolean that's true
        if (displayed){
           this.setText(text); 
           this.displayed = true;
           this.value = num;
        }
        
    }
    
    /**
     * It set's the text that will be displayed on the button.
     * @param num This is the value of the text shown.
     */
    public void setVal(int num){
        value = num;
        this.setText(String.valueOf(num));
    }
    
    /**
     * This getter method is used to access the value of the
     * button in other classes.
     * @return int The value of the button.
     */
    public int getNum(){
        int num = this.value;
        return num;
    }
    
    /**
     * This getter method is used to access Boolean of a button
     * to see if its initially displayed.
     * @return Boolean If it's displayed. 
     */
    public boolean getBool(){
        boolean var = this.displayed;
        return var;
    }
}
