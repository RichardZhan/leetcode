package sorting_algorithm;

import java.util.Arrays;

/**
 * @author Richard.Zhan
 * @Description: quick sort
 * 快速排序
 *
 * 使用分治法 Divide and Conquer 策略来把一个串行list分为两个子串 sublist
 * 也是分而治之思想在排序算法的典型应用
 * 本质来看快速排序应该算是冒泡排序基础上的递归分治法
 * @date 2020/7/26 17:53
 */
public class _06_quick_sort {

    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);

        return quickSort(arr,0,arr.length - 1);
    }


    /**
     * 分治
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int[] quickSort(int[] arr, int left, int right) {

        // 退出条件 left >= right
        // System.out.println("quickSort(): left:" + left + "       right:" + right );
        if (left < right) {
            int partitionIndex = partition(arr,left,right);
            System.out.println("partitionIndex:" + partitionIndex + "            " + Arrays.toString(arr));

            quickSort(arr,left,partitionIndex - 1);
            quickSort(arr,partitionIndex + 1,right);
        }

        return arr;
    }

    /**
     * 划分
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] arr, int left, int right) {
        // 设定基准值
        int pivot = left;
        // System.out.println("pivot:" + pivot);

        int pivot_index = pivot + 1;

        // System.out.println("partition swap: [" + index + "," + right + "]" );
        for (int i = pivot_index; i <= right; i++) {
            // 与基准比较,比基准小的排在左边，更新基准下标
            if (arr[i] < arr[pivot]) {
                swap(arr,i,pivot_index);
                pivot_index ++;
            }
        }
        swap(arr,pivot,pivot_index - 1);
        return pivot_index - 1;
    }

    /**
     * 交换
     *
     * @param arr
     * @param i
     * @param j
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        _06_quick_sort instance = new _06_quick_sort();
        int[] arr = new int[]{47,29,71,99,78,19,24,47};
        int[] output = instance.sort(arr);
        System.out.println(Arrays.toString(output));



    }


}
