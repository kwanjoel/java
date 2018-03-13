package shapes;
public class Rectangle extends Parallelogram{
		
		//Methods
		@Override
		public double CalcPerimeter(){
			return 2 * (getLength() + getWidth());
		}
		
		@Override
		public String toString(){
			return ("Rectangle {w = " + getWidth() + " l = " + getLength() + "} perimeter = " + CalcPerimeter() + " area = " + area.get());
		}
		
		//Constructors
		public Rectangle() {
		}
		
		public Rectangle(double width, double length) throws ParallelogramException, SquareException {
			super(width, length);

		}
		
		public ShapeProperty area = () -> getLength() * getWidth();

}
