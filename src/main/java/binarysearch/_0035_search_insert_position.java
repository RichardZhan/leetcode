package binarysearch;

/**
 * @author Richard.Zhan
 * @Description: leetcode 35 search insert position
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index
 * where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 *
 * Input: [1,3,5,6], 0
 * Output: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/5/27 18:29
 */
public class _0035_search_insert_position {

    int binarySearch(int[] nums,int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (target > nums[nums.length - 1]){
            return nums.length;
        }

        int left = 0;
        int right = nums.length -1;

        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        _0035_search_insert_position instance = new _0035_search_insert_position();

        int[] nums = new int[]{0,2,3,5,6,8};
        int target = -2;
        int result = -1;
        result = instance.binarySearch(nums,target);
        System.out.println(result);
    }

}
