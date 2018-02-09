package shapes;

public class Triangle implements Shape {
	// Members
	private double side1;
	private double side2;
	private double side3;

	// Methods
	@Override
	public double CalcPerimeter() {
		return getSide1() + getSide2() + getSide3();
	}

	@Override
	public String toString() {
		return ("Triangle {side1 = " + getSide1() + "side2 = " + getSide2() + "side3 = " + getSide3() + "} perimeter = "
				+ CalcPerimeter());
	}

	// Getters and Setters
	public double getSide1() {
		return side1;
	}

	public double getSide2() {
		return side2;
	}

	public double getSide3() {
		return side3;
	}

	public void setSide1(double side1) throws TriangleException {
		if (side1 > 0) 
			this.side1 = side1;			
		else throw new TriangleException("Invalid side");
	}

	public void setSide2(double side2) throws TriangleException {
		if (side2 > 0) 
			this.side2 = side2;			
		else throw new TriangleException("Invalid side");
	}
	
	public void setSide3(double side3) throws TriangleException {
		if (side3 > 0) 
			this.side3 = side3;			
		else throw new TriangleException("Invalid side");
	}

	// Constructors
	public Triangle() {
	}

	public Triangle(double side1, double side2, double side3) throws TriangleException {

		// Ensure all sides are positive
		// Ensure that sum of 2 sides is always bigger than last side
		if (side1 > 0 && side2 > 0 && side3 > 0 && side1 + side2 > side3 && side1 + side3 > side2
				&& side3 + side2 > side1) {
			this.side1 = side1;
			this.side2 = side2;
			this.side3 = side3;
		} else
			throw new TriangleException("Invalid side(s)!");

	}
}