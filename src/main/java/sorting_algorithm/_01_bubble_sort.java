package sorting_algorithm;

import java.util.Arrays;

/**
 * @author Richard.Zhan
 * @Description: 冒泡排序
 * bubble sort
 * @date 2020/7/25 22:23
 */
public class _01_bubble_sort {



    public int[] sort (int[] sourceArray) throws Exception {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 1; i < arr.length; i++) {
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
