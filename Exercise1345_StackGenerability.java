public class Exercise1345_StackGenerability {
    public static void main(String[] args) {
        StdOut.println();
        checkSequenceUnderflow("0 1 2 - - -", false);
        checkSequenceUnderflow("0 1 2 - - - 3 4 5 - - 6 - - -", true);
        checkSequenceUnderflow("0 - - 1 2 -", true);

        checkPermutationGenerability("4 3 2 1 0 9 8 7 6 5", true);
        checkPermutationGenerability("4 6 8 7 5 3 2 9 0 1", false);
        checkPermutationGenerability("2 5 6 7 4 8 9 3 1 0", true);
        checkPermutationGenerability("4 3 2 1 0 5 6 7 8 9", true);
        checkPermutationGenerability("1 2 3 4 5 6 9 8 7 0", true);
        checkPermutationGenerability("0 4 6 5 3 8 1 7 2 9", false);
        checkPermutationGenerability("1 4 7 9 8 6 5 3 0 2", false);
        checkPermutationGenerability("2 1 4 3 6 5 8 7 9 0", true);
    }

    private static void checkPermutationGenerability(String string, boolean expected) {
        StdOut.println("if permutation can be generated: " + string);
        StdOut.println(ifPermutationGenerable(string) + " Expected:" + expected);
        StdOut.println();
    }

    private static void checkSequenceUnderflow(String string, boolean expected) {
        StdOut.println("if input underflow:\n" + string);
        StdOut.println(ifUnderflow(string) + " Expected: " + expected);
        StdOut.println();
    }

    private static boolean ifUnderflow(String string) {
        String[] sequence = string.split(" ");
        int checker = 0;
        for (String s : sequence) {
            if (s.equals("-")) {
                checker--;
                if (checker < 0) return true;
            } else {
                checker++;
            }
        }
        return false;
    }

    private static boolean ifPermutationGenerable(String string) {
        String[] permutation = string.split(" ");
        int current = 0;
        Stack<Integer> stack = new Stack<>();
        for (String s : permutation) {
            int intValue = Integer.parseInt(s);
            if (stack.isEmpty() || intValue > stack.peek()) {
                while (current < intValue) {
                    stack.push(current);
                    current++;
                }
                current++;
            } else if (intValue == stack.peek()) {
                stack.pop();
            } else {
                return false;
            }
        }
        return true;
    }
}
