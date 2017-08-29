// Fraction class

class Fraction {
    
    /************** Data members **********************/
    private int numer;
    private int denom;
    
    /************** Constructors **********************/
    public Fraction() {
        numer = 1;
        denom = 1;
    }
    public Fraction(int numer, int denom){
        this.numer = numer;
        this.denom = denom;
    }
    
    /**************** Accessors ***********************/
    public int getNumer(){
        return numer;
    }
    
    public int getDenom(){
        return denom;
    }
    /**************** Mutators ************************/
    public void simplify(){
        int newNum = this.getNumer();
        int newDenom = this.getDenom();
        int gcdNum = gcd(newNum, newDenom);
        /*Fraction simp = new Fraction(newNum/gcdNum, newDenom/gcdNum);
        return simp;*/
        change(newNum/gcdNum, newDenom/gcdNum);
    } 
    
    public void change(int numerC, int denomC){
        this.numer = numerC;
        this.denom = denomC;
    }
    /***************** Other methods ******************/
    public String toString(){
        return (getNumer() + "/" + getDenom());
    }
    public boolean equals(Fraction obj){
        this.simplify();
        obj.simplify();
        if(this.getDenom() == obj.getDenom() && this.getNumer() == obj.getNumer())
            return true;
        else
            return false;
    
    }
    public Fraction add(Fraction obj){
        
        this.simplify();
        obj.simplify();
        int newD = this.getDenom() * obj.getDenom();
        int newN = this.getDenom() * obj.getNumer() + this.getNumer() * obj.getDenom();
        Fraction temp = new Fraction(newN, newD);
        temp.simplify();
        return temp;
    }
    private int gcd(int a, int b){
        while (a != 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }
    
    
}

