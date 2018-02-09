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

public class Main {

	public static void main(String[] args) {

		String s;

		// Array to store the shapes
		Shape[] shapes = new Shape[50];

		// Counter to keep track of shapes created
		int index = 0;

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
							shapes[index] = new Circle(radius);
							index++;
						} catch (CircleException e) {
							System.out.println(e.getMessage());
						}

					} else if (tokens[i].equals("Triangle") && tokens.length == 4) {
						double side1 = Double.parseDouble(tokens[i + 1]);
						double side2 = Double.parseDouble(tokens[i + 2]);
						double side3 = Double.parseDouble(tokens[i + 3]);

						try {
							shapes[index] = new Triangle(side1, side2, side3);
							index++;
						} catch (TriangleException e) {
							System.out.println(e.getMessage());
						}

					} else if (tokens[i].equals("Parallelogram") && tokens.length == 3) {
						double width = Double.parseDouble(tokens[i + 1]);
						double length = Double.parseDouble(tokens[i + 2]);

						try {
							shapes[index] = new Parallelogram(width, length);
							index++;
						} catch (ParallelogramException e) {
							System.out.println(e.getMessage());
						} catch (SquareException e) {
							System.out.println(e.getMessage());
						}

					} else if (tokens[i].equals("Rectangle") && tokens.length == 3) {
						double width = Double.parseDouble(tokens[i + 1]);
						double length = Double.parseDouble(tokens[i + 2]);

						try {
							shapes[index] = new Rectangle(width, length);
							index++;
						} catch (ParallelogramException e) {
							System.out.println(e.getMessage());
						} catch (SquareException e) {
							System.out.println(e.getMessage());
						}

					} else if (tokens[i].equals("Square") && tokens.length == 2) {
						double side = Double.parseDouble(tokens[i + 1]);

						try {
							shapes[index] = new Square(side);
							index++;
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

		System.out.println(index + " shapes were created:");

		for (int j = 0; j < index; j++) {
			System.out.println(shapes[j]);
		}

	}

}
