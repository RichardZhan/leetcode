package twopoints;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Richard.Zhan
 * @Description:
 * Given a string S and a string T,find the minimum window in S
 * which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEABANC", t = "ABC"
 * Output: "BANC"
 *
 *
 * 字串强调连续性
 * t中可能包含重复字符
 * 唯一答案
 *
 * @date 2020/6/23 17:27
 */
public class _0076_minimum_window_substring {


    /**
     * 暴力解法
     * 枚举输入字符串s所有长度大于等于t的字串
     * 逐个判断哪些子串包含t的所有字符
     * 枚举过程中记录符合条件长度最短的字串
     * @param s
     * @param t
     * @return
     */


    /**
     *
     * 要点：
     * 1. 如何判断s的字串包含了t中的所有字符
     * 分别统计s的字串和t中每个字符出现的次数，逐个比多
     * 字符频数数组
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s,String t){
        int sLen = s.length();
        int tLen = t.length();

        if (sLen == 0 || tLen == 0 || sLen < tLen || sLen > Integer.MAX_VALUE){
            return "";
        }


        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        // ascii('z') = 122
        int[] winFreq = new int[128];
        int[] tFreq = new int[128];

        for (char c : charArrayT) {
            System.out.println(c);
            tFreq[c]++;
        }

        // 滑动窗口内部包含多少T中的字符，对应字符频数超过不重复计算
        int distance = 0;
        int minLen = sLen + 1;
        int begin = 0;

        int left = 0;
        int right = 0;
        // [left, right)
        while (right < sLen) {
            System.out.println("right:" + right + "charArrayS[right]:" + charArrayS[right]);
            if (tFreq[charArrayS[right]] == 0){
                right ++;
                continue;
            }

            if (winFreq[charArrayS[right]] < tFreq[charArrayS[right]]){
                distance++;
            }

            winFreq[charArrayS[right]]++;
            right++;

            // 做边界向右边移动 distance == tLen时满足窗口包含t的条件
            // 满足条件包含频数相等且目标长度等于目标长度
            while (distance == tLen){
                System.out.println("distance" + distance);
                if (right - left < minLen){
                    minLen = right - left;
                    begin = left;
                }

                if (tFreq[charArrayS[left]] == 0){
                    left++;
                    continue;
                }

                if (winFreq[charArrayS[left]] == tFreq[charArrayS[left]]) {
                    distance--;
                }
                winFreq[charArrayS[left]]--;
                left++;
            }
        }

        if (minLen == sLen +1){
            return "";
        }


        return s.substring(begin,begin + minLen);
    }




    Map<Character,Integer> ori = new HashMap<>();
    Map<Character,Integer> cnt = new HashMap<>();



    /**
     * 哈希表解决最小覆盖字串问题
     * @param s
     * @param t
     * @return
     */
    public String minWindowMap(String s,String t) {

        int tLen = t.length();
        // 初始化频数哈希表
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c,ori.getOrDefault(c,0) + 1);
        }
        int left = 0;
        int right = -1;
        int len = Integer.MAX_VALUE;
        int ansL = -1;
        int ansR = -1;
        int sLen = s.length();
        // 结束套件 right = sLen
        while (right < sLen){
            ++right;
            if (right < sLen && ori.containsKey(s.charAt(right))){
                cnt.put(s.charAt(right),cnt.getOrDefault(s.charAt(right),0) + 1);
            }
            // 校验窗口哈希表是否满足频数哈希表
            while (check() && left <= right){
                if (right - left + 1 < len){
                    len = right - left + 1;
                    ansL = left;
                    ansR= left + len;
                }
                if (ori.containsKey(s.charAt(left))) {
                    cnt.put(s.charAt(left),cnt.getOrDefault(s.charAt(left),0)-1);
                }
                ++left;
            }
        }



        return ansL == -1 ? "" : s.substring(ansL,ansR);
    }

    /**
     * 校验目标频数哈希表对应的数量是否满足
     * @return
     */
    public boolean check() {
        Iterator iter =ori.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key,0) < val){
                return false;
            }
        }
        return true;

    }


    /**
     * 使用distance计数判定条件哈希表实现
     * @param s
     * @param t
     * @return
     */
    public String minWindowMapDistance(String s,String t){

        int sLen = s.length();
        int tLen = t.length();

        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }

        Map<Character,Integer> winMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            tMap.put(c,tMap.getOrDefault(c,0) + 1);
        }

        int left = 0;
        int right = 0;
        int distance = 0;
        int minLen = sLen + 1;
        int begin = 0;

        while (right < sLen) {
            char c = s.charAt(right);
            if (!tMap.containsKey(c)){
                right++;
                continue;
            }

            if (winMap.getOrDefault(c,0) < tMap.get(c)){
                distance ++;
            }

            winMap.put(c,winMap.getOrDefault(c,0) + 1);
            right ++;

            while (distance == tLen){

                char lc = s.charAt(left);
                if (right - left < minLen){
                    minLen = right - left;
                    begin = left;
                }

                if (!tMap.containsKey(lc)){
                    left ++;
                    continue;
                }

                if (winMap.get(lc) == tMap.get(lc)){
                    distance --;
                }
                winMap.put(lc,winMap.getOrDefault(lc,0) - 1);

                left ++;

            }

        }



        return minLen == sLen + 1 && begin + minLen < sLen ? "" : s.substring(begin,begin + minLen);

    }






    public static void main(String[] args) {

        _0076_minimum_window_substring instance = new _0076_minimum_window_substring();

        // 测试用例
        String s = "ADOBECODEBANC";
        String t = "ABC";


//        String s = "a";
//        String t = "a";

        String output = "";

        output = instance.minWindow(s,t);
        System.out.println(output);

        System.out.println("------------------------------");

        output = instance.minWindowMap(s,t);
        System.out.println(output);


        System.out.println("------------------------------");
        System.out.println(instance.minWindowMapDistance(s,t));





    }



}
