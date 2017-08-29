// CS1020 (AY2014/5 Semester 4) - Lab 9
//
// Name: Xie Peiyi
// Matric. No.: A0141123B
// Lab group: 1
//
// Write the program description below.
// To calculate the total cost needed if a robot travels through a 2D grid
// when it chooses the cell with the lowest cost to move to or to move to
// the destination cell if it can.
//
//
//
//

import java.util.*;

public class RobotMovement { 
    private static final int MAX_VALUE = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt() + 1;
        int[][] arr = new int[size][size];
        
        int row = sc.nextInt();
        int col = sc.nextInt();

        for(int i = 0; i < size - 1; i++){
        	for(int j = 0; j < size - 1; j++)
        		arr[i][j] = sc.nextInt();
        }    


        for(int i = 0; i < size; i++){
        	arr[size - 1][i] = MAX_VALUE;
        	arr[i][size - 1] = MAX_VALUE;
        }
        int cost = arr[row][col];

        cost += move(row, col, arr);
        System.out.println(cost);
    }



    public static int move(int i, int j, int[][] arr){
    	
    	if( i == arr.length - 2 && j == i) return 0; //base case
    	
    	int costDia, costDown, costRight, cost = 0;
	    costDia = arr[i+1][j+1];
		costDown = arr[i+1][j];
		costRight = arr[i][j+1];

		if( i+1 == arr.length - 2 && j == i){
			cost = costDia;
			i++;
			j++;
			cost += move(i, j, arr);
			return cost;
		}else if(i+1 == arr.length - 2 && j == i+1){
			cost = costDown;
			i++;
			cost += move(i, j, arr);
			return cost;
		}else if(j == arr.length - 2 && j == i){
			cost = costRight;
			j++;
			cost += move(i, j, arr);
			return cost;
		}
		
		if(costDia <= costDown && costDia <= costRight){ 
			i++;
			j++;
			cost += costDia + move(i, j, arr);
			return cost;
		}else if(costDown <= costDia && costDown <= costRight){
			i++;
			cost += costDown + move(i, j, arr);
			return cost;
		}else if(costRight <= costDown && costRight <= costDia){
			j++;
			cost += costRight + move(i, j, arr);
			return cost;
		}else if(costRight == costDown && costDown == costDia){
			i++;
			j++;
			cost += costDia;
			return cost;
		}
	

		cost += move(i, j, arr);
		return cost;


    }
}
