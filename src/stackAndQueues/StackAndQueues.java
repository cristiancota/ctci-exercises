package stackAndQueues;

import java.util.ArrayList;
import java.util.List;

public class StackAndQueues {
    public List<CStack> threeInOne(int[] array) {
        List<CStack> result = new ArrayList<>(3);
        result.add(0, new CStack());
        result.add(1, new CStack());
        result.add(2, new CStack());

        int first, second;
        int size = array.length;
        if (size % 3 > 0) {
            first = size / 3;
            second = ((size - first) / 2) + first;
        } else {
            first = size / 3;
            second = first * 2;
        }

        for (int i = 0; i < size; i++) {
            if (i < first) {
                CStack cStack = result.get(0);
                cStack.push(array[i]);
            } else if (i < second) {
                CStack cStack = result.get(1);
                cStack.push(array[i]);
            } else {
                CStack cStack = result.get(2);
                cStack.push(array[i]);
            }
        }

        return result;
    }
}
