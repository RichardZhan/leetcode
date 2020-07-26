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

    public int[] sort (int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);

        if (arr.length < 2) {
            return arr;
        }

        int middle = (int) Math.floor(arr.length / 2);


        int[] left = Arrays.copyOfRange(arr,0,middle);
        int[] right = Arrays.copyOfRange(arr,middle,arr.length);
//        System.out.println("middle: " + middle);
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));


        return merge(sort(left),sort(right));
    }

    /**
     * 合并
     * @param left
     * @param right
     * @return
     */
    private int[] merge(int[] left, int[] right) {

        System.out.println("----------------------");
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int[] result = new int[left.length + right.length];
        int i = 0;

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
