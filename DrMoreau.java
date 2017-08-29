// CS1020 (AY2014/5 Semester 4) - Lab 4
//
// Name: Xie Peiyi
// Matric. No.: A0141123B
// Lab group: 1 
// Collaborators:
// 
// Experiment, in accordance with a set of crossbreeding rules,
// with different starting species of different classes to obtain
// new crossbreed species, with different class attributes, species attributes
// and sounds.
// 


import java.util.*;

/* class for First generation species has been written for you, but you may modify it as you see fit */
class First {
    protected String class_attr; // string containing the class attributes
    protected ArrayList<String> species_attr = new ArrayList<String>(); // list of string containing the species attributes
    protected String sound; // string containing the vocalization of the species
    protected int species_num; // the species number
    protected boolean isChimera = false;
    protected int noClass = 1;
    // constructor
    public First() { 
        class_attr = new String("Swim"); 
    }

    // mutators
    public void setSpeciesNum(int i) { species_num = i; }    
    public void setSpeciesAttr(String a) { species_attr.add(a); }    
    public void setSound(String s) {sound = s; }

    //  you may need to make use of this in the other classes
    public String createSound() {
        if(noClass == 1) return sound;
        if(noClass == 2) return sound + " " + sound;
        if(noClass == 3) return sound + " " + sound + " " + sound;
        if(noClass == 4) return sound + " " + sound + " " + sound + " " + sound;
        else return sound + " " + sound + " " + sound + " " + sound + " " + sound;

    }

    // accessors
    public int getSpeciesNum() { return species_num; }
    public String getClassAttr() { return class_attr; }   
    public ArrayList<String> getSpeciesAttr() { return species_attr; }
    public String getSound() { return sound; }
    public int getNo(){return noClass;}
    public boolean isAChimera(){
        return isChimera;
    }
}

class Second extends First {
    
    public int getNo(){return noClass;}

    public Second() { 
        noClass = 2;
        class_attr += ",Slither";
    }
}

class Third extends Second {
    public int getNo(){return noClass;}
    public Third(){
        noClass = 3;
        class_attr += ",Walk";
    }     

}

class Fourth extends Third {  
    public int getNo(){return noClass;}
    public Fourth(){
        noClass = 4;
        class_attr += ",Climb";
    }  

}

class Fifth extends Fourth {
    public int getNo(){return noClass;}
    public Fifth(){
        noClass = 5;
        class_attr += ",Fly";
    }
}

/* How does chimera differ from the rest? */
class Chimera extends First {
    public int getNo(){return noClass;}
    public Chimera(First a){
        class_attr = a.getClassAttr();
        isChimera = true;
        noClass = a.getNo();
    }
}

public class DrMoreau {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
 
        int numSpe = sc.nextInt();
        int numExp = sc.nextInt();
        First[] listSpe = new First[numSpe+numExp];

        int indexSpe = 0;
        int classSpe = 0;
        for(int i = 0; i < numSpe; i++){
            indexSpe = sc.nextInt();
            classSpe = sc.nextInt();
            if(classSpe == 1) listSpe[i] = new First();
            if(classSpe == 2) listSpe[i] = new Second(); 
            if(classSpe == 3) listSpe[i] = new Third();
            if(classSpe == 4) listSpe[i] = new Fourth();
            if(classSpe == 5) listSpe[i] = new Fifth();
            listSpe[i].setSpeciesNum(indexSpe);
            listSpe[i].setSpeciesAttr(sc.next());
            listSpe[i].setSound(sc.next());

            sc.nextLine();
        }
        int specNo1 = 0, specNo2 = 0, specNew = 0;
        for (int i = numSpe; i < numSpe+numExp; i++){
            specNew = sc.nextInt();
            specNo1 = sc.nextInt();
            specNo2 = sc.nextInt();
            if (listSpe[specNo1-1].isAChimera() || 
                listSpe[specNo2-1].isAChimera())
                sc.nextLine();
            else if(subsumed(listSpe[specNo1-1], listSpe[specNo2-1]) ||
                subsumed(listSpe[specNo2-1], listSpe[specNo1-1])){
                sc.nextLine();
            }
            else if(listSpe[specNo1-1].getNo() == listSpe[specNo2-1].getNo()){
                classSpe = listSpe[specNo1-1].getNo();
                if(classSpe == 1) listSpe[i] = new First();
                if(classSpe == 2) listSpe[i] = new Second(); 
                if(classSpe == 3) listSpe[i] = new Third();
                if(classSpe == 4) listSpe[i] = new Fourth();
                if(classSpe == 5) listSpe[i] = new Fifth();
                listSpe[i].setSpeciesNum(specNew);
                listSpe[i].setSpeciesAttr(sc.next());
                addSpeAttr(listSpe[specNo1-1], listSpe[specNo2-1], listSpe[i]);
                listSpe[i].setSound(sc.next());
                sc.nextLine();
            }
            else if(listSpe[specNo1-1].getNo() != listSpe[specNo2-1].getNo()){
                classSpe = Math.max(listSpe[specNo1-1].getNo(), 
                    listSpe[specNo2-1].getNo());
                if(classSpe == listSpe[specNo1-1].getNo())
                    listSpe[i] = new Chimera(listSpe[specNo1-1]);
                else
                    listSpe[i] = new Chimera(listSpe[specNo2-1]);
                listSpe[i].setSpeciesNum(specNew);
                listSpe[i].setSpeciesAttr(sc.next());
                addSpeAttr(listSpe[specNo1-1], listSpe[specNo2-1], listSpe[i]);
                listSpe[i].setSound(sc.next());
                sc.nextLine();
            }



        }
       

        // The code for output is here ! 

        for (int i = 0; i < numSpe+numExp; i++) {            
            if(listSpe[i] != null){
                System.out.print( i+1 + ": class = " +
                    listSpe[i].getClassAttr() + "; species = ");
                int size = listSpe[i].getSpeciesAttr().size(); 
                for(int j = 0; j < size - 1; j++)
                    System.out.print(listSpe[i].getSpeciesAttr().get(j) + ",");
                System.out.print(listSpe[i].getSpeciesAttr().get(size-1) + 
                    "; sound = \"");
                
                System.out.print(listSpe[i].createSound() + "\"");
                System.out.println();

            }
        }
    }
    // add species attributes to species c given species a and b.
    public static void addSpeAttr(First a, First b, First c){
        for(String e : a.getSpeciesAttr()){
            if(!c.getSpeciesAttr().contains(e))
                c.setSpeciesAttr(e);
        }
        for(String e : b.getSpeciesAttr())
            if(!c.getSpeciesAttr().contains(e))
                c.setSpeciesAttr(e);        
    }
    // determine whether one specie is subsumed by the other
    public static boolean subsumed(First a, First b){
        for(String e: a.getSpeciesAttr()){
            if(!b.getSpeciesAttr().contains(e)) return false;
        }
        return true;

    }

}
