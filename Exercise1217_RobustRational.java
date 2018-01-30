public class Exercise1217_RobustRational {
    private final int numerator;
    private final int denominator;
    private final static String OVERFLOW_ALERT = "Operation would cause overflow";

    public Exercise1217_RobustRational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator can't be equal 0");
        }
        int gcf = gcf(numerator, denominator);
        numerator /= gcf;
        denominator /= gcf;
        if (denominator < 0) {
            // carry minus sign from denominator to numerator
            denominator = -1 * denominator;
            numerator = -1 * numerator;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    private int gcf(int numerator, int denominator) {
        if (denominator == 0) {
            return numerator;
        } else {
            return gcf(denominator, numerator % denominator);
        }
    }

    public int numerator() {
        return this.numerator;
    }

    public int denominator() {
        return this.denominator;
    }

    private void assertPlus(int a, int b) {
        assert a < Integer.MAX_VALUE - b : OVERFLOW_ALERT;
    }

    private void assertMultiply(int a, int b) {
        assert a < Integer.MAX_VALUE / b : OVERFLOW_ALERT;
    }
    private void assertMinus(int a, int b){
        assert a > Integer.MIN_VALUE + b : OVERFLOW_ALERT;
    }

    public Exercise1217_RobustRational plus(Exercise1217_RobustRational b) {
        assertMultiply(this.numerator, b.denominator());
        assertMultiply(b.numerator(), this.denominator);
        assertPlus(this.numerator * b.denominator(), b.numerator() * this.denominator);
        assertMultiply(this.denominator, b.denominator());
        int newNumerator = this.numerator * b.denominator() + b.numerator() * this.denominator;
        int newDenominator = this.denominator * b.denominator();

        return new Exercise1217_RobustRational(newNumerator, newDenominator);
    }

    public Exercise1217_RobustRational minus(Exercise1217_RobustRational b) {
        assertMultiply(this.numerator, b.denominator());
        assertMultiply(b.numerator(), this.denominator);
        assertPlus(this.numerator * b.denominator(), b.numerator() * this.denominator);
        int newNumerator = this.numerator * b.denominator() - b.numerator() * this.denominator;
        int newDenominator = this.denominator * b.denominator();

        return new Exercise1217_RobustRational(newNumerator, newDenominator);
    }

    public Exercise1217_RobustRational times(Exercise1217_RobustRational b) {
//        assertPlus(this.numerator * b.numerator());
//        assertExpress(this.denominator * b.denominator());
        assert this.denominator * b.denominator() <= Integer.MAX_VALUE : OVERFLOW_ALERT;
        int newNumerator = this.numerator * b.numerator();
        int newDenominator = this.denominator * b.denominator();

        return new Exercise1217_RobustRational(newNumerator, newDenominator);
    }

    public Exercise1217_RobustRational divides(Exercise1217_RobustRational b) {
        assertMultiply(this.numerator, b.denominator());
        assertMultiply(this.denominator, b.numerator());
        int newNumerator = this.numerator * b.denominator();
        int newDenominator = this.denominator * b.numerator();

        return new Exercise1217_RobustRational(newNumerator, newDenominator);
    }

    public boolean equals(Exercise1217_RobustRational that) {
        if (that == this) return true;
        if (that == null) return false;
        if (that.getClass() != this.getClass()) return false;
        Exercise1217_RobustRational rational = (Exercise1217_RobustRational) that;
        return (this.numerator == that.numerator() && this.denominator == that.denominator());
    }

    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    public static void main(String[] args) {
        Exercise1217_RobustRational rational1 = new Exercise1217_RobustRational(1, 4);
        Exercise1217_RobustRational rational2 = new Exercise1217_RobustRational(Integer.MAX_VALUE, 1);
//      Overflow errors:
//        rational1.plus(rational2);
//        rational1.times(rational2);
//        rational1.divides(rational2);
        Exercise1217_RobustRational rational3 = new Exercise1217_RobustRational(Integer.MIN_VALUE, 1);
//        rational2.minus(rational1);
    }
}