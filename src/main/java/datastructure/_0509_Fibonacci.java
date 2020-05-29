package datastructure;


/**
 * @author Richard.Zhan
 * @Description: Fibonacci
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987
 * @date 2020/5/15 11:12
 */
public class _0509_Fibonacci {


    /**
     * @Description: 1. 递归通项公式
     * 递归树写法
     * 时间复杂度 O(2^n) 指数级别 爆炸
     * @Author: Richard
     * @Date: 2020/5/15 11:17
     */
    public int fibonacci(int n) {
        if (n < 2){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }


    /**
     * @Description: 2. java快捷版
     * @Author: Richard
     * @Date: 2020/5/15 11:23
     */
    public int fibonacciFast(int n){
        if (n < 2){
            return n;
        } else {
            int[] ans = new int[n+1];
            ans[0] = 0;
            ans[1] = 1;
            for (int i = 2; i <= n; i++) {
                ans[i] = ans[i-1] + ans[i-2];
                System.out.println(i + "===" + ans[i]);
            }
            return ans[n];
        }

    }


    /**
     * @Description: 2. 记忆化自低向上递归
     * @Author: Richard
     * @Date: 2020/5/21 15:53
     */
    public int fibonacciMemoizeDownUp(int n){
        if (n <= 1) {
            return n;
        }

        return memoize(n);
        
    }

    private int memoize(int n) {
        int[] cache = new int[n+1];
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i-1] + cache[i-2];
            System.out.println("cache==" + cache[i]);
        }
        return cache[n];
    }

    private Integer[] cache ;

    /**
     * @Description: 3. 记忆化自顶向下
     * @Author: Richard
     * @Date: 2020/5/21 16:14
     */
    public int fibonacciMemoizeUpDown(int n){
        if (n <= 1) {
            return n;
        }
        cache = new Integer[n+1];
        cache [0] = 0;
        cache [1] = 1;

        return memoizeDown(n);
    }

    private int memoizeDown(int n) {
        if (null != cache[n]) {
            return cache[n];
        }

        cache[n] = memoizeDown(n-1) + memoizeDown(n-2);
        System.out.println(cache[n]);
        return cache[n];
    }

    /**
     * @Description: 4. 自底向上迭代
     * @Author: Richard
     * @Date: 2020/5/21 16:45
     */
    public int fibonacciDownUp2(int n){

        if (n < 2) return n;
        if (n == 2) return 1;

        int current = 0;
        int var1 = 1;
        int var2 = 1;

        for (int i = 3; i <= n; i++) {
            current = var1 + var2;
            var2 = var1;
            var1 = current;
        }
        return current;

    }


    /**
     * @Description: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987
     * @Author: Richard
     * @Date: 2020/5/21 16:56
     */
    public static void main(String[] args) {
        int n = 10;

        //通项公式
        _0509_Fibonacci instance = new _0509_Fibonacci();
        int result = instance.fibonacci(n);
        System.out.println(result);

        //java快捷版
        result = instance.fibonacciFast(n);
        System.out.println(result);

        //带备忘录的递归解法
        result = instance.fibonacciMemoizeDownUp(n);
        System.out.println(result);

        //记忆化自顶向下
        result = instance.fibonacciMemoizeUpDown(n);
        System.out.println(result);

        //自顶向下迭代
        result = instance.fibonacciDownUp2(n);
        System.out.println(result);

        //矩阵求幂

        //使用黄金分割比 公式求解

    }

}
