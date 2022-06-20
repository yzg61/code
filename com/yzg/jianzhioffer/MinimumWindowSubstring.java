package com.yzg.jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class MinimumWindowSubstring {


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 1, 3, 4, 1, 2);

        List<Integer> list2 = list.stream()
                .parallel()
                .filter(e -> !Objects.equals(e, 1))
                .collect(Collectors.toList());


        System.out.println(list2);

    }

    /**
     * 剑指 Offer II 017. 含有所有字符的最短字符串
     * 给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。
     * <p>
     * 如果 s 中存在多个符合条件的子字符串，返回任意一个。
     * <p>
     * <p>
     * <p>
     * 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * 解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C'
     * 示例 2：
     * <p>
     * 输入：s = "a", t = "a"
     * 输出："a"
     * 示例 3：
     * <p>
     * 输入：s = "a", t = "aa"
     * 输出：""
     * 解释：t 中两个字符 'a' 均应包含在 s 的子串中，因此没有符合条件的子字符串，返回空字符串。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length, t.length <= 105
     * s 和 t 由英文字母组成
     * <p>
     * <p>
     * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
     * <p>
     * <p>
     * <p>
     * 注意：本题与主站 76 题相似（本题答案不唯一）：https://leetcode-cn.com/problems/minimum-window-substring/
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {

        //s = "ADOBECODEBANC",
        //t = "ABC"
        int l = 0;
        int r = 0;
        int minL = 0;
        int minLen = 0;
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        int sLen = 0;

        for (char c : t.toCharArray()) {
            tMap.put(c, (tMap.getOrDefault(c, 0)) + 1);
        }

        while (r < s.length() && l < s.length() - t.length()) {
            char c = s.charAt(r);
            if (tMap.containsKey(c)) {
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
                if (sMap.get(c) <= tMap.get(c)) {
                    sLen++;
                }
            }
            r++;
        }

        return s.substring(minL, minL + minLen);
    }

    //https://leetcode-cn.com/problems/WGki4K/
    public int singleNumber(int[] nums) {

        Set<Integer> one = new HashSet<>(nums.length);
        Set<Integer> all = new HashSet<>(nums.length);

        for (int num : nums) {
            if (all.contains(num)) {
                one.remove(num);
            } else {
                one.add(num);
                all.add(num);
            }
        }

        return one.iterator().next();
    }

    //https://leetcode-cn.com/problems/aseY1I/
    public int maxProduct(String[] words) {

        int[] arr = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            int n = 0;
            for (char c : words[i].toCharArray()) {
                n |= (1 << (c - 'a'));
            }
            arr[i] = n;
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] & arr[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }

        return 0;
    }

    //https://leetcode-cn.com/problems/kLl5u1/
    public int[] twoSum(int[] numbers, int target) {
        //1,2,4,6,10,12,14   => 8

        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] > target) {
                r--;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                return new int[]{l, r};
            }
        }
        return null;
    }

    //https://leetcode-cn.com/problems/1fGaJU/
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        //-4,-1,-1,0,1,2,

        //第一位数字
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            //第一位数字相同，跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //双指针
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] < -nums[i]) {
                    //l++,跳过相同的l
                    l++;
                } else if (nums[l] + nums[r] > -nums[i]) {
                    r--;
                } else {
                    //res + 1;
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    //l++
                    do {
                        l++;
                    } while (l < r && nums[l] == nums[l - 1]);
                    //r--
                    do {
                        r--;
                    } while (l < r && nums[r] == nums[r + 1]);
                }
            }

        }

        return res;
    }


    //https://leetcode-cn.com/problems/minimum-size-subarray-sum/
    public int minSubArrayLen(int target, int[] nums) {
        //给定一个含有n个正整数的数组和一个正整数 target 。
        //
        //找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
        //
        //
        //来源：力扣（LeetCode）
        //链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
        //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        if (nums.length == 0) {
            return 0;
        }
        int len = nums.length + 1;
        int l = 0;
        int r = 0;
        int sum = nums[0];

        while (r < nums.length && l <= r) {
            if (sum >= target) {
                len = Math.min(len, r - l + 1);
                sum -= nums[l++];
            } else {
                r++;
                if (r < nums.length) {
                    sum += nums[r];
                }
            }
        }
        return len > nums.length ? 0 : len;
    }


    /**
     * 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [10,5,2,6], k = 100
     * 输出: 8
     * 解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
     * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
     * 示例 2:
     * <p>
     * 输入: nums = [1,2,3], k = 0
     * 输出: 0
     *  
     * <p>
     * 提示: 
     * <p>
     * 1 <= nums.length <= 3 * 104
     * 1 <= nums[i] <= 1000
     * 0 <= k <= 106
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：<a>https://leetcode-cn.com/problems/ZVAVXX<a/>
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int l = 0, r = 0, res = 0;
        int sum = nums[0];

        while (l < nums.length && r < nums.length) {
            //l越界 ，r扩大
            if (l > r) {
                sum *= nums[++r];
            }

            if (sum < k) {
                //如果nums[l, r]满足 sum < K， 则nums[l+n, r] 也满足
                //例如[5,2,6] sum = 60 < 100, 则[2，6]，[6] 也满足
                res += r - l + 1;
                if (++r < nums.length) {
                    //可以扩大
                    sum *= nums[r];
                } else {
                    //缩小
                    sum /= nums[l++];
                }
            } else {
                //不满足 sum < k，只能缩小
                sum /= nums[l++];
            }
        }

        return res;
    }


    //https://leetcode-cn.com/problems/subarray-sum-equals-k/
    public int subarraySum(int[] nums, int k) {
        //[1,1,1,1,1,1], K = 3
        int res = 0, sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }


        return res;
    }
}
