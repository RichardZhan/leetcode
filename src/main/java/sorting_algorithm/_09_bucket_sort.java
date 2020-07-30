package sorting_algorithm;

import java.util.Arrays;

/**
 * @author Richard.Zhan
 * @Description: bucket sort
 * 桶排序
 *
 * 计数排序的升级版
 *
 * @date 2020/7/30 17:13
 */
public class _09_bucket_sort {

    private static final _03_insert_sort INSERT_SORT = new _03_insert_sort();

    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);
        
        return bucketSort(arr,5);
    }

    private int[] bucketSort(int[] arr, int bucketSize) {
        if (arr.length == 0) {
            return arr;
        }

        int minValue = arr[0];
        int maxValue = arr[0];

        for (int value : arr) {
            if (value < minValue){
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }

        int bucketCount = (int) (Math.floor(maxValue - minValue) / bucketSize + 1);
        int[][] buckets = new int[bucketCount][0];

        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((arr[i] - minValue) / bucketSize);
            buckets[index] = arrAppend(buckets[index],arr[i]);
        }

        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            bucket = INSERT_SORT.sort(bucket);
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }

        return arr;
    }


    /**
     *  自动扩容，并保存数据
     * @param arr
     * @param value
     * @return
     */
    private int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr,arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }


    public static void main(String[] args) {
        _09_bucket_sort instance = new _09_bucket_sort();

        int[] sourceArray = new int[] {2,4,5,1,7,3,8,9,6,100};

        int[] arr = instance.sort(sourceArray);

        System.out.println(Arrays.toString(arr));

    }


}
