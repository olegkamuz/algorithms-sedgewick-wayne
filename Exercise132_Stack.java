import java.util.Stack;
public class Exercise132_Stack {
    public static void main(String[] args){
        String str = "it was - the best - of times - - - it was - the - -";
        String[] arrStr = str.split("\\s+");
        Stack<String> stringStack = new Stack<String>();

        for(String s: arrStr){
            if (!s.equals("-")){
                stringStack.push(s);
            } else if (!stringStack.empty()){
                System.out.print(stringStack.pop() + " ");
            }
        }
        System.out.println();
        System.out.print("(" + stringStack.size() + ") left on stack");
    }
}
