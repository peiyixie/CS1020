// To compute the distance of the nearest pair of points
// among a list of points.

import java.util.*;
import java.awt.*;

public class NearestPoints {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double minDist;

        int size = sc.nextInt();  // size of list;
        ArrayList<Point> points = new ArrayList<Point>(size);
        for(int i = 0; i < size; i++){
            points.add(new Point(sc.nextInt(), sc.nextInt()));
        }


        minDist = dist(0, 1, points);
        
         for (int i = 1; i < size - 1; i++){
            for (int j = 0; j < size; j++){
                if(i != j){
                    minDist = Math.min(minDist, dist(i, j, points));
                }
            }
        }
        
        
        System.out.printf("Minimum distance = %.2f\n", minDist);
    }
    
    public static double dist(int a, int b, ArrayList<Point> points){
        return  Math.sqrt(Math.pow(((double)points.get(a).getX() - points.get(b).getX()),2)+
                   (Math.pow((points.get(a).getY() - points.get(b).getY()),2)));
    }
    
}

