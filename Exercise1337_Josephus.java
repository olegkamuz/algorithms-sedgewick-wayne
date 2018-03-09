public class Exercise1337_Josephus {
    public static void main(String[] args) {
        Queue<Integer> josephus = new Queue<>();
        addToCircle(7, 2, josephus);
        eliminate(josephus);
    }

    private static void eliminate(Queue<Integer> josephus) {
        for (Integer i : josephus) {
            StdOut.print(i + " ");
        }
    }

    private static void addToCircle(int membersCount, int step, Queue<Integer> josephus) {
        int[] arr = new int[membersCount];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int i = step - 1;
        while (membersCount != 0) {
            for (; i < arr.length && membersCount != 0; ) {
                josephus.enqueue(arr[i]);
                membersCount--;
                i += 2;
                if (i >= arr.length) {
                    i = i - arr.length;
                }
            }
        }
    }

}
