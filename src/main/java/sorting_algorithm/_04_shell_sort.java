package sorting_algorithm;

import java.util.Arrays;

/**
 * @author Richard.Zhan
 * @Description: shell sort
 * 希尔排序
 * 递减增量排序算法，是插入排序的一种更高级的改进版本
 *
 * 非稳定排序
 * @date 2020/7/26 15:51
 */
public class _04_shell_sort {


    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);

        int gap = 1;

        System.out.println("arr.length:" + arr.length);
        // 计算区间范围
        while (gap < arr.length / 3){
            gap = gap * 3 + 1;
            System.out.println( "gap:" + gap);
        }

        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = temp;
            }
            gap = (int) Math.floor(gap / 3);
            System.out.println("Math.floor(gap / 3):" + gap);
        }


        return arr;
    }


    public static void main(String[] args) {
        _04_shell_sort instance = new _04_shell_sort();

        int[] sourceArray = new int[] {2,4,5,1,7,3};

        int[] arr = instance.sort(sourceArray);

        System.out.println(Arrays.toString(arr));
    }

}
