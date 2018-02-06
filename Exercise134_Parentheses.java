public class Exercise134_Parentheses {
    public static void main(String[] args) {
        String string1 = "[()]{}{[()()]()}";
        String string2 = "[(])";
        printCheck(isBalanced(string1), string1);
        printCheck(isBalanced(string2), string2);
    }

    private static boolean isBalanced(String string) {
        String[] arr = string.split("");
        Stack<String> stackOpen = new Stack<String>();
        for (String s : arr) {
            if (s.equals("[") || s.equals("{") || s.equals("(")) stackOpen.push(s);
            else if (stackOpen.isEmpty()) return false;
            else if (s.equals("]") && !stackOpen.pop().equals("[")) return false;
            else if (s.equals("}") && !stackOpen.pop().equals("{")) return false;
            else if (s.equals(")") && !stackOpen.pop().equals("(")) return false;
        }
        if (!stackOpen.isEmpty()) return false;
        return true;
    }

    private static void printCheck(boolean isBalanced, String string) {
        if (isBalanced) {
            System.out.printf("String %1s is balanced", string);
        } else {
            System.out.printf("String %1s is unbalanced", string);
        }
        System.out.println();
    }
}
