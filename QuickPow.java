package alo1210;

import java.util.ArrayList;
import java.util.List;

public class QuickPow {
    public static int quickPow(int a, int n, int m) {
        if(n == 0) {
            return 1;
        }
        if(a == 0) {
            return 0;
        }
        a %= m;
        int c = quickPow(a, n / 2, m);
        if(n % 2 == 1) {
            return c * c % m * a % m;
        }else{
            return c * c % m;
        }
    }

    /**
     * 给你一个下标从 0 开始的二维数组 variables ，其中 variables[i] = [ai, bi, ci, mi]，以及一个整数 target 。
     *
     * 如果满足以下公式，则下标 i 是 好下标：
     *
     * 0 <= i < variables.length
     * ((aibi % 10)ci) % mi == target
     * 返回一个由 好下标 组成的数组，顺序不限 。
     */

    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < variables.length; i++) {
            if(quickPow(quickPow(variables[i][0], variables[i][1], 10), variables[i][2], variables[i][3]) == target) {
                res.add(i);
            }
        }
        return res;
    }


}
