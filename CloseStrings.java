package closeStrings;

import java.util.Arrays;

public class CloseStrings {
    /**
     *
     * @param word1
     * @param word2
     * @return
     */
    public static boolean closeStrings(String word1, String word2) {
        int[] count1 = getCounts(word1);
        int[] count2 = getCounts(word2);

        for (int  i = 0; i < 26; i++) {
            if (count1[i] > 0 && count2[i] == 0 || count1[i] == 0 && count2[i] > 0) {
                return false;
            }
        }

        Arrays.sort(count1);
        Arrays.sort(count2);
        return Arrays.equals(count1, count2);
    }

    public static int[] getCounts(String word) {
        int[] counts = new int[26];
        char[] chars = word.toCharArray();

        for (char aChar : chars) {
            counts[aChar - 'a']++;
        }

        return counts;
    }


    public static void main(String[] args) {
        String word1 = "aacabb";
        String word2 = "bbcbaa";
    }
}
