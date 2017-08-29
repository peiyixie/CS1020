// CS1020 (AY2014/5 Semester 4) - Lab 3
//
// Name: Xie Peiyi
// Matric. No.: A0141123B
// Lab group: 1
// Collaborators:
// 
// Write the program description below.
// It is mandatory to write program description at the top of every program.
// Creates magic boxes of types integer, double and string
// and store in and retrieve objects of different sizes.
//

import java.util.*;

// complete the Item class
class Item <T> {
    // to help you the required member attributes are given
    int size;
    String name;
    T val;
    
    // do you need a default constructor?
    
    public Item(String iname, int isize, T ival) {
        size = isize;
        name = iname;
        val = ival;
    }
    
    // write the other required methods
    public int getSize(){return size;}
    public String getName(){return name;}
    public T getVal(){return val;}   


    // Do you need to override the equals method? 
    // If you do, uncomment and complete it
    
    public boolean equals(String itemName) {
        if (this.name.equals(itemName)) return true;
        return false;
    }
    
}


// complete the MagicBox class
class MagicBox <U> {
    private static int objSizeStr = 0, objSizeInt = 0, objSizeDou = 0;
    private int size;
    private MagicBox<U> nextBox = null;
    private ArrayList<Item<U>> items;
    public MagicBox() {
        size = 100;
        items = new ArrayList<Item<U>>();
        
    }
    public MagicBox(int size){
        this.size = size;
        items = new ArrayList<Item<U>>();
        
    }
    
    public int getObjSizeStr(){
        return objSizeStr;
    }
    public int getObjSizeInt(){
        return objSizeInt;
    }
    public int getObjSizeDou(){
        return objSizeDou;
    }
    public void newBox(){
        nextBox = new MagicBox<U>();
    }
    public boolean hasBox(){
        if (nextBox != null) return true;
        return false;
    }

    
    
    public void insert(Item<U> item){
        if(this.size >= item.getSize()){
            this.items.add(item);
            this.size -= item.getSize();
            if(item.getVal() instanceof Integer) objSizeInt += item.getSize();
            if(item.getVal() instanceof Double) objSizeDou += item.getSize();
            if(item.getVal() instanceof String) objSizeStr += item.getSize();
            return;
        }
        if(this.hasBox())
            this.nextBox.insert(item);
        return;
    }

    public void addBox(){
        if(!this.hasBox()){
            this.newBox();
            return;
        }
        this.nextBox.addBox();
    }

    public Item<U> retrieve(String itemName){
        int indexItem = this.hasItem(itemName);

        if(this.hasItem(itemName) != -1) {
            return this.items.get(indexItem);
        }
        if(!this.hasBox())
            return null;
        else return this.nextBox.retrieve(itemName);
    }

    public int hasItem(String itemName){
        for(Item element : this.items){
            if (element.equals(itemName)) {
                return this.items.indexOf(element);
                }
            }
            return -1;
        }
    public void removeItem(Item itemD){
        if(this.items.indexOf(itemD) != -1){
            this.size += itemD.getSize();
            this.items.remove(itemD);

        }else{
            this.nextBox.removeItem(itemD);
        }
    }
    public void minusSize(String typeSize, Item itemD){
        if(typeSize.equals("String")) objSizeStr -= itemD.getSize();
        if(typeSize.equals("Integer")) objSizeInt -= itemD.getSize(); 
        if(typeSize.equals("Double")) objSizeDou -= itemD.getSize();
    }

}


// complete the Brinkgotts client class
public class Brinkgotts {
    
    // write the required methods
    
// complete the main method
public static void main(String[] args)  {
    Scanner in = new Scanner(System.in);
    MagicBox<Integer> intRoot = new MagicBox<Integer>(0);
    MagicBox<Double> douRoot = new MagicBox<Double>(0);
    MagicBox<String> strRoot = new MagicBox<String>(0);
    // the parsing of the input operation has been partially done for you please complete it
    while (in.hasNext()) {
        String[] operation = in.nextLine().split(" ");
        
        switch (operation[0]) {
            case "C":   
                int type = Integer.parseInt(operation[1]);
                // complete the code for operation C
                if(type == 1){
                    strRoot.addBox();
                }else if(type == 2){
                    intRoot.addBox();
                }else if(type == 3){
                    douRoot.addBox();
                }
                break;
            case "S":
                // complete the code for operation S
                int typeS = Integer.parseInt(operation[1]);
                String name = operation[2];
                int size = Integer.parseInt(operation[3]);
                if(typeS == 1){
                    String valStr = operation[4];
                    Item<String> strItem = new Item<String>(name, size, valStr);
                    strRoot.insert(strItem);
                } ;
                if(typeS == 2){
                    int valInt = Integer.parseInt(operation[4]);
                    Item<Integer> intItem = new Item<Integer>(name, size, valInt);
                    intRoot.insert(intItem);
                    
                } ;
                if(typeS == 3) {
                    double valDou = Double.parseDouble(operation[4]);
                    Item<Double> douItem = new Item<Double>(name, size, valDou);
                    douRoot.insert(douItem);
                }
                break;
            case "R":                        
                // complete the code for operation R
                String item = operation[1];
                
                if(strRoot.retrieve(item) !=  null){
                    Item<String> tempStr = strRoot.retrieve(item);
                    System.out.println(tempStr.getName() +" of type String, size "+tempStr.getSize()+
                    ", value " + tempStr.getVal()+ " has been retrieved");
                    strRoot.minusSize("String", tempStr);
                    strRoot.removeItem(tempStr);
                }
                else if(intRoot.retrieve(item) != null){
                    Item<Integer> tempInt = intRoot.retrieve(item);
                    System.out.println(tempInt.getName() +" of type Integer, size "+tempInt.getSize()+
                    ", value " + tempInt.getVal()+ " has been retrieved");
                    intRoot.minusSize("Integer", tempInt);
                    intRoot.removeItem(tempInt);
                }
                else if(douRoot.retrieve(item) != null){
                    Item<Double> tempDou = douRoot.retrieve(item);
                    System.out.println(tempDou.getName() +" of type Double, size "+tempDou.getSize()+
                    ", value " + tempDou.getVal()+ " has been retrieved");
                    douRoot.minusSize("Double", tempDou);
                    douRoot.removeItem(tempDou);
                }else{
                    System.out.println(item + " is not found");
                }
                break;
            case "T":                     
                // complete the code for operation T
                int typeT = Integer.parseInt(operation[1]);
                if(typeT == 1)
                System.out.println("Total size of objects stored in String root is " + strRoot.getObjSizeStr());
                if(typeT == 2)
                System.out.println("Total size of objects stored in Integer root is " + intRoot.getObjSizeInt());
                if(typeT == 3)
                System.out.println("Total size of objects stored in Double root is " + douRoot.getObjSizeDou());                
                break;
            default: break;
            }
        }
    }
}


