public class Exercise1219_ParsingTransaction implements Comparable<Exercise1219_ParsingTransaction> {
    private final String who;
    private final Date when;
    private final double amount;

    public Exercise1219_ParsingTransaction(String who, Date when, double amount){
        this.who = who;
        this.when = when;
        this.amount = amount;
    }
    public Exercise1219_ParsingTransaction(String transaction){
        String[] fields = transaction.split("\\s+");
        if (fields.length != 3) {
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
        Exercise1219_ParsingTransaction transaction = (Exercise1219_ParsingTransaction) that;
        return (this.who.equals(transaction.who)) && (this.when.equals(transaction.when)) && (this.amount == transaction.amount);
    }
    public int compareTo(Exercise1219_ParsingTransaction that){
        return 0;
    }
    public int hashCode(){
        return 1;
    }

    public static void main(String[] args){
        Exercise1219_ParsingTransaction parsingDate = new Exercise1219_ParsingTransaction("Turing 5/22/1939 11.99");
        System.out.println(parsingDate);
    }
}

