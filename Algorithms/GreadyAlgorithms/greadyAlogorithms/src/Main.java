import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args){
        List<Activity> activities = new ArrayList<>();
        PriorityQueue<Activity> activityPriorityQueue = new PriorityQueue<>();

        activities.add(new Activity(1, 600, 720));
        activities.add(new Activity(2, 1200, 1380));
        activities.add(new Activity(3, 1020, 1140));
        activities.add(new Activity(4, 600, 630));
        activities.add(new Activity(5, 1140, 1230));
        activities.add(new Activity(6, 1290, 1380));
        activities.add(new Activity(7, 750, 810));
        activities.add(new Activity(8, 1200, 1320));
        activities.add(new Activity(9, 1020, 1170));
        activities.add(new Activity(10, 960, 1140));
        activities.add(new Activity(11, 900, 1020));



        activityPriorityQueue.add(new Activity(1, 600, 720));
        activityPriorityQueue.add(new Activity(2, 1200, 1380));
        activityPriorityQueue.add(new Activity(3, 1020, 1140));
        activityPriorityQueue.add(new Activity(4, 600, 630));
        activityPriorityQueue.add(new Activity(5, 1140, 1230));
        activityPriorityQueue.add(new Activity(6, 1290, 1380));

        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(jump(nums));




//        for(Activity i : activityPriorityQueue){
//            System.out.println(i.endTime);
//        }

//        while(true){
//           Activity  activity =  activityPriorityQueue.poll();
//            System.out.println("id : "+ activity.id + " EndTime : " + activity.endTime);
//        }

//        List<Activity> selectedActivities = select(activities);
//        for(Activity i : selectedActivities){
//            System.out.println(i.id);
//        }



    }

    public static List<Activity> select(List<Activity> activities){
        List<Activity> selectedActivities = new ArrayList<>();
        Collections.sort(activities);
        if(activities.size() > 0){
            selectedActivities.add(activities.get(0));
        }
        for(int i =1; i< activities.size(); i++){
            if(activities.get(i).startTime >= selectedActivities.get(selectedActivities.size()-1).endTime){
                selectedActivities.add(activities.get(i));
            }
        }
        return selectedActivities;
    }

    public  static int jump(int[] nums) {
        int counter = 1;
        int accumulator = 0;
        for(int i = 0; i < nums.length; i++){
            accumulator += nums[i];
            if(accumulator >= nums.length){
                return counter;
            }else{
                counter++;
            }

        }
        return counter;
    }



}
