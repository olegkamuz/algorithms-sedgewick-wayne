public class Exercise1317_readTransaction {
    public static void main(String[] args) {
        printTransactionFromArray(readTransaction());
    }

    private static Transaction[] readTransaction() {
        Queue<Transaction> queue = new Queue<Transaction>();
        while (!StdIn.isEmpty()) {
            String who = StdIn.readString();
            Date when = new Date(StdIn.readString());
            double amount = Double.parseDouble(StdIn.readString());
            Transaction transaction = new Transaction(who, when, amount);
            queue.enqueue(transaction);
        }
        Transaction[] transactions = new Transaction[queue.size()];
        for (int i = 0; i < transactions.length; i++) {
            transactions[i] = queue.dequeue();
        }
        return transactions;
    }

    private static void printTransactionFromArray(Transaction[] transactions) {
        for (int i = 0; i < transactions.length; i++) {
            StdOut.println(transactions[i]);
        }
    }
}

