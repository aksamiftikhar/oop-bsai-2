package Lecture_13;

public class Complex {
    private double real;  // Real part of the complex number
    private double imaginary;  // Imaginary part of the complex number

    // Constructor to initialize real and imaginary parts of the complex number
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Static method to add two Complex numbers
    public static Complex addComplex(Complex A, Complex B) {
        double realSum = A.real + B.real;
        double imaginarySum = A.imaginary + B.imaginary;
        return new Complex(realSum, imaginarySum);
    }

    // Static method to subtract two Complex numbers
    public static Complex subtractComplex(Complex A, Complex B) {
        double realDifference = A.real - B.real;
        double imaginaryDifference = A.imaginary - B.imaginary;
        return new Complex(realDifference, imaginaryDifference);
    }

    // Instance method to compute the modulus of the complex number
    public double modulus() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    // Override toString method to display the complex number in the required format
    @Override
    public String toString() {
        return "(" + real + "+" + imaginary + "i)";
    }

    // Main method for testing
    public static void main(String[] args) {
        Complex num1 = new Complex(5, 3);
        Complex num2 = new Complex(4, 2);

        Complex sum = addComplex(num1, num2);
        Complex difference = subtractComplex(num1, num2);

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Modulus of num1: " + num1.modulus());
    }
}

