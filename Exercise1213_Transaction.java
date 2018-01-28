public class Exercise1213_Transaction implements Comparable<Exercise1213_Transaction> {
    private final String who;
    private final Date when;
    private final double amount;

    public Exercise1213_Transaction(String who, Date when, double amount){
        this.who = who;
        this.when = when;
        this.amount = amount;
    }
    public Exercise1213_Transaction(String transaction){
        String[] fields = transaction.split("\\s+");
        if (fields.length != 3){
            throw new IllegalArgumentException("Invalid transaction");
        }
        this.who = fields[0];
        this.when = new Date(fields[1]);
        this.amount = Double.parseDouble(fields[2]);
    }
    public String who(){
        return this.who;
    }
    public Date when(){ return this.when; }
    public double amount(){ return  this.amount; }
    public String toString(){
        return String.format("%10s %10s %8.2f", who, when, amount);
    }
    public boolean equals(Object that){
        if (that == this) return true;
        if (that == null) return false;
        if (that.getClass() != this.getClass()) return false;
        Exercise1213_Transaction transaction = (Exercise1213_Transaction) that;
        return (this.who.equals(transaction.who)) && (this.when.equals(transaction.when)) && (this.amount == transaction.amount);
    }
    public int compareTo(Exercise1213_Transaction that){
        return 0;
//        if (this.who == that.who && this.when.equals(that.when)){
//            if(this.amount < that.amount) return -1;
//            if(this.amount > that.amount) return +1;
//            return 0;
//        }
//        return 0;
    }
    public int hashCode(){
        return 1;
    }
}
