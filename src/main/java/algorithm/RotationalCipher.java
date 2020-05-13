package algorithm;

/**
 * Given a string and a rotation factor, return an encrypted string.
 */
public class RotationalCipher {
    public static void main(String[] args) {
        String input = "abcdefghijklmNOPQRSTUVWXYZ0123456789";
        int rotationFactor = 39;
        String expected = "nopqrstuvwxyzABCDEFGHIJKLM9012345678";
        String result = rotationalCipher(input, rotationFactor);
        System.out.println(result);
        System.out.println(expected.equals(result));
    }

    /**
     *
     */
    static String rotationalCipher(String input, int rotationFactor) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (Character.isLowerCase(input.charAt(i))) {
                char ch = (char) (((int) input.charAt(i) +
                        rotationFactor - 97) % 26 + 97);
                result.append(ch);
            } else if (Character.isUpperCase(input.charAt(i))) {
                char ch = (char) (((int) input.charAt(i) +
                        rotationFactor - 65) % 26 + 65);
                result.append(ch);
            } else if (Character.isDigit(input.charAt(i))) {
                int newDigit = ((input.charAt(i) +
                        rotationFactor )- 48 )% 10 + 48;
                result.append((char)newDigit);
            } else {
                result.append(input.charAt(i));
            }

        }

        return result.toString();
    }

}
