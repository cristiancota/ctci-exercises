package leetCode;

public class AngleBetweenHandsOfClock {
    public double angleClock(int hour, int minutes) {
        hour = hour == 12 ? 0 : hour;
        double minutesFactor = minutes / 60.0;
        double minuteDegree = minutesFactor * 360;
        double hourDegree = (hour + minutesFactor) * 30;
        double difference = Math.abs(hourDegree - minuteDegree);
        return difference > 180 ? 360 - difference : difference;
    }
}
