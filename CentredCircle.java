// CentredCircle class:
//   Subclass of Circle
//   Instance attribute: centre

// Add import statement(s) below

import java.awt.geom.Point2D;
class CentredCircle extends Circle{
    
    /************** Data members **********************/
    protected Point2D.Double centre;
    
    /************** Constructors **********************/
    // Default constructor creates a yellow circle 
    // with radius 10.0 circle and centre at (0,0)
    
    public CentredCircle() {
        // Fill in the code
        super();
        centre = new Point2D.Double();
        centre.setLocation(0,0);
    }
    
    public CentredCircle(String colour, double radius, Point2D.Double centre) {
        // Fill in the code
        super(colour, radius);
        this.centre = centre;
    }
    
    /**************** Accessor ***********************/
    public Point2D.Double getCentre() {
        // Fill in the code
        return centre;
    }
    
    /**************** Mutator ************************/
    public void setCentre(Point2D.Double centre) {
        // Fill in the code
        this.centre.setLocation(centre);
    }
    
    /***************** Overriding methods ******************/
    // Overriding toString() method
    public String toString() {
        // Fill in the code
        return "[" + getColour() + ", " + getRadius() + ", " 
            + "(" + getCentre().getX() + "," +getCentre().getY()+")" + "]";
    }
    
    // Overriding equals() method
    public boolean equals(Object obj) {
        // Fill in the code
        if (obj instanceof CentredCircle){
            CentredCircle circle = (CentredCircle) obj;
            if (super.equals(circle)){
                if (this.centre.equals(circle.getCentre())) return true;
            }else return false;
        }
        return false;
    }
    
}

