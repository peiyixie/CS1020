// CS1020 (AY2015/6 Semester 4) - Lab 2
//
// Name: Xie Peiyi
// Matric. No.: A0141123B
// Lab group: 1
// Collaborators:
//
// Write the program description below.
// It is mandatory to write program description at the top of every program.
// Given a map of mines, print out the amount of golds in tons and the locations
// of mines in each cell.
//

import java.util.*;

class MyMap {
    private char[][] charMap; // map containing the character labels
    private int nRow; // number of rows
    private int nCol; // number of columns
    
    /* TO STUDENTS: add other attributes you need here */
    
    
    // read in a character map from input, you can modify as you deem fit
    public MyMap(Scanner sc) {       
        nRow = sc.nextInt();
        nCol = sc.nextInt();
        charMap = new char[nRow][nCol];
        String line;
        for (int i = 0; i < nRow; i++) {
            line = sc.next();
            for (int j = 0; j < nCol; j++) {        
                setLabel(i, j, line.charAt(j));     
            }
        }
    }
    
    // mutator for charMap
    public void setLabel(int row, int col, char label) { 
        charMap[row][col] = label; 
    }
    
    // accessor for charMap
    public char getLabel(int row, int col) { 
        return charMap[row][col];
    }
    
    // TO STUDENTS: add other methods you require here
    // return number of rows
    public int getRow(){
        return nRow;
    }
    // return number of columns
    public int getCol(){
        return nCol;
    }
    
    // To print the output map
    public void display() {
        // TO STUDENTS: fill in the code
        for(int i = 0; i < this.nRow; i++){
            for(int j = 0; j < this.nCol; j++){
                System.out.print(charMap[i][j]);
            }
            System.out.println();
        }
    }
}

