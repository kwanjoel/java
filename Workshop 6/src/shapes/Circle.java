package shapes;
public class Circle implements Shape {
	//Members
	private double radius;
	
	//Methods
	@Override
	public double CalcPerimeter(){
		return 2 * Math.PI * getRadius();
	}
	
	@Override
	public String toString(){
		return ("Circle {r = " + getRadius() + "} perimeter = " + CalcPerimeter());
	}
	
	//Getters and Setters
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}

	//Constructors
	public Circle(){
		
	}
	
	public Circle(double radius) throws CircleException {
		//Ensure that radius is a positive value
		if (radius > 0) 
			this.radius = radius;
		else 
			throw new CircleException("Invalid radius!");
	}
	
	public ShapeProperty area = () -> Math.PI * getRadius() * getRadius();
}