package uniqueLetterString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueLetterString {
    public static int uniqueLetterString(String s) {
        int res = 0;
        /* *
         * 思路：获取到所有的子字符串后
         * 因为所有的字符都是大写字母，用一个大小为26的数组维护每个字符出现的次序
         * 去遍历数组中所有的 1 的数量，res加这个数量
         *
         */
        List<String> subString = getAllSubString(s);
        for(String s1 : subString) {
            int[] count = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                count[s1.charAt(i) - 'A']++;
            }

            for (int i = 0; i < 26; i++) {
                if (count[i] == 1){
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 获取所有的字符串方法
     * @param s
     * @return
     */
    public static List<String> getAllSubString(String s) {
        List<String> res = new ArrayList<>();
        int length = s.length();
        for(int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                String s1 = s.substring(i , j + 1);
                res.add(s1);
            }
        }
        return res;
    }

    /**
     * 观看题解写出的方法，之前的方法超时了
     * @param s
     * @return
     */
    public static int uniqueLetterString1(String s){
        int res = 0;
        Map<Character, List<Integer>> map = new HashMap<>();
        char[] chars = s.toCharArray();

        // 获取字符串中每个字符的下标，有可能出现多次
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], new ArrayList<Integer>());
            }
            map.get(chars[i]).add(i);
        }


        for(Map.Entry<Character,List<Integer>> entry : map.entrySet()) {
            int head = -1, tail = -1;
            List<Integer> temp = entry.getValue();
            for (int i = 0; i < temp.size(); i++) {
                tail = (i < temp.size() - 1) ? temp.get(i + 1) : chars.length; // temp.get(i+1) 是下一个字符出现的位置
                res += (temp.get(i) - head) * (tail - temp.get(i));
                head = temp.get(i);
            }
        }
        return res;
    }




    public static void main(String[] args) {
        String s = "LEETCODE";
        System.out.println(uniqueLetterString1(s));
    }
}
