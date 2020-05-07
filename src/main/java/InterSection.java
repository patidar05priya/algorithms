package java;

import java.util.ArrayList;
import java.util.List;

/**
 * Question : Given two lists of intervals, each interval denoted as [start, end], find the intersection (overlapped segments) between the lists
 *
 *
 */
public class InterSection {

    public static void main(String[] args) {
        List<Interval> list1 = new ArrayList<>();
        Interval i1 = new Interval(2, 6);
        list1.add(i1);
        Interval i2 = new Interval(7, 12);
        list1.add(i2);
        Interval i3 = new Interval(15, 20);
        list1.add(i3);


        List<Interval> list2 = new ArrayList<>();
        i1 = new Interval(-5, -3);
        list2.add(i1);
        i2 = new Interval(-2, 0);
        list2.add(i2);
        i3 = new Interval(1, 11);
        list2.add(i3);
        Interval i4 = new Interval(20, 30);
        list2.add(i4);
        Interval i5 = new Interval(40, 60);
        list2.add(i5);

        List<Interval> result = findIntersection(list1, list2);

        for (Interval iv : result) {
            System.out.println(iv.start + " , " + iv.end);
        }
    }

    private static List<Interval> findIntersection(List<Interval> list1, List<Interval> list2) {
        int i = 0;
        int j = 0;

        List<Interval> result = new ArrayList<>();
        while (i < list1.size() && j < list2.size()) {
            int low = Math.max(list1.get(i).start, list2.get(j).start);
            int high = Math.min(list1.get(i).end, list2.get(j).end);
            if (low <= high) {
                result.add(new Interval(low, high));
            }

            if (list1.get(i).end < list2.get(j).end) {
                i++;
            } else {
                j++;
            }
        }


        return result;
    }
}


class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

}
