package stackAndQueues;

public class QueueViaStack extends CStack<Integer> {
    CStack<Integer> stackA;
    CStack<Integer> stackB;

    public QueueViaStack() {
        this.stackA = new CStack<>();
        this.stackB = new CStack<>();
    }

    public void add(int item) {
        if (stackA.isEmpty()) {
            if (!stackB.isEmpty()) {
                while (!stackB.isEmpty()) {
                    stackA.push(stackB.pop());
                }
            }
        }

        stackA.push(item);
    }

    public Integer remove() {
        if (this.isEmpty()) throw new RuntimeException();

        if (stackB.isEmpty()) {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }

        return stackB.pop();
    }

    public Integer peek() {
        if (this.isEmpty()) throw new RuntimeException();

        if (stackB.isEmpty()) {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }

        return stackB.peek();
    }

    public boolean isEmpty() {
        return stackA.isEmpty() && stackB.isEmpty();
    }
}
