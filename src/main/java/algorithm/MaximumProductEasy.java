package algorithm;

import java.util.Arrays;

public class MaximumProductEasy {
    public static void main(String[] args) {
        int[] nums = new int[]{1,5,4,5,6};
        System.out.println(maxProduct(nums));
    }

    static public int maxProduct(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        return (nums[len-1]-1) * (nums[len-2]-1);
    }
}
