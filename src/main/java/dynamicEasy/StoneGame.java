package dynamicEasy;

public class StoneGame {
    public static void main(String[] args) {
        int[] piles = new int[]{7, 8, 8, 10};
        System.out.println(stoneGame(piles));
    }


    static public boolean stoneGame(int[] piles) {
        int length = piles.length;

        int even = 0;
        int odd = 0;

        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                even += piles[i];
            } else {
                odd += piles[i];
            }
        }

        return even != odd;

    }
}
