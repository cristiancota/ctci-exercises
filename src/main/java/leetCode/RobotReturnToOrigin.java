package leetCode;

public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int upCount = 0;
        int downCount = 0;
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'U':
                    upCount++;
                    break;
                case 'D':
                    downCount++;
                    break;
                case 'L':
                    leftCount++;
                    break;
                case 'R':
                    rightCount++;
                    break;
            }
        }
        return upCount == downCount && leftCount == rightCount;
    }
}
