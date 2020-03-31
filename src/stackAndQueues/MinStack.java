package stackAndQueues;

public class MinStack extends CStack<Integer> {
    CStack<Integer> minTrack;

    public MinStack() {
        minTrack = new CStack<>();
    }

    int min() {
        return minTrack.isEmpty() ? Integer.MAX_VALUE : minTrack.peek();
    }

    public void push(int item) {
        if (item <= min()) {
            minTrack.push(item);
        }
        super.push(item);
    }

    public Integer pop() {
        int pop = super.pop();
        if (pop == min()) {
            minTrack.pop();
        }

        return pop;
    }

}
