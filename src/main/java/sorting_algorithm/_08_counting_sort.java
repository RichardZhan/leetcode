package sorting_algorithm;

import java.util.Arrays;

/**
 * @author Richard.Zhan
 * @Description: counting sort
 * 计数排序
 *
 * 要求：输入的数据必须是有确定范围的整数
 * @date 2020/7/30 16:06
 */
public class _08_counting_sort {

    public int[] sort (int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);

        int maxValue = getMaxValue(arr);

        return countingSort(arr,maxValue);
    }

    /**
     * 计数排序
     *
     * @param arr
     * @param maxValue
     * @return
     */
    private int[] countingSort(int[] arr, int maxValue) {
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];

        for (int value : arr) {
            bucket[value] ++;
        }

        int sortedIndex = 0;
        for (int j = 0;j < bucketLen; j++){
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
        return arr;
    }

    /**
     * 获取最大值
     *
     * @param arr
     * @return
     */
    private int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }


    public static void main(String[] args) {
        _08_counting_sort instance = new _08_counting_sort();

        int[] sourceArray = new int[] {2,4,5,1,7,3,8,9,6,100};

        int[] arr = instance.sort(sourceArray);

        System.out.println(Arrays.toString(arr));


    }

}
