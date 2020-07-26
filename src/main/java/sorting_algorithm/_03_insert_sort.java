package sorting_algorithm;

import java.util.Arrays;

/**
 * @author Richard.Zhan
 * @Description: insert sort
 * 插入排序
 *
 * 优化算法 半插入排序
 * @date 2020/7/26 15:37
 */
public class _03_insert_sort {


    public int[] sort(int[] sourceArray) {

        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);


        // 初始有序区间[0,0] 无序区间[1,arr.length]
        for (int i = 1; i < arr.length; i++) {

            // 无序集合第一位，待插入的数据
            int temp = arr[i];

            int j = i;
            // 比较有序区间区间[0,i] 范围递减
            // 有序集合位置右移
            // 记录待插入位置下标
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            if (j != i) {
                arr[j] = temp;
            }
        }
        return arr;
    }


    public static void main(String[] args) {

        _03_insert_sort instance = new _03_insert_sort();

        int[] sourceArray = new int[] {2,4,5,1,7,3};

        int[] arr = instance.sort(sourceArray);

        System.out.println(Arrays.toString(arr));
    }


}
