package com.yzg.test;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.net.Ipv4Util;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.yzg.jianzhioffer.TreeNode;
import com.yzg.leetcode.ListNode;

import java.awt.image.RescaleOp;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

/**
 * @author yzg
 * @create 2019/8/2
 */

public class Main {


    static char[] dist = new char[]{'0', '1', '2', '3', '4', '5', '6', '7'};
    int pick = 1702766719;

    public int findMinDifference(List<String> timePoints) {

        List<Integer> minutes = timePoints.stream()
                .map(e -> {
                    String[] timeSplit = e.split(":");
                    return Integer.parseInt(timeSplit[0]) * 60
                            + Integer.parseInt(timeSplit[1]);
                }).sorted()
                .collect(Collectors.toList());

        int min = Math.min(minutes.get(minutes.size() - 1) - minutes.get(0),
                minutes.get(0) + 1440 - minutes.get(minutes.size() - 1));

        for (int i = 1; i < minutes.size(); i++) {
            min = Math.min(minutes.get(i) - minutes.get(i - 1), min);
        }

        return min;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (index != null && Math.abs(i - index) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }

    /**
     * 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
     * <p>
     * 每一步，你可以从下标 i 跳到下标：
     * <p>
     * i + 1 满足：i + 1 < arr.length
     * i - 1 满足：i - 1 >= 0
     * j 满足：arr[i] == arr[j] 且 i != j
     * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
     * <p>
     * 注意：任何时候你都不能跳到数组外面。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jump-game-iv
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param arr
     * @return
     */
    public int minJumps(int[] arr) {

        //记录相同值的下标,key = nums[i],value = i
        Map<Integer, Set<Integer>> valueMap = new HashMap<>();
        //记录走过的下标
        Set<Integer> existSet = new HashSet<>();
        //添加值相同的下标
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> set = valueMap.getOrDefault(arr[i], new HashSet<>());
            set.add(i);
            valueMap.put(arr[i], set);
        }
        //下一步能走的下标
        Set<Integer> nextIdx = new HashSet<>();
        nextIdx.add(0);
        int res = -1;
        while (!nextIdx.isEmpty()) {
            res++;
            List<Integer> indexList = new ArrayList<>(nextIdx);
            nextIdx.clear();
            for (Integer index : indexList) {
                if (index == null || index == arr.length - 1) {
                    return res;
                }
                existSet.add(index);
                if (index + 1 < arr.length && !existSet.contains(index + 1)) {
                    nextIdx.add(index + 1);
                }
                if (index - 1 >= 0 && !existSet.contains(index - 1)) {
                    nextIdx.add(index - 1);
                }

                for (Integer idx : valueMap.getOrDefault(arr[index], new HashSet<>())) {
                    if (!existSet.contains(idx)) {
                        nextIdx.add(idx);
                    }
                }
                valueMap.remove(arr[index]);
            }

        }


        return res;
    }

    /**
     * 509. 斐波那契数
     * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     * <p>
     * F(0) = 0，F(1) = 1
     * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
     * 给定 n ，请计算 F(n) 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 2
     * 输出：1
     * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[] arr = new int[n + 1];
        arr[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }

    public int tribonacci(int n) {
        if (n < 2) {
            return n;
        }
        if (n == 2) {
            return 1;
        }

        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 1;

        for (int i = 3; i < n + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }

        return arr[n];
    }

    public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }

    public double knightProbability(int n, int k, int row, int column) {

        //8种可能的走法
        final int[][] dis = new int[][]{{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};
        //dp[i][row][column]=从(row, column)出发走了 i 步后仍留在棋盘上的概率
        double[][][] dp = new double[k + 1][n][n];

        for (int i = 0; i < dp.length; i++) {
            for (int x = 0; x < dp[i].length; x++) {
                for (int y = 0; y < dp[i][x].length; y++) {
                    if (i == 0) {
                        //dp[0][x][y] = 1
                        dp[i][x][y] = 1;
                    } else {
                        //dp[i][x][y] = 8个来源点的概率之和(dp[i - 1][x - disX][y - disY]) / 8
                        //累加8个方向的概率
                        for (int[] di : dis) {
                            int xi = x - di[0];
                            int yi = y - di[1];
                            //忽略从外界来的概率
                            if (xi < n && xi >= 0 && yi < n && yi >= 0) {
                                dp[i][x][y] += dp[i - 1][xi][yi] / 8d;
                            }
                        }
                    }
                }
            }
        }

        return dp[k][row][column];
    }

    public int findCenter(int[][] edges) {
        int a = edges[0][0];
        int b = edges[0][1];
        int c = edges[1][0];
        int d = edges[1][1];

        return (a == c || a == d) ? a : b;
    }

    //https://leetcode-cn.com/problems/push-dominoes/

    public int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[cost.length + 1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[dp.length - 1];
    }

    public int rob(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[dp.length - 1];
    }

    /**
     * 838. 推多米诺
     * n 张多米诺骨牌排成一行，将每张多米诺骨牌垂直竖立。在开始时，同时把一些多米诺骨牌向左或向右推。
     * <p>
     * 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
     * <p>
     * 如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时，由于受力平衡， 该骨牌仍然保持不变。
     * <p>
     * 就这个问题而言，我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。
     * <p>
     * 给你一个字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中：
     * <p>
     * dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧，
     * dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧，
     * dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌。
     * 返回表示最终状态的字符串。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：dominoes = "RR.L"
     * 输出："RR.L"
     * 解释：第一张多米诺骨牌没有给第二张施加额外的力。
     * 示例 2：
     * <p>
     * <p>
     * 输入：dominoes = ".L.R...LR..L.."
     * 输出："LL.RR.LLRRLL.."
     *
     * @param dominoes
     * @return
     */
    public String pushDominoes(String dominoes) {
        //L...R => L...R
        //L...L => LLLLL
        //R...L => RR.LL / RRLL
        //R...R => RRRRR
        char[] chars = ("L" + dominoes + "R").toCharArray();

        int l = 0, r = 0;

        while (l < chars.length - 1) {
            do {
                r++;
            } while (chars[r] == '.');

            if (chars[l] == 'L') {
                if (chars[r] == 'L') {
                    //L...L => LLLLL
                    while (++l < r) {
                        chars[l] = 'L';
                    }
                }
                //L...R => L...R
            } else if (chars[l] == 'R') {
                if (chars[r] == 'L') {
                    //R...L => RR.LL / RRLL
                    int rr = r;
                    while (++l < --rr) {
                        chars[l] = 'R';
                        chars[rr] = 'L';
                    }
                } else if (chars[r] == 'R') {
                    //R...R => RRRRR
                    while (++l < r) {
                        chars[l] = 'R';
                    }
                }
            }
            l = r;
        }

        return String.valueOf(chars, 1, chars.length - 2);
    }

    /**
     * 55. 跳跃游戏
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 判断你是否能够到达最后一个下标。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * 示例 2：
     * <p>
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 3 * 104
     * 0 <= nums[i] <= 105
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {

        if (nums[0] == 0 && nums.length > 1) {
            return false;
        }
        //dp[i] = 下标位于i的最大可跳跃长度（包括从i - n 跳跃过来的）
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
            if (dp[i] == 0) {//中途存在最大可跳跃长度为 0无法到达最后一个下标
                return false;
            }
        }

        return true;
    }

    /**
     * 45. 跳跃游戏 II
     * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * <p>
     * 假设你总是可以到达数组的最后一个位置。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     * 示例 2:
     * <p>
     * 输入: nums = [2,3,0,1,4]
     * 输出: 2
     * <p>
     * <p>
     * 提示:
     * <p>
     * 1 <= nums.length <= 104
     * 0 <= nums[i] <= 1000
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int i = 0;
        int jumpNum = 0;

        while (i < nums.length - 1) {
            int num = nums[i];
            if (num + i > nums.length - 2) {
                i = nums.length - 1;
            } else {
                int max = 0;
                int next = i;
                for (int j = 1; j <= num; j++) {
                    if (nums[j + i] + j >= max) {
                        max = nums[j + i] + j;
                        next = j + i;
                    }
                }
                i = next;
            }
            jumpNum++;
        }

        return jumpNum;
    }

    public int deleteAndEarn(int[] nums) {
        int[] arr = new int[10001];
        for (int num : nums) {
            arr[num] += num;
        }

        for (int i = 2; i < arr.length; i++) {
            arr[i] = Math.max(arr[i - 1], arr[i - 2] + arr[i]);
        }

        return arr[arr.length - 1];
    }

    public int maxSubArray(int[] nums) {
        //dp[i]表示 i 结尾的最大 连续子数组之和
        //        int[] dp = new int[nums.length];
        //        dp[0] = nums[0];

        int pre = nums[0];
        int max = pre;
        for (int i = 1; i < nums.length; i++) {
            //子数组连续 / 新子数组
            pre = Math.max(pre + nums[i], nums[i]);

            max = Math.max(pre, max);
        }

        return max;
    }

    public int maxSubarraySumCircular(int[] nums) {
        int pre = nums[0];
        int max = pre;
        for (int i = 1; i < nums.length; i++) {
            //子数组连续 / 新子数组
            pre = Math.max(pre + nums[i], nums[i]);

            max = Math.max(pre, max);
        }

        int[] dp = Arrays.copyOf(nums, nums.length * 2 - 1);
        System.arraycopy(nums, 0, dp, nums.length, nums.length - 1);

        pre = dp[0];
        int max2 = pre;
        int start = 0;
        int len = 1;
        for (int i = 1; i < dp.length; i++) {
            int cur = pre + dp[i];
            if (len > nums.length) {

            }
            if (cur > dp[i]) {
                pre = pre + dp[i];
                len++;
            } else {
                pre = dp[i];
                start = i;
                len = 1;
            }

            max2 = Math.max(pre, max2);
        }

        return Math.max(max2, max);
    }

    /**
     * 1601. 最多可达成的换楼请求数目
     * 我们有 n 栋楼，编号从 0 到 n - 1 。每栋楼有若干员工。由于现在是换楼的季节，部分员工想要换一栋楼居住。
     * <p>
     * 给你一个数组 requests ，其中 requests[i] = [fromi, toi] ，表示一个员工请求从编号为 fromi 的楼搬到编号为 toi 的楼。
     * <p>
     * 一开始 所有楼都是满的，所以从请求列表中选出的若干个请求是可行的需要满足 每栋楼员工净变化为 0 。意思是每栋楼 离开 的员工数目 等于 该楼 搬入 的员工数数目。比方说 n = 3 且两个员工要离开楼 0 ，一个员工要离开楼 1 ，一个员工要离开楼 2 ，如果该请求列表可行，应该要有两个员工搬入楼 0 ，一个员工搬入楼 1 ，一个员工搬入楼 2 。
     * <p>
     * 请你从原请求列表中选出若干个请求，使得它们是一个可行的请求列表，并返回所有可行列表中最大请求数目。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：n = 5, requests = [[0,1],[1,0],[0,1],[1,2],[2,0],[3,4]]
     * 输出：5
     * 解释：请求列表如下：
     * 从楼 0 离开的员工为 x 和 y ，且他们都想要搬到楼 1 。
     * 从楼 1 离开的员工为 a 和 b ，且他们分别想要搬到楼 2 和 0 。
     * 从楼 2 离开的员工为 z ，且他想要搬到楼 0 。
     * 从楼 3 离开的员工为 c ，且他想要搬到楼 4 。
     * 没有员工从楼 4 离开。
     * 我们可以让 x 和 b 交换他们的楼，以满足他们的请求。
     * 我们可以让 y，a 和 z 三人在三栋楼间交换位置，满足他们的要求。
     * 所以最多可以满足 5 个请求。
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：n = 3, requests = [[0,0],[1,2],[2,1]]
     * 输出：3
     * 解释：请求列表如下：
     * 从楼 0 离开的员工为 x ，且他想要回到原来的楼 0 。
     * 从楼 1 离开的员工为 y ，且他想要搬到楼 2 。
     * 从楼 2 离开的员工为 z ，且他想要搬到楼 1 。
     * 我们可以满足所有的请求。
     * 示例 3：
     * <p>
     * 输入：n = 4, requests = [[0,3],[3,1],[1,2],[2,0]]
     * 输出：4
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= n <= 20
     * 1 <= requests.length <= 16
     * requests[i].length == 2
     * 0 <= fromi, toi < n
     *
     * @param n
     * @param requests
     * @return
     */
    public int maximumRequests(int n, int[][] requests) {
        //子集个数
        int maxNum = (int) Math.pow(2, requests.length);
        //满足条件的最大值
        int maximum = 0;
        //遍历所有子集
        for (int k = maxNum - 1; k >= 0; k--) {
            //将2进制数中 位 = 1 的位置对应的数组元素加入到子集中。
            int m = k;
            int i = 0;
            List<int[]> list = new ArrayList<>();
            if (Integer.bitCount(m) < maximum) {
                continue;
            }
            while (m != 0) {
                if (m % 2 != 0) {
                    list.add(requests[i]);
                }
                m = m / 2;
                i++;
            }
            //校验子集是否满足条件
            int[] arr = new int[n];
            for (int[] req : list) {
                arr[req[0]]--;
                arr[req[1]]++;
            }
            boolean res = true;
            for (int ai : arr) {
                if (ai != 0) {
                    res = false;
                    break;
                }
            }

            if (res) {
                maximum = Math.max(maximum, list.size());
            }
        }

        return maximum;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //子集个数
        int maxNum = (int) Math.pow(2, nums.length);

        for (int n = 0; n < maxNum; n++) {
            //将2进制数中 位 = 1 的位置对应的数组元素加入到子集中。
            int m = n;
            int i = 0;
            List<Integer> list = new ArrayList<>();
            while (m != 0) {
                if (m % 2 != 0) {
                    list.add(nums[i]);
                }
                m = m / 2;
                i++;
            }
            res.add(list);
        }


        return res;
    }

    /**
     * 152. 乘积最大子数组
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     * <p>
     * 测试用例的答案是一个 32-位 整数。
     * <p>
     * 子数组 是数组的连续子序列。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * 示例 2:
     * <p>
     * 输入: nums = [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     * <p>
     * <p>
     * 提示:
     * <p>
     * 1 <= nums.length <= 2 * 104
     * -10 <= nums[i] <= 10
     * nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {

        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];

        int res = nums[0];

        for (int i = 1; i < dpMax.length; i++) {
            dpMax[i] = Math.max(Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]), nums[i]);
            dpMin[i] = Math.min(Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]), nums[i]);
            res = Math.max(res, dpMax[i]);
        }

        return res;
    }

    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        //每个周期占用的元素个数
        int t = 2 * numRows - 2;
        //每个周期占用的矩阵长度
        int l = numRows - 1;
        //整个字符串占用的矩阵长度
        int c = (s.length() / t + 1) * l;

        char[][] matrix = new char[numRows][c];

        setMatrix(matrix, s, numRows, 0, 0, 0);

        StringBuilder builder = new StringBuilder();
        for (char[] chars : matrix) {
            for (char cha : chars) {
                if (cha != 0) {
                    builder.append(cha);
                }
            }
        }

        return builder.toString();
    }

    private void setMatrix(char[][] matrix, String s, int numRows, int i, int row, int col) {
        if (i >= s.length() || row >= matrix.length || col >= matrix[row].length) {
            return;
        }
        matrix[row][col] = s.charAt(i);
        if (col % (numRows - 1) == 0) {
            //往下或者往右上角走
            if (row < numRows - 1) {
                //往下
                row++;
            } else {
                //往右上
                col++;
                row--;
            }
        } else {
            //往右上角走
            row--;
            col++;
        }
        setMatrix(matrix, s, numRows, i + 1, row, col);
    }

    public int getMaxLen(int[] nums) {
        //最长子数组长度
        int res = 0;
        //2个0之间的第一个负数
        int first = -1;
        //2个0之间的最后一个负数
        int last = -1;
        //2个0之间的和是否是正数
        boolean post = true;
        int start = 0;
        for (int i = 0; i <= nums.length; i++) {
            if (i == nums.length || nums[i] == 0) {
                if (post) {//和是正数
                    res = Math.max(res, i - start);
                } else {
                    //和为负数,判断第一个负数和最后一个负数到 2边的距离
                    res = Math.max(res, Math.max(i - first - 1, last - start));
                }
                post = true;
                start = i + 1;
                first = -1;
                last = -1;
            } else if (nums[i] < 0) {
                post = !post;
                last = i;
                if (first == -1) {
                    first = i;
                }
            }
        }

        return res;
    }

    public String nearestPalindromic(String n) {


        long l = Long.parseLong(n);
        if (n.length() == 1) {
            return String.valueOf(l - 1);
        }


        long res = 0;
        long minDiff = Long.MAX_VALUE;
        boolean even = n.length() % 2 == 0;
        int i = even ? n.length() / 2 : n.length() / 2 + 1;

        String preStr = n.substring(0, i);
        long pre = Long.parseLong(preStr);

        String numStr = getStr(even, preStr);
        long number = Long.parseLong(numStr);
        long diff = Math.abs(l - number);
        if (number != l) {
            if (diff < minDiff) {
                res = number;
                minDiff = diff;
            } else if (diff == minDiff) {
                res = Math.min(res, number);
            }

        }

        long preAdd = pre + 1;
        if (String.valueOf(preAdd).length() > preStr.length()) {
            //99, 100 => 10, !even
            if (even) {
                even = false;
            } else {
                preAdd /= 10;
                even = true;
            }

        }
        numStr = getStr(even, String.valueOf(preAdd));
        number = Long.parseLong(numStr);
        diff = Math.abs(l - number);
        if (number != l) {
            if (diff < minDiff) {
                res = number;
                minDiff = diff;
            } else if (diff == minDiff) {
                res = Math.min(res, number);
            }

        }

        long preReduce = pre - 1;
        if (String.valueOf(preReduce).length() < preStr.length()) {
            //100, 99 => 999, !even
            if (even) {
                preReduce = preReduce * 10 + 9;
                even = false;
            } else {
                even = true;
            }

        }

        numStr = getStr(even, String.valueOf(preReduce));
        if (preReduce == 0) {
            number = 9;
        } else {
            number = Long.parseLong(numStr);
        }
        diff = Math.abs(l - number);
        if (number != l) {
            if (diff < minDiff) {
                res = number;
                minDiff = diff;
            } else if (diff == minDiff) {
                res = Math.min(res, number);
            }

        }

        return String.valueOf(res);
    }

    private String getStr(boolean even, String preStr) {
        return preStr + (even ? new StringBuilder(preStr).reverse() :
                new StringBuilder(preStr.substring(0, preStr.length() - 1)).reverse());
    }

    public int addDigits(int num) {
        String s = String.valueOf(num);

        while (s.length() > 1) {
            num = 0;
            for (char c : s.toCharArray()) {
                num += c - 48;
            }
            s = String.valueOf(num);
        }

        return Integer.parseInt(s);
    }

    public int maxScoreSightseeingPair(int[] values) {

        //(values[i] + i) + (values[j]- j)
        int res = 0;
        int maxI = 0;
        for (int i = 1; i < values.length; i++) {
            maxI = Math.max(maxI, values[i - 1] + i - 1);
            res = Math.max(res, maxI + values[i] - i);
        }

        return res;
    }

    public String convertToBase7(int num) {
        int radix = 7;
        //多一位缓存正负号
        char[] buf = new char[33];
        //负数
        boolean negative = num < 0;
        int charIndex = 32;
        //负数计算防止 最大正数溢出
        if (!negative) {
            num = -num;
        }

        while (num <= -radix) {
            buf[charIndex--] = dist[-(num % radix)];
            num = num / radix;
        }
        //第一个数字
        buf[charIndex] = dist[-num];
        if (negative) {
            buf[--charIndex] = '-';
        }

        return new String(buf, charIndex, 33 - charIndex);
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] chars = s.toCharArray();
        //candles[i]表示从chars[0]到chars[i]（包括） 共有多少个 *
        int[] candles = new int[chars.length];
        candles[0] = chars[0] == '*' ? 1 : 0;
        //left[i] = n，表示 n <= i，满足 chars[n] = '|' 的最大值
        int[] left = new int[chars.length];
        left[0] = chars[0] == '|' ? 0 : -1;

        for (int i = 1; i < candles.length; i++) {
            if (chars[i] == '*') {
                candles[i] = candles[i - 1] + 1;
                left[i] = left[i - 1];
            } else {
                candles[i] = candles[i - 1];
                left[i] = i;
            }

        }
        //right[i] = n,表示 n >= i, 满足 chars[n] = '|' 的最小值
        int[] right = new int[chars.length];
        right[chars.length - 1] = chars[chars.length - 1] == '|' ? 0 : -1;
        for (int i = right.length - 2; i >= 0; i--) {
            if (chars[i] == '|') {
                right[i] = i;
            } else {
                right[i] = right[i + 1];
            }

        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] que = queries[i];
            int l = right[que[0]];
            int r = left[que[1]];
            if (l == -1 || r == -1 || l >= r) {
                result[i] = 0;
            } else {
                result[i] = candles[r] - candles[l];
            }
        }

        return result;
    }

    /**
     * 374. 猜数字大小
     * 猜数字游戏的规则如下：
     * <p>
     * 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
     * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
     * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
     * <p>
     * -1：我选出的数字比你猜的数字小 pick < num
     * 1：我选出的数字比你猜的数字大 pick > num
     * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
     *
     * @param n
     * @return
     */
    public int guessNumber(int n) {

        int res = n;
        int compare;
        while ((compare = guess(res)) != 0) {
            if (compare > 0) {
                res = (res + n) >>> 1;
            } else {
                n = res;
                res = res >> 1;
            }
        }

        return res;
    }

    private int guess(int n) {
        return Integer.compare(pick, n);
    }

    public int arrangeCoins(int n) {
        return 0;
    }

    private int sum(int n) {
        return n + (n * (n - 1)) >>> 1;
    }

    public int[] kWeakestRows(int[][] mat, int k) {

        int[] arr = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            int[] rows = mat[i];
            arr[i] = (findLast(rows) + 1) * 100 + i;
        }
        Arrays.sort(arr);
        return Arrays.stream(Arrays.copyOf(arr, k))
                .mapToLong(e -> e % 100)
                .mapToInt(e -> (int) e)
                .toArray();
    }

    /**
     * @param rows [1,1,1,0,0,0]
     * @return 2
     */
    private int findLast(int[] rows) {
        if (rows[0] == 0) {
            return -1;
        }
        if (rows[rows.length - 1] == 1) {
            return rows.length - 1;
        }
        int l = 0;
        int r = rows.length;
        while (l < r) {
            int mid = (l + r + 1) >>> 1;
            if (rows[mid] == 0) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }

        return l;
    }

    //[40,60],[50,50]
    //[40,59,60,61], 85, 115

    public int findKthLargest(int[] nums, int k) {

        quickSort(nums, 0, nums.length - 1);

        return nums[nums.length - k];
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int[] par = partition(nums, l, r);
            quickSort(nums, l, par[0]);
            quickSort(nums, par[1], r);
        }
    }

    private int[] partition(int[] nums, int l, int r) {
        //arr[r]作为快排基准数
        //随机基准数
        swap(nums, r, l + (int) (Math.random() * (r - l + 1)));
        int less = l - 1;
        int more = r;
        //3,2,1,5,6,4,4
        //3,2,1,4,6,5,4
        //3,2,1,4,6,5,4 => [3,2,1] [4] [6,5,4]

        while (l < more) {
            if (nums[l] < nums[r]) {
                swap(nums, ++less, l++);
            } else if (nums[l] > nums[r]) {
                swap(nums, --more, l);
            } else {
                l++;
            }
        }
        swap(nums, r, more);


        return new int[]{less, more};

    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 165. 比较版本号
     * 给你两个版本号 version1 和 version2 ，请你比较它们。
     *
     * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
     *
     * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
     *
     * 返回规则如下：
     *
     * 如果 version1 > version2 返回 1，
     * 如果 version1 < version2 返回 -1，
     * 除此之外返回 0。
     *
     *
     * 示例 1：
     *
     * 输入：version1 = "1.01", version2 = "1.001"
     * 输出：0
     * 解释：忽略前导零，"01" 和 "001" 都表示相同的整数 "1"
     * 示例 2：
     *
     * 输入：version1 = "1.0", version2 = "1.0.0"
     * 输出：0
     * 解释：version1 没有指定下标为 2 的修订号，即视为 "0"
     * 示例 3：
     *
     * 输入：version1 = "0.1", version2 = "1.1"
     * 输出：-1
     * 解释：version1 中下标为 0 的修订号是 "0"，version2 中下标为 0 的修订号是 "1" 。0 < 1，所以 version1 < version2
     *
     *
     * 提示：
     *
     * 1 <= version1.length, version2.length <= 500
     * version1 和 version2 仅包含数字和 '.'
     * version1 和 version2 都是 有效版本号
     * version1 和 version2 的所有修订号都可以存储在 32 位整数 中
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        //version1 = "1.01", version2 = "1.001"
        //version1 = "1.0", version2 = "1.0.0"
        //version1 = "0.1", version2 = "1.1"

//        String[] arr1 = version1.split("\\.");
//        String[] arr2 = version2.split("\\.");
        int i1 = 0, i2 = 0;
        int value1, value2;

        while (i1 < version1.length() || i2 < version2.length()) {
            int start = i1;
            if (i1 < version1.length()) {
                while (i1 < version1.length() && version1.charAt(i1) != '.') {
                    i1++;
                }
                value1 = Integer.parseInt(version1.substring(start, i1));
            } else {
                value1 = 0;
            }
            start = i2;
            if (i2 < version2.length()) {
                while (i2 < version2.length() && version2.charAt(i2) != '.') {
                    i2++;
                }
                value2 = Integer.parseInt(version2.substring(start, i2));
            } else {
                value2 = 0;
            }
            if (value1 > value2) {
                return 1;
            } else if (value1 < value2) {
                return -1;
            }
            i1++;
            i2++;
        }

//        while (i1 < arr1.length|| i2 < arr2.length) {
//            if (i1 < arr1.length){
//                value1 = Integer.parseInt(arr1[i1]);
//            } else {
//                value1 = 0;
//            }
//
//            if (i2 < arr2.length) {
//                value2 = Integer.parseInt(arr2[i2]);
//            } else {
//                value2 = 0;
//            }
//
//            if (value1 > value2) {
//                return 1;
//            } else if (value1 < value2) {
//                return -1;
//            }
//            i1++;
//            i2++;
//        }

        return 0;
    }

    private String getString(String s1) {
        int i = s1.lastIndexOf("0");
        if (i != -1) {
            s1 = s1.substring(i);
        }
        return s1;
    }



    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if (list1 != null) {
            cur.next = list1;
        } else {
            cur.next = list2;
        }

        return head.next;

    }


    /**
     * 102. 二叉树的层序遍历
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
     *
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //队列缓存每层的节点
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            int size = queue.size();
            //从队列出取出当前层所有的节点
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                row.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(row);
        }

        return res;
    }

    /**
     * 141. 环形链表
     * 给你一个链表的头节点 head ，判断链表中是否有环。
     *
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
     *
     * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     * 示例 2：
     *
     *
     *
     * 输入：head = [1,2], pos = 0
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     * 示例 3：
     *
     *
     *
     * 输入：head = [1], pos = -1
     * 输出：false
     * 解释：链表中没有环。
     *
     *
     * 提示：
     *
     * 链表中节点的数目范围是 [0, 104]
     * -105 <= Node.val <= 105
     * pos 为 -1 或者链表中的一个 有效索引 。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        Set<ListNode> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }

        return false;
    }

    /**
     * 121. 买卖股票的最佳时机
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     *
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     *
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * 示例 2：
     *
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     *
     * 提示：
     *
     * 1 <= prices.length <= 105
     * 0 <= prices[i] <= 104
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return max;
    }

    /**
     * 103. 二叉树的锯齿形层序遍历
     * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：[[3],[20,9],[15,7]]
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //队列缓存每层的节点
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        boolean right = true;
        while (!queue.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            int size = queue.size();
            //从队列出取出当前层所有的节点
            for (int i = 0; i < size; i++) {
                TreeNode node = right ? queue.pollFirst() : queue.pollLast();
                assert node != null;
                row.add(node.val);

                if (right) {
                    if (node.left != null) {
                        queue.addLast(node.left);

                    }
                    if (node.right != null) {
                        queue.addLast(node.right);
                    }
                } else {
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.addFirst(node.left);

                    }
                }
            }
            right = !right;
            res.add(row);
        }

        return res;
    }

    /**
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 提示：
     *
     * 1 <= s.length <= 104
     * s 仅由括号 '()[]{}' 组成
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        //遍历字符串
        //遇到左括号 入栈
        //遇到右括号 出栈，出栈元素必须是与 右括号对应 的 左括号
        Map<Character, Character> map = new HashMap<Character, Character>(){
            {
                put(')', '(');
                put('}', '{');
                put(']', '[');
            }
        };
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.empty()) {
                    return false;
                }
                if (!stack.pop().equals(map.get(c))) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.empty();
    }

    public int ipToInt(String ip) {
        String[] ipArr = ip.split("\\.");


        long aLong = Ipv4Util.ipv4ToLong(ip);

        return (int) aLong;
    }

    //
    public String reverseWWW(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (int i = s.length() - 1; i >= 0 ; i--) {
            if (s.charAt(i) == '.') {
                char[] chs = new char[stack.size() + 1];
                int j = 0;
                while (!stack.empty()) {
                    chs[j++] = stack.pop();
                }
                chs[chs.length - 1] = '.';
                res.append(chs);
            } else {
                stack.push(s.charAt(i));
            }
        }
        char[] chs = new char[stack.size()];
        int j = 0;
        while (!stack.empty()) {
            chs[j++] = stack.pop();
        }
        res.append(chs);

        return res.toString();
    }


    /**
     * 88. 合并两个有序数组
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     *
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     *
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
     * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
     * 示例 2：
     *
     * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
     * 输出：[1]
     * 解释：需要合并 [1] 和 [] 。
     * 合并结果是 [1] 。
     * 示例 3：
     *
     * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
     * 输出：[1]
     * 解释：需要合并的数组是 [] 和 [1] 。
     * 合并结果是 [1] 。
     * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
     *
     *
     * 提示：
     *
     * nums1.length == m + n
     * nums2.length == n
     * 0 <= m, n <= 200
     * 1 <= m + n <= 200
     * -109 <= nums1[i], nums2[j] <= 109
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            } else {
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            }
        }

        if (n != 0) {
            //nums2 剩下的元素排到 nums1 前面
            System.arraycopy(nums2, 0, nums1, 0, n);
        }
    }


    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length, count = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 3; i < m; i++) {
            for (int j = 8; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int num = 1;
                    count = Math.max(dfsIsland(grid, i, j, num, visited), count);
                }
            }
        }
        return count;
    }
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int dfsIsland(int[][] grid, int i1, int j1, int count, boolean[][] visited) {
        visited[i1][j1] = true;
        for (int k = 0; k < 4; k++) {
            int i = dx[k] + i1;
            int j = dy[k] + j1;
            if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1 && !visited[i][j]) {
//                visited[i][j] = true;
                count = dfsIsland(grid, i, j, count + 1, visited);
            }
        }
        return count;
    }

    public int dfsIsland2(int[][] grid, int i, int j, int count, boolean[][] visited) {
        if (i < 0 || j < 0 || i > grid.length - 1|| j > grid[i].length - 1 || visited[i][j] || grid[i][j] != 1) {
            return count;
        }
        visited[i][j] = true;
        int a1 = dfsIsland2(grid, i, j + 1, count + 1, visited);
        int a2 = dfsIsland2(grid, i, j - 1, count + 1, visited);
        int a3 = dfsIsland2(grid, i + 1, j, count + 1, visited);
        int a4 = dfsIsland2(grid, i - 1, j, count + 1, visited);

        return Math.max(a1, Math.max(a2, Math.max(a3, a4)));
    }


    /**
     * 236. 二叉树的最近公共祖先
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出：3
     * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode leftSon = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSon = lowestCommonAncestor(root.right, p, q);

        if (leftSon != null && rightSon != null)  {
            return root;
        } else if (leftSon != null) {
            return leftSon;
        } else {
            return rightSon;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {


        return null;

    }

    /**
     * 965. 单值二叉树
     * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
     *
     * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
     *
     * 给定树的节点数范围是 [1, 100]。
     * 每个节点的值都是整数，范围为 [0, 99] 。
     * @param root
     * @return
     */
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && root.left.val != root.val) {
            return false;
        }

        if (root.right != null && root.right.val != root.val) {
            return false;
        }

        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        back(nums, 0, res);

        return res;
    }

    private void back(int[] nums, int i, List<List<Integer>> res) {
        if (i == nums.length - 1) {
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }

        for (int j = i + 1; j < nums.length; j++) {
            swap(nums, i, j);
            back(nums, i + 1, res);
            swap(nums, i, j);
        }

    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        backPermuteUnique(nums, 0, res);

        return res;
    }

    private void backPermuteUnique(int[] nums, int i, List<List<Integer>> res) {


    }



    /**
     * 40. 组合总和 II
     * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的每个数字在每个组合中只能使用 一次 。
     *
     * 注意：解集不能包含重复的组合。
     *
     *
     *
     * 示例 1:
     *
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 输出:
     * [
     * [1,1,6],
     * [1,2,5],
     * [1,7],
     * [2,6]
     * ]
     * 示例 2:
     *
     * 输入: candidates = [2,5,2,1,2], target = 5,
     * 输出:
     * [
     * [1,2,2],
     * [5]
     * ]
     *
     *
     * 提示:
     *
     * 1 <= candidates.length <= 100
     * 1 <= candidates[i] <= 50
     * 1 <= target <= 30
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backCombinationSum2(0, candidates, target, 0, res);

        return res;
    }

    private void backCombinationSum2(int sum, int[] nums, int target, int i, List<List<Integer>> res) {

    }

    /**
     * 面试题 17.11. 单词距离
     * 有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
     *
     * 示例：
     *
     * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
     * 输出：1
     * 提示：
     *
     * words.length <= 100000
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int findClosest(String[] words, String word1, String word2) {

        int w1 = -1, w2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {

            if (word1.equals(words[i])) {
                w1 = i;
            } else if (word2.equals(words[i])) {
                w2 = i;
            }
            if (w1 > 0 && w2 > 0) {
                min = Math.min(min, Math.abs(w2 - w1));
            }
        }

        return min;
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        generate(res, new StringBuilder(), n, n);


        return res;
    }

    private void generate(List<String> res,StringBuilder cur, int left, int right) {

    }

    private int res = 0;
    public int sumRootToLeaf(TreeNode root) {

        dfs(root, 0);

        return res;
    }

    private void dfs(TreeNode node, int pre) {
        if(node == null) {
            return;
        }

        pre = pre * 2 + node.val;

        if (node.left == null && node.right == null) {
            res += pre;
            return;
        }

        dfs(node.left, pre);
        dfs(node.right, pre);

    }

    public static void main(String[] args) {
        Main main = new Main();

       int a = main.maxAreaOfIsland(new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}});


        System.out.println(a);
    }

}
