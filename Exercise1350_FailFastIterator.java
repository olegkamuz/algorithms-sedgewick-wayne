import java.util.ConcurrentModificationException;

public class Exercise1350_FailFastIterator {
    public static void main(String[] args) {
        NonrecurringInt nonrecurringInt = new NonrecurringInt(1000);
        Stack<Integer> stack = new Stack<>();
        fullTheStack(nonrecurringInt, stack);
        // causing ConcurrentModificationException
        testPushException(stack, nonrecurringInt);
        // causing ConcurrentModificationException
//        testPopException(stack);
    }

    private static void testPopException(Stack<Integer> stack) {
        StartAsyncStackIteration(stack);
        StartAsyncStackPop(stack);
    }

    private static void testPushException(Stack<Integer> stack, NonrecurringInt nonrecurringInt) {
        StartAsyncStackIteration(stack);
        StartAsyncStackPush(nonrecurringInt, stack);
    }

    private static void fullTheStack(NonrecurringInt nonrecurringInt, Stack<Integer> stack) {
        for (int i = 0; i < 2; i++) {
            stack.push(nonrecurringInt.getInt());
        }
    }

    private static void asyncStackPush(NonrecurringInt nonrecurringInt, Stack<Integer> stack) throws InterruptedException {
//        Thread.sleep(300); // implementing pause eliminate concurrency
        for (int i = 0; i < 10; i++) {
            stack.push(nonrecurringInt.getInt());
        }
    }

    private static void asyncStackPop(Stack<Integer> stack) throws Exception {
//        Thread.sleep(300); // implementing pause eliminate concurrency
        StdOut.println("stack size before popes: " + stack.size());
        for (int i = 0; i < 10; i++) {
            stack.pop();
            Thread.sleep(300);
        }
        StdOut.println("stack size after popes: " + stack.size());
    }

    private static void asyncStackIteration(Stack<Integer> stack) {
        for (Integer i : stack) {
            StdOut.println(i + ", iteration, stack size: " + stack.size());
        }
    }

    private static void StartAsyncStackPush(NonrecurringInt nonrecurringInt, Stack<Integer> stack) {
        Runnable task = () -> {
            try {
                asyncStackPush(nonrecurringInt, stack);
            } catch (Exception ex) {
                throw new ConcurrentModificationException(ex);
            }
        };
        new Thread(task, "asyncStackPush").start();
    }

    private static void StartAsyncStackPop(Stack<Integer> stack) {
        Runnable task = () -> {
            try {
                asyncStackPop(stack);
            } catch (Exception ex) {
                throw new ConcurrentModificationException(ex);
            }
        };
        new Thread(task, "asyncStackPop").start();
    }

    private static void StartAsyncStackIteration(Stack<Integer> stack) {
        Runnable task = () -> {
            try {
                asyncStackIteration(stack);
            } catch (Exception ex) {
                throw new ConcurrentModificationException(ex);
            }
        };
        new Thread(task, "asyncStackIteration").start();
    }
}
