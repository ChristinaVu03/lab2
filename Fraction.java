import java.math.BigInteger;
import java.io.PrintWriter;

/**
 * A simple implementation of Fractions.
 * 
 * @author Samuel A. Rebelsky
 * @author YOUR NAME HERE
 * @version 1.2 of August 2023
 */
public class Fraction {
  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+
  /*
   * (1) Denominators are always positive. Therefore, negative fractions are represented 
   * with a negative numerator. Similarly, if a fraction has a negative numerator, it 
   * is negative.
   * 
   * (2) Fractions are not necessarily stored in simplified form. To obtain a fraction 
   * in simplified form, one must call the `simplify` method.
   */

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   * Warning! Not yet stable.
   */
  public Fraction(BigInteger num, BigInteger denom) {
    this.num = num;
    this.denom = denom;
  } // Fraction(BigInteger, BigInteger)

  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   * Warning! Not yet stable.
   */
  public Fraction(int num, int denom) {
    this.num = BigInteger.valueOf(num);
    this.denom = BigInteger.valueOf(denom);
  } // Fraction(int, int)

  /**
   * Build a new fraction by parsing a string.
   *
   * Warning! Not yet implemented.
   */
  public Fraction(String str) {
    this.num = BigInteger.valueOf(2);
    this.denom = BigInteger.valueOf(7);
      // Split the input string using '/' as the delimiter
      String[] parts = str.split("/");
      
      // Check if the string has the expected format
      if (parts.length != 2) {
          System.out.println("Invalid fraction format");
      }
    
          // Parse the numerator and denominator strings into BigIntegers
          BigInteger parsedNumerator = new BigInteger(parts[0]);
          BigInteger parsedDenominator = new BigInteger(parts[1]);
          
          // Ensure that the denominator is non-negative
          if (parsedDenominator.compareTo(BigInteger.ZERO) <= 0) {
              System.out.println("Denominator must be positive: " + str);
          }
          
          // Set the numerator and denominator for this Fraction object
          this.num = parsedNumerator;
          this.denom = parsedDenominator;
      }
  
    
  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Express this fraction as a double.
   */
  public double doubleValue() {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()

  /**
   * Add the fraction `addMe` to this fraction.
   */
  public Fraction add(Fraction addMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(addMe.denom);
    // The numerator is more complicated
    resultNumerator = (this.num.multiply(addMe.denom)).add(addMe.num.multiply(this.denom));

    // Return the computed value
    return new Fraction(resultNumerator, resultDenominator);
  }// add(Fraction)

  /**
   * Get the denominator of this fraction.
   */
  public BigInteger denominator() {
    return this.denom;
  } // denominator()
  
  /**
   * Get the numerator of this fraction.
   */
  public BigInteger numerator() {
    return this.num;
  } // numerator()
  
  /**
   * Convert this fraction to a string for ease of printing.
   */
  public String toString() {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO)) {
      return "0";
    } // if it's zero

    // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  } // toString()
// class Fraction

// Excercise 1: 
  public Fraction multiply1(Fraction fraction1) throws Exception{
  
      BigInteger newNumerator = this.num.multiply(fraction1.num);
      BigInteger newDenominator = this.denom.multiply(fraction1.denom);

  
    return new Fraction(newNumerator, newDenominator);
  }
  //Excercise 2
  public Fraction fractional() {
    BigInteger remainder = this.num.mod(this.denom);

    // If the remainder is zero, the fractional part is 0
    if (remainder.equals(BigInteger.ZERO)) {
        return new Fraction(BigInteger.ZERO, this.denom);
    } else {
        return new Fraction(remainder, this.denom);
    }
}
// Excercise 4



  public static void main(String[] args) throws Exception{
    PrintWriter pen = new PrintWriter(System.out,true);
    Fraction fraction1 = new Fraction(1,3);
    Fraction fraction2 = new Fraction(1,5);
    pen.println(fraction1.multiply1(fraction2));
    Fraction f;
    f = new Fraction(11,3);
    pen.println(f.fractional());  // 2/3
  
    f = new Fraction(1,2);
    pen.println(f.fractional());  // 1/2
  
    f = new Fraction(5,2);
    pen.println(f.fractional());  // 1/2
  
    f = new Fraction(4,2);
    pen.println(f.fractional());  // 0/2 or 0

    Fraction f5;
    f5 = new Fraction("1/4");
    pen.println(f5.numerator());   // 1
    pen.println(f5.denominator()); // 4
  }
  // +---------+--------------------------------------------------------
  // | Methods |
  // +---------+

  // ...
} // class Fraction
