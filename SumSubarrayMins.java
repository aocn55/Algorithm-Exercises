package sumSubarrayMins;

public class SumSubarrayMins {
    private static final int MOD = (int) (1e9 + 7);
    public static int sumSubarrayMins(int[] arr) {
        /* *
         * 左边找大于于该元素的个数，右边找大于等于该元素的个数，防止相同元素多算
         * (leftAboveCount + rightAboveCount + leftAboveCount * rightAboveCount + 1) * val
         */
        int res = 0;
        int[] leftAboveCount = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            while (j >= 0 && arr[j] > arr[i]) {
                leftAboveCount[i]++;
                j--;
            }
        }

        int[] rightAboveCount = new int[arr.length];
        for (int i = arr.length - 2; i > -1; i--) {
            int j = i + 1;
            while (j < arr.length && arr[j] >= arr[i]) {
                rightAboveCount[i]++;
                j++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            res += ((int)(leftAboveCount[i] + rightAboveCount[i] + leftAboveCount[i] * rightAboveCount[i] + 1) * arr[i] % MOD);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        System.out.println(sumSubarrayMins(arr));
    }
}
