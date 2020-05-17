package algorithm;

import java.util.*;

public class LargestTripleProducts {
    static  int  priya = 1;
    private static int[] findMaxProduct(int[] arr) {
        int[] result = new int[arr.length];
        List<Integer> maxHeap = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            priya++;
            maxHeap.add(arr[i]);
            Collections.sort(maxHeap);
            if (i < 2) {
                result[i] = -1;
            } else {
                result[i] = getProduct(3, maxHeap);
            }
        }

        return result;
    }

    private static int getProduct(int k, List<Integer> maxHeap) {
        int pro = 1;
       for(int i =maxHeap.size()-1;i>= maxHeap.size()-k; i--){
           priya++;
           pro *=  maxHeap.get(i);
       }
        return pro;
    }

    public static void main(String[] args) {
        int[] arr_1 = {1, 2, 3, 4, 5};
        int[] output_1 = findMaxProduct(arr_1);
        int[] expected_1 = {-1, -1, 6, 24, 60};
        System.out.println(Arrays.toString(expected_1));
        System.out.println(Arrays.toString(output_1));

        System.out.println(priya);
    }


}
