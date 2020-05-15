package datastructure;

/**
 * @author Richard.Zhan
 * @Description: Fibonacci
 * @date 2020/5/15 11:12
 */
public class Fibonacci {


    /**
     * @Description: 递归通项公式
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
     * @Description: java快捷版
     * @Author: Richard
     * @Date: 2020/5/15 11:23
     */
    public int fibonacciFast(int n){
        if (n < 2){
            return n;
        } else {
            int[] ans = new int[n];
            ans[0] = 1;
            ans[1] = 1;
            for (int i = 2; i < n; i++) {
                ans[i] = ans[i-1] + ans[i-2];
                System.out.println(i + "===" + ans[i]);
            }
            return ans[n-1];
        }

    }



    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int result = fibonacci.fibonacci(10);
        System.out.println(result);

        result = fibonacci.fibonacciFast(10);
        System.out.println(result);

    }

}
