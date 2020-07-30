package sorting_algorithm;

import java.util.Arrays;

/**
 * @author Richard.Zhan
 * @Description: heap sort
 * 堆排序
 *
 *
 * @date 2020/7/30 15:26
 */
public class _07_heap_sort {

    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);

        int len = arr.length;

        buildMaxHeap(arr,len);

        for (int i = len - 1; i > 0; i--) {
            swap(arr,0,i);
            len --;
            heapify(arr,0,len);
        }

        return arr;
    }

    /**
     * 构建 堆
     * @param arr
     * @param len
     */
    private void buildMaxHeap(int[] arr, int len) {
        int i = (int) Math.floor(len / 2);
        for (; i >= 0 ; i--) {
            heapify(arr,i,len);
        }
    }

    /**
     * 堆积 堆化
     * @param arr
     * @param i
     * @param len
     */
    private void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr,i,largest);
            heapify(arr,largest,len);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        _07_heap_sort instance = new _07_heap_sort();

        int[] sourceArray = new int[] {2,4,5,1,7,3,8,9,6};

        int[] arr = instance.sort(sourceArray);

        System.out.println(Arrays.toString(arr));
    }

}
