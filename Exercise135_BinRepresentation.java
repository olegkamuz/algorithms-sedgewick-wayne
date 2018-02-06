public class Exercise135_BinRepresentation {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<Integer>();
        int N = 50;
        while (N > 0)
        {
            stack.push(N % 2);
            N = N / 2;
        }
        for (int d : stack) StdOut.print(d);
        StdOut.println();
    }
}

