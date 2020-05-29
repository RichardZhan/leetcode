package dynamicprogramming;

import java.util.*;

/**
 * @author Richard.Zhan
 * @Description: 组合总和
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/5/22 16:13
 */
public class _0039_combination_sum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer,Set<List<Integer>>> map = new HashMap<>();
        //对candidates数组进行排序
        Arrays.sort(candidates);
        int len = candidates.length;
        for(int i = 1;i <= target;i++){
            //初始化map
            map.put(i,new HashSet<>());
            //对candidates数组进行循环
            for(int j = 0;j < len&&candidates[j] <= target;j++){
                if(i == candidates[j]){
                    //相等即为相减为0的情况，直接加入set集合即可
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    map.get(i).add(temp);
                }else if(i > candidates[j]){
                    //i-candidates[j]是map的key
                    int key = i-candidates[j];
                    //使用迭代器对对应key的set集合进行遍历
                    //如果candidates数组不包含这个key值，对应的set集合会为空，故这里不需要做单独判断
                    for(Iterator iterator = map.get(key).iterator();iterator.hasNext();){
                        List list = (List) iterator.next();
                        //set集合里面的每一个list都要加入candidates[j]，然后放入到以i为key的集合中
                        List tempList = new ArrayList<>();
                        tempList.addAll(list);
                        tempList.add(candidates[j]);
                        //排序是为了通过set集合去重
                        Collections.sort(tempList);
                        map.get(i).add(tempList);
                    }
                }
            }
        }
        result.addAll(map.get(target));
        return result;
    }


    /**
     * @Description: 凑零钱问题转换 自下向上递归
     * @Author: Richard
     * @Date: 2020/5/22 18:08
     */
    public List<List<Integer>> coinChange(int[] coins,int amount){
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer,Set<List<Integer>>> map = new HashMap<>();

        Arrays.sort(coins);
        for (int i = 1; i <= amount; i++) {
            map.put(i,new HashSet<>());
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > amount) {
                    continue;
                }
                if (i == coins[j]){
                    map.get(i).add(new ArrayList<>(Arrays.asList(i)));
                    System.out.println(map.get(i));
                } else if (i > coins[j]){
                    int key = i - coins[j];
                    if (map.get(key) != null){
                        for (List<Integer> list : map.get(key)) {
                            List temp = new ArrayList();
                            temp.addAll(list);
                            temp.add(coins[j]);
                            Collections.sort(temp);
                            map.get(i).add(temp);
                        }
                    }
                }
            }

        }
        map.forEach((k,v) ->{
            System.out.println(k);
            System.out.println(v);
        });


        result.addAll(map.get(amount));
        return result;
    }




    public static void main(String[] args) {
        _0039_combination_sum instance = new _0039_combination_sum();
        int[] candidates = new int[]{1,2,5};
        int target = 11;
        List<List<Integer>> result = instance.combinationSum(candidates,target);
        result.forEach( e ->{
            System.out.println(e);
        });

        System.out.println("----------------------------------");

        result = instance.coinChange(candidates,target);
        System.out.println("----------------------------------");
        result.forEach(e ->{
            System.out.println(e);
        });
    }



}
