// CS1020 (AY2015/6 Semester 4) - Lab 1 Part 3
//
// Name: Xie Peiyi
// Matric. No.: A0141123B
// Lab group: 1
// Collaborators:
//
// Write the program description below.
// It is mandatory to write program description at the top of every program.
//Converts UK date into USA date and tells if the year is a leap year.
//
//
//
//

import java.util.*;
public class DateConvert {
    
    // Write your user-defined method below.
    // It is mandatory to have a description above every user-defined method. 
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter date in UK format: ");
        String month = sc.next();
        String date = sc.next();
        date = date.substring(0, date.length() - 1);
        String year = sc.next();

        System.out.print("Date in American format: ");
        System.out.println(date+ " " + month + " " + year);
        int yearNum = Integer.valueOf(year);
        if (yearNum % 400 == 0 || (yearNum % 4 == 0 && yearNum % 100 != 0))
            System.out.println(year + " is a leap year.");
        else
            System.out.println(year + " is not a leap year.");
    }
}

