public class Exercise139_MissingParentheses {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<String> stringsStack = new Stack<String>();
        String string = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        String[] arr = string.split(" ");
        for (String s: arr) {
            if (s.equals("("));
            else if (s.equals("+"))ops.push(s);
            else if (s.equals("-"))ops.push(s);
            else if (s.equals("*"))ops.push(s);
            else if (s.equals("/"))ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                if (op.equals("+")) {
                    String rightOperand = stringsStack.pop();
                    String leftOperand = stringsStack.pop();
                    stringsStack.push(" ( " + leftOperand + " + " + rightOperand + " ) ") ;
                }
                else if (op.equals("-")) {
                    String rightOperand = stringsStack.pop();
                    String leftOperand = stringsStack.pop();
                    stringsStack.push(" ( " + leftOperand + " - " + rightOperand + " ) ") ;
                }
                else if (op.equals("*")){
                    String rightOperand = stringsStack.pop();
                    String leftOperand = stringsStack.pop();
                    stringsStack.push(" ( " + leftOperand + " * " + rightOperand + " ) ") ;
                }
                else if (op.equals("/")){
                    String rightOperand = stringsStack.pop();
                    String leftOperand = stringsStack.pop();
                    stringsStack.push(" ( " + leftOperand + " / " + rightOperand + " ) ") ;
                }
            } else {
                stringsStack.push(s);
            }
        }
        for (String s: stringsStack){
            StdOut.print(s);
        }
    }
}
