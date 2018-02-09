package shapes;

public class Parallelogram implements Shape {
	// Members
	private double length;
	private double width;

	// Methods
	@Override
	public double CalcPerimeter() {
		return 2 * (getLength() + getWidth());
	}

	@Override
	public String toString() {
		return ("Parallelogram {w = " + getWidth() + "l = " + getLength() + "} perimeter = " + CalcPerimeter());
	}

	// Getters and Setters
	public double getLength() {
		return length;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	// Constructors
	public Parallelogram() {
	}

	public Parallelogram(double width, double length) throws ParallelogramException, SquareException {
		if(this instanceof Square) {
			if(width <= 0)
				throw new SquareException("Invalid side!");
		}
		
		if(width > 0)
			this.width = width;	
		else
			throw new ParallelogramException("Invalid width!");

		if(length > 0)
			this.length = length;	
		else
			throw new ParallelogramException("Invalid length!");	
		

	}
}