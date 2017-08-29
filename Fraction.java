// Fraction class, using 2 integers as the data members

class Fraction implements FractionI {

	/************** Data members **********************/
	private int numer;
	private int denom;

	/************** Constructors **********************/
	// Default constructor creates a fraction 1/1
	public Fraction(){
		this(1,1);
	}
	public Fraction(int numer, int denom){
		setNumer(numer);
		setDenom(denom);
	}

	/**************** Accessors ***********************/
	public int getNumer(){
		return numer;
	}
	public int getDenom(){
		return denom;
	}

	/**************** Mutators ************************/
	public void setNumer(int numer){
		this.numer = numer;
	}
	public void setDenom(int denom){
		this.denom = denom;
	}

	/***************** Other methods ******************/
	public Fraction add(FractionI f){
		int resultNumer = this.numer * f.getDenom() + this.denom * f.getNumer();
		int resultDenom = this.denom * f.getDenom();
		return new Fraction(resultNumer, resultDenom).simplify();
	}
	public Fraction minus(FractionI f){
		int resultNumer = this.numer * f.getDenom() - this.denom * f.getNumer();
		int resultDenom = this.denom * f.getDenom();
		return new Fraction(resultNumer, resultDenom).simplify();
	}

	public Fraction times(FractionI f){
		int resultNumer = this.numer * f.getNumer();
		int resultDenom = this.denom * f.getDenom();
		return new Fraction(resultNumer, resultDenom).simplify();
	}
	public Fraction divide(FractionI f){
		int resultNumer = this.numer * f.getDenom();
		int resultDenom = this.denom * f.getNumer();
		return new Fraction(resultNumer, resultDenom).simplify();
	}
	public Fraction simplify(){
		int gcdNum = gcd(numer, denom);
		numer /= gcdNum;
		denom /= gcdNum;
		if(denom < 0) {
			numer *= -1;
			denom *= -1;
		} 
		return new Fraction(numer, denom);
	}
	private static int gcd(int p, int q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }

    public String toString(){
    	return numer + "/" + denom;
    }

    public boolean equals(FractionI f){
    	if(this.simplify().getDenom() == f.simplify().getDenom() &&
    		this.simplify().getNumer() == f.simplify().getNumer()) return true;
    	return false;
    }
}

