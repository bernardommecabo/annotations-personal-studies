package org.bernardomecabo.OOPExamples.Encapsulation.TriangleExample.OOP;

public record Triangle(
        double a, double b, double c, double p, double area
) {
    public Triangle(double a, double b, double c) {
        this(a , b , c , (a+b+c)/2, 0);
    }

    public Triangle(Triangle triangle, double area) {
        this(triangle.a(), triangle.b(), triangle.c(), triangle.p(), area);
    }
}
