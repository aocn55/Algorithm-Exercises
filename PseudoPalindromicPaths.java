package pseudoPalindromicPaths;

public class PseudoPalindromicPaths {

    /**
     * 树 类
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static int pseudoPalindromicPaths(TreeNode root) {
        /* *
         * 思路：回文序列就是一个序列倒过来和原序列相同，那么分为以下两种情况‘
         * 1 这个序列的元素有偶数个，那么这个里面的每个元素都会出现偶数次
         * 2 这个序列的元素有奇数个，那么除了中间元素出现 1 次，所有的元素也只会出现偶数次
         * 因为里面的元素只有 1-9 那么我们可以用一个 int[10] 类表示各个元素出现次数
         * 根据此结论我们可以写出isPseudoPalindrome()方法
         */

        int[] counts = new  int[10];

        /* *
         * 此时利用dfs遍历从根节点到叶子节点的所有路径
         */
        return dfs(root, counts);
    }

    public static int dfs(TreeNode node, int[] counts) {
        int res = 0;

        // 该节点为空
        if(node == null) {
            return 0;
        }

        counts[node.val]++; // 出现次数加一
        if(node.left == null && node.right == null) { /* 左右都没有孩子了 */
            // 检查此时是否可以构成回文序列
            if (isPseudoPalindrome(counts)) {
                res = 1;
            }
        }else {
            res = dfs(node.left, counts) + dfs(node.right, counts);
        }
        counts[node.val]--;
        return res;
    }
    
    public static boolean isPseudoPalindrome(int[] counts) {
        int res = 0;

        for (int count1 : counts) {
            if(count1 % 2 == 1) { /* 某个元素出现奇数次 */
                res++;
            }
        }
        return res <= 1;
    }
}
