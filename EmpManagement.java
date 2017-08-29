// CS1020 (AY2014/5 Semester 4) - Lab 7
//
// Name: Xie Peiyi
// Matric. No.: A0141123B
// Lab group: 1
//
// Write the program description below.
// Hire or fire employees with ranks. Promote employees to a higher rank.
//
//
//
//
//

import java.util.*;

/* Service class representing an employee */
class Employee {
    private String name;
    private int rank;
    
    public Employee(String name, int rank){
        this.name = name;
        this.rank = rank;
    }
    
    
    public int getRank(){ return rank; }
    public String getName(){ return name; }
    public String toString(){ return name + " " + rank; }
    
}

/* Client class to simulate the employee management system */
public class EmpManagement{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack <Employee> s1 = new Stack <Employee>();
        int numOp = sc.nextInt();
        for(int i = 0; i < numOp; i++){
            String op = sc.next();
            switch(op){
                case("hire"):
                    String nameHire = sc.next();
                    int rankHire = sc.nextInt();
                    System.out.println("hire " + nameHire + " " + rankHire);
                    addAndOrder(s1, new Employee(nameHire, rankHire));
                    display(s1);
                    System.out.println();
                    
                    break;
                case("fire"):
                    int fireNum = sc.nextInt();
                    System.out.println("fire " + fireNum);
                    for(int j = 0; j < fireNum; j++){
                        s1.pop();
                    }
                    if(s1.empty()) System.out.println("@");
                    
                    display(s1);
                    System.out.println();
                    
                    break;
                case("promote"):
                    String name = sc.next();
                    int rank = sc.nextInt();
                    System.out.println("promote " + name + " " + rank);
                    delete(name, s1);
                    addAndOrder(s1, new Employee(name, rank));
                    display(s1);
                    System.out.println();
                    
                    break;
                default:
                    break;
                    
                    
            }// switch
        } // for loop
    } // main
    
    // to add employee to the masterfile and reorder them
    public static void addAndOrder(Stack<Employee> s1, Employee toCheck){
        
        Stack <Employee> temp = new Stack <Employee>();
        if(s1.empty()) s1.push(toCheck);
        else{
            while(!s1.empty() && s1.peek().getRank() < toCheck.getRank()){
                temp.push(s1.pop());   
            }// while loop
            s1.push(toCheck);
            while(!temp.empty()){
                s1.push(temp.pop());
            }
        } 
    }// order method
    // to delete an employee to be promoted first
    public static void delete(String toDelete, Stack<Employee> s1){
        Stack <Employee> temp = new Stack <Employee>();     
        while(!toDelete.equals(s1.peek().getName())){
            temp.push(s1.pop());
        }
        s1.pop();
        while(!temp.empty()){
            s1.push(temp.pop());
        }
    }
    
    
    
    // to display the contents of the employee masterfile
    public static void display(Stack<Employee> s1){
        Stack <Employee> s2 = new Stack <Employee>();
        while(!s1.empty()) s2.push(s1.pop());
        for (Employee obj: s2){
            System.out.println(obj);
        }
        while(!s2.empty()) s1.push(s2.pop());
    }// display
    
    
}
