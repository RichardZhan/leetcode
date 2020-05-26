package binarysearch;

/**
 * @author Richard.Zhan
 * @Description: 寻找一个数
 * 基本的二分搜索
 * @date 2020/5/26 13:52
 */
public class _base_binary_search {


    /**
     * @Description: 寻找一个数
     * - 搜索区间 [l,r]
     * - 终止条件 num[mid] == target
     * - left = mid + 1,right = mid - 1;
     * - 缺陷 边界
     * @Author: Richard
     * @Date: 2020/5/26 14:20
     */
    int binarySearch(int[] nums,int target) {
        int left = 0;
        int right = nums.length - 1;

        // 闭区间[l,r]
        while (left <= right){
            int mid = left + (right - left) / 2;
            System.out.println(mid);
            // 终止
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * @Description: 寻找左侧边界的二分搜索
     * - 搜索区间 [l,r)
     * - 终止条件 left >= right
     * - left > right target 大于所有
     * - 关键 if (num[mid] == target) right = mid; 用于缩小搜索区间 右边界 right,不断向左搜索
     *
     *
     * - 调整right = nums.length - 1,搜索区间为 [l,f]
     * @Author: Richard
     * @Date: 2020/5/26 14:22
     */
    int left_bound(int[] nums,int target) {

        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length;

        while (left < right){
            int mid = (left + right) /2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid;
            }
        }

        // target 大于所有
        if (left == nums.length) {
            return -1;
        }
        // 同上处理 大于所有
        return nums[left] == target ? left : -1;
    }


    /**
     * @Description: 左侧边界二分搜索
     * 搜索区间 [l,f]
     * @Author: Richard
     * @Date: 2020/5/26 14:57
     */
    int left_bound_2(int[] nums,int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) /2;
            if (nums[mid] == target){
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid -1;
            }
        }

        // 检查出界问题
        if (left >= nums.length || nums[left] != target){
            return -1;
        }
        return left;
    }

    /**
     * @Description: 右侧边界二分搜索
     * @Author: Richard
     * @Date: 2020/5/26 15:00
     */
    int right_bound(int[] nums,int target) {
        if (nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        if (left == 0) {
            return -1;
        }


        return nums[left - 1] == target ? (left - 1) : -1;
    }

    /**
     * @Description: 右侧编辑二分搜索
     * @Author: Richard
     * @Date: 2020/5/26 15:15
     */
    int right_bound_2(int[] nums,int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length + 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        if (right < 0 || nums[right] != target) {
            return  -1;
        }
        return right;
    }


    public static void main(String[] args) {
        _base_binary_search instance = new _base_binary_search();
        int[] nums = new int[]{1,2,3,4,5,6};
        int target = 5;
        // 基本二分搜索
        int result = instance.binarySearch(nums,target);
        System.out.println(result);


        System.out.println("----------------");
        //左侧边界二分搜索 区间[l,f)
        nums = new int[]{1,2,2,3,4};
        target  = 5;
        result = instance.left_bound(nums,target);
        System.out.println(result);

        System.out.println("----------------");
        //左侧边界二分搜索 区间[l,f)
        nums = new int[]{1,2,2,3,4};
        target  = 2;
        result = instance.left_bound_2(nums,target);
        System.out.println(result);


        System.out.println("----------------");
        //左侧边界二分搜索 区间[l,f)
        nums = new int[]{1,2,2,3,4};
        target  = 2;
        result = instance.right_bound(nums,target);
        System.out.println(result);

        System.out.println("----------------");
        //左侧边界二分搜索 区间[l,f)
        nums = new int[]{1,2,2,3,4};
        target  = 0;
        result = instance.right_bound_2(nums,target);
        System.out.println(result);
    }

}
