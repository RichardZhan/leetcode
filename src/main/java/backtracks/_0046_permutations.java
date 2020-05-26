package backtracks;

import java.util.*;

/**
 * @author Richard.Zhan
 * @Description:
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/5/25 21:08
 */
public class _0046_permutations {


    List<List<Integer>> result = new LinkedList<>();



    public List<List<Integer>> permutations(int[] nums){
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track);
        return result;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {

        //触发结束条件
        if (track.size() == nums.length) {
            result.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //排除不合法的选择
            if (track.contains(nums[i])) {
                continue;
            }
            //做选择
            track.add(nums[i]);
            System.out.println("add:" + track);
            //进入下一层决策树
            backtrack(nums, track);
            //取消选择
            track.removeLast();
            System.out.println("remove last:" + track);
        }

    }


    public List<List<Integer>> permute(int[] nums){
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0){
            return res;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums,len,0,stack,used,res);
        return res;
    }

    private void dfs(int[] nums,int len,int depth,Deque<Integer> path,boolean[] used,List<List<Integer>> res){
        if (depth == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]){
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums,len,depth + 1,path,used,res);
            path.removeLast();
            used[i] = false;
        }
    }

    /**
     * @Description:
     *
     * 核心框架
     * for 选择 in 选择列表:
     *     # 做选择
     *     将该选择从选择列表移除
     *     路径.add(选择)
     *     backtrack(路径, 选择列表)
     *     # 撤销选择
     *     路径.remove(选择)
     *     将该选择再加入选择列表
     *
     * leetcode 官方解法
     * 广度优先遍历
     * 深度优先遍历
     *
     *
     *
     * Time complexity:
     * O(n * n!)
     *
     * Space complexity:
     * O(n * n!)
     * @Author: Richard
     * @Date: 2020/5/25 22:05
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        _0046_permutations instance = new _0046_permutations();
        List<List<Integer>> result = instance.permutations(nums);

        for (List<Integer> list : result) {
            System.out.println(list);
        }

        System.out.println("----------------------");

        result = instance.permute(nums);
        for (List<Integer> list : result) {
            System.out.println(list);
        }

    }


}
