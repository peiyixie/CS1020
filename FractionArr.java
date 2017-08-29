// Fraction class, using a 2-element integer array as data members

class FractionArr implements FractionI {

	/************** Data members **********************/
	private int[] members = new int[2];

	/************** Constructors **********************/
	// Default constructor creates a fraction 1/1
	public FractionArr(){
		setNumer(1);
		setDenom(1);
	}
	public FractionArr(int numer, int denom){
		setNumer(numer);
		setDenom(denom);
	}
	/**************** Accessors ***********************/
	public int getNumer(){
		return members[0];
	}   // returns numerator part
	public int getDenom(){
		return members[1];
	}   // returns denominator part
	public void setNumer(int numer){
		members[0] = numer;
	}   // sets new numerator
	public void setDenom(int denom){
		members[1] = denom;
	}   // sets new denominator

	public FractionArr add(FractionI f){
		int resultNumer = members[0] * f.getDenom() + members[1] * f.getNumer();
		int resultDenom = members[1] * f.getDenom();
		return new FractionArr(resultNumer, resultDenom).simplify();
	}     // returns this + f
	public FractionArr minus(FractionI f){
		int resultNumer = members[0] * f.getDenom() - members[1] * f.getNumer();
		int resultDenom = members[1] * f.getDenom();
		return new FractionArr(resultNumer, resultDenom).simplify();
	}   // returns this - f
	public FractionArr times(FractionI f){
		int resultNumer = members[0] * f.getNumer();
		int resultDenom = members[1] * f.getDenom();
		return new FractionArr(resultNumer, resultDenom).simplify();
	}   // returns this * f
	public FractionArr divide(FractionI f){
		int resultNumer = members[0] * f.getDenom();
		int resultDenom = members[1] * f.getNumer();
		return new FractionArr(resultNumer, resultDenom).simplify();
	}  // returns this / f
	public FractionArr simplify(){
		int gcdNum = gcd(members[0], members[1]);
  		members[0] /= gcdNum;
  		members[1] /= gcdNum;
  		if(members[1] < 0) {
   			members[0] *= -1;
   			members[1] *= -1;
		}
		return new FractionArr(members[0], members[1]);
	}           // simplifies this 
	private static int gcd(int p, int q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }
    public String toString(){
    	return members[0] + "/" + members[1];
    }

}

