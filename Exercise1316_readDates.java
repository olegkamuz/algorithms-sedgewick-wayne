public class Exercise1316_readDates {
    public static void main(String[] args) {
        printDateFromArray(readDates());
    }
    private static Date[] readDates() {
        Queue<Date> queue = new Queue<Date>();
        while (!StdIn.isEmpty()){
            Date date = new Date(StdIn.readString());
            queue.enqueue(date);
        }
        Date[] dates = new Date[queue.size()];
        for (int i = 0; i < dates.length; i++) {
            dates[i] = queue.dequeue();
        }
        return dates;
    }
    private static void printDateFromArray(Date[] dates){
        for (int i = 0; i < dates.length; i++) {
            StdOut.println(dates[i]);
        }
    }
}
