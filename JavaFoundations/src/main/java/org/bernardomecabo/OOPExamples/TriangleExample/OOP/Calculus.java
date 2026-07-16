package org.bernardomecabo.OOPExamples.TriangleExample.OOP;

public class Calculus {
    public static Triangle areaTriangle(Triangle triangle) {
        double expression = Math.abs(triangle.p()*(triangle.p()-triangle.a())*(triangle.p()-triangle.b())*(triangle.p()-triangle.c()));
        double area =  Math.sqrt(expression);

        return new Triangle(triangle,area);
    }

    public static Triangle biggerArea(Triangle triangle1, Triangle triangle2) {
        double area1 = triangle1.area();
        double area2 = triangle2.area();
        return (area1 > area2) ? triangle1 : triangle2;
    }
}
