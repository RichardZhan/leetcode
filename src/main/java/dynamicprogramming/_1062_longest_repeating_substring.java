package dynamicprogramming;

/**
 * @Description: longest repeating substring
 * 1062 最长重复字串
 *
 *
 * 问题
 * 给定字符串 S，找出最长重复子串的长度。如果不存在重复子串就返回 0。
 * 示例 1：
 *
 * 输入："abcd"
 * 输出：0
 * 解释：没有重复子串。
 *
 * 示例 2：
 *
 * 输入："abbaba"
 * 输出：2
 * 解释：最长的重复子串为 "ab" 和 "ba"，每个出现 2 次。
 *
 * 示例 3：
 *
 * 输入："aabcaabdaab"
 * 输出：3
 * 解释：最长的重复子串为 "aab"，出现 3 次。
 *
 * 示例 4：
 *
 * 输入："aaaaa"
 * 输出：4
 * 解释：最长的重复子串为 "aaaa"，出现 2 次。
 *
 *
 * 提示：
 *
 * 字符串 S 仅包含从 a 到 z 的小写英文字母。
 * 1<=S.length<=1500
 *
 * @author Richard.Zhan
 * @date 2020/8/5 20:37
 */
public class _1062_longest_repeating_substring {


    /**
     * O(n^3)
     * @param str
     * @return
     */
    int longestRepeatingSubString(String str) {
        int len = str.length();
        int res = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int currLen = 0;
                for (int k = 0; k + j < len; k++) {
                    if (str.charAt(i + k) == str.charAt(j + k)){
                        currLen++;
                        res = Math.max(res,currLen);
                    } else {
                        break;
                    }
                }

            }
        }
        return res;
    }


    /**
     * 动态规划
     * @param input
     * @return
     */
    int longestRepeatingSubstring_2(String input){
        int len = input.length();
        char[] chars = input.toCharArray();

        int res = 0;

        for (int i = 0; i < len - res; i++) {
            int curr = 0;
            for (int j = i + 1,k = 0; j < len - res + curr; j++,k++) {
                if (chars[k] == chars[j]){
                    curr++;
                    res = Math.max(res,curr);
                } else {
                    curr =0;
                }
            }
        }
        return res;
    }





    public static void main(String[] args) {
        _1062_longest_repeating_substring instance = new _1062_longest_repeating_substring();
        String str = "aabcaabdaab";

        int output = 0;
        output = instance.longestRepeatingSubString(str);
        System.out.println(output);



        output = instance.longestRepeatingSubstring_2(str);
        System.out.println(output);



    }




}
