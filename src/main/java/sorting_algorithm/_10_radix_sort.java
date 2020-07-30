package sorting_algorithm;

import java.util.Arrays;

/**
 * @author Richard.Zhan
 * @Description: radix sort
 * 基数排序
 *
 * 原理：
 * 将整数按位数切割成不同的数字，然后按每个位数分别比较
 * 整数也可以表达字符串（名字或日期）和特定格式的浮点数
 *
 *
 * 基数排序 计数排序 桶排序
 *
 * 都利用了桶的概念
 * - 基数排序：根据键值的每位数字类分配桶
 * - 计数排序：每个桶只存储单一键值
 * - 桶排序： 每个桶存储一定范围的数值
 *
 * @date 2020/7/30 17:29
 */
public class _10_radix_sort {

    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);

        int maxDigit = getMaxDigit(arr);
        return radixSort(arr,maxDigit);
    }

    private int[] radixSort(int[] arr, int maxDigit) {
        int mod = 10;
        int dev = 1;

        for (int i = 0;i < maxDigit;i++,dev *= 10,mod *= 10) {
            int[][] counter = new int[mod * 2][0];

            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j] % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket],arr[j]);
            }
            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }
        }
        return arr;
    }

    /**
     * 自动扩容，并保存数据
     * @param arr
     * @param value
     * @return
     */
    private int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr,arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }


    /**
     * 获取最高位数
     * @param arr
     * @return
     */
    private int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumLength(maxValue);
    }

    /**
     * 获取数据长度
     * @param num
     * @return
     */
    private int getNumLength(long num) {
        if (num == 0){
            return 1;
        }
        int length = 0;
        for (long temp = num;temp != 0;temp /= 10) {
            length++;
        }
        return length;
    }

    private int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        _10_radix_sort instance = new _10_radix_sort();
        int[] sourceArray = new int[] {2,4,5,1,7,3,8,9,6,100};

        int[] arr = instance.sort(sourceArray);

        System.out.println(Arrays.toString(arr));
    }

}
