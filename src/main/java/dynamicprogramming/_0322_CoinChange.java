package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Richard.Zhan
 * @Description: 凑零钱问题
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that
 * amount. If that amount of money cannot be made up by any combination of the coins.
 * return -1.
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/5/22 11:27
 */
public class _0322_CoinChange {

    /**
     * @Description: 动态规划 自下而上
     * @Author: Richard
     * @Date: 2020/5/22 11:34
     */
    public int coinChangeBottomToUp(int[] coins, int amount){
        int max = amount + 1;
        //dp 数组记忆
        int[] dp = new int[amount + 1];
        //初始化数组
        Arrays.fill(dp,max);
        dp[0] = 0;
        //循环 1···amount 自下向上
        for (int i = 1; i <= amount; i++) {
            System.out.println("amount = " + i);
            //F(i) = min F(i-Cj) + 1
            for (int j = 0; j < coins.length; j++) {
                //单个coin 需小于amount
                if (coins[j] <= i){
                    //初始F(0)=0,单颗硬币最优解为1,即F(coins[j])=1
                    //dp 用来记忆重复数据
                    System.out.println("min:" + dp[i] + "," + (dp[i-coins[j]] +1));
                    dp[i] = Math.min(dp[i],dp[i-coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }


    /**
     * @Description: 自上向下 递归
     * @Author: Richard
     * @Date: 2020/5/22 17:07
     */
    public int coinChangeUpToBottom(int [] coins,int amount){
       if (amount <1) return 0;
       return coinChange(coins,amount,new int[amount]);
    }

    private int coinChange(int[] coins, int amount, int[] count) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (count[amount -1] != 0) {
            return count[amount -1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins,amount - coin,count);
            if (res >= 0 && res < min){
                min = 1 + res;
            }
        }
        count[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;

        return count[amount - 1];
    }


    public static void main(String[] args) {
        _0322_CoinChange instance = new _0322_CoinChange();

        int[] coins = new int[]{1,2,5};
        int amount = 11;
        int result = instance.coinChangeBottomToUp(coins,amount);
        System.out.println(result);

        result = instance.coinChangeUpToBottom(coins,amount);
        System.out.println(result);
    }
}
