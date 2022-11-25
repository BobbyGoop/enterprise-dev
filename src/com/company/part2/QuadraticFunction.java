package com.company.part2;

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
        Double[] res = new Double[2];
        if (hasRoots) {
            if (discriminant == 0) {
                res[0] = -coefficientB / (2 * coefficientA);
                res[1] = calculateFunctionValue(res[0]);
                roots.add(Arrays.asList(res));
            } else if (discriminant > 0) {
                res[0] = (-coefficientB + Math.sqrt(discriminant)) / (2 * coefficientA);
                res[1] = calculateFunctionValue(res[0]);
                roots.add(Arrays.asList(res));

                res[0] = (-coefficientB - Math.sqrt(discriminant)) / (2 * coefficientA);
                res[1] = calculateFunctionValue(res[0]);
                roots.add(Arrays.asList(res));
            }
        } else {
            roots.add(new ArrayList<>());
        }
        return roots;
    }

    public Double[] findVertexCoordinates() {
        Double[] res = new Double[2];
        res[0] = -coefficientB / (2 * coefficientA);
        res[1] = coefficientC - Math.pow(coefficientB, 2) / (4 * coefficientA);
        return res;
    }
}
