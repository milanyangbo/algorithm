package MapAndSet;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/ https://leetcode-cn.com/problems/3sum/
 */
public class NumberSum {
    public static void main(String[] args) {
        twoSum(new int[]{3, 2, 4}, 6);
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int element = target - nums[i];
            if (map.containsKey(element) && map.get(element) != i) {
                return new int[]{i, map.get(element)};
            }
        }

        throw new IllegalArgumentException(" no two sum");
    }

    public int[] threeSum(int[] nums, int target) {
        return null;
    }
}
