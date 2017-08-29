// CS1020 (AY2015/6 Semester 4) - Lab 1 Part 2
//
// Name: Xie Peiyi
// Matric. No.: A0141123B
// Lab group: 1
// Collaborators:
//
// Write the program description below.
// It is mandatory to write program description at the top of every program.
// Read inputs in three ways and conduct simple arithmetic calculations with
// two bits.
//
//
//
//


import java.util.*;

public class ReadInput {
    
    public static void main(String[] args) {
        
        // declare the necessary variables
        int type, numOfOps;
        
        int result;
        
        // declare a Scanner object to read input
        Scanner sc = new Scanner(System.in);
        
        // read input and process them accordingly
        type = sc.nextInt();
        
        if(type == 1){
            numOfOps = sc.nextInt();
            for (int i = 0; i < numOfOps; i++)
                System.out.println(operation(sc.next(), sc.nextInt(), sc.nextInt()));
            
        }
        if(type == 2){
            while(!sc.hasNextInt()){
                System.out.println(operation(sc.next(), sc.nextInt(), sc.nextInt()));
            }
        }
        if(type == 3){
            while(sc.hasNext())
                System.out.println(operation(sc.next(), sc.nextInt(), sc.nextInt()));
        }
    }
    public static int operation(String operator, int a, int b){
        if(operator.equals("AND")){
            if (a == 1 && b==1)
                return 1;
            else
                return 0;
        }
        else{
            if (a == 1 || b == 1)
                return 1;
            else
                return 0;
        }
    }
}
