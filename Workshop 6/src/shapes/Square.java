package shapes;
public class Square extends Rectangle{
	
	//Methods
	@Override
	public double CalcPerimeter() {
		return 4 * getLength();
	}
	
	@Override
	public String toString(){
		return("Square {s = " + getLength() + "} perimeter = " + CalcPerimeter() + " area = " + area.get());
	}
	
	//Constructors
	public Square() {
		
	}
	
	public Square(double side) throws ParallelogramException, SquareException {
		super(side, side);

	}
	
}