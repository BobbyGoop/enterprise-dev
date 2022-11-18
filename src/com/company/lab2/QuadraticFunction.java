package com.company.lab2;

import java.util.ArrayList;

public class QuadraticFunction
{
    public final double coefficientA;
    public final double coefficientB;
    public final double coefficientC;
    public final double discriminant;
    public boolean isSolved;
    public ArrayList<Double> roots= new ArrayList<>();

    public QuadraticFunction(double A, double B, double C)
    {
        this.coefficientA = A;
        this.coefficientB = B;
        this.coefficientC = C;
        this.discriminant = (Math.pow(this.coefficientB, 2) - 4 * this.coefficientA * this.coefficientC);
        this.solveEquation();
    }

    private double calculateFunctionValue(double X) {
        return this.coefficientA * Math.pow(X, 2) + this.coefficientB * X + this.coefficientC;
    }

    private void solveEquation() {
        if (discriminant==0) {
            this.roots.add(-coefficientB/ 2 * coefficientA);
            this.isSolved = true;
        }
        else if (discriminant>0) {
            this.roots.add(-coefficientB + Math.sqrt(discriminant) / 2 * coefficientA);
            this.roots.add(-coefficientB - Math.sqrt(discriminant) / 2 * coefficientA);
            this.isSolved = true;
        }
        else {
            this.isSolved = false;
        }
    }

//    public Double [] [] getRoots () {
//        switch (this.roots.size()) {
//            case 0: return null;
//            case 1: { }
//        }
//        if (this.isSolved) {
//            switch (this.roots.size())
//            return this.roots.toArray(new Double[0]);
//        }
//        else {
//
//        }
//    }
}
