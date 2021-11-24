package it.unisa.se.calculator.model;

import java.security.InvalidParameterException;
import java.util.Objects;

public class ComplexNumber {

    private double real;
    private double imaginary;

    public ComplexNumber() {
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getImaginary() {
        return imaginary;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComplexNumber)) return false;
        ComplexNumber that = (ComplexNumber) o;
        return compareNumbers(that.getReal(), getReal()) == 0 && compareNumbers(that.getImaginary(), getImaginary()) == 0;
    }

    private int compareNumbers(double imaginary1, double imaginary2){
        if(Math.abs(imaginary1) == 0.0 && Math.abs(imaginary2) == 0.0 )
            return 0;
        return Double.compare(imaginary1,imaginary2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReal(), getImaginary());
    }

    /*static methods*/
    public static ComplexNumber sum(ComplexNumber complexNumber1, ComplexNumber complexNumber2) {
        ComplexNumber result = new ComplexNumber();
        result.setReal(complexNumber1.getReal() + complexNumber2.getReal());
        result.setImaginary(complexNumber1.getImaginary() + complexNumber2.getImaginary());
        return result;
    }

    public static ComplexNumber subtract(ComplexNumber complexNumber1, ComplexNumber complexNumber2) {
        ComplexNumber result = new ComplexNumber();
        result.setReal(complexNumber1.getReal() - complexNumber2.getReal());
        result.setImaginary(complexNumber1.getImaginary() - complexNumber2.getImaginary());
        return result;
    }

    public static ComplexNumber multiply(ComplexNumber complexNumber1, ComplexNumber complexNumber2) {
        ComplexNumber result = new ComplexNumber();
        result.setReal(complexNumber1.getReal() * complexNumber2.getReal() - complexNumber1.getImaginary() * complexNumber2.getImaginary());
        result.setImaginary(complexNumber1.getImaginary() * complexNumber2.getReal() + complexNumber2.getImaginary() * complexNumber1.getReal());
        return result;
    }

    public static ComplexNumber divide(ComplexNumber complexNumber1, ComplexNumber complexNumber2){
        //check if operands are valid
        if(complexNumber2.getReal() == 0.0  && complexNumber2.getImaginary() == 0.0)
            throw new InvalidParameterException("Undefined division, second operand bust be different from 0+0i");


        double a = complexNumber1.getReal();
        double b = complexNumber1.getImaginary();
        double c= complexNumber2.getReal();
        double d = complexNumber2.getImaginary();
        return new ComplexNumber(((c*a)+(b*d))/(a*a + b*b), ((c*b)-(a*d))/(a*a + b*b));

    }
    public static ComplexNumber sqrt(ComplexNumber complexNumber1){
        double real = complexNumber1.getReal();
        double imaginary = complexNumber1.getImaginary();

        double module = Math.sqrt(real * real + imaginary* imaginary);

        double realRoot =  Math.sqrt((real + module) / 2);

        double imaginaryRoot = Math.sqrt(( module - real) / 2);
        if(imaginary<0) imaginaryRoot = imaginaryRoot*(-1);
        return new ComplexNumber(realRoot,imaginaryRoot);

    }
    public static ComplexNumber signInversion(ComplexNumber complexNumber1){
        double real = complexNumber1.getReal();
        double imaginary = complexNumber1.getImaginary();
        return new ComplexNumber(-1* real, -1*imaginary);
    }


}
