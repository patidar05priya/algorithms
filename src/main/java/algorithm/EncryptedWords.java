package algorithm;

public class EncryptedWords {
    static int priya = 0;

    public static void main(String[] args) {
        String s_2 = "abcd";
        String expected_2 = "bacd";
        String output_2 = findEncryptedWord(s_2);

        System.out.println(output_2.equals(expected_2));
        System.out.println(priya);
    }

    static String findEncryptedWord(String s) {
        String encryptedVersion = "";
        return findEncryptedWordUtil(s, encryptedVersion);

    }

    static String findEncryptedWordUtil(String input, String result) {
        if (input.length() <= 1) {
            return input;
        }

        int mid = (input.length() - 1) / 2;
        result = input.charAt(mid) + findEncryptedWordUtil(input.substring(0, mid), result);

        result = result + findEncryptedWordUtil(input.substring(mid + 1), result);


        return result;

    }

}
