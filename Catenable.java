public interface Catenable<Item> {
    Stack catenation(Stack<Item> stack1, Stack<Item> stack2);
    Queue catenation(Queue<Item> queue1, Queue<Item> queue2);
    Steque catenation(Steque<Item> steque1, Steque<Item> steque2);
}
