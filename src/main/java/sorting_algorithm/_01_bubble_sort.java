package sorting_algorithm;

import java.util.Arrays;

/**
 * @author Richard.Zhan
 * @Description: 冒泡排序
 * bubble sort
 * @date 2020/7/25 22:23
 */
public class _01_bubble_sort {


    /**
     * 恭喜！发现隐藏任务！那么Arrays.sort使用的是什么排序算法？”
     * 答：归并、快排、插入都有可能。
     * “恭喜！要素解锁！请你实现快排和归并排序，并说说他们有什么异同。”
     * 答：。。。
     * @param sourceArray
     * @return
     * @throws Exception
     */
    public int[] sort (int[] sourceArray) throws Exception {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 1; i < arr.length; i++) {
            // 当一趟序列遍历中元素没有发生交换则说明该序列已经有序
            boolean flag = true;

            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {

                    // 字符替换 ^ 异或
//                    arr[j] = arr[j]^arr[j + 1];
//                    arr[j + 1] = arr[j]^arr[j + 1];
//                    arr[j] = arr[j]^arr[j + 1];
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    flag = false;
                }
            }

            // 集合已全部有序排序
            if (flag) {
                break;
            }
        }
        return arr;
    }


    public static void main(String[] args) throws Exception{
        _01_bubble_sort instance = new _01_bubble_sort();

        int[] sourceArray = new int[] {2,4,5,1,7,3};

        int[] arr = instance.sort(sourceArray);

        System.out.println(Arrays.toString(arr));


    }





}
