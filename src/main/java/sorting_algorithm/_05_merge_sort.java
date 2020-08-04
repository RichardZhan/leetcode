package sorting_algorithm;

import java.util.Arrays;

/**
 * @author Richard.Zhan
 * @Description: merge sort
 * 归并排序
 *
 * 分治法 Divide and Conquer 的典型应用
 *
 * 实现：
 * - 自上而下的归并 (所有递归的方法都可以用迭代重写)
 * - 自下而上的迭代
 *
 * @date 2020/7/26 16:21
 */
public class _05_merge_sort {

    /**
     * 分治法，自下而上迭代，两两比较
     * @param sourceArray
     * @return
     */
    public int[] sort (int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);

        if (arr.length < 2) {
            return arr;
        }

        int middle = (int) Math.floor(arr.length / 2);

        int[] left = Arrays.copyOfRange(arr,0,middle);
        int[] right = Arrays.copyOfRange(arr,middle,arr.length);

        return merge(sort(left),sort(right));
    }

    /**
     * 合并
     * @param left
     * @param right
     * @return
     */
    private int[] merge(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];
        int i = 0;

        // 循环比较两有序集合的第一位
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left,1,left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right,1,right.length);
            }
        }
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left,1,left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right,1,right.length);
        }

        System.out.println("result: " + Arrays.toString(result));
        return result;
    }


    public static void main(String[] args) {
        _05_merge_sort instance = new _05_merge_sort();

//        int[] sourceArray = new int[] {10,9,8,7,6,5,4,3,2,1};
        int[] sourceArray = new int[] {5,1,1,2,0,0};

        int[] arr = instance.sort(sourceArray);

        System.out.println(Arrays.toString(arr));

    }

}
