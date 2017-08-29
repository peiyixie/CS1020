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

public class GoldHunter {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyMap map = new MyMap(sc);        
        
        // TO STUDENTS: Fill in the code below
        

        
        
        for (int i = 0; i < map.getRow(); i++){
            for(int j = 0; j < map.getCol(); j++){
                int num = numGold(i, j, map);
                if(num != -1)
                    map.setLabel(i, j, (char)(48+num));
            }
        }
        // TO STUDENTS: uncomment the comment below to print out the output
        map.display();
    }
    // TO STUDENTS: You should add some methods in this program.
    //             You should not do all the work in the main() method above.
    // To return number of gold in one cell
    public static int numGold(int row, int col, MyMap map){
        int num = 0;
        int nRow = map.getRow();
        int nCol = map.getCol();
        if(map.getLabel(row,col) == '*') return -1;
        else{
            if(row!=0) {if(map.getLabel(row-1,col) == '*') num++;}
            if(row!=0&&col!=0) {if(map.getLabel(row-1,col-1) == '*') num++;}
            if(row!=0&&col!=nCol-1) {if(map.getLabel(row-1,col+1) == '*') num++;}
            if(col!=0){if(map.getLabel(row,col-1) == '*') num++;}
            if(col!=nCol-1){if(map.getLabel(row,col+1) == '*') num++;}
            if(row!=nRow-1){if(map.getLabel(row+1,col) == '*') num++;}        
            if(row!=nRow-1&&col!=0){if(map.getLabel(row+1,col-1) == '*') num++;}
            if(row!=nRow-1&&col!=nCol-1){if(map.getLabel(row+1,col+1) == '*') num++;}
        }
        return num;
        
    }
}
