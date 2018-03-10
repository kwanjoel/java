package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import shapes.Shape;
import shapes.Circle;
import shapes.CircleException;
import shapes.Triangle;
import shapes.TriangleException;
import shapes.Parallelogram;
import shapes.ParallelogramException;
import shapes.Rectangle;
import shapes.Square;
import shapes.SquareException;
import shapes.ShapeProperty;

public class Main {

	public static void main(String[] args) {

		// Array to store the shapes
		Shape[] shapes = new Shape[50];

		// Counter to keep track of number of shapes created
		int count = 0;

		String s;
		try (BufferedReader br = new BufferedReader(new FileReader("shapes.txt"))) {
			while ((s = br.readLine()) != null) {
				String[] tokens = s.split(",");

				// Identify shape to be created by looking at first token and check for
				// appropriate token length;
				// Then parse the next tokens to be double
				// Then try to create shape and catch exceptions
				for (int i = 0; i < tokens.length; i++) {

					if (tokens[i].equals("Circle") && tokens.length == 2) {
						try {
							double radius = Double.parseDouble(tokens[i + 1]);
							shapes[count] = new Circle(radius);
							count++;
						} catch (CircleException e) {
							System.out.println(e.getMessage());
						}

					} else if (tokens[i].equals("Triangle") && tokens.length == 4) {
						double side1 = Double.parseDouble(tokens[i + 1]);
						double side2 = Double.parseDouble(tokens[i + 2]);
						double side3 = Double.parseDouble(tokens[i + 3]);

						try {
							shapes[count] = new Triangle(side1, side2, side3);
							count++;
						} catch (TriangleException e) {
							System.out.println(e.getMessage());
						}

					} else if (tokens[i].equals("Parallelogram") && tokens.length == 3) {
						double width = Double.parseDouble(tokens[i + 1]);
						double length = Double.parseDouble(tokens[i + 2]);

						try {
							shapes[count] = new Parallelogram(width, length);
							count++;
						} catch (ParallelogramException e) {
							System.out.println(e.getMessage());
						} catch (SquareException e) {
							System.out.println(e.getMessage());
						}

					} else if (tokens[i].equals("Rectangle") && tokens.length == 3) {
						double width = Double.parseDouble(tokens[i + 1]);
						double length = Double.parseDouble(tokens[i + 2]);

						try {
							shapes[count] = new Rectangle(width, length);
							count++;
						} catch (ParallelogramException e) {
							System.out.println(e.getMessage());
						} catch (SquareException e) {
							System.out.println(e.getMessage());
						}

					} else if (tokens[i].equals("Square") && tokens.length == 2) {
						double side = Double.parseDouble(tokens[i + 1]);

						try {
							shapes[count] = new Square(side);
							count++;
						} catch (ParallelogramException e) {
							System.out.println(e.getMessage());
						} catch (SquareException e) {
							System.out.println(e.getMessage());
						}
					}
				}
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		// --------------------------------------------Task One---------------------------------------

		System.out.println(count + " shapes were created:");

		for (int i = 0; i < count; i++) {
			System.out.print(shapes[i]);

			
			// ----------------------------------------Workshop 6 ------------------------------------
			
			//For Circles:
			if (shapes[i] instanceof Circle) {
				double [] values = {((Circle) shapes[i]).getRadius()};
				System.out.print(" area = " + ((Circle)shapes[i]).area.get());

			}
			
			//For rectangles and squares:
			if (shapes[i] instanceof Rectangle) {
				double [] values = {((Rectangle)shapes[i]).getLength(), ((Rectangle)shapes[i]).getWidth()};
				System.out.print(
						" area = " + ((Rectangle)shapes[i]).area.get());
			}

			System.out.print("\n");

		}

	}

} // main
