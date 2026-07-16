package org.bernardomecabo.OOPExamples.TriangleExample;

import org.bernardomecabo.OOPExamples.TriangleExample.OOP.Calculus;
import org.bernardomecabo.OOPExamples.TriangleExample.OOP.Triangle;

public class OOPSolution {
    static void main() {
        Triangle triangle1 = new Triangle(3,2,6);
        Triangle triangle2 = new Triangle(3,1,8);

        triangle1 = Calculus.areaTriangle(triangle1);
        triangle2 = Calculus.areaTriangle(triangle2);
        System.out.println("Area of triangle 1: " + triangle1.area());
        System.out.println("Area of triangle 2: " + triangle2.area());

        Triangle biggerArea = Calculus.biggerArea(triangle1, triangle2);
        System.out.println("Triangle with bigger area is: " + biggerArea);
    }
}
