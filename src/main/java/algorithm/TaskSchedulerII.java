package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of numbers [1, 2, 3, 1, 4, 2, ..... ]. (Notice there could be duplicate) Also given an integer N, which means two same numbers must be N space away.
 * You are going to write a program to find out a way to padding zeros to these numbers with the minimum total length...
 * <p>
 * input  = [1, 2, 3, 1, 2, 2] and N=1
 * output = [1, 2, 3, 1, 2, 0, 2]
 */
public class TaskSchedulerII {

    public static void main(String[] args) {

        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(1);
        input.add(2);
        input.add(2);
        int N = 1;

        System.out.println(input);
        taskScheduler(input, N);
        System.out.println(input);


    }

    public static void taskScheduler(List<Integer> input, int N) {
        Map<Integer, Integer> tracker = new HashMap<>();
        for (int i = 0; i < input.size(); i++) {
            int currentValue = input.get(i);
            if (tracker.containsKey(currentValue)) {
                int oldIndex = tracker.get(currentValue);
                if (i - oldIndex > N) {
                    tracker.put(currentValue, i);
                } else {
                    int noOfInsertion = N - (i - oldIndex) + 1;
                    while (noOfInsertion > 0) {
                        input.add(i, 0);
                        noOfInsertion--;
                    }
                }

            } else {
                tracker.put(currentValue, i);
            }

        }
    }
}
