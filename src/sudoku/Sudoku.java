
package sudoku;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


/**
 * The Sudoku program allows the user to play
 * and solve one Sudoku puzzle. It's extended from a JFrame
 * which means that this class inherits all the properties of 
 * the JFrame class.
 * 
 * @author Vishal Thilak
 * @version 1.0
 * @since 2022-02-07
 */
public class Sudoku extends JFrame {
    public  int current;
    Button[][] buttons = new Button[9][9];
    int arr[][] = new int[9][9];
    
    boolean displayed[][] = new boolean[9][9];
   
    /**
     * The constructor sets the name of the window number.
     */
    public Sudoku() {
        super("Sudoku");
    }
    
    /**
     * Generating puzzle based on difficulty.
     * Calls in PuzzleGenerator class to create puzzle
     * and asks for user input on difficulty.
     * Difficulty easy means a lot of the numbers
     * appear already and hard means a few of them are 
     * shown at the start. 
     */
    public void generate(){
        PuzzleGenerator puzzle = new PuzzleGenerator();
        boolean success = puzzle.generate();
        this.arr = puzzle.returnArray();
        float percentageOfNumsShown = (float) 0.3;
        
        Scanner myObj = new Scanner(System.in); 
        System.out.println("Enter difficulty: Easy, Medium, Hard");
        boolean valid = true;
        
        do{
            String difficulty = myObj.nextLine();
            valid = true;
            switch(difficulty){
                case "Easy" : percentageOfNumsShown = (float) 0.3; break;
                case "Medium" : percentageOfNumsShown = (float) 0.5; break;
                case "Hard" : percentageOfNumsShown = (float) 0.7; break;
                default: valid = false;
            }
            if(!valid){
                System.out.println("Error invalid input try again!");
            }
        } while(!valid);
         
            
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                Random rand = new Random();
                displayed[i][j] = rand.nextFloat() >= percentageOfNumsShown;
            }
        }
    }
    
    /**
     * This method is a getter method that gets
     * the current value of the user.
     * @return int This returns the current value.
     */
    public int getNumber(){
        return this.current;
    }
    
    /**
     * This method sets the current value of the user.
     * @param num This is the number the user wants to be on.
     */
    public void setCurVal(int num){
        current = num;
    }
    
    /**
     * This method is used to determine if the Sudoku puzzle
     * is solved.
     * @return Boolean This returns if the player has solved(won) the game.
     */
    public boolean victory(){
      boolean won = true;
       for (int i = 0; i < 9; i++){
           for (int j = 0; j < 9; j++){
               if (buttons[i][j].getNum() != arr[i][j]){
                   won = false;
               } 
           }
       }
       return won;
        
    }
 
    /**
     * This method sets up the Sudoku board with default values and 
     * the number pad. It's create a GUI. 
     */
    private void createGUI (){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        // JPanels
        JPanel gamePanel = new JPanel();
        JPanel numpad = new JPanel();
        JPanel container = new JPanel();
        container.setBackground(Color.BLACK);
        
        // Layout
        GridLayout layout = new GridLayout(3,3);
        gamePanel.setLayout(layout);
        numpad.setLayout(layout);
        
        // Border
        Border padding = new LineBorder(Color.WHITE, 6); 
        Border border = new LineBorder(Color.WHITE, 1);
        gamePanel.setBorder(border);
        numpad.setBorder(padding);
        
        // Setting numpad size
        numpad.setPreferredSize(new Dimension(300,300));
        numpad.setMaximumSize(new Dimension(100, 300));
        
        // ClickHandler
        ClickHandler ch = new ClickHandler(this);
        
        // Setting up the buttons of the sudoku game
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JPanel innerpanel = new JPanel(); 
                innerpanel.setLayout(layout);
                innerpanel.setBorder(border);
                gamePanel.add(innerpanel);
                for (int k = 0; k < 3; k++){
                    for (int l = 0; l < 3; l++){
                        int row  = 3*i + k;
                        int col = 3*j + l;
                        Button b = new Button(arr[row][col], displayed[row][col]);
                        b.addActionListener(ch);
                        buttons[row][col] = b;
                        innerpanel.add(b);
                        if (displayed[row][col]){
                            b.setBackground(Color.DARK_GRAY);
                        }
                        else{
                            b.setBackground(Color.BLACK);
                        }
                    }
                }
            }
        }
        
        // Setting up the buttons in the number pad
        for (int i = 1; i < 10; i++){
            PadButton num = new PadButton(i);
            num.addActionListener(ch);
            num.setBorder(border);
            numpad.add(num);
            
        }
        
        // Addings game panel and number pad panel into one container panel
        container.add(gamePanel);
        container.add(numpad);
        this.add(container);
        this.pack();
   
    }
    
    /**
     * This is the main  method where the Sudoku game is created.
     * @param args Unused.
     */
    public static void main(String[] args) {   
        Sudoku game = new Sudoku();
        game.generate();
        // Testing to make sure all correct values are shown
//        for (int i = 0; i < 9; i++){
//            for (int j = 0; j  < 9; j++){
//                game.displayed[i][j] = true;
//                if (i==8 && j==8 || i==0 && j==0){
//                    game.displayed[i][j] = false;
//                }
//            }
//       }
        game.createGUI();
    }
  }


              
   
  

 
 
        
