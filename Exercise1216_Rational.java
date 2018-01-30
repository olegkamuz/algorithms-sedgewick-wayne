public class Exercise1216_Rational {
    private final long numerator;
    private final long denominator;
    public Exercise1216_Rational(long numerator, long denominator){
        if (denominator == 0){
            throw new IllegalArgumentException("Denominator can't be equal 0");
        }
        long gcf = gcf(numerator, denominator);
        numerator /= gcf;
        denominator /= gcf;
        if (denominator < 0){
            // carry minus sign from denominator to numerator
            denominator = -1 * denominator;
            numerator = -1 * numerator;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }
    private long gcf(long numerator, long denominator){
        if (denominator == 0){
            return numerator;
        } else {
            return gcf(denominator, numerator % denominator);
        }
    }
    public long numerator(){
        return this.numerator;
    }
    public long denominator(){
        return this.denominator;
    }
    public Exercise1216_Rational plus(Exercise1216_Rational b) {
        long newNumerator = this.numerator * b.denominator() + b.numerator() * this.denominator;
        long newDenominator = this.denominator * b.denominator();

        Exercise1216_Rational newRational = new Exercise1216_Rational(newNumerator, newDenominator);
        return newRational;
    }
    public Exercise1216_Rational minus(Exercise1216_Rational b) {
        long newNumerator = this.numerator * b.denominator() - b.numerator() * this.denominator;
        long newDenominator = this.denominator * b.denominator();

        Exercise1216_Rational newRational = new Exercise1216_Rational(newNumerator, newDenominator);
        return newRational;
    }
    public Exercise1216_Rational times(Exercise1216_Rational b) { long newNumerator = this.numerator * b.numerator;
        long newDenominator = this.denominator * b.denominator();

        Exercise1216_Rational newRational = new Exercise1216_Rational(newNumerator, newDenominator);
        return newRational;
    }
    public Exercise1216_Rational divides(Exercise1216_Rational b) {
        long newNumerator = this.numerator * b.denominator();
        long newDenominator = this.denominator * b.numerator();

        Exercise1216_Rational newRational = new Exercise1216_Rational(newNumerator, newDenominator);
        return newRational;
    }
    public boolean equals(Exercise1216_Rational that) {
        if (that == this) return true;
        if (that == null) return false;
        if (that.getClass() != this.getClass()) return false;
        Exercise1216_Rational rational = (Exercise1216_Rational) that;
        return (this.numerator == that.numerator() && this.denominator == that.denominator());
    }
    public String toString(){
        return this.numerator + "/" + this.denominator;
    }
    public static void main(String[] args) {
        Exercise1216_Rational rational1 = new Exercise1216_Rational(1, 4);
        Exercise1216_Rational rational2 = new Exercise1216_Rational(2, 3);

        Exercise1216_Rational rationalPlus = rational1.plus(rational2);
        StdOut.println("Plus test: 1/4 + 2/3 = " + rationalPlus.numerator + "/" + rationalPlus.denominator
                + " Expected: 11/12");

        Exercise1216_Rational rationalMinus = rational1.minus(rational2);
        StdOut.println("Minus test: 1/4 - 2/3 = " + rationalMinus.numerator + "/" + rationalMinus.denominator
                + " Expected: -5/12");

        Exercise1216_Rational rationalTimes = rational1.times(rational2);
        StdOut.println("Times test: 1/4 * 2/3 = " + rationalTimes.numerator + "/" + rationalTimes.denominator
                + " Expected: 1/6");

        Exercise1216_Rational rationalDividedBy = rational1.divides(rational2);
        StdOut.println("Divided by test: 1/4 / 2/3 = " + rationalDividedBy.numerator + "/" + rationalDividedBy.denominator
                + " Expected: 3/8");

        Exercise1216_Rational equalRational1 = rational1;
        Exercise1216_Rational equalRational2 = new Exercise1216_Rational(rational1.numerator(), rational1.denominator());
        Exercise1216_Rational nonEqualRational = new Exercise1216_Rational(7, 8);
        StdOut.println("Equal test 1 = " + rational1.equals(equalRational1) + " Expected: true");
        StdOut.println("Equal test 2 = " + rational1.equals(equalRational2) + " Expected: true");
        StdOut.println("Equal test 3 = " + rational1.equals(nonEqualRational) + " Expected: false");

        StdOut.println("toString() test 1 = " + rational1 + " Expected: 1/4");
        StdOut.println("toString() test 2 = " + rational2 + " Expected: 2/3");
    }
}
