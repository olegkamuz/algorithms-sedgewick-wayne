public class CatenableClass<Item> implements Catenable<Item> {
    public Stack catenation(Stack<Item> stack1, Stack<Item> stack2) {
        Stack<Item> stackTemp = new Stack<>();
        for (Item item : stack2) {
            stackTemp.push(item);
        }
        while (!stackTemp.isEmpty()) {
            stack1.push(stackTemp.pop());
        }
        return stack1;
    }

    public Queue catenation(Queue<Item> queue1, Queue<Item> queue2) {
        while (!queue2.isEmpty()) {
            queue1.enqueue(queue2.dequeue());
        }
        return queue1;
    }

    public Steque catenation(Steque<Item> steque1, Steque<Item> steque2) {
        while (!steque2.isEmpty()) {
            steque1.enqueue(steque2.pop());
        }
        return steque1;
    }
}
