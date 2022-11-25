package main.java.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadraticFunction {
    public final double coefficientA;
    public final double coefficientB;
    public final double coefficientC;
    public final double discriminant;
    public boolean hasRoots;
    public List<List<Double>> roots = new ArrayList<>();

    public QuadraticFunction(double A, double B, double C) {
        this.coefficientA = A;
        this.coefficientB = B;
        this.coefficientC = C;
        this.discriminant = (Math.pow(this.coefficientB, 2) - 4 * this.coefficientA * this.coefficientC);
        this.hasRoots = (this.discriminant >= 0);
        //this.solveEquation();
    }

    public double calculateFunctionValue(double X) {
        return coefficientA * Math.pow(X, 2) + coefficientB * X + coefficientC;
    }

    public List<List<Double>> getEquationRoots() {
        // Array for storing X and Y values
        if (hasRoots) {
            if (discriminant == 0) {
                double x1 = -coefficientB / (2 * coefficientA);
                double y1 = calculateFunctionValue(x1);
                roots.add(Arrays.asList(x1, y1));
            } else if (discriminant > 0) {
                double x1 = (-coefficientB + Math.sqrt(discriminant)) / (2 * coefficientA);
                double y1 = calculateFunctionValue(x1);
                double x2 = (-coefficientB - Math.sqrt(discriminant)) / (2 * coefficientA);
                double y2 = calculateFunctionValue(x2);
                roots.add(Arrays.asList(x1, y1));
                roots.add(Arrays.asList(x2, y2));
            }
        } else {
            roots.add(new ArrayList<>());
        }
        return roots;
    }

    public double[] findVertexCoordinates() {
        return new double[]{
                -coefficientB / (2 * coefficientA),
                coefficientC - Math.pow(coefficientB, 2) / (4 * coefficientA)
        };
    }
}
