package sorting_algorithm;

import java.util.Arrays;

/**
 * @author Richard.Zhan
 * @Description: selection sort
 * 选择排序
 *
 *
 * 时间复杂度: O(n^2)
 * 数据规模越小越好
 * 不占用额外的内存空间
 * @date 2020/7/26 15:06
 */
public class _02_selection_sort {


    /**
     * 外层循环为已排序集合，内层循环为未排序集合
     * 内层循环每次找出最小值插入已排序的尾巴
     * @param sourceArray
     * @return
     */
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);

        // 区间 [0,arr.length - 1]
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // 区间 [i + 1, arr.length - 1]
            // 找出区间内的最小值
            for (int j =  i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]){
                    min = j;
                }
            }

            // 发现当前区间最小值 交换
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }

        }
        return arr;
    }


    public static void main(String[] args) {
        _02_selection_sort instance = new _02_selection_sort();

        int[] sourceArray = new int[] {2,4,5,1,7,3};

        int[] arr = instance.sort(sourceArray);

        System.out.println(Arrays.toString(arr));

    }


}
