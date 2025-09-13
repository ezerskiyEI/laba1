package demo.parallel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComplexTest {

    private static final double DELTA = 1e-10;

    @Test
    void testPlus() {
        Complex a = new Complex(2, 3);
        Complex b = new Complex(1, 2);
        Complex result = a.plus(b);

        assertEquals(3, result.getRe(), DELTA, "Real part of addition");
        assertEquals(5, result.getIm(), DELTA, "Imaginary part of addition");
    }

    @Test
    void testPlusModifiesOriginal() {
        Complex a = new Complex(2, 3);
        Complex b = new Complex(1, 2);
        a.plus(b);

        assertEquals(3, a.getRe(), DELTA, "Original object real part after plus");
        assertEquals(5, a.getIm(), DELTA, "Original object imaginary part after plus");
    }

    @Test
    void testMinus() {
        Complex a = new Complex(5, 7);
        Complex b = new Complex(2, 3);
        Complex result = a.minus(b);

        assertEquals(3, result.getRe(), DELTA, "Real part of subtraction");
        assertEquals(4, result.getIm(), DELTA, "Imaginary part of subtraction");
    }

    @Test
    void testMinusDoesNotModifyOriginal() {
        Complex a = new Complex(5, 7);
        Complex b = new Complex(2, 3);
        Complex original = new Complex(a.getRe(), a.getIm());
        a.minus(b);

        assertEquals(original.getRe(), a.getRe(), DELTA, "Original object should not be modified by minus");
        assertEquals(original.getIm(), a.getIm(), DELTA, "Original object should not be modified by minus");
    }

    @Test
    void testTimes() {
        Complex a = new Complex(2, 3);
        Complex b = new Complex(1, 2);
        Complex result = a.times(b);

        assertEquals(-4, result.getRe(), DELTA, "Real part of multiplication");
        assertEquals(7, result.getIm(), DELTA, "Imaginary part of multiplication");
    }

    @Test
    void testTimesModifiesOriginal() {
        Complex a = new Complex(2, 3);
        Complex b = new Complex(1, 2);
        a.times(b);

        assertEquals(-4, a.getRe(), DELTA, "Original object real part after times");
        assertEquals(7, a.getIm(), DELTA, "Original object imaginary part after times");
    }

    @Test
    void testTimesWithZero() {
        Complex a = new Complex(2, 3);
        Complex zero = new Complex(0, 0);
        Complex result = a.times(zero);

        assertEquals(0, result.getRe(), DELTA, "Multiplication by zero (real)");
        assertEquals(0, result.getIm(), DELTA, "Multiplication by zero (imaginary)");
    }

    @Test
    void testDivide() {
        Complex a = new Complex(4, 6);
        Complex b = new Complex(2, 2);
        Complex result = a.divide(b);

        assertEquals(2.5, result.getRe(), DELTA, "Real part of division");
        assertEquals(0.5, result.getIm(), DELTA, "Imaginary part of division");
    }

    @Test
    void testDivideDoesNotModifyOriginal() {
        Complex a = new Complex(4, 6);
        Complex b = new Complex(2, 2);
        Complex original = new Complex(a.getRe(), a.getIm());
        a.divide(b);

        assertEquals(original.getRe(), a.getRe(), DELTA, "Original object should not be modified by divide");
        assertEquals(original.getIm(), a.getIm(), DELTA, "Original object should not be modified by divide");
    }

    @Test
    void testDivideByReal() {
        Complex a = new Complex(6, 9);
        Complex b = new Complex(3, 0);
        Complex result = a.divide(b);

        assertEquals(2, result.getRe(), DELTA, "Division by real number (real)");
        assertEquals(3, result.getIm(), DELTA, "Division by real number (imaginary)");
    }

    @Test
    void testConjugate() {
        Complex a = new Complex(3, 4);
        Complex result = a.conjugate();

        assertEquals(3, result.getRe(), DELTA, "Conjugate real part");
        assertEquals(-4, result.getIm(), DELTA, "Conjugate imaginary part");
    }

    @Test
    void testConjugateDoesNotModifyOriginal() {
        Complex a = new Complex(3, 4);
        Complex original = new Complex(a.getRe(), a.getIm());
        a.conjugate();

        assertEquals(original.getRe(), a.getRe(), DELTA, "Original object should not be modified by conjugate");
        assertEquals(original.getIm(), a.getIm(), DELTA, "Original object should not be modified by conjugate");
    }

    @Test
    void testLengthSQ() {
        Complex a = new Complex(3, 4);
        double result = a.lengthSQ();

        assertEquals(25, result, DELTA, "Squared length (3² + 4² = 25)");
    }

    @Test
    void testComplexOperationsChain() {
        Complex a = new Complex(1, 2);
        Complex b = new Complex(3, 4);
        Complex c = new Complex(2, 1);
        Complex d = new Complex(1, 1);

        Complex sum = a.plus(b);
        Complex product = sum.times(c);
        Complex result = product.divide(d);

        assertEquals(9, result.getRe(), DELTA, "Chained operations real part");
        assertEquals(7, result.getIm(), DELTA, "Chained operations imaginary part");
    }

    @Test
    void testNewFractalEquation() {
        Complex z = new Complex(1, 1);
        Complex c = new Complex(0.5, 0.5);

        Complex conjugate = z.conjugate();
        Complex sum = conjugate.plus(c);
        Complex result = sum.times(sum);

        assertEquals(2.0, result.getRe(), DELTA, "New fractal equation real part");
        assertEquals(-3.0, result.getIm(), DELTA, "New fractal equation imaginary part");
    }

    @Test
    void testConstructor() {
        Complex complex = new Complex(2.5, -3.7);

        assertEquals(2.5, complex.getRe(), DELTA, "Constructor real part");
        assertEquals(-3.7, complex.getIm(), DELTA, "Constructor imaginary part");
    }

    @Test
    void testIdentityOperations() {
        Complex a = new Complex(2, 3);
        Complex zero = new Complex(0, 0);
        Complex one = new Complex(1, 0);

        // a + 0 = a
        Complex plusZero = a.plus(zero);
        assertEquals(a.getRe(), plusZero.getRe(), DELTA, "Identity addition (real)");
        assertEquals(a.getIm(), plusZero.getIm(), DELTA, "Identity addition (imaginary)");

        // a * 1 = a
        Complex timesOne = a.times(one);
        assertEquals(a.getRe(), timesOne.getRe(), DELTA, "Identity multiplication (real)");
        assertEquals(a.getIm(), timesOne.getIm(), DELTA, "Identity multiplication (imaginary)");
    }
}