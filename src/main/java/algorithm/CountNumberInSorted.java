
package algorithm;

/**
 * Given a sorted array of integers and a target number, return the count of the target number...
 */
public class CountNumberInSorted {

    public static void main(String[] args) {
    //    int[] array = new int[]{1, 1, 4, 4, 4, 6, 6,7};
       //int[] array = new int[]{2, 2, 2,3,5,5,6,7,8,8,8,10,10,10,10,12,13};
        int[] array = new int[]{-1,-1,1,1,1,1};
        int target = -1;
        System.out.println(countNumber(array, array.length, target));
    }


    private static int countNumber(int[] array, int length, int targte) {
        return countNumberUtil(array, 0, length - 1, 0, targte);
    }

    private static int countNumberUtil(int[] array, int start, int end, int result, int targte) {
        if (start > end) {
            return result;
        }
        int mid = start + ((end - start) / 2);

        if (array[mid] == targte) {
            result++;

        }
        if (array[mid] >= targte)
            result = countNumberUtil(array, start, mid - 1, result, targte);

        if (array[mid] <= targte)
            result = countNumberUtil(array, mid + 1, end, result, targte);
        return result;

    }
}
