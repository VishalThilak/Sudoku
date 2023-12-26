/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Generates the Sudoku board
 * @author Vishal Thilak
 */
public class PuzzleGenerator {
    
    public int arr[][];
    
    /**
     * Constructor that initializes Sudoku puzzle
     */
    public PuzzleGenerator(){
        this.arr = new int[9][9];
    }
    
    /**
     * Calls recursive function to fill in Sudoku puzzle with a random arrangement
     * @return true if created and false otherwise
     */
    public boolean generate(){
        return createBoard();
    }
    
    /**
     * Returns the Sudoku grid
     * @return the 2d int array of the Sudoku puzzle
     */
    public int[][] returnArray(){
        return this.arr;
    }
    
    /**
     * Recursive helper function that generates a Sudoku puzzle
     * sequence.
     * @return true if slotting a number is valid and false otherwise
     */
     public boolean createBoard() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(numbers, new Random());
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] == 0) {
                    for(int num : numbers) {
                        if (validSpace(i, j, num)) {
                            arr[i][j] = num;
                            if (createBoard()) { 
                                return true;
                            } else { 
                                arr[i][j] = 0;
                            }
                        }
                    }
                    return false; 
                }
            }
        }
        return true;
    }
    
     /**
      * Checks if the number exists in a row, column, 
      * and in a 3 x 3 grid around a given row and column
      * @param row the current row
      * @param col the current column
      * @param num the number to check
      * @return false if it exists and true otherwise
      */
    private boolean validSpace(int row, int col, int num){
        return rowValid(row, num) && colValid(col, num)
                && smallGridValid(row - row % 3, col - col % 3, num);
    }
    
    /**
     * Checks if the number exists in a given row
     * @param row the given row
     * @param num the given number
     * @return false if it exists and true otherwise
     */
    private boolean rowValid(int row, int num){
        for(int col = 0; col < arr.length; col++){
            if(arr[row][col] == num) return false;
 
        }
        return true;  
    }
    
    /**
     * Checks if the number exists in a given column
     * @param row the given row
     * @param num the given number
     * @return false if it exists and true otherwise
     */
    private boolean colValid(int col, int num){
        for(int row = 0; row < arr.length; row++){
            if(arr[row][col] == num) return false;
        }
        return true;
    }
    
    /**
     * Checks if the number exists in a mini 3 x 3 around a given row and column
     * @param row the given row
     * @param col the given column
     * @param num the given number
     * @return false if it exists and true otherwise
     */
    private boolean smallGridValid(int row, int col, int num){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(arr[row + i][col + j] == num) return false;
            }
        }
        return true;
    }
}
