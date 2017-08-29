// Define the Set class

import java.util.*;

class Set {
    
    private ArrayList<Integer> members;
    
    // Constructors
    public Set(int num, Scanner sc, char name){
        members = new ArrayList<Integer>();

        System.out.print("Enter elements for set " + name + ": ");
        for (int i = 0; i < num; i++){
            members.add(sc.nextInt());
        }
        
    }
        
        // toString() method
        public String toString() {
        return members.toString();
    }
        public int size(){
            return members.size();
        }
        
        public ArrayList getList(){
            return members;
        }
    // Return true if 'this' is a subset of 'set', 
    // otherwise return false.
    public boolean isSubset(Set set) {
        if(members.size() > set.size()) return false;

        for(int c: members){
            if(!set.getList().contains(c)) return false;
        }
        return true;
            
    }
    public boolean isEqual(Set set) {
        if(members.size() != set.size()) return false;

        for(int c: members){
            if(!set.getList().contains(c)) return false;
        }
        return true;
            
    }
}

