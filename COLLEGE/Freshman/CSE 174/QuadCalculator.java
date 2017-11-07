// Robert Ritchie
// Obtains the coordinates of a quadrilateral's vertices and
// calculates side lengths, area, perimeter, and centroid coordinates.
//
// Test case: jqcd 1 2 1 9 6 7 5 2

import java.util.Scanner;

public class QuadCalculator {
   public static void main(String[] args){
      
      Scanner keyboard = new Scanner(System.in);
      String name, vertex1, vertex2, vertex3, vertex4, name1To2, name2To3, name3To4, name4To1;
      
      // Gets the name and vertices of the quadrilateral
      System.out.print("Enter the four letter name of the quadrilateral: ");
      name = keyboard.next().toUpperCase();
      vertex1 = name.substring(0,1);
      vertex2 = name.substring(1,2);
      vertex3 = name.substring(2,3);
      vertex4 = name.substring(3);
      name1To2 = vertex1 + vertex2;
      name2To3 = vertex2 + vertex3;
      name3To4 = vertex3 + vertex4;
      name4To1 = vertex4 + vertex1;
      
      // Gets the coordinates of the vertices
      double xCoord1, yCoord1, xCoord2, yCoord2, xCoord3, yCoord3, xCoord4, yCoord4;
      
      System.out.print("Enter the coordinates of vertex " + vertex1 + ":");
      xCoord1 = keyboard.nextDouble();
      yCoord1 = keyboard.nextDouble();
      System.out.print("Enter the coordinates of vertex " + vertex2 + ":");
      xCoord2 = keyboard.nextDouble();
      yCoord2 = keyboard.nextDouble();
      System.out.print("Enter the coordinates of vertex " + vertex3 + ":");
      xCoord3 = keyboard.nextDouble();
      yCoord3 = keyboard.nextDouble();
      System.out.print("Enter the coordinates of vertex " + vertex4 + ":");
      xCoord4 = keyboard.nextDouble();
      yCoord4 = keyboard.nextDouble();
      
      // Calculations
      double length1To2, length2To3, length3To4, length4To1, length1To3, length2To4;
      double area, perimeter, semiperimeter, xCentroid, yCentroid, minLength, maxLength;
      
      length1To2 = Math.hypot(xCoord1-xCoord2,yCoord1-yCoord2);
      length2To3 = Math.hypot(xCoord2-xCoord3,yCoord2-yCoord3);
      length3To4 = Math.hypot(xCoord3-xCoord4,yCoord3-yCoord4);
      length4To1 = Math.hypot(xCoord4-xCoord1,yCoord4-yCoord1);
      length1To3 = Math.hypot(xCoord1-xCoord3,yCoord1-yCoord3);
      length2To4 = Math.hypot(xCoord2-xCoord4,yCoord2-yCoord4);
      
      perimeter = length1To2 + length2To3 + length3To4 + length4To1;
      semiperimeter = perimeter*0.5;
      
      area = Math.sqrt((semiperimeter - length1To2)*(semiperimeter - length2To3)*
                       (semiperimeter - length3To4)*(semiperimeter - length4To1) -
                       0.25*(length1To2*length3To4 + length2To3*length4To1 + length1To3*length2To4)*
                       (length1To2*length3To4 + length2To3*length4To1 - length1To3*length2To4));
      
      minLength = Math.min(Math.min(length1To2,length2To3),Math.min(length3To4,length4To1));
      maxLength = Math.max(Math.max(length1To2,length2To3),Math.max(length3To4,length4To1));
      
      double xMidpoint1To3, xMidpoint2To4, yMidpoint1To3, yMidpoint2To4;
      xMidpoint1To3 = 0.5*(xCoord1 + xCoord3);
      yMidpoint1To3 = 0.5*(yCoord1 + yCoord3);
      xMidpoint2To4 = 0.5*(xCoord2 + xCoord4);
      yMidpoint2To4 = 0.5*(yCoord2 + yCoord4);
      xCentroid = 0.5*(xMidpoint1To3 + xMidpoint2To4);
      yCentroid = 0.5*(yMidpoint1To3 + yMidpoint2To4);
      
      
      // Display results
      System.out.println("--- Side Lengths ---");
      System.out.printf("%s: %.3f%n", name1To2, length1To2);
      System.out.printf("%s: %.3f%n", name2To3, length2To3);
      System.out.printf("%s: %.3f%n", name3To4, length3To4);
      System.out.printf("%s: %.3f%n", name4To1, length4To1);
      System.out.println();
      System.out.printf("Shortest side: %.3f%n", minLength);
      System.out.printf("Longest side: %.3f%n", maxLength);
      System.out.println();
      System.out.println("--- Other Measures ---");
      System.out.printf("Perimeter = %.3f%n", perimeter);
      System.out.printf("Area      = %.3f%n", area);
      System.out.printf("Centroid  = (%.3f, %.3f)%n", xCentroid, yCentroid);   
   }
}
