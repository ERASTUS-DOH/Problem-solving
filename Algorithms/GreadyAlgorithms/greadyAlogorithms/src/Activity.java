public class Activity implements Comparable<Activity> {
    public int id;
    public int startTime;
    public int endTime;

    public Activity(int id, int startTime, int endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    @Override
    public int compareTo(Activity a1) {
        return Integer.signum(this.endTime - a1.endTime);
    }
}
