package dynamicEasy;

public class MinimumCostTreeFromLeafValues {
    public static void main(String[] args) {
        int[] tree = new int[]{6, 2, 4};
        System.out.println(mctFromLeafValues(tree));
    }

    static public int mctFromLeafValues(int[] arr) {
        int count = 0;
        int n = arr.length;

        if (n <= 1) return 0;

        int first = 0;
        int second = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {


        }

        System.out.println(first);
        System.out.println(second);
        return count;
    }
}
